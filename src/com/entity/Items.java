package com.entity;

public class Items{
	public  static final int YIHAODIAN_INT=1;
	public  static final int JINGDONG_INT=2;
	public  static final int AMAZON_INT=3;
	public  static final int COO8_INT=3;

	
	//与配置文件中DBNAMES的对应
	public  static final String JINGDONG="JINGDONG";
	public  static final String YIHAODIAN="YIHAODIAN";
	public  static final String AMAZON="AMAZON";  
	public  static final String COO8="COO8";
	
	//用于索引的分类
	public  static final String YIHAODIAN_STRING="一号店YIHAODIAN";
	public  static final String JINGDONG_STRING="京东JINGDONG";
	public  static final String AMAZON_STRING="亚马逊Amazon";  
	public  static final String COO8_STRING="酷吧coo8"; 
		
	
	private String marketName; 
	private String marketId;
	private int id;
	private String itemId;
	
	private String url;
	private String title;
	private double marketPrice;
	private double price;
	public Items(String marketName,int id){
		this.marketName=marketName;
		this.id=id;
	}
	public Items(String market,String url,String title,double marketPrice,double price){
		this.marketName=marketName;
		this.url=url;
		this.title=title;
		this.marketPrice=marketPrice;
		this.price=price; 
	}
	public Items(int id,String marketName,String url,String title,double marketPrice,double price){
		this.id=id;
		this.marketName=marketName;
		this.url=url;
		this.title=title;
		this.marketPrice=marketPrice;
		this.price=price; 
	}
	
	/**ITMmain*/
	public Items(int id,String marketId,String itemId,String title,double marketPrice,double price,boolean bol){
		this.id=id;
		this.itemId=itemId; 
		this.marketId=marketId;
		this.title=title;
		this.marketPrice=marketPrice;
		this.price=price; 
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the marketPrice
	 */
	public double getMarketPrice() {
		return marketPrice;
	}
	/**
	 * @param marketPrice the marketPrice to set
	 */
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString(){
		return "title"+this.title+" url"+this.url+" marketPrice"+this.marketPrice+" price"+this.price;
			
	}
 
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	} 
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Items){ 
			return this.id==((Items)obj).id;
		}
		return false; 
	} 
	@Override
	public int hashCode() { 
		return this.id;
	}
	 
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the marketName
	 */
	public String getMarketName() {
		return marketName;
	}
	/**
	 * @param marketName the marketName to set
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	/**
	 * @return the marketId
	 */
	public String getMarketId() {
		return marketId;
	}
	/**
	 * @param marketId the marketId to set
	 */
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	 
} 