/*
 * Implement a MyQueue class which implements a queue using two stacks.
 */

package StacksAndQueues;

import java.util.Stack;

public class q5 {

	public class Myqueue<T> {
		Stack<T> stackOld, stackNew;
		
		public Myqueue() {
			stackOld = new Stack<T>();
			stackNew = new Stack<T>();
		}
		
		public int size() {
			return stackOld.size() + stackNew.size();
		}
		
		public void push(T t) {
			stackNew.push(t);
		}
		
		public void shiftStacks() {
			if (stackOld.isEmpty()) {
				if (!stackNew.isEmpty()) {
					stackOld.push(stackNew.pop());
				}
			}
		}
		
		public T peek() {
			shiftStacks();
			return stackOld.peek();
		}
		
		public T pop() {
			shiftStacks();
			return stackOld.pop();
		}
	

	}
}
