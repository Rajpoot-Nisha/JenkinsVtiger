package campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.CreateCampaignPage;
import PageObjects.CreateProductPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProduct extends BaseClass {
	@Test
	public void createCampaignWithProductTest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		 File_Utility flib = new File_Utility();
		 java_utilitiy jlib = new java_utilitiy();
		 Excel_Utility elib = new Excel_Utility();
        HomePage homepg = new HomePage(driver);
        homepg.prodLinkClick();
        CreateProductPage prodPage = new CreateProductPage(driver);
        prodPage.clickPlusImg();
        int data =    jlib.getRandomNum();
        String prodName = elib.getExcelDdataUsingData("Product", 2, 2)+data;
        prodPage.prodData(prodName);
        prodPage.clickSaveBtn();
        homepg.moreLinkClick();
        homepg.campLinkClick();
        CreateCampaignPage camPage = new CreateCampaignPage(driver);
        camPage.clickOnPlusImg();
        String cmpgName  = elib.getExcelDdataUsingDataformater("Campaign", 0, 0)+data;
        camPage.campData(cmpgName);
        camPage.clickSelectProduct();
        wlib.switchToWindow(driver,"Products&action");
        camPage.searchProductData(prodName);
        Thread.sleep(2000);
        camPage.clickSearchBtn();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()= '"+prodName+"']")).click();
        wlib.switchToWindow(driver, "Campaigns&action");
        Thread.sleep(1000);
        camPage.clickSaveButton();


}
}
