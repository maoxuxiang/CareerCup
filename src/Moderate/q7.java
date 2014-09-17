package Moderate;
// give any integer, print english phrase.
public class q7 {
	
	public static String[] digits = {"one","two","three","four","five","six","seven","eight","nine" };
	public static String[] teens = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","selventeen"};
	public static String[] tens = {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
	public static String[] bigs = {"","thousand","million"};
	
	public static String numToString(int num) {
		if (num == 0) {
			return "zero";
		}
		
		if (num < 0) {
			return "negtive" + numToString(-1*num);
		}
		
		String str = "";
		int count = 0;
		
		while (num > 0) {
			if (num % 1000 != 0) {
				str = numToString100(num % 1000) + bigs[count] + " " + str;
			}
			count ++;
			num = num / 1000;
		}
		
		return str;
	}
	
	// convert the number less than 100
	public static String numToString100(int num) {
		String str = "";
		
		if (num >= 100) {
			str = str + digits[num/100 - 1] + " hundred ";
			num = num % 100;
		}
		if (num >= 11 && num <= 19) {
			str = str + teens[num - 11] +" ";
		}
		else if (num == 10 || num >=20) {
			str = str + tens[num / 10 - 1] + " ";
			num = num % 10;
		}
		if (num >=1 && num <= 9) {
			str = str + digits[num - 1] + " ";
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		String s = numToString(19323984);
		System.out.print(s);
	}

}
