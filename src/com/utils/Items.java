package com.utils;

public 
class Items{
	public  static final int YIHAODIAN_INT=1;
	public  static final int JINGDONG_INT=2;
	public  static final int AMAZON_INT=3; 
	
	public  static final String YIHAODIAN_STRING="一号店YIHAODIAN";
	public  static final String JINGDONG_STRING="京东JINGDONG";
	public  static final String AMAZON_STRING="亚马逊Amazon"; 
	
	private String market; 
	private int id;
	private String url;
	private String title;
	private double marketPrice;
	private double price;
	public Items(String market,int id){
		this.market=market;
		this.id=id;
	}
	public Items(String market,String url,String title,double marketPrice,double price){
		this.market=market;
		this.url=url;
		this.title=title;
		this.marketPrice=marketPrice;
		this.price=price; 
	}
	public Items(int id,String market,String url,String title,double marketPrice,double price){
		this.id=id;
		this.market=market;
		this.url=url;
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
	 * @return the market
	 */
	public String getMarket() {
		return market;
	}
	/**
	 * @param market the market to set
	 */
	public void setMarket(String market) {
		this.market = market;
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
} 