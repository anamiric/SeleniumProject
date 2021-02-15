package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAddressesPage {

	WebDriver driver;
	JavascriptExecutor js;

	WebElement updateBtn;
	WebElement deleteBtn;
	WebElement addressField;
	WebElement cityField;
	WebElement stateDropdown;
	WebElement postalCodeField;
	WebElement mobileNumField;
	WebElement addressAliasField;
	WebElement saveBtn;
	WebElement address;
	WebElement city;
	WebElement state;
	WebElement postalCode;
	WebElement addNewAddressBtn;
	List<WebElement> statesList;
	List<WebElement> addressBoxes;
	List<String> completeAddress = new ArrayList<>();
	String relativeXpath;

	public MyAddressesPage(WebDriver driver, JavascriptExecutor js) {

		this.driver = driver;
		this.js = js;
	}

	public WebElement getUpdateBtn() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public WebElement getDeleteBtn(int i) {
		
		relativeXpath = "//*[@id=\"center_column\"]/div[1]/div/div[" + i + "]/ul/li[9]/a[2]";

		return driver.findElement(By.xpath(relativeXpath));
	}

	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateDropdown() {
		return driver.findElement(By.id("id_state"));
	}

	public List<WebElement> getStatesList() {
		Select dropdown = new Select(getStateDropdown());
		return dropdown.getOptions();
	}

	public WebElement getPostalCodeField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getMobileNumField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getAddressAliasField() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getAddress(int i) {

		relativeXpath = "//*[@id=\"center_column\"]/div[1]/div/div[" + i + "]/ul/li[4]/span[1]";
		return driver.findElement(By.xpath(relativeXpath));
	}

	public WebElement getCity(int i) {

		relativeXpath = "//*[@id=\"center_column\"]/div[1]/div/div[" + i + "]/ul/li[5]/span[1]";
		return driver.findElement(By.xpath(relativeXpath));
	}

	public WebElement getState(int i) {

		relativeXpath = "//*[@id=\"center_column\"]/div[1]/div/div[" + i + "]/ul/li[5]/span[2]";
		return driver.findElement(By.xpath(relativeXpath));
	}

	public WebElement getPostalCode(int i) {
		
		relativeXpath = "//*[@id=\"center_column\"]/div[1]/div/div[" + i + "]/ul/li[5]/span[3]";
		return driver.findElement(By.xpath(relativeXpath));
	}

	public WebElement getAddNewAddressBtn() {
		return driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
	}
	
	public List<WebElement> getAddressBoxes() {
		
		return driver.findElements(By.className("box"));
	}

	public void clickUpdateBtn() {

		getUpdateBtn().click();
	}

	public void clickAddNewAddressBtn() {

		getAddNewAddressBtn().click();
	}

	public void deleteAddress(int i) {

		getDeleteBtn(i).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void inputAddress(String address1) {

		getAddressField().clear();
		getAddressField().sendKeys(address1);
	}

	public void inputCity(String city) {

		getCityField().clear();
		getCityField().sendKeys(city);
	}

	public void inputState(int stateInList) {

		getStateDropdown().click();
		getStatesList().get(stateInList).click();
	}

	public void inputPostalCode(String postalCode) {

		getPostalCodeField().clear();
		getPostalCodeField().sendKeys(postalCode);
	}

	public void inputMobileNum(String mobileNum) {

		getMobileNumField().clear();
		getMobileNumField().sendKeys(mobileNum);
	}

	public void inputAddressAlias(String addressAlias) {

		getAddressAliasField().clear();
		getAddressAliasField().sendKeys(addressAlias);
	}

	public void clickSaveBtn() {

		getSaveBtn().click();
	}

	public List<String> getAddressFromAddressBox(int i) {

		js.executeScript("arguments[0].scrollIntoView();", getAddress(i));
		String address = getAddress(i).getText().trim();
		String city = getCity(i).getText().trim().replace(",", "");
		String state = getState(i).getText().trim();
		String postalCode = getPostalCode(i).getText().trim();
		completeAddress.add(address);
		completeAddress.add(city);
		completeAddress.add(state);
		completeAddress.add(postalCode);

		return completeAddress;

	}

	public void returnOldAddress(String oldAddress, String oldCity, int oldState, String oldPostalCode) {

		clickUpdateBtn();
		inputAddress(oldAddress);
		inputCity(oldCity);
		inputState(oldState);
		inputPostalCode(oldPostalCode);
		clickSaveBtn();
	}
}
