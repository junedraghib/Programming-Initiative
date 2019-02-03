package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArrayTree {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			int n = s.nextInt();
			int[] arr = new int[n];

			int i = 0;
			while (i < n) {
				arr[i] = s.nextInt();
				i++;
			}

			Tree tree = new Tree(arr);
			tree.display();
			System.out.println();
			tree.vertical();

			t--;
		}
	}
}

class Tree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	Scanner s;

	public Tree(int[] arr) {
		this.root = construct(null, arr, -1);
	}

	private Node construct(Node parent, int[] arr, int vidx) {

		if (vidx >= arr.length) {
			return null;
		}

		Node nn = new Node();
		nn.data = vidx;
		for (int i = vidx + 1; i < arr.length; i++) {
			if (arr[i] == vidx) {
				nn.children.add(construct(nn, arr, i));
			}
		}

		return nn;

	}

	private Node constructB(Node parent, int[] arr, int vidx) {

		if (vidx > arr.length) {
			return null;
		}

		if (vidx == arr.length) {
			Node bn = new Node();
			bn.data = vidx;
			parent.children.add(bn);
			return bn;
		}

		Node nn = new Node();
		nn.data = vidx;
		for (int i = vidx + 1; i < arr.length; i++) {
			if (arr[i] == vidx) {
				nn.children.add(constructB(nn, arr, i));
			}
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

	public void vertical() {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		vertical(this.root.children.get(0), 0, map);
		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		for(int i = map.keySet().size() - 1; i >= 0; i--) {
			for(int value: map.get(keys.get(i))) {
				System.out.print(value);
			}
			System.out.println();
		}
		
		
	}
	
	private void vertical(Node node, int level, HashMap<Integer, ArrayList<Integer>> map) {

		if (node == null) {
			return;
		}
		
		if(map.containsKey(level)) {
			map.get(level).add(node.data);
		} else {
			ArrayList<Integer> a = new ArrayList<>();
			a.add(node.data);
			map.put(level, a);
		}
		
		for (int i = 0; i < node.children.size(); i++) {
			if(i == 0) {
				vertical(node.children.get(i), level - 1, map);
			} else if(i == 1) {
				vertical(node.children.get(i), level + 1, map);
			}
		}

	}
}