package ru.stqa.training.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class PageObject {
	protected final WebDriver driver;
	protected final WebDriverWait wait;
	
	public PageObject(final WebDriver driver, final WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	abstract public boolean pageIsPresent();
}
