package com.main;

import com.databaseOperation.ConnectionUnify;

/**
 * 
 * @author xig
 *
 * description: ϵͳ���
 * 
 * 
 */

public class BookRentalManagementSystem {

	public static void main(String[] args) {
		new BookRentalManagementSystem();
	}
	
	public BookRentalManagementSystem() {
		
		// �������ݿ�
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
		init();
	}
	
	private void init() {
		
		
	}

}
