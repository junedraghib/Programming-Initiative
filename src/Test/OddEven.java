package Test;

import java.util.Scanner;

public class OddEven {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while(t > 0)
        {
            long n = s.nextLong();
            int seven = 0, sodd = 0, pos = 1;
            while( n > 0)
            {
                long rem = n % 10;
                if(pos % 2 != 0)
                {
                    sodd += rem;
                }
                else
                {
                    seven += rem;
                }
                
                n /= 10;
            }
            
            if(sodd % 3 == 0 || seven % 4 == 0)
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
            
            t--;
        }
    }
}