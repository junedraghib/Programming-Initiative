package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 05-Jan-2019
 */
public class Subset_Problem {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		String arr = "";
		int i = 0;
		while (i < n) {
			arr += s.next();
			i++;
		}
//        System.out.println(arr);

		int target = s.nextInt();

//        printPermutation(arr, "");
		printSS(arr, "", target);

	}

	public static void printSS(String ques, String ans, int target) {

		if (ques.length() == 0) {
			int sum = 0;
			for (int i = 0; i < ans.length() ;i++ )
            {
                sum += Character.getNumericValue(ans.charAt(i));
            }
            
            if(sum == target)
            {
                for (int i = 0; i < ans.length() ;i++ )
                {
                    System.out.print(ans.charAt(i)+" ");
                }
                System.out.print(" ");
            }
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans + ch, target); // yes
		printSS(roq, ans, target); // no
		
	}

//    public static void permutation(String qus, String ans, int target)
//    {
//        if (qus.length() == 0) 
//        {
////            int sum = 0;
////            for (int i = 0; i < ans.length() ;i++ )
////            {
////                sum += Character.getNumericValue(ans.charAt(i));
////            }
////            
////            if(sum == target)
////            {
////                for (int i = 0; i < ans.length() ;i++ )
////                {
////                    System.out.print(ans.charAt(i)+" ");
////                }
////                System.out.print(" ");
////            }
//        	System.out.println(ans);
//            
//            return;
//        }
//        
//        char ch = qus.charAt(0);
//        String roq = qus.substring(1);
//        
//        for (int i = 0; i < ans.length() ;i++ )
//        {
//            permutation(roq, ans.substring(0, i)+ch+ans.substring(i), target);
//        }
//    }

	public static void printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {
			printPermutation(roq, ans.substring(0, i) + ch + ans.substring(i));
		}

	}
}
