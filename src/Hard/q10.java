package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words of equal length that are in a dictionary, write a method to
 * Transform one word into another word by changing only one letter at a time.
 * The new word you get in each step must be in the dictionary. EXAMPLE Input:
 * DAMP, LIKE Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
 * 
 */
// O(n) space, O(n) time
public class q10 {
	
	public static LinkedList<String> transform(String start, String end, Set<String> dictionary) {
		
		start = start.toUpperCase();
		end = end.toUpperCase();
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		Map<String, String> backTrack = new HashMap<String, String>();
		
		queue.add(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			String w = queue.poll();
			
			for (String v: getOneEditWords(w)) {
				if (v.equals(end)) {
					LinkedList<String> res = new LinkedList<String>();
					
					res.add(v);
					if (w != null) {
						res.add(0,w);
						w = backTrack.get(w);
					}
					return res;
				}
				
				if (dictionary.contains(v)) {
					if (!visited.contains(v)) {
						visited.add(v);
						queue.add(v);
						backTrack.put(v, w);
					}
				}
			}
			
			
		}
		return null;
	}
	
	private static Set<String> getOneEditWords(String s) {
		Set<String> res = new HashSet<String>();
		
		for (int i=0; i<s.length(); ++i) {
			char[] word = s.toCharArray();
			for (char c='A'; c<='Z'; ++c) {
				if (s.charAt(i) != c) {
					word[i] = c;
					res.add(new String(word));
				}
			}
		}
		return res;
 	}

}
