package com.intraface.infoSearch;

import java.util.ArrayList;
import com.memberClass.Book;

public class InfoSearchOfMember {
	
	private String memberId;				// 会员号
	private String memberName;				// 会员名
	private String memberPhone;				// 会员手机号
	private ArrayList<Book> bookSlip;		// 会员借书表
	
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
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public ArrayList<Book> getBookSlip() {
		return bookSlip;
	}
	public void setBookSlip(ArrayList<Book> bookSlip) {
		this.bookSlip = bookSlip;
	}
	
}
