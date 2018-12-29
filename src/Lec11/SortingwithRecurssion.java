package Lec11;

/**
 * created by : Juned Raghib created on : 26-Dec-2018
 */
public class SortingwithRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 10, 30, 25, 5, 56, -21 };
		// display(mergeSort(arr, 0, arr.length - 1));
		display(arr);
		quicksort(arr, 0, arr.length - 1);
		System.out.println();
		display(arr);

	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			int[] br = new int[1];
			br[0] = arr[low];
			return br;
		}

		int mid = (low + high) / 2;
		int[] fh = mergeSort(arr, low, mid);
		int[] sf = mergeSort(arr, mid + 1, high);

		int[] ans = mergeTwoSortedArray(fh, sf);

		return ans;
	}

	public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
		int i = 0, j = 0, k = 0;
		int[] merged = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				merged[k] = arr1[i];
				i++;
				k++;
			} else {
				merged[k] = arr2[j];
				j++;
				k++;
			}
		}

		if (i == arr1.length) {
			while (j < arr2.length) {
				merged[k] = arr2[j];
				j++;
				k++;
			}
		}

		if (j == arr2.length) {
			while (i < arr1.length) {
				merged[k] = arr1[i];
				i++;
				k++;
			}
		}

		return merged;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	// quick sort

	public static void quicksort(int[] arr, int low, int high) {
		int left = low;
		int right = high;

		if (left >= right) {
			return;
		}

		int mid = (low + high) / 2;
		int pivot = arr[mid]; // Pivot can be any element

		// partitioning in quick sort

		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
				right--;
			}

		}

		quicksort(arr, low, right);
		quicksort(arr, left, high);

	}

}
