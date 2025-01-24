package testng_tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {
	
	

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This test should run first before all the methods in class Day1");
	}
	
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("This test should run  after all the methods in class Day1");
	}
	
	
	@BeforeTest
	public void prerequist()
	{
		System.out.println("This test should run first before all the tests");
	}
	
	@Parameters({"URL"})
	@Test
	public void firsttest(String url)
	{
		System.out.println("First test:"+url);
	}
	

	@Test
	public void secondtest()
	{
		System.out.println("Second test");
	}
	
	

}
