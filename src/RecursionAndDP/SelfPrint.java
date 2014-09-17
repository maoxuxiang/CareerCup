package RecursionAndDP;


	public class SelfPrint {  
	    public static void main(String args[]) {  
	        char s = 34;    
	        char _r = 13;  
	        char _n = 10;  
	        char _ = 92;  
	        char r = 114;  
	        char n = 110;  
	        String str = new String();   
	        String a = "public class SelfPrint {\r\n    public static void main(String args[]) {\r\n        char s = 34;\r\n        char _r = 13;\r\n       char _n = 10;\r\n       char _ = 92;\r\n        char r = 114;\r\n       char n = 110;\r\n       String str = new String();\r\n      String a = %s;\r\n      System.out.printf(a, (s+a+s).replace(str+_r+_n, str+_+r+_+n));\r\n  }\r\n}//一段打印自身的代码";  
	        System.out.printf(a, (s+a+s).replace(str+_r+_n, str+_+r+_+n));  
	    }  
	}

