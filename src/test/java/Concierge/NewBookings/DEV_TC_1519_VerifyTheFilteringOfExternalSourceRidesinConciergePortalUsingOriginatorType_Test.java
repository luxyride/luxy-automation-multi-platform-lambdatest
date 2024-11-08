package Concierge.NewBookings;

import java.util.Map;
import common.TestBase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Test
		extends TestBase {

	String currURL;
	String screenshotPath;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	Actions action;
	Boolean visibilityStatus;
	String exception = "";
	int vechilesCount = 0;
	String scenario;
	Boolean bookingStatus;
	JavascriptExecutor js;
	String tripID;

	DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Main objVerifyNewBookingConciergeMain;
	DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Test objVerifyNewBookingConciergeTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.NewBookings")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.NewBookings")
	public void verificationOfConciergeRidesUsingOriginatorDropDown() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyNewBookingConciergeMain = new DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Main(
					driver);
			objVerifyNewBookingConciergeTest = new DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyNewBookingConciergeTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyNewBookingConciergeTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Concierge Homepage Launch";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// ----------------------------------------------------------------------
			testStep = "Verify the entered Concierge User Logins";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingConciergeMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingConciergeMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingConciergeMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);
				testStep = "visibility of Sign In Button";
				visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyNewBookingConciergeMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				testStep = "visibility of logged in user";
				visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "visibility of logged in user";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			scenario = "Rides_All"; // Validations from Rides - All Page:
			validateOriginatorScenarios(scenario);
			scenario = "InProgress"; // Validations from In Progress Page:
			validateOriginatorScenarios(scenario);
			scenario = "Upcoming"; // Validations from Upcoming Page:
			validateOriginatorScenarios(scenario);
			scenario = "Available"; // Validations from Available Page:
			validateOriginatorScenarios(scenario);
			scenario = "Cancelled"; // Validations from Cancelled Page:
			validateOriginatorScenarios(scenario);
			scenario = "Completed"; // Validations from Completed Page:
			validateOriginatorScenarios(scenario);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
	}

	private void validateOriginatorScenarios(String scenario) throws Exception {
		try {
			objTestBase.defaultWaitTime(3000);
			objVerifyNewBookingConciergeMain.clickRidesSection();
			objTestBase.defaultWaitTime(3000);

			if (scenario.equalsIgnoreCase("Rides_All"))
				objVerifyNewBookingConciergeMain.clickonAllTab();
			else if (scenario.equalsIgnoreCase("InProgress"))
				objVerifyNewBookingConciergeMain.clickonInProgressTab();
			else if (scenario.equalsIgnoreCase("Upcoming"))
				objVerifyNewBookingConciergeMain.clickonUpcomingTab();
			else if (scenario.equalsIgnoreCase("Available"))
				objVerifyNewBookingConciergeMain.clickonAvailableTab();
			else if (scenario.equalsIgnoreCase("Cancelled"))
				objVerifyNewBookingConciergeMain.clickonCancelledTab();
			else if (scenario.equalsIgnoreCase("Completed"))
				objVerifyNewBookingConciergeMain.clickonCompletedTab();

			objTestBase.defaultWaitTime(3000);

			testStep = "Verify Originator drop down section from " + scenario + " Page";
			visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfOriginatorDropSection(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(2000);
			if (testStatus == "PASSED") {
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingConciergeMain.enterSearch();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verify Ground span ride details from " + scenario + " page.";
				visibilityStatus = objVerifyNewBookingConciergeMain.validateConciergerideDetails(visibilityStatus,
						scenario);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					testStep = testStep + " - There is no data to display.";
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "WARNING";
				}
			}

			objTestBase.defaultWaitTime(2000);
			if (testStatus == "PASSED") {
				testStep = "Verify Source System is displayed as per the Concierge site selected from Origintor dropdown from - "
						+ scenario + " page.";
				visibilityStatus = objVerifyNewBookingConciergeMain.verifySourceSystem(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}

	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();
		// Print the Captured the Ride Booking ids - captured
		// DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Test_Test:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : externalSourceTripIDsOriginator.entrySet()) {
			System.out.println(
					"Booking IDs  TC: DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Test = "
							+ "Total TripIDs = " + externalSourceTripIDsOriginator.size() + " - " + entry.getKey()
							+ " - " + entry.getValue());
			utillLogger.info(
					"Booking IDs  TC: DEV_TC_1519_VerifyTheFilteringOfExternalSourceRidesinConciergePortalUsingOriginatorType_Test = "
							+ "Total TripIDs = " + externalSourceTripIDsOriginator.size() + " - " + entry.getKey()
							+ " - " + entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyNewBookingConciergeTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}