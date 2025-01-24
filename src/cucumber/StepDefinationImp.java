package cucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shoppingcart.pageobjects.CartPage;
import shoppingcart.pageobjects.CheckOutOrderPage;
import shoppingcart.pageobjects.ConfirmationPage;
import shoppingcart.pageobjects.LandingPage;
import shoppingcart.pageobjects.ProductCatalog;
import shoppingcart.test.BaseTest;

public class StepDefinationImp extends BaseTest {
	
	LandingPage landingpage;
	ProductCatalog catalog;
	ConfirmationPage confirm;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingpage=launchApplication();
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username,String password)
	{
		catalog=landingpage.Login(username, password);
	}
	
	@When("^I add the Product  (.+) to cart$")
    public void I_add_the_product_to_the_cart(String productname)
    {
		System.out.println(productname);
		List<WebElement> products=catalog.getProductList();
		catalog.addProductToCart(productname);
    }
	
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productname)
	{
		System.out.println(productname);
		CartPage cart=catalog.gotoCart();
		cart.getCartProducts();
		Boolean match=cart.checkIfProductPresentInCart(productname);
		Assert.assertTrue(match);
		CheckOutOrderPage checkout=cart.gotoCheckout();
		checkout.selectCountry("India");
		confirm=checkout.placeOrder();
	}
	
	@Then("{string} message is displayed on the confirmation page")
	public void message_is_displayed_on_the_confirmation_page(String string)
	{
		String ordermessage=confirm.getPlacedOrderMessage();
		
		AssertJUnit.assertEquals(ordermessage,string);
		closeBrowser();
	}
	
	 @Then("{string} message is displayed")
	    public void incorrectEmailOrPasswordMessageIsDisplayed(String expectedMessage) {
	       // String expectedMessage = "Incorrect email or password.";
	        System.out.println("Validating the error message...");
	        
	      //  home.Login("testselenium@gmailtest.com", "Test@140");
	    	String errormessage=landingpage.getErrorMessage();
	    	
	        // Assertion to validate the error message
	        Assert.assertEquals(expectedMessage, errormessage);
}
}


