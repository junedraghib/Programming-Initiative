package Lec06;

public class toggleCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("ADghi");
		System.out.println(toggleCase(sb));
	}
	
	public static String toggleCase(StringBuilder sb)
	{
		for(int i = 0; i <= sb.length() - 1; i++)
		{
			int diff = 'a' - 'A';
			if (sb.charAt(i) <= 'Z' && sb.charAt(i) >= 'A')
			{
				sb.setCharAt(i, (char)(sb.charAt(i)+diff));
			}
			else
			{
				sb.setCharAt(i, (char)(sb.charAt(i)-diff));
			}
		}
		
		return sb.toString();
		
	}

}
