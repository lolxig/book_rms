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
 * description: 会员管理模块接口，分为四个接口，功能分别是  开户、注销、借书、还书
 * 
 * 借书流程：将借书信息记录在借阅表和借阅历史中，然后对该书籍的stock减一
 * 还书流程：将还书信息记录在借阅表和借阅历史中，然后对该书籍的stock加一
 * 
 * 说明：
 * 		开户时，给两个参数(name, phone)即可，会员id自动生成
 * 		注销时，必须给两个参数(id, name)，剩下的phone参数可以不给
 * 
 * 		借书时，必须给四个参数(会员id，会员name, 书籍id, 书籍name)，剩下的参数可以不给
 * 		还书时，必须给四个参数(会员id，会员name, 书籍id, 书籍name)，剩下的参数可以不给
 * 
 * note: 测试通过
 * 
 * complete time: 2019-3-27 17:15:26
 * 
 * ******************************************************************************************
 * 
 * 2019-3-27 21:36:40
 * 
 * 修改：
 * 		对借阅表进行修改，添加两条not null的属性，分别是member_name, book_name
 * 		对借阅历史表进行修改，添加两条not null的属性，分别是member_name, book_name
 * 
 * note: 测试通过
 * complete time: 2019-3-27 21:44:04
 * 
 * ******************************************************************************************
 * 
 * note: 结构调整，数据库连接统一管理
 * 
 * time: 2019-3-29 17:06:57
 * 
 */

public class MemberOperation {
	
	private Member member = null;
	private Book book = null;
	private JDBCOpetation jdbcOpetation = null;
//	private Connection connection = null;
	
	// 构造函数
	public MemberOperation() {
//		member = new Member();
//		book = new Book();
		jdbcOpetation = new JDBCOpetation() {
			
			// 借书接口
			@Override
			public void update() {		
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				PreparedStatement pstmt;
				
				try {
					// 更新借阅表
					String sql = "insert into borrow values('" + member.getId() + "', '" + member.getName() + "', '" + book.getId() + "', '" + book.getName() + "')";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// 更新历史记录表
					sql = "insert into history(type, member_id, member_name, book_id, book_name) values('" + "借书" + "', '" + member.getId() + "', '" + member.getName() + "', '" + book.getId() + "', '" + book.getName() + "')";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// 更新库存
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
			
			// 还书接口
			@Override
			public void select() {		
				// TODO Auto-generated method stub
//				connection = jdbcOpetation.getConnection();
				PreparedStatement pstmt;
				
				try {
					// 更新借阅表
					String sql= "delete from borrow where member_id='" + member.getId() + "' and member_name='" + member.getName() + "' and book_id='" + book.getId() + "' and book_name='" + book.getName() + "'";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// 更新借阅历史表
					sql = "insert into history(type, member_id, member_name, book_id, book_name) values('" + "还书" + "', '" + member.getId() + "', '" + member.getName() + "', '" + book.getId() + "', '" + book.getName() + "')";
					pstmt = (PreparedStatement) ConnectionUnify.connection.prepareStatement(sql);
					pstmt.executeUpdate();
					
					// 更新库存量
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
			
			// 开户接口
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
			
			// 注销接口
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
	
	// 开户接口
	public void openCount(Member mem) {
		this.member = mem;
		jdbcOpetation.insert();
	}
	
	// 注销接口
	public void deleteCount(Member mem) {
		this.member = mem;
		jdbcOpetation.delete();
	}
	
	// 借书接口
	public void borrowBook(Member mem, Book book) {
		this.member = mem;
		this.book = book;
		jdbcOpetation.update();
	}
	
	// 还书接口
	public void returnBook(Member mem, Book book) {
		this.member = mem;
		this.book = book;
		jdbcOpetation.select();
	}
	
}