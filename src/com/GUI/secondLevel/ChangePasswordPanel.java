package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 * 
 * description: �޸��������
 * 
 * 				��Ҫ����� ����Label������passwordfeild��һ��ȷ��button��һ������button
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * 
 * note: ��ͨ������
 * complete time: 2019-3-31 13:16:03
 * 
 * ************************************************************************************
 * 
 * change: ���һ���������������ʾlable
 * time: 2019-4-19 16:59:58
 * 
 */

public class ChangePasswordPanel extends JPanel {
	
	private JPasswordField formerPassword = null,		// ������
						   newPassword = null,			// ������
						   verifyPassword = null;		// ȷ��������
	
	private JButton yesButton = null,					// ȷ�ϰ�ť
					backOf = null;						// ������һ��
	
	private JLabel wrongPassword = null,				// �������벻��ȷ
				   wrongVerifyPassword = null,			// �������벻һ��
				   changeSuccessNote = null;			// �޸ĳɹ���ʾ
	
	// ��������ľ�����
	public String getEnterFormerPassword() {
		return String.valueOf(formerPassword.getPassword());
	}
	
	// ���������������
	public String getEnterNewPassword() {
		return String.valueOf(newPassword.getPassword());
	}
	
	// ���������ȷ������
	public String getEnterVerifyPassword() {
		return String.valueOf(verifyPassword.getPassword());
	}
	
	// ��������
	public void clearEnterArea() {
		formerPassword.setText("");
		newPassword.setText("");
		verifyPassword.setText("");
	}
	
	// ����ȷ�ϰ�ť
	public JButton getYesButton() {
		return yesButton;
	}
	
	// ���ط�����һ�㰴ť
	public JButton getBackOf() {
		return backOf;
	}
	
	// ����wrongPasswordLable
	public JLabel getWrongPasswordLable() {
		return wrongPassword;
	}
	
	// ����wrongVerifyPasswordLable
	public JLabel getWrongVerifyPasswordLable() {
		return wrongVerifyPassword;
	}
	
	// ����changeSuccessNoteLable
	public JLabel getChangeSuccessNote() {
		return changeSuccessNote;
	}
	
	// ���죬������
	public ChangePasswordPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("�޸�����", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ������������ʾ */
		JLabel formerPasswordNote = new JLabel("������");
		
		formerPasswordNote.setBounds(170, 135, 90, 30);
		formerPasswordNote.setOpaque(true);
		formerPasswordNote.setForeground(Color.WHITE);
		formerPasswordNote.setBackground(new Color(MyScreen.colorOfPage));
		formerPasswordNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* ��������� */
		formerPassword = new JPasswordField();
		
		formerPassword.setBounds(270, 135, 120, 30);
		formerPassword.setOpaque(true);
		
		
		/* ������������ʾ */
		JLabel newPasswordNote = new JLabel("������");
		
		newPasswordNote.setBounds(170, 185, 90, 30);
		newPasswordNote.setOpaque(true);
		newPasswordNote.setForeground(Color.WHITE);
		newPasswordNote.setBackground(new Color(MyScreen.colorOfPage));
		newPasswordNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* �¾������ */
		newPassword = new JPasswordField();
		
		newPassword.setBounds(270, 185, 120, 30);
		newPassword.setOpaque(true);
		
		
		/* �ٴ�ȷ��������ʾ */
		JLabel verifyPasswordNote = new JLabel("�ٴ�ȷ��");
		
		verifyPasswordNote.setBounds(170, 235, 90, 30);
		verifyPasswordNote.setOpaque(true);
		verifyPasswordNote.setForeground(Color.WHITE);
		verifyPasswordNote.setBackground(new Color(MyScreen.colorOfPage));
		verifyPasswordNote.setFont(new Font("����", Font.PLAIN, 16));
		
		
		/* �ٴ�ȷ������� */
		verifyPassword = new JPasswordField();
		
		verifyPassword.setBounds(270, 235, 120, 30);
		verifyPassword.setOpaque(true);
		
		
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
		
		
		/* ��������� */
		wrongPassword = new JLabel("�������");
		
		wrongPassword.setBounds(400, 135, 90, 30);
		wrongPassword.setOpaque(true);
		wrongPassword.setForeground(Color.RED);
		wrongPassword.setBackground(new Color(MyScreen.colorOfPage));
		wrongPassword.setFont(new Font("����", Font.PLAIN, 16));
		wrongPassword.setVisible(false);
		
		
		/* �������벻һ�� */
		wrongVerifyPassword = new JLabel("�������벻һ��");
		
		wrongVerifyPassword.setBounds(400, 235, 150, 30);
		wrongVerifyPassword.setOpaque(true);
		wrongVerifyPassword.setForeground(Color.RED);
		wrongVerifyPassword.setBackground(new Color(MyScreen.colorOfPage));
		wrongVerifyPassword.setFont(new Font("����", Font.PLAIN, 16));
		wrongVerifyPassword.setVisible(false);
		
		
		/* �޸ĳɹ���ʾ */
		changeSuccessNote = new JLabel("�����޸ĳɹ�");
		
		changeSuccessNote.setBounds(400, 235, 150, 30);
		changeSuccessNote.setOpaque(true);
		changeSuccessNote.setForeground(Color.RED);
		changeSuccessNote.setBackground(new Color(MyScreen.colorOfPage));
		changeSuccessNote.setFont(new Font("����", Font.PLAIN, 16));
		changeSuccessNote.setVisible(false);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(formerPasswordNote);
		this.add(formerPassword);
		this.add(newPasswordNote);
		this.add(newPassword);
		this.add(verifyPasswordNote);
		this.add(verifyPassword);
		
		this.add(wrongPassword);
		this.add(wrongVerifyPassword);
		this.add(changeSuccessNote);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
