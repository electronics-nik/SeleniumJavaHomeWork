package ru.stqa.training.selenium.maps;

import org.openqa.selenium.By;

public enum LoginPageLocator {
	USERNAME("", "input[name=username]", TypeLocator.CSS),
	PASSWORD("", "input[name=password]", TypeLocator.CSS),
	LOGIN_BTN("", "button[name=login]", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	LoginPageLocator(final String text, final String path, final TypeLocator type) {
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
