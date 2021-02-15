package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wdWait;
	WebElement signInLabel;
	WebElement emailField;
	WebElement passwordField;
	WebElement signInBtn;
	WebElement authenticatonErrorMessage;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getSignInLabel() {
		return driver.findElement(By.className("login"));
	}

	public WebElement getEmailField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInBtn() {
		return driver.findElement(By.id("SubmitLogin"));
	}


	public WebElement getAuthenticatonErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	public void clickSignInLabel() {

		getSignInLabel().click();
	}

	public void inputEmail(String email) {

		getEmailField().clear();
		getEmailField().sendKeys(email);
	}

	public void inputPassword(String password) {

		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}

	public void clearEmailAndPasswordFields() {

		getEmailField().clear();
		getPasswordField().clear();
	}

	public void clickSignInBtn() {

		getSignInBtn().click();
	}
	
	public String getSignInText() {
		
		return getSignInBtn().getText().trim();
	}

	public String getAuthenticationErrorText() {

		return getAuthenticatonErrorMessage().getText().trim();
	}

}
