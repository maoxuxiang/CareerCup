package Hard;

import java.util.Random;

/**
 * Implement the perfect random shuffle of the (52) cards. 
 *
 */
// O(n) space, O(n) time
public class q2 {
	
	public static void shuffle(int[] cards) {

		Random rnd = new Random();
		for (int i=0; i < cards.length; i++) {
			int k = rnd.nextInt(i);
			int tmp = cards[k];
			cards[k] = cards[i];
			cards[i] = tmp;
		}
		
	}
	

}
