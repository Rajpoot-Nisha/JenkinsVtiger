package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductToCampaign {
    @Test
	public void addProductToCampaignTest() throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        FileInputStream fis = new FileInputStream("./src/test/resources/vTiger.properties");
        Properties pro = new Properties();
        pro.load(fis);
        String URL = pro.getProperty("url");
        String USERNAME = pro.getProperty("username");
        String PSWD = pro.getProperty("password ");
        driver.findElement(By.id("submitButton")).click();
        WebElement more=  driver.findElement(By.linkText("More"));
        Actions act = new Actions(driver);
        act.moveToElement(more).perform();
        System.out.println("successfully click on more.....");
       driver.findElement(By.name("Campaigns")).click();
       System.out.println("successfully click on campaign.....");
       driver.findElement(By.xpath("//img[@alt = 'Create Campaign...']")).click();
       System.out.println("successfully click on Plus campaign icon...");
       driver.findElement(By.name("campaignname")).sendKeys("NishaCamp");
       driver.findElement(By.xpath("//img[@alt = 'Select']")).click();
       System.out.println("successfully click on Add product icon....");
       String parent=driver.getWindowHandle();
       Set<String> allWindows = driver.getWindowHandles();
       Iterator<String> I1= allWindows.iterator();

       while(I1.hasNext())
       {

       String child_window=I1.next();


       if(!parent.equals(child_window))
       {
       driver.switchTo().window(child_window);

       System.out.println(driver.switchTo().window(child_window).getTitle());

      // driver.close();
       }

       }
       //switch to the parent window
       driver.switchTo().window(parent);

       }
    	   
       
       

	}


