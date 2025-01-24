package shoppingcart.test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://rahulshettyacademy.com/client");
	driver.manage().window().maximize();
	driver.findElement(By.id("userEmail")).sendKeys("testselenium@gmailtest.com");
	driver.findElement(By.id("userPassword")).sendKeys("Test@1405");
	
	driver.findElement(By.id("login")).click();
	
	String product="BANARSI SAREE";
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-sm-10")));
	List<WebElement> products=driver.findElements(By.cssSelector(".col-sm-10"));
	int i=0;
	/*do {
		if(products.get(i).getText().contains("BANARSI SAREE"))
		{
			System.out.println("Clickd button"+products.get(i).getText());
			products.get(i).findElement(By.xpath("//button[text()=' Add To Cart']")).click();
				break;
		}
		else
		{
			System.out.println(products.get(i).getText());
			i++;
		}
		
	}while(i<products.size());
	*/
	WebElement selectedProduct=products.stream().filter(s->s.getText().contains(product))
			.findFirst().orElse(null);
	
	//System.out.println(selectedProduct.size());
	System.out.println(selectedProduct.getText());
	WebElement element=selectedProduct.findElement(By.cssSelector(".card-body .fa-shopping-cart"));
	Actions actions = new Actions(driver);
	actions.moveToElement(element).perform();
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	//Thread.sleep(5000);
	//element.click();
	
	wait.until(ExpectedConditions.elementToBeClickable(element));
	/*wait.until(new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript(
                "return document.readyState").toString().equals("complete");
        }
    });*/
	//waitForScrollToFinish(driver);
	
	try {
        // Try clicking the element
        element.click();
    } catch (ElementClickInterceptedException e) {
        System.out.println("ElementClickInterceptedException caught. Retrying with JavaScript click.");
        
        // Retry clicking using JavaScript if the exception occurs
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".toast-message")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-message"))));
	
	
	
	String product1="IPHONE 13 PRO";
	selectedProduct=products.stream().filter(s->s.getText().contains(product1))
			.findFirst().orElse(null);
	System.out.println(selectedProduct.getText());
	element=selectedProduct.findElement(By.cssSelector(".card-body .fa-shopping-cart"));
	actions = new Actions(driver);
	actions.moveToElement(element).perform();
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();
	
	
	//element.click();
	//selectedProduct.findElement(By.cssSelector(".card-body .fa-shopping-cart")).click();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".toast-message")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-message"))));
	//driver.findElement(By.cssSelector(".btn-custom .fa-shopping-cart")).click();
	actions.scrollToElement(driver.findElement(By.cssSelector("button[routerlink*='cart']"))).perform();
	driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	
	List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match=cartproducts.stream().anyMatch(s->s.getText().contains(product));
	Assert.assertTrue(match);
	actions.scrollToElement(driver.findElement(By.cssSelector(".totalRow .btn-primary"))).perform();
	driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();
	driver.findElement(By.cssSelector("input[placeholder*='Country']")).sendKeys("India");
	driver.findElement(By.cssSelector(".ta-results .ta-item:nth-of-type(2)")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
	Assert.assertTrue(driver.findElement(By.cssSelector(".hero-primary")).getText().equalsIgnoreCase("Thankyou for the order."));
	
	
	}
	
	 private static void waitForScrollToFinish(WebDriver driver) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Define WebDriverWait with a timeout
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        Object scrollY = js.executeScript("return window.pageYOffset;");
	        System.out.println("ScrollY Value: " + scrollY);
	        System.out.println("ScrollY Type: " + scrollY.getClass().getName());
	        // Wait until the scroll position is stable
	        wait.until(driver1 -> {
	        	Long lastScrollY = (Long) js.executeScript("return window.pageYOffset;");
	            try {
	                Thread.sleep(200); // Short delay to detect motion
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            Object scrollx = js.executeScript("return window.pageYOffset;");
	            System.out.println("ScrollY Value: " + scrollx);
		        System.out.println("ScrollY Type: " + scrollx.getClass().getName());
	            Long currentScrollY = (Long) js.executeScript("return window.pageYOffset;");
	            return lastScrollY.equals(currentScrollY); // Check if scroll position is stable
	        });
	    }
}
