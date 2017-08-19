package ru.stqa.training.selenium.maps;

import org.openqa.selenium.By;

public enum RootMenuMap {
	ITEM_MENU_LOGOUT("", "[title=Logout]", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	RootMenuMap(final String text, final String path, final TypeLocator type) {
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
