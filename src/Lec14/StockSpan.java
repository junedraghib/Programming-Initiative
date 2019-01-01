package Lec14;

import java.util.Scanner;

import Lec13.Stack;

/**
 * created by : Juned Raghib created on : 01-Jan-2019
 */
public class StockSpan {
	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
		int[] arr = {100, 20, 30, 50, 10, 70, 80, 40, 120, 30, 150 };

//		for (int i = 0; i < args.length; i++) {
//			arr[i] = s.nextInt();
//		}

		int[] ans = stockSpan(arr);

		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static int[] stockSpan(int[] arr) throws Exception {
		Stack stack = new Stack(100);
		int span = 0;
		int[] ans = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				span = i + 1;
			} else {
				span = i - stack.peek();
			}
			
			ans[i] = span;
			
			stack.push(i);
		}

		return ans;
	}

}
