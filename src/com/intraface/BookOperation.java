package com.intraface;

import java.sql.*;

import com.databaseOperation.ConnectionUnify;
import com.databaseOperation.JDBCOpetation;
import com.memberClass.Book;

/**
 * 
 * @author xig
 * 
 * description: �鼮����ģ��ӿڣ������ӿ�, ����鼮��ɾ���鼮
 * 
 * ��������㣺��������ʱ���������룬���������ݿ�Ĳ����м���  ?useUnicode=true&characterEncoding=GBK  ����
 * 
 * ˵����
 * 		ɾ���鼮ʱ���������������(id, name)��ʣ�µĲ������Բ���
 * 
 * note: ��ͨ������
 * complete time: 2019-3-27 11:32:22
 * 
 * *****************************************************************************************************
 * 
 * note: �ṹ���������ݿ�����ͳһ����
 * 
 * time: 2019-3-29 17:06:00
 * 
 */

public class BookOperation {
	
	private Book book = null;
	private JDBCOpetation jdbcOpetation = null;
//	private Connection connection = null;
	
	// ���캯��
	public BookOperation() {
//		book = new Book();
//		connection = jdbcOpetation.getConnection();
		jdbcOpetation = new JDBCOpetation() {
			
			@Override
			public void update() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void select() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insert() {
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				String sql = "insert into book(name, author, press, stock) values(?, ?, ?, ?)";
				PreparedStatement pstmt;
				
				try {
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.setString(1, book.getName());
					pstmt.setString(2, book.getAuthor());
					pstmt.setString(3, book.getPress());
					pstmt.setString(4, book.getStock());
					pstmt.executeUpdate();
					System.out.println("Debug: Insert success.");
					pstmt.close();
//					connection.close();	
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
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
//				} catch (ClassNotFoundException e) {
//					System.out.println("Debug: Error loading Mysql Driver!");
//					e.printStackTrace();
//				} catch (SQLException e) {
//					System.out.println("Debug: Error connect mysql server!");
//					e.printStackTrace();
//				}
//				System.out.println("Debug: MySQL link success.");
//				return conn;
//			}
			
			@Override
			public void delete() {
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				String sql = "delete from book where id='" + book.getId() + "' and name='" + book.getName() + "'";
				PreparedStatement pstmt;
			
				try {
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					System.out.println("Debug: Delete success.");
					pstmt.close();
//					connection.close();  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
	
	// ����鼮
	public void addBook(Book book) {
		this.book = book;
		this.jdbcOpetation.insert();
	}
	
	// ɾ���鼮
	public void deleteBook(Book book) {
		this.book = book;
		this.jdbcOpetation.delete();
	}
	
}