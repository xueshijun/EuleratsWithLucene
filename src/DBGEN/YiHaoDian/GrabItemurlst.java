/**
 *
 * Grabbing YHDid lists
 *
 */

/* ****** ****** */
package DBGEN.YiHaoDian;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;

/* ****** ****** */

import java.net.URL;
import java.net.URLConnection;

/* ****** ****** */

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/* ****** ****** */

import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

import DBGEN.UTILS.*;
import DBGEN.YiHaoDian.YiHaoDian;

/* ****** ****** */

class GrabItemurlst {
//
    private static String
	docGetTitle_doc (Document doc)
    {
	return doc.title();
    }
    private static String
	YHDurl2id (String url) {
	int p1;
	p1 = url.lastIndexOf('/');
	if (p1 < 0) return url; else return url.substring(p1+1);
    }
//
    private static
	void processElement_item (Element elmnt) {
	Elements links;
	links = elmnt.select("a.title");
	for(Element link:links) {
	    String id, url;
	    url = link.attr("href");
	    id = YHDurl2id (url);
	    System.out.print ("YHDid = "); System.out.println (id);
	    System.out.print ("YHDurl = "); System.out.println (url);
	    System.out.print ("YHDtitle = "); System.out.println (link.attr("title"));
	}
	links = elmnt.select("p.price>span>strong");
	for(Element link:links) {
	    System.out.print ("YHDprice = "); System.out.println (link.text());
	}
	links = elmnt.select("p.price>span>del");
	for(Element link:links) {
	    System.out.print ("YHDmprice = "); System.out.println (link.text());
	}
	return;
    }

    private static
	void processElement_search_table (Element elmnt) {
	Elements links;
	links = elmnt.select("ul>li");
	for(Element link:links) processElement_item (link);
	return;
    }
//
    private static String
	dirURL_next (Document doc) {
	Elements links =
	    doc.select("body div.turnPageBottom a.page_next");
	for (Element link:links) return link.attr("url") ;
	return null;
    }
//
    private static Document
	processDirURL_html (Document doc) {
	Elements links = doc.select("body div#search_table");
	for (Element link:links) processElement_search_table (link) ;
	return doc;
    }
    private static Document
	processDirURL_json (String url, Document doc) {
//
	try {
	    final URL url2 = new URL(url);
	    final URLConnection conn2 = url2.openConnection();
	    final InputStream inp = conn2.getInputStream();
	    final InputStreamReader inpr = new InputStreamReader(inp);
	    final JSONParser parser = new JSONParser();
	    final JSONObject jobj = (JSONObject)parser.parse(inpr);
	    String jobj_value = (String)jobj.get("value");
	    Document doc2 = Parser.parseBodyFragment(jobj_value, "");
	    doc = processDirURL_html (doc2);
	} catch (Exception _) {
	    ; // HX: what can I do?
	}
	return doc;
    }
    public static Document
	processDirURL (String url, Document doc) {
	Elements links;
	String title = "**NONE**";
	if (doc!=null) { title = docGetTitle_doc(doc); }
	System.out.print ("##DOCURL: "); System.out.println (url);
	System.out.print ("##DOCTITLE: ");
	if (!title.isEmpty()) {
	    System.out.println (title); doc = processDirURL_html (doc);
	} else {
	    System.out.println ("NO TITLE"); doc = processDirURL_json (url, doc);
	}
	return doc ;
    }
//
    private
    static final int theMaxDepth = 1000;
//
    public static void
	processDirURL_rec (String url, int depth) {
	YiHaoDian YHD;
	Document doc;
	YHD = new YiHaoDian ();
	int pagn = 0;
	while (true) {
	    if (depth <= 0) break ;
	    depth = depth - 1 ;
	    if (url == null) break ;
	    pagn += 1;
	    System.out.print ("##PAGE NUMBER = "); System.out.println (pagn);
	    doc = YHD.docGet_URL(url);
	    doc = processDirURL (url, doc) ;
	    url = dirURL_next (doc);
	}
	return;
    }
//
    public static void
	main (String[] args) {
//
	int argc = args.length;
//
	String dir;
	YiHaoDian YHD;
	Document doc;
//
	int depth = 1;
	if (argc >= 1)
	    depth = Integer.parseInt(args[0]);
	if (depth <= 0) depth = theMaxDepth;
	if (depth >= theMaxDepth) depth = theMaxDepth;
//
	System.out.println("##PAGE DEPTH = " + depth);
	System.out.println("##START: " + ADianShang.getTimeStamp());
//
	DirhtmlIter iter;
	iter = new DirhtmlIter (); // input from STDIN
	while (iter.hasNext()) {
	    dir = iter.getNext();
	    if (!dir.startsWith("http:")) continue;
	    System.out.println("##CURRENT: " + ADianShang.getTimeStamp());
	    processDirURL_rec (dir, depth);
	}
//
	System.out.println("##FINISH: " + ADianShang.getTimeStamp());
//

    }
}

/* ****** ****** */

/* end of [GrabItemurlst.java] */
