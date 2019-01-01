package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 30-Dec-2018
 */
public class RainWater {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while(t > 0)
        {
            int n = s.nextInt();
            int[] arr = new int[n]; 
            int[] maxl= new int[n];
            int[] maxr= new int[n];
            
            int i = 0;
            while(i < n)
            {
                arr[i] = s.nextInt();
                i++;
            }
            
            i = 0;
            int max = Integer.MIN_VALUE;
            while(i < n)
            {
                if(arr[i] > max)
                {
                    max = arr[i];
                }
                
                maxl[i] = max;
                i++;
            }
            
            i = n - 1;
            max = Integer.MIN_VALUE;
            while(i >= 0)
            {
                if(arr[i] > max)
                {
                    max = arr[i];
                }
                
                maxr[i] = max;
                i--;
            }
            
            i = 0;
            int waterCollected = 0;
            while(i < n)
            {
                waterCollected += Math.min(maxr[i], maxl[i]) - arr[i];
                i++;
            }
//            System.out.println();
//            display(arr);
//            System.out.println();
//            display(maxr);
//            System.out.println();
//            display(maxl);
//            System.out.println();
            System.out.println(waterCollected);
            
            t--;
        }
    }
	
	
	public static void display(int[] arr)
	{
		for(int val : arr)
		{
			System.out.print(val+" ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}