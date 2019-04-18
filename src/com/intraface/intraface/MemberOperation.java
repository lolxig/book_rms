package com.intraface.intraface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.databaseOperation.ConnectionUnify;
import com.databaseOperation.JDBCOpetation;
import com.memberClass.Book;
import com.memberClass.Member;

/**
 * 
 * @author xig
 *
 * description: ��Ա����ģ��ӿڣ���Ϊ�ĸ��ӿڣ����ֱܷ���  ������ע�������顢����
 * 
 * �������̣���������Ϣ��¼�ڽ��ı�ͽ�����ʷ�У�Ȼ��Ը��鼮��stock��һ
 * �������̣���������Ϣ��¼�ڽ��ı�ͽ�����ʷ�У�Ȼ��Ը��鼮��stock��һ
 * 
 * ˵����
 * 		����ʱ������������(name, phone)���ɣ���Աid�Զ�����
 * 		ע��ʱ���������������(id, name)��ʣ�µ�phone�������Բ���
 * 
 * 		����ʱ��������ĸ�����(��Աid����Աname, �鼮id, �鼮name)��ʣ�µĲ������Բ���
 * 		����ʱ��������ĸ�����(��Աid����Աname, �鼮id, �鼮name)��ʣ�µĲ������Բ���
 * 
 * note: ����ͨ��
 * 
 * complete time: 2019-3-27 17:15:26
 * 
 * ******************************************************************************************
 * 
 * 2019-3-27 21:36:40
 * 
 * �޸ģ�
 * 		�Խ��ı�����޸ģ��������not null�����ԣ��ֱ���member_name, book_name
 * 		�Խ�����ʷ������޸ģ��������not null�����ԣ��ֱ���member_name, book_name
 * 
 * note: ����ͨ��
 * complete time: 2019-3-27 21:44:04
 * 
 * ******************************************************************************************
 * 
 * note: �ṹ���������ݿ�����ͳһ����
 * 
 * time: 2019-3-29 17:06:57
 * 
 */

public class MemberOperation {
	
	private Member member = null;
	private Book book = null;
	private JDBCOpetation jdbcOpetation = null;
//	private Connection connection = null;
	
	// ���캯��
	public MemberOperation() {
//		member = new Member();
//		book = new Book();
		jdbcOpetation = new JDBCOpetation() {
			
			// ����ӿ�
			@Override
			public void update() {		
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				PreparedStatement pstmt;
				
				try {
					// ���½��ı�
					String sql = "insert into borrow values('" + member.getId() + "', '" + member.getName() + "', '" + book.getId() + "', '" + book.getName() + "')";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// ������ʷ��¼��
					sql = "insert into history(type, member_id, member_name, book_id, book_name) values('" + "����" + "', '" + member.getId() + "', '" + member.getName() + "', '" + book.getId() + "', '" + book.getName() + "')";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// ���¿��
					sql = "select * from book where id='" + book.getId() + "'";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					rs.next();
//					String bookStock = rs.getString(5);
//					String bookStock = String.valueOf(Integer.valueOf(rs.getString(5))-1);
/*					for (int i=1; i<6; ++i)
						System.out.print(rs.getString(i) + "\t");
					System.out.println();
*/					
					sql= "update book set stock='" + String.valueOf(Integer.valueOf(rs.getString(5))-1) + "' where id='" + book.getId() + "'";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					System.out.println("Debug: Borrow book success.");
					pstmt.close();
//					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			// ����ӿ�
			@Override
			public void select() {		
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				PreparedStatement pstmt;
				
				try {
					// ���½��ı�
					String sql= "delete from borrow where member_id='" + member.getId() + "' and member_name='" + member.getName() + "' and book_id='" + book.getId() + "' and book_name='" + book.getName() + "'";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// ���½�����ʷ��
					sql = "insert into history(type, member_id, member_name, book_id, book_name) values('" + "����" + "', '" + member.getId() + "', '" + member.getName() + "', '" + book.getId() + "', '" + book.getName() + "')";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// ���¿����
					sql = "select * from book where id='" + book.getId() + "'";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					sql= "update book set stock='" + String.valueOf(Integer.valueOf(rs.getString(5))+1) + "' where id='" + book.getId() + "'";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					System.out.println("Debug: Return book success.");
					pstmt.close();
//					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}			
			}
			
			// �����ӿ�
			@Override
			public void insert() {		
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				String sql = "insert into member(name, phone) values(?, ?)";
				PreparedStatement pstmt;
				
				try {
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getPhone());
					pstmt.executeUpdate();
					
					System.out.println("Debug: Open count success.");
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
			
			// ע���ӿ�
			@Override
			public void delete() {		
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				String sql = "delete from member where id='" + member.getId() + "' and name='" + member.getName() + "'";
				PreparedStatement pstmt;
				
				try {
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					System.out.println("Debug: Delete count success.");
					pstmt.close();
//					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		
	}
	
	// �����ӿ�
	public void openCount(Member mem) {
		this.member = mem;
		jdbcOpetation.insert();
	}
	
	// ע���ӿ�
	public void deleteCount(Member mem) {
		this.member = mem;
		jdbcOpetation.delete();
	}
	
	// ����ӿ�
	public void borrowBook(Member mem, Book book) {
		this.member = mem;
		this.book = book;
		jdbcOpetation.update();
	}
	
	// ����ӿ�
	public void returnBook(Member mem, Book book) {
		this.member = mem;
		this.book = book;
		jdbcOpetation.select();
	}
	
}