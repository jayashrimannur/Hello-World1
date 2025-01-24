package TestJavaBasics;

public class GenerateOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="a2b3c4";
		for(int i=0;i<s.length();i++)
		{
			//char a;
			if (!(Character.isAlphabetic(s.charAt(i))))
			{
				//a=s.charAt(i);
			//else
			//{
			//	System.out.println(s.charAt(i));
				
				int count=Character.getNumericValue(s.charAt(i));
			//	System.out.println("count="+count);
				for(int j=0;j<count;j++)
					System.out.print(s.charAt(i-1));
				//break;
			}
		}
				
	}

}
