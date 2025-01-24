package shoppingcart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.utilities.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	@FindBy(css=".toast-message")
	WebElement errormessage;
	
	
	public ProductCatalog Login(String username,String pass)
	{
		userEmail.sendKeys(username);
		userPassword.sendKeys(pass);
		loginbtn.click();
		ProductCatalog catalog=new ProductCatalog(driver);
		return catalog;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errormessage);
		return errormessage.getText();
	}
	
	public void gotoHome(String url)
	{
		driver.get(url);
	}

}
