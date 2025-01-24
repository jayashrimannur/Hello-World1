package TestJavaBasics;

public class ChildClass extends ParentClass{
	
	public void test2PureChild()
	{
		System.out.println("Test2 under Childclass");
		System.out.println("Calling test1 from Parent class using Super keyword");
		super.test1PureParent();
	}

	public void testCommonMethod()
	{
		System.out.println("Test under Childclass");
	}
	
	public void CommonCalMethod(int s)
	{
		System.out.println("Test In childclass"+s);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParentClass obj=new ChildClass();
		obj.test1PureParent();//Parent Oject No Test1 in childclass so will call parent class
		obj.testCommonMethod();//Parent Object Have test in both classes..so will call overridden method from child
		((ChildClass) obj).CommonCalMethod(1);
		
		//((ChildClass) obj).test1();
		
		ChildClass c= new ChildClass();
		c.test1PureParent();//childclass object calling parentclass method as no overridden method
		c.test2PureChild();//childclass object calling childclass method
		((ParentClass) c).testCommonMethod();//Childclass Object Have test in both classes..so will call overridden method from child
		c.CommonCalMethod("HHHH");
		c.CommonCalMethod(2);
		
		//downcasting
		
		ParentClass child=new ChildClass();
		
		ChildClass child1=(ChildClass)child;
		child1.testCommonMethod();
		child.CommonCalMethod("hhh");
		
		
	}

}
