package seleniumpractice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//div[@id='start'] //button")).click();
		Wait<WebDriver> fw=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement element = fw.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = driver.findElement(By.xpath("//div[@id='finish'] /h4"));
                if (el.isDisplayed()) {
                    System.out.println("Element is visible.");
                    return el;  // Condition is met, return the element
                } else {
                    System.out.println("Waiting for the element to appear...");
                    return null;  // Keep waiting if the condition is not satisfied
                }
            }
        });
		

	}

}
