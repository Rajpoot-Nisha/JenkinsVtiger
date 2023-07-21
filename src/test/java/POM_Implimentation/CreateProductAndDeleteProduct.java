package POM_Implimentation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.CreateProductPage;
import PageObjects.DeleteProductPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
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
         driver.get(URL);
         wlib.maximizeScreen(driver);
         LoginPage lognpg = new LoginPage(driver);
         lognpg.loginToApp(USERNAME, PSWD);
         HomePage homepg = new HomePage(driver);
         homepg.prodLinkClick();
         CreateProductPage prodPage = new CreateProductPage(driver);
         prodPage.clickPlusImg();
         int data =    jlib.getRandomNum();
         String prodName = elib.getExcelDdataUsingData("Product", 2, 2)+data;
         prodPage.prodData(prodName);
         prodPage.clickSaveBtn();
         homepg.prodLinkClick();
         DeleteProductPage dtlPage = new DeleteProductPage(driver);
         dtlPage.prodTable();
         Thread.sleep(2000);
         WebElement delitem =   driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text() = '"+prodName+"']"+"/../preceding-sibling::td/input"));
         delitem.click();
         dtlPage.deleteProdData();
         wlib.switchToAlertAndAccept(driver);
         List<WebElement> prodLists =    driver.findElements(By.xpath("//table[@class= 'lvt small']/tbody/tr/td[3][position()>1]"));
         boolean flag = false;
         for(WebElement productName:prodLists)
         {
        	 
        	 String deleteData = productName.getText();
        	 if(deleteData.contains(prodName))
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


