package TestJavaBasics;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="RahulShettyAcademy";
		String s1="";
		for(int i=s.length()-1;i>=0;i--)
		{
			s1=s1+s.charAt(i);
		}
		System.out.println(s1);
		System.out.println(new StringBuilder(s).reverse().toString());
	}

}
