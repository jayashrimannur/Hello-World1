package TestJavaBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {

			public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://google.com");
			driver.close();
		}
		
}
