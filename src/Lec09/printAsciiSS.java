package Lec09;

public class printAsciiSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSS("abc", "");

	}
	
	public static void printSS(String qus, String ans)
	{
		if(qus.length() == 0)
		{
			System.out.println(ans);
			return;
		}
		
		char ch = qus.charAt(0);
		String roq = qus.substring(1);
		
		printSS(roq, ans);
		printSS(roq, ans + ch);
//		printSS(roq, ans + (int)ch);
	}

}
