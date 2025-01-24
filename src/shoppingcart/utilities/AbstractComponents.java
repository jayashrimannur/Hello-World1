package shoppingcart.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shoppingcart.pageobjects.CartPage;
import shoppingcart.pageobjects.OrderPage;

public class AbstractComponents {
	
WebDriver driver;


	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;

	@FindBy(css="button[routerlink*='myorders']")
	WebElement order;

	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void waitForElementToAppear(By element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}
	
	public void waitForWebElementToAppear(WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementToDisAppear(WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage gotoCart()
	{
		Actions actions = new Actions(driver);
		actions.scrollToElement(cart).perform();
		cart.click();
		CartPage cart=new CartPage(driver);
		return cart;
	}
	
	
	public OrderPage gotoOrder()
	{
		Actions actions = new Actions(driver);
		actions.scrollToElement(order).perform();
		order.click();
		OrderPage ord=new OrderPage(driver);
		return ord;
	}
	
		
	
}
	
