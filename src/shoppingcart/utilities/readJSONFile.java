package shoppingcart.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import com.fasterxml.jaskson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class readJSONFile {
	
	public List<HashMap<String, String>> getJSONtoHashmap() throws IOException
	{
		//read JSON to String
		String jsoncontent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\shoppingcart\\resources\\input.json"));
		
		//String to Hashmap
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}

}
