package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 * 
 * description: �����鼮����
 * 
 * 				��Ҫ����� ������ʾ�����������
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ����ͨ��
 * complete time: 2019-4-16 22:03:58
 *
 */


public class DeleteBookPanel extends JPanel {
	
	private JTextArea bookId = null,		// ���
			  		  bookName = null;		// ����
	private JButton yesButton = null,		// ȷ��
					backOf = null;			// ����
	
	// �������
	public String getBookId() {
		return bookId.getText();
	}
	// ��������
	public String getBookName() {
		return bookName.getText();
	}
	// ����ȷ�ϰ�ť
	public JButton getYesButton() {
		return yesButton;
	}
	// ���ط��ذ�ť
	public JButton getBackOf() {
		return backOf;
	}
	
	// ���죬������
	public DeleteBookPanel() {
		initGUI();
	}
	
	private void initGUI() {

		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("ɾ���鼮", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ���������ʾ */
		JLabel bookIdEnterNote = new JLabel("���");
		
		bookIdEnterNote.setBounds(170, 130, 90, 30);
		bookIdEnterNote.setOpaque(true);
		bookIdEnterNote.setForeground(Color.WHITE);
		bookIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookIdEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* �������� */
		bookId = new JTextArea();
		
		bookId.setBounds(270, 130, 120, 30);
		bookId.setOpaque(true);
		
		
		/* ����������ʾ */
		JLabel bookNameEnterNote = new JLabel("����");
		
		bookNameEnterNote.setBounds(170, 180, 90, 30);
		bookNameEnterNote.setOpaque(true);
		bookNameEnterNote.setForeground(Color.WHITE);
		bookNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookNameEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��������� */
		bookName = new JTextArea();
		
		bookName.setBounds(270, 180, 120, 30);
		bookName.setOpaque(true);
		
		
		
		/* ��ȷ�ϰ�ť */
		yesButton = new JButton("ȷ��");
		
		yesButton.setBounds(200, 250, 70, 30);
		yesButton.setFont(new Font("����", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);
		
		
		/* ��������һ�㰴ť */
		backOf = new JButton("����");
		
		backOf.setBounds(300, 250, 70, 30);
		backOf.setFont(new Font("����", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(bookIdEnterNote);
		this.add(bookId);
		this.add(bookNameEnterNote);
		this.add(bookName);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
		
	}

}
