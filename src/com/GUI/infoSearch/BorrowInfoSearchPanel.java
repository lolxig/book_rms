package com.GUI.infoSearch;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import com.GUI.firstLevel.MyScreen;
import com.intraface.infoSearch.InfoSearchOfBorrow;

/**
 * 
 * @author xig
 * 
 * description: ��Ϣ��ѯ������ʾ���
 * 
 * 				��Ҫ����� һ�����һ�����ذ�ť
 * 
 * note: ��������so easy������ͨ��
 * complete time: 2019-4-18 17:45:29
 * 
 */

public class BorrowInfoSearchPanel extends JPanel {
	
	private JButton returnButton = null;		// ���ذ�ť
	
	// ���ط��ذ�ť
	public JButton getReturnButton() {
		return returnButton;
	}
	
	// ���죬������
	public BorrowInfoSearchPanel(ArrayList<InfoSearchOfBorrow> borrows) {
		
		// ��ArrayListת����Vector
		Vector<Vector<String>> data = new Vector<Vector<String>>();		// ������
		Vector<String> dataTitle = new Vector<String>();				// ������
		
		// ������ת��
		for (InfoSearchOfBorrow borrow : borrows) {
			
			// ���Ļ���
			Vector<String> tmp = new Vector<String>();
			
			tmp.add(borrow.getMemberId());
			tmp.add(borrow.getMemberName());
			tmp.add(borrow.getBookId());
			tmp.add(borrow.getBookName());
			
			data.add(tmp);
		}
		
		// ������
		dataTitle.add("��Ա��");
		dataTitle.add("��Ա��");
		dataTitle.add("���");
		dataTitle.add("����");
		
		
		// ������
		initGUI(data, dataTitle);
	}
	
	private void initGUI(Vector<Vector<String>> data, Vector<String> dataTitle) {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("������Ϣ", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		// �������
		@SuppressWarnings("serial")
		JTable table = new JTable(data, dataTitle) {
			// ���ò��ɱ༭
			public boolean isCellEditable(int row, int colum) {
				return false;
			}	
		};
		JScrollPane tableScroll = new JScrollPane(table);
		
		
		/***********/
		/* ���ñ�� */
		/***********/
		
		// ��ͷ�����϶�
		table.getTableHeader().setReorderingAllowed(false);
		
		// �д�С���ɸı�
		table .getTableHeader().setResizingAllowed(false);
		
		// ��ɫ����
		table.setBackground(new Color(MyScreen.colorOfPage));
		table.setForeground(Color.WHITE);

		// ����ʾ����
		table.setShowVerticalLines(false);
		
		// ���ñ��λ��
		tableScroll.setBounds(50, 120, 500, 170);
		
		// �������ݾ�����ʾ
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		
		// ���ñ�ͷ��ɫ
		table.getTableHeader().setBackground(Color.BLUE);
		table.getTableHeader().setForeground(Color.YELLOW);
		
		// ����ÿ�п��
		TableColumnModel columns = table.getColumnModel();
		
		columns.getColumn(0).setPreferredWidth(50);
		columns.getColumn(1).setPreferredWidth(150);
		columns.getColumn(2).setPreferredWidth(50);
		columns.getColumn(3).setPreferredWidth(250);

		table.setColumnModel(columns);
		
		// ���ÿհ�������ɫ
		tableScroll.getViewport().setBackground(new Color(MyScreen.colorOfPage));
		
		
		// ���÷��ذ�ť
		returnButton = new JButton("����");
		
		returnButton.setBounds(265, 310, 70, 30);
		returnButton.setFont(new Font("����", Font.PLAIN, 16));
		returnButton.setContentAreaFilled(false);
		returnButton.setFocusPainted(false);
		returnButton.setForeground(Color.WHITE);
		
		
		/* �����ӵ�Panel */
		this.add(title);		
		this.add(tableScroll);
		this.add(returnButton);	
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}

}
