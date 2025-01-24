package TestJavaBasics;

public class Palidrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="AMAa";
		StringBuilder s1=new StringBuilder();
		s1.append(s);
		//s1.reverse();
		String s2=""+s1.reverse();
		if(s.equals(s2))
			System.out.println("Palidrome");
		else
			System.out.println("Not Palidrome");
		
		
		
	}

}
