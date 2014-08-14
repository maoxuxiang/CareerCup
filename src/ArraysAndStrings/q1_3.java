package ArraysAndStrings;
/*
 * Given two String, write a method to decide if one is a permutation of the other.
 */
public class q1_3 {
	//way 1
	public String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutaion(String s, String t) {
		if(s.length() != t.length())
			return false;
		return sort(s).equals(sort(t));
	}
	
	//way 2
	public boolean permutation(String s, String t) {
		if (s.length() != t.length())
			return false;
		
		int[] letters = new int[256]; //assumption ASCII
		
		char[] s_array = s.toCharArray();
		for (char c: s_array) {
			letters[c]++;
		}
		
		for (int i=0; i<t.length(); i++) {
			int c = t.charAt(i);
			if(--letters[c]<0)
				return false;
		}
		
		return true;
	}

}
 