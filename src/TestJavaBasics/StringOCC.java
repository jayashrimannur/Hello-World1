package TestJavaBasics;

import java.util.ArrayList;

public class StringOCC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="Straberryrrarr";
		String sub="rr";
		int count=0;
		ArrayList l=new ArrayList();
		
		for(int i=0;i<s.length();i++)
		{
			String sample="";
			for(int j=i+1;j<=s.length();j++)
			{
				sample=s.substring(i, j);
				System.out.println(sample+i+" "+j);
				if(sample.equals(sub))
					count++;
				
			}
			
		}
		System.out.println(count);

	}

}
