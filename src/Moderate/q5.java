package Moderate;
/** 
 * The Game of Master Mind is played as follows: 
 
The computer has four slots containing balls that are red (R ), 
yellow (Y), green (G) or blue (B). For example, the computer might have RGGB 
(e.g., Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue). 
 
You, the user, are trying to guess the solution. 
You might, for example, guess YRGB.When you guess the correct color for the correct slot, 
you get a ¡°hit¡±. If you guess a color that exists but is in the wrong slot, you get a ¡°pseudo-hit¡±. 
For example, the guess YRGB has 2 hits and one pseudo hit. 
 
For each guess, you are told the number of hits and pseudo-hits. 
Write a method that, given a guess and a solution, returns the number of hits and pseudo hits. 
*/

public class q5 {
	
	public static class Result {
		public int hits = 0;
		public int pseudoHits = 0;
		
		public String toString() {
			String s =  "hits =" + hits + " pseudoHits = " + pseudoHits;
			return s;
		}		
	}


	
	public static int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}
	
	public static int MAX_SLOTS = 4;
	
	public static Result estimate (String guess, String solution) {
		if (guess.length() != solution.length()) {
			return null;
		}
		
	    Result res = new Result(); 
	    int[] frequence = new int[MAX_SLOTS];
	    
		for (int i=0; i<guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				res.hits ++;
			} else {
				frequence[code(solution.charAt(i))] ++;
			}
		}
		
		for (int i =0; i<guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (guess.charAt(i) != solution.charAt(i)
					&& code >= 0 && frequence[code] >0) {
				res.pseudoHits ++;
				frequence[code] --;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s = estimate("RGBY", "GGRR").toString();
		System.out.print(s);
	}

}

