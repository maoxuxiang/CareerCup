package Moderate;

import java.util.Arrays;

/**
 * Design an algorithm to find all pairs of integers within an array which sum
 * to a specified value.
 * 
 */
public class q12 {
	
	public static void printPairSum(int[] array, int sum) {
		
		Arrays.sort(array);
		int start = 0;
		int end = array.length - 1;
		
		while (start  < end) {
			if(array[start] + array[end] == sum) {
				System.out.println(array[start] + "," + array[end]);
				start ++;
				end --;
			}
			if(array[start] + array[end] > sum) {
				end --;
			}
			else
				start ++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {9,8,4,5,7,3,5,8,2,1,4,0,5,7,4,3,6,8,4,2,3,7};
		printPairSum(arr, 11);
		
	}

}
