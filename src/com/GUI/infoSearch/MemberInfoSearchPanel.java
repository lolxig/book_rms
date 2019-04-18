package com.GUI.infoSearch;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import com.GUI.firstLevel.MyScreen;
import com.intraface.infoSearch.InfoSearchOfMember;
import com.memberClass.Book;

/**
 * 
 * @author xig
 * 
 * description: ��Ϣ��ѯ��Ա��ʾ���
 * 
 * 				��Ҫ����� һ�����һ�����ذ�ť
 * 
 * note: ����ͨ���������������
 * complete time: 2019-4-18 17:04:55
 * 
 */

public class MemberInfoSearchPanel extends JPanel {
	
	private JButton returnButton = null;		// ���ذ�ť
	
	// ���ط��ذ�ť
	public JButton getReturnButton() {
		return returnButton;
	}
	
	// ���죬������
	public MemberInfoSearchPanel(ArrayList<InfoSearchOfMember> members) {
		
		// ��ArrayListת����Vector
		Vector<Vector<String>> data = new Vector<Vector<String>>();		// ������
		Vector<String> dataTitle = new Vector<String>();				// ������
		
		// ������ת��
		for (InfoSearchOfMember member : members) {
			
			// ��Ա����
			Vector<String> tmp = new Vector<String>();

			// ��Ա�赽���鼮����
			ArrayList<Book> bookSlip = member.getBookSlip();
			String strTmp = null;
			
			for (Book book : bookSlip) {
				strTmp += book.getName() + ',';
			}
			
			// ȥ��β���ź�ͷ����ָ��
			if (strTmp != null) {
				strTmp = strTmp.substring(4, strTmp.length()-1);
			}
				
			// ���ݲ��뵽��Ա����
			tmp.add(member.getMemberId());
			tmp.add(member.getMemberName());
			tmp.add(member.getMemberPhone());
			tmp.add(strTmp);
			
			data.add(tmp);
		}
		
		// ������
		dataTitle.add("��Ա��");
		dataTitle.add("��Ա��");
		dataTitle.add("�ֻ���");
		dataTitle.add("�ѽ��鼮");
		
		// ������
		initGUI(data, dataTitle);
	}
	
	private void initGUI(Vector<Vector<String>> data, Vector<String> dataTitle) {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("��Ա��Ϣ", JLabel.CENTER);
		
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
		columns.getColumn(1).setPreferredWidth(50);
		columns.getColumn(2).setPreferredWidth(100);
		columns.getColumn(3).setPreferredWidth(300);

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
