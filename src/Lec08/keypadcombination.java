package Lec08;

import java.util.ArrayList;
import java.util.Scanner;

public class keypadcombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
//		String keypad = s.next();
		
		System.out.println(getKPC("145"));
		
	}
	
	
	public static ArrayList<String> getKPC(String s)
	{
		if(s.length() == 0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		char ch = s.charAt(0);
		String ros = s.substring(1);
		
		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> result = new ArrayList<>();
		
		String code = getCode(ch);
		
		for(int i = 0; i < code.length(); i++)
		{
			for(String val : rr)
			{
				result.add(code.charAt(i) + val);
			}
		}
		
		return result;
	}
	
	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

}
