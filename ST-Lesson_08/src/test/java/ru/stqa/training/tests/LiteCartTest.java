package ru.stqa.training.tests;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static ru.stqa.training.selenium.SharedMethods.getText;
import static ru.stqa.training.selenium.SharedMethods.getElements;
import static ru.stqa.training.selenium.SharedMethods.getCountElements;
import static ru.stqa.training.selenium.SharedMethods.isElementsPresent;
import static ru.stqa.training.selenium.maps.HomePageMap.IMAGE_WRAPPER;
import static ru.stqa.training.selenium.maps.HomePageMap.STICKER;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ru.stqa.training.selenium.TestBase;

public class LiteCartTest extends TestBase{
	
	@Test(priority = 0)
	public void checkSticker() {
		assertTrue(isElementsPresent(driver, IMAGE_WRAPPER.by()));
		
		List<WebElement> list = getElements(driver, IMAGE_WRAPPER.by());
		int countStickers = 0;
		for (WebElement element : list) {
			assertTrue(isElementsPresent(element, STICKER.by()));
			countStickers = getCountElements(element, STICKER.by());
			assertEquals(countStickers, 1, "Number of stickers not equals 1");
			System.out.println(getText(element, STICKER.by()));
		}
	}
}
