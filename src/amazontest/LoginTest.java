package amazontest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends BaseTest {
	
	
@Test
	
	public void submitOrderTest() throws InterruptedException, IOException {
	
	LandingPage home=launchApplication();
	
	String email="jmannur@gmail.com";
	String pass="Jayu^1405";
	home.Login(email, pass);
	
		
	}


/*public LandingPage launchApplication() throws IOException {
	initializeDriver();
	home=new LandingPage(driver);
	home.gotoHome("https://amazon.co.in");
	return home;
	}
*/
}
