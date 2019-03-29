package com.GUItest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.GUI.LoginPanel;
import com.GUI.MyScreen;


public class PanelTest extends  JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PanelTest();
	}
	
	public PanelTest() {
		
		
		this.add(new LoginPanel(), BorderLayout.CENTER);
		
		
		
		
		
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
