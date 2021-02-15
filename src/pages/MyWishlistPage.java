package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWishlistPage {

	WebDriver driver;
	WebDriverWait wdWait;
	WebElement nameField;
	WebElement saveWishlistBtn;
	WebElement removeWishlist;
	List<WebElement> wishlistsNum;

	public MyWishlistPage(WebDriver driver, WebDriverWait wdWait) {

		this.driver = driver;
		this.wdWait = wdWait;
	}

	public WebElement getNameField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveWishlistBtn() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getRemoveWishlist(WebElement element) {
		return element.findElement(By.className("icon-remove"));
	}

	public List<WebElement> getWishlistsNum() {
		return driver.findElements(By.xpath("//*[@id=\"block-history\"]/table/tbody/tr"));
	}

	public void clickSaveWishlistBtn() {

		getSaveWishlistBtn().click();
	}

	public void clickRemoveWishlist() {

		
		for (WebElement list : getWishlistsNum()) {
			getRemoveWishlist(list).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			wdWait.until(ExpectedConditions.invisibilityOf(list));
		}
	}

	public void createWishlists(int numOfWishlists) {

		int n;
		if (getWishlistsNum().size() > 0) {
			n = getWishlistsNum().size() + 1;
		} else {
			n = 1;
		}

		for (int i = 0; i < numOfWishlists; i++) {
			
			getNameField().sendKeys("Wishlist" + n);
			clickSaveWishlistBtn();
			n++;
		}
	}


}
