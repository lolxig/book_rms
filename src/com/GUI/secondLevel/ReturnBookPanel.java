package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 *
 * description: 还书界面
 * 
 * 				主要组件：四个提示框，四个输入框
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 测试通过
 * complete time: 2019-4-16 20:49:11
 * 
 */

public class ReturnBookPanel extends JPanel {
	
	private JTextArea memberId = null,		// 会员号
					  memberName = null,	// 会员名
					  bookId = null,		// 书号
					  bookName = null;		// 书名
	
	private JButton yesButton = null,		// 确认
					backOf = null;			// 返回
	
	private JLabel successNote = null;		// 成功提示
	
	// 返回会员ID
	public String getEnterMemberId() {
		return memberId.getText();
	}
	// 返回会员名
	public String getEnterMemberName() {
		return memberName.getText();
	}
	// 返回书号
	public String getEnterBookId() {
		return bookId.getText();
	}
	// 返回书名
	public String getEnterBookName() {
		return bookName.getText();
	}
	// 返回确认按钮
	public JButton getYesButton() {
		return yesButton;
	}
	// 返回返回按钮
	public JButton getBackOf() {
		return backOf;
	}
	
	// 返回successNoteLable
	public JLabel getSuccessNoteLable() {
		return successNote;
	}
	
	// 清除输入框
	public void clearEnterArea() {
		memberId.setText("");
		memberName.setText("");
		bookId.setText("");
		bookName.setText("");
	}
		
	// 构造，画界面
	public ReturnBookPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("还书", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 会员号输入提示 */
		JLabel memberIdEnterNote = new JLabel("会员号");
		
		memberIdEnterNote.setBounds(170, 130, 90, 30);
		memberIdEnterNote.setOpaque(true);
		memberIdEnterNote.setForeground(Color.WHITE);
		memberIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberIdEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 会员号输入框 */
		memberId = new JTextArea();
		
		memberId.setBounds(270, 130, 120, 30);
		memberId.setOpaque(true);
		
		
		/* 会员名输入提示 */
		JLabel memberNameEnterNote = new JLabel("会员名");
		
		memberNameEnterNote.setBounds(170, 170, 90, 30);
		memberNameEnterNote.setOpaque(true);
		memberNameEnterNote.setForeground(Color.WHITE);
		memberNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		memberNameEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 会员名输入框 */
		memberName = new JTextArea();
		
		memberName.setBounds(270, 170, 120, 30);
		memberName.setOpaque(true);
		
		
		/* 书号输入提示 */
		JLabel bookIdEnterNote = new JLabel("书号");
		
		bookIdEnterNote.setBounds(170, 210, 90, 30);
		bookIdEnterNote.setOpaque(true);
		bookIdEnterNote.setForeground(Color.WHITE);
		bookIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookIdEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 书号输入框 */
		bookName = new JTextArea();
		
		bookName.setBounds(270, 210, 120, 30);
		bookName.setOpaque(true);
		

		/* 书名输入提示 */
		JLabel bookNameEnterNote = new JLabel("书名");
		
		bookNameEnterNote.setBounds(170, 250, 90, 30);
		bookNameEnterNote.setOpaque(true);
		bookNameEnterNote.setForeground(Color.WHITE);
		bookNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookNameEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 书名输入框 */
		bookId = new JTextArea();
		
		bookId.setBounds(270, 250, 120, 30);
		bookId.setOpaque(true);
		
		
		
		/* 画确认按钮 */
		yesButton = new JButton("确认");
		
		yesButton.setBounds(200, 315, 70, 30);
		yesButton.setFont(new Font("宋体", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);
		
		
		/* 画返回上一层按钮 */
		backOf = new JButton("返回");
		
		backOf.setBounds(300, 315, 70, 30);
		backOf.setFont(new Font("宋体", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* 成功提示 */
		successNote = new JLabel("还书成功");
		
		successNote.setBounds(400, 250, 90, 30);
		successNote.setOpaque(true);
		successNote.setForeground(Color.RED);
		successNote.setBackground(new Color(MyScreen.colorOfPage));
		successNote.setFont(new Font("宋体", Font.PLAIN, 16));	
		successNote.setVisible(false);
		
		
		/* 组件添加到Panel */
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
