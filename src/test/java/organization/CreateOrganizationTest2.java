    package organization;
	
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;
	import generic_Utilities.BaseClass;
	import generic_Utilities.Excel_Utility;
	import generic_Utilities.java_utilitiy;
	import generic_Utilities.ListenerImptClass;
	import PageObjects.CreateOrgPage;
	import PageObjects.HomePage;
import PageObjects.ValidationPage;

   // @Listeners(generic_Utilities.ListenerImptClass.class)

	public class CreateOrganizationTest2 extends BaseClass{
		@Test
		//@Test(retryAnalyzer =generic_Utilities.ReTryAnalyzer.class )
		public void createOrganizationTest() throws Throwable {
			java_utilitiy jlib = new java_utilitiy();
			Excel_Utility elib = new Excel_Utility();
			HomePage homepg = new HomePage(driver);
	         homepg.orgLinkClick();
	         
	         CreateOrgPage orgpage = new CreateOrgPage(driver);
	         orgpage.clickOnPlusImg();

	int ranNumber = jlib.getRandomNum();
	String orgName  = elib.getExcelDdataUsingDataformater("Organazation", 0, 0)+ranNumber;
    String phnNum = elib.getExcelDdataUsingDataformater("Organazation",0,1)+ranNumber;
    String email = elib.getExcelDdataUsingDataformater("Organazation",0,2)+ranNumber;
    orgpage.orgData(orgName, phnNum, email);
    Thread.sleep(1000);
    Assert.assertEquals(false, true);
    orgpage.clickSaveButton();
    
	/* String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	{
		if(actData.contains(orgName))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}*/
    
   
	}
	}
