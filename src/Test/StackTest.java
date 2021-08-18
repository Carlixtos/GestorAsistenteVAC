package Test;

import util.StackU;

public class StackTest {
	
	public static void generalTest() {
		StackU<Integer> stack = new StackU<Integer>();
		
		for(int i = 1; i < 4; ++i) {
			stack.push(i);
		}
		
		System.out.println("INICIO TEST STACKS\n");
		
		System.out.println("Peek: " + stack.peek() + "\n");
		System.out.print("Contenido de Stack: ");
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
		System.out.println("\n");
		System.out.println("FINAL TEST STACKS\n");
		
	}

}
