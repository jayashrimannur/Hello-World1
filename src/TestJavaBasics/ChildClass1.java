package TestJavaBasics;

public class ChildClass1 extends ChildClass2 {
	
	int a;
	
	public ChildClass1(int a)
	{
		
		super(a);
		this.a=a;
	}
	
	public int increment()
	{
		a=a+1;
		return a;
	}
	
	public int decrement()
	{
		a=a+1;
		return a;
	}

	
}
