package Test;

import java.util.Scanner;

import Lec13.Queue;

public class HoodiesCB {

	public static void main(String[] args) throws Exception {
		int n = scn.nextInt();

		hoodies(n);

	}

	static Scanner scn = new Scanner(System.in);

	public static void hoodies(int q) throws Exception {
		Queue pqueue = new Queue(100000);
		Queue c1 = new Queue(50000);
		Queue c2 = new Queue(50000);
		Queue c3 = new Queue(50000);
		Queue c4 = new Queue(50000);
		// Scanner s = new Scanner(System.in);
		while (q > 0) {
			char ch = scn.next().charAt(0);
			if (ch == 'E') {
				int x = scn.nextInt();
				int y = scn.nextInt();
				if (x == 1) {
					c1.enqueue(y);
				} else if (x == 2) {
					c2.enqueue(y);
				} else if (x == 3) {
					c3.enqueue(y);
				} else {
					c4.enqueue(y);
				}

				pqueue.enqueue(x);

			} else if (ch == 'D') {
				int front = pqueue.dequeue();
				if (front == 1) {
					System.out.println(c1.dequeue() + " " + front);
				} else if (front == 2) {
					System.out.println(c2.dequeue() + " " + front);
				} else if (front == 3) {
					System.out.println(c3.dequeue() + " " + front);
				} else if (front == 4) {
					System.out.println(c4.dequeue() + " " + front);
				}
			}
			q--;
		}
	}
}
