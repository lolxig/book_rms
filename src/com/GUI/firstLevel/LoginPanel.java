package com.GUI.firstLevel;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: 登陆界面
 * 
 * 			主要组件：一个JPasswordField，一个JLabel，两个JButton
 * 
 * 搭建思路：
 * 			North为标题，West East Sourth为填充，中间再放一个Panel作为功能面板
 * 
 * *****************************************************************************
 * 
 * time: 2019-3-29 13:48:25
 * 
 * 搭建思路改写：
 * 			使用绝对布局方式，组件少，屏幕大，相对布局需要的填充过多，设计复杂
 * 
 * 			注意：该Panel需要对外暴露一个获取密码接口，方便调用者获取信息
 * 					
 * 				暴露两个button，让驱动来操作按钮
 * 
 * note: 通过测试
 * 
 * complete time: 2019-3-29 16:28:10
 * 
 *
 */

public class LoginPanel extends JPanel {
	
	
/*
 * note: 以下注释代码设计失败，重写
 * 
 * time: 2019-3-29 13:42:35
 * 
 * */

// 
//	/* 定义组件 */
//	private JLabel title = null,		// 标题Label
//				   note = null;			// 提示框
//	private JPasswordField password = null;	// 输入密码框
//	private JButton login = null,		// 登陆按钮
//					exit = null;		// 退出按钮
//	private JPanel exePanel = null;		// 功能面板
//	
//	
//	private JLabel paddingLeft = null,	// 填充料
//				   paddingRight = null,
//				   paddingDown = null,
//				   paddingExe = null;
//	
//	public LoginPanel() {
//		
//		/* 创建组件 */
//		title = new JLabel("图书管理系统", JLabel.CENTER);
//		note = new JLabel("输入密码");
//		password = new JPasswordField(6);
//		login = new JButton("登陆");
//		exit = new JButton("退出");
//		exePanel = new JPanel();
//		
//		
//		paddingLeft = new JLabel("                                                  ");
//		paddingRight = new JLabel("                                                  ");
//		paddingDown = new JLabel(" ");
//		paddingExe = new JLabel(" ");
//		
//		
//		/* 设置组件 */
//		
//		/* 设置 Panel布局, 使用BorderLayout*/
//		this.setLayout(new BorderLayout());
//		this.setBackground(new Color(MyScreen.colorOfPage));
//		
//		
//		/* 设置填充料 */
//		paddingDown.setFont(new Font(" ", Font.PLAIN, 100));
//		paddingExe.setFont(new Font(" ", Font.PLAIN, 60));
//		paddingExe.setOpaque(true);
//		paddingExe.setBackground(new Color(MyScreen.colorOfPage));
//		paddingExe.setForeground(new Color(MyScreen.colorOfPage));
//		
//		/* 设置exePanel属性 */
//		exePanel.setLayout(new BorderLayout());
//		exePanel.add(paddingExe, BorderLayout.NORTH);
//
//		
//		/* 设置title属性 */
//		title.setOpaque(true);
//		title.setFont(new Font("宋体", Font.BOLD, 40));
//		
//		
//		/* 设置note属性 */
//		note.setOpaque(true);
//		
//		
//		
//		/* 添加组件 */
//		this.add(title, BorderLayout.NORTH);				// 标题
//		
//		this.add(paddingLeft, BorderLayout.WEST);			// 填充料
//		this.add(paddingRight, BorderLayout.EAST);
//		this.add(paddingDown, BorderLayout.SOUTH);
//		
//		this.add(password);
//			
//		this.add(exePanel, BorderLayout.CENTER);			// 功能面板
//	}
	
/*
 * note: 以上为失败代码	
 * 
 * */
	
	
/*
 * note: 以下为重新设计
 * 
 * 2019-3-29 13:43:36
 * 
 * */
	
	// 对外暴露一个JPasswordField对象，让外界调取密码数据
	// 暴露两个button
	private JPasswordField pwd = null;
	private JButton login = null,
					exit = null;
	private JLabel wrongPassword = null;
	
	// password获取接口
	public String getEnterPassword() {
		return String.valueOf(pwd.getPassword());
	}
	
	// wrongPassword获取接口
	public JLabel getWrongPassword() {
		return wrongPassword;
	}
	
	// 清空密码输入框
	public void clearPasswordArea() {
		pwd.setText("");
		pwd.requestFocus();				// 清空后获取焦点
	}
	
	// 返回login按钮
	public JButton getLogin() {
		return login;
	}
	
	// 返回exit按钮
	public JButton getExit() {
		return exit;
	}

	// 构造，画界面
	public LoginPanel() {
		initGUI();
	}
	
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
		
		
		/* 密码输入提示 */
		JLabel note = new JLabel("请输入密码");
		
		note.setBounds(170, 170, 90, 30);
		note.setOpaque(true);
		note.setForeground(Color.WHITE);
		note.setBackground(new Color(MyScreen.colorOfPage));
		note.setFont(new Font("宋体", Font.PLAIN, 16));
		
		
		/* 画密码框 */
		pwd = new JPasswordField();
		
		pwd.setBounds(270, 170, 120, 30);
		pwd.setOpaque(true);
		
		
		/* 画登陆按钮 */
		login = new JButton("登陆");
		
		login.setBounds(200, 250, 70, 30);
		login.setFont(new Font("宋体", Font.PLAIN, 16));
		login.setContentAreaFilled(false);
		login.setFocusPainted(false);
//		login.setBorderPainted(false);
		login.setForeground(Color.WHITE);

		
		/* 画退出按钮 */
		exit = new JButton("退出");
		exit.setBounds(330, 250, 70, 30);
		exit.setFont(new Font("宋体", Font.PLAIN, 16));
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
//		exit.setBorderPainted(false);
		exit.setForeground(Color.WHITE);
		
		
		/* 密码错误提示 */
		wrongPassword = new JLabel("密码错误");
		
		wrongPassword.setBounds(270, 205, 200, 30);
		wrongPassword.setOpaque(true);
		wrongPassword.setForeground(Color.RED);
		wrongPassword.setBackground(new Color(MyScreen.colorOfPage));
		wrongPassword.setFont(new Font("宋体", Font.BOLD, 16));
		wrongPassword.setVisible(false);		
		
		
		/* 组件添加到Panel */
		this.add(title);
		this.add(note);
		this.add(pwd);
		this.add(login);
		this.add(exit);
		this.add(wrongPassword);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
