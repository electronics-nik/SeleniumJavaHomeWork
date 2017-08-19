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

import ru.stqa.training.page.object.PageObject;

public class LoginAdminPageObject extends PageObject{
	
	public LoginAdminPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}
	
	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, LOGIN_PAGE_ANCHOR.by(), wait);
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
