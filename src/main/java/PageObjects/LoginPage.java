package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	//Declaration
	@FindBy(name = "user_name")
	private WebElement userNameTextField;
	@FindBy(name="user_password")
	private WebElement pswdTextField;
	@FindBy(id ="submitButton")
	private WebElement submitButton;
	//getters Methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	
	public WebElement getPswdTextField() {
		return pswdTextField;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Business Logic
	public void loginToApp(String userName, String password)
	{
		userNameTextField.sendKeys(userName);
		pswdTextField.sendKeys(password);
		submitButton.click();
	}
		
		
	
	
}
