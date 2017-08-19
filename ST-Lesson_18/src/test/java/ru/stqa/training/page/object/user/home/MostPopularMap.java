package ru.stqa.training.page.object.user.home;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum MostPopularMap {
	MS_HEADER_SECTION("Most Popular", "div#box-most-popular > h3.title", TypeLocator.CSS),
	MS_PRODUCT_LIST("", "div#box-most-popular ul > li", TypeLocator.CSS),
	MS_PRODUCT_LINK("", "a.link", TypeLocator.CSS),
	MS_PRODUCT_NAME("", "a.link > div.name", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	MostPopularMap(final String text, final String path, final TypeLocator type) {
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
