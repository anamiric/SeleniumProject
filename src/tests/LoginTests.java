package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
	
	private String email;
	private String password;
	private String actualResult;	
	private String assertData;

	@Test 
	public void loginValidCredentials() throws InterruptedException {
		
		email = reader.getData("login", 4, 6);		
		password = reader.getData("login", 4, 7);
		
		loginSteps(email, password);
		actualResult = accountPage.getSignOutBtnText();
		assertData = reader.getData("login", 4, 8);
		Assert.assertEquals(actualResult, assertData);
		
		Thread.sleep(3000);
	}
	
	@Test 
	public void loginInvalidPassword() throws InterruptedException {
		
		email = reader.getData("login", 4, 15);
		password = reader.getData("login", 4, 16);
		
		loginSteps(email, password);
		actualResult = loginPage.getAuthenticationErrorText();
		assertData = reader.getData("login", 4, 17);
		Assert.assertEquals(actualResult, assertData);
		
		Thread.sleep(3000);
		
	}
	
	@Test 
	public void loginInvalidCredentials() throws InterruptedException {
		
		email = reader.getData("login", 4, 24);
		password = reader.getData("login", 4, 25);
		
		loginSteps(email, password);
		actualResult = loginPage.getAuthenticationErrorText();
		assertData = reader.getData("login", 4, 26);
		Assert.assertEquals(actualResult, assertData);
		
		Thread.sleep(3000);
		
	}
	
	@Test 
	public void loginEmptyCredentials() throws InterruptedException {
		
		loginPage.clickSignInLabel();
		loginPage.clearEmailAndPasswordFields();
		Thread.sleep(2000);
		loginPage.clickSignInBtn();
		actualResult = loginPage.getAuthenticationErrorText();
		assertData = reader.getData("login", 4, 35);
		Assert.assertEquals(actualResult, assertData);
		
		Thread.sleep(3000);
	}
	
	@Test
	public void logout() throws InterruptedException {
		
		loginValidCredentials();
		accountPage.clickSignOutBtn();
		actualResult = loginPage.getSignInText();
		assertData = reader.getData("login", 4, 45);
		Assert.assertEquals(actualResult, assertData);
		
		Thread.sleep(3000);
		
	}
		
	
}
