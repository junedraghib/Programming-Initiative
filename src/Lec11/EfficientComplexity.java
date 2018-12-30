package Lec11;

import java.time.Period;
import java.util.Arrays;

/**
 * created by : Juned Raghib created on : 26-Dec-2018
 */
public class EfficientComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(polynomial(5, 3));
		System.out.println(countSS("nitin"));
//		sieveofErathosthenes(10);

	}

	public static float polynomial(float x, int p) {
		float sum = 0, previous = 1;
		while (p > 0) {
			previous *= x;
			sum += previous * p;

			p--;
		}

		return sum;

	}

	public static int countSS(String str) {
		// odd length
		int count = 0;
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(orbit + axis)) {
					count++;
				} else {
					break;
				}
			}
		}

		// even length
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit+= 1) {
				if (str.charAt((int)(axis - orbit)) == str.charAt((int)(axis + orbit))) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}
	
	//print primes between given range in O(n(log(logn)))complexity
	
	public static void sieveofErathosthenes(int n)
	{
		boolean[] arr = new boolean[n+1];
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;
		
		for (int table = 2; table*table <= n; table++) 
		{
			if (arr[table] == true) {
				for (int multiplier = 2; multiplier*table <= n; multiplier++) {
					arr[multiplier*table] = false;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] = true)
			{
				System.out.println(i);
			}
		}
		
	}
	
		
		public static int power(int x, int p)
		{
			if (p == 0)
			{
				
			}
			int previous = power(x, p/2);
			int pp = 1;
			if (x % 2 == 0)
			{
				return previous * previous;
			}
			else
			{
				return x * previous * previous;
			}
			
			
		}
		
	
		
		
		
		
		
		
	}


