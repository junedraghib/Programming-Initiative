package Lec15;

import Lec13.Stack;

/**
 * created by : Juned Raghib
 * created on : 02-Jan-2019
 */
public class DynamicStack extends Stack{

	public static void main(String[] args) {
		

	}
	
	@Override
	public void push(int val) throws Exception
	{
		if (this.isFull()) {
			int[] oa = this.arr; 
			int[] na = new int[2*this.arr.length];
			
			for(int i = 0; i < oa.length; i++ )
			{
				na[i] = oa[i];
			}
			
			this.arr = na;
			
		}
		
		super.push(val);
	}

}
