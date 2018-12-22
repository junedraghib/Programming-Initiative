package Lec09;

public class printKPC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printKPC("145", "");

	}
	
	public static void printKPC(String qus, String ans)
	{
		if(qus.length() == 0)
		{
			System.out.println(ans);
			return;
		}
		
		
		char ch = qus.charAt(0);
		String roq = qus.substring(1);
		
		String opt = getCode(ch);
		
		
		for (int i = 0; i < opt.length(); i++) {
			char cc = opt.charAt(i);
			
			printKPC(roq, ans+cc);
		}
		
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
