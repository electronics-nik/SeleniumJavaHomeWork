package ru.stqa.training.page.object.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.typeText;
import static ru.stqa.training.selenium.SharedMethods.isChecked;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;
import static ru.stqa.training.selenium.SharedMethods.getText;
import static ru.stqa.training.selenium.SharedMethods.isElementPresent;
import static ru.stqa.training.page.object.user.UserMenuMap.FORM_TITLE;
import static ru.stqa.training.page.object.user.UserMenuMap.ITEM_MENU_LOGOUT;
import static ru.stqa.training.page.object.user.UserMenuMap.EMAIL_FIELD;
import static ru.stqa.training.page.object.user.UserMenuMap.PWD_FIELD;
import static ru.stqa.training.page.object.user.UserMenuMap.REMEMBER_ME_CHECK;
import static ru.stqa.training.page.object.user.UserMenuMap.LOGIN_BTN;
// import static ru.stqa.training.page.object.user.UserMenuMap.LOST_PWD_BTN;
import static ru.stqa.training.page.object.user.UserMenuMap.NEW_CUSTOMER_LINK;
import static ru.stqa.training.page.object.user.UserMenuMap.SUCCESS_MESSAGE;
import static ru.stqa.training.page.object.user.header.HeaderMap.HOME_LINK;

public class UserPage {
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public UserPage(final WebDriver driver, final WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public boolean loginUserFormIsPresent() {
		return isElementPresent(driver, FORM_TITLE.by());
	}
	
	public void typeEmail(final String email) {
		typeText(driver, EMAIL_FIELD.by(), email);
	}
	
	public void typePassword(final String password) {
		typeText(driver, PWD_FIELD.by(), password);
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
	
	public void clickNewCustomerLink() {
		click(driver, NEW_CUSTOMER_LINK.by());
	}
	
	public String getSuccessMessage() {
		if (waitElementPresent(driver, SUCCESS_MESSAGE.by(), wait)) {
			return getText(driver, SUCCESS_MESSAGE.by());
		} else {
			return "";
		}
	}
	
	public void doLogout() {
		click(driver, ITEM_MENU_LOGOUT.by());
	}
	
	public void gotoHomePage() {
		click(driver, HOME_LINK.by());
	}
}
