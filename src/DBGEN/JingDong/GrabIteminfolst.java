/**
 *
 * For grabbing JD items given their ids
 *
 */

/* ****** ****** */
package DBGEN.JingDong;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* ****** ****** */

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

/* ****** ****** */

import DBGEN.UTILS.*;

import DBGEN.JingDong.JingDong;
import DBGEN.JingDong.JD_360buy_item;

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
	JingDong JD = new JingDong ();
	doc = JD.docGet_URL("http://www.360buy.com/");
	String title = "__NONE__";
	if (doc!=null) { title = doc.title(); }
	System.out.println("##Document Title = " + title);
//
	int cnt = 0;
	ItemurlIter iter;
	iter = new ItemurlIter ();

	JD_360buy_item item;
	while (iter.hasNext()) {
	    url = iter.getNext() ;
	    item = JD.itemMake_URL(url);
	    item.strID_set(JD.itemURL2ID(url));
//
// HX: [item.strJDmprice] is empty for many valid items!
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
