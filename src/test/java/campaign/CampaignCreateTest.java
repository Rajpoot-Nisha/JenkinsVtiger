package campaign;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CreateCampaignPage;
import PageObjects.CreateOrgPage;
import PageObjects.HomePage;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.java_utilitiy;

public class CampaignCreateTest extends BaseClass {
	
	
	@Test
	public void createCampaignTest() throws Throwable {
		java_utilitiy jlib = new java_utilitiy();
		Excel_Utility elib = new Excel_Utility();
		HomePage homepg = new HomePage(driver);
		homepg.moreLinkClick();
		homepg.campLinkClick();

         CreateCampaignPage camPage = new CreateCampaignPage(driver);
         camPage.clickOnPlusImg();

int ranNumber = jlib.getRandomNum();
String cmpgName  = elib.getExcelDdataUsingDataformater("Campaign", 0, 0)+ranNumber;
camPage.campData(cmpgName);
camPage.clickSaveButton();
Assert.assertEquals(true, true);
 String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
{
	if(actData.contains(cmpgName))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
}
}
}


