package test.GUITest;

/**
 * 
 * @author xig
 * 
 * description: 测试JTable
 *
 */

import java.awt.*;
import javax.swing.*;

public class JTableTest extends JFrame {

	private String[][] data = {{"编号一","数据一"}, {"编号二","数据二"},
								{"编号三","数据三"}, {"编号四","数据四"},
								{"编号五","数据五"}, {"编号六","数据六"},
								{"编号七","数据七"}, {"编号八","数据八"},
								{"编号九","数据七"}, {"编号十","数据八"},
								{"编号十一","数据七"}, {"编号十二","数据八"},
								{"编号十三","数据七"}, {"编号十四","数据八"},
								{"编号十五","数据七"}, {"编号十六","数据八"},
								{"编号十七","数据七"}, {"编号十八","数据八"},
								{"编号十九","数据七"}, {"编号二十","数据八"},
							};
	private String[] dataTitle = {"编号","内容"};
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
		
		
		
		
		
		this.setTitle("表格测试");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
