package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utilities.WebDriver_Utility;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);	
	}

	//Declaration
		@FindBy(linkText = "Organizations")
		private WebElement orgLink ;
		@FindBy(linkText ="More")
		private WebElement moreTab;
		@FindBy(name="Campaigns")
		private WebElement campLink;
		@FindBy(linkText="Products")
		private WebElement prodLink;
		@FindBy(xpath="//img[@src = 'themes/softed/images/user.PNG']")
		private WebElement Administrator;
		@FindBy(xpath="//a[text()='Sign Out']")
        private WebElement SignOut;
		// getters Method
		public WebElement getOrgLink() {
			return orgLink;
		}
		public WebElement getMoreTab() {
			return moreTab;
		}
		public WebElement getCampLink() {
			return campLink;
		}
		public WebElement getProdLink() {
			return prodLink;
		}
		public WebElement getAdministrator() {
			return Administrator;
		}
		public WebElement getSignOut() {
			return SignOut;
		}
// Business Logic
		public void orgLinkClick()
		{
			orgLink.click();
		}
		public void moreLinkClick()
		{
			moreTab.click();
		}
		public void campLinkClick()
		{
			campLink.click();
		}
		public void prodLinkClick()
		{
			prodLink.click();
		}
		public void signOut(WebDriver driver)
		{
			WebDriver_Utility wlib = new WebDriver_Utility();
			wlib.actionMoveToElement(driver, Administrator);
			//Actions actions = new Actions(driver);
			//actions.moveToElement(Administrator).perform();
			SignOut.click();
		}
		
}