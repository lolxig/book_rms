package com.memberClass;

/**
 * @author xig
 *	
 * description: 会员类，保存会员信息
 * 				
 * 				属性：ID，名字，手机号
 *
 */

public class Member {
	
	private String id;					// 会员号
	private String name;				// 会员名
	private String phone;				// 手机号
	
	public Member() {
		
	}
	public Member(String id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}