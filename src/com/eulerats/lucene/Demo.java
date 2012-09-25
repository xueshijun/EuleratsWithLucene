package com.eulerats.lucene;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.lucene.queryParser.ParseException;

import com.utils.PageArgs;
 

public class Demo { 
	 
	public static void main(String[] args) throws IOException, SQLException, ParseException {
		
		Index.create(); 
		Index.search("水");
//		Index.search("水       资生堂".split("[ |,|+|，]+"));
//		PageArgs pag=new PageArgs().getPageArgs("jingdong");
//		System.out.println(pag.getPageSize());
//		double d1=0.989;
//		double d2=0.239;
//		System.out.println((d2/d1)*100/10);
	} 
}
