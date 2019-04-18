package com.GUI.infoSearch;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import com.GUI.firstLevel.MyScreen;
import com.intraface.infoSearch.InfoSearchOfBook;

/**
 * 
 * @author xig
 * 
 * description: 信息查询书籍显示面板
 * 
 * 				主要组件： 一个表格，一个返回按钮
 * 
 * note: 果然是万事开头难啊，测试通过
 * complete time: 2019-4-18 17:28:12
 * 
 */

public class BookInfoSearchPanel extends JPanel {
	
	private JButton returnButton = null;		// 返回按钮
	
	// 返回返回按钮
	public JButton getReturnButton() {
		return returnButton;
	}
	
	// 构造，画界面
	public BookInfoSearchPanel(ArrayList<InfoSearchOfBook> books) {
		
		// 将ArrayList转换成Vector
		Vector<Vector<String>> data = new Vector<Vector<String>>();		// 数据行
		Vector<String> dataTitle = new Vector<String>();				// 标题行
		
		// 数据行转换
		for (InfoSearchOfBook book : books) {
			
			// 书籍缓冲
			Vector<String> tmp = new Vector<String>();
			
			tmp.add(book.getBookId());
			tmp.add(book.getBookName());
			tmp.add(book.getBookAuthor());
			tmp.add(book.getBookPress());
			tmp.add(book.getBookStcok());
			
			data.add(tmp);
		}
		
		// 标题行
		dataTitle.add("书号");
		dataTitle.add("书名");
		dataTitle.add("作者");
		dataTitle.add("出版社");
		dataTitle.add("库存量");
		
		// 画界面
		initGUI(data, dataTitle);
	}
	
	private void initGUI(Vector<Vector<String>> data, Vector<String> dataTitle) {
		
		/* 绝对布局，JPanel不用布局管理器 */
		this.setLayout(null);
		
		
		/* 画标题 */
		JLabel title = new JLabel("书籍信息", JLabel.CENTER);
		
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
		
		columns.getColumn(0).setPreferredWidth(30);
		columns.getColumn(1).setPreferredWidth(150);
		columns.getColumn(2).setPreferredWidth(100);
		columns.getColumn(3).setPreferredWidth(170);
		columns.getColumn(4).setPreferredWidth(50);

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
