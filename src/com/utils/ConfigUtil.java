package com.utils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class ConfigUtil { 
	private static Properties props=new Properties();
	static{
		ClassLoader loader=ConfigUtil.class.getClassLoader();
		InputStream in=
			loader.getResourceAsStream("com/utils/config.properties");
		try{
			props.load(in);	 
		}catch(Exception ex){}
	}
	
	public static String getValue(String key){
		return props.getProperty(key);
	}
	public  static void main(String [] args){ 
		System.out.println(getValue("driver"));
		System.out.println(getValue("dbuser"));
		System.out.println(getValue("dbpwd"));
		System.out.println(getValue("url"));
		System.out.println(getValue("JINGDONG"));
		System.out.println(getValue("YIHAODIAN"));
		System.out.println(getValue("AMAZON"));
		System.out.println(
				Arrays.toString(getValue("DBNAMES").split(","))); 
	}
}
