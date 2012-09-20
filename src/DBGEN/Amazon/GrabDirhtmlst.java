/**
 *
 * Grabbing AMZdirhtml lists
 * This is the first step to grabbing AMZid lists
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

import DBGEN.UTILS.ADianShang;
import DBGEN.Amazon.Amazon;

/* ****** ****** */

class GrabDirhtmlst {
//
    public static
	void processElement_siteDirectory (Element elmnt) {
	Elements links;
	links = elmnt.select("table div.popover-grouping a[href]");
	for(Element link:links) {
	    System.out.print("##");
	    System.out.println (link.text());
	    System.out.println (link.attr("href"));
	}
	return;
    }
//
    public static void
	processRootURL (String url) {
	Amazon AMZ;
	Document doc;
	Elements links;

	AMZ = new Amazon ();
	doc = AMZ.docGet_URL(url);

	String title = "**NONE**";
	if (doc!=null) { title = doc.title(); }
	System.out.println ("##Document URL = " + url);
	System.out.println ("##Document Title = " + title);
	links = doc.select("body div#siteDirectory");
	for (Element link:links) processElement_siteDirectory (link) ;
	return ;
    }
//
    public static void
	main (String[] args) {
//
	System.out.println("##START: " + ADianShang.getTimeStamp());
//
	processRootURL("http://www.amazon.cn/gp/site-directory/ref=topnav_sad");
//
	System.out.println("##FINISH: " + ADianShang.getTimeStamp());
//

    }
}

/* ****** ****** */

/* end of [GrabDirhtmlst.java] */
