package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: 信息查询界面
 * 
 * 				主要组件： 四个button，功能分别是，会员查询、书籍查询、借阅查询、历史查询
 * 				次要组件： 一个返回按钮
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 测试通过
 * 
 * complete time: 2019-3-29 21:11:53
 *
 */

public class InfoSearchPanel extends JPanel {
	
	private JButton memberSearch = null,	// 会员查询
					bookSearch = null,		// 书籍查询
					borrowSearch = null,	// 借阅查询
					historySearch = null,	// 历史查询
					backOf = null;			// 返回上一层

	// 获取按钮
	public JButton getMemberSearch() {
		return memberSearch;
	}
	public JButton getBookSearch() {
		return bookSearch;
	}
	public JButton getBorrowSearch() {
		return borrowSearch;
	}
	public JButton getHistorySearch() {
		return historySearch;
	}
	public JButton getBackOf() {
		return backOf;
	}
	
	// 构造，画界面
	public InfoSearchPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("信息查询", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 画会员查询按钮 */
		memberSearch = new JButton("会员查询");
		
		memberSearch.setBounds(125, 150, 150, 30);
		memberSearch.setFont(new Font("宋体", Font.PLAIN, 16));
		memberSearch.setContentAreaFilled(false);
		memberSearch.setFocusPainted(false);
		memberSearch.setForeground(Color.WHITE);
		
		
		/* 画书籍查询按钮 */
		bookSearch = new JButton("书籍查询");
		
		bookSearch.setBounds(325, 150, 150, 30);
		bookSearch.setFont(new Font("宋体", Font.PLAIN, 16));
		bookSearch.setContentAreaFilled(false);
		bookSearch.setFocusPainted(false);
		bookSearch.setForeground(Color.WHITE);
		
		
		/* 画借阅查询按钮*/
		borrowSearch = new JButton("借阅查询");
		
		borrowSearch.setBounds(125, 210, 150, 30);
		borrowSearch.setFont(new Font("宋体", Font.PLAIN, 16));
		borrowSearch.setContentAreaFilled(false);
		borrowSearch.setFocusPainted(false);
		borrowSearch.setForeground(Color.WHITE);
		
		
		/* 画借阅历史按钮 */
		historySearch = new JButton("借阅历史");
		
		historySearch.setBounds(325, 210, 150, 30);
		historySearch.setFont(new Font("宋体", Font.PLAIN, 16));
		historySearch.setContentAreaFilled(false);
		historySearch.setFocusPainted(false);
		historySearch.setForeground(Color.WHITE);
		
		
		/* 画返回上一层按钮 */
		backOf = new JButton("返回上一层");
		
		backOf.setBounds(225, 270, 150, 30);
		backOf.setFont(new Font("宋体", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* 组件添加到Panel */
		this.add(title);
		this.add(memberSearch);
		this.add(bookSearch);
		this.add(borrowSearch);
		this.add(historySearch);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
