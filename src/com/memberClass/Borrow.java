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
	private String memberName;		// 会员名
	private String bookId;			// 书籍号
	private String bookName;		// 书名
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	
}