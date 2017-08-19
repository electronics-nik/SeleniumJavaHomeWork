package ru.stqa.training.tests;

import static org.testng.Assert.assertTrue;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.getElements;
import static ru.stqa.training.selenium.SharedMethods.getText;
import static ru.stqa.training.selenium.SharedMethods.isElementPresent;
import static ru.stqa.training.selenium.SharedMethods.titleIsPresent;
import static ru.stqa.training.selenium.SharedMethods.typeText;
import static ru.stqa.training.selenium.maps.CountriesPageMap.COUNTRIE_PAGE_TITLE;
import static ru.stqa.training.selenium.maps.CountriesPageMap.COUNTRIE_HREF;
import static ru.stqa.training.selenium.maps.CountriesPageMap.COUNTRIE_ROWS;
import static ru.stqa.training.selenium.maps.CountriesPageMap.COUNTRIE_ZONE;
import static ru.stqa.training.selenium.maps.CountriesPageMap.ZONE_PAGE_TITLE;
import static ru.stqa.training.selenium.maps.CountriesPageMap.ZONE_CANCEL_BTN;
import static ru.stqa.training.selenium.maps.CountriesPageMap.ZONE_NAME;
import static ru.stqa.training.selenium.maps.CountriesPageMap.ZONE_ROWS;
import static ru.stqa.training.selenium.maps.LoginPageMap.LOGIN_BTN;
import static ru.stqa.training.selenium.maps.LoginPageMap.PASSWORD;
import static ru.stqa.training.selenium.maps.LoginPageMap.USERNAME;
import static ru.stqa.training.selenium.maps.LoginPageMap.LOGIN_PAGE_ANCHOR;
import static ru.stqa.training.selenium.maps.RootMenuMap.ITEM_MENU_LOGOUT;

import java.util.ArrayList;
import java.util.TreeSet;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ru.stqa.training.selenium.TestBase;

public class LiteCartTest extends TestBase{

	@Test(priority = 0)
	public void login() {
		assertTrue(isElementPresent(driver, LOGIN_PAGE_ANCHOR.by()));
		
		typeText(driver, USERNAME.by(), "admin");
		typeText(driver, PASSWORD.by(), "admin123");
		click(driver, LOGIN_BTN.by());
		
		assertTrue(titleIsPresent(wait, COUNTRIE_PAGE_TITLE.text()), "");
	}	
	
	@Test(priority = 10, dependsOnMethods="login")
	public void verifySortCountries() {
		ArrayList<String> origOrder = new ArrayList<String>();
		TreeSet<String> sortedOrder = new TreeSet<String>();
		assertTrue(isElementPresent(driver, COUNTRIE_ROWS.by()));
		
		String name;
		for (WebElement row : getElements(driver, COUNTRIE_ROWS.by())) {
			name = getAttribute(row, COUNTRIE_HREF.by(), "textContent");
			origOrder.add(name);
			sortedOrder.add(name);
		}
		
		assertTrue(compare(origOrder, sortedOrder));
	}
	
	@Test(priority = 20, dependsOnMethods="login") 
	public void verifySortZones() {
		assertTrue(isElementPresent(driver, COUNTRIE_ROWS.by()));
		int countRows = getCountElements(driver, COUNTRIE_ROWS.by());
		int countZones;
		ArrayList<String> origOrder = new ArrayList<String>();
		TreeSet<String> sortedOrder = new TreeSet<String>();
		String name;
		for(int i=0; i<countRows; i++) {
			origOrder.clear();
			sortedOrder.clear();
			assertTrue(isElementPresent(driver, COUNTRIE_ROWS.by()));
			if(!"0".equals(getText(getElementByIndex(driver, COUNTRIE_ROWS.by(), i), COUNTRIE_ZONE.by()))) {
				System.out.println(getAttribute(getElementByIndex(driver, COUNTRIE_ROWS.by(), i), COUNTRIE_HREF.by(), "textContent"));
				click(getElementByIndex(driver, COUNTRIE_ROWS.by(), i), COUNTRIE_HREF.by());
				assertTrue(titleIsPresent(wait, ZONE_PAGE_TITLE.text()), "");
				countZones = getCountElements(driver, ZONE_ROWS.by()) - 1;
				for(int j=0; j<countZones; j++) {
					name = getText(getElementByIndex(driver, ZONE_ROWS.by(), j), ZONE_NAME.by());
					origOrder.add(name);
					sortedOrder.add(name);
				}
				
				assertTrue(compare(origOrder, sortedOrder));				
				click(driver, ZONE_CANCEL_BTN.by());
			}
		}
	}
	
	@Test(priority = 30, dependsOnMethods="login")
	public void logout() {
		assertTrue(isElementPresent(driver, ITEM_MENU_LOGOUT.by()));
		click(driver, ITEM_MENU_LOGOUT.by());
		assertTrue(isElementPresent(driver, LOGIN_PAGE_ANCHOR.by()));
	}
	
	private boolean compare(ArrayList<String> origOrder, TreeSet<String> sortedOrder) {
		String []str = sortedOrder.toArray(new String[sortedOrder.size()]);
		for(int i = 0; i<origOrder.size(); i++) {
			System.out.println('\t' + origOrder.get(i) + " <===> " + str[i]);
			if (!origOrder.get(i).trim().toLowerCase().equals(str[i].trim().toLowerCase())) {
				return false;
			}
		}
		
		return true;
	}
}



































