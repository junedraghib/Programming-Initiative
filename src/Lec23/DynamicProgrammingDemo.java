package Lec23;

public class DynamicProgrammingDemo {
	public static void main(String[] args) {
//		System.out.println(fibTD(0, new int[7]));
//		System.out.println(fibUD(0));
//		System.out.println(fibUDEffecient(0));

//		System.out.println(boardPathTD(0, 10, new int[10 + 6]));
//		System.out.println(boardPathBU(0, 10));
//		System.out.println(boardPathBUE(0, 10));

//		System.out.println(mazePath(0, 0, 3, 3));
////		System.out.println(mazePathTD(0, 0, 100, 100, new int[100 + 1][100 + 1]));
////		System.out.println(mazePathBU(0, 0, 100, 100));
//		System.out.println(mazePathBU(0, 0, 100, 100));
		int[] coins = {1, 2, 3};
		System.out.println(coinChange(4, coins, ""));
		
//		System.out.println(LCS("abcd", "agcfd"));
//		System.out.println(LCSBU("abcd", "agcfd"));
	}

	// fib in O(n) using recursion
	public static int fibTD(int n, int[] strg) {
		if (n == 1 || n == 0) {
			return n;
		}

		if (strg[n] != 0) {

			return strg[n];
		}

		int fibnm1 = fibTD(n - 1, strg);
		int fibnm2 = fibTD(n - 2, strg);

		strg[n] = fibnm1 + fibnm2;
		return strg[n];
	}

	public static int fibUD(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	public static int fibUDEffecient(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;

		int i = 2;
		while (i <= n) {
			int temp = strg[1];
			strg[1] += strg[0];
			strg[0] = temp;
			i++;
		}

		return strg[1];

	}

	// boardpath using DP
	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		// reuse
		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathTD(curr + dice, end, strg);
		}

		// store
		strg[curr] = count;
		return count;

	}

	// BU DP
	public static int boardPathBU(int curr, int end) {

		int[] strg = new int[end + 6];

		strg[end] = 1;

		int i = end - 1;
		while (i >= 0) {

			int sum = 0;
			for (int j = 1; j <= 6; j++) {
				sum += strg[i + j];
			}
			strg[i] = sum;
			i--;
		}

		return strg[0];

	}

	// BU Efficient
	public static int boardPathBUE(int curr, int end) {

		int[] strg = new int[6];

		strg[0] = 1;

		int i = end - 1;
		while (i >= 0) {

			int sum = 0;
			for (int j = 0; j < 6; j++) {
				sum += strg[j];
			}

			for (int j = 5; j > 0; j--) {
				strg[j] = strg[j - 1];
			}

			strg[0] = sum;
			i--;
		}

		return strg[0];
	}

	// maze path
	public static int mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazePath(cr + 1, cc, er, ec);
		int cv = mazePath(cr, cc + 1, er, ec);

		return ch + cv;
	}

	// maze path using DP
	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr + 1, cc, er, ec, strg);
		int cv = mazePathTD(cr, cc + 1, er, ec, strg);

		strg[cr][cc] = ch + cv;
		return ch + cv;
	}

	// DP BU
	public static int mazePathBU(int cr, int cc, int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];
		strg[er][ec] = 1;
		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				strg[i][j] = strg[i][j] + strg[i + 1][j] + strg[i][j + 1];
			}
		}

		return strg[0][0];
	}

	// DP BUE
	public static int mazePathBUE(int cr, int cc, int er, int ec) {

		int[] strg = new int[ec + 1];

		for (int i = er - 1; i >= 0; i--) {
			for (int j = ec - 1; j >= 0; j--) {
				strg[j] = strg[j] + strg[j + 1];
			}
		}

		return strg[0];
	}

	// coin change using recursion

	public static int coinChange(int n, int[] coins, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return 1;
		}
		
		if (n < 0) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < coins.length; i++) {
			count += coinChange(n - coins[i], coins, ans + coins[i] + " ");
		}

		return count;

	}

	// Longest Common Substring

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans += LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);

			ans = Math.max(o1, o2);
		}

		return ans;

	}

	// LCS using DP

	public static int LCSBU(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i + 1][j]);
				}
			}
		}
		return strg[0][0];

	}

}
