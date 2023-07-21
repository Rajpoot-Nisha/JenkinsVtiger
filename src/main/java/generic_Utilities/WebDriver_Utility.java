package generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	
	WebDriver driver;
	/**
	 *
	 * 
	 * @param driver
	 */
	
	public void maximizeScreen(WebDriver driver)
	{
		
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	
	public void minimiseScreen(WebDriver driver)
	{
		
		driver.manage().window().minimize();
	}
	
	/**
	 *  Wait for page to load before identifying any element im DOM
	 *
	 * 
	 */
	public void implicitywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		
		 Set<String> allwindows = driver.getWindowHandles();
	       Iterator<String> id = allwindows.iterator();
	       while(id.hasNext())
	       {
	    	   
	    	  String win = id.next();
	    	  driver.switchTo().window(win);
	    	  String title = driver.getTitle();
	    	  if(title.contains("PartialWindowTitle"))
	    	  {
	    		  break;
	    	  }
	       }
	       
	       Set<String> allwindows2 = driver.getWindowHandles();
	       Iterator<String> id2 = allwindows.iterator();
	       while(id.hasNext())
	       {
	    	   
	    	  String win = id.next();
	    	  driver.switchTo().window(win);
	    	  String title = driver.getTitle();
	    	  if(title.contains("PartialWindowTitle"))
	    	  {
	    		  break;
	    	  }
	}
	     
	       
	}
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismis(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToFrame(WebDriver driver,int index)
	{
		
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		
		driver.switchTo().frame(id_name_Attribute);
	}

	public void select(WebElement element , String text)
	{
		Select sel = new Select(element);
		sel.deselectByValue(text);
		
	}
	   public void actionMoveToElement(WebDriver driver ,WebElement element) {
		 Actions act = new Actions(driver);
		// WebElement administator = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
		 act.moveToElement(element).perform();
  	   	
	}
}
