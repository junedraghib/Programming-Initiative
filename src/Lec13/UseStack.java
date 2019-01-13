package Lec13;

/**
 * created by : Juned Raghib
 * created on : 29-Dec-2018
 */
public class UseStack {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
//		stack.push(10);
//		stack.pop();
		stack.display();
		
		

	}

}
