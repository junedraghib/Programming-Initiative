package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 24-Dec-2018
 */
public class AlexgoShopping {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int i = 0;
        int[] itemPrice = new int[n];
        while(i < n)
        {
            itemPrice[i] = s.nextInt();
            i++;
        }
        
        int q = s.nextInt();
        
        while(q > 0 && q <= 2*n)
        {
            int amt1 = s.nextInt();
            int item = s.nextInt();
            
            int j = 0;
            int count = 0;
            while(j < itemPrice.length)
            {
                int amt = amt1;
                // while(amt >= itemPrice[j])
                // {
                //     amt = amt % itemPrice[j];
                // }
                
                amt = amt % itemPrice[j];
                if(amt == 0)
                {
                    count++;
                }
                
                j++;
            }
            
            if(item == count && (item <= n && item >= 1))
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
            
            q--;
        }
        
    }
}
