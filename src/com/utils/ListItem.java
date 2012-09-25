package com.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryParser.ParseException;

import com.eulerats.lucene.Index;

public class ListItem extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */ 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("Get reqyest from Search page........");
		
		String searchStr=request.getParameter("keyvalue");
	 
		System.out.println("The Key is Empty.Redirecting ......."+searchStr);
		if(searchStr.trim().equals("")){
			response.sendRedirect("search.html");
		}
		
		ItemsJdbcConnection mysql=new ItemsJdbcConnection();

		List<Items> listResult = null;
		System.out.println("Trying to get index number from physical disk.... ");
		
		String [] keywords=searchStr.split("[ |,|+|，]+");
		
		try {
			listResult= Index.search(keywords);
			
			for(Items list:listResult){
				System.out.println(list.getId()+"\t"+list.getMarket());
			}
		} catch (ParseException e1) { 
			e1.printStackTrace();
		} 
		
		System.out.println("Trying to building connection.... ");   
		Connection [] conn=new Connection[]{
				ItemsJdbcConnection.getConnetction(ConfigUtil.getValue("YIHAODIAN")),
				ItemsJdbcConnection.getConnetction(ConfigUtil.getValue("JINGDONG")),
				ItemsJdbcConnection.getConnetction("AMAZON")
				}; 
		
		List<Items> lists=new ArrayList<Items>();
		 
		String market=null; 
		String sql="";  
		System.out.println("Get Responsed Items ID Lists For Each Sql Related DB.....");
		
		String value1="";
		String value2="";
		String value3="";
		
		for(int j=0;j<listResult.size();j++){
			if(listResult.get(j).getMarket().equals(Items.YIHAODIAN_STRING)){
				if(value1.equals("")){
					value1+=listResult.get(j).getId();		
				}else{
					value1+=","+listResult.get(j).getId();
				} 
			}else if(listResult.get(j).getMarket().equals(Items.JINGDONG_STRING)){
				if(value2.equals("")){
					value2+=listResult.get(j).getId();		
				}else{
					value2+=","+listResult.get(j).getId();
				} 
			}else if(listResult.get(j).getMarket().equals(Items.AMAZON_STRING)){
				if(value3.equals("")){
					value3+=listResult.get(j).getId();		
				}else{
					value3+=","+listResult.get(j).getId();
				}  
			} 
		}  
		System.out.println("Output Response ID.....");
		System.out.println("value1:"+value1);
		System.out.println("value2:"+value2);
		System.out.println("value3:"+value3);
	
		
		for(int i=0;i<conn.length;i++){
			System.out.println("Get SQL MATCHING DB.....");
			switch(i){
				case 0:
					market=Items.YIHAODIAN_STRING; 
					if(!value1.trim().equals("")){ 
						sql="select * from Items where Id in ("+value1+");";
					}else{
						sql="";
					}
					break;
				case 1:
					market=Items.JINGDONG_STRING; 
					if(!value2.trim().equals("")){ 
						sql="select * from Items where Id in ("+value2+");";
					}else{
						sql="";
					}
					break;
				case 2:
					market=Items.AMAZON_STRING;
					if(!value3.trim().equals("")){ 
						sql="select * from Items where Id in ("+value3+");";
					}else{
						sql="";
					}
					break; 	
			}
			
			System.out.println("Try to get data from db using sql statement........");
			System.out.println(sql); 
			if(sql.equals("")){ 
				System.out.println("**********No data in "+market+" db************");
				continue; 
			}  
			
			System.out.println("Try to get ResultSet from db using "+market+"........");
			ResultSet rs  =mysql.getResultSet(conn[i], sql);
			try {
				while(rs.next()){ 
					lists.add(
							new Items(
									Integer.parseInt(rs.getString("Id")),
									market,
								    rs.getString("Url"),
							    	rs.getString("Title"),
									Double.parseDouble(rs.getString("MarketPrice")),
									Double.parseDouble(rs.getString("Price")))
								); 
							System.out.println(market);
					} 
					rs.close();
					conn[i].close(); 
					
				} catch (NumberFormatException e) { 
					e.printStackTrace();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			} 
		
			System.out.println("Sort by Market and price..........");
			Collections.sort(lists,new Comparator(){ 
				public int compare(Object o1, Object o2) { 
//					return (int) (((Items)o1).getPrice()- ((Items)o2).getPrice());
					return (int) (((Items)o1).getPrice()*100/((Items)o1).getMarketPrice()- ((Items)o2).getPrice()*100/((Items)o2).getMarketPrice()); 
				} 
			}); 
		 
			PrintWriter pw=response.getWriter(); 
			System.out.println("Print Html Tags........");
			showHtml(pw, lists,listResult.size());
			System.out.println("All things have done........");
	
		} 

	//
	private static void showHtml(PrintWriter pw,List<Items> lists,int count){
		
		pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />");
		pw.println("<title>Result page</title>");
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
		pw.println("<body>"); 
		pw.println("<div id=\"body-wrapper\">"); 
		pw.println("<div id=\"main-content\">");
//	    <!-- Main Content Section with everything -->
//	    <noscript>
//	    <!-- Show a notification if the user has disabled javascript -->
//	    <div class="notification error png_bg">
//	      <div> Javascript is disabled or is not supported by your browser. Please 
//		  <a href="http://browsehappy.com/" title="Upgrade to a better browser">
//		  upgrade</a> your browser or 
//		  <a href="http://www.google.com/support/bin/answer.py?answer=23852" title="Enable Javascript in your browser">
//		  enable</a> Javascript to navigate the interface properly.
//	        Download From <a href="http://www.exet.tk">exet.tk</a></div>
//	    </div>
//	    </noscript>
		pw.println("<h2>Welcome!</h2>");  
		pw.println("<p id=\"page-intro\"> </p>");  
		pw.println("<div class=\"clear\"></div>");  
		pw.println("<div class=\"content-box\">");  
		pw.println(" <div class=\"content-box-header\">");
		
//		pw.println("<center> <h3>Find about "+count+" results</h3> </center>");  
		pw.println("<center>");
		pw.println("	<div class=\"notification attention png_bg\"> " +
		"<a href=\"#\" class=\"close\">" +
		"<img src=\"resources/images/icons/cross_grey_small.png\" title=\"Close this notification\" alt=\"close\" />" +
		"</a> <div> Find about "+count+" results</div></div>" );
		pw.println("</center>");
		
		pw.println(" <div class=\"clear\"></div>");  
		pw.println("</div>");  
		pw.println("<div class=\"content-box-content\">");
		pw.println("<div class=\"tab-content default-tab\" id=\"tab1\">");    
		


		
		pw.println("<table>" +
				"<thead>" +
				"<tr>" +
				"<th>品名</th>" +
				"<th>商家</th>" +
				"<th>价钱</th>" +
				"<th>市场价</th> " +
				"<th>折扣</th> " +
				"</tr>" +
				"</thead>"); 
		
		if(lists.size()==0){
			pw.println(
					"<tbody>" +
					"<tr>" +
						"<td colspan=\"7\">" +
						"	<div class=\"notification attention png_bg\"> " +
								"<a href=\"#\" class=\"close\">" +
								"<img src=\"resources/images/icons/cross_grey_small.png\" title=\"Close this notification\" alt=\"close\" />" +
								"</a> <div> SORRY!       NOTHING COULD BE FOUND!</div></div>" +
						"</td>"+
					"</tr>" +
					"</tbody>");
		}else{ 
			for(Items list:lists){ 	
					pw.println(
					"<tbody>" +
					"<tr>" +
						"<td><a title=\"title\" href='"+list.getUrl()+"'>"+list.getTitle()+"-"+list.getId()+"</a></td>" +
						"<td>"+list.getMarket()+"</td>" +
						"<td>"+list.getPrice()+"</td>" +
						"<td>"+list.getMarketPrice()+"</td>" +
						"<td>"+(int)(list.getPrice()*100/list.getMarketPrice()*100)/100+"折</td>" +
					"</tr>" +
					"</tbody>");
			}
		} 
		
		pw.println("<tfoot><tr>");
		pw.println("<td colspan=\"7\">");
		pw.println("<div class=\"bulk-actions align-left\"></div> "); 			
			pw.println("<div class=\"pagination\">");
			pw.println("<a href=\"#\" title=\"First Page\">&laquo; First</a>");
			pw.println("<a href=\"#\" title=\"Previous Page\">&laquo; Previous</a> "); 
			pw.println("<a href=\"#\" class=\"number\" title=\"1\">1</a> <a href=\"#\" class=\"number\" title=\"2\">2</a> ");
			pw.println("<a href=\"#\" class=\"number current\" title=\"3\">3</a> " +
					"<a href=\"#\" class=\"number\" title=\"4\">4</a>");
			pw.println("<a href=\"#\" title=\"Next Page\">Next &raquo;</a>" +
					"<a href=\"#\" title=\"Last Page\">Last &raquo;</a> "); 
			pw.println("<span></span><span></span><span></span>");
			pw.println(" </div>");
		pw.println("  <div class=\"clear\"></div>"); 
		pw.println(" </td>");
		pw.println("</tr>  </tfoot> ");  
		pw.println("</table>"); 
		pw.println("</div></div></div>"); 
		pw.println("<div class=\"clear\"></div>");
		
		
		pw.println("<div id=\"footer\"> <small>");
		pw.println(" &#169; Copyright 2012- ALRS | <a href=\"#\">Top</a> </small> </div>");
		pw.println("</div></div></body></html>");

		pw.close(); 
	}
		
	public final static int INITIONAL=0;//初始化
	public final static int VIEWDEFAULTPAGE=1;//
	public final static int VIEWSPECIALPAGE=2;//
//	public final static int PAGE=2;//
	
	public void model(int type){
		switch(type){
			case VIEWDEFAULTPAGE:
			break;
			case VIEWSPECIALPAGE: 
			break;
		}
	}	
}		
 