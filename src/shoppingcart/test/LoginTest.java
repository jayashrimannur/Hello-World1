package shoppingcart.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingcart.pageobjects.CartPage;
import shoppingcart.pageobjects.CheckOutOrderPage;
import shoppingcart.pageobjects.ConfirmationPage;
import shoppingcart.pageobjects.LandingPage;
import shoppingcart.pageobjects.OrderPage;
import shoppingcart.pageobjects.ProductCatalog;

public class LoginTest extends BaseTest {

	@Test(dataProvider="getInformation",groups= {"purchase order"})
	
	public void submitOrderTest(String email,String pass,String product) throws InterruptedException, IOException {
	//LandingPage home=launchApplication();
	ProductCatalog catalog=home.Login(email, pass);
	
	//String product="BANARSI SAREE";
	List<WebElement> products=catalog.getProductList();
	WebElement selectedProduct=catalog.getProductByName(product);
	catalog.addProductToCart(product);
	
	CartPage cart=catalog.gotoCart();
	cart.getCartProducts();
	Boolean match=cart.checkIfProductPresentInCart(product);
	Assert.assertTrue(match);
	
	CheckOutOrderPage checkout=cart.gotoCheckout();
	checkout.selectCountry("India");
	ConfirmationPage confirm=checkout.placeOrder();
	String ordermessage=confirm.getPlacedOrderMessage();
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertEquals(ordermessage,"THANKYOU FOR THE ORDER.");
	Assert.assertEquals(ordermessage,"THANKYOU FOR THE ORDER.");
	
	}
	
	
@Test(dataProvider="getJSONHashMap",groups= {"Hashmap purchase order"})
	
	public void submitOrderTest_updated(HashMap<String,String>input) throws InterruptedException, IOException {
	//LandingPage home=launchApplication();
	ProductCatalog catalog=home.Login(input.get("email"), input.get("pass"));
	
	//String product="BANARSI SAREE";
	List<WebElement> products=catalog.getProductList();
	//WebElement selectedProduct=catalog.getProductByName(input.get("product"));
	catalog.addProductToCart(input.get("product"));
	
	CartPage cart=catalog.gotoCart();
	//cart.getCartProducts();
	Boolean match=cart.checkIfProductPresentInCart(input.get("product"));
	Assert.assertTrue(match);
	
	CheckOutOrderPage checkout=cart.gotoCheckout();
	checkout.selectCountry("India");
	ConfirmationPage confirm=checkout.placeOrder();
	String ordermessage=confirm.getPlacedOrderMessage();
	
	Assert.assertEquals(ordermessage,"THANKYOU FOR THE ORDER.");
	//Assert.assertTrue(false);
	
	}

	
	@Test(dependsOnMethods= {"submitOrderTest"})
	
	public void orderHistoryTest() throws InterruptedException, IOException {
	
		ProductCatalog catalog=home.Login("testselenium@gmailtest.com", "Test@1405");
		OrderPage order=catalog.gotoOrder();
		Assert.assertTrue(order.checkIfProductPresentInOrder("BANARSI SAREE"));
		}	
	


	@DataProvider
	public Object[][] getInformation()
	{
		return new Object[][] {{"testselenium@gmailtest.com","Test@1405","BANARSI SAREE"},
			{"samplet@test.com", "Sample@1405","IPHONE 13 PRO"}};
		
	}

	
	@DataProvider
	public Object[][] getHashMap()
	{
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("email","testselenium@gmailtest.com");
		map.put("pass", "Test@1405");
		map.put("product", "BANARSI SAREE");
		
		HashMap<String,String>map1=new HashMap<String,String>();
		map1.put("email","samplet@test.com");
		map1.put("pass", "Sample@1405");
		map1.put("product", "IPHONE 13 PRO");
		return new Object[][] {{map},
			{map1}};
		
	}
	
	
	@DataProvider
	public Object[][] getJSONHashMap() throws IOException
	{
		List<HashMap<String,String>> data=getJSONtoHashmap("\\src\\shoppingcart\\resources\\input.json");
		return new Object[][] {{data.get(0)},
			{data.get(1)}};
		
	}
	}