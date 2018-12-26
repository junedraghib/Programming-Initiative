package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 25-Dec-2018
 */
public class BitonicMaxPath {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while(t > 0)
        {
            int n, m, i;
            n = s.nextInt();
            m = s.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            
            i = 0;
            while(i < n)
            {
                arr1[i] = s.nextInt();
                i++;
            }
            
            i = 0;
            while(i < m)
            {
                arr2[i] = s.nextInt();
                i++;
            }
            
            int c1 = -1, c2 = -1;
            //detecting common point
            int sum = 0;
            for (i = 0; i < n ;i++)
            {
                for (int j = 0; j < m ;j++)
                {
                    if(arr1[i] == arr2[j])
                    {
                        c1 = i;
                        c2 = j;
                        
                        int sum11 = 0, sum12 = 0, sum21 = 0, sum22 = 0;
                        if(c1 != -1 && c2 != -1)
                        {
                            for (int ii = 0; ii < c1 ;ii++)
                            {
                                sum11 += arr1[ii];
                            }
                            
                            for (int ii = c1; ii < n ;ii++)
                            {
                                sum12 += arr1[ii];
                            }
                            
                            for (int ii = 0; ii < c2 ;ii++)
                            {
                                sum21 += arr2[ii];
                            }
                            
                            for (int ii = c2; ii < n ;ii++)
                            {
                                sum22 += arr2[ii];
                            }
                            
                           
                            if(sum < sum11 + sum12)
                            {
                                sum = sum11 + sum12;
                            }
                            else if(sum < sum11 + sum22)
                            {
                                sum = sum11 + sum22;
                            }
                            else if(sum < sum21 + sum22)
                            {
                                sum = sum21 + sum22;
                            }
                            else if(sum < sum21 + sum12)
                            {
                                sum = sum21 + sum12;
                            }
                            
                            
                        }
                    }
                }
            }
            System.out.println(sum);
            
                
                //
                
            
                        
            t--;
        }
    }
}