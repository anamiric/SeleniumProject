package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

	WebDriver driver;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver_lib\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void posleKlase() throws IOException {
		
		driver.close();
		driver.quit();

	}
}
