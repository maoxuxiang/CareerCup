package BitManipulation;
/*
 * You are given two 32-bit numbers, N and M, and two bit locations, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit
 * i. You can assume that the bits j through i have enough space to fit all of
 * M. That is, if M = 10011, you can assume that there are at least 5 bits
 * between j and i. You would not, for example, have j = 3 and i = 2, because M
 * could not fully fit between bit 3 and bit 2.
 * 
 * EXAMPLE Input: N = 10000000000, M = 10011, i = 2, j = 6 Output: N =
 * 1001001100
 */
// O(n) space, O(1) time
public class q1 {
	
	public static int updateBits(int n, int m, int i, int j) {
		int o = ~0;
		// create left mask 1111000
		int left = o<<(j+1);
	//	System.out.print(left);
		// create right mask 00000111
		int right = (1<<i) - 1;
		
		//create mask
		int mask = left | right;
		int clear = n & mask;
		
		int changeM = m << i;
		return clear | changeM;

	}
	
	 public static int insert(int N, int M, int i, int j) {
		    int mask = ~0;
		    // clear bits
		    for (int b = i; b <= j; ++b) {
		      N &= ~(1 << b);
		    }
		    // set bits
		    N &= mask;
		    N |= M << i;
		    return N;
		  }
	
	public static void main(String[] args) {
		System.out.print(updateBits(1000000000, 10011, 2, 6));
	}

}
