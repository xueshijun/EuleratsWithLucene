package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {  
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw=response.getWriter();
		pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		pw.println("<title>Search Index Page</title> ");
		pw.println("<link rel=\"stylesheet\" href=\"resources/css/reset.css\" type=\"text/css\" media=\"screen\" />");
		pw.println("<link rel=\"stylesheet\" href=\"resources/css/style.css\" type=\"text/css\" media=\"screen\" />");
		pw.println("<link rel=\"stylesheet\" href=\"resources/css/invalid.css\" type=\"text/css\" media=\"screen\" />");
		pw.println("<script type=\"text/javascript\" src=\"resources/scripts/jquery-1.3.2.min.js\"></script>");
		pw.println("<script type=\"text/javascript\" src=\"resources/scripts/simpla.jquery.configuration.js\"></script>");
		pw.println("<script type=\"text/javascript\" src=\"resources/scripts/facebox.js\"></script>"); 
		pw.println("<script type=\"text/javascript\" src=\"resources/scripts/jquery.wysiwyg.js\"></script>"); 
		pw.println("<script type=\"text/javascript\" src=\"resources/scripts/jquery.datePicker.js\"></script>"); 
		pw.println("<script type=\"text/javascript\" src=\"resources/scripts/jquery.date.js\"></script>"); 
		pw.println("</head>");
		pw.println("<body id=\"login\">");
		pw.println("<div id=\"login-wrapper\" class=\"png_bg\">");
			pw.println(" <div id=\"login-top\">");
			pw.println(" <h1></h1>");
			pw.println("</div>");
			pw.println("  <div id=\"login-content\">");
				pw.println("<form action=\"list\" method=\"post\">");
				pw.println("<div class=\"notification information png_bg\">"); 
					pw.println("<a href=\"#\" class=\"close\"><img src=\"resources/images/icons/cross_grey_small.png\" title=\"Close this notification\" alt=\"close\" /></a>");
					pw.println("<div> Please input your keywords. </div>");
				pw.println(" </div>");
				pw.println("<p>");
				pw.println("<label> </label>");
				pw.println("<input class=\"text-input large-input\" type=\"text\" name=\"keyvalue\" />");
				pw.println("<input class=\"button\" type=\"submit\" value=\"Search\" />");
				pw.println("</p>");
				pw.println("<div class=\"clear\"></div> ");
				pw.println("</form>");
			pw.println("</div>"); 
		pw.println("</div>");
			pw.println("<br/>   <br/><br/><br/><br/><br/><br/><br/><br/><br/>");
	
		pw.println("<div align=\"center\">");
			pw.println("<div id=\"footer\">"); 
			pw.println("<small>&#169; Copyright 2012- ALRS  </small>");
			pw.println("<span><a href=\"downloads/Eulerats.rar\">Download Client for Android</a></span>");
			pw.println("</div>");
		pw.println("</div>"); 


		pw.println("</body></html>");
	}

}
