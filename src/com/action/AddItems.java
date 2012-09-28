package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ItemsJdbcConnection;

public class AddItems extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static final int YIHAODIAN=1;
	public  static final int JINGDONG=2;
	public  static final int AMAZON=3; 
		
	protected void service(HttpServletRequest request,HttpServletResponse response){
		try {
			
			request.setCharacterEncoding("utf-8");
			 
			response.setContentType("text/html;charset=utf-8");
			
			ItemsJdbcConnection mysql=new ItemsJdbcConnection();
			Connection conn=null; 
			
			String sql="insert into Items(Url,Title,MarketPrice,Price)" +
					"values(?,?,?,?)";
			switch(Integer.parseInt(request.getParameter("market"))){
				case YIHAODIAN:
					conn=mysql.getConnetction("yihaodian");
					break;
				case JINGDONG:
					conn=mysql.getConnetction("jingdong");
					break;
				case AMAZON:
					conn=mysql.getConnetction("amazon");
					break;
			} 
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,request.getParameter("Url"));
			pstmt.setString(2,request.getParameter("Title"));
			pstmt.setDouble(3,Double.parseDouble(request.getParameter("MarketPrice")));
			pstmt.setDouble(4,Double.parseDouble(request.getParameter("Price"))); 
			pstmt.close();
			
			
			PrintWriter pw=response.getWriter(); 
			pw.println("Insert Data Succesfully!"+"</br>"); 
			pw.println(request.getParameter("Url")+"</br>");
			pw.println(request.getParameter("Title")+"</br>");
			pw.println(request.getParameter("MarketPrice")+"</br>");
			pw.println(request.getParameter("Price")+"</br>"); 
			pw.println("<a href='list'>查看列表</a>");
			pw.close();  
			
			
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	} 
}
