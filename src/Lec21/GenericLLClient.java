package Lec21;

import java.util.LinkedList;

public class GenericLLClient {

	public static void main(String[] args) throws Exception {
		GenericLinkList<Car> ll = new GenericLinkList<>();
		Car[] cars = new Car[5];

		cars[0] = new Car(100, 200, "Black");
		cars[1] = new Car(101, 201, "Grey");
		cars[2] = new Car(102, 202, "Magenta");
		cars[3] = new Car(103, 203, "Burgandi");
		cars[4] = new Car(104, 204, "Aqua");
		
		ll.addAtFirst(cars[0]);
		ll.addAtFirst(cars[1]);
		ll.addAtFirst(cars[2]);
		ll.addAtFirst(cars[3]);
		ll.display();
		LinkedList<Integer> list = new LinkedList<>();
		
	}

}
