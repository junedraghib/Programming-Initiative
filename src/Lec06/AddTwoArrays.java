package Lec06;

import java.util.ArrayList;

public class AddTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = {9, 9, 9, 9};
		int[] two = {9, 9, 9, 9};
		
		System.out.print(addArrays(one, two));
	}
	public static ArrayList<Integer> addArrays(int[] one, int[] two)
	{
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		int i = one.length -1;
		int j = two.length -1;
		
		int carry = 0;
		
		while (i >= 0 || j >= 0)
		{
			int sum = carry;
			if(i >= 0)
			{
				sum += one[i];
			}
			if(j >= 0)
			{
				sum += two[j];
			}
			
			int rem = sum % 10;
			ans.add(0, rem);
			carry = sum / 10;
			
			i--;
			j--;
		}
		ans.add(0, carry);
		return ans;
	}
	
	

}
