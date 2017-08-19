package ru.stqa.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import ru.stqa.training.exception.NotSupportedBrowserException;
import ru.stqa.training.exception.NotSupportedOSException;

public class TestBase {
	protected WebDriver driver = null;
	protected WebDriverWait wait;
	private final String osName = System.getProperty("os.name").toUpperCase();
	protected String browser = "chrome";
	
	private final String baseUrl = "http://my-mantis.esy.es/litecart/en/";
	
	@BeforeClass
	public void onStart() throws NotSupportedOSException, NotSupportedBrowserException {
		if("firefox".equals(browser)) {
			if (osName.contains("MAC")) {
				System.setProperty("webdriver.gecko.driver",
		                "drv/firefox/mac_geckodriver");
			} else if (osName.contains("WIN")) {
				System.setProperty("webdriver.gecko.driver",
		                "drv/firefox/win_64_geckodriver.exe");
			} else if (osName.contains("LINUX")) {
				System.setProperty("webdriver.gecko.driver",
		                "drv/firefox/linux_64_geckodriver");
			}
			
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)) {
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
		} else if ("ie".equals(browser)) {
				if (osName.contains("WIN")) {
					System.setProperty("webdriver.ie.driver", 
							"drv/ie/win_32_IEDriverServer.exe");
				} else {
					throw new NotSupportedOSException("OS: " + osName + " not supported IE browser");
				}
				
				driver = new InternetExplorerDriver();
		} else if ("safari".equals(browser)) {
				if (osName.contains("MAC")) {
					// System.setProperty("webdriver.chrome.driver", 
					// 		"drv/chrome/linux_64_chromedriver");
				} else {
					throw new NotSupportedOSException("OS: " + osName + " not supported Safari browser");
				}
				
				driver = new SafariDriver();
		} else {
			throw new NotSupportedBrowserException("Browser: " + browser + " not supported");
		}
		
		wait = new WebDriverWait(driver, 15);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}		
	}
}
