package com.memberClass;

/**
 * 
 * @author xig
 * 
 * description: 历史记录类，保存历史记录信息
 * 
 * 				属性：日期，会员，书籍
 *
 */

public class History {
	
	String date;			// 日期
	String memberId;		// 会员
	String bookId;			// 书籍
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
}