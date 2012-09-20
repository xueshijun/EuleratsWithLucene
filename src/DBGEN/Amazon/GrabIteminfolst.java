/**
 *
 * For grabbing AMZ items given their ids
 *
 */

/* ****** ****** */
package DBGEN.Amazon;
import java.io.IOException;

/* ****** ****** */

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

/* ****** ****** */

import DBGEN.UTILS.*;

import DBGEN.Amazon.Amazon;
import DBGEN.Amazon.AMZ_1_item;

/* ****** ****** */

class GrabIteminfolst {
//
    public static void
	main (String[] args) {
//
	int argc = args.length;
//
	String url;
	Document doc;
//
	System.out.println("##START: " + ADianShang.getTimeStamp());
//
	Amazon AMZ = new Amazon ();
	doc = AMZ.docGet_URL("http://www.amazon.cn/");
	String title = "__NONE__";
	if (doc!=null) { title = doc.title(); }
	System.out.println("##Document Title = " + title);
//
	int cnt = 0;
	ItemurlIter iter;
	iter = new ItemurlIter ();

	AMZ_1_item item;
	while (iter.hasNext()) {
	    url = iter.getNext() ;
	    if (url.startsWith("##")) continue;
	    item = AMZ.itemMake_ID(url);
	    item.strID_set(AMZ.itemURL2ID(url));
//
// HX: [item.strAMZmprice] is empty for many valid items!
//
	    cnt = cnt + 1;
	    item.myprint();
	    if (cnt % 100 == 0) {
		System.out.println("##CURRENT: " + ADianShang.getTimeStamp());
		System.out.flush();
	    }
//
	}
//
	System.out.println("##FINISH: " + ADianShang.getTimeStamp());
//
    }
}

/* ****** ****** */

/* end of [GrabIteminfolst.java] */
