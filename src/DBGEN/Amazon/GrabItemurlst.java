/**
 *
 * Grabbing AMZid lists
 *
 */

/* ****** ****** */
package DBGEN.Amazon;
import java.io.IOException;

/* ****** ****** */

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

import DBGEN.UTILS.*;
import DBGEN.Amazon.Amazon;

/* ****** ****** */

class GrabItemurlst {
//
    private static
	void processElement_Result (Element elmnt) {
	Elements links;
//
	System.out.print ("AMZid = ");
	System.out.println (elmnt.attr("name"));
//
	String title = null;
	System.out.print ("AMZtitle = ");
	if (title == null) {
	    links =
		elmnt.select("a.title[href]");
	    for (Element link:links) title = link.text();
	}
	if (title == null) {
	    links =
		elmnt.select("div.productTitle a[href]");
	    for (Element link:links) title = link.text();
	}
	System.out.println (title);
//
	links = elmnt.select("div.newPrice");
	for (Element link:links) {
	    Element link2;
	    String price = null;
	    String mprice = null;
	    link2 = link.select("span").first();
	    if (link2 != null) price = link2.text();
	    link2 = link.select("strike").first();
	    if (link2 != null) mprice = link2.text();
	    System.out.print ("AMZprice = "); System.out.println (price);
	    System.out.print ("AMZmprice = "); System.out.println (mprice);
	}
//
	return;
    }
    private static
	void processElement_Results (Element elmnt) {
	Elements links, link2;
	links = elmnt.select("div.result[name]");
	for(Element link:links) processElement_Result (link);
	return;
    }
    private static
	void processElement_btfResults (Element elmnt) {
	Elements links;
	links = elmnt.select("div.result[name]");
	for(Element link:links) System.out.println (link.attr("name"));
	return;
    }
//
    private static String
	dirURL_next (Document doc) {
	Elements links =
	    doc.select("body div#bottomBar span.pagnNext a[href]");
	for (Element link:links) { return link.attr("href"); }
	return null;
    }
//
    public static void
	processDirURL
	(String url, Document doc) {
	Elements links;

	String title = "**NONE**";
	if (doc!=null) { title = doc.title(); }
	System.out.println("##DOCURL = " + url);
	System.out.println("##DOCTITLE = " + title);
	links = doc.select("body div#atfResults");
	for (Element link:links) processElement_Results(link) ;
	links = doc.select("body div#btfResults");
	for (Element link:links) processElement_Results(link) ;
	return ;
    }
//
    private
    static final int theMaxDepth = 10000;
    private
    static final String
	dirbase = "http://www.amazon.cn/s/ref=sr_hi_1?rh=n%3A";
//
    private
    static String
	dirFullize (String dir) {
	if (dir == null) return null ;
	String node = dir;
	int p = node.lastIndexOf ('=');
	if (p >= 0) node = node.substring(p+1);
	return (dirbase + node);
    }
    private
    static String
	dirFullize2 (String url) { return url; }
//
    public static void processDirURL_rec (String url, int depth) {
	Amazon AMZ;
	Document doc;
	AMZ = new Amazon ();
	int pagn = 0;
	while (true) {
	    if (depth <= 0) break ;
	    depth = depth - 1 ;
	    if (url == null) break ;
	    pagn += 1;
	    System.out.print ("##PAGE NUMBER = "); System.out.println (pagn);
	    doc = AMZ.docGet_URL(url);
	    processDirURL (url, doc) ;
	    url = dirURL_next (doc);
	}
	return;
    }
//
    public static void main (String[] args) {
//
	int argc = args.length;
//
	String dir;
	Amazon AMZ;
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
	    if (!dir.startsWith("/")) continue;
	    dir = dirFullize(dir);
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
