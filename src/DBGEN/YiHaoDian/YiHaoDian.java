/**
 * HX-2012-08-12
 */

/* ****** ****** */

package DBGEN.YiHaoDian;

/* ****** ****** */

import java.io.IOException;

/* ****** ****** */

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

import DBGEN.UTILS.ADianShang;

/* ****** ****** */

import DBGEN.YiHaoDian.YHD_1_item;

/* ****** ****** */

public
class YiHaoDian extends ADianShang {
//
    public YiHaoDian ()
    {
	CONNECT_TIMEOUT_INI_set(500/*ms*/); return;
    }
//
    public String
	itemID2URL (String id) {
	return "http://www.yihaodian.com/product/" + id + "_1";
    }
    public String
	itemURL2ID (String url) {
	int p1;
	p1 = url.lastIndexOf('/');
	if (p1 < 0) return url; else return url.substring(p1+1);
    }
//
    public YHD_1_item
	itemMake_ID(String id)
    {
	YHD_1_item item ;
	item = itemMake_URL (itemID2URL (id));
	item.strID_set (id);
	return item;
    }
    public YHD_1_item
	itemMake_URL(String url)
    {
	Document doc = docGet_URL (url);
	YHD_1_item item = new YHD_1_item (doc);
	item.strURL_set (url);
	return item;
    }
//
} // end of [class]

/* ****** ****** */

/* end of [YiHaoDian.java] */
