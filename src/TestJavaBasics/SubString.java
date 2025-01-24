package TestJavaBasics;

import java.util.ArrayList;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Straberryrr";
		ArrayList<String> names=new ArrayList<String>();
		String sub="rr";
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				System.out.println(s.substring(i,j));
				names.add(s.substring(i,j));
				if(sub.equals(s.substring(i,j)))
					count++;
			}
		}
		System.out.println(count);
		System.out.println(names.stream().filter(a->a.equals(sub)).count());
		//System.out.println(s.length()-s.replaceAll(sub,"").length());
		//System.out.println(s.length());
		//System.out.println(s.replaceAll(sub, "").length());
		
		CharSequence cs= sub;
		System.out.println(s.contains(cs));
		ArrayList<Character> l=new ArrayList<Character>();
		char[] c=s.toCharArray();
		
		l.add(c[0]);
		l.add(c[1]);
		System.out.println(l);
	}

}
