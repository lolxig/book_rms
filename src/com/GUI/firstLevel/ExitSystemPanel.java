package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: 2019-4-19 14:50:21��ӣ���Ϊ�˳�ϵͳ�Ļ������
 * 
 *
 */

public class ExitSystemPanel extends JPanel {
	
	private JButton yesButton = null,		// ȷ��
					cancelButton = null;	// ȡ��
	
	// ����ȷ�ϰ�ť
	public JButton getYesButton() {
		return yesButton;
	}
	
	// ����ȡ����ť
	public JButton getCancelButton() {
		return cancelButton;
	}
	
	// ���죬������
	public ExitSystemPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ���� */
		JLabel noteLable = new JLabel("ȷ���˳�ϵͳ��", JLabel.CENTER);
		
		noteLable.setBounds(100, 70, 400, 70);
		noteLable.setOpaque(true);
		noteLable.setForeground(Color.YELLOW);
		noteLable.setBackground(new Color(MyScreen.colorOfPage));
		noteLable.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ���ð�ť */
		yesButton = new JButton("ȷ��");
		
		yesButton.setBounds(200, 200, 70, 30);
		yesButton.setFont(new Font("����", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);

		cancelButton = new JButton("ȡ��");
		cancelButton.setBounds(330, 200, 70, 30);
		cancelButton.setFont(new Font("����", Font.PLAIN, 16));
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setForeground(Color.WHITE);
		

		/* ������ */
		this.add(noteLable);
		this.add(yesButton);
		this.add(cancelButton);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
