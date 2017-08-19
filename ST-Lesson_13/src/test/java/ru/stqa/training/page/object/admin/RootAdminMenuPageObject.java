package ru.stqa.training.page.object.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.page.object.admin.RootAdminMenuMap.LOGOUT;

public class RootAdminMenuPageObject {
	private final WebDriver driver;
	@SuppressWarnings("unused")
	private final WebDriverWait wait;
	
	public RootAdminMenuPageObject(final WebDriver driver, final WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickLogout() {
		click(driver, LOGOUT.by());
	}
}
