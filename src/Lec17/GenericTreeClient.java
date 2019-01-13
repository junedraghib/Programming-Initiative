package Lec17;

/**
 * created by : Juned Raghib
 * created on : 06-Jan-2019
 */
public class GenericTreeClient {

	public static void main(String[] args) {
		//10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0 
		GenericTree gt = new GenericTree("10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0");
//		gt.display();
//		System.out.println(gt.size());
//		System.out.println(gt.max());
//		System.out.println(gt.find(60));
		
//		gt.preorder();
//		gt.mirror();
//		System.out.println();
//		gt.display();
//		gt.preorder();
//		System.out.println();
		
//		System.out.println("height : "+gt.height());
		
//		gt.preorder();
//		System.out.println();
//		gt.postorder();
//		System.out.println();
//		gt.levelorder();
//		System.out.println();
//		gt.levelorderNL();
//		System.out.println();
//		gt.levelorderZZ();
//		System.out.println();
//		gt.printAtLevel(2);
		
		gt.multiSolver(20);
	}

}
