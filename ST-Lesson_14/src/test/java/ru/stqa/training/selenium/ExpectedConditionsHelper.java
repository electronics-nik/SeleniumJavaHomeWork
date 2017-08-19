package ru.stqa.training.selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionsHelper {
	public static ExpectedCondition<Boolean> presentNewWindow(final WebDriver driver, final Set<String> oldWindowId) {
		return new ExpectedCondition<Boolean>() {			
			public Boolean apply(WebDriver input) {
				Set<String> set = driver.getWindowHandles();
				if (set.size() > oldWindowId.size()) {
					return true;
				} 
				
				for (String id : set) {
					if (oldWindowId.contains(id)) {
						continue;
					} else {
						return true;
					}
				}
								
				return null;
			}			
		};
	}
}
