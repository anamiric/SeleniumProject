package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wdWait;
	WebElement productNameCart;
	WebElement priceCart;
	WebElement quantity;
	WebElement deleteProduct;
	WebElement alertMessage;
	List<WebElement> productsCart;
	List<String> productInfoCart = new ArrayList<>();

	public CartPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wdWait) {

		this.driver = driver;
		this.js = js;
		this.wdWait = wdWait;
	}

	public WebElement getProductNameCart(WebElement element) {
		return element.findElement(By.className("product-name"));
	}

	public WebElement getPriceCart(WebElement element) {
		return element.findElement(By.className("price"));
	}

	public WebElement getQuantity(WebElement element) {
		return element.findElement(By.className("cart_quantity_input"));
	}

	public WebElement getDeleteProduct(WebElement element) {
		return element.findElement(By.className("cart_quantity_delete"));
	}

	public WebElement getAlertMessage() {
		return driver.findElement(By.className("alert-warning"));
	}

	public List<WebElement> getProductsCart() {
		return driver.findElements(By.xpath("//tr[starts-with(@id,'product')]"));
	}
	
	public List<String> getProductInfoCart() {
		String name;
		String price;
		
		for(WebElement product : getProductsCart()) {
			js.executeScript("arguments[0].scrollIntoView();" , product);
			name = getProductNameText(product);
			price = getPriceText(product);
			productInfoCart.add(name);
			productInfoCart.add(price);			
		}
		
		return productInfoCart;
	}
	
	public int getQuantityValue() {
		String quantityText = "";
		int quantityValue = 0;
		
		for(WebElement product : getProductsCart()) {
			js.executeScript("arguments[0].scrollIntoView();" , product);
			quantityText = getQuantity(product).getAttribute("value").trim();
			try {
				quantityValue = Integer.parseInt(quantityText);
			    } catch (NumberFormatException nfe) {
			      nfe.printStackTrace();
			    }			
		}
		
		return quantityValue;
	}
	
	public String getProductNameText(WebElement element) {
		
		return getProductNameCart(element).getText().trim();
	}
	
	public String getPriceText(WebElement element) {
		
		return getPriceCart(element).getText().trim();
	}

	public void deleteProductFromCart() {
		
		for(WebElement product : getProductsCart()) {
			getDeleteProduct(product).click();
			wdWait.until(ExpectedConditions.invisibilityOf(product));
		}
	}
	
	public String getAlertMessageText() {
		
		return getAlertMessage().getText().trim();
	}
}
