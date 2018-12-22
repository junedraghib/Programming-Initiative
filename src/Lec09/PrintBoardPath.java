package Lec09;

import Lec08.BoardPath;

public class PrintBoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBoardPath(4, "");
		System.out.println(BoardPath.getBoardPath(0, 4));
	}

	public static void printBoardPath(int end, String ans) {
		if (end == 0) {
			System.out.println(ans);
			return;
		}

		for (int dice = 1; dice <= 6 && end - dice >= 0; dice++) {
			printBoardPath(end - dice, ans + dice);
		}
	}

}
