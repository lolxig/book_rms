package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: ��ҳ��
 * 	
 * 			��Ҫ����� �ĸ�button�����ֱܷ��ǣ��޸����룬��Ա�����鼮������Ϣ��ѯ
 * 			��Ҫ�����һ���˳���ť
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ��ͨ������
 * 
 * complete time: 2019-3-29 17:48:15
 * 
 * 
 */

public class HomePanel extends JPanel {
	
	private JButton changePassword = null,		// �޸�����
					memberManagement = null,	// ��Ա����
					bookManagement = null,		// �鼮����
					infoSearch = null,			// ��Ϣ��ѯ
					exitSystem = null;			// �˳�ϵͳ

	// ��ȡ��ť
	public JButton getChangePassword() {
		return changePassword;
	}
	public JButton getMemberManagement() {
		return memberManagement;
	}
	public JButton getBookManagement() {
		return bookManagement;
	}
	public JButton getInfoSearch() {
		return infoSearch;
	}
	public JButton getExitSystem() {
		return exitSystem;
	}
	
	public HomePanel() {
		initGUI();
	}
	
	// ���죬������
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
		
		
		/* ���޸����밴ť */
		changePassword = new JButton("�޸�����");
		
		changePassword.setBounds(125, 150, 150, 30);
		changePassword.setFont(new Font("����", Font.PLAIN, 16));
		changePassword.setContentAreaFilled(false);
		changePassword.setFocusPainted(false);
		changePassword.setForeground(Color.WHITE);
		
		
		/* ����Ա����ť */
		memberManagement = new JButton("��Ա����");
		
		memberManagement.setBounds(325, 150, 150, 30);
		memberManagement.setFont(new Font("����", Font.PLAIN, 16));
		memberManagement.setContentAreaFilled(false);
		memberManagement.setFocusPainted(false);
		memberManagement.setForeground(Color.WHITE);
		
		
		/* ���鼮����ť*/
		bookManagement = new JButton("�鼮����");
		
		bookManagement.setBounds(125, 210, 150, 30);
		bookManagement.setFont(new Font("����", Font.PLAIN, 16));
		bookManagement.setContentAreaFilled(false);
		bookManagement.setFocusPainted(false);
		bookManagement.setForeground(Color.WHITE);
		
		
		/* ����Ϣ��ѯ��ť */
		infoSearch = new JButton("��Ϣ��ѯ");
		
		infoSearch.setBounds(325, 210, 150, 30);
		infoSearch.setFont(new Font("����", Font.PLAIN, 16));
		infoSearch.setContentAreaFilled(false);
		infoSearch.setFocusPainted(false);
		infoSearch.setForeground(Color.WHITE);
		
		
		/* ���˳�ϵͳ��ť */
		exitSystem = new JButton("�˳�ϵͳ");
		
		exitSystem.setBounds(225, 270, 150, 30);
		exitSystem.setFont(new Font("����", Font.PLAIN, 16));
		exitSystem.setContentAreaFilled(false);
		exitSystem.setFocusPainted(false);
		exitSystem.setForeground(Color.WHITE);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(changePassword);
		this.add(memberManagement);
		this.add(bookManagement);
		this.add(infoSearch);
		this.add(exitSystem);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
