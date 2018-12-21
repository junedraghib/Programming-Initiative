package Lec07;

public class findLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 80, 60, 120, 80 };
		System.out.println(findLast(arr, 0, 80));

	}

	public static int findLast(int[] arr, int vidx, int item) {
		int result;
		if (vidx == arr.length) {
			return -1;
		}
		// so that we have returened the result of the iteam that we have find only for
		// the first time
		result = findLast(arr, vidx + 1, item);
		if (result == -1 && item == arr[vidx]) {
			return vidx;
		}
		return result;
	}

}
