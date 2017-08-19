package ru.stqa.training.page.object.product;

import static ru.stqa.training.page.object.product.AddNewProductPageMap.SAVE_BTN;
// import static ru.stqa.training.page.object.product.AddNewProductPageMap.CANCEL_BTN;
// import static ru.stqa.training.page.object.product.AddNewProductPageMap.DELETE_BTN;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_CATEGORY_CHECK_BOX;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_CATEGORY_NAME;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_CODE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_DATE_VALID_FROM;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_DATE_VALID_TO;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_DEFAULT_CATEGORY;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_DEF_CATEGORY_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_DELIVERY_STATUS;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_DELIVERY_STATUS_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_GENDER_CHECK_BOX;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_GENDER_NAME;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_NAME;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_QUANTITY;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_QUANTITY_UNIT;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_QUANTITY_UNIT_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_SOLD_OUT_STATUS;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_SOLD_OUT_STATUS_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_STATUS_DISABLE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_STATUS_ENABLE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.GENERAL_UPLOAD_IMAGES;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.HEADER_PAGE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_DESCRIPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_HEAD_TITLE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_KEYWORDS;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_MANUFACTURER;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_MANUFACTURER_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_META_DESCRIPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_SHORT_DESCRIPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_SUPPLIER;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.INFORMATION_SUPPLIER_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_CURRENCY_OF_PURCHASE_PRICE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_CURRENCY_OF_PURCHASE_PRICE_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_PRICE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_PRICE_CURRENCY_NAME;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_PRICE_INCLUDE_TAX;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_PURCHASE_PRICE_VALUE;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_TAX_CLASS;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.PRICE_TAX_CLASS_OPTION;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.TAB_LIST;
import static ru.stqa.training.page.object.product.AddNewProductPageMap.TAB_URL;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.isChecked;
import static ru.stqa.training.selenium.SharedMethods.selectOptionByName;
import static ru.stqa.training.selenium.SharedMethods.typeText;
import static ru.stqa.training.selenium.SharedMethods.typeTextWithoutClear;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewProductPageObject {
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public AddNewProductPageObject(final WebDriver driver, final WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public boolean addNewProductPageIsPresent() {
		return waitElementPresent(driver, HEADER_PAGE.by(), wait);
	}
	
	public void selectTabByName(final String tabName) {
		int countTabs = getCountElements(driver, TAB_LIST.by());
		WebElement tab;
		String text;
		for (int i = 0; i < countTabs; i++) {
			tab = getElementByIndex(driver, TAB_LIST.by(), i);
			text = getAttribute(tab, TAB_URL.by(), "textContent");
			if (tabName.equals(text)) {
				click(tab, TAB_URL.by());
			}
		}
	}
	
	public void clickSave() {
		click(driver, SAVE_BTN.by());
	}
	
// ----------------------------------- General Tab -----------------------------------
	public boolean generalTabIsPresent() {
		return waitElementPresent(driver, GENERAL_STATUS_ENABLE.by(), wait);
	}
	
	public void setStatus(boolean enable) {
		if (enable) {
			click(driver, GENERAL_STATUS_ENABLE.by());
		} else {
			click(driver, GENERAL_STATUS_DISABLE.by());
		}
	}
	
	public void typeName(final String name) {
		typeText(driver, GENERAL_NAME.by(), name);
	}
	
	public void typeCode(final String code) {
		typeText(driver, GENERAL_CODE.by(), code);
	}
	
	public void checkCategory(boolean check, final String name) {
		int count = getCountElements(driver, GENERAL_CATEGORY_CHECK_BOX.by());
		WebElement element;
		for (int i = 0; i < count; i++) {
			element = getElementByIndex(driver, GENERAL_CATEGORY_CHECK_BOX.by(), i);
			if (name.equals(getAttribute(getElementByIndex(driver, GENERAL_CATEGORY_NAME.by(), i), 
					"textContent").trim())) {
				if ((isChecked(element) && !check) || (!isChecked(element) && check)) {
					click(element);
				}				
			}
		}
	}
	
	public boolean selectDefaultCategory(final String value) {
		return selectOptionByName(driver, GENERAL_DEFAULT_CATEGORY.by(), GENERAL_DEF_CATEGORY_OPTION.by(), value);
	}
	
	public void checkGender(boolean check, final String name) {
		int count = getCountElements(driver, GENERAL_GENDER_CHECK_BOX.by());
		WebElement element;
		for (int i = 0; i < count; i++) {
			element = getElementByIndex(driver, GENERAL_GENDER_CHECK_BOX.by(), i);
			if (name.equals(getAttribute(getElementByIndex(driver, GENERAL_GENDER_NAME.by(), i), 
					"textContent").trim())) {
				if ((isChecked(element) && !check) || (!isChecked(element) && check)) {
					click(element);
				}				
			}
		}
	}
	
	public void typeQuantity(double quantity) {
		typeText(driver, GENERAL_QUANTITY.by(), ""+quantity);
	}
	
	public boolean selectQuantityUnit(final String value) {
		return selectOptionByName(driver, GENERAL_QUANTITY_UNIT.by(), GENERAL_QUANTITY_UNIT_OPTION.by(), value);
	}
	
	public boolean selectDeliveryStatus(final String value) {
		return selectOptionByName(driver, GENERAL_DELIVERY_STATUS.by(), GENERAL_DELIVERY_STATUS_OPTION.by(), value);
	}
	
	public boolean selectSoldOutStatus(final String value) {
		return selectOptionByName(driver, GENERAL_SOLD_OUT_STATUS.by(), GENERAL_SOLD_OUT_STATUS_OPTION.by(), value);
	}
	
	public void typeUploadImage(final String fileName) {
		typeTextWithoutClear(driver, GENERAL_UPLOAD_IMAGES.by(), fileName);
	}
	
	public void typeDateValidFrom(final String date) {
		typeTextWithoutClear(driver, GENERAL_DATE_VALID_FROM.by(), date);
	}
	
	public void typeDateValidTo(final String date) {
		typeTextWithoutClear(driver, GENERAL_DATE_VALID_TO.by(), date);
	}
	
// --------------------------------- Information Tab ---------------------------------
	public boolean informationTabIsPresent() {
		return waitElementPresent(driver, INFORMATION_MANUFACTURER.by(), wait);
	}
	
	public boolean selectManufacturer(final String value) {
		return selectOptionByName(driver, INFORMATION_MANUFACTURER.by(), 
				INFORMATION_MANUFACTURER_OPTION.by(), value);
	}
	
	public boolean selectSupplier(final String value) {
		return selectOptionByName(driver, INFORMATION_SUPPLIER.by(), INFORMATION_SUPPLIER_OPTION.by(), value);
	}
	
	public void typeKeywords(final String keywords) {
		typeText(driver, INFORMATION_KEYWORDS.by(), keywords);
	}
	
	public void typeShortDescription(final String shordDescription) {
		typeText(driver, INFORMATION_SHORT_DESCRIPTION.by(), shordDescription);
	}
	
	public void typeDescription(final String description) {
		typeText(driver, INFORMATION_DESCRIPTION.by(), description);
	}
	
	public void typeHeadTitle(final String headTitle) {
		typeText(driver, INFORMATION_HEAD_TITLE.by(), headTitle);
	}
	
	public void typeMetaDescription(final String metaDescription) {
		typeText(driver, INFORMATION_META_DESCRIPTION.by(), metaDescription);
	}
	
// ------------------------------------ Price Tab ------------------------------------
	public boolean priceTabIsPresent() {
		return waitElementPresent(driver, PRICE_PURCHASE_PRICE_VALUE.by(), wait);
	}
	
	public void typePurchasePrice(double price) {
		typeText(driver, PRICE_PURCHASE_PRICE_VALUE.by(), "" + price);
	}
	
	public boolean selectCurrency(final String currency) {
		return selectOptionByName(driver, PRICE_CURRENCY_OF_PURCHASE_PRICE.by(), 
				PRICE_CURRENCY_OF_PURCHASE_PRICE_OPTION.by(), currency);
	}
	
	public boolean selectTaxClass(final String taxClass) {
		return selectOptionByName(driver, PRICE_TAX_CLASS.by(), PRICE_TAX_CLASS_OPTION.by(), taxClass);
	}
	
	public void setPriceByCurrencyName(final String currencyName, double price) {
		int countCurrencyName = getCountElements(driver, PRICE_PRICE.by());
		String name;
		for (int i = 0; i < countCurrencyName; i++) {
			name = getAttribute(getElementByIndex(driver, PRICE_PRICE_CURRENCY_NAME.by(), i), "textContent");
			if (name.equals(currencyName)) {
				typeText(getElementByIndex(driver, PRICE_PRICE.by(), i), "" + price);
			}
		}
	}
	
	public void setPriceInclTaxByCurrencyName(final String currencyName, double price) {
		int countCurrencyName = getCountElements(driver, PRICE_PRICE_INCLUDE_TAX.by());
		String name;
		for (int i = 0; i < countCurrencyName; i++) {
			name = getAttribute(getElementByIndex(driver, PRICE_PRICE_CURRENCY_NAME.by(), i), "textContent");
			if (name.equals(currencyName)) {
				typeText(getElementByIndex(driver, PRICE_PRICE_INCLUDE_TAX.by(), i), "" + price);
			}
		}
	}
}









































