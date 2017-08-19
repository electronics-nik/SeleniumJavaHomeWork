package ru.stqa.training.selenium;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import org.junit.Test;
import org.openqa.selenium.By;

public class MyFirstTest extends TestBase{
	
	@Test
	public void myFirstTest() {
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("webdriver");
		driver.findElement(By.name("btnG")).click();
		wait.until(titleIs("webdriver - Поиск в Google"));
	}
}
