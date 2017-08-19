package ru.stqa.training.page.object.user;

import static ru.stqa.training.page.object.admin.LoginPageMap.USERNAME;
import static ru.stqa.training.page.object.user.CreateAccountMap.ADDRESS_1_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.ADDRESS_2_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.CITY_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.COMPANY_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.CONFIRM_PWD_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.COUNTRY_COMBO_BOX;
import static ru.stqa.training.page.object.user.CreateAccountMap.CREATE_ACCOUNT_BTN;
import static ru.stqa.training.page.object.user.CreateAccountMap.DISIRED_PWD_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.EMAIL_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.FIRST_NAME_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.LAST_NAME_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.PAGE_HEADER_H1;
import static ru.stqa.training.page.object.user.CreateAccountMap.PHONE_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.POSTCODE_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.SUBSCRIBE_CHECK_BOX;
import static ru.stqa.training.page.object.user.CreateAccountMap.TAX_ID_FIELD;
import static ru.stqa.training.page.object.user.CreateAccountMap.ZONE_COMBO_BOX;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.getElement;
import static ru.stqa.training.selenium.SharedMethods.typeText;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
	private final WebDriver driver;
	// private final WebDriverWait wait;
	
	public CreateAccountPage(final WebDriver driver /* , final WebDriverWait wait */) {
		this.driver = driver;
		// this.wait = wait;
	}
	
	public String getHeader() {
		return getAttribute(driver, PAGE_HEADER_H1.by(), "textContent");
	}
	
	public void typeTaxId(final String taxId) {
		typeText(driver, TAX_ID_FIELD.by(), taxId);
	}
	
	public void typeCompany(final String company) {
		typeText(driver, COMPANY_FIELD.by(), company);
	}
	
	public void typeFirstName(final String firsName) {
		typeText(driver, FIRST_NAME_FIELD.by(), firsName);
	}
	
	public void typeLastName(final String lastName) {
		typeText(driver, LAST_NAME_FIELD.by(), lastName);
	}
	
	public void typeUsername(final String username) {
		typeText(driver, USERNAME.by(), username);
	}
	
	public void typeAddress_1(final String address_1) {
		typeText(driver, ADDRESS_1_FIELD.by(), address_1);
	}
	
	public void typeAddress_2(final String address_2) {
		typeText(driver, ADDRESS_2_FIELD.by(), address_2);
	}
	
	public void typePostcode(final String postCode) {
		typeText(driver, POSTCODE_FIELD.by(), postCode);
	}
	
	public void typeCity(final String city) {
		typeText(driver, CITY_FIELD.by(), city);
	}
	
	public void selectCountry(final String country) {
		Select select = new Select(getElement(driver, COUNTRY_COMBO_BOX.by()));
		select.selectByValue(country);
	}
	
	public void selectZone(final String zone) {
		Select select = new Select(getElement(driver, ZONE_COMBO_BOX.by()));
		select.selectByValue(zone);
	}
	
	public void typeEmail(final String email) {
		typeText(driver, EMAIL_FIELD.by(), email);
	}
	
	public void typePhone(final String phone) {
		typeText(driver, PHONE_FIELD.by(), phone);
	}
	
	public void checkSubscribe() {
		if (!getElement(driver, SUBSCRIBE_CHECK_BOX.by()).isSelected()) {
			click(driver, SUBSCRIBE_CHECK_BOX.by());
		}
	}
	
	public void uncheckSubscribe() {
		if (getElement(driver, SUBSCRIBE_CHECK_BOX.by()).isSelected()) {
			click(driver, SUBSCRIBE_CHECK_BOX.by());
		}
	}
	
	public void typePassword(final String password) {
		typeText(driver, DISIRED_PWD_FIELD.by(), password);
	}
	
	public void typeConfirmPassword(final String password) {
		typeText(driver, CONFIRM_PWD_FIELD.by(), password);
	}
	
	public void clickCreateAccountBtn() {
		click(driver, CREATE_ACCOUNT_BTN.by());
	}
}
