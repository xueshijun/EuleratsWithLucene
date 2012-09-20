package com.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MySql {
 
 
	/**
	 * 1.String url = "jdbc:mysql://localhost:3306/"+strDBName+"?useUnicode=true&characterEncoding=utf8";
	 * DriverManager.getConnection(url, user, password);
//        	
	 * 2.String url = "jdbc:mysql://localhost:3306/"+strDBName+"?user=root&password=xueshijun&unicode=true&charachterEncoding=utf8";
	 * DriverManager.getConnection(url);

	 * 
	 * 
	 * @param strDBName
	 * @return
	 */
	public   Connection getConnetction(String strDBName) {
		String driver = "com.mysql.jdbc.Driver";  
    	// URLָ��Ҫ���ʵ����ݿ���
//    	String url = "jdbc:mysql://localhost:3306/stu?characterEncoding=utf8";
		String url = "jdbc:mysql://localhost:3306/"+strDBName+"?useUnicode=true&characterEncoding=utf8";//(ע�⣺��Ҫ�����κοո񣬷������)
//		String url = "jdbc:mysql://localhost:3306/"+strDBName+"?user=root&password=xueshijun&unicode=true&charachterEncoding=utf8"; 
    	 

// 		MySQL����ʱ���û��� 
    	String user = "root";
//    	String user = "xueshijun"; 
// 		Java����MySQL����ʱ������ 
    	String password = "xueshijun"; 
		try
        { 
        	// ������������ 
        	Class.forName(driver); 
        	// �������ݿ� 
        	return DriverManager.getConnection(url, user, password);
//        	return DriverManager.getConnection(url);
        } 
        catch(Exception e) 
        { 
            e.printStackTrace(); 
        }
		return null;  
	}
	
	 
	
    /**
     * ִ��SQL���
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
     * ���ؽ����
     * */ 
	public ResultSet getResultSet(Connection conn,String sql){ 
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