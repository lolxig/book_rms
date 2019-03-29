package com.intraface;

import java.sql.*;

import com.databaseOperation.ConnectionUnify;
import com.databaseOperation.JDBCOpetation;
import com.memberClass.Password;

/**
 * 
 * @author xig
 * 
 *  
 * description: Password操作接口，对内部提供两个接口，一个获取密码，一个是设置密码
 * 
 * note: 已通过测试
 * complete time: 2019-3-26 22:21:41
 * 
 * ********************************************************************************
 * 
 * note: 结构调整，数据库连接统一管理
 * time: 2019-3-29 17:07:31
 * 
 */


public class PasswordOperation {

	private Password password = null;
	private JDBCOpetation jdbcOpetation = null;
//	private Connection connection = null;

	// 构造函数
	public PasswordOperation() {
		password = new Password();
		jdbcOpetation = new JDBCOpetation() {
			
			@Override
			public void update() {
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				String sql = "update password set password='" + password.getPassword() + "' where id=1";
				PreparedStatement pstmt;
				
				try {
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					System.out.println("Debug: Update success.");
					pstmt.close();
//					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void select() {
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				String sql = "select * from password";
				PreparedStatement pstmt;
				
				try {
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					password.setPassword(rs.getString(2));
					pstmt.close();
//					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("Debug: Select success.");
			}
			
			@Override
			public void insert() {
				// TODO Auto-generated method stub
				
			}
			
//			@Override
//			public Connection getConnection() {
//				// TODO Auto-generated method stub
//				String driver = "com.mysql.jdbc.Driver";
//				String url = "jdbc:mysql://localhost:3306/book_rms?useUnicode=true&characterEncoding=GBK";
//				String username = "root";
//				String password = "xigua123";
//				Connection conn = null;
//				
//				try {
//					Class.forName(driver);
//					conn = (Connection) DriverManager.getConnection(url, username, password);
//					System.out.println("Debug: MySQL link success.");
//				} catch (ClassNotFoundException e) {
//					System.out.println("Debug: Error loading Mysql Driver!");
//					e.printStackTrace();
//				} catch (SQLException e) {
//					System.out.println("Debug: Error connect mysql server!");
//					e.printStackTrace();
//				}
//				return conn;
//			}
			
			@Override
			public void delete() {
				// TODO Auto-generated method stub
				
			}
		};
		jdbcOpetation.select();
	}
	
	// 获取密码
	public String getPassword() {
		this.jdbcOpetation.select();
		return password.getPassword();
	}
	
	// 设置密码
	public void setPassword(String password) {
		this.password.setPassword(password);
		this.jdbcOpetation.update();
	}

}