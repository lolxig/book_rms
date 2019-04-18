package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 *
 * description: 开户界面
 * 
 * 				主要组件： 两个提示，两个输入框
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 通过测试
 * complete time: 2019-3-31 13:45:17
 * 
 */

public class OpenCountPanel extends JPanel {
	
	private JTextArea memberName = null,	// 会员名
					  memberPhone = null;	// 会员手机号
	private JButton yesButton = null,		// 确认
					backOf = null;			// 返回
	
	// 返回输入的会员名
	public String getEnterMemberName() {
		return memberName.getText();
	}
	// 返回输入的会员手机号
	public String getEnterMemberPhone() {
		return memberPhone.getText();
	}
	// 返回确认按钮
	public JButton getYesButton() {
		return yesButton;
	}
	// 返回返回按钮
	public JButton getBackOf() {
		return backOf;
	}
	
	// 构造，画界面
	public OpenCountPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("开户", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 会员名输入提示 */
		JLabel memberNameEnterNote = new JLabel("会员名");
		
		memberNameEnterNote.setBounds(170, 160, 90, 30);
		memberNameEnterNote.setOpaque(true);
		memberNameEnterNote.setForeground(Color.WHITE);
		memberNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberNameEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 会员名输入框 */
		memberName = new JTextArea();
		
		memberName.setBounds(270, 160, 120, 30);
		memberName.setOpaque(true);

		
		/* 会员手机号输入提示 */
		JLabel memberPhoneEnterNote = new JLabel("会员手机号");
		
		memberPhoneEnterNote.setBounds(170, 220, 90, 30);
		memberPhoneEnterNote.setOpaque(true);
		memberPhoneEnterNote.setForeground(Color.WHITE);
		memberPhoneEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberPhoneEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 会员手机号输入框 */
		memberPhone = new JTextArea();
		
		memberPhone.setBounds(270, 220, 120, 30);
		memberPhone.setOpaque(true);
		
		
		/* 画确认按钮 */
		yesButton = new JButton("确认");
		
		yesButton.setBounds(200, 295, 70, 30);
		yesButton.setFont(new Font("宋体", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);
		
		
		/* 画返回上一层按钮 */
		backOf = new JButton("返回");
		
		backOf.setBounds(300, 295, 70, 30);
		backOf.setFont(new Font("宋体", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* 组件添加到Panel */
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
