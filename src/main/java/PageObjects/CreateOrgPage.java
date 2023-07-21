package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage  {

	public CreateOrgPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//img[@title = 'Create Organization...']")
	private WebElement createOrgPlusImg ;
	@FindBy(name="accountname")
	private WebElement orgNmae ;
	@FindBy(id="phone")
	private WebElement orhPhone ;
	@FindBy(id="email1")
	private WebElement orhEmail ;
	@FindBy(xpath="//input[@title ='Save [Alt+S]']")
	private WebElement saveButton ;
	
	
	// getter methods
	public WebElement getCreateOrgPlusImg() {
		return createOrgPlusImg;
	}
	
	
	public WebElement getOrgNmae() {
		return orgNmae;
	}
	
	public WebElement getOrhPhone() {
		return orhPhone;
	}
	
	public WebElement getOrhEmail() {
		return orhEmail;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	// Business Logic
	
	public void clickOnPlusImg()
	{
		createOrgPlusImg.click();
	}
	public void orgData(String orgname,String phone, String email)
	{
		orgNmae.sendKeys(orgname);
		orhPhone.sendKeys(phone);
		orhEmail.sendKeys(email);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
		
}
