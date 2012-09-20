/**
 * HX-2012-08-10:
 * storing information on each product found at www.360buy.com
 */

/* ****** ****** */

package DBGEN.JingDong;

/* ****** ****** */

import java.util.ArrayList;

/* ****** ****** */
 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

public
class JD_360buy_item {
//
// HX: if strJDmprice is null then the item is dropped
//
    private String strID = "**NONE**";
    private String strURL = "**NONE**";
    private String strTitle = null;
    private String strJDprice = null;
    private String strJDmprice = null;
//
    private String strProductKWS ="**NONE**";
    private String strProductInfo="**NONE**";
//
    public JD_360buy_item(Document doc)
    {
	if (doc!=null) strTitle_set(doc);
	if (doc!=null) strJDprice_set(doc);
	if (doc!=null) strJDmprice_set(doc);
	/*
	if (doc!=null) strProductKWS_set(doc);
	if (doc!=null) strProductInfo_set(doc);
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
    public
	String strTitle_get()
    {
	return strTitle ;
    }
    public void
	strTitle_set(Document doc)
    {
	if (doc!=null) {
	    Element link =
		doc.select("div.w.main>div.right-extra>#name>h1").first();
	    if (link!=null) strTitle = link.text();
	} // end of [if]
	if (strTitle==null) strTitle = "**NONE**";
	return ;
    }
//
    public
	String strJDprice_get ()
    {
	return strJDprice ; 
    }
    public void
	strJDprice_set(Document doc)
    {
	if (doc!=null) {
	    Elements links =
		doc.select("div.w.main>div.right-extra>#summary>li");
	    for (Element link:links) {
		Element image =
		    link.select("img[src$=.png]").first();
		if (image!=null) {
		    strJDprice = image.attr("src"); break;
		} // end of [if]
	    }
	}
	return;
    }
//
    public String
	strJDmprice_get ()
    {
	return strJDmprice ; 
    }
    public void
	strJDmprice_set(Document doc)
    {
	Elements links;
	if (doc!=null) {
	    links = doc.select("div.w.main>div.right-extra>#summary>li>del");
	    for (Element link:links) {
		strJDmprice = link.text(); break;
	    }
	    if (strJDmprice != null) return;
	    links = doc.select("div.w.main>div.right-extra>#book-price>li>del");
	    for (Element link:links) {
		strJDmprice = link.text(); break;
	    }
	    if (strJDmprice != null) return;
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
	if (link!=null) strProductKWS = link.attr("content");
	if (strProductKWS==null) strProductKWS = "**NONE**";
	return;
    }
//
    public String strProductInfo_get()
    {
	return strProductInfo ; 
    }
    public void
	strProductInfo_set(Document doc)
    {
	strProductInfo = null;
	if (doc!=null) {
	    Elements links, links2 ;
	    links = doc.select("TABLE DIV[class=pcp_zhengzi]");
	    links2 = doc.select("TABLE DIV[oldclass=pcp_zhengzi]");
	    links.addAll(links2) ;
	    links2 = doc.select("TABLE DIV[oldoldclass=pcp_zhengzi]");
	    links.addAll(links2) ;
	    links2 = doc.select("TABLE DIV[oldoldoldclass=pcp_zhengzi]");
	    links.addAll(links2) ;
	    for (Element link:links) {
		if (strProductInfo==null) {
		    strProductInfo = "\n" + link.text();
		} else {
		    strProductInfo = strProductInfo + "\n" + link.text();
		} // end of [if]
	    }
	}
	if (strProductInfo==null) strProductInfo = "**NONE**";
	return;
    }
//
    public void myprint () {
	System.out.println ("ID = " + strID);
	System.out.println ("URL = " + strURL);
	System.out.println ("title = " + strTitle);
	System.out.println ("JDprice = " + strJDprice);
	System.out.println ("JDmprice = " + strJDmprice);
	/*
	System.out.println ("ProductKWS = " + strProductKWS);
	System.out.println ("ProductInfo = " + strProductInfo);
	*/
	return;
    }
//
} // end of [JD_360buy_item]

/* ****** ****** */

/* end of [JD_360buy_item.java] */
