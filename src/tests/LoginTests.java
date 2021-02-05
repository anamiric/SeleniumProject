package tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

	@Test
	public void login() throws InterruptedException {
		
		driver.navigate().to("https://www.google.com/");
		
		Thread.sleep(3000);
	}
}
