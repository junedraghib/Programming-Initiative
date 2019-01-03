package Lec15;

import Lec13.Stack;

/**
 * created by : Juned Raghib created on : 02-Jan-2019
 */
public class DSClient {

	public static void main(String[] args) throws Exception {
		Stack ds = new DynamicStack();
		
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);
		ds.push(60);
		ds.push(70);
		ds.push(80);
		ds.push(90);
		
		ds.display();

	}

}
