package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 * 
 * description: 修改密码界面
 * 
 * 				主要组件： 三个Label，三个passwordfeild，一个确认button，一个返回button
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * 
 * note: 已通过测试
 * complete time: 2019-3-31 13:16:03
 * 
 */

public class ChangePasswordPanel extends JPanel {
	
	private JPasswordField formerPassword = null,		// 旧密码
						   newPassword = null,			// 新密码
						   verifyPassword = null;		// 确认新密码
	private JButton yesButton = null,					// 确认按钮
					backOf = null;						// 返回上一层
	
	// 返回输入的旧密码
	public String getEnterFormerPassword() {
		return String.valueOf(formerPassword.getPassword());
	}
	// 返回输入的新密码
	public String getEnterNewPassword() {
		return String.valueOf(newPassword.getPassword());
	}
	// 返回输入的确认密码
	public String getEnterVerifyPassword() {
		return String.valueOf(verifyPassword.getPassword());
	}
	// 返回确认按钮
	public JButton getYesButton() {
		return yesButton;
	}
	// 返回返回上一层按钮
	public JButton getBackOf() {
		return backOf;
	}
	
	
	// 构造，画界面
	public ChangePasswordPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("修改密码", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 旧密码输入提示 */
		JLabel formerPasswordNote = new JLabel("旧密码");
		
		formerPasswordNote.setBounds(170, 135, 90, 30);
		formerPasswordNote.setOpaque(true);
		formerPasswordNote.setForeground(Color.WHITE);
		formerPasswordNote.setBackground(new Color(MyScreen.colorOfPage));
		formerPasswordNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 画旧密码框 */
		formerPassword = new JPasswordField();
		
		formerPassword.setBounds(270, 135, 120, 30);
		formerPassword.setOpaque(true);
		
		
		/* 新密码输入提示 */
		JLabel newPasswordNote = new JLabel("新密码");
		
		newPasswordNote.setBounds(170, 185, 90, 30);
		newPasswordNote.setOpaque(true);
		newPasswordNote.setForeground(Color.WHITE);
		newPasswordNote.setBackground(new Color(MyScreen.colorOfPage));
		newPasswordNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 新旧密码框 */
		newPassword = new JPasswordField();
		
		newPassword.setBounds(270, 185, 120, 30);
		newPassword.setOpaque(true);
		
		
		/* 再次确认输入提示 */
		JLabel verifyPasswordNote = new JLabel("再次确认");
		
		verifyPasswordNote.setBounds(170, 235, 90, 30);
		verifyPasswordNote.setOpaque(true);
		verifyPasswordNote.setForeground(Color.WHITE);
		verifyPasswordNote.setBackground(new Color(MyScreen.colorOfPage));
		verifyPasswordNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 再次确认密码框 */
		verifyPassword = new JPasswordField();
		
		verifyPassword.setBounds(270, 235, 120, 30);
		verifyPassword.setOpaque(true);
		
		
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
		this.add(formerPasswordNote);
		this.add(formerPassword);
		this.add(newPasswordNote);
		this.add(newPassword);
		this.add(verifyPasswordNote);
		this.add(verifyPassword);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
