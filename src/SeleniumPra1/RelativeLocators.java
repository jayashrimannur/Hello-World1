package SeleniumPra1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditbox=driver.findElement(By.name("name"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		WebElement dateofbirth=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofbirth)).click();
		
		WebElement exampleCheck=driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(exampleCheck)).click();
		
		WebElement radio=driver.findElement(By.id("inlineRadio2"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
	}

}
