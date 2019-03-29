package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 *
 * description: 书籍管理界面
 * 
 * 				主要组件： 两个按钮，功能分别是增加书籍和删除书籍
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 已通过测试
 * 
 * complete time: 2019-3-29 19:57:02
 * 
 */

public class BookManagementPanel extends JPanel {
	
	private JButton addBook = null,			// 添加书籍
					deleteBook = null,		// 删除书籍
					backOf = null;			// 返回上一层

	// 获取按钮
	public JButton getAddBook() {
		return addBook;
	}
	public JButton getDeleteBook() {
		return deleteBook;
	}
	public JButton getBackOf() {
		return backOf;
	}
	
	// 构造，画界面
	public BookManagementPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("书籍管理", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 画添加书籍按钮 */
		addBook = new JButton("添加书籍");
		
		addBook.setBounds(125, 170, 150, 30);
		addBook.setFont(new Font("宋体", Font.PLAIN, 16));
		addBook.setContentAreaFilled(false);
		addBook.setFocusPainted(false);
		addBook.setForeground(Color.WHITE);
		
		
		/* 画删除书籍按钮 */
		deleteBook = new JButton("删除书籍");
		
		deleteBook.setBounds(325, 170, 150, 30);
		deleteBook.setFont(new Font("宋体", Font.PLAIN, 16));
		deleteBook.setContentAreaFilled(false);
		deleteBook.setFocusPainted(false);
		deleteBook.setForeground(Color.WHITE);
		
		
		/* 画返回上一层按钮 */
		backOf = new JButton("返回上一层");
		
		backOf.setBounds(225, 250, 150, 30);
		backOf.setFont(new Font("宋体", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* 组件添加到Panel */
		this.add(title);
		this.add(addBook);
		this.add(deleteBook);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
