/**
 *
 * Grabbing JDid lists
 *
 */
package DBGEN.JingDong;
/* ****** ****** */

import java.io.IOException;

/* ****** ****** */

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

import DBGEN.UTILS.*;
import DBGEN.JingDong.JingDong;

/* ****** ****** */

class GrabItemurlst {
//
    private static
	void processElement_plist (Element elmnt) {
	Elements links;
	links = elmnt.select("div.p-name a[href]");
	for(Element link:links) System.out.println(link.attr("href"));
	return;
    }
//
    private static String
	dirURL_next (Document doc) {
	Elements links =
	    doc.select("body div.pagin.fr a.next");
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
	links = doc.select("body div#plist");
	for (Element link:links) processElement_plist(link) ;
	return ;
    }
//
    private
    static final int theMaxDepth = 1000;
    private
    static final String dirbase = "http://www.360buy.com";
    private
    static final String dirbase1 = "http://www.360buy.com/";
    private
    static final String dirbase2 = "http://www.360buy.com/products/";
//
    private
    static String
	dirFullize (String dir) {
	if (dir == null) return null ;
	if (dir.startsWith("http:")) return (dir);
	if (dir.startsWith("/")) return (dirbase + dir);
	return (dirbase1 + dir);
    }
    private
    static String
	dirFullize2 (String url) {
	if (url == null) return null ;
	if (url.startsWith("http:")) return (url);
	return (dirbase2 + url);
    }
//
    public static void
	processDirURL_rec (String url, int depth) {
	JingDong JD;
	Document doc;
	JD = new JingDong ();
	int pagn = 0;
	while (true) {
	    if (depth <= 0) break ;
	    depth = depth - 1 ;
	    if (url == null) break ;
	    pagn += 1;
	    System.out.print ("##PAGE NUMBER = "); System.out.println (pagn);
	    url = dirFullize2 (url);
	    doc = JD.docGet_URL(url);
	    processDirURL (url, doc) ;
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
	JingDong JD;
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
	    if (!dir.endsWith(".html")) continue;
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
