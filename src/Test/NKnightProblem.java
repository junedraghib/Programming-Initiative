package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 10-Jan-2019
 */
public class NKnightProblem {
	static int count = 0;

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean[][] board = new boolean[n][n];

		nknight(n, 0, 0, board, "");
		System.out.println();
		System.out.println(count);
	}

	public static void nknight(int n, int row, int col, boolean[][] board, String ans) {

		if (n == 0) {
			System.out.printf(ans + " ");
			count++;
			return;
		}

		for (int r = row; r < board.length; r++) {
			for (int c = col; c < board[0].length; c++) {
				if (isItSafe(r, c, board)) {
					board[r][c] = true;
					nknight(n - 1, r, c + 1, board, ans + "{" + r + "-" + c + "}");
					board[r][c] = false;
				}
			}
			col = 0;
		}

	}

	public static boolean safe(int row, int col, boolean[][] board) {
		if (board[row][col]) {
			return false;
		} else if (inrange(row + 2, col - 1, board.length)) {
			if (board[row + 2][col - 1]) {
				return false;
			}
		} else if (inrange(row + 2, col + 1, board.length)) {
			if (board[row + 2][col + 1]) {
				return false;
			}
		} else if (inrange(row - 2, col - 1, board.length)) {
			if (board[row - 2][col - 1]) {
				return false;
			}
		} else if (inrange(row - 2, col + 1, board.length)) {
			if (board[row - 2][col + 1]) {
				return false;
			}
		} else if (inrange(row + 1, col - 2, board.length)) {
			if (board[row + 1][col - 2]) {
				return false;
			}
		} else if (inrange(row + 1, col + 2, board.length)) {
			if (board[row + 1][col + 2]) {
				return false;
			}
		} else if (inrange(row - 1, col - 2, board.length)) {
			if (board[row - 1][col - 2]) {
				return false;
			}
		} else if (inrange(row - 1, col + 2, board.length)) {
			if (board[row - 2][col + 1]) {
				return false;
			}
		}

		return true;
	}

	public static boolean inrange(int r, int c, int n) {
		if (r >= 0 && r < n && c >= 0 && c < n) {
			return true;
		} else
			return false;
	}

	public static boolean isItSafe(int r, int c, boolean[][] board) {
		if (board[r][c]) {
			return false;
		} else if (inrange(r + 2, c + 1, board.length)) {
			return !board[r + 2][c + 1];
		} else if (inrange(r + 2, c - 1, board.length)) {
			return !board[r + 2][c - 1];
		} else if (inrange(r + 1, c + 2, board.length)) {
			return !board[r + 1][c + 2];
		} else if (inrange(r - 1, c + 2, board.length)) {
			return !board[r - 1][c + 2];
		} else if (inrange(r - 2, c + 1, board.length)) {
			return !board[r - 2][c + 1];
		} else if (inrange(r - 2, c - 1, board.length)) {
			return !board[r - 2][c - 1];
		} else if (inrange(r + 1, c - 2, board.length)) {
			return !board[r + 1][c - 2];
		} else if (inrange(r - 1, c - 2, board.length)) {
			return !board[r - 1][c - 2];
		} else
			return true;
	}

	public static boolean isSafe(int row, int col, boolean[][] board) {

		if (!board[row][col]) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j]) {
						if (inrange(i + 2, j - 1, board.length)) {
							return i + 2 != row && j - 1 != col;
						} else if (inrange(i - 2, j - 1, board.length)) {
							return i - 2 != row && j - 1 != col;
						} else if (inrange(i + 2, j + 1, board.length)) {
							return i + 2 != row && j + 1 != col;
						} else if (inrange(i - 2, j + 1, board.length)) {
							return i - 2 != row && j + 1 != col;
						} else if (inrange(i + 1, j - 2, board.length)) {
							return i + 1 != row && j - 2 != col;
						} else if (inrange(i - 1, j - 2, board.length)) {
							return i - 1 != row && j - 2 != col;
						} else if (inrange(i + 1, j + 2, board.length)) {
							return i + 1 != row && j + 2 != col;
						} else if (inrange(i - 1, j + 2, board.length)) {
							return i - 1 != row && j + 2 != col;
						} else {
							return false;
						}
					} else {
						return true;
					}
				}
			}
		}

		return false;

	}
}
