package com.databaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author xig
 * 
 * 结构更改，统一管理数据库连接
 *
 */

public class ConnectionUnify {
	
	public static Connection connection = null;
	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/book_rms?useUnicode=true&characterEncoding=GBK";
		String username = "root";
		String password = "xigua123";
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Debug: Error loading Mysql Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Debug: Error connect mysql server!");
			e.printStackTrace();
		}
		System.out.println("Debug: MySQL link success.");
		return conn;
	}

}
