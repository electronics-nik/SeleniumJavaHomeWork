package ru.stqa.training.page.object.user.home;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum HomePageMap {
	IMAGE_WRAPPER("", "div.image-wrapper", TypeLocator.CSS),
	STICKER("", "div.sticker", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	HomePageMap(final String text, final String path, final TypeLocator type) {
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
