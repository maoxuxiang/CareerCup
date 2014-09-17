package Moderate;
/**
 * Design an algorithm to figure out if someone has won a game of tic-tac-toe.
 * The input is a NxN board with type char[][], where '.' denotes the slot that
 * has not been occupied, '+' denotes the slot that is occupied by player 1, and
 * '-' denotes the slot that is occupied by player 2.
 * 
 */
// O(1) space, O(n) time
public class q2 {
	
	public static boolean won (char[][] board) {
		if (checkDiagonal(board) || checkCounterDiagonal(board)) {
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			if (checkRow(i, board) || checkCol(i, board)) {
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean checkDiagonal (char[][] board) {
		char type = board[0][0];
		
		for (int i = 1; i<board.length; i++) {
			if (board[i][i] != type ) {
				return false;
			}
		}
		
		if (type != '.') {
			return true;
		}
		return false;
	}
	
	private static boolean checkCounterDiagonal (char[][] board) {
		char type = board[0][board.length-1];
		
		for (int i = 1; i<board.length; i++) {
			if (board[i][board.length-1-i] != type ) {
				return false;
			}
		}
		
		if (type != '.') {
			return true;
		}
		return false;
	}
	
	private static boolean checkRow (int a, char[][] board) {
		
		for (int i = 0; i < board.length - 1; i++) {
			if (board[a][i] != board[a][i +1]) {
				return false;
			}
		}
		
		if (board[a][0] != '.') {
			return true;
		}
		
		return false;
	}

	private static boolean checkCol (int a, char[][] board) {
		
		for (int i = 0; i < board.length - 1; i++) {
			if (board[i][a] != board[i+1][a]) {
				return false;
			}
		}
		
		if (board[0][a] != '.') {
			return true;
		}
		
		return false;
	}

}
