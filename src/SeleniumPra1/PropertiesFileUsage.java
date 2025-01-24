package SeleniumPra1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUsage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties prop=new Properties();
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\src\\shoppingcart\\resources\\Global.properties");
		prop.load(fin);
		System.out.println(prop.getProperty("browser"));
		
		
	}

}
