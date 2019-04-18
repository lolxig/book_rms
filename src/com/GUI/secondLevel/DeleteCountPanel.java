package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 *
 * description: ע������
 * 
 * 				��Ҫ����� ������ʾ�����������
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ��ͨ������
 * complete time: 2019-3-31 14:01:59
 * 
 */

public class DeleteCountPanel extends JPanel {
	
	private JTextArea memberId = null,	// ��Ա��
					  memberName = null;	// ��Ա��
	private JButton yesButton = null,		// ȷ��
					backOf = null;			// ����
	
	// ��������Ļ�Ա��
	public String getEnterMemberId() {
		return memberId.getText();
	}
	// ��������Ļ�Ա��
	public String getEnterMemberName() {
		return memberName.getText();
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
	public DeleteCountPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("ע��", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ��Ա��������ʾ */
		JLabel memberIdEnterNote = new JLabel("��Ա��");
		
		memberIdEnterNote.setBounds(170, 160, 90, 30);
		memberIdEnterNote.setOpaque(true);
		memberIdEnterNote.setForeground(Color.WHITE);
		memberIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberIdEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��Ա������� */
		memberId = new JTextArea();
		
		memberId.setBounds(270, 160, 120, 30);
		memberId.setOpaque(true);

		
		/* ��Ա��������ʾ */
		JLabel memberNameEnterNote = new JLabel("��Ա��");
		
		memberNameEnterNote.setBounds(170, 220, 90, 30);
		memberNameEnterNote.setOpaque(true);
		memberNameEnterNote.setForeground(Color.WHITE);
		memberNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberNameEnterNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��Ա������� */
		memberName = new JTextArea();
		
		memberName.setBounds(270, 220, 120, 30);
		memberName.setOpaque(true);
		
		
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
		this.add(memberIdEnterNote);
		this.add(memberId);
		this.add(memberNameEnterNote);
		this.add(memberName);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
