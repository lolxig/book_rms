package com.intraface.infoSearch;

import java.util.ArrayList;
import com.memberClass.Book;

public class InfoSearchOfMember {
	
	private String memberId;				// ��Ա��
	private String memberName;				// ��Ա��
	private String memberPhone;				// ��Ա�ֻ���
	private ArrayList<Book> bookSlip;		// ��Ա�����
	
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
