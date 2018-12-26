package Test;

import java.util.Scanner;

public class RotateArray {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int i = 0;
        long[] arr = new long[n];
        while(i < n)
        {
            arr[i] = s.nextLong();
        
            i++;
        }
        
        int q = s.nextInt();
        long sum = 0;
        while(q > 0)
        {
            int x = s.nextInt();
            i = 0;
            while(i < n)
            {
                arr[i] += array(arr, i, x);
                sum += arr[i]; 
            }
            q--;
        }
        
        
        System.out.println(sum % (Math.pow(10,9) + 7));
        
        
    }
    
    
    public static long array(long[] arr, int i, int x)
    {
        if(i - x < 0)
        {
            return arr[arr.length + i -x];
        }
        else{
            return arr[i - x];
        }
    }
}