package Lec10;

/**
 * created by : Juned Raghib created on : 25-Dec-2018
 */
public class WildCardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wildCardMatching("abbagdhc", "a?b*c"));

	}

	public static boolean wildCardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		} else if (src.length() != 0 && pattern.length() == 0) {
			return false;
		} else if (src.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		char srcch = src.charAt(0);
		char patch = pattern.charAt(0);

		String srcros = src.substring(1);
		String patros = pattern.substring(1);

		boolean rr;
		if (srcch == patch || patch == '?') {
			rr = wildCardMatching(srcros, patros);
		} else if (patch == '*') {
			rr = wildCardMatching(srcros, pattern) || wildCardMatching(src, patros);
		} 
		else {
			return false;
		}

		return rr;

	}

}
