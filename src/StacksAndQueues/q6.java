/*
 * Write a program to sort a stack in ascending order (Biggest items on top).
 */
package StacksAndQueues;

import java.util.Stack;

public class q6 {
	
	public static Stack<Integer> sort(Stack<Integer> t) {
		Stack<Integer> r = new Stack<Integer>();
		
		while (!t.isEmpty()) {
			int tmp = t.pop();
			while (!r.isEmpty() && r.peek()>tmp) {
				t.push(r.pop());
			}
			
			r.push(tmp);
		}
		return r;
	}

}
