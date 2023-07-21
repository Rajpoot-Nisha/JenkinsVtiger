package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	@Test(dataProvider = "dataProviderExecute")
	public void bookTickets(String src,String dest)
	{
		System.out.println("Book tickets from" +src+ "to" +dest);
		
	}
	@DataProvider
	public Object[][] dataProviderExecute()
	{
		Object[][] obj = new Object[2][2];
		obj[0][0] = "Pune";
		obj[0][1] = "Goa";
		
		obj[1][0] = "Delhi";
		obj[1][1] = "Manali";
		
		obj[2][0] = "Pune";
		obj[2][1] = "Jhansi";
		
		obj[3][0] = "delhi";
		obj[3][1] = "kerela";
		
		return obj;
		
	}

}
