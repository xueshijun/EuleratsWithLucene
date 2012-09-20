/**
 * HX-2012-08-12:
 * storing information on each product found at www.yihaodian.com
 */

/* ****** ****** */

package DBGEN.YiHaoDian;

/* ****** ****** */

import java.util.ArrayList;

/* ****** ****** */
 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

public
class YHD_1_item {
//
// HX: if strYHDmprice is null then the item is dropped
//
    private String strID = "**NONE**";
    private String strURL = "**NONE**";
    private String strTitle = "**NONE**";
    private String strYHDprice = null; // YiHaoDian price
    private String strYHDpprice = null; // YiHaoDian promotional price
    private String strYHDmprice = null; // YiHaoDian market price
    private String strProductKWS = "**NONE**";
//
    public YHD_1_item(Document doc)
    {
	if (doc != null) strTitle_set(doc);
	if (doc != null) strYHDprice_set(doc);
	if (doc != null) strYHDpprice_set(doc);
	if (doc != null) strYHDmprice_set(doc);
	/*
	if (doc != null) strProductKWS_set(doc);
	*/
    }
//
    public String strID_get()
    {
	return strID;
    }
    public void strID_set(String id)
    {
	strID = id; return ;
    }
//
    public String strURL_get()
    {
	return strURL;
    }
    public void strURL_set(String url)
    {
	strURL = url; return ;
    }
//
    public String strTitle_get()
    {
	return strTitle ;
    }
    public void strTitle_set(Document doc)
    {
	if (doc != null) {
	    Element link =
		doc.select("div.produce.clearfix>div.p_title>h2>font#productMainName").first();
	    if (link != null) strTitle = link.text();
	} // end of [if]
	if (strTitle == null) strTitle = "**NONE**";
	return ;
    }
//
    public String strYHDprice_get()
    {
	return strYHDprice;
    }
    public void
	strYHDprice_set(Document doc)
    {
	if (doc != null) {
	    Element link = null;
	    Elements links = null;
	    links = doc.select("div.produce.clearfix>div.property.property_box>div.specific_info1>dl.clearfix");
	    for (Element link2:links) {
		link = link2.select("dd>span#nonMemberPrice").first();
		if (link != null) break;
	    }
	    if (link != null) strYHDprice = link.text();
	}
	return;
    }
//
    public String strYHDpprice_get()
    {
	return strYHDpprice;
    }
    public void
	strYHDpprice_set(Document doc)
    {
	if (doc != null) {
	    Element link = null;
	    Elements links = null;
	    links = doc.select("div.produce.clearfix>div.property.property_box>div.specific_info1>dl.clearfix");
	    for (Element link2:links) {
		link = link2.select("dd>span#productFacadePrice").first();
		if (link != null) break;
	    }
	    if (link != null) strYHDpprice = link.text();
	}
	return;
    }
//
    public String strYHDmprice_get()
    {
	return strYHDmprice;
    }
    public void
	strYHDmprice_set(Document doc)
    {
	if (doc != null) {
	    Element link = null;
	    Elements links = null;
	    links = doc.select("div.produce.clearfix>div.property.property_box>div.specific_info1>dl.clearfix");
	    for (Element link2:links) {
		link = link2.select("dd>del#old_price").first();
		if (link != null) break;
	    }
	    if (link != null) strYHDmprice = link.text();
	}
	return;
    }
//
    public String
	strProductKWS_get (Document doc)
    {
	return strProductKWS ;
    }
    public void
	strProductKWS_set (Document doc)
    {
	Element link =
	    doc.select("meta[name=keywords]").first();
	if (link != null) strProductKWS = link.attr("content");
	if (strProductKWS == null) strProductKWS = "**NONE**";
	return;
    }
//
    public void myprint () {
	System.out.println ("ID = " + strID);
	System.out.println ("URL = " + strURL);
	System.out.println ("title = " + strTitle);
	System.out.println ("YHDprice = " + strYHDprice);
	System.out.println ("YHDpprice = " + strYHDpprice);
	System.out.println ("YHDmprice = " + strYHDmprice);
	/*
	System.out.println ("ProductKWS = " + strProductKWS);
	*/
	return;
    }
//
} // end of [YHD_1_item]

/* ****** ****** */

/* end of [YHD_1_item.java] */
