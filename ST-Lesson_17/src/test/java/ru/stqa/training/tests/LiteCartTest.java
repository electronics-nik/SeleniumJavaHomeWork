package ru.stqa.training.tests;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;

import ru.stqa.training.page.object.admin.AdminMenuPageObject;
import ru.stqa.training.page.object.admin.LoginAdminPageObject;
import ru.stqa.training.page.object.admin.RootAdminMenuPageObject;
import ru.stqa.training.page.object.admin.catalog.CatalogPageObject;
import ru.stqa.training.page.object.admin.product.ProductPageObject;
import ru.stqa.training.selenium.TestBase;

public class LiteCartTest extends TestBase{
	
	@Test(priority = 0, enabled = true)
	public void verifyBrowserLog() {
		LoginAdminPageObject login = new LoginAdminPageObject(driver, wait);
		AdminMenuPageObject admin = new AdminMenuPageObject(driver, wait);
		RootAdminMenuPageObject root = new RootAdminMenuPageObject(driver, wait);
		CatalogPageObject catalog = new CatalogPageObject(driver, wait);
		ProductPageObject product = new ProductPageObject(driver, wait);
		
		assertTrue(login.pageIsPresent());
		login.typeUserName("admin");
		login.typeUserPasword("admin123");
		login.clickLoginBtn();
		
		assertTrue(admin.pageIsPresent());
		admin.clickMenuItemByName("Catalog");
		
		assertTrue(catalog.pageIsPresent());
		catalog.openAllCategories();
		
		for (int i=0; i<catalog.getCountProduct(); i++) {
			catalog.openProductPageByIndex(i);
			assertTrue(product.pageIsPresent());
			assertFalse(isContainsMsgErrorLevel(getBrowserLog()));
			product.clickCancel();
			assertTrue(catalog.pageIsPresent());
		}
		
		root.clickLogout();
		assertTrue(login.pageIsPresent());
	}
	
	private boolean isContainsMsgErrorLevel(LogEntries entries) {
		/*
			SEVERE (highest value) 
			WARNING 
			INFO 
			CONFIG 
			FINE 
			FINER 
			FINEST (lowest value)
		*/ 

		for (LogEntry entry : entries.getAll()) {
			if (entry.getLevel().getName().equals("SEVERE") ||
					entry.getLevel().getName().equals("WARNING")) {
				return true;
			}
		}
		
		return false;
	}
}



































