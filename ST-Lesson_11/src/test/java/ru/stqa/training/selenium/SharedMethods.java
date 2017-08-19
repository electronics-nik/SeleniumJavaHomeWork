package ru.stqa.training.selenium;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SharedMethods {
	public static WebElement getElement(final WebDriver driver, final By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(final WebElement element, final By locator) {
		return element.findElement(locator);
	}
// ---------------------------------------------------------------------------------------------------------	
	public static WebElement getElementByIndex(final WebDriver driver, final By locator, int index) {
		return driver.findElements(locator).get(index);
	}
	
	public static WebElement getElementByIndex(final WebElement element, final By locator, int index) {
		return element.findElements(locator).get(index);
	}
// ---------------------------------------------------------------------------------------------------------	
	public static List<WebElement> getElements(final WebDriver driver, final By locator) {
		return driver.findElements(locator);
	}
	
	public static List<WebElement> getElements(final WebElement element, final By locator) {
		return element.findElements(locator);
	}
// ---------------------------------------------------------------------------------------------------------	
	public static int getCountElements(final WebDriver driver, final By locator) {
		return driver.findElements(locator).size();
	}
	
	public static int getCountElements(final WebElement element, final By locator) {
		return element.findElements(locator).size();
	}
// ---------------------------------------------------------------------------------------------------------	
	public static void click(final WebDriver driver, final By locator) {
		getElement(driver, locator).click();
	}
	
	public static void click(final WebElement element, final By locator) {
		getElement(element, locator).click();
	}
// ---------------------------------------------------------------------------------------------------------	
	public static boolean isElementsPresent(final WebDriver driver, final By locator) {
		try {
			return getElements(driver, locator).size() > 0;
		} catch (InvalidSelectorException ex) {
			return false;
		}
	}
	
	public static boolean isElementsPresent(final WebElement element, final By locator) {
		try {
			return getElements(element, locator).size() > 0;
		} catch (InvalidSelectorException ex) {
			return false;
		}
	}
// ---------------------------------------------------------------------------------------------------------
	public static boolean isElementPresent(final WebDriver driver, final By locator) {
		try {
			getElement(driver, locator);
			return true;
		} catch (InvalidSelectorException ex) {
			throw ex;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public static boolean isElementPresent(final WebElement element, final By locator) {
		try {
			getElement(element, locator);
			return true;
		} catch (InvalidSelectorException ex) {
			throw ex;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
// ---------------------------------------------------------------------------------------------------------	
	public static String getText(final WebDriver driver, final By locator) {
		return getElement(driver, locator).getText();
	}
	
	public static String getText(final WebElement element, final By locator) {
		return getElement(element, locator).getText();
	}
// ---------------------------------------------------------------------------------------------------------
	public static String getAttribute(final WebDriver driver, final By locator, final String attribute) {
		return getElement(driver, locator).getAttribute(attribute);
	}
	
	public static String getAttribute(final WebElement element, final By locator, final String attribute) {
		return getElement(element, locator).getAttribute(attribute);
	}
// ---------------------------------------------------------------------------------------------------------
	public static String getElementColor(final WebDriver driver, final By locator) {
		return getElement(driver, locator).getCssValue("color");
	}
	
	public static String getElementColor(final WebElement element, final By locator) {
		return getElement(element, locator).getCssValue("color");
	}
// ---------------------------------------------------------------------------------------------------------
	public static String getElementFontSize(final WebDriver driver, final By locator) {
		return getElement(driver, locator).getCssValue("font-size");
	}
	
	public static String getElementFontSize(final WebElement element, final By locator) {
		return getElement(element, locator).getCssValue("font-size");
	}
// ---------------------------------------------------------------------------------------------------------
	public static String getElementFontWeight(final WebDriver driver, final By locator) {
		return getElement(driver, locator).getCssValue("font-weight");
	}
	
	public static String getElementFontWeight(final WebElement element, final By locator) {
		return getElement(element, locator).getCssValue("font-weight");
	}
// ---------------------------------------------------------------------------------------------------------
	public static String getElementTextDecoration(final WebDriver driver, final By locator) {
		return getElement(driver, locator).getCssValue("text-decoration");
	}
		
	public static String getElementTextDecoration(final WebElement element, final By locator) {
		return getElement(element, locator).getCssValue("text-decoration");
	}
// ---------------------------------------------------------------------------------------------------------
	public static boolean isChecked(final WebDriver driver, final By locator) {
		return Boolean.parseBoolean(getAttribute(driver, locator, "checked"));
	}
		
	public static boolean isChecked(final WebElement element, final By locator) {
		return Boolean.parseBoolean(getAttribute(element, locator, "checked"));
	}
// ---------------------------------------------------------------------------------------------------------
	public static boolean waitElementPresent(final WebDriver driver, final By locator, final WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(getElement(driver, locator)));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}
	
	public static boolean waitElementPresent(final WebElement element, final By locator, final WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(getElement(element, locator)));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}
// ---------------------------------------------------------------------------------------------------------	
	public static void typeText(final WebDriver driver, final By locator, final String text) {
		click(driver, locator);
		clearField(driver, locator);
		sendKeys(driver, locator, text);
	}
		
	public static boolean titleIsPresent(final WebDriverWait wait, final String title) {
		return wait.until(titleIs(title));
	}
			
	public static void sendKeys(final WebDriver driver, final By locator, final CharSequence... value) {
		getElement(driver, locator).sendKeys(value);
	}
	
	public static void clearField(final WebDriver driver, final By locator) {
		getElement(driver, locator).clear();
	}
// ---------------------------------------------------------------------------------------------------------
}
