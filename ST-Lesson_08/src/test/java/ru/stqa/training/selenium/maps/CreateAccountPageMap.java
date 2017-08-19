package ru.stqa.training.selenium.maps;

import org.openqa.selenium.By;

public enum CreateAccountPageMap {
	HEADER_PAGE("", "", TypeLocator.CSS),
	TAX_ID_FIELD("", "", TypeLocator.CSS),
	COMPANY_FIELD("", "", TypeLocator.CSS),
	FIRST_NAME_FIELD("", "", TypeLocator.CSS),
	LAST_NAME_FIELD("", "", TypeLocator.CSS),
	ADDRESS_1_FIELD("", "", TypeLocator.CSS),
	ADDRESS_2_FIELD("", "", TypeLocator.CSS),
	POSTCODE_FIELD("", "", TypeLocator.CSS),
	CITY_FIELD("", "", TypeLocator.CSS),
	COUNTRY_FIELD("", "", TypeLocator.CSS),
	EMAIL_FIELD("", "", TypeLocator.CSS),
	PHONE_FIELD("", "", TypeLocator.CSS),
	SUBSCRIBE_CHECK_BOX("", "", TypeLocator.CSS),
	DESIRED_PASSWORD_FIELD("", "", TypeLocator.CSS),
	CONFIRM_PASSWORD_FIELD("", "", TypeLocator.CSS),
	CREATE_ACCOUNT_BTN("", "", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	CreateAccountPageMap(final String text, final String path, final TypeLocator type) {
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
