package Dispatch.NewBooking;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_2043_VerifyRideReassignmentToDifferentCorporateAccountWhenARideIsBookedThroughDispatchPortal_Test
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

	DEV_TC_2043_VerifyRideReassignmentToDifferentCorporateAccountWhenARideIsBookedThroughDispatchPortal_Main objVerifyNewBookingDispatchMain;
	DEV_TC_2043_VerifyRideReassignmentToDifferentCorporateAccountWhenARideIsBookedThroughDispatchPortal_Test objVerifyNewBookingDispatchTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.NewBooking")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.NewBooking")
	public void verificationOfNewBookingFromDispatchSite() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyNewBookingDispatchMain = new DEV_TC_2043_VerifyRideReassignmentToDifferentCorporateAccountWhenARideIsBookedThroughDispatchPortal_Main(
					driver);
			objVerifyNewBookingDispatchTest = new DEV_TC_2043_VerifyRideReassignmentToDifferentCorporateAccountWhenARideIsBookedThroughDispatchPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyNewBookingDispatchTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyNewBookingDispatchTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Homepage Launch";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// ----------------------------------------------------------------------
			testStep = "Verify the entered Dispatch User Logins";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingDispatchMain.eMailInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingDispatchMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingDispatchMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyNewBookingDispatchMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyNewBookingDispatchMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyNewBookingDispatchMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of Dispatch Login";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			scenario = "Book Sedan";
			testStatus = vechileBooking(scenario, testStatus);

			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
	}

	public String vechileBooking(String scenario, String testStatus) throws Exception {
		try {
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifyNewBookingDispatchMain.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifyNewBookingDispatchMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingDispatchMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingDispatchMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingDispatchMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingDispatchMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingDispatchMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyNewBookingDispatchMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			if (scenario == "Book Sedan") {
				objVerifyNewBookingDispatchMain.clickOnSedan();
			}

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingDispatchMain.searchBookingUserName();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingDispatchMain.clickcheckbox();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingDispatchMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingDispatchMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingDispatchMain.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)", "");
			objTestBase.defaultWaitTime(3000);


			objVerifyNewBookingDispatchMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyNewBookingDispatchMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingDispatchMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifyNewBookingDispatchMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyNewBookingDispatchMain.clickRidesSection();
				objTestBase.defaultWaitTime(6000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifyNewBookingDispatchMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != "")
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							lambdaTestStatusUpdate("passed", testStep);
					else if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				} else if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
			}

			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingDispatchMain.clickOnMoveToCorporate();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingDispatchMain.enterCorporateName();
			objTestBase.defaultWaitTime(3000);
			objVerifyNewBookingDispatchMain.clickOnMoveBtn();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of successful message after Ride Moving to corporate Account";
			visibilityStatus = objVerifyNewBookingDispatchMain
					.verifyConfirmationMsgafterRideMovingToCorporate(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify concierge Homepage Launch";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// ----------------------------------------------------------------------
			testStep = "Verify the entered Concierge User Logins";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingDispatchMain.ConciergeEmailInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingDispatchMain.ConciergepasswordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingDispatchMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyNewBookingDispatchMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyNewBookingDispatchMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyNewBookingDispatchMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of Dispatch Login";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifyNewBookingDispatchMain.ConciergeClickRidesSection();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingDispatchMain.searchInput(tripID);
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyNewBookingDispatchMain.visibilityOfSearchedRide(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return testStatus;
	}

	@AfterClass(groups = "Dispatch.NewBooking")
	public void afterClass() {
		driver.quit();

		// Removes the Duplicate Trip IDs from rideBookingDispatchIds HashMap
		final Iterator<Entry<String, String>> iter = rideBookingDispatchIds.entrySet().iterator();
		final HashSet<String> valueSet = new HashSet<String>();
		while (iter.hasNext()) {
			final Entry<String, String> next = iter.next();
			if (!valueSet.add(next.getValue())) {
				iter.remove();
			}
		}

		// Print the Captured the Ride Booking ids - captured from
		// DEV_TC_1020_VerificationOfNewBookingFromDispatchSite Test Case:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingDispatchIds.entrySet()) {
			System.out.println(
					"Booking IDs from TC: DEV_TC_1020_VerificationOfNewBookingFromDispatchSite = " + "Total TripIDs = "
							+ rideBookingDispatchIds.size() + " - " + entry.getKey() + " - " + entry.getValue());
			utillLogger.info(
					"Booking IDs from TC: DEV_TC_1020_VerificationOfNewBookingFromDispatchSite = " + "Total TripIDs = "
							+ rideBookingDispatchIds.size() + " - " + entry.getKey() + " - " + entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyNewBookingDispatchTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}