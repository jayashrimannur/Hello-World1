package seleniumpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String day="15";
		String month="June";
		String year="2024";
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//abbr[text()='"+month+"']")).click();	
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();	
		
		List<WebElement>pickedDate=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<pickedDate.size();i++)
		{
			//System.out.println(pickedDate.get(i).getAttribute("value"));
			System.out.println(pickedDate.get(i).getDomAttribute("value"));
		}
	}

}
