package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.utils.ConfigUtil;
public class ItemsJdbcConnection {
 
// 
//	/**
//	 * 1.String url = "jdbc:mysql://localhost:3306/"+strDBName+"?useUnicode=true&characterEncoding=utf8";
//	 * DriverManager.getConnection(url, user, password);
////        	
//	 * 2.String url = "jdbc:mysql://localhost:3306/"+strDBName+"?user=root&password=xueshijun&unicode=true&charachterEncoding=utf8";
//	 * DriverManager.getConnection(url);
//
//	 * 
//	 * 
//	 * @param strDBName
//	 * @return
//	 */
//	public  static Connection getConnetction(String strDBName) {
//		String driver = "com.mysql.jdbc.Driver";  
//    	// URL指向要访问的数据库名
////    	String url = "jdbc:mysql://localhost:3306/stu?characterEncoding=utf8";
//		String url = "jdbc:mysql://localhost:3306/"+strDBName+"?useUnicode=true&characterEncoding=utf8";//(注意：不要出现任何空格，否则出错)
////		String url = "jdbc:mysql://localhost:3306/"+strDBName+"?user=root&password=xueshijun&unicode=true&charachterEncoding=utf8"; 
//    	 
//
//// 		MySQL配置时的用户名 
//    	String user = "root";
////    	String user = "xueshijun"; 
//// 		Java连接MySQL配置时的密码 
//    	String password = "root3306"; 
//		try
//        { 
//        	// 加载驱动程序 
//        	Class.forName(driver); 
//        	// 连接数据库 
//        	return DriverManager.getConnection(url, user, password);
////        	return DriverManager.getConnection(url);
//        } 
//        catch(Exception e) 
//        { 
//            e.printStackTrace(); 
//        }
//		return null;  
//	}
	
	public  static Connection getConnetction(String strDBName) {
		Connection conn = null;	
		try {
        	// 加载驱动程序 
        	Class.forName(ConfigUtil.getValue("driver")); 
        	System.out.println(ConfigUtil.getValue("driver"));
        	// 连接数据库  
        	conn=DriverManager.getConnection(
						ConfigUtil.getValue("url")+strDBName+"?useUnicode=true&characterEncoding=utf8",
						ConfigUtil.getValue("dbuser"),
						ConfigUtil.getValue("dbpwd")); 
        	System.out.println(ConfigUtil.getValue("url")+strDBName+"?useUnicode=true&characterEncoding=utf8");
        	System.out.println(ConfigUtil.getValue("dbuser"));
        	System.out.println(ConfigUtil.getValue("dbpwd"));
			} catch (SQLException e) { 
				System.out.println("SQL连接错误！"+e.toString());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("获取配置文件连接出错！"+e.toString());
				e.printStackTrace();
			}   
			return conn;
	}
	
	
    /**
     * 执行SQL语句
     * */
    public int executeSql(Connection conn,String sql) 
    { 
    	Statement statement=null;
    	int result=0;
    	try {
    		if(!conn.isClosed()) { 
    			statement=conn.createStatement(
    					ResultSet.TYPE_SCROLL_SENSITIVE,
    					ResultSet.CONCUR_UPDATABLE); 
    			 result=statement.executeUpdate(sql);
    			return result;
			}
		} catch (SQLException e) {  
	        e.printStackTrace(); 
	        return result; 
		} 
		finally {
			if(statement!=null) {
				try {
					statement.close();
				}catch (SQLException ex) {
		            // ignore
					ex.printStackTrace();
					return result; 
		        } 
			}
		}
		return  result;
    } 

    
    /**
     * 返回结果集
     * */ 
	public static ResultSet getResultSet(Connection conn,String sql){ 
    	Statement statement=null;
    	ResultSet result=null;
    	try
        { 
        	statement=conn.createStatement(
        			ResultSet.TYPE_SCROLL_SENSITIVE,
        			ResultSet.CONCUR_READ_ONLY); 
            result=statement.executeQuery(sql);
            return result; 
        } 
        catch(Exception e){ 
            e.printStackTrace(); 
            return result; 
        } 
    }  
}
