package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 30-Dec-2018
 */
public class BinarySearch {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
        
//        int nn = n;
//        int i = 0;
//        int[] arr = new int[n];
//        while(i < n)
//        {
//            arr[i] = s.nextInt();
//            i++;
////            n--;
//        }
        
//        int m = s.nextInt();
        int[] arr1 = {3, 5, 6, 9, 78};
        
        System.out.println(binarySearch(arr1, 0, arr1.length - 1, 78 ));
        
        
    }

	public static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
}
