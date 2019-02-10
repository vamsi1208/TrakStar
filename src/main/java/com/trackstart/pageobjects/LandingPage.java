package com.trackstart.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.trackstart.utilityclasses.Excel_Reader;

import junit.framework.Assert;

public class LandingPage {

	WebDriver driver;
	By noOfEmployees = By.id("num_employees_input");
	By performanceManagementChkBox = By.xpath("//*[text()='Performance Management']");
	By employeeEngagementChkBox = By.xpath("//*[text()='Employee Engagement Surveys']");
	By applicationTrackingChkBox = By.xpath("//h3[text()='Applicant Tracking']");
	By contactUs = By.xpath("//*[@id='contact-us-quote']");

	By performanceManagementQuote = By
			.xpath("//*[text()='Your Custom Quote']//..//*[text()='Performance Management']//../div[1]");
	By successionPlanningQuote = By
			.xpath("//*[text()='Your Custom Quote']//..//*[text()='Succession Planning']//../div[1]");
	By employeeEngagement = By.xpath("//*[text()='Your Custom Quote']//..//*[text()='Employee Engagement']//../div[1]");
	By applicantTracking = By.xpath("//*[text()='Your Custom Quote']//..//*[text()='Applicant Tracking']//../div[1]");
	By annualSubscription = By
			.xpath("//*[text()='Your Custom Quote']//..//*[text()='Annual Subscription']//..//..//div[1]/span[1]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyDifferentPricesAndFeatures() {
		// String noofEmp,String perfManagementFeature,String
		// empEngagementFeature,String appliTrackingFeature

		for (int i = 1; i <= 4; i++) {
			driver.get("https://www.trakstar.com/pricing/");

			try {
				String noOfEmployeesValue = Excel_Reader.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx",
						"PricesAndFeatures", i, 0);
				String performanceManagementFeature = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 1);
				String successionPlanningFeature = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 2);
				String employeeEngagementFeature = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 3);
				String applicantTrackingFeature = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 4);
				String performanceManagementExpectedValue = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 5);
				String successionPlanningExpectedValue = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 6);
				String employeeEngagementExpectedValue = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 7);
				String applicantTrackingExpectedValue = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 8);
				String annualSubscriptionExpectedValue = Excel_Reader
						.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx", "PricesAndFeatures", i, 9);

				// String annualSubscriptionValue =
				// Excel_Reader.getCellData(".\\src\\test\\resources\\TestData\\Prices.xlsx",
				// "PricesAndFeatures", i, 4);
