package ru.stqa.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import ru.stqa.training.page.object.user.CreateAccountPage;
import ru.stqa.training.page.object.user.UserPage;
import ru.stqa.training.selenium.TestBase;

public class LiteCartTest extends TestBase{
	private String testFirstName = "Иван";
	private String testLastName = "Сергеев";
	private String testEmail = "test@odessa.com";
	private String testPwd = "123456";
	
	@Test(priority = 0)
	public void createNewCustomenr() {
		CreateAccountPage newAccount = new CreateAccountPage(driver);
		UserPage user = new UserPage(driver, wait);
		user.clickNewCustomerLink();
		assertEquals(newAccount.getHeader() ,"Create Account");
		newAccount.typeTaxId("5467621834");
		newAccount.typeCompany("Home");
		newAccount.typeFirstName(testFirstName);
		newAccount.typeLastName(testLastName);
		newAccount.typeAddress_1("Пушкинская 56");
		newAccount.typePostcode("65465");
		newAccount.typeCity("Одесса");
		// newAccount.selectCountry("Russian Federation");
		newAccount.typeEmail(testEmail);
		newAccount.typePhone("+380 67 832-16-50");
		
		newAccount.typePassword(testPwd);
		newAccount.typeConfirmPassword(testPwd);
		newAccount.clickCreateAccountBtn();
		
		assertEquals(user.getSuccessMessage().trim(), "Your customer account has been created.");
		
		user.doLogout();
		assertTrue(user.loginFormIsPresent());
	}
	
	@Test(priority = 10, dependsOnMethods = "createNewCustomenr")
	public void testNewCustomer() {
		UserPage user = new UserPage(driver, wait);
		user.gotoHomePage();
		
		assertTrue(user.loginFormIsPresent());
		user.typeEmail(testEmail);
		user.typePassword(testPwd);
		user.clickLoginBtn();
		
		String msg = user.getSuccessMessage();
		assertTrue(msg.contains(testFirstName));
		assertTrue(msg.contains(testLastName));
		
		user.doLogout();
		assertTrue(user.loginFormIsPresent());
	}
}



































