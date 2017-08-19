package ru.stqa.training.page.object.admin.countries;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum CountriesPageMap {
	COUNTRIES_PAGE_TITLE("Countries", "td#content > h1", TypeLocator.CSS), 
	COUNTRIES_ROWS("",".dataTable tr.row", TypeLocator.CSS),
	COUNTRIES_HREF("", "a", TypeLocator.CSS),
	COUNTRIES_ZONE("", "td:nth-child(6)", TypeLocator.CSS),
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
