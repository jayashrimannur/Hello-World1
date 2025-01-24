package seleniumpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortUsingStream {

public static void main(String[] args) throws InterruptedException 
{
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// "//table[contains(@class,'table')]  //tr[1] //th[1]"
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement>fruits=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originallist=fruits.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedlist=fruits.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		Assert.assertTrue(originallist.equals(sortedlist));
		
		String itemprice="Wheat";
		List<String>price;
		do
		{
			
		price=fruits.stream().filter(s->s.getText().contains(itemprice)).map(s->getPrice(s)).collect(Collectors.toList());	
		//Thread.sleep(2000);
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			fruits=driver.findElements(By.xpath("//tr/td[1]"));
		}
		
		}while(price.size()<1);
		price.forEach(s -> System.out.println(s));
}




public static String getPrice(WebElement w)
{
	return w.findElement(By.xpath("following-sibling::td[1]")).getText();
	
}
}