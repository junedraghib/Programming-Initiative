package Test;

import java.util.Scanner;

public class PascalTriangle {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] arr = new int[n];
        
        arr[0] = 1;
        System.out.println(arr[0]);
        arr[1] = 1;
        System.out.println(arr[0] +"\t"+ arr[1]);
        
        int row = 2;
        while(row < n)
        {
            arr = generateNext(arr, row, n);
            display(arr, row);
            row++;
        }
    }
    
    public static int[] generateNext(int[] arr, int cRow, int n)
    {
        int[] arr1 = new int[n];
        arr1[0] = 1;
        int i = 0;
        int j = 1;
        while(i < cRow - 1 && j < cRow)
        {
            arr1[j] = arr[i] + arr[j];
            
            i++;
            j++;
        }
        
        arr1[j] = 1;
        
        return arr1;
    }
    
    public static void display(int[] arr, int row)
    {
        int i = 0;
        while(i <= row)
        {
            System.out.print(arr[i]+"\t");
            i++;
        }
        System.out.println();
        
        
        
    }
}