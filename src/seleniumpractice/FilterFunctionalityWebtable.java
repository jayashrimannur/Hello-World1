package seleniumpractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterFunctionalityWebtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String searchtext="Rice";
		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys(searchtext);
		//Apply the filter and get the filterList
		List<WebElement>filterList=driver.findElements(By.xpath("//tr/td[1]"));
		//Apply the filter using the stream java code and get the list
		List<WebElement> list=filterList.stream().filter(s->s.getText().contains(searchtext)).collect(Collectors.toList());
		//check if the both the list size matches
		Assert.assertEquals(filterList.size(), list.size());
	}

}
