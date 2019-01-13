package Lec19;

/**
 * created by : Juned Raghib
 * created on : 13-Jan-2019
 */
public class BinaryTreeClient {

	public static void main(String[] args) {
		//10 true 20 true 50 false false true 60 false false true 30 false false
		BinaryTree bt = new BinaryTree("10 true 20 true 50 true 88 false false false true 60 false false true 30 false false");
//		bt.display();
		System.out.println("max : "+bt.max());
		System.out.println("ispresent : "+bt.find(20));
		System.out.println("height : "+bt.height());
		System.out.print("Preorder : ");
		bt.preorder();
		System.out.println();
		System.out.print("Postorder : ");
		bt.postorder();
		System.out.println();
		System.out.println("diameter : "+bt.diameter());
		System.out.println("diameter : "+bt.diameter1());
		System.out.println("IsBalanced : "+bt.isBalanced());
	}

}
