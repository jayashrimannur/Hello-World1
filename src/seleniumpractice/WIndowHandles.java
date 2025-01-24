package seleniumpractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WIndowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> s=driver.getWindowHandles();
		Iterator<String>it=s.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String st=driver.findElement(By.cssSelector(".im-para.red")).getText();
		String email=st.split(" ")[4];
		driver.switchTo().window(parent);
		System.out.println(email);
		driver.findElement(By.id("username")).sendKeys(email);
		

	}

}
