package Moderate;

import java.util.Hashtable;

/**
 *Design a method to find the frequency of occurrences of any given word in a book
 */
public class q9 {
	
	Hashtable<String, Integer> setupDictionary(String[] book) {
		
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		
		for(String word: book) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (!table.containsKey(word)) {
					table.put(word, 1);
				}
				table.put(word, table.get(word)+1);
			}
			
		}
		return table;
	}
	
	public static int getFrequency(Hashtable<String, Integer> table, String word) {
		if (table == null || word == null) {
			return -1;
		}
		
		word = word.toLowerCase();
		if (table.contains(word)) {
			return table.get(word);
		}
		
		return 0;
	}

}
