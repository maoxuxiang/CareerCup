package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method. Write a program to
 * find and maintain the median value as new values are generated.
 * 
 */
// O(n) space, O(logn) time

public class q9 {
	
	public static class MaxHeapComparator implements Comparator<Integer> {
		
		public int compare(Integer a, Integer b) {
			return -a.compareTo(b);
		}
		
	}
	
	private PriorityQueue<Integer>  minHalf = new PriorityQueue<Integer>(1, new MaxHeapComparator());
	private PriorityQueue<Integer>  maxHalf = new PriorityQueue<Integer>();
	
	public void addNum(int num) {

		if (minHalf.size() == maxHalf.size()) {

			if (maxHalf.peek() != null && num > maxHalf.peek()) {
				minHalf.add(maxHalf.poll());
				maxHalf.add(num);
			}
			else {
				minHalf.add(num);
			}
		}
		
		else {
			if (num < minHalf.peek()) {
				maxHalf.add(minHalf.poll());
				minHalf.add(num);
			}
			else {
				maxHalf.add(num);
			}
		}
	}
	
	public int median() {
		if (minHalf.isEmpty()) {
			return 0;
		}
		
		if (minHalf.size() == maxHalf.size()) {
			return (minHalf.peek() + maxHalf.peek()) / 2;
		}
		
		else {
			return minHalf.peek();
		}
	}
	
	public static void main( String[] args) {
		q9 test = new q9();
		test.addNum(1);
		test.addNum(12);
		test.addNum(11);
		test.addNum(4);
		test.addNum(8);
		test.addNum(10);
		
		System.out.print(test.median());
	}

}
