package test.GUITest;

/**
 * 
 * @author xig
 * 
 * description: ����JTable
 *
 */

import java.awt.*;
import javax.swing.*;

public class JTableTest extends JFrame {

	private String[][] data = {{"���һ","����һ"}, {"��Ŷ�","���ݶ�"},
								{"�����","������"}, {"�����","������"},
								{"�����","������"}, {"�����","������"},
								{"�����","������"}, {"��Ű�","���ݰ�"},
								{"��ž�","������"}, {"���ʮ","���ݰ�"},
								{"���ʮһ","������"}, {"���ʮ��","���ݰ�"},
								{"���ʮ��","������"}, {"���ʮ��","���ݰ�"},
								{"���ʮ��","������"}, {"���ʮ��","���ݰ�"},
								{"���ʮ��","������"}, {"���ʮ��","���ݰ�"},
								{"���ʮ��","������"}, {"��Ŷ�ʮ","���ݰ�"},
							};
	private String[] dataTitle = {"���","����"};
	private JTable jtable = new JTable(data, dataTitle);
	private JScrollPane jscrollpane = new JScrollPane(jtable);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTableTest();
	}
	
	public JTableTest()	{
		
		jtable.setEnabled(false);
		jscrollpane.setBounds(0, 0, 200, 100);
		
		this.add(jscrollpane);
		
		
		
		
		
		this.setTitle("������");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
