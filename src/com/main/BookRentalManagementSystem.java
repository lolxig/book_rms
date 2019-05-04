package com.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

import java.sql.*;

import com.GUI.firstLevel.*;
import com.GUI.secondLevel.*;
import com.cardLable.CardLable;
import com.GUI.infoSearch.*;
import com.intraface.intraface.*;
import com.memberClass.*;
import com.intraface.infoSearch.*;
import com.databaseOperation.*;


/**
 * 
 * @author xig
 *
 * description: 系统入口
 * 
 *  			主要组件：
 *  					首先是所有PANEL，先添加进来，然后是一个frame，一个card
 *  					
 *  					然后是四个内部接口，提供功能的接口
 *  
 *  					接下来的，要啥补啥
 * 
 * project link: https://github.com/lolxig/book_rms.git
 * 				本次开发，源代码全部托管于git，并用于后续的版本控制
 * 
 */

public class BookRentalManagementSystem {
	
	
	/***************/
	/*  所有Panel  */
	/***************/
	
	// GUI组件
	
	// frame和card
	private JFrame frame = null;
	private CardLayout card = null;
	
	// firstLevel
	private BookManagementPanel bookManagementPanel = null;
	private ExitSystemPanel exitSystemPanel = null;
	private HomePanel homePanel = null;
	private InfoSearchPanel infoSearchPanel = null;
	private LoginPanel loginPanel = null;
	private MemberManagementPanel memberManagementPanel = null;
	
	// secondLevel
	private AddBookPanel addBookPanel = null;
	private BorrowBookPanel borrowBookPanel = null;
	private ChangePasswordPanel changePasswordPanel = null;
	private DeleteBookPanel deleteBookPanel = null;
	private DeleteCountPanel deleteCountPanel = null;
	private OpenCountPanel openCountPanel = null;
	private ReturnBookPanel returnBookPanel = null;
	
	// infoSearch
	private BookInfoSearchPanel bookInfoSearchPanel = null;
	private BorrowInfoSearchPanel borrowInfoSearchPanel = null;
	private HistoryInfoSearchPanel historyInfoSearchPanel = null;
	private MemberInfoSearchPanel memberInfoSearchPanel = null;
	
	
	// 内部接口
	private BookOperation bookOperation = null;
	private InfoSearchOperation infoSearchOperation = null;
	private MemberOperation memberOperation = null;
	private PasswordOperation passwordOperation = null;
	
	// 记录上一个卡片
	private String lastCard = null;
	
	
	/**************/
	/*  系统入口  */
	/**************/
	
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
	
	
	
	/************/
	/*  初始化  */
	/************/
	
	// 初始化
	private void init() {

		// 初始化各个PANEL和接口
		panelAndIntrafaceInit();	
		
		// frame初始化
		frameInit();
		
		// 初始化完毕后切换至登陆界面
		changeToLoginPanel();
	}
	
	// panle初始化
	private void panelAndIntrafaceInit() {
		
		// 内部接口
		bookOperation = new BookOperation();
		exitSystemPanel = new ExitSystemPanel();
		infoSearchOperation = new InfoSearchOperation();
		memberOperation = new MemberOperation();
		passwordOperation = new PasswordOperation();
		
		// firstLevel
		bookManagementPanel = new BookManagementPanel();
		homePanel = new HomePanel();
		infoSearchPanel = new InfoSearchPanel();
		loginPanel = new LoginPanel();
		memberManagementPanel = new MemberManagementPanel();
		
		// secondLevel
		addBookPanel = new AddBookPanel();
		borrowBookPanel = new BorrowBookPanel();
		changePasswordPanel = new ChangePasswordPanel();
		deleteBookPanel = new DeleteBookPanel();
		deleteCountPanel = new DeleteCountPanel();
		openCountPanel = new OpenCountPanel();
		returnBookPanel = new ReturnBookPanel();
		
		// infoSearch
		bookInfoSearchPanel = new BookInfoSearchPanel(infoSearchOperation.searchBook());
		borrowInfoSearchPanel = new BorrowInfoSearchPanel(infoSearchOperation.searchBorrow());
		historyInfoSearchPanel = new HistoryInfoSearchPanel(infoSearchOperation.searchHistory());
		memberInfoSearchPanel = new MemberInfoSearchPanel(infoSearchOperation.searchMember());
	}
	
