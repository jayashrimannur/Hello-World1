package amazontest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import shoppingcart.pageobjects.LandingPage;
//import AmazonTest.test.BaseTest;

public class BaseTest {
	WebDriver driver;
	LandingPage home;
	public void initializeDriver() throws IOException
	{
	
		Properties prop=new Properties();
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\src\\shoppingcart\\resources\\Global.properties");
		prop.load(fin);
		
		String browsername=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		System.out.println(browsername);
		if(browsername.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			if(browsername.contains("headless"))
				options.addArguments("headless");
			driver=new ChromeDriver(options);
		
		}
		else if(browsername.equalsIgnoreCase("edge"))
				//edgecode
				driver=new EdgeDriver();
		else if(browsername.equalsIgnoreCase("firefox"))
			//edgecode
			driver=new FirefoxDriver();
	
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
	BaseTest bt=new BaseTest();
	bt.initializeDriver();
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		initializeDriver();
		home=new LandingPage(driver);
		home.gotoHome("https://amazon.co.in");
		return home;
		}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	public List<HashMap<String, String>> getJSONtoHashmap(String filepath) throws IOException
	{
		//read JSON to String
		String jsoncontent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+filepath));
		
		//String to Hashmap
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File fs=ts.getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.dir")+"\\"+testcasename+".png");
		FileUtils.copyFile(fs, new File(System.getProperty("user.dir")+"\\"+testcasename+".png"));
		return System.getProperty("user.dir")+"\\"+testcasename+".png";
	}
	


}
