package testng_tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day4 {

	@Test(dataProvider="getData")
	public void webloginCarLoan(String username,String Pass)
	{
		System.out.println("webloginCarLoan test");
		System.out.println("username:"+username);
		System.out.println("password:"+Pass);
	}
	
	@Test(groups="Smoke")
	public void mobileloginCarLoan()
	{
		System.out.println("mobileloginCarLoan test");
	}
	
	@Test(timeOut=4000)
	public void apiloginCarLoan()
	{
		System.out.println("apiloginCarLoan test");
		Assert.assertTrue(false);
	}
	
	@BeforeMethod
	
	public void beforeMethod()
	{
		System.out.println("Before method need to execute before every test in Day4 class");
	}
	
@AfterMethod
	
	public void afterMethod()
	{
		System.out.println("After method need to execute after every test in Day4 class");
	}
	

@DataProvider
public Object getData()
{
	Object data[][]=new Object[3][2];
	data[0][0]="Username1";
	data[0][1]="Password1";
	
	data[1][0]="Username2";
	data[1][1]="Password2";
	
	data[2][0]="Username3";
	data[2][1]="Password3";
	
	return data;
	
	
}

}


