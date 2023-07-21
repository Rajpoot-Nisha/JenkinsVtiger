package DataDrivenTesting;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignCreate {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		/* driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         */
		 // webDriver utility
		
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 wlib.maximizeScreen(driver);
		// wlib.implicitywait();// issue
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 //File utility
         File_Utility flib = new File_Utility();
         String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
         
        /* FileInputStream fis = new FileInputStream("./src/test/resources/vTiger.properties");
         Properties pro = new Properties();
         pro.load(fis);		 
         String URL = pro.getProperty("url");
         String USERNAME = pro.getProperty("username");
         String PSWD = pro.getProperty("password");
         */
        		 
         driver.get(URL);
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PSWD); 
         driver.findElement(By.id("submitButton")).click();
         WebElement more=  driver.findElement(By.linkText("More"));
         Actions act = new Actions(driver);
         act.moveToElement(more).perform();
        driver.findElement(By.name("Campaigns")).click();
        driver.findElement(By.xpath("//img[@alt = 'Create Campaign...']")).click();
        // java utility
        java_utilitiy jlib = new java_utilitiy();
        int rNum  =    jlib.getRandomNum();
        
        
      /*  FileInputStream fisExcel = new FileInputStream("src/test/resources/TestData10to12.xlsx");
        Workbook book = WorkbookFactory.create(fisExcel);
        Sheet sh = book.getSheet("Campaign");
        Row rw = sh.getRow(3);
        Cell cel =  rw.getCell(2);
        // fetch the data from file
        String campData = cel.getStringCellValue()+data;
        */
        //Exce lUtility
        Excel_Utility elib = new Excel_Utility();
        String campData = elib.getExcelDdataUsingDataformater("Campaign",3,2)+rNum;
        driver.findElement(By.name("campaignname")).sendKeys(campData);
        driver.findElement(By.xpath("//input[@title ='Save [Alt+S]']")).click();
      // wlib.actionMoveToElement(); // issue
       Actions act1 = new Actions(driver);
		 WebElement administator = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
		 act1.moveToElement(administator).perform();
       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       

	}

}
