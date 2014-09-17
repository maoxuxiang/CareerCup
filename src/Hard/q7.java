package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given a list of words, write a program to find the longest word made of other
 * words in the list.
 * 
 */
// O(1) space, O(2^(d/2)) time, where d is the length of the word.
public class q7 {
	
	public static class lengthComparator implements Comparator<String> {

		public int compare(String s1, String s2) {
			if (s1.length() > s2.length()) {
				return -1;
			}
			if (s1.length() < s2.length()) {
				return 1;
			}
			else 
				return 0;
		}
	}
	 
	public static String printLongestString(String[] sarr) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String s: sarr) {
			map.put(s, true);
		}
		
		Arrays.sort(sarr, new lengthComparator());
		
		for (String s: sarr) {
			if (canBuildWords(s,true,map)) {
				System.out.print(s);
				return s;
			}
			
		}
		
		return "";
	}
	
	public static boolean canBuildWords(String s, boolean isOriginal, 
			HashMap<String, Boolean> map) {
		if (map.containsKey(s) && !isOriginal) {
			return map.get(s);
		}
		
		for (int i=0; i<s.length(); ++i) {
			
			String left = s.substring(0,i);
			String right = s.substring(i);
			
			if (map.containsKey(left) && map.get(left) == true && canBuildWords(right, false, map)) {
				return true;
			}

		}
		
		map.put(s, false);
		return false;
	}

}
