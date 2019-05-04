package com.GUI.firstLevel;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: ��½����
 * 
 * 			��Ҫ�����һ��JPasswordField��һ��JLabel������JButton
 * 
 * �˼·��
 * 			NorthΪ���⣬West East SourthΪ��䣬�м��ٷ�һ��Panel��Ϊ�������
 * 
 * *****************************************************************************
 * 
 * time: 2019-3-29 13:48:25
 * 
 * �˼·��д��
 * 			ʹ�þ��Բ��ַ�ʽ������٣���Ļ����Բ�����Ҫ�������࣬��Ƹ���
 * 
 * 			ע�⣺��Panel��Ҫ���Ⱪ¶һ����ȡ����ӿڣ���������߻�ȡ��Ϣ
 * 					
 * 				��¶����button����������������ť
 * 
 * note: ͨ������
 * 
 * complete time: 2019-3-29 16:28:10
 * 
 *
 */

public class LoginPanel extends JPanel {
	
	
/*
 * note: ����ע�ʹ������ʧ�ܣ���д
 * 
 * time: 2019-3-29 13:42:35
 * 
 * */

// 
//	/* ������� */
//	private JLabel title = null,		// ����Label
//				   note = null;			// ��ʾ��
//	private JPasswordField password = null;	// ���������
//	private JButton login = null,		// ��½��ť
//					exit = null;		// �˳���ť
//	private JPanel exePanel = null;		// �������
//	
//	
//	private JLabel paddingLeft = null,	// �����
//				   paddingRight = null,
//				   paddingDown = null,
//				   paddingExe = null;
//	
//	public LoginPanel() {
//		
//		/* ������� */
//		title = new JLabel("ͼ�����ϵͳ", JLabel.CENTER);
//		note = new JLabel("��������");
//		password = new JPasswordField(6);
//		login = new JButton("��½");
//		exit = new JButton("�˳�");
//		exePanel = new JPanel();
//		
//		
//		paddingLeft = new JLabel("                                                  ");
//		paddingRight = new JLabel("                                                  ");
//		paddingDown = new JLabel(" ");
//		paddingExe = new JLabel(" ");
//		
//		
//		/* ������� */
//		
//		/* ���� Panel����, ʹ��BorderLayout*/
//		this.setLayout(new BorderLayout());
//		this.setBackground(new Color(MyScreen.colorOfPage));
//		
//		
//		/* ��������� */
//		paddingDown.setFont(new Font(" ", Font.PLAIN, 100));
//		paddingExe.setFont(new Font(" ", Font.PLAIN, 60));
//		paddingExe.setOpaque(true);
//		paddingExe.setBackground(new Color(MyScreen.colorOfPage));
//		paddingExe.setForeground(new Color(MyScreen.colorOfPage));
//		
//		/* ����exePanel���� */
//		exePanel.setLayout(new BorderLayout());
//		exePanel.add(paddingExe, BorderLayout.NORTH);
//
//		
//		/* ����title���� */
//		title.setOpaque(true);
//		title.setFont(new Font("����", Font.BOLD, 40));
//		
//		
//		/* ����note���� */
//		note.setOpaque(true);
//		
//		
//		
//		/* ������ */
//		this.add(title, BorderLayout.NORTH);				// ����
//		
//		this.add(paddingLeft, BorderLayout.WEST);			// �����
//		this.add(paddingRight, BorderLayout.EAST);
//		this.add(paddingDown, BorderLayout.SOUTH);
//		
//		this.add(password);
//			
//		this.add(exePanel, BorderLayout.CENTER);			// �������
//	}
	
/*
 * note: ����Ϊʧ�ܴ���	
 * 
 * */
	
	
/*
 * note: ����Ϊ�������
 * 
 * 2019-3-29 13:43:36
 * 
 * */
	
	// ���Ⱪ¶һ��JPasswordField����������ȡ��������
	// ��¶����button
	private JPasswordField pwd = null;
	private JButton login = null,
					exit = null;
	private JLabel wrongPassword = null;
	
	// password��ȡ�ӿ�
	public String getEnterPassword() {
		return String.valueOf(pwd.getPassword());
	}
	
	// wrongPassword��ȡ�ӿ�
	public JLabel getWrongPassword() {
		return wrongPassword;
	}
	
	// ������������
	public void clearPasswordArea() {
		pwd.setText("");
		pwd.requestFocus();				// ��պ��ȡ����
	}
	
	// ����login��ť
	public JButton getLogin() {
		return login;
	}
	
	// ����exit��ť
	public JButton getExit() {
		return exit;
	}

	// ���죬������
	public LoginPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("ͼ�����޹���ϵͳ", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ����������ʾ */
		JLabel note = new JLabel("����������");
		
		note.setBounds(170, 170, 90, 30);
		note.setOpaque(true);
		note.setForeground(Color.WHITE);
		note.setBackground(new Color(MyScreen.colorOfPage));
		note.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ������� */
		pwd = new JPasswordField();
		
		pwd.setBounds(270, 170, 120, 30);
		pwd.setOpaque(true);
		
		
		/* ����½��ť */
		login = new JButton("��½");
		
		login.setBounds(200, 250, 70, 30);
		login.setFont(new Font("����", Font.PLAIN, 16));
		login.setContentAreaFilled(false);
		login.setFocusPainted(false);
//		login.setBorderPainted(false);
		login.setForeground(Color.WHITE);

		
		/* ���˳���ť */
		exit = new JButton("�˳�");
		exit.setBounds(330, 250, 70, 30);
		exit.setFont(new Font("����", Font.PLAIN, 16));
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
//		exit.setBorderPainted(false);
		exit.setForeground(Color.WHITE);
		
		
		/* ���������ʾ */
		wrongPassword = new JLabel("�������");
		
		wrongPassword.setBounds(270, 205, 200, 30);
		wrongPassword.setOpaque(true);
		wrongPassword.setForeground(Color.RED);
		wrongPassword.setBackground(new Color(MyScreen.colorOfPage));
		wrongPassword.setFont(new Font("����", Font.BOLD, 16));
		wrongPassword.setVisible(false);		
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(note);
		this.add(pwd);
		this.add(login);
		this.add(exit);
		this.add(wrongPassword);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
