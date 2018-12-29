package Test;

import java.util.ArrayList;

/**
 * created by : Juned Raghib
 * created on : 27-Dec-2018
 */
public class RecursionCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<ArrayList<String>> aa = new ArrayList<ArrayList<String>>();
//		ArrayList<String> a = new ArrayList<>();
//		ArrayList<String> b = new ArrayList<>();
//		a.add("hello");
//		b.add("juned");
//		aa.add(a);
//		aa.add(b);
//		System.out.println(aa);
//		
//		char ch = 'A';
		System.out.println(getRecursionCode("1125"));

	}
	
	public static ArrayList<ArrayList<String>> getRecursionCode(String str)
	{
		if(str.length() == 0)
		{
			ArrayList<ArrayList<String>> br = new ArrayList<ArrayList<String>>();
			ArrayList<String> a = new ArrayList<>();
			ArrayList<String> aa = new ArrayList<>();
			a.add("");
			br.add(a);
			br.add(a
			br.
			return br;
		}
		
		String ch = str.substring(0,1);
		String roq = str.substring(1);
		
		ArrayList<ArrayList<String>> rr = getRecursionCode(roq);
		
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		
		//ArrayList<String> firstal = rr.get(0);
		rr.get(0).set(0, ch + rr.get(0).get(0));
		
		rr.get(1).add(0, ch);
		
		ans.add(rr.get(0));
		ans.add(rr.get(0));
		
		return ans;
		
	}

}
