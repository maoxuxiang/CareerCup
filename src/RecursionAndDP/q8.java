package RecursionAndDP;
/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5
 * cents) and pennies (1 cent), write code to calculate the number of ways of
 * representing n cents.
 * 
 */
public class q8 {
	
	private static int makeChange(int num, int[] denoms, int index) {
		
		if (index == denoms.length - 1) {
			return 1;
		}
		int ways = 0;
		for (int i=0; i*denoms[index] <= num; i++) {
			int restNum = num - i*denoms[index];
			ways += makeChange(restNum, denoms, index + 1);
		}
		
		return ways;
		
	}
	
	public static int makeChange(int num) {
		int[] denoms = {25, 10, 5, 1};
		return makeChange(num, denoms, 0);
	}
	
	public static void main(String[] args) {
		System.out.println(makeChange(10000));
	}
	
	// DP solution
	public static int makeDPChange(int num) {
		int[] denoms = {25, 10, 5, 1};
		int[][] map = new int[num+1][denoms.length];
		return makeDPChange(num, denoms, 0, map);
	}
	
	private static int makeDPChange(int num, int[] denoms, int index, int[][] map) {
		if (map[num][index] > 0) {
			return map[num][index];
		}
		
		if (index == denoms.length - 1) {
			return 1;
		}
		int ways = 0;
		for (int i=0; i*denoms[index] <= num; i++) {
			int restNum = num - i*denoms[index];
			ways += makeDPChange(restNum, denoms, index + 1, map);
		}
		
		map[num][index] = ways;
		return ways;
		
	}

}
