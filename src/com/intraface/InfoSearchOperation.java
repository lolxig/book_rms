package com.intraface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.databaseOperation.JDBCOpetation;
import com.infoSearch.InfoSearchOfBook;
import com.infoSearch.InfoSearchOfBorrow;
import com.infoSearch.InfoSearchOfHistory;
import com.infoSearch.InfoSearchOfMember;
import com.memberClass.Book;

/**
 * 
 * @author xig
 * 
 * description: 信息查询接口，分为四个接口，功能分别是  查询会员、查询书籍、查询借阅、查询历史
 * 
 * 说明：
 * 			查询会员接口返回一个定义好的会员ArrayList，供上层界面接口使用
 * 			查询书籍接口返回一个定义好的书籍ArrayList，供上层界面接口使用
 * 			查询借阅接口返回一个定义好的借阅ArrayList，供上层界面接口使用
 * 			查询历史接口返回一个定义好的历史ArrayList，供上层界面接口使用
 * 
 * note: 测试通过
 * complete time: 2019-3-28 18:38:16
 * 
 */

public class InfoSearchOperation {
	
	private JDBCOpetation jdbcOpetation = null;
	private Connection connection = null;
	
	// 构造函数
	public InfoSearchOperation() {
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
	}
	
	// 查询会员
	public ArrayList<InfoSearchOfMember> searchMember() {
		
		ArrayList<InfoSearchOfMember> members = new ArrayList<InfoSearchOfMember>();
		
		connection = jdbcOpetation.getConnection();
		PreparedStatement psmt = null;
		
		try {
			String sql = "select * from member";
			psmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				
				// 获取会员信息
				InfoSearchOfMember isMember = new InfoSearchOfMember();
				
				isMember.setMemberId(rs.getString(1));
				isMember.setMemberName(rs.getString(2));
				isMember.setMemberPhone(rs.getString(3));
				
				// 获取会员书籍信息
				sql = "select * from borrow where member_id='" + isMember.getMemberId() + "'";
				psmt = (PreparedStatement) connection.prepareStatement(sql);
				ResultSet rsTmp = psmt.executeQuery();
				ArrayList<Book> books = new ArrayList<Book>();		
				while (rsTmp.next()) {
					Book book = new Book();
					book.setId(rsTmp.getString(3));
					book.setName(rsTmp.getString(4));
					books.add(book);
				}
				isMember.setBookSlip(books);
				
				// 将会员添加至会员薄
				members.add(isMember);
			}
			psmt.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// 返回会员薄
		return members;
	}
	
	// 查询书籍
	public ArrayList<InfoSearchOfBook> searchBook() {
		
		ArrayList<InfoSearchOfBook> books = new ArrayList<InfoSearchOfBook>();
		
		connection = jdbcOpetation.getConnection();
		PreparedStatement psmt = null;
		
		try {
			String sql = "select * from book";
			psmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				
				InfoSearchOfBook isBook = new InfoSearchOfBook();
				
				isBook.setBookId(rs.getString(1));
				isBook.setBookName(rs.getString(2));
				isBook.setBookAuthor(rs.getString(3));
				isBook.setBookPress(rs.getString(4));
				isBook.setBookStcok(rs.getString(5));
				
				books.add(isBook);
			}
			psmt.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// 返回书籍薄
		return books;
	}
	
	//查询借阅
	public ArrayList<InfoSearchOfBorrow> searchBorrow() {
		
		ArrayList<InfoSearchOfBorrow> borrows = new ArrayList<InfoSearchOfBorrow>();
		
		connection = jdbcOpetation.getConnection();
		PreparedStatement psmt = null;
		
		try {
			String sql = "select * from borrow";
			psmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				
				InfoSearchOfBorrow isBorrow = new InfoSearchOfBorrow();
				
				isBorrow.setMemberId(rs.getString(1));
				isBorrow.setMemberName(rs.getString(2));
				isBorrow.setBookId(rs.getString(3));
				isBorrow.setBookName(rs.getString(4));
				
				borrows.add(isBorrow);
			}
			psmt.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// 返回借阅薄
		return borrows;
	}
	
	// 查询历史
	public ArrayList<InfoSearchOfHistory> searchHistory() {
		
		ArrayList<InfoSearchOfHistory> histories = new ArrayList<InfoSearchOfHistory>();
		
		connection = jdbcOpetation.getConnection();
		PreparedStatement psmt = null;
		
		try {
			String sql = "select * from history";
			psmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				
				InfoSearchOfHistory isHistory = new InfoSearchOfHistory();
				

				isHistory.setDate(new String(rs.getString(1).toCharArray(), 0, 19));
				isHistory.setType(rs.getString(2));
				isHistory.setMemberId(rs.getString(3));
				isHistory.setMemberName(rs.getString(4));
				isHistory.setBookId(rs.getString(5));
				isHistory.setBookName(rs.getString(6));
				
				histories.add(isHistory);
			}
			psmt.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// 返回历史记录薄
		return histories;
	}
	
}