package Lec06;

public class higher_lowerASCII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("gbdx");
		System.out.println(higher_lowerASCII(sb));

	}
	
	public static String higher_lowerASCII(StringBuilder sb)
	{
		for (int i = 0; i < sb.length(); i++)
		{
			if (i % 2 != 0)
			{
				char ch = sb.charAt(i);
				sb.setCharAt(i, ++ch);
			}
			
			if (i % 2 == 0)
			{
				char ch = sb.charAt(i);
				sb.setCharAt(i, --ch);
			}
		}
		return sb.toString();
	}

}
