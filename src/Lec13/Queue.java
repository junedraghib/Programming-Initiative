package Lec13;

/**
 * created by : Juned Raghib created on : 29-Dec-2018
 */
public class Queue {

	protected int front;
	protected int size;
	protected int[] arr;

	public Queue() {
		this.arr = new int[5];
		this.size = 0;
		this.front = 0;
	}

	public Queue(int cap) {
		this.arr = new int[cap];
		this.size = 0;
		this.front = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.arr.length;
	}

	public void enqueue(int item) throws Exception {
		if (this.isFull()) {
			throw new Exception("Queue is Full");
		}
		this.arr[(this.front + this.size) % this.arr.length] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rv = this.arr[this.front];
		this.arr[this.front] = 0;
		this.size--;
		this.front = (this.front + 1) % this.arr.length;
		return rv;
	}

	public int getFront() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Queue is Full");
		}

		return this.arr[(this.front) % this.arr.length];
	}

	public void display() {
		
//		System.out.print("+");
		for (int i = 0; i < this.arr.length; i++) {
			if (i == this.front + this.size - 1) {
				System.out.print("-r-");
				
			}
			else {
				System.out.print("---");
			}
		}
//		System.out.print("+");
		System.out.println();
		
		for (int i = 0; i < this.arr.length; i++) {
			int rear = (i + this.front) % this.arr.length;
			System.out.print(this.arr[rear] + " ");
		}
		
//		System.out.print("+");
		System.out.println();
		for (int i = 0; i < this.arr.length; i++) {
			if (i == this.front) {
				System.out.print("f--");
				
			}
			else {
				System.out.print("---");
			}
		}
		System.out.println();
//		System.out.print("+");
	}

}
