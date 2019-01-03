package Lec15.Adapter;

import Lec13.ReverseStack;
import Lec13.Stack;
import Lec15.DynamicStack;

/**
 * created by : Juned Raghib
 * created on : 02-Jan-2019
 */
public class QueueUsingStack {

	Stack ds = new DynamicStack();
	
	public void enqueue(int item) throws Exception
	{
		DynamicStack temp = new DynamicStack();
		
		while(!ds.isEmpty())
		{
			try {
				temp.push(ds.pop());
			} catch (Exception e) {
				throw new Exception("Queue is Full!!");
			}
		}
		
		ds.push(item);
		
		while(!temp.isEmpty())
		{
			try {
				ds.push(temp.pop());
			} catch (Exception e) {
				throw new Exception("Queue is Full!!");
			}
		}
	}
	
	public int dequeue() throws Exception
	{
		int rv = 0;
		try {
			rv = ds.pop();
		} catch (Exception e) {
			throw new Exception("Queue is Empty!!");
		}
		return rv;
	}
	
	public int getFront() throws Exception
	{
		int rv = 0;
		try {
			rv = ds.peek();
		} catch (Exception e) {
			throw new Exception("Queue is Empty!!");
		}
		return rv;
	}
	
	public void display() throws Exception
	{
		ds.display();
	}

}
