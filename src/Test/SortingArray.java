package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 24-Dec-2018
 */
public class SortingArray {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        int[] arr = new int[n]; 
        while(i < n)
        {
            arr[i] = s.nextInt();
            i++;
        }
        
        display(bubbleSort(arr));
        display(selectionSort(arr));
        display(insertionSort(arr));
		
    }
    
    public static int[] insertionSort(int[] arr)
    {
        long start = System.currentTimeMillis();
    	
    	int n = arr.length;
    	//Integer.va
        for (int i = 0; i < n ; i++ )
        {
            int key = arr[i];
            int j = i - 1;
            while( j >= 0 && arr[j] > key)
            {
                
                arr[j + 1] = arr[j];
                j = j - 1;
            
            }
            
            arr[j + 1] = key;
            
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("Insertion Sort Time Taken : "+(double)(end-start));
        
        return arr;
        
    }
    
    
    public static int[] selectionSort(int[] arr)
    {
    	long start = System.currentTimeMillis();
    	
    	int n = arr.length;
        for (int i = 0; i < n - 1 ; i++ )
        {
            int min = i;
            for (int j = i + 1; j < n ; j++ )
            {
                if(arr[j] < arr[min])
                {
                    min = j;
                    
                }
            }
            
            //only n swap will occur, this selectionSort is MW efficient algorithm 
            
            if( min != i)
            {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("Selection Sort Time Taken : "+(double)(end-start));
        
        return arr;
        
    }
    
    
    public static int[] bubbleSort(int[] arr)
    {
    	long start = System.currentTimeMillis();
    	
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
        
        long end = System.currentTimeMillis();
        
        System.out.println("Bubble Sort Time Taken : "+(double)(end-start));
        
        return arr;
        
    }
    
    
    
    public static void display(int[] arr)
    {
        int i = 0;
        while(i < arr.length)
        {
            System.out.print(arr[i]+" ");
            i++;
        }
        System.out.println();
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
}

    