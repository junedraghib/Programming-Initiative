package Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * created by : Juned Raghib created on : 08-Jan-2019
 */
public class isBalanced {

	public static void main(String args[]) {
//		Scanner s = new Scanner(System.in);
//		int t = s.nextInt();
//		while (t > 0) {
//			String str = s.next();
//			char ch = str.charAt(0);
//			int count = 0;
//			if (ch == '(' || ch == ')') {
//				count = 1;
//			}
//			
//			
//			Stack<Character> stackb = new Stack<>();
//			Stack<Character> stack = new Stack<>();
//
////            if (isBalanced(str, stackb)) {
////            	maxdepth(str.substring(1), count, Integer.MIN_VALUE, ch, stack);
////			}
////            else
////            	System.out.println("-1");
//
//			maxdepth(str);
//
//			t--;
//		}
		
	}

	public static boolean isbalanced(String str, String open, String close) {

		if (str.length() == 0) {
			System.out.println(open + " " + close);

			if (open.compareTo(close) == 0) {
				return true;
			} else {
				return false;
			}
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		if (ch == '[' || ch == '(' || ch == '{') {
			return isbalanced(ros, open + ch, close);
		} else if (ch == ']' || ch == ')' || ch == '}') {
			return isbalanced(ros, open, getMatched(ch) + close);
		}

		return isbalanced(ros, open, close);
	}

	public static boolean isBalanced(String str, Stack<Character> stack) {

		if (str.length() == 0) {
			if (stack.empty()) {
				return true;
			} else {
				return false;
			}
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		if (ch == '[' || ch == '(' || ch == '{') {
			stack.push(ch);
			boolean rr = isBalanced(ros, stack);
			return rr;
		} else if (ch == ']' || ch == ')' || ch == '}') {
			char chh = stack.pop();
			if (chh == getMatched(ch)) {
				boolean rr = isBalanced(ros, stack);
				return rr;
			} else
				return false;
		} else {
			boolean rr = isBalanced(ros, stack);
			return rr;
		}
	}

	public static char getMatched(char ch) {
		if (ch == ']') {
			return '[';
		} else if (ch == '}') {
			return '{';
		} else {
			return '(';
		}

	}

	public static void maxdepth(String str) {

		int i = 0;
		int count = 0;
		int max = Integer.MIN_VALUE;
		while (i < str.length()) {

			char ch = str.charAt(i);

			if (ch == '(') {
				count++;
				if (count > max) {
					max = count;
				}
			} else if (ch == ')') {
				if (count > 0) {
					count--;
				} else {
					System.out.println("-1");
					return;
				}
			}
			i++;
		}

		if (count == 0) {
			System.out.println(max);
		} else
			System.out.println("-1");

	}

	public static ArrayList<String> sort(ArrayList<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).compareTo(list.get(min)) < 0) {
					min = j;
				}
			}

			String temp = list.get(min);
			list.set(min, list.get(i));
			list.set(i, temp);
		}

		return list;
	}

}
