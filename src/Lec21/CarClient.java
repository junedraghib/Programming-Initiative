package Lec21;

public class CarClient {
	public static void main(String[] args) {

		Car[] cars = new Car[5];

		cars[0] = new Car(100, 200, "Black");
		cars[1] = new Car(101, 201, "Grey");
		cars[2] = new Car(102, 202, "Magenta");
		cars[3] = new Car(103, 203, "Burgandi");
		cars[4] = new Car(104, 204, "Aqua");
		
		display(cars);

	}

	public static <T> void display(T[] cars) {

		for (T val : cars)
			System.out.println(val+" ");
	}

}
