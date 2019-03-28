package com.memberClass;

/**
 * @author xig
 * 
 * description: 借阅类，保存借阅信息
 * 	
 * 				属性：会员号，书籍号
 *
 */

public class Borrow {
	
	private String memberId;		// 会员号
	private String bookId;			// 书籍号
	
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