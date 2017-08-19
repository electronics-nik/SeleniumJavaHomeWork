package ru.stqa.training.page.object.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.stqa.training.page.object.PageObject;

import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;
import static ru.stqa.training.page.object.admin.RootAdminMenuMap.LOGOUT;

public class RootAdminMenuPageObject extends PageObject{
	
	public RootAdminMenuPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}
	
	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, LOGOUT.by(), wait);
	}
	
	public void clickLogout() {
		click(driver, LOGOUT.by());
	}
}
