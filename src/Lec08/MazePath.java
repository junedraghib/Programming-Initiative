package Lec08;

import java.util.ArrayList;

public class MazePath {

	private static final int ArrayList = 0;

	public static void main(String[] args) {
		
		System.out.println(getMazePath(0, 0, 2, 2));

	}
	
	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec)
	{
		if(cr == er && cc == ec)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		if( cr > er || cc > ec)
		{
			ArrayList<String> br = new ArrayList<>();
//			br.add("");
			return br;
		}
		
		
		ArrayList<String> ans = new ArrayList<>();
		
		ArrayList<String> hor = getMazePath(cr, cc + 1, er, ec);
		ArrayList<String> ver = getMazePath(cr + 1, cc , er, ec);
		
		for (String val : hor) {
			ans.add("H"+val);
		}
		
		for (String val : ver) {
			ans.add("V"+val);
		}
		
		return ans;
	}

}
