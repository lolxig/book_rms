package com.GUI.secondLevel;

import java.awt.*;
import javax.swing.*;

import com.GUI.firstLevel.MyScreen;

/**
 * 
 * @author xig
 * 
 * description: 增加书籍界面
 * 
 * 				主要组件： 两个提示框，两个输入框
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 测试通过
 * complete time: 2019-4-16 22:03:58
 *
 */


public class DeleteBookPanel extends JPanel {
	
	private JTextArea bookId = null,		// 书号
			  		  bookName = null;		// 书名
	private JButton yesButton = null,		// 确认
					backOf = null;			// 返回
	
	// 返回书号
	public String getBookId() {
		return bookId.getText();
	}
	// 返回书名
	public String getBookName() {
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
	
	// 构造，画界面
	public DeleteBookPanel() {
		initGUI();
	}
	
	private void initGUI() {

		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("删除书籍", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 书号输入提示 */
		JLabel bookIdEnterNote = new JLabel("书号");
		
		bookIdEnterNote.setBounds(170, 130, 90, 30);
		bookIdEnterNote.setOpaque(true);
		bookIdEnterNote.setForeground(Color.WHITE);
		bookIdEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookIdEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 书号输入框 */
		bookId = new JTextArea();
		
		bookId.setBounds(270, 130, 120, 30);
		bookId.setOpaque(true);
		
		
		/* 书名输入提示 */
		JLabel bookNameEnterNote = new JLabel("作者");
		
		bookNameEnterNote.setBounds(170, 180, 90, 30);
		bookNameEnterNote.setOpaque(true);
		bookNameEnterNote.setForeground(Color.WHITE);
		bookNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookNameEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 书名输入框 */
		bookName = new JTextArea();
		
		bookName.setBounds(270, 180, 120, 30);
		bookName.setOpaque(true);
		
		
		
		/* 画确认按钮 */
		yesButton = new JButton("确认");
		
		yesButton.setBounds(200, 250, 70, 30);
		yesButton.setFont(new Font("宋体", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);
		
		
		/* 画返回上一层按钮 */
		backOf = new JButton("返回");
		
		backOf.setBounds(300, 250, 70, 30);
		backOf.setFont(new Font("宋体", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* 组件添加到Panel */
		this.add(title);
		this.add(bookIdEnterNote);
		this.add(bookId);
		this.add(bookNameEnterNote);
		this.add(bookName);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
		
	}

}
