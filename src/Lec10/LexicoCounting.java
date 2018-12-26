package Lec10;

/**
 * created by : Juned Raghib created on : 25-Dec-2018
 */
public class LexicoCounting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printLexicoCounting(0, 1000);

	}

	public static void printLexicoCounting(int cur, int end) {

		if (cur > end) {
			return;
		}

		System.out.println(cur);
		int i = 0;

		if (cur == 0) {
			i = 1;
		}

		for (; i <= 9; i++) {
			printLexicoCounting(cur * 10 + i, end);
		}
	}

}
