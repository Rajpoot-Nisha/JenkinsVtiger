package product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjects.CreateProductPage;
import PageObjects.DeleteProductPage;
import PageObjects.HomePage;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.WebDriver_Utility;
import generic_Utilities.java_utilitiy;

public class CreateaproductAndDeleteProduct  extends BaseClass {
	@Test
	public void createProductAndDeleteProductTest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
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
        homepg.prodLinkClick();
        DeleteProductPage dtlPage = new DeleteProductPage(driver);
        dtlPage.prodTable();
        Thread.sleep(2000);
        WebElement delitem =   driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text() = '"+prodName+"']"+"/../preceding-sibling::td/input"));
        delitem.click();
        dtlPage.deleteProdData();
        wlib.switchToAlertAndAccept(driver);
        List<WebElement> prodLists =    driver.findElements(By.xpath("//table[@class= 'lvt small']/tbody/tr/td[3][position()>1]"));
        boolean flag = false;
        for(WebElement productName:prodLists)
        {
       	 
       	 String deleteData = productName.getText();
       	 if(deleteData.contains(prodName))
       	 {
       		 flag = true;
       		 break;
       	 }
        }
        if(flag)
        {
       	 System.out.println("Product data is deleted");
        }
       	
        else
        {
       	 System.out.println("Product data is not deleted");
        }
       	
        }

}
