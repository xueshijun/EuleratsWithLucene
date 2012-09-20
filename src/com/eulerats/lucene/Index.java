package com.eulerats.lucene;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.utils.Items;
import com.utils.MySql;

public class Index {
	public Index(){}
	
	public final static String INDEX_STORE_PATH="C://AllIndex"+File.separator;
	
	private static Document getDocument(String market,String id,String title)
	throws SQLException{  
		Document doc=new Document(); 
			doc.add(
					new Field("ID",id,Field.Store.YES,Field.Index.NO));
			doc.add(
					new Field("Market",market,Field.Store.YES,Field.Index.ANALYZED)); 
			doc.add(
					new Field("Title",title,Field.Store.YES,Field.Index.ANALYZED));
		return doc;
	} 

	
	public static void create() throws IOException, SQLException{ 
		System.out.println("begin to create index............");
		long start=System.currentTimeMillis(); 
		
		Directory dir=FSDirectory.open(new File(INDEX_STORE_PATH));	/**IOException*/
			
		IndexWriter writer=new IndexWriter(dir,
				 new IKAnalyzer(),
				true,IndexWriter.MaxFieldLength.UNLIMITED);
	
		String sql="select * from Items"; 
		MySql mysql=new MySql();
		
		Connection [] conn=new Connection[]{
				mysql.getConnetction("yihaodian"),
				mysql.getConnetction("jingdong"),
				mysql.getConnetction("amazon")
				}; 
		
		try {  
			
			for(int i=0;i<conn.length;i++){	
				String market = "";
				switch(i){
				case 0:
					market=Items.YIHAODIAN_STRING; 
					break;
				case 1:
					market=Items.JINGDONG_STRING;
					break;
				case 2:
					market=Items.AMAZON_STRING;
					break;
				} 
				ResultSet rs=mysql.getResultSet(conn[i], sql);  
				while(rs.next()){ 
					writer.addDocument(
							getDocument(market,
										rs.getString("Id"),
										rs.getString("Title")));   
					System.out.println(market+"  "+rs.getString("Id")+"  "+rs.getString("Title"));
				} 
				rs.close();
				conn[i].close(); 
				System.out.println(market+"  has   finished!");
			}
		}catch(Exception ex){
			
		} 	 
		long end=System.currentTimeMillis();
		System.out.println("All has finished!");
		System.out.println("Creating index cost "+(end-start)+" ms");
		writer.close();
	}







	
	public static List<Items> search(String str) throws IOException, ParseException{
 
		Directory dir=FSDirectory.open(new File(INDEX_STORE_PATH));
		 
		IndexSearcher searcher=new IndexSearcher(dir);  
		
		 List<Items> lists=new ArrayList<Items>();
		
	//	QueryParser parser=new QueryParser(Version.LUCENE_30,
	//			key,//ItemNumber,ItemName,ItemType,MarketPrice
	//			new StandardAnalyzer(Version.LUCENE_30));
	//	Query query=parser.parse(value);/**ParseException*/ 
		
		BooleanQuery query=new BooleanQuery(); 
		TermQuery termQuery1=new TermQuery(new Term("Market",str)); 
		TermQuery termQuery2=new TermQuery(new Term("Title",str)); 
		query.add(termQuery1,BooleanClause.Occur.SHOULD);
		query.add(termQuery2,BooleanClause.Occur.SHOULD);	
	
		
		
		long start=System.currentTimeMillis();
		TopDocs hits=searcher.search(query,100);
		System.out.println("totalHits:"+hits.totalHits);
		long end=System.currentTimeMillis();
		 
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=searcher.doc(scoreDoc.doc);
			
			lists.add(new Items(doc.get("Market"),Integer.parseInt(doc.get("ID")))); 
			
			System.out.print(doc.get("ID")+" "); 
			System.out.print(doc.get("Title")+" ");
			System.out.print(doc.get("Market")+" \n"); 
		}
		System.out.println("found "+hits.totalHits+" matches in "+(end-start)+"ms"); 
		searcher.close();
//		for(Items list:lists){
//			System.out.println(list.getMarket()+"--"+list.getId());
//		} 
		Collections.sort(lists,new Comparator<Object>(){ 
			public int compare(Object o1, Object o2) { 
				return Collator.getInstance(Locale.CHINESE).compare(
						((Items)o1).getMarket()
						,((Items)o2).getMarket()); 
			} 
		});
//		for(Items list:lists){
//			System.out.println(list.getMarket()+"--"+list.getId());
//		}
		return lists;
	}
	
	public static List<Items> search(String [] str) throws IOException, ParseException{
		 
		Directory dir=FSDirectory.open(new File(INDEX_STORE_PATH));
		 
		IndexSearcher searcher=new IndexSearcher(dir);  
		
		 List<Items> lists=new ArrayList<Items>();
		
	//	QueryParser parser=new QueryParser(Version.LUCENE_30,
	//			key,//ItemNumber,ItemName,ItemType,MarketPrice
	//			new StandardAnalyzer(Version.LUCENE_30));
	//	Query query=parser.parse(value);/**ParseException*/ 
		
		BooleanQuery query=new BooleanQuery(); 
		TermQuery termQuery;
		for(int i=0;i<str.length;i++){ 
			termQuery=new TermQuery(new Term("Title",str[i]));  
			query.add(termQuery,BooleanClause.Occur.MUST); 
			
			termQuery=new TermQuery(new Term("Market",str[i]));  
			query.add(termQuery,BooleanClause.Occur.SHOULD);
		}
	
		
		
		long start=System.currentTimeMillis();
		TopDocs hits=searcher.search(query,100);
		System.out.println("totalHits:"+hits.totalHits);
		long end=System.currentTimeMillis();
		 
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=searcher.doc(scoreDoc.doc);
			
			lists.add(new Items(doc.get("Market"),Integer.parseInt(doc.get("ID")))); 
			
			System.out.print(doc.get("ID")+" "); 
			System.out.print(doc.get("Title")+" ");
			System.out.print(doc.get("Market")+" \n"); 
		}
		System.out.println("found "+hits.totalHits+" matches in "+(end-start)+"ms"); 
		searcher.close();
//		for(Items list:lists){
//			System.out.println(list.getMarket()+"--"+list.getId());
//		} 
		Collections.sort(lists,new Comparator<Object>(){ 
			public int compare(Object o1, Object o2) { 
				return Collator.getInstance(Locale.CHINESE).compare(
						((Items)o1).getMarket()
						,((Items)o2).getMarket()); 
			} 
		});
//		for(Items list:lists){
//			System.out.println(list.getMarket()+"--"+list.getId());
//		}
		return lists;
	}
}
