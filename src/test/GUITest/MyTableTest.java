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
 * description: �����ҵı�����Ƿ�����
 *
 */

public class MyTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionUnify.connection = ConnectionUnify.getConnection();
		
		new MyTableTest((new InfoSearchOperation()).searchMember());
	}
	
	public MyTableTest(ArrayList<InfoSearchOfMember> members) {
		
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
		
		System.out.println("=============================================");
		System.out.println("��Ա��\t��Ա��\t�ֻ���\t\t�ѽ��鼮");
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
