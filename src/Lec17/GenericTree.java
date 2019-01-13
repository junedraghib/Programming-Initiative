package Lec17;

import java.awt.DisplayMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 06-Jan-2019
 */
public class GenericTree {
	Scanner s;

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		s = new Scanner(System.in);
		this.root = construct(null, -1);
	}

	public GenericTree(String str) {
		s = new Scanner(str);
		this.root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Root Node Data : ");
		} else {
			System.out.println(ith + "Child Node Data of " + parent.data + " : ");
		}

		Node nn = new Node();
		nn.data = s.nextInt();

		System.out.println("Number of children" + ith + "child of " + nn.data + " : ");
		int noc = s.nextInt();

		for (int i = 0; i < noc; i++) {
			nn.children.add(construct(nn, i));
		}

		return nn;
	}

	public void display() {

		display1(this.root);
	}

	private void display1(Node node) {

		String str = node.data + "->";

		for (Node child : node.children) {
			str += child.data + " ";
		}

		str += ".";
		System.out.println(str);

		for (int i = node.children.size() - 1; i >= 0; i--) {
			display1(node.children.get(i));
		}

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		System.out.print(node.data + " ");

		for (int i = node.children.size() - 1; i >= 0; i--) {
			postorder(node.children.get(i));
		}

	}

	public void preorder() {

		preorder(this.root);
	}

	private void preorder(Node node) {

		System.out.print(node.data + " ");

		for (int i = 0; i < node.children.size(); i++) {
			preorder(node.children.get(i));
		}
	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}
		}
	}

	// using null

	// using primary and helper queue
	public void levelorderNL() {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.addLast(this.root);

		while (!primary.isEmpty()) {
			Node rn = primary.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (primary.isEmpty()) {
				primary = helper;
				System.out.println();
				helper = new LinkedList<>();
			}
		}
	}

	public void levelorderZZ() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		queue.addLast(this.root);

		int count = 0;
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (int i = 0; i < rn.children.size(); i++) {
					stack.addFirst(rn.children.get(i));
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}

			if (queue.isEmpty()) {
				count++;
				queue = stack;
				System.out.println();
				stack = new LinkedList<>();
			}
		}
	}

	public void printAtLevel(int level) {
		printAtLevel(level, this.root, 0);
	}

	private void printAtLevel(int level, Node node, int count) {
		if (count == level) {
			System.out.print(node.data + " ");
		}

		for (int i = 0; i < node.children.size(); i++) {
			printAtLevel(level, node.children.get(i), count + 1);
		}
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int sum = 0;
		for (Node child : node.children) {
			sum += size(child);
		}

		return sum + 1;

	}

	private int max(Node node, int max) {
		if (node.data > max) {
			max = node.data;
		}

		for (Node n : node.children) {
			max = max(n, max);

		}

		return max;
	}

	// getting max of all the subtrees and the deciding max out of them and the
	// particular node
	private int max(Node node) {
		int tmax = node.data;

		for (Node child : node.children) {
			int cmax = max(child);
			tmax = Math.max(cmax, tmax);
		}

		return tmax;
	}

	public int max1() {
		return max(this.root);
	}

	public int max() {
		return max(this.root, Integer.MIN_VALUE);
	}

	public boolean find(int value) {
		return find(this.root, value);
	}

	private boolean find(Node node, int value) {
		if (node.data == value) {
			return true;
		}

		for (Node n : node.children) {
			boolean found = find(n, value);
			if (found) {
				return true;
			}
		}
		return false;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		int th = -1;

		for (Node child : node.children) {
			int ch = height(child);
			th = Math.max(th, ch);
		}

		return th + 1;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {
		int i = 0;
		int j = node.children.size() - 1;

		while (i < j) {
			Node left = node.children.get(i);
			Node right = node.children.get(j);

			node.children.set(i, right);
			node.children.set(j, left);

			i++;
			j--;
		}

		for (Node child : node.children) {
			mirror(child);
		}

	}

	// lecture 18

	private class HeapMover {

		int size = 0;
		int max = Integer.MIN_VALUE;
		boolean ispresent = false;
		int height = 0;
		Node predicessor;
		Node successor;
		Node justgreater;
	}

	public void multiSolver(int item) {
		HeapMover mover = new HeapMover();
		multiSolver(mover, item, 0, this.root);
		System.out.println("Size : " + mover.size);
		System.out.println("Max : " + mover.max);
		System.out.println("Height : " + mover.height);
		System.out.println("IsPresent : " + mover.ispresent);
		System.out.println("Predecessor : "+(mover.predicessor == null?null:mover.predicessor.data));
		System.out.println("Successor : "+(mover.successor == null?null:mover.successor.data));
		System.out.println("JustGreater : "+mover.justgreater.data);
	}

	private void multiSolver(HeapMover mover, int item, int level, Node node) {

		mover.size++;

		if (node.data > mover.max) {
			mover.max = node.data;
		}

		if (mover.ispresent == true && mover.successor == null) {
			mover.successor = node;
		}
		
		if (node.data == item) {
			mover.ispresent = true;
		}
		
		if (mover.ispresent == false) {
			mover.predicessor = node;
		}
		
		if (node.data > item) {
//			mover.justgreater = node;
			
			if (mover.justgreater == null || node.data < mover.justgreater.data) {
				mover.justgreater = node;
			}
		}
		
		if (level > mover.height) {
			mover.height = level;
		}

		for (Node child : node.children) {
			multiSolver(mover, item, level + 1, child);
		}

	}



}
