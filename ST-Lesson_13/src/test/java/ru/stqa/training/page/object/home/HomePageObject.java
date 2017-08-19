package ru.stqa.training.page.object.home;

import static ru.stqa.training.page.object.home.MostPopularMap.MS_HEADER_SECTION;
import static ru.stqa.training.page.object.home.MostPopularMap.MS_PRODUCT_LINK;
import static ru.stqa.training.page.object.home.MostPopularMap.MS_PRODUCT_LIST;
import static ru.stqa.training.page.object.home.MostPopularMap.MS_PRODUCT_NAME;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.stqa.training.page.object.PageObject;

public class HomePageObject extends PageObject{
	public HomePageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, MS_HEADER_SECTION.by(), wait);
	}
	
	public boolean sectionIsEmpty() {
		int count = getCountElements(driver, MS_PRODUCT_LIST.by());
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean msFindElementByName(final String productName) {
		String name;
		for(int i=0; i<getCountElements(driver, MS_PRODUCT_LIST.by()); i++) {
			name = getAttribute(getElementByIndex(driver, MS_PRODUCT_LIST.by(), i),
					MS_PRODUCT_NAME.by(), "textContent");
			if (productName.equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void msClickProductByName(final String productName) {
		String name;
		for(int i=0; i<getCountElements(driver, MS_PRODUCT_LIST.by()); i++) {
			name = getAttribute(getElementByIndex(driver, MS_PRODUCT_LIST.by(), i),
					MS_PRODUCT_NAME.by(), "textContent");
			if (productName.equals(name)) {
				click(getElementByIndex(driver, MS_PRODUCT_LIST.by(), i), MS_PRODUCT_LINK.by());
			}
		}
	}
}
