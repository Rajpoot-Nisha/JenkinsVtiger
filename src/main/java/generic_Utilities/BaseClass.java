package generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

public	WebDriver driver;
public static WebDriver sDriver;
   // @Parameters("BROWSER")
	@BeforeClass
	public void beforeClass() throws Throwable
	{
		File_Utility flib=new File_Utility();
		 String BROWSER = flib.getStringKeyAndVAlue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sDriver = driver;
	}
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		File_Utility flib=new File_Utility();
		 wlib.implicitywait(driver);
		 String URL =  flib.getStringKeyAndVAlue("url");
	     String USERNAME = flib.getStringKeyAndVAlue("username");
         String PSWD = flib.getStringKeyAndVAlue("password");
		driver.get(URL);
		wlib.maximizeScreen(driver);
		
		//calling from POM
		LoginPage lognpg = new LoginPage(driver);
        lognpg.loginToApp(USERNAME, PSWD);
	}
	@AfterMethod
	public void afterMethod()
	{
		 HomePage homepg = new HomePage(driver);
         homepg.signOut(driver);
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}


}
