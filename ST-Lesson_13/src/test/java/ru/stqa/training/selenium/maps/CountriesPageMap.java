package ru.stqa.training.selenium.maps;

import org.openqa.selenium.By;

public enum CountriesPageMap {
	COUNTRIE_PAGE_TITLE("Countries | My Store", "", null), 
	COUNTRIE_ROWS("",".dataTable tr.row", TypeLocator.CSS),
	COUNTRIE_HREF("", "a", TypeLocator.CSS),
	COUNTRIE_ZONE("", "td:nth-child(6)", TypeLocator.CSS),
	ZONE_PAGE_TITLE("Edit Country | My Store", "", null), 
	ZONE_ROWS("", "#table-zones tr:not(.header)", TypeLocator.CSS),
	ZONE_NAME("", "td:nth-child(3)", TypeLocator.CSS),
	ZONE_CANCEL_BTN("", "[name=cancel]", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	CountriesPageMap(final String text, final String path, final TypeLocator type) {
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
