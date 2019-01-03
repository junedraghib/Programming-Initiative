package Lec15.LinkList;

/**
 * created by : Juned Raghib created on : 02-Jan-2019
 */
public class LinkList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty!!");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty!!");
		}

		return this.tail.data;
	}

	public int getAtIndex(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index!!");
		}

		Node temp = this.head;

		int i = 0;
		while (i < index) {
			temp = temp.next;
			i++;
//			this.size++;
		}

		return temp.data;
	}

	public void display() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty!!");
		}

		Node temp = this.head;
		System.out.println("------------");

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("------------");
	}

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

	public void addAtFirst(int data) throws Exception {

		Node nn = new Node();
		nn.data = data;
		nn.next = null;

		if (this.size == 0) {
			this.tail = nn;
		} else {
			nn.next = this.head;
		}

		this.head = nn;
		this.size++;

	}

	public Node getNodeAtIndex(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index!!");
		}

		Node temp = this.head;

		int i = 0;
		while (i < index) {
			temp = temp.next;
			i++;
//			this.size++;
		}

		return temp;
	}

	public void addAtIndex(int index, int data) throws Exception {
		if (index == 0) {
			addAtFirst(data);
		} else if (index == this.size) {
			addAtLast(data);
		} else {
			Node nn = new Node();
			nn.data = data;
			nn.next = null;

			Node n = getNodeAtIndex(index);
			Node nm1 = getNodeAtIndex(index - 1);

			nm1.next = nn;
			nn.next = n;
			
			size++ ;
		}
	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		} else if (this.size == 1) {
			int rv = this.head.data;

			this.head = null;
			this.tail = null;
			this.size--;
			return rv;
		} else {

			int rv = this.head.data;

			this.head = this.head.next;
			this.size--;
			return rv;
		}
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		} else if (this.size == 1) {
			int rv = this.tail.data;

			this.head = null;
			this.tail = null;
			this.size--;
			return rv;
		} else {
			int rv = this.tail.data;

			Node n = getNodeAtIndex(this.size - 2);
			n.next = null;
			this.tail = n;

			this.size--;
			return rv;
		}
	}

	public int removeAt(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		} else if (index == 0) {
			return removeFirst();
		} else if (index == this.size - 1) {
			return removeLast();
		} else {
			Node n = getNodeAtIndex(index);
			int rv = n.data;
			Node nm1 = getNodeAtIndex(index - 1);
			nm1.next = n.next;
			this.size--;
			return rv;
		}
	}

}
