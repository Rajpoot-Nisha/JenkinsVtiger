package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) {
		WebDriver driver;
		/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		*/
		/*
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		*/
		/*
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();*/
	
        String key = "webdriver.chrome.driver";
       // String value = "C:\\Users\\HP\\ChromeDriver113\\chromedriver.exe";
        String value = "./src/main/resources/chromedriver.exe";
        System.setProperty(key, value);
         driver = new ChromeDriver();
		
		
	}

}
