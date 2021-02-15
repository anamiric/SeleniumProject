package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wdWait;
	WebElement product;
	WebElement productName;
	WebElement productPrice;
	WebElement addToCartBtn;
	WebElement continueShopping;
	WebElement proceedToCart;
	Actions actions;
	List<WebElement> listOfProducts;
	List<String> productInfo = new ArrayList<>();

	public ProductsPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wdWait) {

		this.driver = driver;
		this.js = js;
		this.wdWait = wdWait;
	}

	public WebElement getProduct() {
		return driver.findElement(By.className("product-container"));
	}

	public WebElement getProductName(WebElement element) {
		return element.findElement(By.className("product-name"));
	}

	public WebElement getProductPrice(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getAddToCartBtn(WebElement element) {
		return element.findElement(By.className("ajax_add_to_cart_button"));
	}

	public WebElement getContinueShopping() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span"));
	}

	public WebElement getProceedToCart() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
	}

	public List<WebElement> getListOfProducts() {
		return driver.findElements(By.className("product-container"));
	}

	public void clickAddToCartBtn(WebElement element) {

		getAddToCartBtn(element).click();
	}

	public void clickContinueShopping() {

		getContinueShopping().click();
	}

	public void clickProceedToCart() {

		getProceedToCart().click();
	}

	public void addProductsToCart(int numOfProducts) {
		String name;
		String price;
		String xpath;
		int counter = 0;
		Actions actions = new Actions(driver);

		js.executeScript("arguments[0].scrollIntoView();", getProduct());
		for (int i = 0; i < numOfProducts; i++) {
			name = getProductNameText(getListOfProducts().get(i));
			xpath = "//*[@id=\"homefeatured\"]/li[" + (i + 1) + "]/div/div[2]/div[1]";
			price = getPriceText(xpath);
			productInfo.add(name);
			productInfo.add(price);
			actions.moveToElement(getListOfProducts().get(i)).perform();
			clickAddToCartBtn(getListOfProducts().get(i));
			counter++;
			wdWait.until(ExpectedConditions.visibilityOf(getProceedToCart()));
			if (counter == numOfProducts) {
				clickProceedToCart();
			} else {
				clickContinueShopping();
			}
		}

	}
	
	public void addSameProductMultipleTimes(int quantity) {
		String name;
		String price;
		String xpath;
		int counter = 0;
		Actions actions = new Actions(driver);

		js.executeScript("arguments[0].scrollIntoView();", getProduct());
		name = getProductNameText(getListOfProducts().get(0));
		xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[1]";
		price = getPriceText(xpath);
		productInfo.add(name);
		productInfo.add(price);
		for (int i = 0; i < quantity; i++) {			
			actions.moveToElement(getListOfProducts().get(0)).perform();
			clickAddToCartBtn(getListOfProducts().get(0));
			counter++;
			wdWait.until(ExpectedConditions.visibilityOf(getProceedToCart()));
			if (counter == quantity) {
				clickProceedToCart();
			} else {
				clickContinueShopping();
			}
		}
		
	}
	
	public List<String> getProductInfo(){
		
		return productInfo;
	}

	public String getProductNameText(WebElement element) {

		return getProductName(element).getText().trim();
	}

	public String getPriceText(String xpath) {

		return getProductPrice(xpath).getText().trim();
	}

}
