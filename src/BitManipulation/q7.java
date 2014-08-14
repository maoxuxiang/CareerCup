package BitManipulation;

import java.util.ArrayList;

/**
 * An array A contains all the integers from 0 to n, except for one number which
 * is missing. In this problem, we cannot access an entire integer in A with a
 * single operation. The elements of A are represented in binary, and the only
 * operation we can use to access them is "fetch the jth bit of A[i]", which
 * takes constant time. Write code to find the missing integer. Can you do it in
 * O(n) time?
 * 
 */
public class q7 {
	
	public int findMissing(ArrayList<Integer> array) {
		return findMissing(array, 0);
	}
	
	private int findMissing(ArrayList<Integer> array, int column) {
		if (column >= Integer.SIZE) {
			return 0;
		}
		
		ArrayList<Integer> one = new ArrayList<Integer>(array.size()/2);
		ArrayList<Integer> zero = new ArrayList<Integer>(array.size()/2);
		
		for (Integer t : array) {
			if (t.fetch(column) == 1) {
				one.add(t);
			}
			else {
				zero.add(t);
			}
		}
		
		if (zero.size() <= one.size()) {
			int v = findMissing(zero, column + 1);
			return (v<<1) | 0;
		}
		else {
			int v = findMissing(one, column + 1);
			return (v<<1) | 1;
		}
	}

}
