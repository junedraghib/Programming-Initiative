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

			size++;
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

	public void reverseDI() throws Exception {
		int left = 0;
		int right = this.size - 1;

		while (left <= right) {
			Node ln = this.getNodeAtIndex(left);
			Node rn = this.getNodeAtIndex(right);

			int temp = rn.data;
			rn.data = ln.data;
			ln.data = temp;

			left++;
			right--;
		}
	}

	public void reversePI() {

		Node prev = this.head;
		Node curr = this.head.next;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;
	}

	private void reversePR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		reversePR(curr, curr.next);
		curr.next = prev;

	}

	public void reversePR() {
		// client wouldn't have access to the head
		reversePR(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	public void reverseDR() {

		reverseDR(this.head, this.head.next, 0);

	}

	private Node reverseDR(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}

		left = reverseDR(left, right.next, count + 1);
		if (count >= this.size / 2) {
			int temp = right.data;
			right.data = left.data;
			left.data = temp;
		}

		return left.next;

	}

	private class HeapMover {
		Node left;
	}

	public void reverseDRheapMover() {
		HeapMover mover = new HeapMover();
		mover.left = this.head;
		reverseDRHeapMover(mover, this.head.next, 0);
	}

	private void reverseDRHeapMover(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}

		reverseDRHeapMover(mover, right.next, count + 1);
		if (count >= this.size / 2) {
			int temp = right.data;
			right.data = mover.left.data;
			mover.left.data = temp;
		}

		mover.left = mover.left.next;

	}

	public void fold() throws Exception {
		HeapMover mover = new HeapMover();
		mover.left = this.head;
		fold(mover, this.head.next, 0);
		Node last = getNodeAtIndex(this.size - 1);
		last.next = null;
	}

	private void fold(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}

//		if(count == (this.size / 2))
//		{
//			right.next = null;
//		}

//		if(count < this.size / 2)
//		{
//			return;
//		}

		fold(mover, right.next, count + 1);
		Node temp = null;
		if (count >= this.size / 2) {
			temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;
		}

		mover.left = temp;

	}

	public void middle() {
		System.out.println(middleNode().data);
	}

	private Node middleNode() {

		Node prev = this.head;
		Node curr = this.head;

		while (!(curr.next == null || curr.next.next == null)) {
			prev = prev.next;
			curr = curr.next.next;
		}

		return prev;

	}

	// kth node from last
	public int kthfromlast(int k) {

		Node slow = this.head;
		Node fast = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public void kthreverse(int k) throws Exception {
		LinkList prev = null;

		while (this.size != 0) {
			LinkList curr = new LinkList();

			for (int i = 0; i < k; i++) {
				curr.addAtFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.size += curr.size;
				prev.tail = curr.tail;
			}

		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	public void createDummy() {
		Node n1 = new Node();
		n1.data = 10;
		Node n2 = new Node();
		n2.data = 20;
		Node n3 = new Node();
		n3.data = 30;
		Node n4 = new Node();
		n4.data = 40;
		Node n5 = new Node();
		n5.data = 50;
		Node n6 = new Node();
		n6.data = 60;
		Node n7 = new Node();
		n7.data = 70;
		Node n8 = new Node();
		n8.data = 80;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n4;

		this.head = n1;

	}

	public void detectRemoveLoop() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast) {
				break;
			}
		}

		Node start = this.head;
		Node loop = fast;

		while (loop.next != fast.next) {
			start = start.next;
			loop = loop.next;
		}

		loop.next = null;

	}

}
