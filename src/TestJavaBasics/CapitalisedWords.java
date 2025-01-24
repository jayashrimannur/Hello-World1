package TestJavaBasics;

public class CapitalisedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="RahulShettyAcademyWebsite";
		int count=0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)>='A' && s.charAt(i)<='Z')
				count++;
		System.out.println(count);
	}

}
