package seleniumpractice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//https://developer.chrome.com/docs/chromedriver/capabilities
		//For allowing SSL certifications
		EdgeOptions options=new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		
		ChromeOptions options1=new ChromeOptions();
		options1.setAcceptInsecureCerts(true);
		
		
		//for setting up proxy
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("Proxy", proxy);
		
		// Add a ChromeDriver-specific capability.
		options1.addExtensions(new File("/path/to/extension.crx"));
		ChromeDriver driver1 = new ChromeDriver(options1);
		
		//To set the download dir
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options1.setExperimentalOption("prefs", prefs);
		
		
		
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
