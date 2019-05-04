package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: 2019-4-19 14:50:21添加，作为退出系统的缓冲界面
 * 
 *
 */

public class ExitSystemPanel extends JPanel {
	
	private JButton yesButton = null,		// 确认
					cancelButton = null;	// 取消
	
	// 返回确认按钮
	public JButton getYesButton() {
		return yesButton;
	}
	
	// 返回取消按钮
	public JButton getCancelButton() {
		return cancelButton;
	}
	
	// 构造，画界面
	public ExitSystemPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 标题 */
		JLabel noteLable = new JLabel("确认退出系统？", JLabel.CENTER);
		
		noteLable.setBounds(100, 70, 400, 70);
		noteLable.setOpaque(true);
		noteLable.setForeground(Color.YELLOW);
		noteLable.setBackground(new Color(MyScreen.colorOfPage));
		noteLable.setFont(new Font("宋体", Font.BOLD, 40));
		
		
		/* 设置按钮 */
		yesButton = new JButton("确认");
		
		yesButton.setBounds(200, 200, 70, 30);
		yesButton.setFont(new Font("宋体", Font.PLAIN, 16));
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setForeground(Color.WHITE);

		cancelButton = new JButton("取消");
		cancelButton.setBounds(330, 200, 70, 30);
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 16));
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setForeground(Color.WHITE);
		

		/* 添加组件 */
		this.add(noteLable);
		this.add(yesButton);
		this.add(cancelButton);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
