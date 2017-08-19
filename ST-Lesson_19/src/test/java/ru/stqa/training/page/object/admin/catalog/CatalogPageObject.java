package ru.stqa.training.page.object.admin.catalog;

import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.ADD_NEW_CATEGORY_BTN;
import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.ADD_NEW_PRODUCT_BTN;
import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.CATALOG_TREE_ROW;
import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.CATALOG_TREE_ROW_GROUP_CLOSE_ICON;
import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.CATALOG_TREE_ROW_GROUP_LINK;
import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.CATALOG_TREE_ROW_GROUP_OPEN_ICON;
import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.CATALOG_TREE_ROW_PRODUCT_LINK;
import static ru.stqa.training.page.object.admin.catalog.CatalogPageMap.HEADER_PAGE;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.isElementPresent;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.stqa.training.page.object.PageObject;

public class CatalogPageObject extends PageObject{
	public CatalogPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}
	
	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, HEADER_PAGE.by(), wait);
	}
	
	public void clickAddNewCategoryBtn() {
		click(driver, ADD_NEW_CATEGORY_BTN.by());
	}
	
	public void clickAddNewProductBtn() {
		click(driver, ADD_NEW_PRODUCT_BTN.by());
	}
	
	public boolean findProduct(final String productName) {
		int count;
		String text;
		boolean flag = true; 
		WebElement element;
		while (flag) {
			flag = false;
			count = getCountElements(driver, CATALOG_TREE_ROW.by());
			for (int i=0; i<count; i++) {
				element = getElementByIndex(driver, CATALOG_TREE_ROW.by(), i);
				if (isElementPresent(element, CATALOG_TREE_ROW_GROUP_OPEN_ICON.by())) {
					continue;
				} else if (isElementPresent(element, CATALOG_TREE_ROW_GROUP_CLOSE_ICON.by())) {
					click(element, CATALOG_TREE_ROW_GROUP_LINK.by());
					flag = true;
					break;
				} else {
					text = getAttribute(element, 
							CATALOG_TREE_ROW_PRODUCT_LINK.by(), "textContent");
					if (productName.equals(text)) {
						return true;
					}
				}
			}	
		}		
		
		return false;
	}
	
	public void openAllCategories() {
		int count;
		boolean flag = true;
		WebElement element = null;
		while(flag) {
			flag = false;
			count = getCountElements(driver, CATALOG_TREE_ROW.by());
			for (int i=0; i<count; i++) {
				element = getElementByIndex(driver, CATALOG_TREE_ROW.by(), i);
				if (isElementPresent(element, CATALOG_TREE_ROW_GROUP_OPEN_ICON.by())) {
					continue;
				} else if (isElementPresent(element, CATALOG_TREE_ROW_GROUP_CLOSE_ICON.by())) {
					click(element, CATALOG_TREE_ROW_GROUP_LINK.by());
					flag = true;
					break;
				} else {
					continue;
				}
			}
		}
	}
	
	public int getCountProduct() {
		int count = 0;
		WebElement element = null;
		for (int i=0; i<getCountElements(driver, CATALOG_TREE_ROW.by()); i++) {
			element = getElementByIndex(driver, CATALOG_TREE_ROW.by(), i);
			if (isElementPresent(element, CATALOG_TREE_ROW_PRODUCT_LINK.by())) {
				count++;
			}
		}		
		
		return count;
	}
	
	public void openProductPageByIndex(int index) {
		int count = 0;
		WebElement element = null;
		for (int i=0; i<getCountElements(driver, CATALOG_TREE_ROW.by()); i++) {
			element = getElementByIndex(driver, CATALOG_TREE_ROW.by(), i);
			if (isElementPresent(element, CATALOG_TREE_ROW_PRODUCT_LINK.by())) {
				if (count == index) {
					click(element, CATALOG_TREE_ROW_PRODUCT_LINK.by());
				}
				
				count++;
			}
		}
	}
}






























