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
 * description: ϵͳ���
 * 
 *  			��Ҫ�����
 *  					����������PANEL������ӽ�����Ȼ����һ��frame��һ��card
 *  					
 *  					Ȼ�����ĸ��ڲ��ӿڣ��ṩ���ܵĽӿ�
 *  
 *  					�������ģ�Ҫɶ��ɶ
 * 
 * project link: https://github.com/lolxig/book_rms.git
 * 				���ο�����Դ����ȫ���й���git�������ں����İ汾����
 * 
 */

public class BookRentalManagementSystem {
	
	
	/***************/
	/*  ����Panel  */
	/***************/
	
	// GUI���
	
	// frame��card
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
	
	
	// �ڲ��ӿ�
	private BookOperation bookOperation = null;
	private InfoSearchOperation infoSearchOperation = null;
	private MemberOperation memberOperation = null;
	private PasswordOperation passwordOperation = null;
	
	// ��¼��һ����Ƭ
	private String lastCard = null;
	
	
	/**************/
	/*  ϵͳ���  */
	/**************/
	
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
	
	
	
	/************/
	/*  ��ʼ��  */
	/************/
	
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
	
	// frame��card��ʼ��
	private void frameInit() {
		
		// �������
		card = new CardLayout();
		frame = new JFrame();
		
		// ����Ϊ��Ƭ����
		frame.setLayout(card);
		
		// ���PANEL
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
		
		// frame����
		frame.setTitle("ͼ�����޹���ϵͳ");
		frame.setSize(MyScreen.WIDTH, MyScreen.HIGHT);
		frame.setLocation(MyScreen.X, MyScreen.Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	
	/****************/
	/*   �����л�    */
	/****************/
	
	// firstLevel
	
	// �л����鼮����panel
	private void changeToBookManagementPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_MANAGEMENT_PANEL);
		actionOfBookManagementPanel();
	}
	
	// �л����˳�ϵͳ�������
	private void changeToExitSystemPanel() {
		card.show(frame.getContentPane(), CardLable.EXIT_SYSTEM_PANEL);
		actionOfExitSystemPanel();
	}
	
	// �л���������
	private void changeToHomePanel() {
		card.show(frame.getContentPane(), CardLable.HOME_PANEL);
		actionOfHomePanel();
	}
	
