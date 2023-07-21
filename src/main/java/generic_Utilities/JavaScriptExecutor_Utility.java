package generic_Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor_Utility {
	
	JavascriptExecutor js;
	
	public JavaScriptExecutor_Utility(WebDriver driver)
	{
		
		js = (JavascriptExecutor)driver;
		
		
	}
	public void launchAppUrl(String url)
	{
		
		
		js.executeScript("window.location = arguments[0]", url);
	}
	
	
	public void sendKeys(WebElement elm ,String data)
	{
		
		
		js.executeScript("window.value = arguments[0]", elm, data);
	}
	
	public void click(WebElement elmnt)
	{
		
		
		js.executeScript("arguments[0].click()", elmnt);
	}
	

}
