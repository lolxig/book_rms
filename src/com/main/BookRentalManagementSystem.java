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
 * description: ϵͳ���
 * 
 *  			��Ҫ�����
 *  					����������PANEL������ӽ�����Ȼ����һ��frame��һ��card
 *  					
 *  					Ȼ�����ĸ��ڲ��ӿڣ��ṩ���ܵĽӿ�
 *  
 *  					�������ģ�Ҫɶ��ɶ
 * 
 * 
 */

public class BookRentalManagementSystem {
	
	// GUI���
	
	// frame��card
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
	
	
	// �ڲ��ӿ�
	BookOperation bookOperation = null;
	InfoSearchOperation infoSearchOperation = null;
	MemberOperation memberOperation = null;
	PasswordOperation passwordOperation = null;
	
	

	public static void main(String[] args) {
		new BookRentalManagementSystem();
	}
	
	// ���
	public BookRentalManagementSystem() {		
		
		// �������ݿ�
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
		// ��ʼ��
		init();
	}
	
	// ��ʼ��
	private void init() {
		
		
		
		
		// ��ʼ������PANEL�ͽӿ�
		panelAndIntrafaceInit();	
		
		// frame��ʼ��
		frameInit();
		
		// ��ʼ����Ϻ��л�����½����
		changeToLoginPanel();
	}
	
	// panle��ʼ��
	private void panelAndIntrafaceInit() {
		
		// �ڲ��ӿ�
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
	
	
	// frame��card��ʼ��
	private void frameInit() {
		
		// �������
		card = new CardLayout();
		frame = new JFrame();
		
		// ����Ϊ��Ƭ����
		frame.setLayout(card);
		
		// ���PANEL
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
		
		// frame����
		frame.setTitle("ͼ�����޹���ϵͳ");
		frame.setSize(MyScreen.WIDTH, MyScreen.HIGHT);
		frame.setLocation(MyScreen.X, MyScreen.Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	/****************/
	/*   �����л�   */
	/****************/
	
	// firstLevel
	
	// �л����鼮����panel
	private void changeToBookManagementPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_MANAGEMENT_PANEL);
	}
	
	// �л���������
	private void changeToHomePanel() {
		card.show(frame.getContentPane(), CardLable.HOME_PANEL);
	}
	
	// �л�����Ϣ��������
	private void changeToInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.INFO_SEARCH_PANEL);
	}
	
	// �л�����½����
	private void changeToLoginPanel() {
		card.show(frame.getContentPane(), CardLable.LOGIN_PANEL);
	}
	
	// �л�����Ա����һ������
	private void changeToMemberManagementPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_MANAGEMENT_PANEL);
	}
	
	// secondLevel
	
	// �л�������鼮����
	private void changeToAddBookPanel() {
		card.show(frame.getContentPane(), CardLable.ADD_BOOK_PANEL);
	}
	
	// �л����������
	private void changeToBorrowBookPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_BOOK_PANEL);
	}
	
	// �л��������������
	private void changeToChangePasswordPanel() {
		card.show(frame.getContentPane(), CardLable.CHANGE_PASSWORD_PANEL);
	}
	
	// �л���ɾ���鼮����
	private void changeToDeleteBookPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_BOOK_PANEL);
	}
	
	// �л���ɾ���˻�����
	private void changeToDeleteCountPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_COUNT_PANEL);
	}
	
	// �л�����������
	private void changeToOpenCountPanel() {
		card.show(frame.getContentPane(), CardLable.OPEN_COUNT_PANEL);
	}
	
	// �л����������
	private void changeToReturnBookPanel() {
		card.show(frame.getContentPane(), CardLable.RETURN_BOOK_PANEL);
	}
	
	// infoSearch
	
	// �л����鼮��Ϣ��������
	private void changeToBookInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_INFO_SEARCH_PANEL);
	}
	
	// �л���������Ϣ��������
	private void changeToBorrowInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_INFO_SEARCH_PANEL);
	}
	
	// �л�����ʷ��¼��Ϣ��������
	private void changeToHistoryInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.HISTORY_INFO_SEARCH_PANEL);
	}
	
	// �л�����Ա��Ϣ��������
	private void changeToMemberInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_INFO_SEARCH_PANEL);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// �˳�ϵͳ
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
