package ru.stqa.training.page.object.user.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;
import static ru.stqa.training.selenium.SharedMethods.waitElementStaleness;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.page.object.user.cart.CartPageMap.CART_IS_EMPTY;
import static ru.stqa.training.page.object.user.cart.CartPageMap.CART_PRODUCT_FIRST;
import static ru.stqa.training.page.object.user.cart.CartPageMap.CART_PRODUCT_IN_TABLE;
import static ru.stqa.training.page.object.user.cart.CartPageMap.CART_PRODUCT_NAME;
import static ru.stqa.training.page.object.user.cart.CartPageMap.CART_PRODUCT_REMOVE_BTN;
import static ru.stqa.training.page.object.user.cart.CartPageMap.CART_SHORTCUT_FIRST;
import static ru.stqa.training.page.object.user.cart.CartPageMap.CART_SHORTCUT_LINK;
import static ru.stqa.training.page.object.user.cart.CartPageMap.HEADER_PAGE;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.getElement;
import static ru.stqa.training.selenium.SharedMethods.isElementPresent;

import ru.stqa.training.page.object.PageObject;

public class CartPageObject extends PageObject {
	public CartPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public boolean pageIsPresent() {
		return (waitElementPresent(driver, HEADER_PAGE.by(), wait) ||
				waitElementPresent(driver, CART_IS_EMPTY.by(), wait));
	}

	public boolean deleteAllProducts() {
		int count;
		String productName;
		String productNameInTable;
		WebElement element = null;
		while(isElementPresent(driver, CART_SHORTCUT_FIRST.by())) {
			click(getElement(driver, CART_SHORTCUT_FIRST.by()), CART_SHORTCUT_LINK.by());
			productName = getAttribute(getElement(driver, CART_PRODUCT_FIRST.by()), CART_PRODUCT_NAME.by(), "textContent");
			
			count = getCountElements(driver, CART_PRODUCT_IN_TABLE.by());
			for (int i=0; i<count; i++) {
				productNameInTable = getAttribute(getElementByIndex(driver, CART_PRODUCT_IN_TABLE.by(), i), "textContent");
				if (productName.equals(productNameInTable)) {
					element = getElementByIndex(driver, CART_PRODUCT_IN_TABLE.by(), i);
					break;
				}
			}
			
			click(getElement(driver, CART_PRODUCT_FIRST.by()), CART_PRODUCT_REMOVE_BTN.by());
			if (!waitElementStaleness(element, wait)) {
				return false;
			}
		}
		
		if (!isElementPresent(driver, CART_PRODUCT_FIRST.by())) {
			return true;
		}
		
		productName = getAttribute(getElement(driver, CART_PRODUCT_FIRST.by()), 
				CART_PRODUCT_NAME.by(), "textContent");
		productNameInTable = getAttribute(driver, CART_PRODUCT_IN_TABLE.by(), "textContent");
		if (productName.equals(productNameInTable)) {
			element = getElement(driver, CART_PRODUCT_IN_TABLE.by());
		}
		
		click(getElement(driver, CART_PRODUCT_FIRST.by()), CART_PRODUCT_REMOVE_BTN.by());
		if (!waitElementStaleness(element, wait)) {
			return false;
		}
			
		return true;
	}
}
