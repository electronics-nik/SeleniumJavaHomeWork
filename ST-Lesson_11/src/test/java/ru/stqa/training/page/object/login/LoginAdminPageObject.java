package ru.stqa.training.page.object.login;

import static ru.stqa.training.page.object.login.LoginPageMap.LOGIN_BTN;
import static ru.stqa.training.page.object.login.LoginPageMap.LOGIN_PAGE_ANCHOR;
import static ru.stqa.training.page.object.login.LoginPageMap.PASSWORD;
import static ru.stqa.training.page.object.login.LoginPageMap.USERNAME;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.isElementPresent;
import static ru.stqa.training.selenium.SharedMethods.typeText;

import org.openqa.selenium.WebDriver;

public class LoginAdminPageObject {
	private final WebDriver driver;
	
	public LoginAdminPageObject(final WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyAnchor() {
		return isElementPresent(driver, LOGIN_PAGE_ANCHOR.by());
	}
	
	public void typeUserName(final String username) {
		typeText(driver, USERNAME.by(), username);
	}
	
	public void typeUserPasword(final String userPwd) {
		typeText(driver, PASSWORD.by(), userPwd);
	}
	
	public void clickLoginBtn() {
		click(driver, LOGIN_BTN.by());
	}
}
