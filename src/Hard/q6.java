package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Describe an algorithm to find the smallest one million numbers in one billion
 * numbers. Assume that the computer memory CANNOT hold all one billion numbers.
 * 
 */
// O(k) space, O(nlgk) time
public class q6 {
	
	public static int[] first(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare (Integer a, Integer b) {
				return -a.compareTo(b);
			}
		});
		
		for (int i=0; i<arr.length; i++) {
			heap.add(arr[i]);
			
			if (heap.size() > k) {
				heap.poll();
			}
			
		}
		
		
		int id =0;
		
		int[] res = new int[k];
		while (!heap.isEmpty()) {
			res[id++] = heap.poll();
		}
		
		return res;
	}
// solution 2 selection rank algorithm
}
