package generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	
	public String getStringKeyAndVAlue(String key) throws IOException 
	{
		
		 FileInputStream fis = new FileInputStream("./src/test/resources/vTiger.properties");
         Properties pro = new Properties();
         pro.load(fis);
         String value = pro.getProperty(key);
         return value;
	}

}
