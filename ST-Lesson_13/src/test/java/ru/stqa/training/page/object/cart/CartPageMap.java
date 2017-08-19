package ru.stqa.training.page.object.cart;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum CartPageMap {
	HEADER_PAGE("Customer Details", "div#box-checkout-customer > h2.title", TypeLocator.CSS),
	CART_IS_EMPTY("", "div#checkout-cart-wrapper > p > em", TypeLocator.CSS),
	CART_PRODUCT_FIRST("", "div#box-checkout-cart ul.items > li:first-child", TypeLocator.CSS),
	CART_PRODUCT_NAME("", "strong", TypeLocator.CSS),
	CART_PRODUCT_REMOVE_BTN("", "button[name=remove_cart_item]", TypeLocator.CSS),	
	CART_SHORTCUT_FIRST("", "div#box-checkout-cart ul.shortcuts > li:first-child", TypeLocator.CSS),
	CART_SHORTCUT_LINK("", "a", TypeLocator.CSS),
	CART_PRODUCT_IN_TABLE("", "div#order_confirmation-wrapper tr > td.item", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	CartPageMap(final String text, final String path, final TypeLocator type) {
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
