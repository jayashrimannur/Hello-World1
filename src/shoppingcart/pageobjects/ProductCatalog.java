package shoppingcart.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.utilities.AbstractComponents;

public class ProductCatalog extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".col-sm-10")
	List<WebElement> products;
	
	
	
   By products1=By.cssSelector(".col-sm-10");
   By addcart=By.cssSelector(".card-body .fa-shopping-cart");
   By toastmess=By.cssSelector(".toast-message");
   
   
   
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(products1);
		return products;
	}
	
	public WebElement getProductByName(String product)
	{
		WebElement selectedProduct=getProductList().stream().filter(s->s.getText().contains(product))
				.findFirst().orElse(null);	
		return selectedProduct;
	}
	
	public void addProductToCart(String product)
	{
		
		WebElement element=getProductByName(product).findElement(addcart);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		waitForElementToBeClickable(element);
		element.click();
		waitForElementToAppear(toastmess);
		waitForElementToDisAppear(driver.findElement(toastmess));
	}
}
