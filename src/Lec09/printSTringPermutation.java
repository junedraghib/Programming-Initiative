package Lec09;

public class printSTringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printPermutation("abc", "");

		// printPermutationLexicographically("aabc", "");
		printUniquePermutation("aabc", "");

	}

	public static void printPermutation(String qus, String ans) {
		if (qus.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = qus.charAt(0);
		String roq = qus.substring(1);

		for (int i = 0; i <= ans.length(); i++) {

			printPermutation(roq, ans.substring(0, i) + ch + ans.substring(i));
		}
	}

	public static void printPermutationLexicographically(String qus, String ans) {
		if (qus.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < qus.length(); i++) {
			char ch = qus.charAt(i);
			String roq = qus.substring(0, i) + qus.substring(i + 1);

			printPermutationLexicographically(roq, ans + ch);
		}
	}

	public static void printUniquePermutation(String qus, String ans) {
		if (qus.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < qus.length(); i++) {
			char ch = qus.charAt(i);
			String roq = qus.substring(0, i) + qus.substring(i + 1);

			if (!isDuplicate(qus, i)) {
				printUniquePermutation(roq, ans + ch);
			} else {
				continue;
			}

		}

	}

	// return true if ith character present before ith position else return false
	public static boolean isDuplicate(String s, int i) {
		for (int j = i - 1; j >= 0; j--) {
			if (s.charAt(j) == s.charAt(i)) {
				return true;
			}

		}
		return false;
	}

	public static boolean isDuplicate(boolean[] visited, char ch) {
		if (visited[ch]) {
			return true;
		}

		return false;
	}

}
