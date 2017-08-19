package ru.stqa.training.selenium;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import org.junit.Test;
import org.openqa.selenium.By;

public class LiteCartTest extends TestBase{
	
	@Test
	public void myFirstTest() {
		driver.get("http://my-mantis.esy.es/litecart/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.name("login")).click();
		wait.until(titleIs("My Store"));
	}
}
