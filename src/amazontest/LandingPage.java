package amazontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.pageobjects.ProductCatalog;

public class LandingPage {
WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

public LandingPagebyteam2(WebDriver driver)
	{
		//super(driver);
		System.out.println("new branch update");
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="ap_email_login")
	WebElement userEmail;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtn;
	
	@FindBy(id="ap_password")
	WebElement userPassword;
	
	@FindBy(id="signInSubmit")
	WebElement loginbtn;
	
	public void Login(String username,String pass)
	{
		userEmail.sendKeys(username);
		continueBtn.click();
		userPassword.sendKeys(pass);
		loginbtn.click();
		
	}
	
	public void gotoHome(String url)
	{
		driver.get(url);
	}

}
