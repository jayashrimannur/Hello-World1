package seleniumpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JavascriptExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement>tablevalues= driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		int sum=0;
		for(int i=0;i<tablevalues.size();i++)
		{
			sum=sum+Integer.parseInt(tablevalues.get(i).getText());
		}
		System.out.println(sum);
		String s=driver.findElement(By.cssSelector(".totalAmount")).getText();
		System.out.println(Integer.parseInt(s.split(" ")[3]));
	}

}
