package Test;

import java.util.Scanner;

public class numberPatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int row = 1, nsp = n - 1, nch = 1, ch;
        while(row <= n)
        {
            //for each row
            int csp = 1;
            ch = row;
            while(csp <= nsp)
            {
                System.out.print(" \t");
                csp++;
            }
            
            int cch = 1;
            while(cch <= nch)
            {
                System.out.print(ch+"\t");
                if(cch <= nch/2)
                {
                    ch++;
                }
                else
                {
                    ch--;
                }
                cch++;
            }
            
            System.out.println();
            
            //updation
            
            
                nsp--;
                nch +=2;
            
            row++;
        }
        row -=2;
        nsp = 1;
        nch = 2*n - 2;
        while(row >= 0)
        {
        	int csp = 1;
            ch = row;
            while(csp <= nsp)
            {
                System.out.print(" \t");
                csp++;
            }
            
            int cch = 1;
            while(cch < nch)
            {
                System.out.print(ch+"\t");
                if(cch <= nch/2 - 1)
                {
                    ch++;
                }
                else
                {
                    ch--;
                }
                cch++;
            }
            
            nsp++;
            nch -= 2;
            row--;
            System.out.println();
        }
	}

}
