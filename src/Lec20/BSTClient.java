package Lec20;

public class BSTClient {

	public static void main(String[] args) {
		
		int[] inorder = {10, 20, 30, 40, 45, 50, 55, 60, 65, 70, 80};
		BinarySearchTree bst = new BinarySearchTree(inorder);
//		System.out.println("max : "+bst.max());
//		System.out.println("ispresent : "+bst.find(21));
//		System.out.println("Height : "+bst.height());
//		bst.pirntInRange(15, 55);
//		bst.replaceWithSumofGreater();
//		System.out.println();
//		bst.printDecreasing();
		bst.display();
//		bst.addAtProperLocation(22);
//		System.out.println();
//		bst.display();
//		bst.removeNodeRetainingBST();
//		System.out.println("------------");
		bst.display();

	}

}
