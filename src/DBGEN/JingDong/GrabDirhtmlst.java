/**
 *
 * Grabbing JDdirhtml lists
 * This is the first step to grabbing JDid lists
 *
 */

/* ****** ****** */
package DBGEN.JingDong;
import java.io.IOException;

/* ****** ****** */

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

import DBGEN.UTILS.ADianShang;
import DBGEN.JingDong.JingDong;

/* ****** ****** */

class GrabDirhtmlst {
//
    public static void processElement_m (Element elmnt) {
		Elements links;
		links = elmnt.select(".mc>dl>dd a");
		for(Element link:links) {
		    System.out.print("##");
		    System.out.println (link.text());
		    System.out.println (link.attr("href"));
		}
		return;
    }
//
    public static void processRootURL (String url) {
		JingDong JD;
		Document doc;
		Elements links;
	
		JD = new JingDong ();
		doc = JD.docGet_URL(url);
	
		String title = "**NONE**";
		if (doc!=null) { title = doc.title(); }
		System.out.println ("##DOCURL = " + url);
		System.out.println ("##DOCTITLE = " + title);
		links = doc.select("body .m");
		for (Element link:links) processElement_m (link) ;
		return ;
    }
//
    public static void main (String[] args) {
//
	System.out.println("##START: " + ADianShang.getTimeStamp());
//
	processRootURL("http://www.360buy.com/allSort.aspx");
	/*
	processRootURL("http://www.360buy.com/book/booksort.aspx");
	processRootURL("http://mvd.360buy.com/mvdsort/4051.html"); // music
	processRootURL("http://mvd.360buy.com/mvdsort/4052.html"); // movies
	processRootURL("http://mvd.360buy.com/mvdsort/4053.html"); // education
	*/
//
	System.out.println("##FINISH: " + ADianShang.getTimeStamp());
//

    }
}

/* ****** ****** */

/* end of [GrabDirhtmlst.java] */
