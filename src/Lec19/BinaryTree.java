package Lec19;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 13-Jan-2019
 */
public class BinaryTree {

	Scanner s = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = construct(null, true);
	}

	public BinaryTree(String str) {

		s = new Scanner(str);
		this.root = construct(null, true);
	}

	private Node construct(Node parent, boolean isLeft) {

		if (parent == null) {
			System.out.println("Root Data : ");
		} else {
			System.out.println("Data for " + parent.data + " : ");
		}

		int item = s.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + "has left Node : ");
		boolean hln = s.nextBoolean();

		if (hln) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + "has Right Node : ");
		boolean hrn = s.nextBoolean();

		if (hrn) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int tm = node.data;

		int lm = max(node.left);
		tm = Math.max(tm, lm);
		int rm = max(node.right);
		tm = Math.max(tm, rm);

		return tm;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean rr = find(node.left, item);
		if (rr) {
			return true;
		} else if (!rr) {
			return find(node.right, item);
		} else {
			return false;
		}
	}

	public int height() {

		return height(this.root);

	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int th = -1;

		int lh = height(node.left);
		th = Math.max(th, lh);
		int rh = height(node.right);
		th = Math.max(th, rh);

		return th + 1;
	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int lh = this.height(node.left);
		int rh = this.height(node.right);

		int diameter = lh + rh + 2;
		int ld = diameter(node.left);
		int rd = diameter(node.right);
		return Math.max(diameter, Math.max(ld, rd));
	}

	// in O(n)
	public int diameter1() {
		return diameter1(this.root).diameter;
	}

	private class DiaPair {
		int height = -1;
		int diameter = 0;
	}

	private DiaPair diameter1(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter1(node.left);
		DiaPair rdp = diameter1(node.right);

		DiaPair np = new DiaPair();
		np.height = Math.max(ldp.height, rdp.height) + 1;

		np.diameter = Math.max(ldp.height + rdp.height + 2, Math.max(ldp.diameter, rdp.diameter));

		return np;
	}

	public boolean isBalanced() {
		return isBalanced(this.root).isblanced;
	}

	private class Pair {
		int height = -1;
		boolean isblanced = true;
	}

	private Pair isBalanced(Node node) {

		if (node == null) {
			return new Pair();
		}

		Pair lp = isBalanced(node.left);
		Pair rp = isBalanced(node.right);

		int bf = Math.abs(lp.height - rp.height);

		Pair np = new Pair();

		if (!(lp.isblanced || rp.isblanced)) {
			np.isblanced = false;
			np.height = Math.max(lp.height, rp.height) + 1;
			return np;
		}

		if (bf == 0 || bf == 1) {
			np.isblanced = true;
		} else {
			np.isblanced = false;
		}

		np.height = Math.max(lp.height, rp.height) + 1;

		return np;
	}

}
