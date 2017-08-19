package ru.stqa.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import ru.stqa.training.page.object.cart.CartPageObject;
import ru.stqa.training.page.object.header.HeaderPageObject;
import ru.stqa.training.page.object.home.HomePageObject;
import ru.stqa.training.page.object.product.ProductPageObject;
import ru.stqa.training.selenium.TestBase;


public class LiteCartTest extends TestBase{
	@Test(priority = 0, enabled = true)
	public void addPtoductToCart() {
		HomePageObject home = new HomePageObject(driver, wait);
		ProductPageObject product = new ProductPageObject(driver, wait);
		HeaderPageObject header = new HeaderPageObject(driver, wait);
		String [] productNames = {"Test Product", "Test Product 1", "Blue Duck", "Green Duck"};
		header.goToHomePage();
		
		for (String productName : productNames) {
			assertTrue(home.pageIsPresent());
			assertTrue(home.msFindElementByName(productName));
			home.msClickProductByName(productName);
			
			assertTrue(product.pageIsPresent());
			assertEquals(productName, product.getProductName());
			
			product.addToCartProduct();
			assertTrue(product.waitChangeCountInCart());
					
			header.goToHomePage();
		}
	}
	
	@Test(priority = 10)
	public void removeProductFromCart() {
		HeaderPageObject header = new HeaderPageObject(driver, wait);
		CartPageObject cart = new CartPageObject(driver, wait);
		
		header.checkout();
		assertTrue(cart.pageIsPresent());		
		assertTrue(cart.deleteAllProducts());
	}
}



































