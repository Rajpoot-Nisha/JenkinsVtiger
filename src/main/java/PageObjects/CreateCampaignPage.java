package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public  CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//img[@alt = 'Create Campaign...']")
	private WebElement plusImage;
	@FindBy(name = "campaignname")
	private WebElement campName;
	@FindBy(xpath ="//img[@alt = 'Select']")
	private WebElement selectProduct;
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	@FindBy(name = "search")
	private WebElement searchBtn;
	@FindBy(xpath = "//input[@accesskey = 'S']")
	private WebElement saveButton;
	
	
	public WebElement getPlusImage() {
		return plusImage;
	}
	public WebElement getCampName() {
		return campName;
	}
	public WebElement getSelectProduct() {
		return selectProduct;
	}
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void clickOnPlusImg()
	{
		plusImage.click();
	}
	
	public void campData(String name)
	{
		campName.sendKeys(name);
	}
	public void clickSelectProduct()
	{
		selectProduct.click();
	}
	public void searchProductData(String prdname)
	{
		searchTextField.sendKeys(prdname);;
	}
	public void clickSearchBtn()
	{
		searchBtn.click();
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
}
