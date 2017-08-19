package ru.stqa.training.selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.stqa.training.selenium.SharedMethods.waitNewWindowPresent;

public class WindowHelper {
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public WindowHelper(final WebDriver driver, final WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public String getActiveWindowId() {
		return driver.getWindowHandle();
	}
	
	public void switchToWindow(final String windowId) {
		driver.switchTo().window(windowId);
	}
	
	public Set<String> getIdCurrentWindows() {
		return driver.getWindowHandles();
	}
	
	public String getNewWindowId(Set<String> oldWindowId) {
		if (!waitNewWindowPresent(driver, wait, oldWindowId)) {
			return "";
		}
		
		Set<String> newWindowId = driver.getWindowHandles();
		for (String id : newWindowId) {
			if (oldWindowId.contains(id)) {
				continue;
			} else {
				return id;
			}
		}
		
		return "";
	}
	
	public void closeActiveWindow() {
		driver.close();
	}
}
