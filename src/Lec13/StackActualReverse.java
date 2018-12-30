package Lec13;

/**
 * created by : Juned Raghib
 * created on : 29-Dec-2018
 */
public class StackActualReverse {
//actual stack must be reveresed
	public static void main(String[] args) throws Exception {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		
		System.out.println();
		reverse(stack, new Stack());
		System.out.println();
		
		stack.display();
		

	}
	
	public static void reverse(Stack stack, Stack temp) throws Exception
	{
		if (stack.isEmpty() ) {
			if(temp.isEmpty()) {
//				reverse(temp, stack);
				return;
			}
			int cur = temp.pop();
			reverse(stack, temp);
			stack.push(cur);
			
			
			//temp.display();
			return;
		}
		
		int cur = stack.pop();
		temp.push(cur);
		reverse(stack, temp);
	}

}
