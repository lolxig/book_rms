package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.databaseOperation.JDBCOpetation;

public class DataTest {

	private static JDBCOpetation jdbcOpetation = null;
	private static Connection connection = null;
	private static String sql = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		jdbcOpetation = new JDBCOpetation() {
			
			@Override
			public void update() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void select() {
				// TODO Auto-generated method stub
				connection = jdbcOpetation.getConnection();
				sql = "select * from history";
				PreparedStatement psmt = null;
				
				try {
					psmt = (PreparedStatement) connection.prepareStatement(sql);
					ResultSet rs = psmt.executeQuery();
					
//					rs.next();
					
//					System.out.println(rs.getString(1));
					
					while (rs.next()) {
						String tmp = rs.getString(1);
						char tmpChar[] = new char[40];
						
						tmpChar = tmp.toCharArray();
						
//						System.out.println(tmpChar);
						
						tmpChar[19] = '\0';
						tmp = new String(tmpChar, 0, 19);
						
						System.out.println(tmp);
					}
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
			}
			
			@Override
			public void insert() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Connection getConnection() {
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
			
			@Override
			public void delete() {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		jdbcOpetation.select();
		
		
	}

}
