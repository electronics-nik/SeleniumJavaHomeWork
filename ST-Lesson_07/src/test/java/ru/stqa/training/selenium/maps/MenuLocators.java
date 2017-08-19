package ru.stqa.training.selenium.maps;

import org.openqa.selenium.By;

public enum MenuLocators {
	MENU_ITEMS_LI("", "li#app-", TypeLocator.CSS),
	MENU_ITEM_URL("", "a", TypeLocator.CSS),
	MENU_ITEM_SELECTED("", "li#app-.selected", TypeLocator.CSS),
	MENU_ITEM_NAME("", "a>span.name", TypeLocator.CSS),
	MENU_SUBMENU_ITEMS_LI("", "ul>li", TypeLocator.CSS);	
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	MenuLocators(final String text, final String path, final TypeLocator type) {
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
