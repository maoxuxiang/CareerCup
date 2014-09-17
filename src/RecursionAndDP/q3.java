package RecursionAndDP;

/**
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]
 * = i. Given a sorted array, write a method to find a magic index, if one
 * exists, in array A.
 * 
 * FOLLOW UP What if the values are not distinct?
 * 
 */
// O(1) space, O(lgn) time
public class q3 {
	
	public int findMagicIndex(int[] array) {
		return findMagicIndex(array, 0, array.length-1);
	}
	
	public int findMagicIndex(int[] array, int start, int terminal) {
		
		int mid = (start + terminal)/2;
		if (array[mid] == mid) {
			return mid;
		}
		
		int min = Math.min(array[mid], mid-1);
		int left = findMagicIndex(array, start, min);
		
		if (left > -1) {
			return left;
		}
		
		int max = Math.max(array[mid], mid+1);
		int right = findMagicIndex(array, max, terminal);
		return right;
		
	}

}
