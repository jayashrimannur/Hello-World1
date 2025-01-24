package seleniumpractice;

import java.util.Iterator;
import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LinksCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Count no of links on the page
		System.out.println("Links count "+driver.findElements(By.tagName("a")).size());
		//limiting the webdriver scope
		WebElement we=driver.findElement(By.id("gf-BIG"));
		System.out.println("Links count on footer section: "+we.findElements(By.tagName("a")).size());
		
		//Find links in the first column of the footer section
		WebElement firstcolumn=we.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("First column links: "+firstcolumn.findElements(By.tagName("a")).size());
		
		for(int i=0;i<firstcolumn.findElements(By.tagName("a")).size();i++)
		{
			String combKeys=Keys.chord(Keys.CONTROL,Keys.ENTER);
			firstcolumn.findElements(By.tagName("a")).get(i).sendKeys(combKeys);
			
			Thread.sleep(2000);
			
		}
		
		Set<String>wh=driver.getWindowHandles();
		Iterator<String>it=wh.iterator();
		//Iterator<String>it=s.iterator();
		for(int i=0;i<wh.size();i++)
		{
			System.out.println(driver.switchTo().window(it.next()).getTitle());
			
		}
		
		
		
	}

}
