package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 *
 * description: �������
 * 
 * 				��Ҫ������ĸ���ʾ���ĸ������
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ����ͨ��
 * complete time: 2019-4-16 20:49:11
 * 
 */

public class ReturnBookPanel extends JPanel {
	
	private JTextArea memberId = null,		// ��Ա��
					  memberName = null,	// ��Ա��
					  bookId = null,		// ���
					  bookName = null;		// ����
	
	private JButton yesButton = null,		// ȷ��
					backOf = null;			// ����
	
	private JLabel successNote = null;		// �ɹ���ʾ
	
	// ���ػ�ԱID
	public String getEnterMemberId() {
		return memberId.getText();
	}
	// ���ػ�Ա��
	public String getEnterMemberName() {
		return memberName.getText();
	}
	// �������
	public String getEnterBookId() {
		return bookId.getText();
	}
	// ��������
	public String getEnterBookName() {
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
	
	// ����successNoteLable
	public JLabel getSuccessNoteLable() {
		return successNote;
	}
	
	// ��������
	public void clearEnterArea() {
		memberId.setText("");
		memberName.setText("");
		bookId.setText("");
		bookName.setText("");
	}
		
	// ���죬������
	public ReturnBookPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("����", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ��Ա��������ʾ */
		JLabel memberIdEnterNote = new JLabel("��Ա��");
		
		memberIdEnterNote.setBounds(170, 130, 90, 30);
		memberIdEnterNote.setOpaque(true);
		memberIdEnterNote.setForeground(Color.WHITE);
		memberIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberIdEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��Ա������� */
		memberId = new JTextArea();
		
		memberId.setBounds(270, 130, 120, 30);
		memberId.setOpaque(true);
		
		
		/* ��Ա��������ʾ */
		JLabel memberNameEnterNote = new JLabel("��Ա��");
		
		memberNameEnterNote.setBounds(170, 170, 90, 30);
		memberNameEnterNote.setOpaque(true);
		memberNameEnterNote.setForeground(Color.WHITE);
		memberNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberNameEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��Ա������� */
		memberName = new JTextArea();
		
		memberName.setBounds(270, 170, 120, 30);
		memberName.setOpaque(true);
		
		
		/* ���������ʾ */
		JLabel bookIdEnterNote = new JLabel("���");
		
		bookIdEnterNote.setBounds(170, 210, 90, 30);
		bookIdEnterNote.setOpaque(true);
		bookIdEnterNote.setForeground(Color.WHITE);
		bookIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookIdEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* �������� */
		bookName = new JTextArea();
		
		bookName.setBounds(270, 210, 120, 30);
		bookName.setOpaque(true);
		

		/* ����������ʾ */
		JLabel bookNameEnterNote = new JLabel("����");
		
		bookNameEnterNote.setBounds(170, 250, 90, 30);
		bookNameEnterNote.setOpaque(true);
		bookNameEnterNote.setForeground(Color.WHITE);
		bookNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookNameEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��������� */
		bookId = new JTextArea();
		
		bookId.setBounds(270, 250, 120, 30);
		bookId.setOpaque(true);
		
		
		
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
		
		
		/* �ɹ���ʾ */
		successNote = new JLabel("����ɹ�");
		
		successNote.setBounds(400, 250, 90, 30);
		successNote.setOpaque(true);
		successNote.setForeground(Color.RED);
		successNote.setBackground(new Color(MyScreen.colorOfPage));
		successNote.setFont(new Font("����", Font.PLAIN, 16));	
		successNote.setVisible(false);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(memberIdEnterNote);
		this.add(memberId);
		this.add(memberNameEnterNote);
		this.add(memberName);
		this.add(bookIdEnterNote);
		this.add(bookId);
		this.add(bookNameEnterNote);
		this.add(bookName);
		
		this.add(successNote);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
	
	
	
	
	
	
	
}
