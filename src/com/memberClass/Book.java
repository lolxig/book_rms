package com.memberClass;

/**
 * 
 * @author xig
 *
 * desciption: 书籍类，保存书籍信息
 * 		
 * 				属性：书号，书名，作者，出版社，库存量
 *
 */

public class Book {
	
	private String id;			// 书号
	private String name;		// 书名
	private String author;		// 作者
	private String press;		// 出版社
	private String stock;		// 库存量
	
	public  Book() {
		
	}
	public Book(String id, String name, String author, String press, int stock) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.press = press;
		this.stock = String.valueOf(stock);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}

}