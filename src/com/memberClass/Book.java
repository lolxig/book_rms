package com.memberClass;

/**
 * 
 * @author xig
 *
 * desciption: �鼮�࣬�����鼮��Ϣ
 * 		
 * 				���ԣ���ţ����������ߣ������磬�����
 *
 */

public class Book {
	
	private String id;			// ���
	private String name;		// ����
	private String author;		// ����
	private String press;		// ������
	private String stock;		// �����
	
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