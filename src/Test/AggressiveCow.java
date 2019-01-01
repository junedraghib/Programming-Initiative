package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 31-Dec-2018
 */
public class AggressiveCow {
	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        int[] index = new int[n];
        
        
        int i = 0;
        while(i < n)
        {
            index[i] = s.nextInt();
            i++;
        }
        
        Arrays.sort(index);
        
         
        int mindis = 1;
        while(true)
        {
            i = 0;
            int j = i + 1;
            int remainingstalls = n;
            int remainingcows = c;
            //boolean[] isassigned = new boolean[n];
            //isassigned[0] = true;
            remainingcows--;
            remainingstalls--;
            while(remainingcows > 0 && remainingstalls > 0 && i < n - 1 && j < n)
            {
                if (index[j] - index[i] >= mindis)
                {
                    //isassigned[j] = true;
                    remainingstalls--;
                    remainingcows--;
                    i++;
                    j++;
                }
                else 
                {
                    //isassigned[j] = true;
                    remainingstalls--;
                    //i++;
                    j++;
                }
            }
            
            
            System.out.println(remainingcows+" "+remainingstalls);
            
            if(remainingcows <= 0)
            {
            	mindis++;
            	continue;
            }
            else if(remainingstalls <= 0)
            {
                System.out.println(mindis);
                break;
            }
            else
            {
                break;
            }
            
        }
        
    }
}