package Lec10;

/**
 * created by : Juned Raghib created on : 25-Dec-2018
 */
public class NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nqueen(new boolean[4][4], 0, "");

	}

	public static void nqueen(boolean[][] board, int row, String ans) {
		if (row == board[0].length) {
			System.out.println(ans);
			return;
		}

		int col = 0;
		for (; col < board[0].length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				nqueen(board, row + 1, ans + "{" + row + "," + col + "}");
				board[row][col] = false;
			}
		}
	}

	public static boolean isSafe(boolean[][] board, int row, int col) {
		// vertically up
		int r = row - 1;
		int c = col;
		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}

			r--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
		if (board[r][c]) {
			return false;
		}

			r--;
			c--;
		}
		
		return true;
	}

}
