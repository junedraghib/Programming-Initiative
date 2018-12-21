package Lec08;

import java.util.ArrayList;

public class stringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getPermutaion("abc"));

	}
	
	
	public static ArrayList<String> getPermutaion(String s)
	{
		if(s.length() == 0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		
		char ch = s.charAt(0);
		
		ArrayList<String> rr = getPermutaion(s.substring(1));
		
		ArrayList<String> ans = new ArrayList<>();
		
		for(String val : rr)
		{
			for (int i = 0; i <= val.length(); i++) {//equality is important so that at the base case this loop may execute so the ans could be generated
				ans.add(val.substring(0, i) + ch + val.substring(i));
			}
			
		}
		
		
		return ans;
	}

}
