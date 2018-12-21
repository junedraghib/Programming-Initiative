package Test;

import java.util.Scanner;

public class mountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        
        int nsp = 2*n - 3, nch = 1, row = 1;
        
        while(row <= n)
        {
            //for each row
            int ch = 1;
            int cch = 1;
            while(cch <= nch)
            {
                System.out.print(ch+"\t");
                cch++;
                ch++;
            }
            
            //spaces
            int csp = 1;
            while(csp <= nsp)
            {
                System.out.print(" \t");
                csp++;
            }
            
            //character again
            cch = 1;
            if (row == n)
            {
            	cch = 2;
            	ch--;
			}
            while(cch <= nch)
            {
                ch--;
            	System.out.print(ch+"\t");
                cch++;
                
            }
            
            nch++;
            nsp -= 2;
            System.out.println();
            row++;
        }
        System.out.println(Math.pow(2, 2));
   }
	}

