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
 * 
 */

public class BookRentalManagementSystem {
	
	// GUI组件
	
	// frame和card
	JFrame frame = null;
	CardLayout card = null;
	
	// firstLevel
	BookManagementPanel bookManagementPanel = null;
	HomePanel homePanel = null;
	InfoSearchPanel infoSearchPanel = null;
	LoginPanel loginPanel = null;
	MemberManagementPanel memberManagementPanel = null;
	
	// secondLevel
	AddBookPanel addBookPanel = null;
	BorrowBookPanel borrowBookPanel = null;
	ChangePasswordPanel changePasswordPanel = null;
	DeleteBookPanel deleteBookPanel = null;
	DeleteCountPanel deleteCountPanel = null;
	OpenCountPanel openCountPanel = null;
	ReturnBookPanel returnBookPanel = null;
	
	// infoSearch
	BookInfoSearchPanel bookInfoSearchPanel = null;
	BorrowInfoSearchPanel borrowInfoSearchPanel = null;
	HistoryInfoSearchPanel historyInfoSearchPanel = null;
	MemberInfoSearchPanel memberInfoSearchPanel = null;
	
	
	// 内部接口
	BookOperation bookOperation = null;
	InfoSearchOperation infoSearchOperation = null;
	MemberOperation memberOperation = null;
	PasswordOperation passwordOperation = null;
	
	

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
	/*   界面切换   */
	/****************/
	
	// firstLevel
	
	// 切换至书籍管理panel
	private void changeToBookManagementPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_MANAGEMENT_PANEL);
	}
	
	// 切换至主界面
	private void changeToHomePanel() {
		card.show(frame.getContentPane(), CardLable.HOME_PANEL);
	}
	
	// 切换至信息检索见面
	private void changeToInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.INFO_SEARCH_PANEL);
	}
	
	// 切换至登陆界面
	private void changeToLoginPanel() {
		card.show(frame.getContentPane(), CardLable.LOGIN_PANEL);
	}
	
	// 切换至会员管理一级界面
	private void changeToMemberManagementPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_MANAGEMENT_PANEL);
	}
	
	// secondLevel
	
	// 切换至添加书籍界面
	private void changeToAddBookPanel() {
		card.show(frame.getContentPane(), CardLable.ADD_BOOK_PANEL);
	}
	
	// 切换至借书界面
	private void changeToBorrowBookPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_BOOK_PANEL);
	}
	
	// 切换至更改密码界面
	private void changeToChangePasswordPanel() {
		card.show(frame.getContentPane(), CardLable.CHANGE_PASSWORD_PANEL);
	}
	
	// 切换至删除书籍界面
	private void changeToDeleteBookPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_BOOK_PANEL);
	}
	
	// 切换至删除账户界面
	private void changeToDeleteCountPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_COUNT_PANEL);
	}
	
	// 切换至开户界面
	private void changeToOpenCountPanel() {
		card.show(frame.getContentPane(), CardLable.OPEN_COUNT_PANEL);
	}
	
	// 切换至还书界面
	private void changeToReturnBookPanel() {
		card.show(frame.getContentPane(), CardLable.RETURN_BOOK_PANEL);
	}
	
	// infoSearch
	
	// 切换至书籍信息检索界面
	private void changeToBookInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_INFO_SEARCH_PANEL);
	}
	
	// 切换至借阅信息检索界面
	private void changeToBorrowInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_INFO_SEARCH_PANEL);
	}
	
	// 切换至历史记录信息检索界面
	private void changeToHistoryInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.HISTORY_INFO_SEARCH_PANEL);
	}
	
	// 切换至会员信息检索界面
	private void changeToMemberInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_INFO_SEARCH_PANEL);
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
