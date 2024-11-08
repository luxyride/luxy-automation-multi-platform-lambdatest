package Concierge.NewBookings;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1530_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressLaterEDITRideInConciergeportal_Test
		extends TestBase {
	String tripID;
	String currURL;
	String screenshotPath;
	Actions action;
	String testStep;
	String testStatus;
	String scenario;
	WebElement element;
	Boolean visibilityStatus;
	String exception = "";
	JavascriptExecutor js;
	String dateTime;

	DEV_TC_1530_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressLaterEDITRideInConciergeportal_Main objVerifyEditDetails_Main;
	DEV_TC_1530_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressLaterEDITRideInConciergeportal_Test objVerifyEditDetails_Test;
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
	public void verificationOfRideEditDetailsFromDispatchSite() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyEditDetails_Main = new DEV_TC_1530_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressLaterEDITRideInConciergeportal_Main(
					driver);
			objVerifyEditDetails_Test = new DEV_TC_1530_VerifyDateAndTimeConversionWhenWeEnterDateAndTimeFirstAndPickupAddressLaterEDITRideInConciergeportal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyEditDetails_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify Dispatch Portal Launch Homepage";
			currURL = driver.getCurrentUrl();
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED" && tripID != null) {
				testStatus = " ";
				objVerifyEditDetails_Main.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyEditDetails_Main.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyEditDetails_Main.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyEditDetails_Main.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifyEditDetails_Main.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyEditDetails_Main.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				utillLogger.info(testStep + " - " + testStatus);

				objVerifyEditDetails_Main.clickRidesSection();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Rides All Page loaded.?";
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				objVerifyEditDetails_Main.searchRideId(tripID);
				objTestBase.defaultWaitTime(5000);

				// Validate the TripID Details:
				testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for Vehicle Trip ID: " + tripID
						+ " - Before Update";
				visibilityStatus = objVerifyEditDetails_Main.validateTripIDDetails(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				}

				testStep = "Validate EDIT Ride for Vehicle - Trip ID: " + tripID;
				if (visibilityStatus.booleanValue() == true) {
					objVerifyEditDetails_Main.editRideDetails();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Edit Ride Booking for Vehicle - Trip ID: " + tripID
							+ " - Before Update";
					visibilityStatus = objVerifyEditDetails_Main.verifyEDITRideDetailsPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					objTestBase.defaultWaitTime(2000);

					testStep = "Verification of Edit Ride Booking Page for Vehicle - Trip ID: " + tripID
							+ " - Before Update";
					if (testStatus == "PASSED") {
						objVerifyEditDetails_Main.removePickupAddress();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.enterDate();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.enterTime();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.addFromAddress();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.clickOnSedan();
						objTestBase.defaultWaitTime(2000);

						testStep = "verification of Selecting Date and time and then enter pickup and dropoff Addresses";
						dateTime = objVerifyEditDetails_Main.captureDateAndTime(dateTime);
						if (dateTime != null) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							continueofBookingFlow(dateTime);
						} else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}
				objTestBase.defaultWaitTime(1000);
				utillLogger.info(testStep + " - " + testStatus);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	private void continueofBookingFlow(String dateTime) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1800)", "");
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyEditDetails_Main.visibilityOfUpdateRideBtn(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				testStep = "Verify visibility of Update Ride Button";
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				// Prod Restriction:
				if (!environmentCode.equalsIgnoreCase("prod")) {
					objTestBase.defaultWaitTime(1000);
					objVerifyEditDetails_Main.clickonUpdateRideBtn();
					testStep = "Verification of SEDAN Vehicle Ride Update Booking Confirmation Message";
					visibilityStatus = objVerifyEditDetails_Main.verifyRideBookingConfirmation(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)", "");
				objTestBase.defaultWaitTime(2000);
				
				clickOnCardOption();
				objTestBase.defaultWaitTime(2000);

				objVerifyEditDetails_Main.enterPaymentInformation();
				objTestBase.defaultWaitTime(2000);

				utillLogger.info(testStep + " - " + testStatus);
				testStep = "Verification of SEDAN Vehicle Ride Booking Payment Update";
				visibilityStatus = objVerifyEditDetails_Main.visibilitofUpdatePaymentBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				}

				// Prod Restriction:
				if (!environmentCode.equalsIgnoreCase("prod")) {
					objTestBase.defaultWaitTime(1000);
					objVerifyEditDetails_Main.clickonPaynowBtn();
					testStep = "Verification of SEDAN Vehicle Ride Update Booking Confirmation Message";
					visibilityStatus = objVerifyEditDetails_Main.verifyRideBookingConfirmation(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}
			}

			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			objVerifyEditDetails_Main.clickRidesSection();
			objTestBase.defaultWaitTime(6000);

			if (testStatus == "PASSED") {
				// Capture the Ride Booking IDs:
				tripID = objVerifyEditDetails_Main.captureRideBookingIDs(visibilityStatus, scenario, tripID);
				testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
				if (tripID != "")
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			} else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

			if (tripID != null) {
				testStep = "Verification of Date & Time Conversion after Ride Booking completed from Rides All Expanded View page";
				visibilityStatus = objVerifyEditDetails_Main.verifyDateTimeCoversion(visibilityStatus, dateTime);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
