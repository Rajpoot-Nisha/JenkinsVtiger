package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public  CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//img[@alt = 'Create Product...']")
	private WebElement plusImage;
	@FindBy(name = "productname")
	private WebElement prodName;
	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveButton;
	// Getters Methods
	public WebElement getPlusImage() {
		return plusImage;
	}
	public WebElement getProdName() {
		return prodName;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	//Business Logic
	public void clickPlusImg()
	{
		plusImage.click();
	}
	public void prodData(String name)
	{
		prodName.sendKeys(name);	
		
	}
	public void clickSaveBtn()
	{
		saveButton.click();
	}

}
