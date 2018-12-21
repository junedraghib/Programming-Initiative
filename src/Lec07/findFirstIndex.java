package Lec07;

public class findFirstIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 80, 60, 120, 80};
		System.out.println(findFirst(arr, 0, 80));

	}
	
	public static int findFirst(int[] arr, int vidx, int item)
	{
		int result;
		if (vidx == arr.length) {
			return -1;
		}
		if(item == arr[vidx])
		{
			result = vidx;
			return result;
		}
		result = findFirst(arr, vidx + 1, item);
		return result;
	}

}
