package ru.stqa.training.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import ru.stqa.training.page.object.admin.AdminMenuPageObject;
import ru.stqa.training.page.object.admin.LoginAdminPageObject;
import ru.stqa.training.page.object.admin.RootAdminMenuPageObject;
import ru.stqa.training.page.object.catalog.CatalogPageObject;
import ru.stqa.training.page.object.product.AddNewProductPageObject;
import ru.stqa.training.selenium.TestBase;

public class LiteCartTest extends TestBase{
	private static final String productName = "Test Product 1";
	
	@Test(priority = 0, enabled = true)
	public void createNewProduct() {
		LoginAdminPageObject login = new LoginAdminPageObject(driver, wait);
		AdminMenuPageObject menu = new AdminMenuPageObject(driver, wait);
		CatalogPageObject catalog = new CatalogPageObject(driver, wait);
		AddNewProductPageObject product = new AddNewProductPageObject(driver, wait);
		RootAdminMenuPageObject rootMenu = new RootAdminMenuPageObject(driver, wait);
		
		assertTrue(login.loginAdminFormIsPresent());
		login.typeUserName("admin");
		login.typeUserPasword("admin123");
		login.clickLoginBtn();	
		
		assertTrue(menu.isAdminMenuPresent());
		menu.clickMenuSubitemByName("Catalog", "Catalog");
		
		assertTrue(catalog.catalogPageIsPresent());
		catalog.clickAddNewProductBtn();
		
		assertTrue(product.addNewProductPageIsPresent());
		
		// ----------------------------------- General Tab -----------------------------------
		product.selectTabByName("General");
		assertTrue(product.generalTabIsPresent());
		
		product.setStatus(true);
		product.typeName(LiteCartTest.productName);
		product.typeCode("new code product");
		product.checkCategory(false, "");
		product.checkCategory(true, "Subcategory");
		assertTrue(product.selectDefaultCategory("Subcategory"));
		product.checkGender(true, "Unisex");
		product.typeQuantity(10);
		assertTrue(product.selectQuantityUnit("pcs"));
		assertTrue(product.selectDeliveryStatus("3-5 days"));
		assertTrue(product.selectSoldOutStatus("Temporary sold out"));
		product.typeUploadImage("D:/viber image 2.jpg");
		product.typeDateValidFrom("01.01.2016");
		product.typeDateValidTo("31.12.2016");
				
		// --------------------------------- Information Tab ---------------------------------
		product.selectTabByName("Information");
		assertTrue(product.informationTabIsPresent());
		assertTrue(product.selectManufacturer("ACME Corp."));
		assertTrue(product.selectSupplier("Amazon"));
		product.typeKeywords("Test, Selenium, TestNG");
		product.typeShortDescription("Test product");
		product.typeDescription("Large description for new product");
		product.typeHeadTitle("Head title for new product");
		product.typeMetaDescription("Meta description");		
		
		// ------------------------------------ Price Tab ------------------------------------
		product.selectTabByName("Prices");
		assertTrue(product.priceTabIsPresent());
		product.typePurchasePrice(12.45);
		assertTrue(product.selectCurrency("US Dollars"));
		
		product.setPriceByCurrencyName("USD", 12.45);
		product.setPriceByCurrencyName("RUB", 345.33);
		product.setPriceByCurrencyName("EUR", 10.22);
		product.setPriceByCurrencyName("UAH", 280.25);
				
		product.clickSave();
		rootMenu.clickLogout();
	}
	
	@Test(priority = 10, dependsOnMethods = "createNewProduct") 
	public void verifyNewProduct() {
		LoginAdminPageObject login = new LoginAdminPageObject(driver, wait);
		AdminMenuPageObject menu = new AdminMenuPageObject(driver, wait);
		CatalogPageObject catalog = new CatalogPageObject(driver, wait);
		RootAdminMenuPageObject rootMenu = new RootAdminMenuPageObject(driver, wait);
		
		assertTrue(login.loginAdminFormIsPresent());
		login.typeUserName("admin");
		login.typeUserPasword("admin123");
		login.clickLoginBtn();	
		
		assertTrue(menu.isAdminMenuPresent());
		menu.clickMenuSubitemByName("Catalog", "Catalog");
		
		assertTrue(catalog.faindProduct(LiteCartTest.productName));
		
		rootMenu.clickLogout();
	}
}



































