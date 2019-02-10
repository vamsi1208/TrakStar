package com.trackstar.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.trackstart.pageobjects.LandingPage;
import com.trackstart.utilityclasses.DriverClass;

public class TestClass {
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		driver = DriverClass.getDriver("chrome");
	}

	@Test
	public void test() {
		driver = DriverClass.getDriver("chrome");
		LandingPage lp = new LandingPage(driver);
		lp.verifyDifferentPricesAndFeatures();

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
