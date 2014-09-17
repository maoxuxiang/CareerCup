package Hard;
/**
 * You have a large text file containing words. Given any two words, find the
 * shortest distance (in terms of number of words) between them in the file. Can
 * you make the searching operation in O(1) time? What about the space
 * complexity for your solution?
 * 
 */
// O(1) space, O(n) time
public class q5 {
	
	public static int findMinDis(String[] words, String s1, String s2) {
		int dis = Integer.MAX_VALUE;
		int s1FirstTime = -1;
		int s2FirstTime = -1;
		
		for (int i=0; i<words.length; i++) {
			if (words[i] == s1) {
				s1FirstTime = i;

				int dis2 = s1FirstTime - s2FirstTime;
				if (dis2 < dis && s2FirstTime >= 0) {
					dis = dis2;
				}
			}
			
		}
		
		for (int i=0; i<words.length; i++) {
			if (words[i] == s2) {
				s2FirstTime = i;

				int dis2 = s2FirstTime - s1FirstTime;
				if (dis2 < dis && s1FirstTime >= 0) {
					dis = dis2;
				}
			}
			
		}
		
		return dis;
	}

}
