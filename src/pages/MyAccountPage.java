package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	WebElement SignOutBtn;
	WebElement myAddressesLabel;
	WebElement myPersonalInfoLabel;
	WebElement myWishlist;
	
	public MyAccountPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getSignOutBtn() {
		return driver.findElement(By.className("logout"));
	}
	
	public WebElement getMyAddressesLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a"));
	}

	public WebElement getMyPersonalInfoLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a"));
	}

	public WebElement getMyWishlist() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a"));
	}
	
	public void clickMyAddressesLabel() {
		
		getMyAddressesLabel().click();
	}
	
	public void clickMyPersonalInfoLabel() {
		
		getMyPersonalInfoLabel().click();
	}
	
	public void clickMyWishlists() {
		
		getMyWishlist().click();
	}

	public void clickSignOutBtn() {
		
		getSignOutBtn().click();
	}
	
	public String getSignOutBtnText() {
		
		return getSignOutBtn().getText().trim();
	}
}
