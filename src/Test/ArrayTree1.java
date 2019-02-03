package Test;

import java.util.Scanner;

public class ArrayTree1 {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t > 0){
            int n = s.nextInt();
            int[] arr = new int[n];
            int i = 0;
            while(i < n){
                arr[i] = s.nextInt();
                i++;
            }
            
            BinaryTree bt = new BinaryTree(arr);
            bt.display();
            t--;
        }
    }
}

class BinaryTree{
    private class Node{
        int data;
        Node left;
        Node right;
    }
    
    Node root;
    // Scanner s;
    
    public BinaryTree(int[] arr){
        this.root = construct(null, arr, 0);
    }
    
    private Node construct(Node node, int[] arr, int vidx){
        if(vidx >= arr.length) {
        	return new Node();
        }
        
        Node nn = new Node();
        nn.data = arr[vidx];
        
        Node rn = construct(nn, arr, vidx + 1);
//        nn.right = construct(nn, arr, vidx + 2);
        
        rn.data = vidx;
        
        if(nn.left == null) {
        	nn.left = rn;
        } else if(nn.right == null) {
        	nn.right = rn;
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
}