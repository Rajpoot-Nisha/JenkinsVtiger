package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
	
	public DeleteProductPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text() = 'Products'][1]")
	private WebElement prodTable ;
	@FindBy(xpath = "//input[@value= 'Delete']")
	private WebElement deleteBtn ;
	
	public WebElement getProdTable() {
		return prodTable;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	//Business logic
	public void prodTable()
	{
		prodTable.click();
		
	}
	public void deleteProdData()
	{
		deleteBtn.click();
		
	}
}
