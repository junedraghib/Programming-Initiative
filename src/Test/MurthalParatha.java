package Test;

import java.util.Arrays;
import java.util.Scanner;

public class MurthalParatha {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int nop = scn.nextInt();
		int now = scn.nextInt();

		int[] arr = new int[now];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);

		int lo = 0;
		int hi = arr[arr.length - 1] * nop;
//		System.out.println(hi);
		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(arr, now, nop, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);
	}

	private static boolean isPossible(int[] arr, int now, int nop, int mid) {
		int pratha = 1;
		int timeremaining = mid;
		
		int i = 0;
		while(i < arr.length) {
			
			if(arr[i] < timeremaining) {
				timeremaining -= arr[i];
				pratha++;
				if(pratha == nop) {
					return true;
				}
			} else {
				i++;
				timeremaining = mid;
				
			}
//			return true;
		}
		
		return false;
	}

}
