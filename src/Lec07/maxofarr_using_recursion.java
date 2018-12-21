package Lec07;

public class maxofarr_using_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 80, 60, 120, 80};
		System.out.println(maxofarr(arr, 0));

	}
	
	public static int maxofarr(int[] arr, int vidx)
	{
		if (vidx == arr.length)
		{
			return Integer.MIN_VALUE;
		}
		int max = arr[vidx];
		int result = maxofarr(arr, vidx + 1);
		if (max < result)
		{
			max = result;
		}
		
		return max;
	}

}
