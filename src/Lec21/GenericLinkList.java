package Lec21;

public class GenericLinkList <T>{
	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty!!");
		}

		return this.head.data;
	}

	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty!!");
		}

		return this.tail.data;
	}

	public T getAtIndex(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index!!");
		}

		Node temp = this.head;

		int i = 0;
		while (i < index) {
			temp = temp.next;
			i++;
		}

		return temp.data;
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

	public void addAtLast(T data) throws Exception {

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

	public void addAtFirst(T data) throws Exception {

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

	public Node getNodeAtIndex(int j) throws Exception {
		if (j < 0 || j >= this.size) {
			throw new Exception("Invalid Index!!");
		}

		Node temp = this.head;

		int i = 0;
		while (i < j) {
			temp = temp.next;
			i++;
		}

		return temp;
	}

	public void addAtIndex(int index, T data) throws Exception {
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

			size++;
		}
	}

	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		} else if (this.size == 1) {
			T rv = this.head.data;

			this.head = null;
			this.tail = null;
			this.size--;
			return rv;
		} else {

			T rv = this.head.data;

			this.head = this.head.next;
			this.size--;
			return rv;
		}
	}

	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		} else if (this.size == 1) {
			T rv = this.tail.data;

			this.head = null;
			this.tail = null;
			this.size--;
			return rv;
		} else {
			T rv = this.tail.data;

			Node n = getNodeAtIndex(this.size - 2);
			n.next = null;
			this.tail = n;

			this.size--;
			return rv;
		}
	}

	public T removeAtIndex(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		} else if (index == 0) {
			return removeFirst();
		} else if (index == this.size - 1) {
			return removeLast();
		} else {
			Node n = getNodeAtIndex(index);
			T rv = n.data;
			Node nm1 = getNodeAtIndex(index - 1);
			nm1.next = n.next;
			this.size--;
			return rv;
		}
	}
}
