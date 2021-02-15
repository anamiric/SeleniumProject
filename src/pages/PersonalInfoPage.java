package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {

	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement currentPassword;
	WebElement saveInfoBtn;
	WebElement userMessage;
	WebElement headerUserName;
	
	public PersonalInfoPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getCurrentPassword() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getSaveInfoBtn() {
		return driver.findElement(By.name("submitIdentity"));
	}
	
	public WebElement getUserMessage() {
		return driver.findElement(By.className("alert-success"));
	}

	public WebElement getHeaderUserName() {
		return driver.findElement(By.className("header_user_info"));
	}

	public void inputFirstName(String firstName) {
		
		getFirstNameField().clear();
		getFirstNameField().sendKeys(firstName);
	}
	
	public void inputLastName(String lastName) {
		
		getLastNameField().clear();
		getLastNameField().sendKeys(lastName);
	}
	
	public void inputCurrentPassword(String password) {
		
		getCurrentPassword().clear();
		getCurrentPassword().sendKeys(password);
	}
	
	public void clickSaveInfoBtn() {
		
		getSaveInfoBtn().click();
	}
	
	public void clickHeaderUserName() {
		
		getHeaderUserName().click();
	}
	
	public String getUserMessageText() {
		
		return getUserMessage().getText().trim();
	}
	
	public String getHederUserNameText() {
		
		return getHeaderUserName().getText().trim();
	}
	
	public void returnOldInfo(String firstName, String lastName, String password) {
		
		inputFirstName(firstName);
		inputLastName(lastName);
		inputCurrentPassword(password);
		clickSaveInfoBtn();
	}
	
}
