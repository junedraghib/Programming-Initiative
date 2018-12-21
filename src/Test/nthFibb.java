package Test;

import java.util.*;
public class nthFibb {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a, b, c = 0, i;
        a = 0;
        b = 1;
        i = 1;
        while (i <= n)
        {
        	c = a + b;
        	a = b;
        	b = c;
        	
        	i++;
		}
        
        System.out.println(a);
    }
}
