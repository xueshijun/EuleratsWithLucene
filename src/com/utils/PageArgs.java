package com.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dao.ItemsJdbcConnection;

public class PageArgs {
	private int currentPage;
	private int pageSize;
	private long maxPage;
	private int prePage;
	private int nextPage;
	
	public void setPageCount(int currentPage){
		this.currentPage=currentPage;
		this.prePage=currentPage-1<=1?1:currentPage-1;
		this.nextPage=(int)(currentPage+1>=maxPage?maxPage:currentPage+1);
	}
	
	public PageArgs getPageArgs(String strDB){
		PageArgs pag=null;
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=ItemsJdbcConnection.getConnetction(strDB);
		try{
			String sql="select count(*) from Items";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				int count=rs.getInt(1);
				pag=new PageArgs();
				pag.setPageSize(pageSize);
				pag.setMaxPage((count+pageSize-1)/pageSize);
				pag.setPageCount(count);
			} 
		}catch(Exception ex){
			System.err.println("Paging occured a problem:"+ex.toString());
		}
		return pag; 
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the maxPage
	 */
	public long getMaxPage() {
		return maxPage;
	}

	/**
	 * @param maxPage the maxPage to set
	 */
	public void setMaxPage(long maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * @return the prePage
	 */
	public int getPrePage() {
		return prePage;
	}

	/**
	 * @param prePage the prePage to set
	 */
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	/**
	 * @return the nextPage
	 */
	public int getNextPage() {
		return nextPage;
	}

	/**
	 * @param nextPage the nextPage to set
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}
