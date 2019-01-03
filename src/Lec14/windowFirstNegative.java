package Lec14;

import Lec13.Queue;

/**
 * created by : Juned Raghib 
 * created on : 01-Jan-2019
 */
public class windowFirstNegative {

	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		int[] arr = { 2, 3, -1, 4, -3, -2, -1, 5, 6, 7, -1 };
		getFirstNegative(arr, 4);
	}

	public static void getFirstNegative(int[] arr, int k) throws Exception {
		Queue window = new Queue(100);
		for (int i = 0; i < k; i++) {
			// for the first window
			// insert element if it is negative
			if (arr[i] < 0) {
				window.enqueue(i);
			}
		}

		for (int i = k; i < arr.length; i++) {
			// get first negative for previous window
			if (window.isEmpty()) {
				System.out.println("0");
			} else {
				System.out.println(arr[window.getFront()]);
			}

			// remove useless element

			if (!window.isEmpty() && window.getFront() <= i - k) {
				window.dequeue();
			}

			// insert element
			if (arr[i] < 0) {
				window.enqueue(i);
			}
		}
		if (window.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(arr[window.getFront()]);
		}
	}

}
