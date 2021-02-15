package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyPersonalInfoTests extends BaseTest {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String assertMessage;
	private String fullName;

	@Test
	public void editPersonalInfo() throws InterruptedException {
		email = reader.getData("login", 4, 6);
		password = reader.getData("login", 4, 7);
		firstName = reader.getData("personal_info", 5, 5);
		lastName = reader.getData("personal_info", 5, 7);
		assertMessage = reader.getData("personal_info", 5, 9);
		fullName = firstName + " " + lastName;

		loginSteps(email, password);
		accountPage.clickMyPersonalInfoLabel();
		persInfoPage.inputFirstName(firstName);
		persInfoPage.inputLastName(lastName);
		persInfoPage.inputCurrentPassword(password);
		persInfoPage.clickSaveInfoBtn();
		
		Assert.assertEquals(persInfoPage.getUserMessageText(), assertMessage);
		Assert.assertEquals(persInfoPage.getHederUserNameText(), fullName);

		Thread.sleep(3000);
		
		driver.navigate().back();
		firstName = reader.getData("personal_info", 4, 4);
		lastName = reader.getData("personal_info", 4, 6);
		persInfoPage.returnOldInfo(firstName, lastName, password);

	}
}
