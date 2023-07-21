package implimantationGenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class CreateProduct {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//driver initialization
				WebDriver driver;
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
				 WebDriver_Utility wlib = new WebDriver_Utility();
				 File_Utility flib = new File_Utility();
				 java_utilitiy jlib = new java_utilitiy();
				 Excel_Utility elib = new Excel_Utility();
				 wlib.maximizeScreen(driver);
				// wlib.implicitywait();  // issue
		 
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
         String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
         driver.get(URL);
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PSWD); 
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.linkText("Products")).click();
         driver.findElement(By.xpath("//img[@alt = 'Create Product...']")).click();
        
         int data =    jlib.getRandomNum();
         // set the excel file path
         String prodData = elib.getExcelDdataUsingData("Product", 2, 2)+data;
         driver.findElement(By.name("productname")).sendKeys(prodData);
         driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
         Actions act1 = new Actions(driver);
         // Logout 
  		 WebElement administator = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
  		 act1.moveToElement(administator).perform();
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
// completed
