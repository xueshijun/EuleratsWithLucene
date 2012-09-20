package com.eulerats.lucene;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.lucene.queryParser.ParseException;
 

public class Demo { 
	 
	public static void main(String[] args) throws IOException, SQLException, ParseException {
		
//		Index.create(); 
//		Index.search("水");
		Index.search("水       资生堂".split("[ |,|+|，]+"));
		
		
 
	} 
}
