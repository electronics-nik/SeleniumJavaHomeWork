package ru.stqa.training.page.object.admin.countries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.stqa.training.page.object.admin.countries.CountriesPageMap.COUNTRIES_PAGE_TITLE; 
import static ru.stqa.training.page.object.admin.countries.CountriesPageMap.COUNTRIES_ROWS;
import static ru.stqa.training.page.object.admin.countries.CountriesPageMap.COUNTRIES_HREF;

import ru.stqa.training.page.object.PageObject;

import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.click;

public class CountriesPageObject extends PageObject {

	public CountriesPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, COUNTRIES_PAGE_TITLE.by(), wait);
	}

	public void clickCountryByName(final String countryName) {
		int countCountries = getCountElements(driver, COUNTRIES_ROWS.by());
		String name;
		for (int i=0; i<countCountries; i++) {
			name = getAttribute(getElementByIndex(driver, COUNTRIES_ROWS.by(), i),
					COUNTRIES_HREF.by(), "textContent");
			
			if (countryName.equals(name)) {
				click(getElementByIndex(driver, COUNTRIES_ROWS.by(), i),
					COUNTRIES_HREF.by());
				break;
			}
		}
	}
}
