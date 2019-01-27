package Lec22;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMapDemo hmd = new HashMapDemo();
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		hmd.maxconsecutivesequence(arr);
	}

	public char maxFreq(String str) {
		HashMap<Character, Integer> map = new HashMap<>();

		int i = 0;
		while (i < str.length()) {
			Character ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}

			i++;
		}

		int maxfreq = 0;
		Character maxchar = '\0';
		for (Character key : map.keySet()) {
			if (map.get(key) > maxfreq) {
				maxfreq = map.get(key);
				maxchar = key;
			}
		}

		return maxchar;
	}

	public void maxconsecutivesequence(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i], false);
			} else {
				map.put(arr[i], true);
			}

			if (map.containsKey(arr[i] + 1)) {
				if (map.get(arr[i])) {
					map.put(arr[i] + 1, false);
				}
			}
		}

		int maxlength = 0;
		int start = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key)) {

				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (maxlength < count) {
					maxlength = count;
					start = key;
				}
			}
		}

		int i = 0;
		while (i < maxlength) {
			System.out.print(start + " ");
			start++;
			i++;
		}

	}
}
