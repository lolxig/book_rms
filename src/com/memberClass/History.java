package com.memberClass;

/**
 * 
 * @author xig
 * 
 * description: ��ʷ��¼�࣬������ʷ��¼��Ϣ
 * 
 * 				���ԣ����ڣ���Ա���鼮
 *
 */

public class History {
	
	String date;			// ����
	String memberId;		// ��Ա
	String bookId;			// �鼮
	
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