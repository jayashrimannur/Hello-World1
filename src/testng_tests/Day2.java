package testng_tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day2 {
	
	@Test
	public void thirdtest()
	{
		System.out.println("Third test");
	}
	
	@AfterTest
	public void LastTest()
	{
		System.out.println("this test shold run at the end");
	}
	

}
