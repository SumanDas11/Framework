package com.projectname.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import com.projectname.pages.BaseClass;
import com.projectname.pages.LoginPage;

public class AppLoginTests extends BaseClass {

	@Test
	public void loginApp() {
		Reporter.log("Test case started.", true); //logs only for internal use
		
		logger = report.createTest("Login to App."); //part of extent report
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting application");
		
		loginPage.loginToApp(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		
		logger.pass("Login success");
		//Helper.captureScreenshot(driver);
	}
}
