package Lec06;

import java.util.ArrayList;

public class IntersectionofArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = { 10, 10, 20, 20, 25, 35, 60, 70, 70 };
		int[] two = { 10, 20, 20, 20, 30, 35, 40, 70, 70, 80 };
//		System.out.print(intersection_twoloop(one, two));
//		System.out.println();
		System.out.print(intersection_oneloop(one, two));

	}

	public static ArrayList<Integer> intersection_twoloop(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < two.length; j++) {
				if (one[i] == two[j]) {
					ans.add(two[j]);
					two[j] = 0;
					one[i] = -1;
					break; // to save next iterations
				}
			}
		}
		return ans;

	}

	public static ArrayList<Integer> intersection_oneloop(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		System.out.println(one.length);
		for (int i = 0, j = 0; i <= one.length - 1 && j <= two.length - 1;) {
			
			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {
				ans.add(one[i]);
				System.out.println("hhhh");
				i++;
				j++;
			}
		}

		return ans;

	}

}
