package Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 09-Jan-2019
 */
public class RecurssionCode {
	static ArrayList<String> result = new ArrayList<>();

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.next();
		gen(str, "");
		System.out.println(result);
		System.out.println(recurssionCode(str));

	}

	public static ArrayList<String> recurssionCode(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

//		if (str.length() == 1) {
//			ArrayList<String> br = new ArrayList<>();
//			char chw = getcode(Integer.parseInt(str.substring(0)));
//			if (Character.isAlphabetic(chw)) {
//				br.add("" + chw);
//			}
//			
//			return br;
//		}

		ArrayList<String> rr1 = recurssionCode(str.substring(1));
		ArrayList<String> rr2 = new ArrayList<>();
		if (str.length() > 1) {
			rr2 = recurssionCode(str.substring(2));
		}

		ArrayList<String> result = new ArrayList<>();

		for (String val : rr1) {
			int i = 0;
			boolean flag = true;
			while (i < val.length()) {
				if (!Character.isAlphabetic(val.charAt(i))) {
					flag = false;
					break;
				}
				i++;
			}

			if (flag) {
				result.add(getcode(Integer.parseInt(str.substring(0, 1))) + val);
			}

			
		}

		for (String val : rr2) {
			int i = 0;
			boolean flag = true;
			while (i < val.length()) {
				if (!Character.isAlphabetic(val.charAt(i))) {
					flag = false;
					break;
				}
				i++;
			}

			if (flag) {
				result.add(getcode(Integer.parseInt(str.substring(0, 2))) + val);
			}
		}

		return result;

	}

	private static char getcode(int value) {

		return (char) (value + 'a' - 1);
	}

	static void gen(String s, String perm) {
		if (s.isEmpty()) {
			int i = 0;
			boolean flag = true;
			while (i < perm.length()) {
				if (!Character.isAlphabetic(perm.charAt(i))) {
					flag = false;
					break;
				}
				i++;
			}

			if (flag) {
				result.add(perm);
			}
			return;
		}
		gen(s.substring(1), perm + code(Integer.parseInt(s.substring(0, 1))));
		if (s.length() > 1) {
			gen(s.substring(2), perm + code(Integer.parseInt(s.substring(0, 2))));
		}

	}

	static char code(int num) {
		return (char) ('a' + num - 1);
	}

}
