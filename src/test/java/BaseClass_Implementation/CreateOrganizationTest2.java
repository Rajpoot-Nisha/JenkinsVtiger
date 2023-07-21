    package BaseClass_Implementation;
	
	import org.openqa.selenium.By;
import org.testng.annotations.Test;
	import generic_Utilities.BaseClass;
	import generic_Utilities.Excel_Utility;
	import generic_Utilities.java_utilitiy;
	import PageObjects.CreateOrgPage;
	import PageObjects.HomePage;
	public class CreateOrganizationTest2 extends BaseClass{

		@Test
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
    orgpage.clickSaveButton();
	 String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	{
		if(actData.contains(orgName))
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
