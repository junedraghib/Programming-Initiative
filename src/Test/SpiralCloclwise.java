package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 26-Dec-2018
 */

//3 4
//11 12 13 14
//21 22 23 24
//31 32 33 34
public class SpiralCloclwise {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();

		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		int rs = 0, cs = 0, re = m - 1, ce = n - 1, i = 0, j = 0;
		while (ce >= cs && re >= rs) {
			i = rs;
			j = cs;
			while (j <= ce) {
				System.out.printf(arr[i][j] + ", ");
				j++;
			}
			rs++;
			i = rs;
			j = ce;
			while (i <= re) {
				System.out.printf(arr[i][j] + ", ");
				i++;
			}
			ce--;
			i = re;
			j = ce;
			if (re >= rs) {
				while (j >= cs) {
					System.out.printf(arr[i][j] + ", ");
					j--;
				}
				re--;
				i = re;
				j = cs;
				while (i >= rs) {
					System.out.printf(arr[i][j] + ", ");
					i--;
				}
				cs++;
			}
		}

		System.out.print("END");

	}
}
