package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryParser.ParseException;

import com.dao.ItemsJdbcConnection;
import com.entity.Items;
import com.lucene.Index;
import com.utils.ConfigUtil;

public class ListItem extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */ 
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("Get request from Search page........");
		
		String searchStr=request.getParameter("keyvalue");
	 
		System.out.println("The Key is Empty! Redirecting ......."+searchStr);
		if(searchStr.trim().equals("")){
			response.sendRedirect("search.html");
		}
		

		
		//-------------------------------------------------------------
		List<Items> listResult = null; 
		System.out.println("Get Keywords.... ");
		String [] keywords=searchStr.split("[ |,|+|，]+"); 
		System.out.println("Trying to get index  from physical disk.... ");
		if(keywords.length==0){
			System.out.println("Single Keyword.... ");
			try {
				listResult= Index.search(searchStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else{
			System.out.println("Multiple Keywords.... ");
			try {
				listResult= Index.search(keywords);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		System.out.println("Listing Items in index...... ");
		for(Items list:listResult){
			System.out.println(list.getId()+"\t"+list.getMarketName());
		}
		 
		//------------------------------------------------------------- 
		System.out.println("Get Responsed Items ID Lists of Each  Related DB.....");  
		String value1="";//YIHAODIAN
		String value2="";//JINGDONG
		String value3="";//AMAZON
		String value4="";//COO8
		for(int i=0;i<listResult.size();i++){
			if(listResult.get(i).getMarketName().equals(Items.YIHAODIAN_STRING)){
				if(value1.equals("")){
					value1+=listResult.get(i).getId();		
				}else{
					value1+=","+listResult.get(i).getId();
				} 
			}else if(listResult.get(i).getMarketName().equals(Items.JINGDONG_STRING)){
				if(value2.equals("")){
					value2+=listResult.get(i).getId();		
				}else{
					value2+=","+listResult.get(i).getId();
				} 
			}else if(listResult.get(i).getMarketName().equals(Items.AMAZON_STRING)){
				if(value3.equals("")){
					value3+=listResult.get(i).getId();		
				}else{
					value3+=","+listResult.get(i).getId();
				}  
			} else if(listResult.get(i).getMarketName().equals(Items.COO8_STRING)){
				if(value4.equals("")){
					value4+=listResult.get(i).getId();		
				}else{
					value4+=","+listResult.get(i).getId();
				}  
			}   
		}
		
		
		List<Items> lists=new ArrayList<Items>();
		String market=null; 
		String sql="";   
		 
		System.out.println("Output Response ID.....");
		System.out.println("value1:"+value1);
		System.out.println("value2:"+value2);
		System.out.println("value3:"+value3);
		System.out.println("value4:"+value4);
	
		
		System.out.println();
		
		System.out.println("Trying to building connection.... "); 
		//		Connection [] conn=new Connection[]{
		//		ItemsJdbcConnection.getConnetction(ConfigUtil.getValue("YIHAODIAN")),
		//		ItemsJdbcConnection.getConnetction(ConfigUtil.getValue("JINGDONG")),
		//		ItemsJdbcConnection.getConnetction("AMAZON")
		//		}; 
		//
		//DBNAMES=JINGDONG,YIHAODIAN,AMAZON,COO8
		String[] str_Conn=ConfigUtil.getValue("DBNAMES").split(",");  
		Map<String,Connection>  connMap=new HashMap<String,Connection>();
		for(int i=0;i<str_Conn.length;i++){
			connMap.put(str_Conn[i],ItemsJdbcConnection.getConnetction(
					ConfigUtil.getValue(str_Conn[i])));
		}  
		
		Set<Entry<String, Connection>> entry=connMap.entrySet();
		Iterator<Entry<String, Connection>> iterator=entry.iterator();
		System.out.println("Get SQL MATCHING DB.....");
		
		
		
		while(iterator.hasNext()){
			Entry<String, Connection> entity=iterator.next(); 
			System.out.println(entity.getKey()+":"+entity.getValue()); 
			sql="";
			if(entity.getKey().equals(Items.YIHAODIAN)){
				market=Items.YIHAODIAN_STRING; 
				if(!value1.trim().equals("")){ 
					sql="select * from ITMmain where Id in ("+value1+");";
				}else{
					continue;
				} 
			}else if(entity.getKey().equals(Items.JINGDONG)){
				market=Items.JINGDONG_STRING; 
				if(!value2.trim().equals("")){ 
					sql="select * from ITMmain where Id in ("+value2+");";
				} else{
					continue;
				} 
			} else if(entity.getKey().equals(Items.AMAZON)){ 
				market=Items.AMAZON_STRING;
				if(!value3.trim().equals("")){ 
					sql="select * from ITMmain where Id in ("+value3+");";
				}else{
					continue;
				} 
			}else if(entity.getKey().equals(Items.COO8)){ 
				market=Items.COO8_STRING;
				if(!value4.trim().equals("")){ 
					sql="select * from ITMmain where Id in ("+value4+");";
				}else{
					continue;
				} 
			} 
			
			System.out.println("SQL:"+sql);
			System.out.println("Try to get data from db using sql statement........");
//			System.out.println(sql); 
//			if(sql.equals("")){ 
//				System.out.println("**********No data in "+market+" db************");
//				continue; 
//			}  
			
			System.out.println("Try to get ResultSet from db using "+market+"........");
		 
			ResultSet rs  =ItemsJdbcConnection.getResultSet(entity.getValue(), sql);
			try {
				while(rs.next()){ 
					lists.add( 
//						Items(int id,int itemId,int marketId,String title,double marketPrice,double price){
						new Items(
							Integer.parseInt(rs.getString("Id")),  
							rs.getString("ITMstore"),
							rs.getString("ITMid"),
							rs.getString("ITMtitle"),
							Double.parseDouble(rs.getString("ITMmprice")),
							Double.parseDouble(rs.getString("ITMprice"))
							,true)
					); 
					System.out.println(market);
				} 
				rs.close();
				entity.getValue().close(); 
					
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
				"<th>价格</th>" +
				"<th>市场价</th> " +
				"<th>折扣</th> " +
				"</tr>" +
				"</thead>"); 
		System.out.println("商品总数"+lists.size());
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
//			Items(int id,int itemId,int marketId,String title,double marketPrice,double price){
			for(Items list:lists){ 	
				String url="";
				String marketName="";
					pw.println(
					"<tbody>" +
					"<tr>" +
						"<td><a title=\"title\" href='"+list.getItemId()+"'>"+list.getTitle()+"-"+list.getId()+"</a></td>" +
						"<td>"+list.getMarketName()+"-"+list.getMarketId()+"</td>" +
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
			pw.println("<a href=\"#\" class=\"number current\" title=\"1\">1</a> <a href=\"#\" class=\"number\" title=\"2\">2</a> ");
			pw.println("<a href=\"#\"  class=\"number\" title=\"3\">3</a> " +
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
		
}		
 