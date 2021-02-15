package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWishlistsTests extends BaseTest {

	private String email;
	private String password;
	private int numOfLists;
	private int existingListNum;
	private int addedListNum;

	@Test(priority = 1)
	public void addOneWishlist() throws InterruptedException {

		email = reader.getData("login", 4, 6);
		password = reader.getData("login", 4, 7);
		numOfLists = reader.getNumberData("wishlist", 4, 5);

		loginSteps(email, password);
		accountPage.clickMyWishlists();
		wishlistPage.createWishlists(numOfLists);
		addedListNum = wishlistPage.getWishlistsNum().size();
		Assert.assertTrue(addedListNum == numOfLists);

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void addFiveWishlists() throws InterruptedException {
		email = reader.getData("login", 4, 6);
		password = reader.getData("login", 4, 7);
		numOfLists = reader.getNumberData("wishlist", 4, 10);

		loginSteps(email, password);
		accountPage.clickMyWishlists();
		existingListNum = wishlistPage.getWishlistsNum().size();
		wishlistPage.createWishlists(numOfLists);
		addedListNum = wishlistPage.getWishlistsNum().size() - existingListNum;

		Assert.assertTrue(addedListNum == numOfLists);

		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void removeWishlists() throws InterruptedException {
		email = reader.getData("login", 4, 6);
		password = reader.getData("login", 4, 7);

		loginSteps(email, password);
		accountPage.clickMyWishlists();
		wishlistPage.clickRemoveWishlist();
		existingListNum = wishlistPage.getWishlistsNum().size();

		Assert.assertTrue(existingListNum == 0);

		Thread.sleep(3000);
	}

}
