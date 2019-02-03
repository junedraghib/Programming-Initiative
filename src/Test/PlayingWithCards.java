package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PlayingWithCards {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int q = s.nextInt();
		Stack<Integer> Am1 = new Stack<>();
		Stack<Integer> A = new Stack<>();
		Stack<Integer> B = new Stack<>();
//		Stack<Integer> pile = new Stack<>();
		int i = 0;

		i = 0;
		while (i < n) {
			Am1.push(s.nextInt());
			i++;
		}
//		System.out.println(ithprime(3));

		for (int j = 1; j <= q; j++) {
			while (!Am1.isEmpty()) {
				int top = Am1.pop();

				if (top % ithprime(j) == 0) {
					B.push(top);
				} else {
					A.push(top);
				}
			}

			while (!B.isEmpty()) {
				System.out.println(B.pop());
			}

			Am1 = A;
			
			if(j == q) {
				while (!Am1.isEmpty()) {
					System.out.println(Am1.pop());
				}
			}

		}

	}

	public static int ithprime(int i) {
		int count = 0;
		int num = 2;
		while(true) {
			if(isprime(num)) {
				count++;
				if(count == i) {
					return num;
				}
			}
			num++;
		}
	}

	public static boolean isprime(int n) {

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
