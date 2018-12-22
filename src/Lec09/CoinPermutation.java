package Lec09;

public class CoinPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printCoinPermutation(3, "");
		printNoTwoConsecutiveHeadcoinToss(3, "", true);
	}

	public static void printCoinPermutation(int numToss, String ans) {
		if (numToss == 0) {
			System.out.println(ans);
			return;
		}

		printCoinPermutation(numToss - 1, ans + "H");
		printCoinPermutation(numToss - 1, ans + "T");
	}

	public static void printNoTwoConsecutiveHeadcoinToss(int numToss, String ans, boolean wasLastHead) {
		if (numToss == 0) {
			System.out.println(ans);
			return;
		}

		if (wasLastHead) {
			printNoTwoConsecutiveHeadcoinToss(numToss - 1, ans + "T", false);
		} else {
			printNoTwoConsecutiveHeadcoinToss(numToss - 1, ans + "T", false);
			printNoTwoConsecutiveHeadcoinToss(numToss - 1, ans + "H", true);
		}
	}

}
