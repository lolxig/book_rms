package com.GUI.infoSearch;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import com.GUI.firstLevel.MyScreen;
import com.intraface.infoSearch.InfoSearchOfHistory;

/**
 * 
 * @author xig
 * 
 * description: 信息查询历史显示面板
 * 
 * 				主要组件： 一个表格，一个返回按钮
 * 
 * note: 界面全搞定，测试通过
 * complete time: 2019-4-18 17:58:54
 * 
 */

public class HistoryInfoSearchPanel extends	JPanel {
	
	private JButton returnButton = null;		// 返回按钮
	
	// 返回返回按钮
	public JButton getReturnButton() {
		return returnButton;
	}
	
	// 构造，画界面
	public HistoryInfoSearchPanel(ArrayList<InfoSearchOfHistory> histories)	{
		
		// 将ArrayList转换成Vector
		Vector<Vector<String>> data = new Vector<Vector<String>>();		// 数据行
		Vector<String> dataTitle = new Vector<String>();				// 标题行		
		
		for (InfoSearchOfHistory history : histories) {
			
			// 历史缓冲
			Vector<String> tmp = new Vector<String>();
			
			tmp.add(history.getDate());
			tmp.add(history.getMemberId());
			tmp.add(history.getMemberName());
			tmp.add(history.getBookId());
			tmp.add(history.getBookName());
			
			data.add(tmp);		
		}
		
		// 标题行
		dataTitle.add("日期时间");
		dataTitle.add("会员号");
		dataTitle.add("会员名");
		dataTitle.add("书号");
		dataTitle.add("书名");
		
		
		// 画界面
		initGUI(data, dataTitle);
	}
	
	private void initGUI(Vector<Vector<String>> data, Vector<String> dataTitle) {
		
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("历史信息", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("宋体", Font.BOLD, 40));
		
		// 滚动表格
		@SuppressWarnings("serial")
		JTable table = new JTable(data, dataTitle) {
			// 设置不可编辑
			public boolean isCellEditable(int row, int colum) {
				return false;
			}	
		};
		JScrollPane tableScroll = new JScrollPane(table);
		
		
		/***********/
		/* 配置表格 */
		/***********/
		
		// 表头不可拖动
		table.getTableHeader().setReorderingAllowed(false);
		
		// 列大小不可改变
		table .getTableHeader().setResizingAllowed(false);
		
		// 颜色配置
		table.setBackground(new Color(MyScreen.colorOfPage));
		table.setForeground(Color.WHITE);

		// 不显示竖线
		table.setShowVerticalLines(false);
		
		// 设置表格位置
		tableScroll.setBounds(50, 120, 500, 170);
		
		// 设置数据居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		
		// 设置表头颜色
		table.getTableHeader().setBackground(Color.BLUE);
		table.getTableHeader().setForeground(Color.YELLOW);
		
		// 设置每列宽度
		TableColumnModel columns = table.getColumnModel();
		
		columns.getColumn(0).setPreferredWidth(180);
		columns.getColumn(1).setPreferredWidth(50);
		columns.getColumn(2).setPreferredWidth(70);
		columns.getColumn(3).setPreferredWidth(50);
		columns.getColumn(4).setPreferredWidth(150);

		table.setColumnModel(columns);
		
		// 设置空白区域颜色
		tableScroll.getViewport().setBackground(new Color(MyScreen.colorOfPage));
		
		
		// 配置返回按钮
		returnButton = new JButton("返回");
		
		returnButton.setBounds(265, 310, 70, 30);
		returnButton.setFont(new Font("宋体", Font.PLAIN, 16));
		returnButton.setContentAreaFilled(false);
		returnButton.setFocusPainted(false);
		returnButton.setForeground(Color.WHITE);
		
		
		/* 组件添加到Panel */
		this.add(title);		
		this.add(tableScroll);
		this.add(returnButton);	
		
		this.setBackground(new Color(MyScreen.colorOfPage));			
	}
	
}
