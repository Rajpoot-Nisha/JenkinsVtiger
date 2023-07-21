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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
         File_Utility flib = new File_Utility();
         String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
         
       /*
        FileInputStream fis = new FileInputStream("./src/test/resources/vTiger.properties");
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
         driver.findElement(By.linkText("Organizations")).click();
         driver.findElement(By.xpath("//img[@title = 'Create Organization...']")).click();
         
         java_utilitiy jlib = new java_utilitiy();
         int data =    jlib.getRandomNum();
         // set the excel file path
        
        /* FileInputStream fisExcel = new FileInputStream("src/test/resources/TestData10to12.xlsx");
         Workbook book = WorkbookFactory.create(fisExcel);
         Sheet sh = book.getSheet("Organazation");
         Row rw = sh.getRow(0);
         Cell cel =  rw.getCell(0);
         // fetch the data from file
          * String orgData = cel.getStringCellValue()+data;
         */
         Excel_Utility elib = new Excel_Utility();
         String orgData = elib.getExcelDdataUsingDataformater("Organazation",0,0)+data;
         
         WebElement orname = driver.findElement(By.name("accountname"));
         orname.sendKeys(orgData+data);
         driver.findElement(By.id("phone")).sendKeys("1234567890"+data);
         driver.findElement(By.id("email1")).sendKeys("dsfrg@gmail.com"+data);
         driver.findElement(By.xpath("//input[@title ='Save [Alt+S]']")).click();
	

	}

}
