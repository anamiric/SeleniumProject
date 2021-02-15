package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CartPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyWishlistPage;
import pages.PersonalInfoPage;
import pages.ProductsPage;

public class BaseTest {

	public static final String URL = "http://automationpractice.com/index.php";
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wdWait;
	DataReader reader;
	//pages
	LoginPage loginPage;
	MyAccountPage accountPage;
	MyAddressesPage addressPage;
	PersonalInfoPage persInfoPage;
	MyWishlistPage wishlistPage;
	ProductsPage productPage;
	CartPage cartPage;
	

	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver_lib\\chromedriver.exe");

		driver = new ChromeDriver();
		wdWait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
		reader = new DataReader("data/test_plan.xlsx");
		loginPage = new LoginPage(driver);
		accountPage = new MyAccountPage(driver);
		addressPage = new MyAddressesPage(driver, js);
		persInfoPage = new PersonalInfoPage(driver);
		wishlistPage = new MyWishlistPage(driver, wdWait);
		productPage = new ProductsPage(driver, js, wdWait);
		cartPage = new CartPage(driver, js, wdWait);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		driver.navigate().to(URL);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@AfterClass
	public void after() throws IOException {

		driver.close();
		driver.quit();

	}

	public void loginSteps(String email, String password) throws InterruptedException {

		loginPage.clickSignInLabel();
		loginPage.inputEmail(email);
		Thread.sleep(2000);
		loginPage.inputPassword(password);
		Thread.sleep(2000);
		loginPage.clickSignInBtn();
		Thread.sleep(2000);
	}
}
