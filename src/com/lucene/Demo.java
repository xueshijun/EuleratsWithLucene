package com.lucene;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.lucene.queryParser.ParseException;

import com.dao.ItemsJdbcConnection;
import com.utils.ConfigUtil;
 

public class Demo { 
	 
	public static void main(String[] args) throws IOException, SQLException, ParseException {
		
		Index.create(); 
		Index.search("苹果");
//		Index.search("水       资生堂".split("[ |,|+|，]+"));
//		PageArgs pag=new PageArgs().getPageArgs("jingdong");
//		System.out.println(pag.getPageSize());
//		double d1=0.989;
//		double d2=0.239;
//		System.out.println((d2/d1)*100/10);
//		
//		String[] str_Conn=ConfigUtil.getValue("DBNAMES").split(","); 
//		
//		Map<String,Connection>  connMap=new HashMap<String,Connection>();
//		for(int i=0;i<str_Conn.length;i++){
//			connMap.put(str_Conn[i],ItemsJdbcConnection.getConnetction(
//					ConfigUtil.getValue(str_Conn[i])));
//		} 
//		
//		Set<Entry<String, Connection>> entry=connMap.entrySet();
//		Iterator<Entry<String, Connection>> iter=entry.iterator();
//		while(iter.hasNext()){
//			Entry<String, Connection> ite=iter.next(); 
//			System.out.println(ite.getKey()+":"+ite.getValue()); 
//		} 
		
	 
	} 
}
