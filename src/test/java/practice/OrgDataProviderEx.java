package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrgDataProviderEx {
	
	public void createOrgWithDataProvider(String uname,String pswd,String phnno)
	{
	
	WebDriver driver;
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.get("http://localhost:8888/");
   driver.findElement(By.name("user_name")).sendKeys("admin");
   driver.findElement(By.name("user_password")).sendKeys("admin");
   driver.findElement(By.id("submitButton")).click();
   driver.findElement(By.linkText( "Organizations")).click();
   driver.findElement(By.xpath("//img[@title = 'Create Organization...']")).click();
   driver.findElement(By.name("accountname")).sendKeys(uname);
   driver.findElement(By.id("phone")).sendKeys(phnno);
    

}
}