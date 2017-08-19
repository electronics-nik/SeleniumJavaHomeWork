package ru.stqa.training.page.object.admin.product;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum AddNewProductPageMap {
	HEADER_PAGE("Add New Product", "td#content > h1", TypeLocator.CSS),
	TAB_LIST("", "div.tabs li", TypeLocator.CSS),
	TAB_URL("", "a", TypeLocator.CSS),
	SAVE_BTN("Save", "td#content form button[name=save]", TypeLocator.CSS),
	CANCEL_BTN("Cancel", "td#content form button[name=cancel]", TypeLocator.CSS),
	DELETE_BTN("Delete", "td#content form button[name=delete]", TypeLocator.CSS),
	
	// ----------------------------------- General Tab -----------------------------------
	GENERAL_STATUS_ENABLE("", "div#tab-general input[type=radio][value='1']", TypeLocator.CSS),
	GENERAL_STATUS_DISABLE("", "div#tab-general input[type=radio][value='0']", TypeLocator.CSS),
	GENERAL_NAME("", "div#tab-general input[name^=name", TypeLocator.CSS),
	GENERAL_CODE("", "div#tab-general input[name=code]", TypeLocator.CSS),
	GENERAL_CATEGORY_CHECK_BOX("", "div#tab-general input[name^=categories]", TypeLocator.CSS),
	GENERAL_CATEGORY_NAME("", "//*[@id='tab-general']//input[contains(@name,'categories')]/../../td[count(input)=0]", 
		TypeLocator.XPATH),
	GENERAL_DEFAULT_CATEGORY("", "div#tab-general select[name=default_category_id]", TypeLocator.CSS),
	GENERAL_DEF_CATEGORY_OPTION("", "option", TypeLocator.CSS),
	GENERAL_GENDER_CHECK_BOX("", "div#tab-general input[name^=product_groups]", TypeLocator.CSS),
	GENERAL_GENDER_NAME("", "//*[@id='tab-general']//input[contains(@name,'product_groups')]/../../td[count(input)=0]", 
		TypeLocator.XPATH),
	GENERAL_QUANTITY("", "div#tab-general input[name=quantity]", TypeLocator.CSS),
	GENERAL_QUANTITY_UNIT("", "div#tab-general select[name=quantity_unit_id]", TypeLocator.CSS),
	GENERAL_QUANTITY_UNIT_OPTION("", "option", TypeLocator.CSS),
	GENERAL_DELIVERY_STATUS("", "div#tab-general select[name=delivery_status_id]", TypeLocator.CSS),
	GENERAL_DELIVERY_STATUS_OPTION("", "option", TypeLocator.CSS),
	GENERAL_SOLD_OUT_STATUS("", "div#tab-general select[name=sold_out_status_id]", TypeLocator.CSS),
	GENERAL_SOLD_OUT_STATUS_OPTION("", "option", TypeLocator.CSS),
	GENERAL_UPLOAD_IMAGES("", "div#tab-general input[name^=new_images]", TypeLocator.CSS),
	GENERAL_DATE_VALID_FROM("", "div#tab-general input[name=date_valid_from]", TypeLocator.CSS),
	GENERAL_DATE_VALID_TO("", "div#tab-general input[name=date_valid_to]", TypeLocator.CSS),
	
	// --------------------------------- Information Tab ---------------------------------
	INFORMATION_MANUFACTURER("", "div#tab-information select[name=manufacturer_id]", TypeLocator.CSS),
	INFORMATION_MANUFACTURER_OPTION("", "option", TypeLocator.CSS),
	INFORMATION_SUPPLIER("", "div#tab-information select[name=supplier_id]", TypeLocator.CSS),
	INFORMATION_SUPPLIER_OPTION("", "option", TypeLocator.CSS),
	INFORMATION_KEYWORDS("", "div#tab-information input[name=keywords]", TypeLocator.CSS),
	INFORMATION_SHORT_DESCRIPTION("", "div#tab-information input[name^=short_description]", TypeLocator.CSS),
	INFORMATION_DESCRIPTION("", "div#tab-information div.trumbowyg-editor", TypeLocator.CSS),
	INFORMATION_HEAD_TITLE("", "div#tab-information input[name^=head_title]", TypeLocator.CSS),
	INFORMATION_META_DESCRIPTION("", "div#tab-information input[name^=meta_description]", TypeLocator.CSS),
	
	// ------------------------------------ Price Tab ------------------------------------
	PRICE_PURCHASE_PRICE_VALUE("", "div#tab-prices input[name=purchase_price]", TypeLocator.CSS),
	PRICE_CURRENCY_OF_PURCHASE_PRICE("", "div#tab-prices select[name=purchase_price_currency_code]", TypeLocator.CSS),
	PRICE_CURRENCY_OF_PURCHASE_PRICE_OPTION("", "option", TypeLocator.CSS),
	PRICE_TAX_CLASS("", "div#tab-prices select[name=tax_class_id]", TypeLocator.CSS),
	PRICE_TAX_CLASS_OPTION("", "option", TypeLocator.CSS),
	PRICE_PRICE_CURRENCY_NAME("", "div#tab-prices span.input-wrapper > strong", TypeLocator.CSS),
	PRICE_PRICE("", "div#tab-prices input[name^=price]", TypeLocator.CSS),
	PRICE_PRICE_INCLUDE_TAX("", "div#tab-prices input[name^=gross_prices]", TypeLocator.CSS);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	AddNewProductPageMap(final String text, final String path, final TypeLocator type) {
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
