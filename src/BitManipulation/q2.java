package BitManipulation;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a
 * double, print the binary representation. If the number cannot be represented
 * accurately in binary with less than 32 characters, print "ERROR".
 * 
 */
// O(n) space, O(n) time
public class q2 {
	
	public static String PrintBinary(double num) {
		if (num > 1 || num < 0) {
			return "ERROR";
		}
		
		StringBuilder s =  new StringBuilder();
		s.append(".");
		while(num > 0) {
			
			if (s.length() > 32) {
				return "ERROR";
			}
		
			num = 2 * num;
			if (num >= 1) {
				s.append("1");
				num -= 1; 
			}
			
			else if (num < 1) {
				s.append("0");
			}
		}
		return s.toString();
	}

}
