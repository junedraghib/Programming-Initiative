package Lec14;

import Lec13.Queue;

/**
 * created by : Juned Raghib created on : 01-Jan-2019
 */
public class QueueReverse {

	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
//		queueActualReverese(queue);
		System.out.println();
		queueRevereseDisplay(queue, 0);
		System.out.println();
		queue.display();
	}

	public static void queueActualReverese(Queue q) throws Exception {
		if (q.isEmpty()) {
			return;
		}

		int cur = q.dequeue();
		queueActualReverese(q);
		q.enqueue(cur);

	}

	public static void queueRevereseDisplay(Queue q, int count) throws Exception {
		if (count == q.size()) {
			return;
		}

		int cur = q.dequeue();
		q.enqueue(cur);
		count++;
		queueRevereseDisplay(q, count);
		System.out.print(cur + " ");

	}

}
