package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 12-Jan-2019
 */
public class Chess2 {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean[] primes = SOE(n * n);
		int[] portsmines = makePortsMines(primes);
		// display(primes);
		// System.out.println();
		// display(portsmines);

		int ans = chess(0, n - 1, 0, n - 1, "", portsmines);
		System.out.println("\n" + ans);
	}

	public static int chess(int sr, int er, int sc, int ec, String ans, int[] portsmines) {
		if (sr == er && sc == ec) {
			System.out.print(ans + "{" + sr + "-" + sc + "} ");
			return 1;
		}

		if (sr > er || sc > ec) {
			return 0;
		}

		if (portsmines[sr * (ec + 1) + (sc + 1)] == 1) {
			return 0;
		}

		int count = 0;

		if (portsmines[sr * (ec + 1) + (sc + 1)] == 2) {
			count += chess(er, er, ec, ec, ans + "{" + sr + "-" + sc + "}P", portsmines);
		}

		// as knight
		count += chess(sr + 2, er, sc + 1, ec, ans + "{" + sr + "-" + sc + "}K", portsmines);
		count += chess(sr + 1, er, sc + 2, ec, ans + "{" + sr + "-" + sc + "}K", portsmines);

		if (sr == 0 || sr == er || sc == 0 || sc == ec) {

			for (int move = 1; move <= ec - sc; move++) {
				// any number of moves horizontally
				count += chess(sr, er, sc + move, ec, ans + "{" + sr + "-" + sc + "}R", portsmines);

			}

			for (int move = 1; move <= er - sr; move++) {
				// any number of steps vertically
				count += chess(sr + move, er, sc, ec, ans + "{" + sr + "-" + sc + "}R", portsmines);

			}

		}

		if ((sr == sc) || (sr + sc == er)) {
			for (int move = 1; move <= ec - sc && move <= er - sr; move++) {
				// any number of moves diagonally
				count += chess(sr + move, er, sc + move, ec, ans + "{" + sr + "-" + sc + "}B", portsmines);

			}
		}

		return count;

	}

	public static boolean[] SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			// Don't speak the table of 4
			if (primes[table] == false) {
				continue;
			}

			for (int multiplier = 2; table * multiplier <= n; multiplier++) {
				primes[table * multiplier] = false;
			}

		}

		return primes;

	}

	public static int[] makePortsMines(boolean[] primes) {
		int[] portsmines = new int[primes.length];

		int flag = 0;
		for (int j = 0; j < primes.length; j++) {
			if (primes[j]) {
				if (flag % 2 == 0) {
					portsmines[j] = 1;
				} else {
					portsmines[j] = 2;
				}

				flag++;
			}
		}

		return portsmines;
	}

	public static void display(int[] arr) {
		// for (int i = 0; i < arr.length ;i++ )
		// {

		// System.out.println();
		// }
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + "\t");
		}
	}

	public static void display(boolean[] arr) {
		// for (int i = 0; i < arr.length ;i++ )
		// {

		// System.out.println();
		// }
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
	}

}
