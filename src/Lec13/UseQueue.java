package Lec13;

/**
 * created by : Juned Raghib
 * created on : 29-Dec-2018
 */
public class UseQueue {

	public static void main(String[] args) throws Exception {
		
		Queue queue = new Queue();
		//queue.dequeue();
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println();
		queue.display();
		System.out.println();
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		System.out.println();
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(60);
		queue.enqueue(70);
		System.out.println();
		queue.display();
	}

}
