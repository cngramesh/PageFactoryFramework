package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider()
	{
		File src = new File("./Config/Config.properties");
		try {
			
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to Read Config file."+e.getMessage());
		}
		
	}
	
	
	public String getDataFromConfig(String keyToSearch)
	{
		return prop.getProperty(keyToSearch);
		
	}
	
	public String GetBrowser()
	{
		return prop.getProperty("Browser");
		
	}
	
	public String getURL()
	{
		return prop.getProperty("TestURL");
		
	}
	
}
