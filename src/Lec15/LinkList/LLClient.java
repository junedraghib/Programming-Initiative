package Lec15.LinkList;

/**
 * created by : Juned Raghib created on : 02-Jan-2019
 */
public class LLClient {

	public static void main(String[] args) throws Exception {
		LinkList list = new LinkList();
		list.addAtLast(10);
		list.addAtLast(20);
		list.addAtLast(30);
		list.addAtLast(40);
		list.addAtLast(50);
		list.addAtLast(60);
		list.addAtLast(70);
		list.addAtLast(80);
		list.addAtLast(90);
		//list.addAtLast(50);
//		
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.getAtIndex(2));
		
//		list.addAtFirst(11);
//		
//		list.display();
//		
//		list.addAtIndex(2, 12);
//		list.display();
//		list.removeAt(2);
//		list.display();
//		list.removeFirst();
//		list.display();
//		list.removeLast();
		
//		list.display();
//		System.out.println();
//		list.reversePI();
//		list.display();
//		list.reversePR();
//		list.display();
//		list.reverseDR();
//		list.display();
//		list.reverseDRheapMover();
//		list.display();
//		list.fold();
//		list.display();
//		list.removeLast();
//		list.display();
//		list.middle();
//		list.kthreverse(3);
//		list.display();
		LinkList ll = new LinkList();
		ll.addAtFirst(12);
		ll.createDummy();
		ll.detectRemoveLoop();
		ll.display();
		
		

	}

}
