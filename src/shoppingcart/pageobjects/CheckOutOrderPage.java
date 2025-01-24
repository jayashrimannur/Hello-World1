package shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.utilities.AbstractComponents;

public class CheckOutOrderPage extends AbstractComponents {
	WebDriver driver;
	
	public CheckOutOrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="input[placeholder*='Country']")
	WebElement country;
	
	@FindBy(css=".ta-results .ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	

	public void selectCountry(String countryname)
	{
		country.sendKeys(countryname);
		selectcountry.click();
	}
	
	public ConfirmationPage placeOrder()
	{
		Actions actions = new Actions(driver);
		actions.scrollToElement(placeorder).perform();
		placeorder.click();
		ConfirmationPage confirm=new ConfirmationPage(driver);
		return confirm;
	}
	
	
}
