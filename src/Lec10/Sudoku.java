package Lec10;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 25-Dec-2018
 */
public class Sudoku {
	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		System.out.println();
		display(arr);

		// calling from main
		sudokuSolver(arr, 0);

//		solveSudoku(arr, arr.length);

		System.out.println();
		display(arr);
	}

	public static void sudokuSolver(int[][] arr, int row) {
		if (row == arr[0].length) {

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					if (sudoku[i][j] == 0) {
						sudoku[i][j] = arr[i][j];
					}
				}
			}

			return;
		}

		for (int col = 0; col < arr[0].length; col++) {
			if (arr[row][col] == 0) {

				for (int value = 1; value <= 9; value++) {

					if (safe(arr, row, col, value)) {
						arr[row][col] = value;
						sudokuSolver(arr, row + 1);
						arr[row][col] = 0;
					}
				}
			}
		}

	}

	public static boolean solveSudoku(int[][] board, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}
		if (isEmpty) {
			return true;
		}

		for (int num = 1; num <= n; num++) {
			if (safe(board, row, col, num)) {
				board[row][col] = num;
				if (solveSudoku(board, n)) {

					return true;
				} else {
					board[row][col] = 0; 
				}
			}
		}
		return false;
	}

	private static boolean safe(int[][] arr, int row, int col, int value) {

		// within the row
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[row][i] == value) {
//				System.out.println("within row");
				return false;
			}
		}

		// within the column
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[i][col] == value) {
//				System.out.println("within col");
				return false;
			}
		}

		// within its inner box
		int boxrowstart = row / 3;
		int boxcolstart = col / 3;

		for (int i = boxrowstart * 3; i < (boxrowstart + 1) * 3; i++) {
			for (int j = boxcolstart * 3; j < (boxcolstart + 1) * 3; j++) {
				if (arr[i][j] == value) {
//					System.out.println("within box");
					return false;
				}
			}
		}

		return true;
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
