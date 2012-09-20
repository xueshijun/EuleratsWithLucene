/**
 *
 * Grabbing YHDdirhtml lists
 * This is the first step to grabbing YHDid lists
 *
 */

/* ****** ****** */
package DBGEN.YiHaoDian;
import java.io.IOException;

/* ****** ****** */

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

import DBGEN.UTILS.ADianShang;
import DBGEN.YiHaoDian.YiHaoDian;

/* ****** ****** */

class GrabDirhtmlst {
//
    public static
	void processElement_alonesort (Element elmnt) {
	Elements links;
	links = elmnt.select(".mc>dl>dd a");
	for(Element link:links) {
	    System.out.print ("##");
	    System.out.println (link.text());
	    System.out.println (link.attr("href"));
	}
	return;
    }
//
    public static void
	processRootURL (String url) {
	YiHaoDian YHD;
	Document doc;
	Elements links;

	YHD = new YiHaoDian ();
	doc = YHD.docGet_URL(url);

	String title = "**NONE**";
	if (doc!=null) { title = doc.title(); }
	System.out.println ("##Document URL = " + url);
	System.out.println ("##Document Title = " + title);
	links = doc.select("body .alonesort");
	for (Element link:links) processElement_alonesort (link) ;
	return ;
    }
//
    public static void
	main (String[] args) {
//
	System.out.println("##START: " + ADianShang.getTimeStamp());
//
	processRootURL("http://www.yihaodian.com/listAll.do");
//
	System.out.println("##FINISH: " + ADianShang.getTimeStamp());
//

    }
}

/* ****** ****** */

/* end of [GrabDirhtmlst.java] */
