package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	protected WebDriver driver;
	protected WebDriverWait wait;
	private final String osName = System.getProperty("os.name").toUpperCase();
	
	@Before
	public void onStart() {
		if (osName.contains("MAC")) {
			System.setProperty("webdriver.chrome.driver", 
					"drv/chrome/mac_64_chromedriver");
		} else if (osName.contains("WIN")) {
			System.setProperty("webdriver.chrome.driver", 
					"drv/chrome/win_32_chromedriver.exe");
		} else if (osName.contains("LINUX")) {
			System.setProperty("webdriver.chrome.driver", 
					"drv/chrome/linux_64_chromedriver");
		}
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	@After
	public void stop() {
		driver.quit();
		driver = null;
	}
}
