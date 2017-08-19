package ru.stqa.training.page.object.admin.countries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.stqa.training.page.object.admin.countries.EditCountryPageMap.COUNTRY_EDIT_PAGE_TITLE;
import static ru.stqa.training.page.object.admin.countries.EditCountryPageMap.COUNTRY_EDIT_PAGE_CODE_ALPHA2_LINK;
import static ru.stqa.training.page.object.admin.countries.EditCountryPageMap.COUNTRY_EDIT_PAGE_CODE_ALPHA3_LINK;
import static ru.stqa.training.page.object.admin.countries.EditCountryPageMap.COUNTRY_EDIT_PAGE_TAX_ID_FORMAT_LINK;
import static ru.stqa.training.page.object.admin.countries.EditCountryPageMap.COUNTRY_EDIT_PAGE_POSTCODE_FORMAT_LINK;
import static ru.stqa.training.page.object.admin.countries.EditCountryPageMap.COUNTRY_EDIT_PAGE_CURRENCY_CODE_LINK;
import static ru.stqa.training.page.object.admin.countries.EditCountryPageMap.COUNTRY_EDIT_PAGE_PHONE_COUNTRY_CODE_LINK;

import ru.stqa.training.page.object.PageObject;

import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.waitTitlePagePresent;

public class EditCountryPageObject extends PageObject {

	public EditCountryPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, COUNTRY_EDIT_PAGE_TITLE.by(), wait);
	}

	public void clickCodeAlpha2Link() {
		click(driver, COUNTRY_EDIT_PAGE_CODE_ALPHA2_LINK.by());
	}
	
	public boolean virifyCodeAlpha2Window() {
		return waitTitlePagePresent(driver, wait, COUNTRY_EDIT_PAGE_CODE_ALPHA2_LINK.text());
	}
	
	public void clickCodeAlpha3Link() {
		click(driver, COUNTRY_EDIT_PAGE_CODE_ALPHA3_LINK.by());
	}
	
	public boolean virifyCodeAlpha3Window() {
		return waitTitlePagePresent(driver, wait, COUNTRY_EDIT_PAGE_CODE_ALPHA3_LINK.text());
	}
	
	public void clickTaxIdFormatLink() {
		click(driver, COUNTRY_EDIT_PAGE_TAX_ID_FORMAT_LINK.by());
	}
	
	public boolean virifyTaxIdFormatWindow() {
		return waitTitlePagePresent(driver, wait, COUNTRY_EDIT_PAGE_TAX_ID_FORMAT_LINK.text());
	}
	
	public void clickPostcodeFormatLink() {
		click(driver, COUNTRY_EDIT_PAGE_POSTCODE_FORMAT_LINK.by());
	}
	
	public boolean virifyPostcodeFormatWindow() {
		return waitTitlePagePresent(driver, wait, COUNTRY_EDIT_PAGE_POSTCODE_FORMAT_LINK.text());
	}
	
	public void clickCurrencyCodeLink() {
		click(driver, COUNTRY_EDIT_PAGE_CURRENCY_CODE_LINK.by());
	}
	
	public boolean virifyCurrencyCodeWindow() {
		return waitTitlePagePresent(driver, wait, COUNTRY_EDIT_PAGE_CURRENCY_CODE_LINK.text());
	}
	
	public void clickPhoneCountryCodeLink() {
		click(driver, COUNTRY_EDIT_PAGE_PHONE_COUNTRY_CODE_LINK.by());
	}
	
	public boolean virifyPhoneCountryWindow() {
		return waitTitlePagePresent(driver, wait, COUNTRY_EDIT_PAGE_PHONE_COUNTRY_CODE_LINK.text());
	}
}
