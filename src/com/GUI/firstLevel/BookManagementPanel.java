package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 *
 * description: �鼮�������
 * 
 * 				��Ҫ����� ������ť�����ֱܷ��������鼮��ɾ���鼮
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ��ͨ������
 * 
 * complete time: 2019-3-29 19:57:02
 * 
 */

public class BookManagementPanel extends JPanel {
	
	private JButton addBook = null,			// ����鼮
					deleteBook = null,		// ɾ���鼮
					backOf = null;			// ������һ��

	// ��ȡ��ť
	public JButton getAddBook() {
		return addBook;
	}
	public JButton getDeleteBook() {
		return deleteBook;
	}
	public JButton getBackOf() {
		return backOf;
	}
	
	// ���죬������
	public BookManagementPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("�鼮����", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ������鼮��ť */
		addBook = new JButton("����鼮");
		
		addBook.setBounds(125, 170, 150, 30);
		addBook.setFont(new Font("����", Font.PLAIN, 16));
		addBook.setContentAreaFilled(false);
		addBook.setFocusPainted(false);
		addBook.setForeground(Color.WHITE);
		
		
		/* ��ɾ���鼮��ť */
		deleteBook = new JButton("ɾ���鼮");
		
		deleteBook.setBounds(325, 170, 150, 30);
		deleteBook.setFont(new Font("����", Font.PLAIN, 16));
		deleteBook.setContentAreaFilled(false);
		deleteBook.setFocusPainted(false);
		deleteBook.setForeground(Color.WHITE);
		
		
		/* ��������һ�㰴ť */
		backOf = new JButton("������һ��");
		
		backOf.setBounds(225, 250, 150, 30);
		backOf.setFont(new Font("����", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(addBook);
		this.add(deleteBook);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
