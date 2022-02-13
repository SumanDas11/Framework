package com.projectname.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.projectname.utilities.BrowserFactory;
import com.projectname.utilities.ConfigDataProvider;
import com.projectname.utilities.ExcelDataProvider;
import com.projectname.utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		
		Reporter.log("Setting up the environment.", true); //logs only for internal use
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider(); // constructor in the class will be invoked

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/AppReport_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setupApp() {
		driver = BrowserFactory.startApplication(driver, config.getDataFromConfig("browser"),
				config.getDataFromConfig("testUrl"));
		System.out.println("Page title is: " + driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		BrowserFactory.quitBrowser(driver);

	}

	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build()); //capture screenshot and attach to report(attach to report is not working)
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush(); // keeps on adding the test to a single report
		
		Reporter.log("Test completed", true); //logs only for internal use
	}
}
