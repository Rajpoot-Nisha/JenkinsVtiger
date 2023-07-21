package product;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProducAndtDeleteProductTest {
    @Test
	public void createProductAndDeleteProductTest() throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 File_Utility flib = new File_Utility();
		 java_utilitiy jlib = new java_utilitiy();
		 Excel_Utility elib = new Excel_Utility();
		 wlib.maximizeScreen(driver);
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
	     int rabNum = jlib.getRandomNum();
	     String prodData = elib.getExcelDdataUsingData("Product", 2, 2)+rabNum;
         driver.findElement(By.name("productname")).sendKeys(prodData);
         driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
         driver.findElement(By.linkText("Products")).click();
         WebElement delitem =   driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text() = '"+prodData+"']"+"/../preceding-sibling::td/input"));
         delitem.click();
         driver.findElement(By.xpath("//input[@value= 'Delete']")).click();
         wlib.switchToAlertAndAccept(driver);
         List<WebElement> prodLists =    driver.findElements(By.xpath("//table[@class= 'lvt small']/tbody/tr/td[3][position()>1]"));
         boolean flag = false;
         for(WebElement prodName:prodLists)
         {
        	 
        	 String deleteData = prodName.getText();
        	 if(deleteData.contains(prodData))
        	 {
        		 flag = true;
        		 break;
        	 }
         }
         if(flag)
         {
        	 System.out.println("Product data is deleted");
         }
        	
         else
         {
        	 System.out.println("Product data is not deleted");
         }
        	
         }
		

	}


