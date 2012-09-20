/**
 * HX-2012-08-10
 * HX-2012-08-11
 */

/* ****** ****** */

package DBGEN.Amazon;

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

import DBGEN.Amazon.AMZ_1_item;

/* ****** ****** */

public
class Amazon
extends ADianShang {
//
    public Amazon ()
    {
	CONNECT_TIMEOUT_INI_set(500/*ms*/); return;
    }
//
    public String
	itemID2URL (String id) {
	return ("http://www.amazon.cn/gp/product/" + id);
    }
    public String
	itemURL2ID (String url) {
	int p;
	p = url.lastIndexOf('/');
	if (p >= 0) return url.substring(p+1); else return url;
    }
//
    public AMZ_1_item
	itemMake_ID(String id)
    {
	AMZ_1_item item ;
	item = itemMake_URL (itemID2URL (id));
	item.strID_set (id);
	return item;
    }
    public AMZ_1_item
	itemMake_URL(String url)
    {
	Document doc = docGet_URL (url);
	AMZ_1_item item = new AMZ_1_item (doc);
	item.strURL_set (url);
	return item;
    }
//
} // end of [Amazon]

/* ****** ****** */

/* end of [Amazon.java] */
