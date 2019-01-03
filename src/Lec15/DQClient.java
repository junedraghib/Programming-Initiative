package Lec15;

/**
 * created by : Juned Raghib created on : 02-Jan-2019
 */
public class DQClient {

	public static void main(String[] args) throws Exception {
		DynamicQueue dq = new DynamicQueue();
		
		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		dq.enqueue(60);
		dq.enqueue(70);
		dq.enqueue(80);
		dq.enqueue(90);
		dq.enqueue(100);
		dq.enqueue(110);
		
		dq.display();

	}

}
