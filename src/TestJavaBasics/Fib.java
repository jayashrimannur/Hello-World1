package TestJavaBasics;

public class Fib {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0,j=1;i<10;)
		{
			System.out.println(i);
			int k=i+j;
			i=j;
			j=k;
		}
	}
}
