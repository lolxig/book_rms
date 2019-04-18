package test.functionTest;

import java.util.ArrayList;

import com.intraface.infoSearch.InfoSearchOfBook;
import com.intraface.infoSearch.InfoSearchOfBorrow;
import com.intraface.infoSearch.InfoSearchOfHistory;
import com.intraface.infoSearch.InfoSearchOfMember;
import com.intraface.intraface.InfoSearchOperation;
import com.memberClass.Book;

public class InfoSearchOperationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InfoSearchOperation iso = new InfoSearchOperation();
		
		ArrayList<InfoSearchOfMember> members = new ArrayList<InfoSearchOfMember>();
		ArrayList<InfoSearchOfBook> books = new ArrayList<InfoSearchOfBook>();
		ArrayList<InfoSearchOfBorrow> borrows = new ArrayList<InfoSearchOfBorrow>();
		ArrayList<InfoSearchOfHistory> histories = new ArrayList<InfoSearchOfHistory>();
		
		members = iso.searchMember();
		books = iso.searchBook();
		borrows = iso.searchBorrow();
		histories =iso.searchHistory();
	
		System.out.println();
		System.out.println("会员号\t会员名\t手机号\t\t已借书籍");
		System.out.println("============================================");
		for (InfoSearchOfMember isMember : members) {
			System.out.print(isMember.getMemberId() + '\t');
			System.out.print(isMember.getMemberName() + '\t');
			System.out.print(isMember.getMemberPhone() + '\t');
			
			if (isMember.getBookSlip().size() != 0) {
				boolean flag = false;
				for (Book book : isMember.getBookSlip()) {
					if (flag) {
						System.out.println("\t\t\t\t" + book.getName());
					} else {
						System.out.println(book.getName());
						flag = true;
					}
				}
			} else {
				System.out.println();
			}
		}
		System.out.println("============================================");
	
		
		
		System.out.println();
		System.out.println("书号\t书名\t\t作者\t\t出版社\t\t库存\t");
		System.out.println("=================================================================");
		for (InfoSearchOfBook isBook : books) {
			System.out.print(isBook.getBookId() + '\t');
			System.out.print(isBook.getBookName() + '\t' + '\t');
			System.out.print(isBook.getBookAuthor() + '\t' + '\t');
			System.out.print(isBook.getBookPress() + '\t');
			System.out.print(isBook.getBookStcok() + '\t');
			System.out.println();
		}
		System.out.println("=================================================================");
		
		
		
		System.out.println();
		System.out.println("会员号\t会员名\t书号\t书名");
		System.out.println("==================================");
		for (InfoSearchOfBorrow isBorrow : borrows) {
			System.out.print(isBorrow.getMemberId() + '\t');
			System.out.print(isBorrow.getMemberName() + '\t');
			System.out.print(isBorrow.getMemberId() + '\t');
			System.out.print(isBorrow.getBookName());
			System.out.println();
		}
		System.out.println("==================================");
		
		
		
		System.out.println();
		System.out.println("时间日期\t\t\t会员号\t会员名\t书号\t书名");
		System.out.println("============================================================");
		for (InfoSearchOfHistory isHistory : histories) {
			System.out.print(isHistory.getDate() + '\t');
			System.out.print(isHistory.getMemberId() + '\t');
			System.out.print(isHistory.getMemberName() + '\t');
			System.out.print(isHistory.getBookId() + '\t');
			System.out.print(isHistory.getBookName());
			System.out.println();
		}
		System.out.println("============================================================");
		
	}

}
