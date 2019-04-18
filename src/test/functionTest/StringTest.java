package test.functionTest;

/**
 * 
 * 
 * @author xig
 * 
 * note: ×ª»»²âÊÔ
 *
 */

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char tmp[] = new char[100];
		
		String s = "fnkdsfjhdskljhfekwnrklewfhj";
		
		System.out.println(s);
		
		tmp = s.toCharArray();
		
		System.out.println(tmp);
		
		String s_tmp = String.valueOf(tmp);
		
		System.out.println(s_tmp);
		
		
	}

}
