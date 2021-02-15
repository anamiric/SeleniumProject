package tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAddressesTests extends BaseTest {
	
	private static final int FIRST_ADDRESS_BOX = 1;
	private static final int SECOND_ADDRESS_BOX = 2;
	private String email; 
	private String password;
	private String newAddress;
	private String newCity;
	private String newState;
	private String newPostalCode;
	private String newMobileNum;
	private String newAddressAlias;
	private String oldAddress;
	private String oldCity; 
	private String oldPostalCode;
	private int numberOfAddresses;
	private List<String> addressData = new ArrayList<>();
	
	@Test (priority = 1)
	public void updateAddress() throws InterruptedException {
		email = reader.getData("login", 4, 6);
		password = reader.getData("login", 4, 7);
		newAddress = reader.getData("my_addresses", 5, 6);
		newCity = reader.getData("my_addresses", 5, 8);
		newState = reader.getData("my_addresses", 5, 9);
		newPostalCode = reader.getData("my_addresses", 5, 11);
		oldAddress = reader.getData("my_addresses", 4, 5);
		oldCity = reader.getData("my_addresses", 4, 7);
		oldPostalCode = reader.getData("my_addresses", 4, 10);
		
		loginSteps(email, password);
		accountPage.clickMyAddressesLabel();
		addressPage.clickUpdateBtn();
		addressPage.inputAddress(newAddress);
		addressPage.inputCity(newCity);
		addressPage.inputState(1);
		addressPage.inputPostalCode(newPostalCode);
		addressPage.clickSaveBtn();
		
		Assert.assertEquals(addressPage.getAddressFromAddressBox(FIRST_ADDRESS_BOX), getAddressData());
		
		Thread.sleep(3000);
		addressPage.returnOldAddress(oldAddress, oldCity, 5, oldPostalCode);	
		
	}
	
	@Test (priority = 2)
	public void addNewAddress() throws InterruptedException {
		email = reader.getData("login", 4, 6);
		password = reader.getData("login", 4, 7);
		newAddress = reader.getData("my_addresses", 4, 18);
		newCity = reader.getData("my_addresses", 4, 19);
		newState = reader.getData("my_addresses", 4, 20);
		newPostalCode = reader.getData("my_addresses", 4, 21);
		newMobileNum = reader.getData("my_addresses", 4, 22);
		newAddressAlias = reader.getData("my_addresses", 4, 23);
		
		loginSteps(email, password);
		accountPage.clickMyAddressesLabel();
		addressPage.clickAddNewAddressBtn();
		addressPage.inputAddress(newAddress);
		addressPage.inputCity(newCity);
		addressPage.inputState(12);
		addressPage.inputPostalCode(newPostalCode);
		addressPage.inputMobileNum(newMobileNum);
		addressPage.inputAddressAlias(newAddressAlias);
		addressPage.clickSaveBtn();

		Assert.assertEquals(addressPage.getAddressFromAddressBox(SECOND_ADDRESS_BOX), getAddressData());
		Thread.sleep(3000);
	}
	
	@Test (priority = 3)
	public void deleteAddress() throws InterruptedException {
		email = reader.getData("login", 4, 6);
		password = reader.getData("login", 4, 7);
		
		loginSteps(email, password);
		accountPage.clickMyAddressesLabel();
		numberOfAddresses = addressPage.getAddressBoxes().size();
		Assert.assertTrue(numberOfAddresses == 2);
		addressPage.deleteAddress(SECOND_ADDRESS_BOX);
		numberOfAddresses = addressPage.getAddressBoxes().size();
		Assert.assertTrue(numberOfAddresses == 1);
		
		Thread.sleep(3000);
		
	}	

	public List<String> getAddressData() {
		
		addressData.add(newAddress);
		addressData.add(newCity);
		addressData.add(newState);
		addressData.add(newPostalCode);
		
		return addressData;
		
	}
	

}
