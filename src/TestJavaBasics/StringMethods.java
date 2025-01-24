package TestJavaBasics;

public class StringMethods {
	public static void main(String[] args) {
		String s="Welcome to the Java World";
		String[] ss=s.split(" ");
		for(int i=0;i<ss.length;i++)
			System.out.println(ss[i]);
	}

}
