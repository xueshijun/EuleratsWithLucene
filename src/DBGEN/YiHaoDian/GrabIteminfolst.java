/**
 *
 * For grabbing YHD items given their ids
 *
 */

/* ****** ****** */
package DBGEN.YiHaoDian;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* ****** ****** */

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

/* ****** ****** */

import DBGEN.UTILS.*;
import DBGEN.YiHaoDian.YiHaoDian;
import DBGEN.YiHaoDian.YHD_1_item;

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
	YiHaoDian YHD = new YiHaoDian ();
	doc = YHD.docGet_URL("http://www.yihaodian.com/");
	String title = "__NONE__";
	if (doc!=null) { title = doc.title(); }
	System.out.println ("##Document Title = " + title);
//
	int cnt = 0;
	ItemurlIter iter = null;
	if (argc == 0) iter = new ItemurlIter ();
	if (argc >= 1) iter = new ItemurlIter (args[0]);
//
	YHD_1_item item;
	while (iter.hasNext()) {
	    url = iter.getNext() ;
	    item = YHD.itemMake_URL (url);
	    item.strID_set(YHD.itemURL2ID(url));
	    if (item.strYHDprice_get() != null) {
		cnt = cnt + 1;
		item.myprint();
		if (cnt % 100 == 0) {
		    System.out.println("##CURRENT: " + ADianShang.getTimeStamp());
		    System.out.flush();
		}
	    }
	}
//
	System.out.println("##FINISH: " + ADianShang.getTimeStamp());
//
    }
}

/* ****** ****** */

/* end of [GrabIteminfolst.java] */
