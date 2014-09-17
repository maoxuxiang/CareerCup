package Hard;

import java.util.Random;

/**
 * Write a method to randomly generate a set of m integers from an array of size
 * n. Each element must have equal probability of being chosen.
 * 
 */
// O(m) space, O(1) time
// reserve solution
public class q3 {
	
	public static void randomGenerate(int[] arr, int m) {
		int[] reserve = new int[m];
		Random rnd = new Random();
		
		for (int i=0; i<arr.length; i++) {
			if (i < m) {
				reserve[i] = arr[i];
			}
			
			else {
				 // new elements are kept with probability m/i
				int k = rnd.nextInt(i);
				if (k < m) {
					reserve[k] = arr[i];
				}
			}
		}
	}

}
