package Lec15;

import Lec13.Queue;

/**
 * created by : Juned Raghib
 * created on : 02-Jan-2019
 */
public class DynamicQueue extends Queue{
	@Override
	public void enqueue(int item) throws Exception
	{
		int[] na = new int[2*this.arr.length];
		int[] oa = this.arr;
		if (isFull()) {
			
			for (int i = 0; i < this.arr.length; i++) {
				int idx = (i + this.front) % oa.length;
				na[i] = oa[idx];
//				this.dequeue();
			}
			
			this.front = 0;
			this.arr = na;
		}
		
		super.enqueue(item);
	}
}
