package com.memberClass;

/**
 * @author xig
 *	
 * description: ��Ա�࣬�����Ա��Ϣ
 * 				
 * 				���ԣ�ID�����֣��ֻ���
 *
 */

public class Member {
	
	private String id;					// ��Ա��
	private String name;				// ��Ա��
	private String phone;				// �ֻ���
	
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