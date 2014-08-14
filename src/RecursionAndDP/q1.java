package RecursionAndDP;
/*
 * A man is running up a staircase with n steps, and can go either 1 steps, 2 steps, 
 * or 3 steps at a time.Now write a program to count how many possible ways 
 * the child can run the stairs.
 */

public class q1 {
	
	public static int countWays(int n, int[] map) {
		
	//	map = new int[n];
		
		if (n<0) {
			return 0;
		}
		else if (n == 0) {
			return 1;
		}
		
		else if (map[n] >= 1) {
			return map[n];
		}
		else
			map[n] = countWays(n-1, map) + countWays(n-2, map) + countWays(n-3, map);
		return map[n];
		
	}
	
	public static void main (String[] args) {
		int n = 1;
		int[] map = new int[n+1];
		System.out.print(countWays(n, map));
	}

}
