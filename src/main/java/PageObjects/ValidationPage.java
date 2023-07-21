package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {
	
	
	public ValidationPage(WebDriver driver)
	{
		
	PageFactory.initElements(driver,this);	
		
	}
	@FindBy(xpath = "//a[@class ='hdrLink']")
	private WebElement homePage ;
	@FindBy(xpath = "html//table[3]/tbody/tr[2]/td[1]/a[text() = 'Organizations'] ")
	private WebElement orgPage ;
	@FindBy(xpath = "html//table[3]/tbody/tr[2]/td[1]/a[text() = 'Campaigns']")
	private WebElement campignPage ;
	@FindBy(xpath = "html//table[3]/tbody/tr[2]/td[1]/a[text() = 'Products']")
	private WebElement prodPage ;
	
	public WebElement getHomePage() {
		return homePage;
	}
	
	public WebElement getOrgPage() {
		return orgPage;
	}
	
	public WebElement getCampignPage() {
		return campignPage;
	}
	
	public WebElement getProdPage() {
		return prodPage;
	}
	
	public String verifyHomePage()
	{
		return homePage.getText();
	}
	

}
