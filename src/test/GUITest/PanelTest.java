package test.GUITest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.GUI.firstLevel.BookManagementPanel;
import com.GUI.firstLevel.HomePanel;
import com.GUI.firstLevel.InfoSearchPanel;
import com.GUI.firstLevel.LoginPanel;
import com.GUI.firstLevel.MemberManagementPanel;
import com.GUI.firstLevel.MyScreen;
import com.GUI.infoSearch.BookInfoSearchPanel;
import com.GUI.infoSearch.BorrowInfoSearchPanel;
import com.GUI.infoSearch.HistoryInfoSearchPanel;
import com.GUI.infoSearch.MemberInfoSearchPanel;
import com.GUI.secondLevel.AddBook;
import com.GUI.secondLevel.BorrowBookPanel;
import com.GUI.secondLevel.ChangePasswordPanel;
import com.GUI.secondLevel.DeleteBook;
import com.GUI.secondLevel.DeleteCountPanel;
import com.GUI.secondLevel.OpenCountPanel;
import com.GUI.secondLevel.ReturnBookPanel;
import com.databaseOperation.ConnectionUnify;
import com.intraface.intraface.InfoSearchOperation;


public class PanelTest extends  JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PanelTest();
	}
	
	public PanelTest() {
		
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
//		this.add(new LoginPanel(), BorderLayout.CENTER);
		
//		this.add(new HomePanel(), BorderLayout.CENTER);
		
//		this.add(new MemberManagementPanel(), BorderLayout.CENTER);
		
//		this.add(new BookManagementPanel(), BorderLayout.CENTER);
		
//		this.add(new InfoSearchPanel(), BorderLayout.CENTER);
		
//		this.add(new ChangePasswordPanel(), BorderLayout.CENTER);
		
//		this.add(new OpenCountPanel(), BorderLayout.CENTER);
		
//		this.add(new DeleteCountPanel(), BorderLayout.CENTER);
		
//		this.add(new BorrowBookPanel(), BorderLayout.CENTER);
		
//		this.add(new ReturnBookPanel(), BorderLayout.CENTER);
		
//		this.add(new AddBook(), BorderLayout.CENTER);
		
//		this.add(new DeleteBook(), BorderLayout.CENTER);
		
//		this.add(new MemberInfoSearchPanel(new InfoSearchOperation().searchMember()));
		
//		this.add(new BookInfoSearchPanel(new InfoSearchOperation().searchBook()));
		
//		this.add(new BorrowInfoSearchPanel(new InfoSearchOperation().searchBorrow()));
		
		this.add(new HistoryInfoSearchPanel(new InfoSearchOperation().searchHistory()));
		
		
		
		
		
		
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
