package ru.stqa.training.page.object.admin;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum RootAdminMenuMap {
	LOGOUT("", "td#sidebar > div.header > a[title=Logout]", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	RootAdminMenuMap(final String text, final String path, final TypeLocator type) {
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
