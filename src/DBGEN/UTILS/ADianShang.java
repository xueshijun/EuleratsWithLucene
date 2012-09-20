/**
 * HX-2012-08-12
 */

/* ****** ****** */

package DBGEN.UTILS;

/* ****** ****** */

import java.io.IOException;

/* ****** ****** */

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* ****** ****** */

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* ****** ****** */

public
class ADianShang {
//
    public static
	String getTimeStamp () {
	DateFormat dateFormat =
	    new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }
//
    public String
	itemID2URL (String id) {
	return "itemID2URL(" + id + ")" ; // dummy
    }
    public String
	itemURL2ID (String url) {
	return "itemURL2ID(" + url + ")" ; // dummy
    }
//
    private int CONNECT_TIMEOUT_INI = 1000/*ms*/;
    public int
	CONNECT_TIMEOUT_INI_get() { return CONNECT_TIMEOUT_INI ; }
    public void
	CONNECT_TIMEOUT_INI_set(int val) { CONNECT_TIMEOUT_INI = val; return; }
//
    private int CONNECT_TIMEOUT_FIN = 16000/*ms*/;
    public int
	CONNECT_TIMEOUT_FIN_get() { return CONNECT_TIMEOUT_FIN ; }
    public void
	CONNECT_TIMEOUT_FIN_set(int val) { CONNECT_TIMEOUT_FIN = val; return; }
//
    private static
	void _geterr (String URL) {
	System.err.println ("Connection failed: URL = " + URL);
	return;
    }
    public Document
	docGet_URL(String url)
    {
	Document doc;
	Connection conn;
	int timeout = CONNECT_TIMEOUT_INI;
	conn = null;
	try {
	    conn = Jsoup.connect(url);
	} catch (Exception _) {
	    ; // conn is null at this point
	} // end of [try]
	if (conn == null) return null;
	while (true) {
	    conn = conn.timeout(timeout);
	    try {
		return conn.get();
	    } catch (IOException _) {
		timeout = 2 * timeout;
		if (timeout > CONNECT_TIMEOUT_FIN) { _geterr(url); break; }
	    } // end of [try]
	}
	return null; // HX: max timeout reached at this point
    }
//
    public String
	docGetTitle_doc (Document doc)
    {
	return doc.title();
    }
//
} // end of [class]

/* ****** ****** */

/* end of [ADianShang.java] */
