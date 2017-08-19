package ru.stqa.training.page.object.user.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.stqa.training.page.object.PageObject;

import static ru.stqa.training.page.object.user.header.HeaderMap.CHECKOUT_LINK;
import static ru.stqa.training.page.object.user.header.HeaderMap.COUNT_ITEMS_INTO_CART;
import static ru.stqa.training.page.object.user.header.HeaderMap.HOME_LINK;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;

public class HeaderPageObject extends PageObject {

	public HeaderPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, HOME_LINK.by(), wait);
	}
	
	public void goToHomePage() {
		click(driver, HOME_LINK.by());
	}
	
	public void checkout() {
		click(driver, CHECKOUT_LINK.by());
	}
	
	public int getCountItemIntoCart() {
		return Integer.parseInt(getAttribute(driver, COUNT_ITEMS_INTO_CART.by(), "textContent"));
	}
}
