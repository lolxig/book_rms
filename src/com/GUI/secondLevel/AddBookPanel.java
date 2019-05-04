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
 * 				��Ҫ����� �ĸ���ʾ���ĸ������
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * 
 * note: ����ͨ��
 * complete time: 2019-4-16 21:17:51
 *
 */

public class AddBookPanel extends JPanel {
	
	private JTextArea bookName = null,		// ����
					  authorName = null,	// ����
					  press = null,			// ������
					  amount = null;		// ����
	
	private JButton yesButton = null,		// ȷ��
					backOf = null;			// ����
	
	private JLabel successNote = null;		// �����ɹ���ʾ
	
	// ��������
	public String getBookName() {
		return bookName.getText();
	}
	// ����������
	public String getAuthorName() {
		return authorName.getText();
	}
	// ���س�����
	public String getPress() {
		return press.getText();
	}
	// ��������
	public String getAmount() {
		return amount.getText();
	}
	// ����ȷ�ϰ�ť
	public JButton getYesButton() {
		return yesButton;
	}
	// ���ط��ذ�ť
	public JButton getBackOf() {
		return backOf;
	}
	
	// ���ز����ɹ���ʾ��
	public JLabel getSuccessNote() {
		return successNote;
	}
	
	// ��������
	public void clearEnterArea() {
		bookName.setText("");
		authorName.setText("");
		press.setText("");
		amount.setText("");
	}
	
	// ���죬������
	public AddBookPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("����鼮", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ����������ʾ */
		JLabel bookNameEnterNote = new JLabel("����");
		
		bookNameEnterNote.setBounds(170, 130, 90, 30);
		bookNameEnterNote.setOpaque(true);
		bookNameEnterNote.setForeground(Color.WHITE);
		bookNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookNameEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��������� */
		bookName = new JTextArea();
		
		bookName.setBounds(270, 130, 120, 30);
		bookName.setOpaque(true);
		
		
		/* ����������ʾ */
		JLabel authorNameEnterNote = new JLabel("����");
		
		authorNameEnterNote.setBounds(170, 170, 90, 30);
		authorNameEnterNote.setOpaque(true);
		authorNameEnterNote.setForeground(Color.WHITE);
		authorNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		authorNameEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��������� */
		authorName = new JTextArea();
		
		authorName.setBounds(270, 170, 120, 30);
		authorName.setOpaque(true);
		
		
		/* ������������ʾ */
		JLabel pressEnterNote = new JLabel("������");
		
		pressEnterNote.setBounds(170, 210, 90, 30);
		pressEnterNote.setOpaque(true);
		pressEnterNote.setForeground(Color.WHITE);
		pressEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		pressEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ����������� */
		press = new JTextArea();
		
		press.setBounds(270, 210, 120, 30);
		press.setOpaque(true);
		

		/* ����������ʾ */
		JLabel amountEnterNote = new JLabel("����");
		
		amountEnterNote.setBounds(170, 250, 90, 30);
		amountEnterNote.setOpaque(true);
		amountEnterNote.setForeground(Color.WHITE);
		amountEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		amountEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��������� */
		amount = new JTextArea();
		
		amount.setBounds(270, 250, 120, 30);
		amount.setOpaque(true);
		
		
		
		/* ��ȷ�ϰ�ť */
		yesButton = new JButton("ȷ��");
		
		yesButton.setBounds(200, 315, 70, 30);
		yesButton.setFont(new Font("����", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);
		
		
		/* ��������һ�㰴ť */
		backOf = new JButton("����");
		
		backOf.setBounds(300, 315, 70, 30);
		backOf.setFont(new Font("����", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* ��ӳɹ���ʾ */
		successNote = new JLabel("��ӳɹ�");
		
		successNote.setBounds(400, 250, 90, 30);
		successNote.setOpaque(true);
		successNote.setForeground(Color.RED);
		successNote.setBackground(new Color(MyScreen.colorOfPage));
		successNote.setFont(new Font("����", Font.PLAIN, 16));
		successNote.setVisible(false);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(bookNameEnterNote);
		this.add(bookName);
		this.add(authorNameEnterNote);
		this.add(authorName);
		this.add(pressEnterNote);
		this.add(press);
		this.add(amountEnterNote);
		this.add(amount);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.add(successNote);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
