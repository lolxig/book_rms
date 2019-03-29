package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: 主页面
 * 	
 * 			主要组件： 四个button，功能分别是，修改密码，会员管理，书籍管理，信息查询
 * 			次要组件：一个退出按钮
 * 
 * 搭建思路：
 * 			用绝对布局方式，手动搭建
 * 
 * 按钮功能管理，全部交给最上层的frame来管理，即，返回所有按钮
 * 
 * note: 已通过测试
 * 
 * complete time: 2019-3-29 17:48:15
 * 
 * 
 */

public class HomePanel extends JPanel {
	
	private JButton changePassword = null,		// 修改密码
					memberManagement = null,	// 会员管理
					bookManagement = null,		// 书籍管理
					infoSearch = null,			// 信息查询
					exitSystem = null;			// 退出系统

	// 获取按钮
	public JButton getChangePassword() {
		return changePassword;
	}
	public JButton getMemberManagement() {
		return memberManagement;
	}
	public JButton getBookManagement() {
		return bookManagement;
	}
	public JButton getInfoSearch() {
		return infoSearch;
	}
	public JButton getExitSystem() {
		return exitSystem;
	}
	
	public HomePanel() {
		initGUI();
	}
	
	// 构造，画界面
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("图书租赁管理系统", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 画修改密码按钮 */
		changePassword = new JButton("修改密码");
		
		changePassword.setBounds(125, 150, 150, 30);
		changePassword.setFont(new Font("宋体", Font.PLAIN, 16));
		changePassword.setContentAreaFilled(false);
		changePassword.setFocusPainted(false);
		changePassword.setForeground(Color.WHITE);
		
		
		/* 画会员管理按钮 */
		memberManagement = new JButton("会员管理");
		
		memberManagement.setBounds(325, 150, 150, 30);
		memberManagement.setFont(new Font("宋体", Font.PLAIN, 16));
		memberManagement.setContentAreaFilled(false);
		memberManagement.setFocusPainted(false);
		memberManagement.setForeground(Color.WHITE);
		
		
		/* 画书籍管理按钮*/
		bookManagement = new JButton("书籍管理");
		
		bookManagement.setBounds(125, 210, 150, 30);
		bookManagement.setFont(new Font("宋体", Font.PLAIN, 16));
		bookManagement.setContentAreaFilled(false);
		bookManagement.setFocusPainted(false);
		bookManagement.setForeground(Color.WHITE);
		
		
		/* 画信息查询按钮 */
		infoSearch = new JButton("信息查询");
		
		infoSearch.setBounds(325, 210, 150, 30);
		infoSearch.setFont(new Font("宋体", Font.PLAIN, 16));
		infoSearch.setContentAreaFilled(false);
		infoSearch.setFocusPainted(false);
		infoSearch.setForeground(Color.WHITE);
		
		
		/* 画退出系统按钮 */
		exitSystem = new JButton("退出系统");
		
		exitSystem.setBounds(225, 270, 150, 30);
		exitSystem.setFont(new Font("宋体", Font.PLAIN, 16));
		exitSystem.setContentAreaFilled(false);
		exitSystem.setFocusPainted(false);
		exitSystem.setForeground(Color.WHITE);
		
		
		/* 组件添加到Panel */
		this.add(title);
		this.add(changePassword);
		this.add(memberManagement);
		this.add(bookManagement);
		this.add(infoSearch);
		this.add(exitSystem);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
