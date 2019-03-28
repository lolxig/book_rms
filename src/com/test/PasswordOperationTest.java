package com.test;

import com.intraface.PasswordOperation;

public class PasswordOperationTest {

	public static void main(String[] args) {
		
		PasswordOperation po = new PasswordOperation();
		System.out.println("password: " + po.getPassword());
		
		po.setPassword("123456");
		System.out.println("password: " + po.getPassword());
	}

}
