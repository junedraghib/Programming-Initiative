package Test;

import java.util.Scanner;

public class testChar {

		public static void main(String args[]) {
	        Scanner s = new Scanner(System.in);
	        
	        char ch = '\0';
	        int n1 = 0, n2 = 0;
	        while(ch != 'X' || ch != 'x')
	        {
	            ch = s.next().charAt(0);
	            if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
	            {
	                n1 = s.nextInt();
	                n2 = s.nextInt();
	                
	                if(ch == '+')
	                {
	                    System.out.println(n1+n2);
	                }
	                else if(ch == '-')
	                {
	                    System.out.println(n1-n2);
	                }
	                else if(ch == '*')
	                {
	                    System.out.println(n1*n2);
	                }
	                else if(ch == '/')
	                {
	                    System.out.println(n1/n2);
	                }
	                
	            
	            }
	            else if(ch == 'X' || ch == 'x')
	            {
	                return;
	            }
	            else
	            {
	                System.out.println("Invalid operation. Try again.");
	            }
	            
	        }
	    }
	}
