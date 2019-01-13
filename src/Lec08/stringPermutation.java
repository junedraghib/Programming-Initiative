package Lec08;

import java.util.ArrayList;
import java.util.Scanner;

public class stringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
//		System.out.println(getPermutaion("cab"));
		ArrayList<String> ans = getPermutaion(str, str);
		for(String val : ans)
		{
//			if (val.compareTo(str) < 0) {
//				System.out.println(val);
//			}
			System.out.println(val);
		}

	}
	
	
	public static ArrayList<String> getPermutaion(String s, String str)
	{
		if(s.length() == 0)
		{
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		
		char ch = s.charAt(0);
		
		ArrayList<String> rr = getPermutaion(s.substring(1), str);
		
		ArrayList<String> ans = new ArrayList<>();
		
		for(String val : rr)
		{
			for (int i = 0; i <= val.length(); i++) {//equality is important so that at the base case this loop may execute so the ans could be generated
				String temp = val.substring(0, i) + ch + val.substring(i);
				if (temp.compareTo(str) < 0) {
					ans.add(temp);
				}
			}
			
		}
		
		
		return ans;
	}

}
