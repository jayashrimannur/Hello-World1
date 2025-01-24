package shoppingcart.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingcart.utilities.AbstractComponents;

public class OrderPage extends AbstractComponents{


	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderproducts;

	
	public List<WebElement> getOrderProducts()
	
	{
		for(int i=0;i<orderproducts.size();i++)
			System.out.println(orderproducts.get(i).getText());
		return orderproducts;
	}

	public Boolean checkIfProductPresentInOrder(String product)
	{
		return getOrderProducts().stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
	}
	
}
