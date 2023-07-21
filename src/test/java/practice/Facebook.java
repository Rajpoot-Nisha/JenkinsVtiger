package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) {
		
		    WebDriver driver;
		    String key = "webdriver.chrome.driver";
	        // String value = "C:\\Users\\HP\\ChromeDriver113\\chromedriver.exe";
	        String value = "./src/main/resources/chromedriver.exe";
	        System.setProperty(key, value);
	          driver = new ChromeDriver();
	          driver.get("https://www.facebook.com/");
	          driver.manage().window().maximize();
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	          driver.findElement(By.xpath("//a[text() ='Create new account']")).click();
	        WebElement date =   driver.findElement(By.id("//select[@id = 'day']"));
	        date.click();
	        date.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP);
	        date.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP);
	        date.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP);
	        date.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP);
	        date.click();

	}

}
