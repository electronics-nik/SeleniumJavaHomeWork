package ru.stqa.training.page.object.admin;

import static ru.stqa.training.page.object.admin.LoginPageMap.LOGIN_PAGE_ANCHOR;
import static ru.stqa.training.page.object.admin.LoginPageMap.USERNAME;
import static ru.stqa.training.page.object.admin.LoginPageMap.PASSWORD;
import static ru.stqa.training.page.object.admin.LoginPageMap.REMEMBER_ME_CHECK;
import static ru.stqa.training.page.object.admin.LoginPageMap.LOGIN_BTN;

import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.isChecked;
// import static ru.stqa.training.selenium.SharedMethods.isElementPresent;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;
import static ru.stqa.training.selenium.SharedMethods.typeText;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAdminPageObject {
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public LoginAdminPageObject(final WebDriver driver, final WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public boolean loginAdminFormIsPresent() {
		return waitElementPresent(driver, LOGIN_PAGE_ANCHOR.by(), wait);
		// return isElementPresent(driver, LOGIN_PAGE_ANCHOR.by());
	}
	
	public void typeUserName(final String username) {
		typeText(driver, USERNAME.by(), username);
	}
	
	public void typeUserPasword(final String userPwd) {
		typeText(driver, PASSWORD.by(), userPwd);
	}
	
	public void rememberMy(boolean flag) {
		if (isChecked(driver, REMEMBER_ME_CHECK.by()) && !flag) {
			click(driver, REMEMBER_ME_CHECK.by());
		} else if (!isChecked(driver, REMEMBER_ME_CHECK.by()) && flag) {
			click(driver, REMEMBER_ME_CHECK.by());
		}
	}
	
	public void clickLoginBtn() {
		click(driver, LOGIN_BTN.by());
	}
}
