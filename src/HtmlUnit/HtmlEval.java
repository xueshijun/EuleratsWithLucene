/*
** HX: simple test for htmlunit
*/

/* ****** ****** */
package HtmlUnit;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.BrowserVersion;

/* ****** ****** */

class HtmlEval {

    public static void
    main (String[] args) throws Exception
    {
	HtmlPage page ;
	final WebClient webClient = new WebClient();
	String url = "http://www.google.com";
	if (args.length >= 1) url = args[0] ;
	/*
	webClient.setJavaScriptEnabled(false);
	*/
	page = webClient.getPage(url);
	System.out.println (page.asXml());
	webClient.closeAllWindows();
    }

}

/* ****** ****** */

/* end of [HtmlEval.java] */
