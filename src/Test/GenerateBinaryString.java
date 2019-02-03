package Test;

import java.util.Scanner;

public class GenerateBinaryString {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0) {
			
			String str = s.next();
			gernerate(str, "");
			
			t--;
		}
    }
    
    public static void gernerate(String qus, String ans){
        
        if(qus.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        
        char ch = qus.charAt(0);
        String str = qus.substring(1);
        
        if(ch == '0' || ch == '1'){
            gernerate(str, ans+ch);
        } else if(ch == '?'){
            gernerate(str, ans+"0");
            gernerate(str, ans+"1");
        }
    }
}