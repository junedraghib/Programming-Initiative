package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 24-Dec-2018
 */
public class DeepakGF {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while(t > 0)
        {
            int n = s.nextInt();
            int i = 0;
            int[] price1 = new int[n];
            while(i < n)
            {
                price1[i] = s.nextInt();
                
                i++;
            }
            
            int[] price = bubbleSort(price1);
            int total = s.nextInt();
            int mindiff = Integer.MAX_VALUE, r1 = -1, r2 = -1;
            
            for (i = 0; i < n ;i++ )
            {
                
                for (int j = i; j < n ;j++ )
                {
                    if (price[i] + price[j] == total)
                    {
    
                        if(Math.abs(price[i] - price[j]) <= mindiff)
                        {
                            mindiff = Math.abs(price[i] - price[j]);
                            //System.out.println(mindiff);
                            r1 = i;
                            r2 = j;
                        }
                        
                        
                    
                    }
                }
            }
            
            if(r1 != -1 && r2 != -1)
            {
                System.out.println("Deepak should buy roses whose prices are "+price[r1]+" and "+price[r2]+".");
            }
            t--;
        }
    }
    
    public static int[] bubbleSort(int[] arr)
    {
    	//long start = System.currentTimeMillis();
    	
    	int n = arr.length;
        for (int i = 0; i < n - 1 ; i++ )
        {
            boolean isSwapped = false;
            for (int j = 0; j < n - i - 1 ; j++ )
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    isSwapped = true;
                }
            }
            
            if (!isSwapped)
            {
                break;
            }
        }
        
        
        return arr;
        
    }
}