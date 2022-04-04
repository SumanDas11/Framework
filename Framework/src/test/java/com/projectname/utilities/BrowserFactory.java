package com.projectname.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.out.println("Yet to configure IE browser");
		} else {
			System.out.println("Browser is not supported for the test.");
		}

		driver.manage().window().maximize();
		//checking Git operations with author sumandas.aec@gmail.com
		
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Could not wait for 5 sec" + e.getMessage());
		}
		
		driver.quit();
	}
}
