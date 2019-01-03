package Lec15;

import Lec15.Adapter.QueueUsingStack;

/**
 * created by : Juned Raghib created on : 02-Jan-2019
 */
public class QusingSClient {

	public static void main(String[] args) throws Exception {

		QueueUsingStack qs = new QueueUsingStack();

		qs.enqueue(10);
		qs.enqueue(20);
		qs.enqueue(30);
		qs.enqueue(40);
		qs.enqueue(50);
		qs.enqueue(60);
		qs.enqueue(70);
		qs.enqueue(80);
		qs.display();

	}

}
