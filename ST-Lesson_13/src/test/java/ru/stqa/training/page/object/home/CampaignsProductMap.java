package ru.stqa.training.page.object.home;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum CampaignsProductMap {
	CAM_PRODUCT_LIST("", "div#box-campaigns li", TypeLocator.CSS),
	CAM_PRODUCT_HREF("", "a:first-child", TypeLocator.CSS),
	CAM_PRODUCT_NAME("", ".name", TypeLocator.CSS),
	CAM_PRODUCT_REG_PRICE("", ".regular-price", TypeLocator.CSS),
	CAM_PRODUCT_CAM_PRICE("", ".campaign-price", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	CampaignsProductMap(final String text, final String path, final TypeLocator type) {
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
