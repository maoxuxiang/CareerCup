package BitManipulation;
/**
 * Write a function to determine the number of bits required to convert integer
 * A to integer B.
 * 
 */
public class Q5 {
	
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >>1) {
			count += (c & 1);
		}
		return count;
	}
	
	// solution 2
	public static int bitSwapRequired2(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c-1)) {
			count ++;
		}
		return count;
	}

}
