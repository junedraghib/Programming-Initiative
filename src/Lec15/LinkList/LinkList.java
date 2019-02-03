package Lec15.LinkList;

import java.util.LinkedList;

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

	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
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

	public int removeAtIndex(int index) throws Exception {
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

	// reverse data iteratively
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

	// reverse pointer iteratively
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

	// reverse pointer recursively helper function
	private void reversePR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		reversePR(curr, curr.next);
		curr.next = prev;

	}

	// reverse pointer recursively
	public void reversePR() {
		// client wouldn't have access to the head
		reversePR(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	// reverse Data recursively helper function
	public void reverseDR() {

		reverseDR(this.head, this.head.next, 0);

	}

	/**
	 * we have made this method as we need to have access to LinkList private
	 * properties such as head and tail and at the same time we have to make this
	 * function accessible to public client, this we will call it from another
	 * public method while making sure, that a public client might not be having
	 * access to private properties
	 */
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

	/**
	 * HeapMover is a concept to make a particular data member global so that each
	 * function frame could have access to that variable, at anytime, we might have
	 * created that variable at class level or static but for other function we
	 * might not be using this variable very frequently, thus later approach will
	 * cause increased size for each instance for this class, thus better is to use
	 * a HeapMover concept
	 *
	 * here we wanted to make variable left global so we have created a private
	 * class heapmover here and left as a member of this class.
	 *
	 **/
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

		// create a difference of k distance among slow and fast pointer
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		// when fast pointer reaches end of the LinkList slow reaches to (n - k)th node
		// which is kth from last
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

	private LinkList mergerTwoSortedLinkList(LinkList second) throws Exception {
		LinkList sorted = new LinkList();

		Node fptr = this.head;
		Node sptr = second.head;

		while (fptr != null && sptr != null) {
			if (fptr.data < sptr.data) {
				sorted.addAtLast(fptr.data);
				fptr = fptr.next;
			} else {
				sorted.addAtLast(sptr.data);
				sptr = sptr.next;
			}
		}

		if (fptr == null) {
			while (sptr != null) {
				sorted.addAtLast(sptr.data);
				sptr = sptr.next;
			}
		}

		if (sptr == null) {
			while (fptr != null) {
				sorted.addAtLast(fptr.data);
				fptr = fptr.next;
			}
		}

		return sorted;
	}

	public void mergeSort() throws Exception {
		if (this.size == 1) {
			return;
		}

		Node midn = this.middleNode();
		Node midp1n = midn.next;

		LinkList fh = new LinkList();
		fh.head = this.head;
		fh.tail = midn;
		fh.size = (this.size + 1) / 2;
		fh.tail.next = null;

		LinkList sh = new LinkList();
		sh.head = midp1n;
		sh.tail = this.tail;
		sh.size = (this.size) / 2;
		sh.tail.next = null;

		fh.mergeSort();
		sh.mergeSort();

		LinkList merged = fh.mergerTwoSortedLinkList(sh);

		this.head = merged.head;
		this.tail = merged.tail;
		this.size = merged.size;

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
		this.tail = null;

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

		if (slow == fast) {
			Node start = this.head;
			Node loop = fast;

			while (loop.next != start.next) {
				start = start.next;
				loop = loop.next;
			}
			
			System.out.println("Loop Detected at "+loop.data+" and "+start.next.data);
			loop.next = null;
			System.out.println("Loop Removed!!");
		}
		else
		{
			System.out.println("No Loop Detected!!");
		}

	}
	
	public void add(LinkList l) throws Exception{
	    LinkList ll = add(this, l);
	    
	    if(ll.getFirst() == 0){
	        ll.removeFirst();
	        ll.display();
	    } else {
	        ll.display();
	    }
	}
	
	private LinkList add(LinkList l1, LinkList l2) throws Exception{
	    
	    if(l1.isEmpty() && l2.isEmpty()){
	        LinkList br = new LinkList();
	        br.addAtFirst(0);
	        return br;
	    }
	    
	    int val1 = l1.removeLast();
	    int val2 = l2.removeLast();
	    
	    LinkList rll = add(l1, l2);
	    
	    int carry0 = rll.removeFirst();
	    
	    int sum = (val1 + val2 + carry0) % 10;
	    int carry1 = (val1 + val2 + carry0) / 10;
	    
	    rll.addAtFirst(sum);
	    rll.addAtFirst(carry1);
	    
	    return rll;
	    
	}
	
	

}
