/**
 *
 * The main function for replenshing JingDong database
 *
 */

/* ****** ****** */
package DBGEN.JingDong;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;

/* ****** ****** */

class GrabPImagelst {
//
    private static
	String BUYIMG_URL = "http://price.360buyimg.com";
//
    private static
	String getTimeStamp () {
	DateFormat dateFormat =
	    new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }
//
    private static void
	priceImageDownload (int id) throws IOException {
	URL url = null;
	File file = null;
	BufferedImage bufimg = null;
	try {
	  url = new URL(BUYIMG_URL + "/gp" + id + ",3.png");
	} catch (MalformedURLException _) { }
	if (url!=null) {
	    try { bufimg = ImageIO.read(url); } catch (IOException _) { }
	} // end of [if]
	if (bufimg!=null) {
	    String fname = "gp" + id + ".png";
	    System.out.println ("##IMAGE FILE CREATED: " + fname);
	    file = new File("PIMG/" + fname);
	    ImageIO.write(bufimg, "png", file);
	}
    }
//
    public static void
	main (String[] args) throws IOException {
//
	int argc = args.length;
//
	System.out.println("##START: " + getTimeStamp());
//	
	Integer id_ini = 0, id_fin = 0;
	if (argc >= 1) {
	    try { id_ini = Integer.parseInt(args[0]); } catch (Exception _) { };
	}
	if (argc >= 2) {
	    try { id_fin = Integer.parseInt(args[1]); } catch (Exception _) { };
	}
//
	System.out.println ("id_ini = " + id_ini);
	System.out.println ("id_fin = " + id_fin);
//
	for (int id=id_ini; id <= id_fin; id += 1) {
	    System.out.println(id + ": start");
            priceImageDownload(id);
	    System.out.println(id + ": finish");
	}
//
	System.out.println("##FINISH: " + getTimeStamp());
//
    }
}

/* ****** ****** */

/* end of [GrabPImagelst.java] */
