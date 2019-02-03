package Test;

import java.util.Scanner;

public class TripletLLTarget {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();

		LinkList l1 = new LinkList();
		LinkList l2 = new LinkList();
		LinkList l3 = new LinkList();

		while (n > 0) {
			l1.addAtLast(s.nextInt());
			n--;
		}

		while (m > 0) {
			l2.addAtLast(s.nextInt());
			m--;
		}

		while (k > 0) {
			l3.addAtLast(s.nextInt());
			k--;
		}

		int target = s.nextInt();
//		l1.display();
//		l2.display();
//		l3.display();
//		System.out.println(target);
		l1.getTriplet(l2, l3, target);
	}
}

class LinkList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public void addAtLast(int data) throws Exception {

		Node nn = new Node();
		nn.data = data;
		nn.next = null;

		if (this.size == 0) {
			this.head = nn;
		} else {
			this.tail.next = nn;
		}

		this.tail = nn;
		this.size++;

	}

	public void display() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty!!");
		}

		Node temp = this.head;
		System.out.println("------------------------------");

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("------------------------------");
	}

	public void getTriplet(LinkList l2, LinkList l3, int target) {
		Node ptr2 = l2.head;
		Node ptr3 = l3.head;

//		this.getTriplet(ptr2, ptr3, target, ans);
		this.getTripletI(ptr2, ptr3, target);
	}

	private void getTripletI(Node ptr22, Node ptr33, int target) {
		Node ptr1 = this.head;
		while (ptr1 != null) {
			Node ptr2 = ptr22;
			while (ptr2 != null) {
				Node ptr3 = ptr33;
				while (ptr3 != null) {
					int sum = ptr1.data + ptr2.data + ptr3.data;
//					System.out.println(sum);
					if (sum == target) {
						System.out.println(ptr1.data + " " + ptr2.data + " " + ptr3.data);
					}

					ptr3 = ptr3.next;
				}

				ptr2 = ptr2.next;
			}

			ptr1 = ptr1.next;
		}

	}
}