	// frame和card初始化
	private void frameInit() {
		
		// 创建组件
		card = new CardLayout();
		frame = new JFrame();
		
		// 设置为卡片布局
		frame.setLayout(card);
		
		// 添加PANEL
		frame.add(CardLable.BOOK_MANAGEMENT_PANEL, bookManagementPanel);
		frame.add(CardLable.EXIT_SYSTEM_PANEL, exitSystemPanel);
		frame.add(CardLable.HOME_PANEL, homePanel);
		frame.add(CardLable.INFO_SEARCH_PANEL, infoSearchPanel);
		frame.add(CardLable.LOGIN_PANEL, loginPanel);
		frame.add(CardLable.MEMBER_MANAGEMENT_PANEL, memberManagementPanel);
		
		frame.add(CardLable.ADD_BOOK_PANEL, addBookPanel);
		frame.add(CardLable.BORROW_BOOK_PANEL, borrowBookPanel);
		frame.add(CardLable.CHANGE_PASSWORD_PANEL, changePasswordPanel);
		frame.add(CardLable.DELETE_BOOK_PANEL, deleteBookPanel);
		frame.add(CardLable.DELETE_COUNT_PANEL, deleteCountPanel);
		frame.add(CardLable.OPEN_COUNT_PANEL, openCountPanel);
		frame.add(CardLable.RETURN_BOOK_PANEL, returnBookPanel);
		
		frame.add(CardLable.BOOK_INFO_SEARCH_PANEL, bookInfoSearchPanel);
		frame.add(CardLable.BORROW_INFO_SEARCH_PANEL, borrowInfoSearchPanel);
		frame.add(CardLable.HISTORY_INFO_SEARCH_PANEL, historyInfoSearchPanel);
		frame.add(CardLable.MEMBER_INFO_SEARCH_PANEL, memberInfoSearchPanel);
		
		// frame属性
		frame.setTitle("图书租赁管理系统");
		frame.setSize(MyScreen.WIDTH, MyScreen.HIGHT);
		frame.setLocation(MyScreen.X, MyScreen.Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	
	/****************/
	/*   界面切换    */
	/****************/
	
	// firstLevel
	
	// 切换至书籍管理panel
	private void changeToBookManagementPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_MANAGEMENT_PANEL);
		actionOfBookManagementPanel();
	}
	
	// 切换至退出系统缓冲界面
	private void changeToExitSystemPanel() {
		card.show(frame.getContentPane(), CardLable.EXIT_SYSTEM_PANEL);
		actionOfExitSystemPanel();
	}
	
	// 切换至主界面
	private void changeToHomePanel() {
		card.show(frame.getContentPane(), CardLable.HOME_PANEL);
		actionOfHomePanel();
	}
	
