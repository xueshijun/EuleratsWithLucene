/**
 * HX-2012-08-10:
 * storing information on each product found at www.360buy.com
 */

/* ****** ****** */

package DBGEN.Amazon;

/* ****** ****** */

import java.util.ArrayList;

/* ****** ****** */
 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* ****** ****** */

public
class AMZ_1_item {
//
// HX: if strAMZmprice is null then the item is dropped
//
    private String strID = "**NONE**";
    private String strURL = "**NONE**";
    private String strTitle = null;
    private String strAMZprice = null;
    private String strAMZpprice = null;
    private String strAMZmprice = null;
//
    public AMZ_1_item(Document doc)
    {
	if (doc!=null) strTitle_set(doc);
	if (doc!=null) strAMZprice_set(doc);
	if (doc!=null) strAMZpprice_set(doc);
	if (doc!=null) strAMZmprice_set(doc);
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
		doc.select("title").first();
	    if (link!=null) strTitle = link.text();
	} // end of [if]
	if (strTitle==null) strTitle = "**NONE**";
	return ;
    }
//
    public
	String strAMZprice_get ()
    {
	return strAMZprice ; 
    }
    public void
	strAMZprice_set(Document doc)
    {
	Elements links;
	if (doc!=null) {
	    links = doc.select("table.product td>span#priceLarge");
	    if (links.isEmpty()) {
		links = doc.select("table.product td>span#actualPriceValue");
	    }
	    for (Element link:links) {
		strAMZprice = link.text();
	    }
	}
	return;
    }
//
    public
	String strAMZpprice_get ()
    {
	return strAMZpprice ; 
    }
    public void
	strAMZpprice_set(Document doc)
    {
	Elements links;
	if (doc!=null) {
	    links =
		doc.select("table.product td>span#dealPriceValue");
	    for (Element link:links) {
		strAMZpprice = link.text();
	    }
	}
	return;
    }
//
    public String
	strAMZmprice_get ()
    {
	return strAMZmprice ; 
    }
    public void
	strAMZmprice_set(Document doc)
    {
	Elements links;
	if (doc!=null) {
	    links = doc.select("table.product td.listprice");
	    if (links.isEmpty()) {
		links = doc.select("table.product td>span.listprice");
	    }
	    for (Element link:links) {
		strAMZmprice = link.text();
	    }
	}
	return;
    }
//
    public void myprint () {
	System.out.println ("ID = " + strID);
	System.out.println ("URL = " + strURL);
	System.out.println ("title = " + strTitle);
	System.out.println ("AMZprice = " + strAMZprice);
	System.out.println ("AMZpprice = " + strAMZpprice);
	System.out.println ("AMZmprice = " + strAMZmprice);
	return;
    }
//
} // end of [AMZ_1_item]

/* ****** ****** */

/* end of [AMZ_1_item.java] */
