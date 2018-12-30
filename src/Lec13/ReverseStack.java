package Lec13;

/**
 * created by : Juned Raghib created on : 29-Dec-2018
 */
public class ReverseStack {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();

		printReverse(stack);
		System.out.println();
		stack.display();

	}

	public static void printReverse(Stack stack) throws Exception {
		if (stack.isEmpty()) {
			return;
		}

		int cur = stack.pop();
		printReverse(stack);
		System.out.print(cur + " ");
		stack.push(cur);
	}

}