	// 切换至信息检索见面
	private void changeToInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.INFO_SEARCH_PANEL);
		actionOfInfoSearchPanel();
	}
	
	// 切换至登陆界面
	private void changeToLoginPanel() {
		card.show(frame.getContentPane(), CardLable.LOGIN_PANEL);
		actionOfLoginPanel();
	}
	
	// 切换至会员管理界面
	private void changeToMemberManagementPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_MANAGEMENT_PANEL);
		actionOfMemberManagementPanel();
	}
	
	// secondLevel
	
	// 切换至添加书籍界面
	private void changeToAddBookPanel() {
		card.show(frame.getContentPane(), CardLable.ADD_BOOK_PANEL);
		actionOfAddBookPanel();
	}
	
	// 切换至借书界面
	private void changeToBorrowBookPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_BOOK_PANEL);
		actionOfBorrowBookPanel();
	}
	
	// 切换至更改密码界面
	private void changeToChangePasswordPanel() {
		card.show(frame.getContentPane(), CardLable.CHANGE_PASSWORD_PANEL);
		actionOfChangePasswordPanel();
	}
	
	// 切换至删除书籍界面
	private void changeToDeleteBookPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_BOOK_PANEL);
		actionOfDeleteBookPanel();
	}
	
	// 切换至删除账户界面
	private void changeToDeleteCountPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_COUNT_PANEL);
		actionOfDeleteCountPanel();
	}
	
	// 切换至开户界面
	private void changeToOpenCountPanel() {
		card.show(frame.getContentPane(), CardLable.OPEN_COUNT_PANEL);
		actionOfOpenCountPanel();
	}
	
	// 切换至还书界面
	private void changeToReturnBookPanel() {
		card.show(frame.getContentPane(), CardLable.RETURN_BOOK_PANEL);
		actionOfReturnBookPanel();
	}
	
	// infoSearch
	
	// 切换至书籍信息检索界面
	private void changeToBookInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_INFO_SEARCH_PANEL);
		actionOfBookInfoSearchPanel();
	}
	
	// 切换至借阅信息检索界面
	private void changeToBorrowInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_INFO_SEARCH_PANEL);
		actionOfBorrowInfoSearchPanel();
	}
	
	// 切换至历史记录信息检索界面
	private void changeToHistoryInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.HISTORY_INFO_SEARCH_PANEL);
		actionOfHistoryInfoSearchPanel();
	}
	
	// 切换至会员信息检索界面
	private void changeToMemberInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_INFO_SEARCH_PANEL);
		actionOfMemberInfoSearchPanel();
	}
	
	
	
	/**************/
	/*  界面动作     */
	/**************/
	
	// 书籍管理panel动作 __________complete time: 2019-4-19 16:29:51
	private void actionOfBookManagementPanel() {
		
		/**
		 * function: 书籍管理界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 16:29:38
		 * 
		 */
		
		bookManagementPanel.getAddBook().addMouseListener(new MouseListener() {		// 添加书籍按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bookManagementPanel.getAddBook().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bookManagementPanel.getAddBook().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 切换至添加书籍界面
				// TODO Auto-generated method stub
				changeToAddBookPanel();
			}
		});
		
		bookManagementPanel.getDeleteBook().addMouseListener(new MouseListener() {	// 删除书籍按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bookManagementPanel.getDeleteBook().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bookManagementPanel.getDeleteBook().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 切换至删除书籍界面
				// TODO Auto-generated method stub
				changeToDeleteBookPanel();
			}
		});
		
		bookManagementPanel.getBackOf().addMouseListener(new MouseListener() {		// 返回上一层按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bookManagementPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bookManagementPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 返回至主界面
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// 退出系统PANEL动作 __________complete time: 2019-4-19 15:54:17
	private void actionOfExitSystemPanel() {
		
		/**
		 * function: 退出系统缓冲界面
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 15:53:50
		 * 
		 */
		
		exitSystemPanel.getYesButton().addMouseListener(new MouseListener() {		// 确认按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exitSystemPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exitSystemPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				exitSystem();
			}
		});
		
		exitSystemPanel.getCancelButton().addMouseListener(new MouseListener() {	// 取消按钮
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exitSystemPanel.getCancelButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exitSystemPanel.getCancelButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				card.show(frame.getContentPane(), lastCard);						// 切换至上一张卡片
			}
		});
		
	}
	
	// 主界面动作 __________complete time: 2019-4-19 15:49:59
	private void actionOfHomePanel() {
		
		/**
		 *  funciton: 根据不同的按钮，跳转至不同的界面
		 *  
		 *  note: 测试通过
		 *  complete time: 2019-4-19 15:49:46
		 *  
		 * */
		
		homePanel.getChangePassword().addMouseListener(new MouseListener() {		// 修改密码按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getChangePassword().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {								// 搞些花里胡哨的颜色
				// TODO Auto-generated method stub
				homePanel.getChangePassword().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 切换至修改密码界面
				// TODO Auto-generated method stub
				changeToChangePasswordPanel();
			}
		});
		
		homePanel.getMemberManagement().addMouseListener(new MouseListener() {		// 会员管理按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getMemberManagement().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getMemberManagement().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				changeToMemberManagementPanel();									// 切换至会员管理界面
			}
		});
		
		homePanel.getBookManagement().addMouseListener(new MouseListener() {		// 书籍管理按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getBookManagement().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getBookManagement().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 切换至书籍管理界面
				// TODO Auto-generated method stub
				changeToBookManagementPanel();
			}
		});
		
		homePanel.getInfoSearch().addMouseListener(new MouseListener() {		// 信息查询按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getInfoSearch().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getInfoSearch().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 切换至信息查询界面
				// TODO Auto-generated method stub
				changeToInfoSearchPanel();
			}
		});
		
		homePanel.getExitSystem().addMouseListener(new MouseListener() {		// 退出系统按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getExitSystem().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				homePanel.getExitSystem().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lastCard = CardLable.HOME_PANEL;							// 跳转记录
				changeToExitSystemPanel();									// 切换至退出系统PANEL
			}
		});
		
	}
	
	// 信息检索见面动作 __________complete time: 2019-4-19 16:44:19
	private void actionOfInfoSearchPanel() {
		
		/**
		 * function: 信息查询界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 16:44:07
		 * 
		 */
		
		infoSearchPanel.getMemberSearch().addMouseListener(new MouseListener() {	// 会员查询按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getMemberSearch().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getMemberSearch().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 切换至会员查询界面
				// TODO Auto-generated method stub
				changeToMemberInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getBookSearch().addMouseListener(new MouseListener() {		// 书籍查询按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getBookSearch().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getBookSearch().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 切换至书籍查询界面
				// TODO Auto-generated method stub
				changeToBookInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getBorrowSearch().addMouseListener(new MouseListener() {	// 借阅查询按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getBorrowSearch().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getBorrowSearch().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 切换至借阅查询界面
				// TODO Auto-generated method stub
				changeToBorrowInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getHistorySearch().addMouseListener(new MouseListener() {	// 借阅历史按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getHistorySearch().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getHistorySearch().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 切换至借阅历史查询界面
				// TODO Auto-generated method stub
				changeToHistoryInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getBackOf().addMouseListener(new MouseListener() {			// 返回上一层按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				infoSearchPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 返回至主界面
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// 登陆界面动作 __________complete time: 2019-4-19 14:33:25
	private void actionOfLoginPanel() {
		
		/**
		 *  funciton: check password，然后进入系统，切换至主界面
		 *  
		 *  note: 测试通过
		 *  complete time: 2019-4-19 14:27:50 
		 *  
		 * */
		
		loginPanel.getLogin().addMouseListener(new MouseListener() {		// 登陆按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				loginPanel.getLogin().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {						// 做些花里胡哨的颜色
				// TODO Auto-generated method stub
				loginPanel.getLogin().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {						// 进入系统
				// TODO Auto-generated method stub
				String systemPassword = passwordOperation.getPassword();	// 系统密码
				String enterPassword = loginPanel.getEnterPassword();		// 输入的密码
				
				if (systemPassword.equals(enterPassword)) {					// 密码正确，进入系统
					changeToHomePanel();
				} else {
					if (!enterPassword.equals("")) {
						loginPanel.getWrongPassword().setVisible(true);		// 显示密码错误提示
						loginPanel.clearPasswordArea();						// 清空密码输入框
					}
				}
			}
		});
		
		loginPanel.getExit().addMouseListener(new MouseListener() {			// 退出按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {							
				// TODO Auto-generated method stub
				loginPanel.getExit().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {						// 做些花里胡哨的颜色
				// TODO Auto-generated method stub
				loginPanel.getExit().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {						// 退出系统
				// TODO Auto-generated method stub
				lastCard = CardLable.LOGIN_PANEL;							// 跳转记录
				changeToExitSystemPanel();
			}
		});
		
	}
	
	// 会员管理界面动作 __________complete time: 2019-4-19 16:21:03
	private void actionOfMemberManagementPanel() {
		
		/**
		 * function: 会员管理目录界面
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 16:20:20
		 * 
		 */
		
		memberManagementPanel.getOpenCount().addMouseListener(new MouseListener() {		// 开户按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getOpenCount().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getOpenCount().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {									// 切换至开户界面
				// TODO Auto-generated method stub
				changeToOpenCountPanel();
			}
		});
		
		memberManagementPanel.getDeleteCount().addMouseListener(new MouseListener() {	// 注销按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getDeleteCount().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getDeleteCount().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {									// 切换至注销账户界面
				// TODO Auto-generated method stub
				changeToDeleteCountPanel();
			}
		});
		
		memberManagementPanel.getBorrowBook().addMouseListener(new MouseListener() {	// 借书按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getBorrowBook().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getBorrowBook().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {									// 切换至借书界面
				// TODO Auto-generated method stub
				changeToBorrowBookPanel();
			}
		});
		
		memberManagementPanel.getReturnBook().addMouseListener(new MouseListener() {	// 还书按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getReturnBook().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getReturnBook().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {									// 切换至还书界面
				// TODO Auto-generated method stub
				changeToReturnBookPanel();
			}
		});
		
		memberManagementPanel.getBackOf().addMouseListener(new MouseListener() {		// 返回按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				memberManagementPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {									// 返回至主界面
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// secondLevel
	
	// 添加书籍界面动作 __________complete time: 2019-5-4 16:11:01
	private void actionOfAddBookPanel() {
		
		/**
		 * function: 添加书籍界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-5-4 16:10:47
		 * 
		 */
		
		Book book = new Book();							// 获取添加书籍的信息
		
		
		addBookPanel.clearEnterArea();					// 界面遗留信息清空
		addBookPanel.getSuccessNote().setVisible(false);
		
		addBookPanel.getYesButton().addMouseListener(new MouseListener() {		// 确认按钮动作
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {								// 配置移出移进颜色
				// TODO Auto-generated method stub
				addBookPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addBookPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 点击动作
				// TODO Auto-generated method stub
				
				book.setName(addBookPanel.getBookName());						// 获取信息
				book.setAuthor(addBookPanel.getAuthorName());
				book.setPress(addBookPanel.getPress());
				book.setStock(addBookPanel.getAmount());
				
				bookOperation.addBook(book);									// 数据添加至数据库
				addBookPanel.clearEnterArea();									// 界面遗留信息清空
				addBookPanel.getSuccessNote().setVisible(true);					// 显示操作成功
			}
		});
		
		addBookPanel.getBackOf().addMouseListener(new MouseListener() {			// 返回按钮动作
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {								// 配置颜色
				// TODO Auto-generated method stub
				addBookPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addBookPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 返回按钮动作
				// TODO Auto-generated method stub
				changeToBookManagementPanel();									// 切换至书籍管理界面
			}
		});
		
	}
	
	// 借书界面动作 __________complete time: 2019-4-19 18:35:57
	private void actionOfBorrowBookPanel() {
		
		/**
		 * function: 借书界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 18:35:39
		 */
		
		// 借阅
		Member member = new Member();
		Book book = new Book();
		
		// 借阅历史
		
		borrowBookPanel.clearEnterArea();
		borrowBookPanel.getSuccessNoteLable().setVisible(false);
		
		borrowBookPanel.getYesButton().addMouseListener(new MouseListener() {	// 确认按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				borrowBookPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				borrowBookPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				member.setId(borrowBookPanel.getEnterMemberId());				// 设置会员和书籍信息
				member.setName(borrowBookPanel.getEnterMemberName());
				book.setId(borrowBookPanel.getEnterBookId());
				book.setName(borrowBookPanel.getEnterBookName());
				
				borrowBookPanel.getSuccessNoteLable().setVisible(true);			// 显示提示
				borrowBookPanel.clearEnterArea();
				memberOperation.borrowBook(member, book);						// 将数据写入数据库

			}
		});
		
		borrowBookPanel.getBackOf().addMouseListener(new MouseListener() {		// 返回按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				borrowBookPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				borrowBookPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 返回会员管理界面
				// TODO Auto-generated method stub
				borrowBookPanel.clearEnterArea();								// 清除输入框
				changeToMemberManagementPanel();								// 切换至会员管理界面
			}
		});
		
	}
	
	// 修改密码界面动作 __________complete time: 2019-4-19 17:25:16
	private void actionOfChangePasswordPanel() {
		
		/**
		 * function: 修改密码界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 17:25:03
		 * 
		 */
		
		changePasswordPanel.getYesButton().addMouseListener(new MouseListener() {	// 确认按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				changePasswordPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				changePasswordPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {										// 修改密码操作
				// TODO Auto-generated method stub
				
				String systemPassword = passwordOperation.getPassword();					// 系统密码
				String enterFormerPassword = changePasswordPanel.getEnterFormerPassword();	// 获取输入的旧密码
				String enterNewPassword = changePasswordPanel.getEnterNewPassword();		// 获取输入的新密码
				String enterVerifyPassword = changePasswordPanel.getEnterVerifyPassword();	// 获取输入的确认密码
				
				changePasswordPanel.getWrongPasswordLable().setVisible(false);
				changePasswordPanel.getWrongVerifyPasswordLable().setVisible(false);
				changePasswordPanel.getChangeSuccessNote().setVisible(false);
				
				if (!systemPassword.equals(enterFormerPassword)) {							// 判断旧密码输入				
					changePasswordPanel.getWrongPasswordLable().setVisible(true);			// 显示提示
					changePasswordPanel.clearEnterArea();									// 清除输入框
				} else {
					if (!enterNewPassword.equals(enterVerifyPassword)) {					// 判定两次输入是否一致
						changePasswordPanel.getWrongVerifyPasswordLable().setVisible(true);	// 显示提示
						changePasswordPanel.clearEnterArea();								// 清除输入框	
					} else {			
						changePasswordPanel.getChangeSuccessNote().setVisible(true);		// 显示提示
						passwordOperation.setPassword(enterNewPassword);					// 如果都正确，则确认更改密码，修改数据库存储的密码
					}
				}
			}
		});
		
		changePasswordPanel.getBackOf().addMouseListener(new MouseListener() {	// 返回按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				changePasswordPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				changePasswordPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 返回至主界面
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// 删除书籍界面动作 __________complete time: 2019-5-4 16:22:29
	private void actionOfDeleteBookPanel() {
		
		/**
		 * function: 删除书籍界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-5-4 16:22:16
		 * 
		 */
		
		Book book = new Book();
		
		deleteBookPanel.clearEnterArea();					// 清空初始化界面
		deleteBookPanel.getSuccessNote().setVisible(false);
		
		deleteBookPanel.getYesButton().addMouseListener(new MouseListener() {		// 确认按钮操作
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {									// 添加按钮颜色效果
				// TODO Auto-generated method stub
				deleteBookPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteBookPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// 确认按钮动作
				// TODO Auto-generated method stub
				
				book.setId(deleteBookPanel.getBookId());							// 获取信息
				book.setName(deleteBookPanel.getBookName());
				
				bookOperation.deleteBook(book);										// 数据写入数据库
				deleteBookPanel.getSuccessNote().setVisible(true);					// 显示操作成功提示
				deleteBookPanel.clearEnterArea();
			}
		});
		
		deleteBookPanel.getBackOf().addMouseListener(new MouseListener() {			// 返回按钮操作
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {									// 配置颜色
				// TODO Auto-generated method stub
				deleteBookPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteBookPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				changeToBookManagementPanel();										// 返回至书籍管理界面
			}
		});
		
	}
	
	// 注销账户界面动作 __________complete time: 2019-4-19 18:13:32
	private void actionOfDeleteCountPanel() {
		
		/**
		 * function: 注销账户界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 18:13:19
		 * 
		 */
		
		Member deleteMember = new Member();		// 要被删除的会员
			
		deleteCountPanel.clearEnterArea();
		deleteCountPanel.getDeleteSuccessNoteLable().setVisible(false);
			
		deleteCountPanel.getYesButton().addMouseListener(new MouseListener() {	// 确认按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteCountPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteCountPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				deleteMember.setId(deleteCountPanel.getEnterMemberId());
				deleteMember.setName(deleteCountPanel.getEnterMemberName());
				
				deleteCountPanel.getDeleteSuccessNoteLable().setVisible(true);	// 显示提示
				memberOperation.deleteCount(deleteMember);						// 从数据库删除账户
			}
		});
		
		deleteCountPanel.getBackOf().addMouseListener(new MouseListener() {		// 返回按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteCountPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteCountPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 切换至会员管理界面
				// TODO Auto-generated method stub
				changeToMemberManagementPanel();
			}
		});
		
	}
	
	// 开户界面动作 __________complete time: 2019-4-19 17:52:40
	private void actionOfOpenCountPanel() {
		
		/**
		 * function: 开户界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 17:52:28
		 * 
		 */
		
		Member newMember = new Member();		// 新会员

		openCountPanel.clearEnterArea();
		openCountPanel.getOpenCountSuccess().setVisible(false);
		
		openCountPanel.getYesButton().addMouseListener(new MouseListener() {	// 确认按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				openCountPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				openCountPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 确认开户
				// TODO Auto-generated method stub
				
				newMember.setName(openCountPanel.getEnterMemberName());			// 获取输入的会员名
				newMember.setPhone(openCountPanel.getEnterMemberPhone());		// 获取输入的会员手机号
				
				openCountPanel.getOpenCountSuccess().setVisible(true);			// 显示开户成功提示
				memberOperation.openCount(newMember);							// 用户数据添加至数据库
				openCountPanel.clearEnterArea();
			}
		});
		
		openCountPanel.getBackOf().addMouseListener(new MouseListener() {		// 返回按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				openCountPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				openCountPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 返回会员管理界面
				// TODO Auto-generated method stub
				changeToMemberManagementPanel();
			}
		});
		
	}
	
	// 还书界面动作 __________complete time: 2019-4-19 18:53:50
	private void actionOfReturnBookPanel() {
		
		/**
		 * function: 还书界面动作
		 * 
		 * note: 测试通过
		 * complete time: 2019-4-19 18:53:37
		 */
		
		Member member = new Member();
		Book book = new Book();
		
		returnBookPanel.clearEnterArea();
		returnBookPanel.getSuccessNoteLable().setVisible(false);
		
		returnBookPanel.getYesButton().addMouseListener(new MouseListener() {		// 确认按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				returnBookPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				returnBookPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				// 录入信息
				member.setId(returnBookPanel.getEnterMemberId());
				member.setName(returnBookPanel.getEnterMemberName());
				book.setId(returnBookPanel.getEnterBookId());
				book.setName(returnBookPanel.getEnterBookName());
				
				returnBookPanel.clearEnterArea();								// 清除输入框
				returnBookPanel.getSuccessNoteLable().setVisible(true);			// 显示成功标签
				
				memberOperation.returnBook(member, book);						// 录入数据库
			}
		});
		
		returnBookPanel.getBackOf().addMouseListener(new MouseListener() {		// 返回按钮监听
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				returnBookPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				returnBookPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// 返回至会员管理界面
				// TODO Auto-generated method stub
				changeToMemberManagementPanel();
			}
		});
		
	}
	
	// infoSearch
	
	// 书籍信息检索界面动作
	private void actionOfBookInfoSearchPanel() {
		
		/**
		 * function: 只有一个动作，即返回上一层
		 * 
		 */
		
		bookInfoSearchPanel.getReturnButton().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bookInfoSearchPanel.getReturnButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bookInfoSearchPanel.getReturnButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				changeToInfoSearchPanel();
			}
		});
		
	}
	
	// 借阅信息检索界面动作
	private void actionOfBorrowInfoSearchPanel() {
		
		/**
		 * function: 只有一个动作，即返回上一层
		 * 
		 */
		
		borrowInfoSearchPanel.getReturnButton().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				borrowInfoSearchPanel.getReturnButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				borrowInfoSearchPanel.getReturnButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				changeToInfoSearchPanel();
			}
		});
		
	}
	
	// 历史记录信息检索界面动作
	private void actionOfHistoryInfoSearchPanel() {
		
		/**
		 * function: 只有一个动作，即返回上一层
		 * 
		 */
		
		historyInfoSearchPanel.getReturnButton().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				historyInfoSearchPanel.getReturnButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				historyInfoSearchPanel.getReturnButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				changeToInfoSearchPanel();
			}
		});
		
	}
	
	// 会员信息检索界面动作
	private void actionOfMemberInfoSearchPanel() {
		
		/**
		 * function: 只有一个动作，即返回上一层
		 * 
		 */
		
		memberInfoSearchPanel.getReturnButton().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				memberInfoSearchPanel.getReturnButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				memberInfoSearchPanel.getReturnButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				changeToInfoSearchPanel();
			}
		});
		
	}
	
	
	
	/**************/
	/*  系统出口      */
	/**************/
	
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
