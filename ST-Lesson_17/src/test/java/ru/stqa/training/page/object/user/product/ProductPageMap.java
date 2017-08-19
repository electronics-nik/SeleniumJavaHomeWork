package ru.stqa.training.page.object.user.product;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum ProductPageMap {
	HEADER_PAGE("", "div#box-product h1.title", TypeLocator.CSS),
	PRODUCT_REG_PRICE("", "div#box-product .regular-price", TypeLocator.CSS),
	PRODUCT_CAM_PRICE("", "div#box-product .campaign-price", TypeLocator.CSS),
	PRODUCT_ADD_TO_CART_BTN("", "div#box-product button[name=add_cart_product]", TypeLocator.CSS);
	
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
