package ru.stqa.training.page.object.user;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum UserMenuMap {
	FORM_TITLE("Login", "#box-account-login > h3.title", TypeLocator.CSS),
	EMAIL_FIELD("", "form[name=login_form] input[name=email]", TypeLocator.CSS),
	PWD_FIELD("", "form[name=login_form] input[name=password]", TypeLocator.CSS),
	REMEMBER_ME_CHECK("", "form[name=login_form] input[name=remember_me]", TypeLocator.CSS),
	LOGIN_BTN("", "form[name=login_form] button[name=login]", TypeLocator.CSS),
	LOST_PWD_BTN("", "form[name=login_form] button[name=lost_password]", TypeLocator.CSS),
	NEW_CUSTOMER_LINK("", "form[name=login_form] a", TypeLocator.CSS),
	ITEM_MENU_LOGOUT("", "Logout", TypeLocator.LINK),
	
	SUCCESS_MESSAGE("", ".notice.success", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	UserMenuMap(final String text, final String path, final TypeLocator type) {
		this.text = text;
		this.path = path;
		this.type = type;
	}
	
	public String text() {
		return text;
	}
	
	public By by() {
		if (type == TypeLocator.CSS) {
			return By.cssSelector(path);
		} else if (type == TypeLocator.LINK) {
			return By.linkText(path);
		} else {
			return By.xpath(path);
		}
	}
}
