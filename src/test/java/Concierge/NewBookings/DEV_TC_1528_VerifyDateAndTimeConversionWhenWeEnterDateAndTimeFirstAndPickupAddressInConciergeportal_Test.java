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

public class DEV_TC_1528_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressInConciergeportal_Test
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
	String dateTime;

	DEV_TC_1528_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressInConciergeportal_Main objVerifyNewBookingConciergeMain;
	DEV_TC_1528_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressInConciergeportal_Test objVerifyNewBookingConciergeTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.NewBookings")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());

			// Clear the TripIDs which were booked from DEV_TC_1126:
			rideBookingIdsConcierge.clear();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.NewBookings")
	public void verificationOfNewBookingFromDispatchSite() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyNewBookingConciergeMain = new DEV_TC_1528_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressInConciergeportal_Main(
					driver);
			objVerifyNewBookingConciergeTest = new DEV_TC_1528_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressInConciergeportal_Test();
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
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
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
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingConciergeMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifyNewBookingConciergeMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of Dispatch Login";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
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
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
	}

	public String vechileBooking(String scenario, String testStatus) throws Exception {
		try {

			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifyNewBookingConciergeMain.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyNewBookingConciergeMain.clickNewBooking();
			objTestBase.defaultWaitTime(1000);

			testStep = "Visibility of New Booking Page loaded";
			visibilityStatus = objVerifyNewBookingConciergeMain.visibilitOfNewBookingPageLoaded(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifyNewBookingConciergeMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.enterTime();
			objTestBase.defaultWaitTime(2000);

			testStep = "verification of Selecting Date and time and then enter pickup and dropoff Addresses";
			dateTime = objVerifyNewBookingConciergeMain.captureDateAndTime(dateTime);
			if (dateTime != null) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				continueofBookingFlow(dateTime);
			} else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return testStatus;
	}

	private void continueofBookingFlow(String dateTime) {
		try {
			objVerifyNewBookingConciergeMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			objVerifyNewBookingConciergeMain.clickOnSedan();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingConciergeMain.enterFirstName();
			objTestBase.defaultWaitTime(1000);

			objVerifyNewBookingConciergeMain.clickOnAddSecondaryPassengerDetails();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingConciergeMain.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingConciergeMain.promoCodeEnable();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.enterPromocode(scenario);
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.clickonPromocodeApply();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			objTestBase.defaultWaitTime(2000);

			clickOnCardOption();
			objTestBase.defaultWaitTime(2000);
			
			objVerifyNewBookingConciergeMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyNewBookingConciergeMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingConciergeMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifyNewBookingConciergeMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				objVerifyNewBookingConciergeMain.clickRidesSection();
				objTestBase.defaultWaitTime(6000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifyNewBookingConciergeMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != "")
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				if (tripID != null) {
					testStep = "Verification of Date & Time Conversion after Ride Booking completed from Rides All Expanded View page";
					visibilityStatus = objVerifyNewBookingConciergeMain.verifyDateTimeCoversion(visibilityStatus,
							dateTime);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}
			}
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();

		// Removes the Duplicate Trip IDs from rideBookingIdsConcierge HashMap
		final Iterator<Entry<String, String>> iter = rideBookingIdsConcierge.entrySet().iterator();
		final HashSet<String> valueSet = new HashSet<String>();
		while (iter.hasNext()) {
			final Entry<String, String> next = iter.next();
			if (!valueSet.add(next.getValue())) {
				iter.remove();
			}
		}

		// Print the Captured the Ride Booking ids - captured from
		// DEV_TC_1528_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressInConciergeportal_Test:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
			System.out
					.println("Booking IDs from TC: DEV_TC_1248_VerifyNewRideBookingFunctionalityFromConciergePortal = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
			utillLogger.info("Booking IDs from TC: DEV_TC_1248_VerifyNewRideBookingFunctionalityFromConciergePortal = "
					+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
					+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyNewBookingConciergeTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}