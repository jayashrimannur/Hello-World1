package testng_tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	
	@Test(enabled=false)
	public void webloginHomeLoan()
	{
		System.out.println("webloginHomeLOan test");
	}
	
	@Parameters({"URL"})
	
	@Test(enabled=false)
	public void weblogoutHomeLoan(String url)
	{
		System.out.println("weblogoutHomeLoan test:"+url);
	}
	
	@Test
	public void webfunctionHomeLoan()
	{
		System.out.println("webfunctionHomeLoan test");
	}
	
	@Test(groups="Smoke")
	public void mobileloginHomeLoan()
	{
		System.out.println("mobileloginHomeLoan test");
	}
	
	@Test(dependsOnMethods= {"webfunctionHomeLoan"})
	public void apiloginHomeLoan()
	{
		System.out.println("apiloginHomeLoan test");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Need to execute before suite test");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Need to execute after suite test");
	}
	
	

}
