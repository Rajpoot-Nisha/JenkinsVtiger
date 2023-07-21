package assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		System.out.println("Launch Amazon application successfully....");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("//a"));
	
		
		 FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\TestData10to12.xlsx");
		    Workbook book = WorkbookFactory.create(fis);
		    Sheet s1 = book.getSheet("Sheet1");
		    int i =0;
		    int count = 0;
		    String text = "";
          for(WebElement link:allLinks)
               {
        	  text = link.getText();
             
	             Row row = s1.createRow(i);
	             Cell cel = row.createCell(0);
	             cel.setCellValue(text);
	             i++;
	 	       
                 }
         
          count++;
		
		  
		  FileOutputStream fos = new FileOutputStream("C:\\Users\\HP\\Desktop\\TestData10to12.xlsx");
		    book.write(fos);
		    book.close();
		   
	        System.out.println("Data added successfully.......");
	        System.out.println("total no of links " +allLinks.size());
	        //System.out.println(text);
		}
	
	
}



