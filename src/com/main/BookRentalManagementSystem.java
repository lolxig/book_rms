package com.main;

import java.sql.SQLException;

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
	
	// ���
	public BookRentalManagementSystem() {		
		
		// �������ݿ�
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
		// ��ʼ��
		init();
	}
	
	// ��ʼ��
	private void init() {
		
		
	}
	
	
	// �˳�ϵͳ
	private void exitSystem() {
		try {
			ConnectionUnify.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
