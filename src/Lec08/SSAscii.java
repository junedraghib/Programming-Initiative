package Lec08;

import java.util.ArrayList;

public class SSAscii {

	public static void main(String[] args) {

		// String str = " ";
		// System.out.println(str.length());
		//
		// ArrayList<String> list = new ArrayList<>();
		// System.out.println(list.size());
		//
		// list.add(str);
		// System.out.println(list.size());

		System.out.println(getSS("ab"));
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {

			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recRes = getSS(ros);

		ArrayList<String> myRes = new ArrayList<>();

		for (String val : recRes) {
			myRes.add(val);
			myRes.add(ch + val);
			myRes.add((int)ch + val);
		}

		return myRes;

	}

}
