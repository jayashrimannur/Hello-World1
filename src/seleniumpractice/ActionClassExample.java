package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExample {
	public static void main(String[] args) {
		
	WebDriver driver = new EdgeDriver();
	driver.get("https://www.amazon.in/");
	WebElement we=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
	Actions a=new Actions(driver);
	a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
	.sendKeys("hello").doubleClick().build().perform();
	//Move to specific element
//	a.moveToElement(we).contextClick().build().perform();

}
}
