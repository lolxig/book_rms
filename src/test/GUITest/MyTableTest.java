package test.GUITest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.databaseOperation.ConnectionUnify;
import com.intraface.infoSearch.InfoSearchOfMember;
import com.intraface.intraface.InfoSearchOperation;
import com.memberClass.Book;

/**
 * 
 * @author xig
 * 
 * description: 测试我的表格工作是否正常
 *
 */

public class MyTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
		new MyTableTest((new InfoSearchOperation()).searchMember());
	}
	
	public MyTableTest(ArrayList<InfoSearchOfMember> members) {
		
		// 将ArrayList转换成Vector
		Vector<Vector<String>> data = new Vector<Vector<String>>();		// 数据行
		Vector<String> dataTitle = new Vector<String>();				// 标题行
		
		// 数据行转换
		for (InfoSearchOfMember member : members) {
			
			// 会员缓冲
			Vector<String> tmp = new Vector<String>();

			// 会员借到的书籍缓冲
			ArrayList<Book> bookSlip = member.getBookSlip();
			String strTmp = null;
			
			for (Book book : bookSlip) {
				strTmp += book.getName() + ',';
			}
			
			// 去掉尾逗号和头部空指针
			if (strTmp != null) {
				strTmp = strTmp.substring(4, strTmp.length()-1);
			}
				
			// 数据插入到会员缓冲
			tmp.add(member.getMemberId());
			tmp.add(member.getMemberName());
			tmp.add(member.getMemberPhone());
			tmp.add(strTmp);
			
			data.add(tmp);
		}
		
		System.out.println("=============================================");
		System.out.println("会员号\t会员名\t手机号\t\t已借书籍");
		System.out.println("=============================================");
		
		for (Vector<String> tmp : data) {
			for (String strTmp : tmp) {
				System.out.print(strTmp + "\t");
			}
			System.out.println();
		}

		System.out.println("=============================================");
		
		
		try {
			ConnectionUnify.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
