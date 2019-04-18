package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 *
 * description: ��������
 * 
 * 				��Ҫ����� ������ʾ�����������
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ͨ������
 * complete time: 2019-3-31 13:45:17
 * 
 */

public class OpenCountPanel extends JPanel {
	
	private JTextArea memberName = null,	// ��Ա��
					  memberPhone = null;	// ��Ա�ֻ���
	private JButton yesButton = null,		// ȷ��
					backOf = null;			// ����
	
	// ��������Ļ�Ա��
	public String getEnterMemberName() {
		return memberName.getText();
	}
	// ��������Ļ�Ա�ֻ���
	public String getEnterMemberPhone() {
		return memberPhone.getText();
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
	public OpenCountPanel() {
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
		JLabel memberNameEnterNote = new JLabel("��Ա��");
		
		memberNameEnterNote.setBounds(170, 160, 90, 30);
		memberNameEnterNote.setOpaque(true);
		memberNameEnterNote.setForeground(Color.WHITE);
		memberNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberNameEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��Ա������� */
		memberName = new JTextArea();
		
		memberName.setBounds(270, 160, 120, 30);
		memberName.setOpaque(true);

		
		/* ��Ա�ֻ���������ʾ */
		JLabel memberPhoneEnterNote = new JLabel("��Ա�ֻ���");
		
		memberPhoneEnterNote.setBounds(170, 220, 90, 30);
		memberPhoneEnterNote.setOpaque(true);
		memberPhoneEnterNote.setForeground(Color.WHITE);
		memberPhoneEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberPhoneEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��Ա�ֻ�������� */
		memberPhone = new JTextArea();
		
		memberPhone.setBounds(270, 220, 120, 30);
		memberPhone.setOpaque(true);
		
		
		/* ��ȷ�ϰ�ť */
		yesButton = new JButton("ȷ��");
		
		yesButton.setBounds(200, 295, 70, 30);
		yesButton.setFont(new Font("����", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);
		
		
		/* ��������һ�㰴ť */
		backOf = new JButton("����");
		
		backOf.setBounds(300, 295, 70, 30);
		backOf.setFont(new Font("����", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(memberNameEnterNote);
		this.add(memberName);
		this.add(memberPhoneEnterNote);
		this.add(memberPhone);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
