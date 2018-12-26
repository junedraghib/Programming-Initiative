package Lec10;

/**
 * created by : Juned Raghib
 * created on : 25-Dec-2018
 */
public class generateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParanthesis(0, 0, 3, "");

	}
	
	
	public static void generateParanthesis(int open, int close, int n, String ans)
	{
		if(open == n && close == n)
		{
			System.out.println(ans);
			return;
		}
		
		if (close > open || open > n || close > n) {
			return;
		}
		
		
		generateParanthesis(open + 1, close, n, ans+"(");
		generateParanthesis(open, close + 1, n, ans+")");
	}

}
