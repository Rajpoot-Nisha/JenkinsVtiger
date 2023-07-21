package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitTime {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         FileInputStream fis = new  FileInputStream("src/test/resources/LoginDetails.properties");
         Properties pro = new Properties();
         pro.load(fis);
         String URL = pro.getProperty("url");
         String USERNAME = pro.getProperty("username");
         String PASSWORD = pro.getProperty("password");
         driver.get(URL);
         driver.findElement(By.id("username")).sendKeys(USERNAME);
         driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(PASSWORD);
         driver.findElement(By.id("loginButton")).click();
		

	}

}
