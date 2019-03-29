package com.main;

import com.databaseOperation.ConnectionUnify;

/**
 * 
 * @author xig
 *
 * description: 系统入口
 * 
 * 
 */

public class BookRentalManagementSystem {

	public static void main(String[] args) {
		new BookRentalManagementSystem();
	}
	
	public BookRentalManagementSystem() {
		
		// 连接数据库
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
		init();
	}
	
	private void init() {
		
		
	}

}
