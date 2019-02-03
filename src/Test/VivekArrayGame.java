package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class VivekArrayGame {
//	static int score = 0;
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t > 0) {

			int n = s.nextInt();
			int[] arr = new int[n];
			int i = 0;
			int target = 0;
			while (i < n) {
				arr[i] = s.nextInt();
				target += arr[i];
				i++;
			}
//            System.out.println(target);
			System.out.println(game(arr, 0, arr.length ));

			t--;
		}
	}

	private static int game(int[] arr, int i, int f) {
//		boolean found = false;
		for (int j = i + 1; j <= f - 1; j++) {
			int suml = sum(arr, i, j);
//			System.out.println("suml : "+suml);
			int sumr = sum(arr, j, f );
//			System.out.println("sumr : "+sumr);
			if(suml == sumr) {
				int scorel = game(arr, i, j);
				int scorer = game(arr, j, f);
				return Math.max(scorel, scorer) + 1;
			}
			
		}
		return 0;
	}
	
	private static int sum(int[] arr, int i, int f) {
		int sum = 0;
		for (int j = i; j < f; j++) {
			sum += arr[j];
		}
		
		return sum;
	}

}