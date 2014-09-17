package Moderate;

/**
 * Write a function to swap two numbers in place (that is, without temporary
 * variables).
 * 
 */

public class q1 {
	
	public static void swap(int a, int b) {
		a = a - b;
		b = b + a;
		a = b - a;
		
		System.out.println("a: " + a );
		System.out.println("b: " + b );
	}
	
	public static void main(String[] args) {
		swap(1,2);
	}

}