/*
				System.out.println("The Value is " + noOfEmployeesValue + " " + performanceManagementFeature + "   "
						+ successionPlanningFeature + "   " + employeeEngagementFeature + "  "
						+ applicantTrackingFeature);
				System.out.println("The Value is " + " " + performanceManagementExpectedValue + "   "
						+ successionPlanningExpectedValue + "   " + employeeEngagementExpectedValue + "  "
						+ applicantTrackingExpectedValue + "  " + annualSubscriptionExpectedValue);*/

				driver.findElement(noOfEmployees).sendKeys(noOfEmployeesValue);
			  driver.findElement(employeeEngagementChkBox).click();
			driver.findElement(applicationTrackingChkBox).click();
				/*System.out.println(driver.findElement(performanceManagementQuote).getText());
				System.out.println(driver.findElement(successionPlanningQuote).getText());
				System.out.println(driver.findElement(employeeEngagement).getText());
				System.out.println(driver.findElement(applicantTracking).getText());
				System.out.println(driver.findElement(annualSubscription).getText());

				System.out.println(driver.findElement(performanceManagementQuote).getText()
						.equalsIgnoreCase("$" + performanceManagementExpectedValue));
				System.out.println(driver.findElement(successionPlanningQuote).getText()
						.equalsIgnoreCase("$" + successionPlanningExpectedValue));
				System.out.println(driver.findElement(employeeEngagement).getText()
						.equalsIgnoreCase("$" + employeeEngagementExpectedValue));

				System.out.println(driver.findElement(applicantTracking).getText()
						.equalsIgnoreCase("$" + applicantTrackingExpectedValue));
				System.out.println(driver.findElement(annualSubscription).getText()
						.equalsIgnoreCase("$" + annualSubscriptionExpectedValue));
*/				if (noOfEmployeesValue.equalsIgnoreCase("25")) {
					if (performanceManagementFeature.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(performanceManagementQuote).getText()
								.equalsIgnoreCase("$" + performanceManagementExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + performanceManagementExpectedValue
								+ " but actual is " + driver.findElement(performanceManagementQuote).getText(), result);
					}
					if (successionPlanningFeature.equalsIgnoreCase("yes")) {
						
						boolean result = driver.findElement(successionPlanningQuote).getText()
								.equalsIgnoreCase("$" + successionPlanningExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + successionPlanningExpectedValue
								+ " but actual is " + driver.findElement(successionPlanningQuote).getText(), result);
					}
					if (employeeEngagementExpectedValue.equalsIgnoreCase("yes")) {
						//Thread.sleep(5000);
						//driver.findElement(employeeEngagementChkBox).click();
						
						boolean result = driver.findElement(employeeEngagement).getText()
								.equalsIgnoreCase("$" + employeeEngagementExpectedValue);

						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + employeeEngagementExpectedValue
								+ " but actual is " + driver.findElement(employeeEngagement).getText(), result);
					}
					if (applicantTrackingExpectedValue.equalsIgnoreCase("yes")) {
						//driver.findElement(applicationTrackingChkBox).click();
						boolean result = driver.findElement(applicantTracking).getText()
								.equalsIgnoreCase("$" + applicantTrackingExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + applicantTrackingExpectedValue
								+ " but actual is " + driver.findElement(applicantTracking).getText()
										.equalsIgnoreCase("$" + applicantTrackingExpectedValue),
								result);
					}
					if (annualSubscriptionExpectedValue.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(annualSubscription).getText()
								.equalsIgnoreCase("$" + annualSubscriptionExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + annualSubscriptionExpectedValue
								+ " but actual is " + driver.findElement(annualSubscription).getText()
										.equalsIgnoreCase("$" + annualSubscriptionExpectedValue),
								result);
					}
				} else if (noOfEmployeesValue.equalsIgnoreCase("100")) {
					if (performanceManagementFeature.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(performanceManagementQuote).getText()
								.equalsIgnoreCase("$" + performanceManagementExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + performanceManagementExpectedValue
								+ " but actual is " + driver.findElement(performanceManagementQuote).getText(), result);
					}
					if (successionPlanningFeature.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(successionPlanningQuote).getText()
								.equalsIgnoreCase("$" + successionPlanningExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + successionPlanningExpectedValue
								+ " but actual is " + driver.findElement(successionPlanningQuote).getText(), result);
					}
					if (employeeEngagementExpectedValue.equalsIgnoreCase("yes")) {
						driver.findElement(employeeEngagementChkBox).click();
						boolean result = driver.findElement(employeeEngagement).getText()
								.equalsIgnoreCase("$" + employeeEngagementExpectedValue);

						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + employeeEngagementExpectedValue
								+ " but actual is " + driver.findElement(employeeEngagement).getText(), result);
					}
					if (applicantTrackingExpectedValue.equalsIgnoreCase("yes")) {
						driver.findElement(applicationTrackingChkBox).click();
						boolean result = driver.findElement(applicantTracking).getText()
								.equalsIgnoreCase("$" + applicantTrackingExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + applicantTrackingExpectedValue
								+ " but actual is " + driver.findElement(applicantTracking).getText()
										.equalsIgnoreCase("$" + applicantTrackingExpectedValue),
								result);
					}
					if (annualSubscriptionExpectedValue.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(annualSubscription).getText()
								.equalsIgnoreCase("$" + annualSubscriptionExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + annualSubscriptionExpectedValue
								+ " but actual is " + driver.findElement(annualSubscription).getText()
										.equalsIgnoreCase("$" + annualSubscriptionExpectedValue),
								result);
					}
				} else if (noOfEmployeesValue.equalsIgnoreCase("500")) {
					if (performanceManagementFeature.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(performanceManagementQuote).getText()
								.equalsIgnoreCase("$" + performanceManagementExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + performanceManagementExpectedValue
								+ " but actual is " + driver.findElement(performanceManagementQuote).getText(), result);
					}
					if (successionPlanningFeature.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(successionPlanningQuote).getText()
								.equalsIgnoreCase("$" + successionPlanningExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + successionPlanningExpectedValue
								+ " but actual is " + driver.findElement(successionPlanningQuote).getText(), result);
					}
					if (employeeEngagementExpectedValue.equalsIgnoreCase("yes")) {
						driver.findElement(employeeEngagementChkBox).click();
						boolean result = driver.findElement(employeeEngagement).getText()
								.equalsIgnoreCase("$" + employeeEngagementExpectedValue);

						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + employeeEngagementExpectedValue
								+ " but actual is " + driver.findElement(employeeEngagement).getText(), result);
					}
					if (applicantTrackingExpectedValue.equalsIgnoreCase("yes")) {
						driver.findElement(applicationTrackingChkBox).click();
						boolean result = driver.findElement(applicantTracking).getText()
								.equalsIgnoreCase("$" + applicantTrackingExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + applicantTrackingExpectedValue
								+ " but actual is " + driver.findElement(applicantTracking).getText()
										.equalsIgnoreCase("$" + applicantTrackingExpectedValue),
								result);
					}
					if (annualSubscriptionExpectedValue.equalsIgnoreCase("yes")) {
						boolean result = driver.findElement(annualSubscription).getText()
								.equalsIgnoreCase("$" + annualSubscriptionExpectedValue);
						Assert.assertTrue("For employee count " + noOfEmployeesValue
								+ " ,PerformanceQuote expected is  " + annualSubscriptionExpectedValue
								+ " but actual is " + driver.findElement(annualSubscription).getText()
										.equalsIgnoreCase("$" + annualSubscriptionExpectedValue),
								result);
					}
				} else if (noOfEmployeesValue.equalsIgnoreCase("5000")) {

					Assert.assertTrue("The Contact Us is not displayed", driver.findElement(contactUs).isDisplayed());
				}

System.out.println(driver.findElement(performanceManagementQuote).getText());
System.out.println(driver.findElement(successionPlanningQuote).getText());
System.out.println(driver.findElement(employeeEngagement).getText());
System.out.println(driver.findElement(applicantTracking).getText());
System.out.println(driver.findElement(annualSubscription).getText());

System.out.println(driver.findElement(performanceManagementQuote).getText()
		.equalsIgnoreCase("$" + performanceManagementExpectedValue));
System.out.println(driver.findElement(successionPlanningQuote).getText()
		.equalsIgnoreCase("$" + successionPlanningExpectedValue));
System.out.println(driver.findElement(employeeEngagement).getText()
		.equalsIgnoreCase("$" + employeeEngagementExpectedValue));

System.out.println(driver.findElement(applicantTracking).getText()
		.equalsIgnoreCase("$" + applicantTrackingExpectedValue));
System.out.println(driver.findElement(annualSubscription).getText()
		.equalsIgnoreCase("$" + annualSubscriptionExpectedValue));

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
