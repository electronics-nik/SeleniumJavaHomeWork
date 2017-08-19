package ru.stqa.training.tests;

import static org.testng.Assert.assertTrue;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.getElement;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.getText;
import static ru.stqa.training.selenium.SharedMethods.isElementsPresent;
import static ru.stqa.training.selenium.SharedMethods.titleIsPresent;
import static ru.stqa.training.selenium.SharedMethods.typeText;
import static ru.stqa.training.selenium.maps.LoginPageLocator.LOGIN_BTN;
import static ru.stqa.training.selenium.maps.LoginPageLocator.PASSWORD;
import static ru.stqa.training.selenium.maps.LoginPageLocator.USERNAME;
import static ru.stqa.training.selenium.maps.MenuLocators.MENU_ITEMS_LI;
import static ru.stqa.training.selenium.maps.MenuLocators.MENU_ITEM_NAME;
import static ru.stqa.training.selenium.maps.MenuLocators.MENU_ITEM_URL;
import static ru.stqa.training.selenium.maps.MenuLocators.MENU_ITEM_SELECTED;
import static ru.stqa.training.selenium.maps.MenuLocators.MENU_SUBMENU_ITEMS_LI;

import static ru.stqa.training.selenium.maps.ContentPageMap.CONTENT_PAGE_HEADER;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ru.stqa.training.selenium.TestBase;

public class LiteCartTest extends TestBase{
	
	@Test(priority = 0)
	public void login() {
		typeText(driver, USERNAME.by(), "admin");
		typeText(driver, PASSWORD.by(), "admin123");
		click(driver, LOGIN_BTN.by());
		
		assertTrue(titleIsPresent(wait, "My Store"), "Ошибка процедуры логина");
	}
	
	@Test(priority = 10)
	public void menuItem() {
		assertTrue(isElementsPresent(driver, MENU_ITEMS_LI.by()), "Left menu is not present");
		WebElement item, subItem;
		int countItems = getCountElements(driver, MENU_ITEMS_LI.by());
		int countSubItems = 0;
		for (int i=0; i<countItems; i ++) {
			item = getElementByIndex(driver, MENU_ITEMS_LI.by(), i);
			System.out.println(getText(item, MENU_ITEM_NAME.by()));
			click(item, MENU_ITEM_URL.by());
			item = getElement(driver, MENU_ITEM_SELECTED.by());
			countSubItems = getCountElements(item, MENU_SUBMENU_ITEMS_LI.by());
			for (int j=0; j<countSubItems; j++) {
				item = getElement(driver, MENU_ITEM_SELECTED.by());
				subItem = getElementByIndex(item, MENU_SUBMENU_ITEMS_LI.by(), j);
				System.out.print('\t' + getText(subItem, MENU_ITEM_NAME.by()));
				click(subItem, MENU_ITEM_URL.by());
				
				assertTrue(isElementsPresent(driver, CONTENT_PAGE_HEADER.by()));
				System.out.println("\t- " + getText(driver, CONTENT_PAGE_HEADER.by()));
			}
			
			if (countSubItems == 0) {
				assertTrue(isElementsPresent(driver, CONTENT_PAGE_HEADER.by()));
				System.out.println("\t- " + getText(driver, CONTENT_PAGE_HEADER.by()));
			}
		}
	}
}
