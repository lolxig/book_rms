package com.GUI.firstLevel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author xig
 * 
 * description: ��Ա�������
 * 
 * 				��Ҫ������ĸ���ť���ֱ��ǿ�����ע�������飬����
 * 				��Ҫ�����������һ��
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ����ͨ��
 * 
 * complete time: 2019-3-29 19:15:37
 * 
 *
 */

public class MemberManagementPanel extends JPanel {
	
	private JButton openCount = null,		// ����
					deleteCount = null,		// ע��
					borrowBook = null,		// ����
					returnBook = null,		// ����
					backOf = null;			// ������һ��
	
	// ��ȡ��ť
	public JButton getOpenCount() {
		return openCount;
	}
	public JButton getDeleteCount() {
		return deleteCount;
	}
	public JButton getBorrowBook() {
		return borrowBook;
	}
	public JButton getReturnBook() {
		return returnBook;
	}
	public JButton getBackOf() {
		return backOf;
	}

	// ���죬������
	public MemberManagementPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("��Ա����", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ��������ť */
		openCount = new JButton("����");
		
		openCount.setBounds(205, 150, 70, 30);
		openCount.setFont(new Font("����", Font.PLAIN, 16));
		openCount.setContentAreaFilled(false);
		openCount.setFocusPainted(false);
		openCount.setForeground(Color.WHITE);
		
		
		/* ��ע����ť */
		deleteCount = new JButton("ע��");
		
		deleteCount.setBounds(325, 150, 70, 30);
		deleteCount.setFont(new Font("����", Font.PLAIN, 16));
		deleteCount.setContentAreaFilled(false);
		deleteCount.setFocusPainted(false);
		deleteCount.setForeground(Color.WHITE);
		
		
		/* �����鰴ť*/
		borrowBook = new JButton("����");
		
		borrowBook.setBounds(205, 210, 70, 30);
		borrowBook.setFont(new Font("����", Font.PLAIN, 16));
		borrowBook.setContentAreaFilled(false);
		borrowBook.setFocusPainted(false);
		borrowBook.setForeground(Color.WHITE);
		
		
		/* �����鰴ť */
		returnBook = new JButton("����");
		
		returnBook.setBounds(325, 210, 70, 30);
		returnBook.setFont(new Font("����", Font.PLAIN, 16));
		returnBook.setContentAreaFilled(false);
		returnBook.setFocusPainted(false);
		returnBook.setForeground(Color.WHITE);
		
		
		/* ��������һ�㰴ť */
		backOf = new JButton("������һ��");
		
		backOf.setBounds(225, 270, 150, 30);
		backOf.setFont(new Font("����", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		

		/* �����ӵ�Panel */
		this.add(title);
		this.add(openCount);
		this.add(deleteCount);
		this.add(borrowBook);
		this.add(returnBook);
		this.add(backOf);
			
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
