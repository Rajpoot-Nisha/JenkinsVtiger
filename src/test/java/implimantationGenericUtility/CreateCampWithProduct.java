package implimantationGenericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 File_Utility flib = new File_Utility();
		 java_utilitiy jlib = new java_utilitiy();
		 Excel_Utility elib = new Excel_Utility();
		 
		wlib.implicitywait(driver);// issue
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
         driver.get(URL);
         wlib.maximizeScreen(driver);
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PSWD); 
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.linkText("Products")).click();
         driver.findElement(By.xpath("//img[@alt = 'Create Product...']")).click();
         int rNum  =    jlib.getRandomNum();
         String prodData = elib.getExcelDdataUsingDataformater("Product", 0, 0)+rNum;
         driver.findElement(By.name("productname")).sendKeys(prodData);
         driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
         driver.findElement(By.linkText("More")).click();
        driver.findElement(By.name("Campaigns")).click();
        driver.findElement(By.xpath("//img[@alt = 'Create Campaign...']")).click();
        String campData = elib.getExcelDdataUsingDataformater("Campaign",3,2)+rNum;
        driver.findElement(By.name("campaignname")).sendKeys(campData);
       driver.findElement(By.xpath("//img[@alt = 'Select']")).click();
       wlib.switchToWindow(driver,"Products&action");
       driver.findElement(By.id("search_txt")).sendKeys(prodData);
       driver.findElement(By.name("search")).click();
       Thread.sleep(1000);
       driver.findElement(By.xpath("//a[text()= '"+prodData+"']")).click();
       wlib.switchToWindow(driver, "Campaigns&action");
       Thread.sleep(1000);
       driver.findElement(By.xpath("//input[@title ='Save [Alt+S]']")).click();
       WebElement administator = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
	   wlib.actionMoveToElement(driver, administator);
       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

        
        

	}
       
      
}

