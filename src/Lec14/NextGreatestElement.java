package Lec14;

import java.util.Scanner;

import Lec13.*;

/**
 * created by : Juned Raghib created on : 01-Jan-2019
 */
public class NextGreatestElement {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
		int[] arr = { 10, 20, 5, 60, 30, 70 };

//		for (int i = 0; i < args.length; i++) {
//			arr[i] = s.nextInt();
//		}

		int[] ans = nextGreatest(arr);

		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static int[] nextGreatest(int[] arr) throws Exception {
		Stack stack = new Stack(100);
		int[] ans = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[stack.pop()] = arr[i];
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}

		return ans;
	}

}
