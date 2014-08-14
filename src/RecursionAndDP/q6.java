package RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement an algorithm to print all valid (e.g., properly opened and closed)
 * combinations of n-pairs of parentheses.
 */
// O(2^n) space, O(2^n) time, a more strict bound is the catalan number 
 
public class q6 {
	
	public static List<String> printPar(int n) {
		List<String> res = new ArrayList<String>();
		StringBuilder s = new StringBuilder();
		printPar(n, 0, 0, s, res);
		System.out.print(res);
		return res;
	}
	
	public static void printPar(int n, int left, int right, StringBuilder s, List<String> res) {
		if (left == n && right == n) {
			res.add(s.toString());
		}
		
		if (left < n) {
			s.append("(");
			printPar(n, left+1, right, s, res);
			s.deleteCharAt(s.length()-1);
		}
		
		if (right < left) {
			s.append(")");
			printPar(n, left, right+1, s, res);
			s.deleteCharAt(s.length()-1);
		}
	}
	
	public static void main(String[] args) {
		printPar(3);
	}
	

}
