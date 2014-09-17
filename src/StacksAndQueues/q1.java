/*
 * Describe how you could use a single array to implement three stacks.
 */

package StacksAndQueues;

public class q1 {
	
	//Fixed division. 
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPOINTer = {-1, -1, -1};

	
	void push(int stackNum, int value) throws Exception {
		if (stackPOINTer[stackNum] + 1 >= stackSize) 
			throw new Exception ("Out of space");
		
		stackPOINTer[stackNum] ++;
		buffer[absTopOfStack(stackNum)] = value;
	}
	
	int pop(int stackNum) throws Exception {                               
		if (stackPOINTer[stackNum] == -1)
			throw new Exception ("an empty stack");
		int value = buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)] = 0;
		stackPOINTer[stackNum]--;
		return value;
	}
	
	int peek(int stackNum) {
		return buffer[absTopOfStack(stackNum)];
	}
	
	boolean isEmpty(int stackNum) {
		if (stackPOINTer[stackNum]  > -1)
			return false;
		else 
			return true;
	}
	
	int absTopOfStack(int stackNum) {
		return stackNum*stackSize + stackPOINTer[stackNum];
	}
}
