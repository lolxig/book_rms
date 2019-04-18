package com.main;

import java.sql.SQLException;

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
	
	// 入口
	public BookRentalManagementSystem() {		
		
		// 连接数据库
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
		// 初始化
		init();
	}
	
	// 初始化
	private void init() {
		
		
	}
	
	
	// 退出系统
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
