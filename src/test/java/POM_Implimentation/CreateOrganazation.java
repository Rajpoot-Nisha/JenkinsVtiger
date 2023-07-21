package POM_Implimentation;

import java.io.IOException;

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
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 File_Utility flib = new File_Utility();
		 java_utilitiy jlib = new java_utilitiy();
		 Excel_Utility elib = new Excel_Utility();
		
		 String BROWSER = flib.getStringKeyAndVAlue("browser");
		 WebDriver driver ;
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 System.out.println("Chrome  is successfully Launched....");
		 } 
		 
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver() ;
			 System.out.println("firefoxd  is successfully Launched....");
			 
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver(); 
			 System.out.println("edge  is successfully Launched....\"");
		 }
		 else
		 {
			 System.out.println("Driver is not matched....");
			 driver = new ChromeDriver(); 
		 }
		 
		 wlib.implicitywait(driver);
		 String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
         driver.get(URL);
         wlib.maximizeScreen(driver);
         LoginPage lognpg = new LoginPage(driver);
         lognpg.loginToApp(USERNAME, PSWD);
         HomePage homepg = new HomePage(driver);
         homepg.orgLinkClick();
         CreateOrgPage orgpage = new CreateOrgPage(driver);
         orgpage.clickOnPlusImg();
         int data =    jlib.getRandomNum();
      String orgName  = elib.getExcelDdataUsingDataformater("Organazation", 0, 0)+data;
      String phnNum = elib.getExcelDdataUsingDataformater("Organazation",0,1)+data;
      String email = elib.getExcelDdataUsingDataformater("Organazation",0,2)+data;
      orgpage.orgData(orgName, phnNum, email);
      orgpage.clickSaveButton();
     // homepg.signOut(driver);
      Actions act1 = new Actions(driver);
      // Logout 
		 WebElement administator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 act1.moveToElement(administator).click();
		 
         driver.findElement(By.xpath("//a[text() = 'Sign Out']")).click();  // issue

      
		
		 }
	

}
