package Lec21;

public class GenericPrograming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
//	public static <T> T[] mergeSort(T[] arr, int low, int high) {
//		if (low == high) {
//			T[] br = new T[1];
//			br[0] = arr[low];
//			return br;
//		}
//
//		int mid = (low + high) / 2;
//		T[] fh = mergeSort(arr, low, mid);
//		T[] sf = mergeSort(arr, mid + 1, high);
//
//		T[] ans = mergeTwoSortedArray(fh, sf);
//
//		return ans;
//	}
//
//	public static <T> T[] mergeTwoSortedArray(T[] arr1, T[] arr2) {
//		int i = 0, j = 0, k = 0;
//		T[] merged = new T[arr1.length + arr2.length];
//		while (i < arr1.length && j < arr2.length) {
//			if (arr1[i] < arr2[j]) {
//				merged[k] = arr1[i];
//				i++;
//				k++;
//			} else {
//				merged[k] = arr2[j];
//				j++;
//				k++;
//			}
//		}
//
//		if (i == arr1.length) {
//			while (j < arr2.length) {
//				merged[k] = arr2[j];
//				j++;
//				k++;
//			}
//		}
//
//		if (j == arr2.length) {
//			while (i < arr1.length) {
//				merged[k] = arr1[i];
//				i++;
//				k++;
//			}
//		}
//
//		return merged;
//	}

}
