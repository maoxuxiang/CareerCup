package Moderate;

import java.util.Random;

/**
 * Implement a method rand7() given rand5(). That is, given a method that
 * generates a random number between 0 and 4 (inclusive), write a method that
 * generates a random number between 0 and 6 (inclusive).
 * 
 */

public class q11 {
	
	private static Random rnd = new Random();
	
	public static int rand5() {
		return rnd.nextInt(5);
	}
	
	public static int rand7() {

		while (true) {
			int num = 5*rand5() + rand5();
			if (num < 21) {
				return num % 7;
			}
		}
	}

}
