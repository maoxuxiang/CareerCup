package ArraysAndStrings;

/* 1.1 Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data stru
 */
public class q1_1 {
	//way 1
	public boolean isUniqueChars2(String str) {
		if (str.length() > 256) 
			return false;
		boolean[] char_set = new boolean[256];
		for (int i=0; i<str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}
	
	//way2
	public boolean isUniqueChars(String str) {
		int checker = 0;
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker&(1<<val))>0)
				return false;
			checker |= (1<<val);
		}
		return true;
	}
}
