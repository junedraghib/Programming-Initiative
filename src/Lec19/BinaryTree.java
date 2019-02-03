package Lec19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
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

	public BinaryTree(int[] pre, int[] in) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int inlo, int inhi) {
		if (plo > phi || inlo > inhi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		int searchindex = -1;
		for (int i = inlo; i <= inhi; i++) {
			if (in[i] == pre[plo]) {
				searchindex = i;
				break;
			}
		}

		int numberofelement = searchindex - inlo;
		nn.left = construct(pre, plo + 1, plo + numberofelement, in, inlo, searchindex - 1);
		nn.right = construct(pre, plo + numberofelement + 1, phi, in, searchindex + 1, inhi);
		return nn;
	}

//	private Node constructpostin(int[] post, int plo, int phi, int[] in, int inlo, int inhi)
//	{
//		if (plo > phi || inlo > inhi) {
//			return null;
//		}
//		
//		Node nn = new Node();
//		nn.data = post[plo];
//		
//		int searchindex = -1;
//		for (int i = inlo; i <= inhi; i++) {
//			if (in[i] == post[phi]) {
//				searchindex = i;
//				break;
//			}
//		}
//		
//		int numberofelement = inhi - searchindex;
//		nn.left = construct(post, plo + 1, plo + numberofelement, in, inlo, searchindex - 1);
//		nn.right = construct(post,plo + numberofelement + 1, phi, in,searchindex + 1, inhi);
//		return nn;
//	}

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

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node node) {

		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
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

	// date 19 jan 2k19

	private class Pair1 {
		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderI() {
		LinkedList<Pair1> stack = new LinkedList<>();

		Pair1 sp = new Pair1();
		sp.node = this.root;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair1 tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}

			if (!tp.sd) {
				System.out.print(tp.node.data + " ");
				tp.sd = true;
			} else if (!tp.ld) {
				Pair1 np = new Pair1();
				np.node = tp.node.left;
				if (np.node != null) {
					stack.addFirst(np);
				}
				tp.ld = true;
			} else if (!tp.rd) {
				Pair1 np = new Pair1();
				np.node = tp.node.right;
				if (np.node != null) {
					stack.addFirst(np);
				}
				tp.rd = true;
			} else {
				stack.removeFirst();
			}

		}

	}

	private class BSTPair {
		boolean isBST;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
	}

	public boolean isBST() {
		return isBST(this.root).isBST;
	}

	private BSTPair isBST(Node node) {

		if (node == null) {
			BSTPair np = new BSTPair();
			np.isBST = true;
			return np;
		}

		BSTPair lp = isBST(node.left);
		BSTPair rp = isBST(node.right);

		BSTPair sp = new BSTPair();
		sp.min = Math.min(Math.min(lp.min, rp.min), node.data);
		sp.max = Math.max(Math.max(lp.max, rp.max), node.data);

		if (lp.max < node.data && rp.min > node.data && lp.isBST && rp.isBST) {
			sp.isBST = true;
		} else {
			sp.isBST = false;
		}

		return sp;
	}

	// vertical order using hashmap
	private class HorizontalComparator implements Comparator<VOPair> {

		@Override
		public int compare(VOPair o1, VOPair o2) {
			return o1.hlevel - o2.hlevel;
		}

	}

	public void printVerticalOrder() {
		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();
		printVerticalOrder(this.root, map, 0, 0);

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		
		
		Collections.sort(keys);
		
		for (Integer key : keys) {
			ArrayList<VOPair> list = new ArrayList<>(map.get(key));
			Collections.sort(list, new HorizontalComparator());
			
			System.out.println(key + " " + list);

		}
		
	}

	private class VOPair {
		Node node;
		int vlevel;
		int hlevel;

		@Override
		public String toString() {
			return this.node.data + "";
		}
	}

	private void printVerticalOrder(Node node, HashMap<Integer, ArrayList<VOPair>> map, int hl, int vl) {

		if (node == null) {
			return;
		}

		VOPair np = new VOPair();
		np.node = node;
		np.vlevel = vl;
		np.hlevel = hl;

		if (!map.containsKey(vl)) {
			map.put(vl, new ArrayList<>());
		}

		map.get(vl).add(np);

		printVerticalOrder(node.left, map, hl + 1, vl - 1);
		printVerticalOrder(node.right, map, hl + 1, vl + 1);
		
	}
	
	public int LCA(int a, int b){
	    return LCA(this.root, a, b).data;
	}
	
	private Node LCA(Node node, int a, int b){
	    if(node == null){
	        return null;
	    }
	    
	    if(node.data == a || node.data == b){
	        return node;
	    }
	    
	    Node lnode = LCA(node.left, a, b);
	    Node rnode = LCA(node.right, a, b);
	    
	    //if lnode and rnode return something then
	    //
	    if(lnode != null && rnode != null){
	        return node;
	    }
	    
	    return (lnode != null)?lnode:rnode;
	}
	
}
