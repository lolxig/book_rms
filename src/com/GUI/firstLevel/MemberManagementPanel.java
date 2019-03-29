package com.GUI.firstLevel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author xig
 * 
 * description: 会员管理界面
 * 
 * 				主要组件：四个按钮，分别是开户，注销，借书，还书
 * 				次要组件：返回上一层
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 测试通过
 * 
 * complete time: 2019-3-29 19:15:37
 * 
 *
 */

public class MemberManagementPanel extends JPanel {
	
	private JButton openCount = null,		// 开户
					deleteCount = null,		// 注销
					borrowBook = null,		// 借书
					returnBook = null,		// 还书
					backOf = null;			// 返回上一层
	
	// 获取按钮
	public JButton getOpenCount() {
		return openCount;
	}
	public JButton getDeleteCount() {
		return deleteCount;
	}
	public JButton getBorrowBook() {
		return borrowBook;
	}
	public JButton getReturnBook() {
		return returnBook;
	}
	public JButton getBackOf() {
		return backOf;
	}

	// 构造，画界面
	public MemberManagementPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("会员管理", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 画开户按钮 */
		openCount = new JButton("开户");
		
		openCount.setBounds(205, 150, 70, 30);
		openCount.setFont(new Font("宋体", Font.PLAIN, 16));
		openCount.setContentAreaFilled(false);
		openCount.setFocusPainted(false);
		openCount.setForeground(Color.WHITE);
		
		
		/* 画注销按钮 */
		deleteCount = new JButton("注销");
		
		deleteCount.setBounds(325, 150, 70, 30);
		deleteCount.setFont(new Font("宋体", Font.PLAIN, 16));
		deleteCount.setContentAreaFilled(false);
		deleteCount.setFocusPainted(false);
		deleteCount.setForeground(Color.WHITE);
		
		
		/* 画借书按钮*/
		borrowBook = new JButton("借书");
		
		borrowBook.setBounds(205, 210, 70, 30);
		borrowBook.setFont(new Font("宋体", Font.PLAIN, 16));
		borrowBook.setContentAreaFilled(false);
		borrowBook.setFocusPainted(false);
		borrowBook.setForeground(Color.WHITE);
		
		
		/* 画还书按钮 */
		returnBook = new JButton("还书");
		
		returnBook.setBounds(325, 210, 70, 30);
		returnBook.setFont(new Font("宋体", Font.PLAIN, 16));
		returnBook.setContentAreaFilled(false);
		returnBook.setFocusPainted(false);
		returnBook.setForeground(Color.WHITE);
		
		
		/* 画返回上一层按钮 */
		backOf = new JButton("返回上一层");
		
		backOf.setBounds(225, 270, 150, 30);
		backOf.setFont(new Font("宋体", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		

		/* 组件添加到Panel */
		this.add(title);
		this.add(openCount);
		this.add(deleteCount);
		this.add(borrowBook);
		this.add(returnBook);
		this.add(backOf);
			
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
