package ru.stqa.training.tests;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import ru.stqa.training.page.object.admin.AdminMenuPageObject;
import ru.stqa.training.page.object.admin.LoginAdminPageObject;
import ru.stqa.training.page.object.admin.RootAdminMenuPageObject;
import ru.stqa.training.page.object.admin.countries.CountriesPageObject;
import ru.stqa.training.page.object.admin.countries.EditCountryPageObject;
import ru.stqa.training.selenium.TestBase;
import ru.stqa.training.selenium.WindowHelper;


public class LiteCartTest extends TestBase{
	@Test(priority = 0, enabled = true)
	public void verifyLinks() {
		LoginAdminPageObject login = new LoginAdminPageObject(driver, wait);
		AdminMenuPageObject admin = new AdminMenuPageObject(driver, wait);
		RootAdminMenuPageObject root = new RootAdminMenuPageObject(driver, wait);
		CountriesPageObject countries = new CountriesPageObject(driver, wait);
		EditCountryPageObject edirCountry = new EditCountryPageObject(driver, wait);
		WindowHelper helper = new WindowHelper(driver, wait);
		
		assertTrue(login.pageIsPresent());
		login.typeUserName("admin");
		login.typeUserPasword("admin123");
		login.clickLoginBtn();
		
		assertTrue(admin.pageIsPresent());
		admin.clickMenuItemByName("Countries");
		
		assertTrue(countries.pageIsPresent());
		countries.clickCountryByName("Andorra");
		
		assertTrue(edirCountry.pageIsPresent());		
		String rootWindowId = helper.getActiveWindowId();
		Set<String> oldWindowId = helper.getIdCurrentWindows();
		
		// Code Alpha-2 Link
		edirCountry.clickCodeAlpha2Link();
		String newWindowId = helper.getNewWindowId(oldWindowId);
		helper.switchToWindow(newWindowId);
		assertTrue(edirCountry.virifyCodeAlpha2Window());
		helper.closeActiveWindow();
		helper.switchToWindow(rootWindowId);
		assertTrue(edirCountry.pageIsPresent());
		
		// Code Alpha-3 Link
		edirCountry.clickCodeAlpha3Link();
		newWindowId = helper.getNewWindowId(oldWindowId);
		helper.switchToWindow(newWindowId);
		assertTrue(edirCountry.virifyCodeAlpha3Window());
		helper.closeActiveWindow();
		helper.switchToWindow(rootWindowId);
		assertTrue(edirCountry.pageIsPresent());
		
		// Tax Id Format Link
		edirCountry.clickTaxIdFormatLink();
		newWindowId = helper.getNewWindowId(oldWindowId);
		helper.switchToWindow(newWindowId);
		assertTrue(edirCountry.virifyTaxIdFormatWindow());
		helper.closeActiveWindow();
		helper.switchToWindow(rootWindowId);
		assertTrue(edirCountry.pageIsPresent());
		
		// Postcode Format Link
		edirCountry.clickPostcodeFormatLink();
		newWindowId = helper.getNewWindowId(oldWindowId);
		helper.switchToWindow(newWindowId);
		assertTrue(edirCountry.virifyPostcodeFormatWindow());
		helper.closeActiveWindow();
		helper.switchToWindow(rootWindowId);
		assertTrue(edirCountry.pageIsPresent());
		
		// Currency Code Link
		edirCountry.clickCurrencyCodeLink();
		newWindowId = helper.getNewWindowId(oldWindowId);
		helper.switchToWindow(newWindowId);
		assertTrue(edirCountry.virifyCurrencyCodeWindow());
		helper.closeActiveWindow();
		helper.switchToWindow(rootWindowId);
		assertTrue(edirCountry.pageIsPresent());
		
		// Phone Country Code Link
		edirCountry.clickPhoneCountryCodeLink();
		newWindowId = helper.getNewWindowId(oldWindowId);
		helper.switchToWindow(newWindowId);
		assertTrue(edirCountry.virifyPhoneCountryWindow());
		helper.closeActiveWindow();
		helper.switchToWindow(rootWindowId);
		assertTrue(edirCountry.pageIsPresent());
		
		assertTrue(root.pageIsPresent());
		root.clickLogout();
		assertTrue(login.pageIsPresent());
	}
}



































