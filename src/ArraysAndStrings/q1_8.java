package ArraysAndStrings;

/*
 * Write a method if you have isSubstring which checks if one word is a substring of another.
 */

public class q1_8 {
	
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			
			return isSubstring(s1s1, s2);
		}
		return false;
	}

	private boolean isSubstring(String s1s1, String s2) {

		return false;
	}

}
