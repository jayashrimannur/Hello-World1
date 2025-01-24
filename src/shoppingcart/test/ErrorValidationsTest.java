package shoppingcart.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingcart.pageobjects.CartPage;
import shoppingcart.pageobjects.CheckOutOrderPage;
import shoppingcart.pageobjects.ConfirmationPage;
import shoppingcart.pageobjects.ProductCatalog;

public class ErrorValidationsTest extends BaseTest{
	@Test(groups={"ErrorHandling"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException {
	//LandingPage home=launchApplication();
	home.Login("testselenium@gmailtest.com", "Test@140");
	String errormessage=home.getErrorMessage();
	Assert.assertEquals(errormessage, "Incorrect email or password.");
	}
	
	@Test(groups={"ErrorHandling Second"})
	public void productErrorValidation() throws InterruptedException, IOException {
		//LandingPage home=launchApplication();
		ProductCatalog catalog=home.Login("samplet@test.com", "Sample@1405");
		
		String product="BANARSI SAREE";
		//List<WebElement> products=catalog.getProductList();
		//WebElement selectedProduct=catalog.getProductByName(product);
		catalog.addProductToCart(product);
		
		CartPage cart=catalog.gotoCart();
		cart.getCartProducts();
		Boolean match=cart.checkIfProductPresentInCart("ZARA COAT ");
		Assert.assertFalse(match);
		}
		
	

}
