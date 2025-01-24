package TestJavaBasics;

public class WithoutLoop1to100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printnumber(1);

	}
	public static void printnumber(int number)
	{
		if(number<=100)
		{
			System.out.println(number);
			printnumber(number+1);
		}
		
	}

}
