package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsToCartTest extends BaseTest {
	
	private int numOfProducts;
	private int quantity;
	String productsRemovedMessage;
	
	@Test
	public void addOneProductToCart() throws InterruptedException {
		
		numOfProducts = reader.getNumberData("add_products", 4, 4);
		productPage.addProductsToCart(numOfProducts);
		
		Assert.assertEquals(productPage.getProductInfo(), cartPage.getProductInfoCart());
		
		Thread.sleep(3000);
	}
	
	@Test
	public void addThreeProductsToCart() throws InterruptedException {
		
		numOfProducts = reader.getNumberData("add_products", 4, 14);
		productPage.addProductsToCart(numOfProducts);
		
		Assert.assertEquals(productPage.getProductInfo(), cartPage.getProductInfoCart());
		
		Thread.sleep(3000);

	}
	
	@Test
	public void addSameProductToCartThreeTimes() throws InterruptedException {
		
		quantity = reader.getNumberData("add_products", 4, 23);
		productPage.addSameProductMultipleTimes(quantity);
		
		Assert.assertEquals(productPage.getProductInfo(), cartPage.getProductInfoCart());
		Assert.assertEquals(cartPage.getQuantityValue(), quantity);
		
		Thread.sleep(3000);
	}
	
	@Test	
	public void deleteProductsFromCart() throws InterruptedException {
		numOfProducts = reader.getNumberData("add_products", 4, 32);
		productsRemovedMessage = reader.getData("add_products", 4, 34);
		
		productPage.addProductsToCart(numOfProducts);
		cartPage.deleteProductFromCart();
		
		Assert.assertEquals(cartPage.getAlertMessageText(), productsRemovedMessage);
		
		Thread.sleep(3000);
	}

}
