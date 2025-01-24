package TestJavaBasics;

public class ParentClass {
	public void test1PureParent()
	{
		System.out.println("Test1 In Parenetclass");
	}
	
	public void testCommonMethod()
	{
		System.out.println("Test In Parenetclass");
	}
	
	public void CommonCalMethod(String s)
	{
		System.out.println("Test In Parenetclass"+s);
	}
	
	public static void main(String[] args)
	{
		ChildClass1 cs=new ChildClass1(3);
		System.out.println(cs.increment());
		System.out.println(cs.decrement());
		System.out.println(cs.mulbythree());
		System.out.println(cs.mulbytwo());
	}

}
