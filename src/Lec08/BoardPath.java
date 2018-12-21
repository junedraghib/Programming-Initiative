package Lec08;

import java.util.ArrayList;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getBoardPath(0, 4));

	}
	
	public static ArrayList<String> getBoardPath(int current, int end)
	{
		if(current == end)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		if(current > end)
		{
			ArrayList<String> br = new ArrayList<>();
//			br.add("");
			return br;
		}
		
		
		ArrayList<String> ans = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(current + dice, end);
			for (String val : rr) {
				ans.add(dice+val);
			}
		}
		
		
		return ans;
	}

}
