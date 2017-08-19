package ru.stqa.training.page.object.admin.countries;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum EditCountryPageMap {
	COUNTRY_EDIT_PAGE_TITLE("Edit Country", "td#content > h1", TypeLocator.CSS),
	COUNTRY_EDIT_PAGE_CODE_ALPHA2_LINK("ISO 3166-1 alpha-2 - Wikipedia", 
			"//*/td[@id='content']//td[count(input[@name='iso_code_2'])=1]/a", 
			TypeLocator.XPATH),
	COUNTRY_EDIT_PAGE_CODE_ALPHA3_LINK("ISO 3166-1 alpha-3 - Wikipedia", 
			"//*/td[@id='content']//td[count(input[@name='iso_code_3'])=1]/a", 
			TypeLocator.XPATH),
	COUNTRY_EDIT_PAGE_TAX_ID_FORMAT_LINK("Regular expression - Wikipedia", 
			"//*/td[@id='content']//td[count(input[@name='tax_id_format'])=1]/a", 
			TypeLocator.XPATH),
	COUNTRY_EDIT_PAGE_POSTCODE_FORMAT_LINK("Regular expression - Wikipedia", 
			"//*/td[@id='content']//td[count(input[@name='postcode_format'])=1]/a", 
			TypeLocator.XPATH),
	COUNTRY_EDIT_PAGE_CURRENCY_CODE_LINK("List of countries and capitals with currency and language - Wikipedia", 
			"//*/td[@id='content']//td[count(input[@name='currency_code'])=1]/a", 
			TypeLocator.XPATH),
	COUNTRY_EDIT_PAGE_PHONE_COUNTRY_CODE_LINK("List of country calling codes - Wikipedia", 
			"//*/td[@id='content']//td[count(input[@name='phone_code'])=1]/a", 
			TypeLocator.XPATH);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	EditCountryPageMap(final String text, final String path, final TypeLocator type) {
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
