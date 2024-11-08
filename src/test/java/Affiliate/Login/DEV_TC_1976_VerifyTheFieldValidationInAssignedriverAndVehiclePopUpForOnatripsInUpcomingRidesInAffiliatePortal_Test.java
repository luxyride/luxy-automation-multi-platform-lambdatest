package Affiliate.Login;

import common.TestBase;
import org.testng.annotations.Test;

import java.util.Map;

import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1976_VerifyTheFieldValidationInAssignedriverAndVehiclePopUpForOnatripsInUpcomingRidesInAffiliatePortal_Test
		extends TestBase {

	String currURL;
	String screenshotPath;
	String expected;
	String userName;
	String testStep;
	String scenario;
	String testStatus;
	WebElement element;
	Actions action;
	Boolean visibilityStatus;
	String exception = "";

	DEV_TC_1976_VerifyTheFieldValidationInAssignedriverAndVehiclePopUpForOnatripsInUpcomingRidesInAffiliatePortal_Main objVerifySighninMain;
	DEV_TC_1976_VerifyTheFieldValidationInAssignedriverAndVehiclePopUpForOnatripsInUpcomingRidesInAffiliatePortal_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Affiliate.Login")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Affiliate.Login")
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1976_VerifyTheFieldValidationInAssignedriverAndVehiclePopUpForOnatripsInUpcomingRidesInAffiliatePortal_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1976_VerifyTheFieldValidationInAssignedriverAndVehiclePopUpForOnatripsInUpcomingRidesInAffiliatePortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("affiliateURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of affiliate Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				objVerifySighninMain.clickOnRides();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickOnAllTab();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of affiliate Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				utillLogger.info(testStep + " - " + testStatus);

				if (!rideBookingIdsTravelAgent.isEmpty()) {
					for (Map.Entry<String, String> entry : rideBookingIdsTravelAgent.entrySet()) {
						if (!entry.getKey().toLowerCase().contains("temp")) {
							objVerifySighninMain.clickOnRides();
							objTestBase.defaultWaitTime(2000);
							objVerifySighninMain.clickOnAllTab();
							objTestBase.defaultWaitTime(3000);

							driver.navigate().refresh();
							objTestBase.defaultWaitTime(3000);
							tripID = entry.getValue();
							scenario = entry.getKey();
							objVerifySighninMain.searchTripID(tripID);
							objTestBase.defaultWaitTime(5000);
							objVerifySighninMain.clickBookingTripId();
							objTestBase.defaultWaitTime(2000);
							
							testStep = "visibility Of Assign Driver And Vehicle";
							visibilityStatus = objVerifySighninMain.visibilityOfAssignDriverAndVehicle(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
								testStatus = "PASSED";
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
								testStatus = "FAILED";

							}


							objTestBase.defaultWaitTime(2000);
							objVerifySighninMain.clickOnAssignDriverToggle();
							objTestBase.defaultWaitTime(2000);

							testStep = "visibility of driver details Form";
							visibilityStatus = objVerifySighninMain.visibilityOfDriverDetailsFormPage(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
								testStatus = "PASSED";
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
								testStatus = "FAILED";

							}
							
							objTestBase.defaultWaitTime(2000);
							objVerifySighninMain.clickOnConfirm();
							objTestBase.defaultWaitTime(2000);
							
							testStep = "visibility of Error Message Under Text Fields";
							visibilityStatus = objVerifySighninMain.visibilityOfErrorMessagedUnderTextFields(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
								testStatus = "PASSED";
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
								testStatus = "FAILED";

							}
							
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Affiliate.Login")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
