package BaseClass_Implementation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObjects.CreateCampaignPage;
import PageObjects.CreateProductPage;
import PageObjects.HomePage;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.java_utilitiy;

public class CreateProductTest2  extends BaseClass  {
	
	@Test
	public void createProductTest() throws Throwable {
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
       


}

}
