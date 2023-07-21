package implimantationGenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCamaign {

	public static void main(String[] args) throws IOException {
		//driver initialization
		WebDriver driver;
		//chromedriver path setup using webDriver
		WebDriverManager.chromedriver().setup();
		//chromeDriver instance
	    driver = new ChromeDriver();
		 //all utilities class object creation
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 File_Utility flib = new File_Utility();
		 java_utilitiy jlib = new java_utilitiy();
		 Excel_Utility elib = new Excel_Utility();
		 //maximise the screne
		 wlib.maximizeScreen(driver);
		// wlib.implicitywait();  // issue
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 //get login credenctial from property file
         String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
         //Launch the url 
         driver.get(URL);
         //Login to application
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PSWD); 
         driver.findElement(By.id("submitButton")).click();
         // click on more majore tab
         
         driver.findElement(By.linkText("More")).click();
        // driver.findElement(By.xpath("//a[text() = 'More']"));
       //click on campaign tab under more
        driver.findElement(By.name("Campaigns")).click();
        //click on create  (+ plus Button) Campaign
        driver.findElement(By.xpath("//img[@alt = 'Create Campaign...']")).click();
        // use for get uniue number along with campaign name(remove duplicacy)
        int rNum  =    jlib.getRandomNum();
       //get campaign data from Excel file
        String campData = elib.getExcelDdataUsingDataformater("Campaign",3,2)+rNum;
        driver.findElement(By.name("campaignname")).sendKeys(campData);
        driver.findElement(By.xpath("//input[@title ='Save [Alt+S]']")).click();
      // wlib.actionMoveToElement(); // issue
       Actions act1 = new Actions(driver);
       // Logout 
		 WebElement administator = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
		 act1.moveToElement(administator).perform();
       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
//completed
