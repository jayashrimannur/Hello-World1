package seleniumpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		List<WebElement> cl=driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(cl.size());
		
		System.out.println(cl.get(2).isSelected());
		cl.get(2).click();
		System.out.println(cl.get(2).isSelected());
		
		/*for(WebElement cloption:cl)
			
		{  System.out.println(cloption.getText());
			if(cloption.getText().equals("Senior Citizen"))
			{   
				System.out.println(cloption.isSelected());
				cloption.click();
				System.out.println(cloption.isSelected());
				break;
			}
		}*/
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> wl=driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		System.out.println(wl.size());
		for(int i=0;i<wl.size();i++)
		{
			System.out.println(wl.get(i).getText());
			if(wl.get(i).getText().equals("India"))
			{
				wl.get(i).click();
			
				break;
			}
		}
	}

}
