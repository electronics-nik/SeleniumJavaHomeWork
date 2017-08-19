package ru.stqa.training.page.object.admin.catalog;

import org.openqa.selenium.By;

import ru.stqa.training.selenium.maps.TypeLocator;

public enum CatalogPageMap {
	HEADER_PAGE("Catalog", "td#content > h1", TypeLocator.CSS),
	ADD_NEW_CATEGORY_BTN("", "Add New Category", TypeLocator.LINK),
	ADD_NEW_PRODUCT_BTN("", "Add New Product", TypeLocator.LINK),
	CATALOG_TREE_ROW("", "form[name=catalog_form] tr.row", TypeLocator.CSS),
	CATALOG_TREE_ROW_GROUP_OPEN_ICON("", "i.fa.fa-folder-open", TypeLocator.CSS),
	CATALOG_TREE_ROW_GROUP_CLOSE_ICON("", "i.fa.fa-folder", TypeLocator.CSS),
	CATALOG_TREE_ROW_GROUP_LINK("", "//*/td[count(i[@class='fa fa-folder'])=1]/a", TypeLocator.XPATH),
	CATALOG_TREE_ROW_PRODUCT_LINK("", ".//td[count(img)=1]/a", TypeLocator.XPATH);
	
	private final String text;
	private final String path;
	private final TypeLocator type;
	
	CatalogPageMap(final String text, final String path, final TypeLocator type) {
		this.text = text;
		this.path = path;
		this.type = type;
	}
	
	public String text() {
		return text;
	}
	
	public By by() {
		if (type == TypeLocator.CSS) {
			return By.cssSelector(path);
		} else if (type == TypeLocator.LINK) {
			return By.linkText(path);
		} else {
			return By.xpath(path);
		}
	}
}
