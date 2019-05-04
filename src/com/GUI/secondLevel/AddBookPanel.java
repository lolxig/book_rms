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
 * 				主要组件： 四个提示框，四个输入框
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * 
 * note: 测试通过
 * complete time: 2019-4-16 21:17:51
 *
 */

public class AddBookPanel extends JPanel {
	
	private JTextArea bookName = null,		// 书名
					  authorName = null,	// 作者
					  press = null,			// 出版社
					  amount = null;		// 数量
	
	private JButton yesButton = null,		// 确认
					backOf = null;			// 返回
	
	private JLabel successNote = null;		// 操作成功提示
	
	// 返回书名
	public String getBookName() {
		return bookName.getText();
	}
	// 返回作者名
	public String getAuthorName() {
		return authorName.getText();
	}
	// 返回出版社
	public String getPress() {
		return press.getText();
	}
	// 返回数量
	public String getAmount() {
		return amount.getText();
	}
	// 返回确认按钮
	public JButton getYesButton() {
		return yesButton;
	}
	// 返回返回按钮
	public JButton getBackOf() {
		return backOf;
	}
	
	// 返回操作成功提示框
	public JLabel getSuccessNote() {
		return successNote;
	}
	
	// 清空输入框
	public void clearEnterArea() {
		bookName.setText("");
		authorName.setText("");
		press.setText("");
		amount.setText("");
	}
	
	// 构造，画界面
	public AddBookPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("添加书籍", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 书名输入提示 */
		JLabel bookNameEnterNote = new JLabel("书名");
		
		bookNameEnterNote.setBounds(170, 130, 90, 30);
		bookNameEnterNote.setOpaque(true);
		bookNameEnterNote.setForeground(Color.WHITE);
		bookNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		bookNameEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 书名输入框 */
		bookName = new JTextArea();
		
		bookName.setBounds(270, 130, 120, 30);
		bookName.setOpaque(true);
		
		
		/* 作者输入提示 */
		JLabel authorNameEnterNote = new JLabel("作者");
		
		authorNameEnterNote.setBounds(170, 170, 90, 30);
		authorNameEnterNote.setOpaque(true);
		authorNameEnterNote.setForeground(Color.WHITE);
		authorNameEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		authorNameEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 作者输入框 */
		authorName = new JTextArea();
		
		authorName.setBounds(270, 170, 120, 30);
		authorName.setOpaque(true);
		
		
		/* 出版社输入提示 */
		JLabel pressEnterNote = new JLabel("出版社");
		
		pressEnterNote.setBounds(170, 210, 90, 30);
		pressEnterNote.setOpaque(true);
		pressEnterNote.setForeground(Color.WHITE);
		pressEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		pressEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 出版社输入框 */
		press = new JTextArea();
		
		press.setBounds(270, 210, 120, 30);
		press.setOpaque(true);
		

		/* 数量输入提示 */
		JLabel amountEnterNote = new JLabel("数量");
		
		amountEnterNote.setBounds(170, 250, 90, 30);
		amountEnterNote.setOpaque(true);
		amountEnterNote.setForeground(Color.WHITE);
		amountEnterNote.setBackground(new Color(MyScreen.colorOfPage));
		amountEnterNote.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 书名输入框 */
		amount = new JTextArea();
		
		amount.setBounds(270, 250, 120, 30);
		amount.setOpaque(true);
		
		
		
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
		
		
		/* 添加成功提示 */
		successNote = new JLabel("添加成功");
		
		successNote.setBounds(400, 250, 90, 30);
		successNote.setOpaque(true);
		successNote.setForeground(Color.RED);
		successNote.setBackground(new Color(MyScreen.colorOfPage));
		successNote.setFont(new Font("宋体", Font.PLAIN, 16));
		successNote.setVisible(false);
		
		
		/* 组件添加到Panel */
		this.add(title);
		this.add(bookNameEnterNote);
		this.add(bookName);
		this.add(authorNameEnterNote);
		this.add(authorName);
		this.add(pressEnterNote);
		this.add(press);
		this.add(amountEnterNote);
		this.add(amount);
		
		this.add(yesButton);
		this.add(backOf);
		
		this.add(successNote);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
