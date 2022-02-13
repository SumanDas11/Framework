package com.projectname.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "email")
	WebElement uname;
	@FindBy(id = "pass")
	WebElement pword;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	public void loginToApp(String username, String password)
	{
		uname.sendKeys(username);
		pword.sendKeys(password);
		loginButton.click();
	}
}
