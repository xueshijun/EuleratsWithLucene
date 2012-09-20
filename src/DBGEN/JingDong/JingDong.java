/**
 * HX-2012-08-10
 * HX-2012-08-11
 */

/* ****** ****** */

package DBGEN.JingDong;

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

import DBGEN.JingDong.JD_360buy_item;

/* ****** ****** */

public
class JingDong
extends ADianShang {
//
    public JingDong ()
    {
	CONNECT_TIMEOUT_INI_set(500/*ms*/); return;
    }
//
    public String
	itemID2URL (String id) {
	return ("http://www.360buy.com/product/" + id + ".html");
    }
    public String
	itemURL2ID (String url) {
	int p1, p2;
	p1 = url.lastIndexOf('/');
	if (p1 < 0) return url;
	p2 = url.lastIndexOf(".html");
	if (p2 >= 0) return url.substring(p1+1, p2); else return url.substring(p1+1);
    }
//
    public JD_360buy_item
	itemMake_ID(String id)
    {
	JD_360buy_item item ;
	item = itemMake_URL (itemID2URL (id));
	item.strID_set (id);
	return item;
    }
    public JD_360buy_item
	itemMake_URL(String url)
    {
	Document doc = docGet_URL (url);
	JD_360buy_item item = new JD_360buy_item (doc);
	item.strURL_set (url);
	return item;
    }
//
} // end of [JingDong]

/* ****** ****** */

/* end of [JingDong.java] */
