package shoppingcart.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.utilities.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;

	@FindBy(css=".totalRow .btn-primary")
	WebElement checkout;
	
	public List<WebElement> getCartProducts()
	{
		return cartproducts;
	}

	public Boolean checkIfProductPresentInCart(String product)
	{
		return getCartProducts().stream().anyMatch(s->s.getText().contains(product));
	}
	
	public CheckOutOrderPage gotoCheckout()
	{
		Actions actions = new Actions(driver);
		actions.scrollToElement(checkout).perform();
		checkout.click();
		CheckOutOrderPage checkout=new CheckOutOrderPage(driver);
		return checkout;
	}

	
	
}
