package seleniumpractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CartBase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    String[] names= {"Cucumber","Brocolli","Beetroot","Beans"};
		List<WebElement> prod=driver.findElements(By.cssSelector(".product-name"));
		for(int i=0;i<prod.size();i++)
		{
			//To check if the names needed are present in the product list or not
			//if present add to the cart
			List items=Arrays.asList(names);
			//System.out.println(prod.get(i).getText().split(" ")[0]);
			//for(int j=0;j<names.length;j++)
			//{
			int j=0;
				if(items.contains(prod.get(i).getText().split(" ")[0]))
				{
					System.out.println(prod.get(i).getText().split(" ")[0]);
			//	if (prod.get(i).getText().contains(names[j])) {
					//Thread.sleep(2000);
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					if(names.length==j)
						break;
					//break;
				}
			//}
		}
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//org.openqa.selenium.NoSuchElementException because of synchronization issue
		driver.findElement(By.cssSelector(".promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".promoInfo"))));
		
		driver.findElement(By.cssSelector(".promoInfo")).getText().equals("Code applied ..!");
		//org.openqa.selenium.InvalidSelectorException:if you are using cssselector method and passing xpath as argument
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement coun=driver.findElement(By.cssSelector(".wrapperTwo select"));
		Select country=new Select(coun);
		country.selectByVisibleText("India");
		driver.findElement(By.cssSelector(".chkAgree")).click();
		
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		
		
	}

}
