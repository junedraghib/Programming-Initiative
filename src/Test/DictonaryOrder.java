package Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 09-Jan-2019
 */
public class DictonaryOrder {

//	static ArrayList<String> list = new ArrayList<>();
//    public static void main(String args[]) {
////        Scanner s = new Scanner(System.in);
////        String str = s.next();
////        printss(str, " ");
////        ArrayList<String> ans = sort(list);
////        for(String val : ans)
////        {
////           if(str.compareTo(val) > 0)
////           {
////               System.out.println(val);
////           }
//////           System.out.println(val);
////        }
//    	System.out.println(compareto("abc", "acd"));
//    }
//    
//    
//    public static void printss(String qus, String ans)
//    {
//        if(qus.length() == 0)
//        {
//            list.add(ans);
//            return;
//        }
//        
//        
//        char ch = qus.charAt(0);
//        String roq = qus.substring(1);
//        
//        for (int i = 0; i < ans.length() ;i++ )
//        {
//            printss(roq, ans.substring(0, i)+ch+ans.substring(i));
//        }
//    }
//    
//    public static int compareto(String s1, String s2)
//    {
//    	
//    	char ch1 = s1.charAt(0);
//    	char ch2 = s2.charAt(0);
//    	
//    	String ros1 = s1.substring(1);
//    	String ros2 = s2.substring(1);
//    	
//    	if (ch1 - ch2 == 0) {
//			return compareto(ros1, ros2);
//		}
//    	else
//    		return ch1 - ch2;
//    	
//    }
//    
//    
//    public static ArrayList<String> sort(ArrayList<String> list) {
//		for (int i = 0; i < list.size() - 1; i++) {
//			int min = i;
//			for (int j = i + 1; j < list.size(); j++) {
//				if (list.get(j).compareTo(list.get(min)) < 0) {
//					min = j;
//				}
//			}
//
//			String temp = list.get(min);
//			list.set(min, list.get(i));
//			list.set(i, temp);
//		}
//
//		return list;
//	}
//}

	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			String str = s.next();
//			System.out.println(getPermutaion("cab"));
//			ArrayList<String> ans = getPermutaion(str, str);
//			for(String val : ans)
//			{
//				if (compareto(val, str) < 0) {
//					System.out.println(val);
//				}
////	 			System.out.println(val);
//			}
			printPermutation(str, "", false);

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
			String ros = s.substring(1);
			ArrayList<String> rr = getPermutaion(ros, str);
			
			ArrayList<String> ans = new ArrayList<>();
			
			for(String val : rr)
			{
				for (int i = 0; i <= val.length(); i++) {//equality is important so that at the base case this loop may execute so the ans could be generated
					String temp = val.substring(0, i) + ch + val.substring(i);
					ans.add(temp);
				}
				
			}
			
			
			return ans;
		}
		
		
		public static void printPermutation(String ques, String ans, String str) {

			if (ques.length() == 0) {
				if(ans.compareTo(str) > 0)
				{
				    System.out.println(ans);
				}
				return;
			}

			char ch = ques.charAt(0);
			String roq = ques.substring(1);

			for (int i = 0; i <= ans.length(); i++) {
				printPermutation(roq, ans.substring(0, i) + ch + ans.substring(i), str);
			}

		}
		
		public static void printPermutation(String ques, String ans, boolean islarger) {

			if (ques.length() == 0) {
				if(islarger)
				{
				    System.out.println(ans);
				}
				return;
			}

			char ch = ques.charAt(0);
			String roq = ques.substring(1);

			if(islarger)
			{
			    printPermutation(roq, ch + ans, true);
			}
			else{
			    if(ch < ques.charAt(0))
			    {
			        //no call
			    }
			    else if(ch > ques.charAt(0))
			    {
			        printPermutation(roq, ch + ans, true);
			    }
			    else
			    {
			        printPermutation(roq, ch + ans, false);
			    }
			}

		}
		
		public static int compareto(String s1, String s2)
	    {
	    	if (s1.length() == 0 && s2.length() == 0)
	    	{
	    	    return 0;
	    	}
	    	
	    	if (s1.length() == 0 )
	    	{
	    	    return -1 * s2.charAt(0);
	    	}
	    	
	    	if (s2.length() == 0)
	    	{
	    	    return s1.charAt(0);
	    	}
	    	
	    	
	    	
	    	char ch1 = s1.charAt(0);
	    	char ch2 = s2.charAt(0);
	    	
	    	String ros1 = s1.substring(1);
	    	String ros2 = s2.substring(1);
	    	
	    	if (ch1 - ch2 == 0) {
				return compareto(ros1, ros2);
			}
	    	else
	    		return ch1 - ch2;
	    	
	    }

	}
