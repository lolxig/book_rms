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
	String type;			// 操作类型
	String memberId;		// 会员
	String memberName;		// 会员名
	String bookId;			// 书籍ID
	String bookName;		// 书名
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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