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

public class FlipCart {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		System.out.println("Launch flipkart application successfully....");
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();

		List<WebElement> allLinks = driver.findElements(By.tagName("//a"));
		int r = 0;
		int count = 0;

		for(WebElement elm:allLinks)
		{
		    String text = elm.getText();
             System.out.println(text);
		    FileInputStream fis = new FileInputStream("./src/test/resources/TestData10to12.xlsx");
		    Workbook book = WorkbookFactory.create(fis);
		    Sheet s1 = book.getSheet("Sheet2");
		    Row row = s1.getRow(r);
		    if (row == null) {
		        row = s1.createRow(r);
             
		    }
		    Cell cel = row.createCell(0);
		    cel.setCellValue(text);
		    r++;
		    count++;
		    

		  FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData10to12.xlsx");
		    book.write(fos);
		    book.close();
		}
		System.out.println("total no of links " +allLinks.size());

	}
}




    
   
    
		

	


