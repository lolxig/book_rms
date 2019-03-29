package com.GUI.firstLevel;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author xig
 * 
 * description: ��Ϣ��ѯ����
 * 
 * 				��Ҫ����� �ĸ�button�����ֱܷ��ǣ���Ա��ѯ���鼮��ѯ�����Ĳ�ѯ����ʷ��ѯ
 * 				��Ҫ����� һ�����ذ�ť
 * 
 * �˼·��
 * 			�þ��Բ��ַ�ʽ���ֶ��
 * 
 * ��ť���ܹ���ȫ���������ϲ��frame�����������������а�ť
 * 
 * note: ����ͨ��
 * 
 * complete time: 2019-3-29 21:11:53
 *
 */

public class InfoSearchPanel extends JPanel {
	
	private JButton memberSearch = null,	// ��Ա��ѯ
					bookSearch = null,		// �鼮��ѯ
					borrowSearch = null,	// ���Ĳ�ѯ
					historySearch = null,	// ��ʷ��ѯ
					backOf = null;			// ������һ��

	// ��ȡ��ť
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
	
	// ���죬������
	public InfoSearchPanel() {
		initGUI();
	}
	
	private void initGUI() {
		
		/* ���Բ��֣�JPanel���ò��ֹ����� */
		this.setLayout(null);
		
		
		/* ������ */
		JLabel title = new JLabel("��Ϣ��ѯ", JLabel.CENTER);
		
		title.setBounds(100, 30, 400, 70);
		title.setOpaque(true);
		title.setForeground(Color.YELLOW);
		title.setBackground(new Color(255));
		title.setFont(new Font("����", Font.BOLD, 40));
		
		
		/* ����Ա��ѯ��ť */
		memberSearch = new JButton("��Ա��ѯ");
		
		memberSearch.setBounds(125, 150, 150, 30);
		memberSearch.setFont(new Font("����", Font.PLAIN, 16));
		memberSearch.setContentAreaFilled(false);
		memberSearch.setFocusPainted(false);
		memberSearch.setForeground(Color.WHITE);
		
		
		/* ���鼮��ѯ��ť */
		bookSearch = new JButton("�鼮��ѯ");
		
		bookSearch.setBounds(325, 150, 150, 30);
		bookSearch.setFont(new Font("����", Font.PLAIN, 16));
		bookSearch.setContentAreaFilled(false);
		bookSearch.setFocusPainted(false);
		bookSearch.setForeground(Color.WHITE);
		
		
		/* �����Ĳ�ѯ��ť*/
		borrowSearch = new JButton("���Ĳ�ѯ");
		
		borrowSearch.setBounds(125, 210, 150, 30);
		borrowSearch.setFont(new Font("����", Font.PLAIN, 16));
		borrowSearch.setContentAreaFilled(false);
		borrowSearch.setFocusPainted(false);
		borrowSearch.setForeground(Color.WHITE);
		
		
		/* ��������ʷ��ť */
		historySearch = new JButton("������ʷ");
		
		historySearch.setBounds(325, 210, 150, 30);
		historySearch.setFont(new Font("����", Font.PLAIN, 16));
		historySearch.setContentAreaFilled(false);
		historySearch.setFocusPainted(false);
		historySearch.setForeground(Color.WHITE);
		
		
		/* ��������һ�㰴ť */
		backOf = new JButton("������һ��");
		
		backOf.setBounds(225, 270, 150, 30);
		backOf.setFont(new Font("����", Font.PLAIN, 16));
		backOf.setContentAreaFilled(false);
		backOf.setFocusPainted(false);
		backOf.setForeground(Color.WHITE);
		
		
		/* �����ӵ�Panel */
		this.add(title);
		this.add(memberSearch);
		this.add(bookSearch);
		this.add(borrowSearch);
		this.add(historySearch);
		this.add(backOf);
		
		this.setBackground(new Color(MyScreen.colorOfPage));
	}
	
}
