package ru.stqa.training.selenium.maps;

import org.openqa.selenium.By;

public enum ProductPageMap {
	PRODUCT_NAME("", "div#box-product h1.title", TypeLocator.CSS),
	PRODUCT_REG_PRICE("", "div#box-product .regular-price", TypeLocator.CSS),
	PRODUCT_CAM_PRICE("", "div#box-product .campaign-price", TypeLocator.CSS),
	
	T("", "", null);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	ProductPageMap(final String text, final String path, final TypeLocator type) {
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
