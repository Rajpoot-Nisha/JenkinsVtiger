package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("http://localhost:8888/index.php?action=Login&module=Users");
         driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("admin"); 
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.linkText("Products")).click();
         driver.findElement(By.xpath("//img[@alt = 'Create Product...']")).click();
         Random r = new Random();
	     int rabNum = r.nextInt(1000);
         // driver.findElement(By.name("productname")).sendKeys("laptop");
         FileInputStream fisExcel = new FileInputStream("src/test/resources/TestData10to12.xlsx");
         Workbook book = WorkbookFactory.create(fisExcel);
         Sheet sh = book.getSheet("Product");
         Row rw = sh.getRow(0);
         Cell cel =  rw.getCell(0);
         // fetch the data from file
         String prodData = cel.getStringCellValue()+rabNum;
         driver.findElement(By.name("productname")).sendKeys(prodData);
       WebElement savebutton =   driver.findElement(By.xpath("//input[@accessKey = 'S']"));
   Point cordinate = savebutton.getLocation();
   System.out.println(cordinate);
  JavascriptExecutor js = (JavascriptExecutor) driver; 
  js.executeScript("window.scrollBy(602,0)");
  driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
  driver.findElement(By.linkText("Products")).click();
WebElement delitem =   driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text() = '"+prodData+"']"+"/../preceding-sibling::td/input"));
delitem.click();
driver.findElement(By.xpath("//input[@value= 'Delete']")).click();
driver.switchTo().alert().accept();
//Alert al = driver.switchTo().alert();
//al.accept();

	}

}
