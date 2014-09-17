
package RecursionAndDP;

import java.util.ArrayList;

/*
 * Write a method to compute all permutations of a string.
 * o(n!)time
 */
public class Q5 {
	
	static ArrayList<String> getPerms(String str) {
		
		
		if (str == null) {
			return null;
		}
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String rest = str.substring(1);
		ArrayList<String> words = getPerms(rest);
		for (String s : words) {
			for (int i=0; i<=s.length(); i++) {
				String neword = insert(first, s, i);
				permutations.add(neword);
			}
		}
		return permutations;
	}
	
	static String insert(char c, String s, int i) {
		String first = s.substring(0,i);
		String last = s.substring(i);
		return first + c + last;
	}
	
	public static void main(String[] args) {
		 ArrayList<String> s = getPerms("mop");
		 System.out.print(s);
	}

}
