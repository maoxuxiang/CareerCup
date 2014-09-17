package Hard;

/**
 * Count the number of digit '2' within range of 0 to n.
 * 
 */
// O(1) space, O(d) time, where d is the length of number

public class q4 {
	
	//brute forth
	public static int numberof2In(int n) {
		int count = 0;
		for (int i=0; i<=n; i++) {
			count += numberOf2(i); 
		}
		return count;
	}
	
	private static int numberOf2(int i) {
		int count = 0;
		while (i > 0) {
			if (i % 10 == 2) {
				count ++;
			}
			i = i / 10;
		}
		return count;
	}
	
	//solution2
	public static int count2OfNum(int num) {
		int count = 0;
		int length = String.valueOf(num).length();
		
		for(int i=0; i<length; ++i) {
			count += count2OfDigit(num, i);
		}
	
		return count;
	}
	
	private static int count2OfDigit(int num, int b) {
		int powOf10 = (int)Math.pow(10, b);
		int nextPowOf10 = powOf10*10;
		
		int right = num % powOf10;
		
		int roundDown = num - num % nextPowOf10;
		int roundUp = roundDown + nextPowOf10;
		
		int digit = (num / powOf10) % 10;
		
		if ( digit < 2)
			return roundDown / 10;
		if (digit > 2)
			return roundUp / 10;
		else 
			return roundDown /10 + right +1;
	}
	
	public static void main(String[] args) {
	//	System.out.println(numberof2In(20888777));
		System.out.print(count2OfNum(20888777));
	}

}
