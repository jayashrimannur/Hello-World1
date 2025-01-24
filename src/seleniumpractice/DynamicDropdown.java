package seleniumpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='AIP']")).click();
		Thread.sleep(1000);
		//ElementNotVisible exception when two elements exists for one xpath and
		//selenium tries to find the first one 
		//which is not visible on the screen now
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		//driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DEL']")).click();
		//when NoSuchElementException , means xpath itself is wrong
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
		List<WebElement> cl=driver.findElements(By.cssSelector("input[type='checkbox']"));
		cl.get(2).click();
		System.out.println(cl.get(2).isSelected());
		driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();
		

	}

}
