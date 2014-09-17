package RecursionAndDP;

public class f {
	public static void main(String args[]) {  
        char s = 34;  
        String a = "public class SelfPrint {public static void main(String args[]) {char s = 34; String a = %s;System.out.printf(a, s+a+s);}}//一段打印自身的代码";  
        System.out.printf(a, s + a + s);  
    }  
}
