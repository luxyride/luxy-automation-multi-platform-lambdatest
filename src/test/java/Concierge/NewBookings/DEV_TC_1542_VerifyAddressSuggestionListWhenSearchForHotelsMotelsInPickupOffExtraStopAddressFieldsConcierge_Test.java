package Concierge.NewBookings;

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

public class DEV_TC_1542_VerifyAddressSuggestionListWhenSearchForHotelsMotelsInPickupOffExtraStopAddressFieldsConcierge_Test
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

	DEV_TC_1542_VerifyAddressSuggestionListWhenSearchForHotelsMotelsInPickupOffExtraStopAddressFieldsConcierge_Main objVerifyNewBookingConciergeMain;
	DEV_TC_1542_VerifyAddressSuggestionListWhenSearchForHotelsMotelsInPickupOffExtraStopAddressFieldsConcierge_Test objVerifyNewBookingConciergeTest;
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
			objVerifyNewBookingConciergeMain = new DEV_TC_1542_VerifyAddressSuggestionListWhenSearchForHotelsMotelsInPickupOffExtraStopAddressFieldsConcierge_Main(
					driver);
			objVerifyNewBookingConciergeTest = new DEV_TC_1542_VerifyAddressSuggestionListWhenSearchForHotelsMotelsInPickupOffExtraStopAddressFieldsConcierge_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyNewBookingConciergeTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyNewBookingConciergeTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Homepage Launch";

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
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingConciergeMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingConciergeMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

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

				visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of Dispatch Login";
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

			scenario = "Book Sedan";
			testStatus = vechileBooking(scenario, testStatus);

			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
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
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingConciergeMain.clickNewBooking();
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			testStep = "Verification of Hotel/Motel Address details for From Address";
			visibilityStatus = objVerifyNewBookingConciergeMain.addFromAddress(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Hotel/Motel Address details for To Address";
			visibilityStatus = objVerifyNewBookingConciergeMain.addToAddress(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			objTestBase.defaultWaitTime(1000);

			objVerifyNewBookingConciergeMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Hotel/Motel Address details for Extra Stop Address";
			visibilityStatus = objVerifyNewBookingConciergeMain.addExtraStop(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			objTestBase.defaultWaitTime(1000);

			objVerifyNewBookingConciergeMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyNewBookingConciergeMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			if (scenario == "Book Sedan") {
				objVerifyNewBookingConciergeMain.clickOnSedan();
			} else if (scenario == "Book SUV") {
				objVerifyNewBookingConciergeMain.clickOnSUV();
			} else if (scenario == "Book SUVXL") {
				objVerifyNewBookingConciergeMain.clickOnSUVXL();
			} else if (scenario == "Book VAN") {
				objVerifyNewBookingConciergeMain.clickOnVAN();
			} else if (scenario == "Book VANXL") {
				objVerifyNewBookingConciergeMain.clickOnVANXL();
			}
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			

			objVerifyNewBookingConciergeMain.enterFirstName();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingConciergeMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingConciergeMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyNewBookingConciergeMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingConciergeMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifyNewBookingConciergeMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyNewBookingConciergeMain.clickRidesSection();
				objTestBase.defaultWaitTime(2000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifyNewBookingConciergeMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					System.out.println("Trip ID = " + tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != null)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return testStatus;
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
		utillLogger.info("## " + objVerifyNewBookingConciergeTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}