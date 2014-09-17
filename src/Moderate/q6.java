package Moderate;
/**
 * Given an array of integers, write a method to find indices m and n such that
 * if you sorted elements m through n, the entire array would be sorted.
 * Minimize n - m (that is, find the smallest such sequence).
 * 
 * EXAMPLE
 * Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 * Result: 3, 9
 */
// O(1) space, O(n) time
public class q6 {
	
	private static int findLeftEnd(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			if (array[i] > array[i+1]) {
				return i;
			}
		}
		return  array.length-1;
	}
	
	private static int findRighBegin(int[] array) {
		for (int i=array.length-1; i>=1; i--) {
			if (array[i] < array[i-1]) {
				return i;
			}
		}
		return 0;
	}
	
	private static int shrinkLeft(int[] array, int minIndex, int start) {
		int tmp = array[minIndex];
		for (int i=start; i>=0; i--) {
			if(array[i] <= tmp) {
				return i;
			}
		}
		return 0;
	}
	
	private static int shrinkRight(int[] array, int maxIndex, int start) {
		int tmp = array[maxIndex];
		for (int i=start; i<array.length; i++) {
			if (array[i] >= tmp) {
				return i-1;
			}
		}
		return array.length-1;
	}
	
	public static void findArrayIndex(int[] array) {
		int left_end = findLeftEnd(array);
		int begin_right = findRighBegin(array);
		
		
		//already sorted
		if (left_end == array.length-1) {
			return;
		}
		
		int minIndex = left_end + 1;
		int maxIndex = begin_right -1;
		
		for (int i = left_end; i<begin_right; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
		}
		
		int mid_begin = shrinkLeft(array, minIndex, left_end);
		int mid_end = shrinkRight(array, maxIndex, begin_right);
		
		System.out.print(mid_begin + "," + mid_end);
		
	}
	
	public static void main(String[] args) {
		int[] i = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		findArrayIndex(i);
	}
}
