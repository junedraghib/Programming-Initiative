package Lec13;

/**
 * created by : Juned Raghib created on : 29-Dec-2018
 */
public class Stack {
	// stack properties

	protected int tos;
	protected int[] arr;

	// default constructor
	public Stack() {
		this.tos = -1;
		this.arr = new int[5];
	}

	public Stack(int cap) {
		this.tos = -1;
		this.arr = new int[cap];
	}

	public int size() {
		return tos + 1; // size of the stack
	}

	public boolean isEmpty() {
		return tos == -1 || this.size() == 0;
	}

	public boolean isFull() {
		return this.size() == this.arr.length;
	}

	public void push(int val) throws Exception {
		if (this.isFull()) {
			throw new Exception("Stack is Full");

		}

		this.tos++;
		this.arr[tos] = val;

	}

	public int pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");

		} else {
			int rv = this.arr[this.tos];
			this.tos--;
			return rv;
		}

	}

	public int peek() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");

		} else {
			int rv = this.arr[this.tos];
			return rv;
		}

	}

	public void display() throws Exception {
		int i = this.tos;
		while (i >= 0) {
			System.out.println(this.arr[i]);
			i--;
		}
	}

}
