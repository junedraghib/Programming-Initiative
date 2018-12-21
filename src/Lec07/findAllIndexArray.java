package Lec07;

public class findAllIndexArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 80, 60, 120, 80 };
		int[] ans = findAll(arr, 0, 80, 0);
		for(int var : ans)
		{
			System.out.println(var);
		}
	}
	public static int[] findAll(int[] arr, int vidx, int item, int count)
	{
		if (vidx == arr.length) {
			int[] baseRes = new int[count];
			return baseRes;
		}
		if (item == arr[vidx]) {
			int[] recRes = findAll(arr, vidx + 1, item, count + 1);
			recRes[count] = vidx;
			return recRes;
		} else {
			int[] recRes = findAll(arr, vidx + 1, item, count);
			//recRes[count] = vidx;
			return recRes;
		}
		
	}

}
