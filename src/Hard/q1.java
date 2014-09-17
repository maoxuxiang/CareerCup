package Hard;
/**
 * Write a function to add two number without add operation.
 * 
 */
// O(1) space, O(d) time, where d is the length of bits
public class q1 {
	
	public static int add(int a, int b) {
		int sum = a ^ b;
		int carry = (a & b) << 1;
		
		if (carry != 0) {
			return add(sum, carry);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.print(add(9,8));
	}
}
