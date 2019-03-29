package com.GUItest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.GUI.firstLevel.BookManagementPanel;
import com.GUI.firstLevel.HomePanel;
import com.GUI.firstLevel.InfoSearchPanel;
import com.GUI.firstLevel.LoginPanel;
import com.GUI.firstLevel.MemberManagementPanel;
import com.GUI.firstLevel.MyScreen;


public class PanelTest extends  JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PanelTest();
	}
	
	public PanelTest() {
		
//		this.add(new LoginPanel(), BorderLayout.CENTER);
		
//		this.add(new HomePanel(), BorderLayout.CENTER);
		
//		this.add(new MemberManagementPanel(), BorderLayout.CENTER);
		
//		this.add(new BookManagementPanel(), BorderLayout.CENTER);
		
//		this.add(new InfoSearchPanel(), BorderLayout.CENTER);
		
		
		
		
		
		/* 设置frame属性 */
//		this.setBackground(new Color(MyScreen.colorOfPage));
		this.setTitle("图书租赁管理系统");
		this.setSize(MyScreen.WIDTH, MyScreen.HIGHT);
		this.setLocation(MyScreen.X, MyScreen.Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

}
