package Lec17;

import java.awt.DisplayMode;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 06-Jan-2019
 */
public class GenericTree {
	Scanner s = new Scanner(System.in);
	private class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	private Node root;
	
	public GenericTree()
	{
		this.root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {
		
		if (parent == null) {
			System.out.println("Root Node Data : ");
		}
		else
		{
			System.out.println(ith+"Child Node Data of "+parent.data+" : ");
		}
		
		Node nn = new Node();
		nn.data = s.nextInt();
		
		System.out.println("Number of children"+ith+"child of "+nn.data+" : ");
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
		
		String str = node.data+"->"; 
		
		for(Node child : node.children)
		{
			str += child.data;
		}
		
		str += ".";
		
		for(Node child : node.children)
		{
			display1(child);
		}

	}
	
	
	

}
