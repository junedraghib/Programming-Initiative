package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 31-Dec-2018
 */
public class NextSmallerofNextGreatest {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t > 0)
        {
            int n = s.nextInt();
            int[] arr = new int[n];
            
            int i = 0;
            while(i < n)
            {
                arr[i] = s.nextInt();
                i++;
            }
            
            for (i = 0; i < n ;i++ )
            {
                int cur = arr[i];
                
                int j = i + 1;
                int large = -1;
                while(j < n - 1)
                {
                    if(arr[j] > cur)
                    {
                        large = arr[j];
                        break;
                    }
                    j++;
                }
//                System.out.print(large);
                int k = j + 1;
                int min = -1;
                while(k < n - 1)
                {
                    if (large > arr[k])
                    {
                        min = arr[k];
                        break;
                    }
                    k++;
                }
                
                System.out.printf(min+" ");
            }
            
            
            t--;
        }
    }
}