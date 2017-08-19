package ru.stqa.training.selenium.maps;

import org.openqa.selenium.By;

public enum LoginPageMap {
	LOGIN_PAGE_ANCHOR("", "[name=login_form]", TypeLocator.CSS),
	USERNAME("", "input[name=username]", TypeLocator.CSS),
	PASSWORD("", "input[name=password]", TypeLocator.CSS),
	LOGIN_BTN("", "button[name=login]", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	LoginPageMap(final String text, final String path, final TypeLocator type) {
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
		} else {
			return By.xpath(path);
		}
	}
}
