package com.projectname.testcases;

import java.time.Duration;

import org.openqa.selenium.By;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseWithoutFramework 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Page title is: "+driver.getTitle());
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("username");
		driver.quit();

	}
}
