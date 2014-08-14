package ArraysAndStrings;
/*
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string.
 */

public class q1_5 {
	// way 1
	String compressBetter(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i=1; i<str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}
	
	int countCompression(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char last = str.charAt(0);
		int count = 1;
		int size = 0;
		
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == last) {
				count ++;
			}
			else {
				last = str.charAt(i);
				size = 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		
		size = 1 + String.valueOf(count).length();
		return size;
	}
	
	// way 2 won't use StringBuffer  o(n)time and o(n)space
	
	String compressAlternate(String str) {
		int size = countCompression(str);
		if(size > str.length())
			return str;
		
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		
		for (int i=1; i<str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			}
			else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		
		index = setChar(array, last, index, count);
		return String.valueOf(array);
		
	}
	
	int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index ++;
		
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x: cnt) {
			array[index] = x;
			index ++;
		}
		return index;
	}

}
