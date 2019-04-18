package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 *
 * description: 注销界面
 * 
 * 				主要组件： 两个提示，两个输入框
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 已通过测试
 * complete time: 2019-3-31 14:01:59
 * 
 */

public class DeleteCountPanel extends JPanel {
	
	private JTextArea memberId = null,	// 会员号
					  memberName = null;	// 会员名
	private JButton yesButton = null,		// 确认
					backOf = null;			// 返回
	
	// 返回输入的会员号
	public String getEnterMemberId() {
		return memberId.getText();
	}
	// 返回输入的会员名
	public String getEnterMemberName() {
		return memberName.getText();
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
	public DeleteCountPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("注销", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 会员号输入提示 */
		JLabel memberIdEnterNote = new JLabel("会员号");
		
		memberIdEnterNote.setBounds(170, 160, 90, 30);
		memberIdEnterNote.setOpaque(true);
		memberIdEnterNote.setForeground(Color.WHITE);
		memberIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberIdEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 会员号输入框 */
		memberId = new JTextArea();
		
		memberId.setBounds(270, 160, 120, 30);
		memberId.setOpaque(true);

		
		/* 会员名输入提示 */
		JLabel memberNameEnterNote = new JLabel("会员名");
		
		memberNameEnterNote.setBounds(170, 220, 90, 30);
		memberNameEnterNote.setOpaque(true);
		memberNameEnterNote.setForeground(Color.WHITE);
		memberNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberNameEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 会员名输入框 */
		memberName = new JTextArea();
		
		memberName.setBounds(270, 220, 120, 30);
		memberName.setOpaque(true);
		
		
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
		this.add(memberIdEnterNote);
		this.add(memberId);
		this.add(memberNameEnterNote);
		this.add(memberName);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
