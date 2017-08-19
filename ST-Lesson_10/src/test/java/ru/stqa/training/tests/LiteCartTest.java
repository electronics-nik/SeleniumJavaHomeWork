package ru.stqa.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.getElementByIndex;
import static ru.stqa.training.selenium.SharedMethods.isElementPresent;
import static ru.stqa.training.selenium.SharedMethods.getElementColor;
import static ru.stqa.training.selenium.SharedMethods.getElementFontSize;
import static ru.stqa.training.selenium.SharedMethods.getElementFontWeight;
import static ru.stqa.training.selenium.SharedMethods.getElementTextDecoration;
import static ru.stqa.training.selenium.maps.CampaignsProductMap.CAM_PRODUCT_CAM_PRICE;
import static ru.stqa.training.selenium.maps.CampaignsProductMap.CAM_PRODUCT_HREF;
import static ru.stqa.training.selenium.maps.CampaignsProductMap.CAM_PRODUCT_LIST;
import static ru.stqa.training.selenium.maps.CampaignsProductMap.CAM_PRODUCT_NAME;
import static ru.stqa.training.selenium.maps.CampaignsProductMap.CAM_PRODUCT_REG_PRICE;
import static ru.stqa.training.selenium.maps.ProductPageMap.PRODUCT_CAM_PRICE;
import static ru.stqa.training.selenium.maps.ProductPageMap.PRODUCT_NAME;
import static ru.stqa.training.selenium.maps.ProductPageMap.PRODUCT_REG_PRICE;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ru.stqa.training.selenium.TestBase;

public class LiteCartTest extends TestBase{

	@Test
	public void operationYellowDuck() {
		assertTrue(isElementPresent(driver, CAM_PRODUCT_LIST.by()));
		int countProduct = getCountElements(driver, CAM_PRODUCT_LIST.by());
		String name1, name2;
		String regPrice1, regPrice2;
		String camPrice1, camPrice2;
				
		WebElement product;
		for (int i=0; i<countProduct; i++) {
			assertTrue(isElementPresent(driver, CAM_PRODUCT_LIST.by()));
			product = getElementByIndex(driver, CAM_PRODUCT_LIST.by(), i);
			name1 = getAttribute(product, CAM_PRODUCT_NAME.by(), "textContent");
			regPrice1 = getAttribute(product, CAM_PRODUCT_REG_PRICE.by(), "textContent");
			assertEquals(getElementColor(product, CAM_PRODUCT_REG_PRICE.by()), 
					"rgba(119, 119, 119, 1)", "");
			assertEquals(getElementFontSize(product, CAM_PRODUCT_REG_PRICE.by()), 
					"14.4px", "");
			assertEquals(getElementTextDecoration(product, CAM_PRODUCT_REG_PRICE.by()), 
					"line-through");
			
			camPrice1 = getAttribute(product, CAM_PRODUCT_CAM_PRICE.by(), "textContent");
			assertEquals(getElementColor(product, CAM_PRODUCT_CAM_PRICE.by()), 
					"rgba(204, 0, 0, 1)", "");
			assertEquals(getElementFontSize(product, CAM_PRODUCT_CAM_PRICE.by()), 
					"18px", "");
			assertEquals(getElementFontWeight(product, CAM_PRODUCT_CAM_PRICE.by()), 
					"bold");
			
			click(product, CAM_PRODUCT_HREF.by());
			
			assertTrue(isElementPresent(driver, PRODUCT_NAME.by()));
			name2 = getAttribute(driver, PRODUCT_NAME.by(), "textContent");
			regPrice2 = getAttribute(driver, PRODUCT_REG_PRICE.by(), "textContent");
			assertEquals(getElementColor(driver, PRODUCT_REG_PRICE.by()), 
					"rgba(102, 102, 102, 1)", "PRODUCT_REG_PRICE color is nod GREY");
			assertEquals(getElementFontSize(driver, PRODUCT_REG_PRICE.by()), 
					"16px", "PRODUCT_REG_PRICE font size is not 16px");
			assertEquals(getElementTextDecoration(driver, PRODUCT_REG_PRICE.by()), 
					"line-through", "PRODUCT_REG_PRICE isn't line-through");
			
			camPrice2 = getAttribute(driver, PRODUCT_CAM_PRICE.by(), "textContent");
			assertEquals(getElementColor(driver, PRODUCT_CAM_PRICE.by()), 
					"rgba(204, 0, 0, 1)", "PRODUCT_CAM_PRICE color is not RED");
			assertEquals(getElementFontSize(driver, PRODUCT_CAM_PRICE.by()), 
					"22px", "PRODUCT_CAM_PRICE font size is not 22px");
			assertEquals(getElementFontWeight(driver, PRODUCT_CAM_PRICE.by()), 
					"bold", "PRODUCT_CAM_PRICE is not BOLD");
			
			assertEquals(name1, name2, "Product name is not equals");
			assertEquals(regPrice1, regPrice2, "Regular price is not equals");
			assertEquals(camPrice1, camPrice2, "Campaing price is not equals");
			
			System.out.println(name1 + " <===> " + name2);
			System.out.println(regPrice1 + " <===> " + regPrice2);
			System.out.println(camPrice1 + " <===> " + camPrice2);
			
			driver.navigate().back();
		}
	}
}



































