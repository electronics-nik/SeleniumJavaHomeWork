package ru.stqa.training.page.object.user;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum CreateAccountMap {
	PAGE_HEADER_H1("Create Account", "h1.title", TypeLocator.CSS),
	TAX_ID_FIELD("", "form[name=customer_form] input[name=tax_id]", TypeLocator.CSS),
	COMPANY_FIELD("", "form[name=customer_form] input[name=company]", TypeLocator.CSS),
	FIRST_NAME_FIELD("", "form[name=customer_form] input[name=firstname]", TypeLocator.CSS),
	LAST_NAME_FIELD("", "form[name=customer_form] input[name=lastname]", TypeLocator.CSS),
	ADDRESS_1_FIELD("", "form[name=customer_form] input[name=address1]", TypeLocator.CSS),
	ADDRESS_2_FIELD("", "form[name=customer_form] input[name=address2]", TypeLocator.CSS),
	POSTCODE_FIELD("", "form[name=customer_form] input[name=postcode]", TypeLocator.CSS),
	CITY_FIELD("", "form[name=customer_form] input[name=city]", TypeLocator.CSS),
	COUNTRY_COMBO_BOX("", "form[name=customer_form] select[name=country_code]", TypeLocator.CSS),
	ZONE_COMBO_BOX("", "form[name=customer_form] select[name=zone_code]", TypeLocator.CSS),
	EMAIL_FIELD("", "form[name=customer_form] input[name=email]", TypeLocator.CSS),
	PHONE_FIELD("", "form[name=customer_form] input[name=phone]", TypeLocator.CSS),
	SUBSCRIBE_CHECK_BOX("", "form[name=customer_form] input[name=newsletter]", TypeLocator.CSS),
	DISIRED_PWD_FIELD("", "form[name=customer_form] input[name=password]", TypeLocator.CSS),
	CONFIRM_PWD_FIELD("", "form[name=customer_form] input[name=confirmed_password]", TypeLocator.CSS),
	CREATE_ACCOUNT_BTN("Create Account", "form[name=customer_form] button[type=submit]", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	CreateAccountMap(final String text, final String path, final TypeLocator type) {
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
