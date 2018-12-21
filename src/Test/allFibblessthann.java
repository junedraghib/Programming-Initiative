package Test;

import java.util.Scanner;

public class allFibblessthann {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        generateFibb(n);
       
    }
    
    public static void generateFibb(int n)
    {
        int a, b, c, i;
        a = 0;
        b = 1;
        i = 1;
        while(i <= n && a <= n)
        {
        	System.out.println(a);
        	c = a + b;
            a = b;
            b = c;
            
        }
        

	}

}
