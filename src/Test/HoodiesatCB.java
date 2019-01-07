package Test;

import java.util.Scanner;
import Lec13.Queue;
import Lec13.Stack;
import Lec14.QueueReverse;
import Lec15.DynamicQueue;
import Lec15.DynamicStack;

/**
 * created by : Juned Raghib created on : 02-Jan-2019
 */
public class HoodiesatCB {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int q = scn.nextInt();
		hoodies(q);

	}

	public static void hoodies(int q) throws Exception {

		Queue course = new Queue(q);
		Queue rollno = new Queue(q);
//		course.enqueue(1);
//		rollno.enqueue(1);
//		course.enqueue(3);
//		rollno.enqueue(1);
//		course.enqueue(1);
//		rollno.enqueue(3);
//		course.enqueue(2);
//		rollno.enqueue(2);
//		course.enqueue(3);
//		rollno.enqueue(2);
//		course.enqueue(1);
//		rollno.enqueue(4);
//		course.enqueue(2);
//		rollno.enqueue(5);
//		course.enqueue(3);
//		rollno.enqueue(3);

		while (q > 0) {
			char op = scn.next().charAt(0);
			if (op == 'E') {
				int x = scn.nextInt();
				int y = scn.nextInt();

				if (course.isEmpty() && rollno.isEmpty()) {
					course.enqueue(x);
					rollno.enqueue(y);
				} else {
					oppE(course, rollno, x, y);
				}

			} else if (op == 'D') {
				System.out.println(course.dequeue() + " " + rollno.dequeue());
			}

			q--;
		}

	}

	public static void oppE(Queue course, Queue rollno, int c, int r) throws Exception {

//		System.out.println();
//		course.display();
//		System.out.println();
//		rollno.display();
		

		boolean flag = false;

		java.util.Stack<Integer> coursestack = new java.util.Stack<>();
		java.util.Stack<Integer> rollnostack = new java.util.Stack<>();
		
		while (!course.isEmpty() && !rollno.isEmpty()) {

			int curcou = course.getFront();
			int currol = rollno.getFront();

			if (c == curcou && !flag) {
				coursestack.push(c);
				rollnostack.push(r);
				flag = true;
			}

			coursestack.push(curcou);
			rollnostack.push(currol);
		}coursestack.push(curcou);
		rollnostack.push(currol);
		coursestack.push(c);
		rollnostack.push(r);

		while (!coursestack.isEmpty() && !rollnostack.isEmpty()) {
			course.enqueue(coursestack.pop());
			rollno.enqueue(rollnostack.pop());
		}
		
		QueueReverse.queueActualReverese(course);
		QueueReverse.queueActualReverese(rollno);
		
	}

}


//18
//E 1 1
//E 3 1 
//E 1 3
//E 2 2 
//E 3 2 
//E 1 4
//E 2 5
//E 3 3
//E 1 5
//D
//D
//D
//D
//D
//D
//D
//D
//D

