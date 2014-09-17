package Moderate;

/**
 * You are given an array of integers (both positive and negative). Find the
 * contiguous sequence with the largest sum. Return the sum. EXAMPLE Input: 2,
 * -8, 3, -2, 4, -10 Output: 5
 * 
 */
// O(1) space, O(n) time

public class q8 {
	
	public static int getMaxSum(int[] array) {
		int sum = 0;
		int maxSum = 0;
		
		for (int i=0; i<array.length; i++) {
			sum += array[i];
			if (maxSum < sum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		
		return maxSum;
	} 
	
	public static void main(String[] args) {
		int[] a = {2,3,-8,-1,2,4,-2,3};
		System.out.println(getMaxSum(a));
	}

}
