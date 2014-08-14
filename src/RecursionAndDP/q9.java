package RecursionAndDP;

import java.util.ArrayList;

/**
 * Write an algorithm to print all ways of arranging eight queens on an 8x8
 * chess board so that none of them share the same row, column or diagona  mmm m ml. In
 * this cases, "diagonal" means all diagonals, not just the two that bisect the
 * board.
 */
public class q9 {
	
	static int SIZE = 8;
	
	public static void placeQueens(int[] columns, int row, ArrayList<int[]> result) {
		
		if (row == SIZE) {
			result.add(columns);
			for (int i=0; i<columns.length; i++) {
				System.out.print(columns[i]+" ");
				
			}
			System.out.println();
		}
		else {
			
			for (int col=0; col<SIZE; col++) {
				if (checkVaild(columns, row, col)) {
					columns[row] = col;
					placeQueens(columns, row+1, result);
				}
			}
		}
	}
	
	private static boolean checkVaild(int[] columns, int row, int col) {
		for (int row1=0; row1 < row; row1++) {
			int col1 = columns[row1];
			if (col1 == col) {
				return false;
			}
			if (Math.abs(col1-col) == Math.abs(row1 - row)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] columns = new int[SIZE];
		ArrayList<int[]> result = new ArrayList<int[]>();
		placeQueens(columns, 0, result);
		System.out.print(result.size());
	}

}
