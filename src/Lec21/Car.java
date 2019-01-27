package Lec21;

public class Car implements Comparable<Car> {

	int price;
	int speed;
	String color;

	public Car(int price, int speed, String color) {
		this.price = price;
		this.speed = speed;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Price " + this.price + " Speed " + this.speed + " Color " + this.color;
	}

	@Override
	public int compareTo(Car o) {

		return 0;
	}
	
	public static void bubbleSort(int[] arr) {

		int n = arr.length;

		boolean flag = true;
		for (int counter = 0; counter < n - 1; counter++) {

			// System.out.println("Counter " + counter);
			for (int j = 0; j < n - counter - 1; j++) {

				if (arr[j] > arr[j + 1]) {

					flag = false;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			if (flag) {
				break;
			}

			// display(arr);
		}

	}

}
