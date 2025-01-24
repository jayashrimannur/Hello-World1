package seleniumpractice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LocatorPrac {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriver driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement w=driver.findElement(By.linkText("Forgot your password?"));
		String name="Jayashri";
		w.click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jmannur@gmail.com");
		//driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		//driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("jmannur@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String Message=driver.findElement(By.cssSelector("form p")).getText();
		LocatorPrac l=new LocatorPrac();
		String pass=l.getPassword(Message);
		//Element Click intercepted exception...org.openqa.selenium.ElementClickInterceptedException:
			System.out.println(Message);
			driver.findElement(By.cssSelector(".go-to-login-btn")).click();
			driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
			driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys(pass);
			Thread.sleep(1000);
			driver.findElement(By.id("chkboxTwo")).click();
			
			driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//div[@class='login-container']/p")).getText();
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(),"You are successfully logged in.");
			Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Hello "+name+",");
			
		
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			Thread.sleep(1000);
			driver.close();
	}

	public String getPassword(String Message)
	{
		
		String[] s=Message.split(" ");
		String[] pass=s[4].split("'");
		System.out.println("Password:"+pass[1]);
		return pass[1];
	}
}
