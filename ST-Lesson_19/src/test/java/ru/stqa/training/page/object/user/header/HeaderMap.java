package ru.stqa.training.page.object.user.header;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum HeaderMap {
	HOME_LINK("", "i.fa.fa-home[title=Home]", TypeLocator.CSS),
	COUNT_ITEMS_INTO_CART("", "div#cart span.quantity", TypeLocator.CSS),
	CART("", "div#cart", TypeLocator.CSS),
	CHECKOUT_LINK("", "Checkout »", TypeLocator.LINK);
	
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	HeaderMap(final String text, final String path, final TypeLocator type) {
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
