package implimantationGenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import PageObjects.CreateOrgPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganazation {

	public static void main(String[] args) throws IOException, InterruptedException {
		 
		 //all utilities class object creation
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 File_Utility flib = new File_Utility();
		 java_utilitiy jlib = new java_utilitiy();
		 Excel_Utility elib = new Excel_Utility();
		 WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();	 
		 wlib.implicitywait(driver);
         String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
         //Launch the url
         driver.get(URL);
         wlib.maximizeScreen(driver);
         //Login to application
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PSWD); 
         driver.findElement(By.id("submitButton")).click();
         // click on more organization tab
         driver.findElement(By.linkText("Organizations")).click();
         driver.findElement(By.xpath("//img[@title = 'Create Organization...']")).click();
         // reduce duplicacy
         int data =    jlib.getRandomNum();
         // get organization data from excel file
         String orgData = elib.getExcelDdataUsingDataformater("Organazation",0,0)+data;
          driver.findElement(By.name("accountname")).sendKeys(orgData);
          String phnNum = elib.getExcelDdataUsingDataformater("Organazation",0,1)+data;
          driver.findElement(By.id("phone")).sendKeys(phnNum);
          String email = elib.getExcelDdataUsingDataformater("Organazation",0,2)+data;
          driver.findElement(By.id("email1")).sendKeys(email);
          // Save data
         driver.findElement(By.xpath("//input[@title ='Save [Alt+S]']")).click();
         Actions act1 = new Actions(driver);
         // Logout 
  		 WebElement administator = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
  		 act1.moveToElement(administator).perform();
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	

	}

}
// not completed
