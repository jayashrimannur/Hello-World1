package seleniumpractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement>links=driver.findElements(By.xpath("//table[@class='gf-t']//a"));
		SoftAssert a=new SoftAssert();
		
		for(int i=1;i<links.size();i++)
		{
			String linktext=links.get(i).getDomAttribute("href");
		//	URL url=new URL(linktext);
			HttpURLConnection conn=(HttpURLConnection) new URL(linktext).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int res=conn.getResponseCode();
			a.assertTrue(res<400, "link "+linktext+" is  broken. Response code: "+res);
		/*	if(res<=201)
				System.out.println("link "+linktext+" is not broken. Response code: "+res);
			else
			{
				System.out.println("link "+linktext+" is  broken. Response code: "+res);
				Assert.assertTrue(false);
			}*/

			
		}
		a.assertAll();
/*		String linktext=driver.findElement(By.xpath("//a[contains(@href,'brokenlink')]")).getDomAttribute("href");
	
		
		URL url=new URL(linktext);
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.connect();
		int res=conn.getResponseCode();
		System.out.println(res);
	*/	

	}

}
