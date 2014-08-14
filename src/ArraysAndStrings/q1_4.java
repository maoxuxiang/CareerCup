package ArraysAndStrings;
/*
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string 
 * has sufficient space at the end of the string to hold the additional characters, and that you
 * are givn the "true" length of the string. (Note: if implementing in Java, please use a character 
 * array so that you can perform this operation in place.)
 */

public class q1_4 {
	
	public static void main(String[] args) {
		String str = "i am mao";
		char[] temp = str.toCharArray();
		char[] s = new char[10000];
		
		int i = 0;
		while (i < temp.length) {
			s[i] = temp[i];
			i++;
		}
		
		s[i] = '\0';
		
		replaceSpaces(s, temp.length);
		System.out.println(s);
	}
	
	public static void replaceSpaces(char[] s, int length) {
		
		
		int spaceCount = 0, newLength, i;
		for (i=0; i<length; i++) {
			if(s[i] == ' ') {
				spaceCount ++;
			}
		}
		
		newLength = length + spaceCount*2;
//		char[] ss = new char[newLength];
		s[newLength] = '\0'; // '\0' is used to mark the end of the characters
		for (i = length - 1; i>=0; i--) {
			if (s[i]==' ') {
				s[newLength - 1]='0';
				s[newLength - 2]='2';
				s[newLength - 3]='%';
				newLength = newLength - 3;
			}
			else {
				s[newLength - 1] = s[i];
				newLength = newLength - 1;
			}
		}
//		return ss;
		
	}

}