	// �л�����Ϣ��������
	private void changeToInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.INFO_SEARCH_PANEL);
		actionOfInfoSearchPanel();
	}
	
	// �л�����½����
	private void changeToLoginPanel() {
		card.show(frame.getContentPane(), CardLable.LOGIN_PANEL);
		actionOfLoginPanel();
	}
	
	// �л�����Ա�������
	private void changeToMemberManagementPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_MANAGEMENT_PANEL);
		actionOfMemberManagementPanel();
	}
	
	// secondLevel
	
	// �л�������鼮����
	private void changeToAddBookPanel() {
		card.show(frame.getContentPane(), CardLable.ADD_BOOK_PANEL);
		actionOfAddBookPanel();
	}
	
	// �л����������
	private void changeToBorrowBookPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_BOOK_PANEL);
		actionOfBorrowBookPanel();
	}
	
	// �л��������������
	private void changeToChangePasswordPanel() {
		card.show(frame.getContentPane(), CardLable.CHANGE_PASSWORD_PANEL);
		actionOfChangePasswordPanel();
	}
	
	// �л���ɾ���鼮����
	private void changeToDeleteBookPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_BOOK_PANEL);
		actionOfDeleteBookPanel();
	}
	
	// �л���ɾ���˻�����
	private void changeToDeleteCountPanel() {
		card.show(frame.getContentPane(), CardLable.DELETE_COUNT_PANEL);
		actionOfDeleteCountPanel();
	}
	
	// �л�����������
	private void changeToOpenCountPanel() {
		card.show(frame.getContentPane(), CardLable.OPEN_COUNT_PANEL);
		actionOfOpenCountPanel();
	}
	
	// �л����������
	private void changeToReturnBookPanel() {
		card.show(frame.getContentPane(), CardLable.RETURN_BOOK_PANEL);
		actionOfReturnBookPanel();
	}
	
	// infoSearch
	
	// �л����鼮��Ϣ��������
	private void changeToBookInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BOOK_INFO_SEARCH_PANEL);
		actionOfBookInfoSearchPanel();
	}
	
	// �л���������Ϣ��������
	private void changeToBorrowInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.BORROW_INFO_SEARCH_PANEL);
		actionOfBorrowInfoSearchPanel();
	}
	
	// �л�����ʷ��¼��Ϣ��������
	private void changeToHistoryInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.HISTORY_INFO_SEARCH_PANEL);
		actionOfHistoryInfoSearchPanel();
	}
	
	// �л�����Ա��Ϣ��������
	private void changeToMemberInfoSearchPanel() {
		card.show(frame.getContentPane(), CardLable.MEMBER_INFO_SEARCH_PANEL);
		actionOfMemberInfoSearchPanel();
	}
	
	
	
	/**************/
	/*  ���涯��     */
	/**************/
	
	// �鼮����panel���� __________complete time: 2019-4-19 16:29:51
	private void actionOfBookManagementPanel() {
		
		/**
		 * function: �鼮������涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 16:29:38
		 * 
		 */
		
		bookManagementPanel.getAddBook().addMouseListener(new MouseListener() {		// ����鼮��ť����
			
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
			public void mouseClicked(MouseEvent e) {								// �л�������鼮����
				// TODO Auto-generated method stub
				changeToAddBookPanel();
			}
		});
		
		bookManagementPanel.getDeleteBook().addMouseListener(new MouseListener() {	// ɾ���鼮��ť����
			
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
			public void mouseClicked(MouseEvent e) {								// �л���ɾ���鼮����
				// TODO Auto-generated method stub
				changeToDeleteBookPanel();
			}
		});
		
		bookManagementPanel.getBackOf().addMouseListener(new MouseListener() {		// ������һ�㰴ť����
			
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
			public void mouseClicked(MouseEvent e) {								// ������������
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// �˳�ϵͳPANEL���� __________complete time: 2019-4-19 15:54:17
	private void actionOfExitSystemPanel() {
		
		/**
		 * function: �˳�ϵͳ�������
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 15:53:50
		 * 
		 */
		
		exitSystemPanel.getYesButton().addMouseListener(new MouseListener() {		// ȷ�ϰ�ť����
			
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
		
		exitSystemPanel.getCancelButton().addMouseListener(new MouseListener() {	// ȡ����ť
			
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
				card.show(frame.getContentPane(), lastCard);						// �л�����һ�ſ�Ƭ
			}
		});
		
	}
	
	// �����涯�� __________complete time: 2019-4-19 15:49:59
	private void actionOfHomePanel() {
		
		/**
		 *  funciton: ���ݲ�ͬ�İ�ť����ת����ͬ�Ľ���
		 *  
		 *  note: ����ͨ��
		 *  complete time: 2019-4-19 15:49:46
		 *  
		 * */
		
		homePanel.getChangePassword().addMouseListener(new MouseListener() {		// �޸����밴ť����
			
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
			public void mouseEntered(MouseEvent e) {								// ��Щ������ڵ���ɫ
				// TODO Auto-generated method stub
				homePanel.getChangePassword().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// �л����޸��������
				// TODO Auto-generated method stub
				changeToChangePasswordPanel();
			}
		});
		
		homePanel.getMemberManagement().addMouseListener(new MouseListener() {		// ��Ա����ť����
			
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
				changeToMemberManagementPanel();									// �л�����Ա�������
			}
		});
		
		homePanel.getBookManagement().addMouseListener(new MouseListener() {		// �鼮����ť����
			
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
			public void mouseClicked(MouseEvent e) {							// �л����鼮�������
				// TODO Auto-generated method stub
				changeToBookManagementPanel();
			}
		});
		
		homePanel.getInfoSearch().addMouseListener(new MouseListener() {		// ��Ϣ��ѯ��ť����
			
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
			public void mouseClicked(MouseEvent e) {							// �л�����Ϣ��ѯ����
				// TODO Auto-generated method stub
				changeToInfoSearchPanel();
			}
		});
		
		homePanel.getExitSystem().addMouseListener(new MouseListener() {		// �˳�ϵͳ��ť����
			
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
				lastCard = CardLable.HOME_PANEL;							// ��ת��¼
				changeToExitSystemPanel();									// �л����˳�ϵͳPANEL
			}
		});
		
	}
	
	// ��Ϣ�������涯�� __________complete time: 2019-4-19 16:44:19
	private void actionOfInfoSearchPanel() {
		
		/**
		 * function: ��Ϣ��ѯ���涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 16:44:07
		 * 
		 */
		
		infoSearchPanel.getMemberSearch().addMouseListener(new MouseListener() {	// ��Ա��ѯ��ť����
			
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
			public void mouseClicked(MouseEvent e) {								// �л�����Ա��ѯ����
				// TODO Auto-generated method stub
				changeToMemberInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getBookSearch().addMouseListener(new MouseListener() {		// �鼮��ѯ��ť����
			
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
			public void mouseClicked(MouseEvent e) {								// �л����鼮��ѯ����
				// TODO Auto-generated method stub
				changeToBookInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getBorrowSearch().addMouseListener(new MouseListener() {	// ���Ĳ�ѯ��ť����
			
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
			public void mouseClicked(MouseEvent e) {								// �л������Ĳ�ѯ����
				// TODO Auto-generated method stub
				changeToBorrowInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getHistorySearch().addMouseListener(new MouseListener() {	// ������ʷ��ť����
			
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
			public void mouseClicked(MouseEvent e) {								// �л���������ʷ��ѯ����
				// TODO Auto-generated method stub
				changeToHistoryInfoSearchPanel();
			}
		});
		
		infoSearchPanel.getBackOf().addMouseListener(new MouseListener() {			// ������һ�㰴ť����
			
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
			public void mouseClicked(MouseEvent e) {								// ������������
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// ��½���涯�� __________complete time: 2019-4-19 14:33:25
	private void actionOfLoginPanel() {
		
		/**
		 *  funciton: check password��Ȼ�����ϵͳ���л���������
		 *  
		 *  note: ����ͨ��
		 *  complete time: 2019-4-19 14:27:50 
		 *  
		 * */
		
		loginPanel.getLogin().addMouseListener(new MouseListener() {		// ��½��ť����
			
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
			public void mouseEntered(MouseEvent e) {						// ��Щ������ڵ���ɫ
				// TODO Auto-generated method stub
				loginPanel.getLogin().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {						// ����ϵͳ
				// TODO Auto-generated method stub
				String systemPassword = passwordOperation.getPassword();	// ϵͳ����
				String enterPassword = loginPanel.getEnterPassword();		// ���������
				
				if (systemPassword.equals(enterPassword)) {					// ������ȷ������ϵͳ
					changeToHomePanel();
				} else {
					if (!enterPassword.equals("")) {
						loginPanel.getWrongPassword().setVisible(true);		// ��ʾ���������ʾ
						loginPanel.clearPasswordArea();						// ������������
					}
				}
			}
		});
		
		loginPanel.getExit().addMouseListener(new MouseListener() {			// �˳���ť����
			
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
			public void mouseEntered(MouseEvent e) {						// ��Щ������ڵ���ɫ
				// TODO Auto-generated method stub
				loginPanel.getExit().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {						// �˳�ϵͳ
				// TODO Auto-generated method stub
				lastCard = CardLable.LOGIN_PANEL;							// ��ת��¼
				changeToExitSystemPanel();
			}
		});
		
	}
	
	// ��Ա������涯�� __________complete time: 2019-4-19 16:21:03
	private void actionOfMemberManagementPanel() {
		
		/**
		 * function: ��Ա����Ŀ¼����
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 16:20:20
		 * 
		 */
		
		memberManagementPanel.getOpenCount().addMouseListener(new MouseListener() {		// ������ť����
			
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
			public void mouseClicked(MouseEvent e) {									// �л�����������
				// TODO Auto-generated method stub
				changeToOpenCountPanel();
			}
		});
		
		memberManagementPanel.getDeleteCount().addMouseListener(new MouseListener() {	// ע����ť����
			
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
			public void mouseClicked(MouseEvent e) {									// �л���ע���˻�����
				// TODO Auto-generated method stub
				changeToDeleteCountPanel();
			}
		});
		
		memberManagementPanel.getBorrowBook().addMouseListener(new MouseListener() {	// ���鰴ť����
			
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
			public void mouseClicked(MouseEvent e) {									// �л����������
				// TODO Auto-generated method stub
				changeToBorrowBookPanel();
			}
		});
		
		memberManagementPanel.getReturnBook().addMouseListener(new MouseListener() {	// ���鰴ť����
			
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
			public void mouseClicked(MouseEvent e) {									// �л����������
				// TODO Auto-generated method stub
				changeToReturnBookPanel();
			}
		});
		
		memberManagementPanel.getBackOf().addMouseListener(new MouseListener() {		// ���ذ�ť����
			
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
			public void mouseClicked(MouseEvent e) {									// ������������
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// secondLevel
	
	// ����鼮���涯�� __________complete time: 2019-5-4 16:11:01
	private void actionOfAddBookPanel() {
		
		/**
		 * function: ����鼮���涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-5-4 16:10:47
		 * 
		 */
		
		Book book = new Book();							// ��ȡ����鼮����Ϣ
		
		
		addBookPanel.clearEnterArea();					// ����������Ϣ���
		addBookPanel.getSuccessNote().setVisible(false);
		
		addBookPanel.getYesButton().addMouseListener(new MouseListener() {		// ȷ�ϰ�ť����
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {								// �����Ƴ��ƽ���ɫ
				// TODO Auto-generated method stub
				addBookPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addBookPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// �������
				// TODO Auto-generated method stub
				
				book.setName(addBookPanel.getBookName());						// ��ȡ��Ϣ
				book.setAuthor(addBookPanel.getAuthorName());
				book.setPress(addBookPanel.getPress());
				book.setStock(addBookPanel.getAmount());
				
				bookOperation.addBook(book);									// ������������ݿ�
				addBookPanel.clearEnterArea();									// ����������Ϣ���
				addBookPanel.getSuccessNote().setVisible(true);					// ��ʾ�����ɹ�
			}
		});
		
		addBookPanel.getBackOf().addMouseListener(new MouseListener() {			// ���ذ�ť����
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {								// ������ɫ
				// TODO Auto-generated method stub
				addBookPanel.getBackOf().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addBookPanel.getBackOf().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {							// ���ذ�ť����
				// TODO Auto-generated method stub
				changeToBookManagementPanel();									// �л����鼮�������
			}
		});
		
	}
	
	// ������涯�� __________complete time: 2019-4-19 18:35:57
	private void actionOfBorrowBookPanel() {
		
		/**
		 * function: ������涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 18:35:39
		 */
		
		// ����
		Member member = new Member();
		Book book = new Book();
		
		// ������ʷ
		
		borrowBookPanel.clearEnterArea();
		borrowBookPanel.getSuccessNoteLable().setVisible(false);
		
		borrowBookPanel.getYesButton().addMouseListener(new MouseListener() {	// ȷ�ϰ�ť����
			
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
				
				member.setId(borrowBookPanel.getEnterMemberId());				// ���û�Ա���鼮��Ϣ
				member.setName(borrowBookPanel.getEnterMemberName());
				book.setId(borrowBookPanel.getEnterBookId());
				book.setName(borrowBookPanel.getEnterBookName());
				
				borrowBookPanel.getSuccessNoteLable().setVisible(true);			// ��ʾ��ʾ
				borrowBookPanel.clearEnterArea();
				memberOperation.borrowBook(member, book);						// ������д�����ݿ�

			}
		});
		
		borrowBookPanel.getBackOf().addMouseListener(new MouseListener() {		// ���ذ�ť����
			
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
			public void mouseClicked(MouseEvent e) {							// ���ػ�Ա�������
				// TODO Auto-generated method stub
				borrowBookPanel.clearEnterArea();								// ��������
				changeToMemberManagementPanel();								// �л�����Ա�������
			}
		});
		
	}
	
	// �޸�������涯�� __________complete time: 2019-4-19 17:25:16
	private void actionOfChangePasswordPanel() {
		
		/**
		 * function: �޸�������涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 17:25:03
		 * 
		 */
		
		changePasswordPanel.getYesButton().addMouseListener(new MouseListener() {	// ȷ�ϰ�ť����
			
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
			public void mouseClicked(MouseEvent e) {										// �޸��������
				// TODO Auto-generated method stub
				
				String systemPassword = passwordOperation.getPassword();					// ϵͳ����
				String enterFormerPassword = changePasswordPanel.getEnterFormerPassword();	// ��ȡ����ľ�����
				String enterNewPassword = changePasswordPanel.getEnterNewPassword();		// ��ȡ�����������
				String enterVerifyPassword = changePasswordPanel.getEnterVerifyPassword();	// ��ȡ�����ȷ������
				
				changePasswordPanel.getWrongPasswordLable().setVisible(false);
				changePasswordPanel.getWrongVerifyPasswordLable().setVisible(false);
				changePasswordPanel.getChangeSuccessNote().setVisible(false);
				
				if (!systemPassword.equals(enterFormerPassword)) {							// �жϾ���������				
					changePasswordPanel.getWrongPasswordLable().setVisible(true);			// ��ʾ��ʾ
					changePasswordPanel.clearEnterArea();									// ��������
				} else {
					if (!enterNewPassword.equals(enterVerifyPassword)) {					// �ж����������Ƿ�һ��
						changePasswordPanel.getWrongVerifyPasswordLable().setVisible(true);	// ��ʾ��ʾ
						changePasswordPanel.clearEnterArea();								// ��������	
					} else {			
						changePasswordPanel.getChangeSuccessNote().setVisible(true);		// ��ʾ��ʾ
						passwordOperation.setPassword(enterNewPassword);					// �������ȷ����ȷ�ϸ������룬�޸����ݿ�洢������
					}
				}
			}
		});
		
		changePasswordPanel.getBackOf().addMouseListener(new MouseListener() {	// ���ذ�ť����
			
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
			public void mouseClicked(MouseEvent e) {							// ������������
				// TODO Auto-generated method stub
				changeToHomePanel();
			}
		});
		
	}
	
	// ɾ���鼮���涯�� __________complete time: 2019-5-4 16:22:29
	private void actionOfDeleteBookPanel() {
		
		/**
		 * function: ɾ���鼮���涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-5-4 16:22:16
		 * 
		 */
		
		Book book = new Book();
		
		deleteBookPanel.clearEnterArea();					// ��ճ�ʼ������
		deleteBookPanel.getSuccessNote().setVisible(false);
		
		deleteBookPanel.getYesButton().addMouseListener(new MouseListener() {		// ȷ�ϰ�ť����
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {									// ��Ӱ�ť��ɫЧ��
				// TODO Auto-generated method stub
				deleteBookPanel.getYesButton().setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteBookPanel.getYesButton().setForeground(new Color(MyScreen.colorOfButton));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {								// ȷ�ϰ�ť����
				// TODO Auto-generated method stub
				
				book.setId(deleteBookPanel.getBookId());							// ��ȡ��Ϣ
				book.setName(deleteBookPanel.getBookName());
				
				bookOperation.deleteBook(book);										// ����д�����ݿ�
				deleteBookPanel.getSuccessNote().setVisible(true);					// ��ʾ�����ɹ���ʾ
				deleteBookPanel.clearEnterArea();
			}
		});
		
		deleteBookPanel.getBackOf().addMouseListener(new MouseListener() {			// ���ذ�ť����
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {									// ������ɫ
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
				changeToBookManagementPanel();										// �������鼮�������
			}
		});
		
	}
	
	// ע���˻����涯�� __________complete time: 2019-4-19 18:13:32
	private void actionOfDeleteCountPanel() {
		
		/**
		 * function: ע���˻����涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 18:13:19
		 * 
		 */
		
		Member deleteMember = new Member();		// Ҫ��ɾ���Ļ�Ա
			
		deleteCountPanel.clearEnterArea();
		deleteCountPanel.getDeleteSuccessNoteLable().setVisible(false);
			
		deleteCountPanel.getYesButton().addMouseListener(new MouseListener() {	// ȷ�ϰ�ť����
			
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
				
				deleteCountPanel.getDeleteSuccessNoteLable().setVisible(true);	// ��ʾ��ʾ
				memberOperation.deleteCount(deleteMember);						// �����ݿ�ɾ���˻�
			}
		});
		
		deleteCountPanel.getBackOf().addMouseListener(new MouseListener() {		// ���ذ�ť����
			
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
			public void mouseClicked(MouseEvent e) {							// �л�����Ա�������
				// TODO Auto-generated method stub
				changeToMemberManagementPanel();
			}
		});
		
	}
	
	// �������涯�� __________complete time: 2019-4-19 17:52:40
	private void actionOfOpenCountPanel() {
		
		/**
		 * function: �������涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 17:52:28
		 * 
		 */
		
		Member newMember = new Member();		// �»�Ա

		openCountPanel.clearEnterArea();
		openCountPanel.getOpenCountSuccess().setVisible(false);
		
		openCountPanel.getYesButton().addMouseListener(new MouseListener() {	// ȷ�ϰ�ť����
			
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
			public void mouseClicked(MouseEvent e) {							// ȷ�Ͽ���
				// TODO Auto-generated method stub
				
				newMember.setName(openCountPanel.getEnterMemberName());			// ��ȡ����Ļ�Ա��
				newMember.setPhone(openCountPanel.getEnterMemberPhone());		// ��ȡ����Ļ�Ա�ֻ���
				
				openCountPanel.getOpenCountSuccess().setVisible(true);			// ��ʾ�����ɹ���ʾ
				memberOperation.openCount(newMember);							// �û�������������ݿ�
				openCountPanel.clearEnterArea();
			}
		});
		
		openCountPanel.getBackOf().addMouseListener(new MouseListener() {		// ���ذ�ť����
			
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
			public void mouseClicked(MouseEvent e) {							// ���ػ�Ա�������
				// TODO Auto-generated method stub
				changeToMemberManagementPanel();
			}
		});
		
	}
	
	// ������涯�� __________complete time: 2019-4-19 18:53:50
	private void actionOfReturnBookPanel() {
		
		/**
		 * function: ������涯��
		 * 
		 * note: ����ͨ��
		 * complete time: 2019-4-19 18:53:37
		 */
		
		Member member = new Member();
		Book book = new Book();
		
		returnBookPanel.clearEnterArea();
		returnBookPanel.getSuccessNoteLable().setVisible(false);
		
		returnBookPanel.getYesButton().addMouseListener(new MouseListener() {		// ȷ�ϰ�ť����
			
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
				
				// ¼����Ϣ
				member.setId(returnBookPanel.getEnterMemberId());
				member.setName(returnBookPanel.getEnterMemberName());
				book.setId(returnBookPanel.getEnterBookId());
				book.setName(returnBookPanel.getEnterBookName());
				
				returnBookPanel.clearEnterArea();								// ��������
				returnBookPanel.getSuccessNoteLable().setVisible(true);			// ��ʾ�ɹ���ǩ
				
				memberOperation.returnBook(member, book);						// ¼�����ݿ�
			}
		});
		
		returnBookPanel.getBackOf().addMouseListener(new MouseListener() {		// ���ذ�ť����
			
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
			public void mouseClicked(MouseEvent e) {							// ��������Ա�������
				// TODO Auto-generated method stub
				changeToMemberManagementPanel();
			}
		});
		
	}
	
	// infoSearch
	
	// �鼮��Ϣ�������涯��
	private void actionOfBookInfoSearchPanel() {
		
		/**
		 * function: ֻ��һ����������������һ��
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
	
	// ������Ϣ�������涯��
	private void actionOfBorrowInfoSearchPanel() {
		
		/**
		 * function: ֻ��һ����������������һ��
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
	
	// ��ʷ��¼��Ϣ�������涯��
	private void actionOfHistoryInfoSearchPanel() {
		
		/**
		 * function: ֻ��һ����������������һ��
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
	
	// ��Ա��Ϣ�������涯��
	private void actionOfMemberInfoSearchPanel() {
		
		/**
		 * function: ֻ��һ����������������һ��
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
	/*  ϵͳ����      */
	/**************/
	
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
