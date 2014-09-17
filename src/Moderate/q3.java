package Moderate;
/**
 * Design an algorithm which counts the number of trailing zeros in n factorial.
 *
 */
// O(1) space, O(nlgn) time

public class q3 {
	
	// solution 1: count the number of factors of 5
	private static int factorsOf5(int num) {
		int count = 0;
		
		while (num % 5 == 0) {
			count ++;
			num = num/5;
		}
		return count;
	}
	
	public static int countFactZero(int num) {
		int count = 0;
		for (int i=2; i<=num; i++) {
			count += factorsOf5(i);
		}
		
		return count;
	}
	
	// solution 2 a little more efficient
	
	public static int countFacZero2(int num) {
		int count = 0;
		for (int i = 5; num / i >0; i = i*5) {
			count += num / i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countFactZero(25));
		System.out.print(countFacZero2(26));
	}

}
