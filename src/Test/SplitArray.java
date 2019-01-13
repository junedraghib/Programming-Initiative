package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 04-Jan-2019
 */
public class SplitArray {
//	static int count = 0;
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int i = 0;
		int sum1 = 0;
		int arr[] = new int[n];
		while (i < n) {
			arr[i] = scn.nextInt();
			sum1 += arr[i];
			i++;
		}
		
		//int count = count(arr, 0, sum1 / 2, new boolean[arr.length], 0);
//		split3(arr, 0, sum1 / 2, new boolean[n]);
		split(arr, 0, 0, "", "", 0);
//		System.out.println(count);

	}
	
	public static void split(int[] arr, int sumgp1, int sumgp2, String gp1, String gp2, int vidx)
    {
        
        if(vidx == arr.length )
        {
            if(sumgp1 == sumgp2)
            {
                System.out.println(gp1+" and "+gp2);
                return;
            }
            else
                return;
        }
        
        
        split(arr, sumgp1 + arr[vidx], sumgp2, gp1+arr[vidx]+" ", gp2, vidx + 1);
        
        split(arr, sumgp1, sumgp2  + arr[vidx], gp1, gp2+arr[vidx]+" ", vidx + 1);
        
    }

	public static int split(int[] arr, int vidx, int target, int count, int sum) {
		if (vidx == arr.length) {
			return count;
		}
		if (sum == target) {
			count++;
			display(arr, vidx);
			return count;
		}

		int cur = arr[vidx];
		count += split(arr, vidx++, target, count, sum + cur);
//    	count += split(arr, vidx++, target, count, sum);

		return count;

	}

	public static void split2(int[] arr, int vidx, int target, int sum, boolean[] include) {
		if (vidx == arr.length) {
			return;
		}

		if (sum == target) {
//			display2(arr, vidx, include);
		}
		else if(sum < target)
		{
			return;
		}
		else if(sum > target)
		{
			//include[vidx] = false;
			return;
		}
		

		int cur = arr[vidx];
		split2(arr, vidx++, target, sum, include);
		include[vidx] = true;
		split2(arr, vidx++, target, sum + cur, include);

	}
	
	public static void split3(int[] arr, int vidx, int target, boolean[] included)
	{
		if(target == 0)
		{
//			count++;
			display2(arr, included);
			return;
		}
		
		for (int i = vidx; i < arr.length; i++) {
			if (!included[i]) {
				included[i] = true;
				split3(arr, i, target - arr[i], included);
				included[i] = false;
			}
		}
		
	}
	
	public static int count(int[] arr, int vidx, int target, boolean[] included, int count)
	{
		if(target == 0)
		{
			count++;
			return count;
		}
		
		for (int i = vidx; i < arr.length; i++) {
			if (!included[i]) {
				included[i] = true;
				count += count(arr, i, target - arr[i], included, count);
				included[i] = false;
			}
		}
		
		return 0;
	}

	public static int sum(int[] arr, int vidx) {
		int sum = 0;
		int i = 0;
		while (i < vidx) {
			sum += arr[i];

			i++;
		}
		return sum;
	}

	public static void display(int[] arr, int vidx) {
		int i = 0;
		while (i < vidx) {
			System.out.print(arr[i] + " ");
			i++;
		}

		System.out.printf("and ");

		while (i < arr.length) {
			System.out.print(arr[i] + " ");
			i++;
		}
		System.out.println();

	}

	public static void display2(int[] arr, boolean include[]) {
		int i = 0;
		while (i < arr.length) {
			if (include[i]) {
				System.out.print(arr[i] + " ");
			}

			i++;
		}
		
		System.out.print("and ");
		
		i = 0;
		while (i < arr.length) {
			if (!include[i]) {
				System.out.print(arr[i] + " ");
			}

			i++;
		}

		System.out.println();

	}
}
