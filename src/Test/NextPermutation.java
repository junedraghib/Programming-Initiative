package Test;

import java.util.Scanner;

public class NextPermutation {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t > 0){
            
            int n = s.nextInt();
            String str = "";
            while(n > 0){
                
                str += s.nextInt();
                n--;
            }
            
            permutation(str, "", str);
            
            t--;
        }
    }
    
    public static void permutation(String ques, String ans, String os) {

		if (ques.length() == 0) {
		    
		    long num = Long.parseLong(os);
		    long nextnum = Long.parseLong(ans);
			if (nextnum > num){
				int i = 0;
				while(i < ans.length()){
			        System.out.print(ans.charAt(i)+" ");	
			        i++;
				}
			}
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			permutation(roq, ans + ch, os);
		}

	}
    
}