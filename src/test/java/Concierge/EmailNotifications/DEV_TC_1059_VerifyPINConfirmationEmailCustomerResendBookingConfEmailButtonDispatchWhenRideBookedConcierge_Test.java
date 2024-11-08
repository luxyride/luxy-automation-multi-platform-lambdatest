package Concierge.EmailNotifications;

import java.util.Map;
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

public class DEV_TC_1059_VerifyPINConfirmationEmailCustomerResendBookingConfEmailButtonDispatchWhenRideBookedConcierge_Test
		extends TestBase {
	int indexCount = 1;

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
	String scenario;
	String tripID;

	DEV_TC_1059_VerifyPINConfirmationEmailCustomerResendBookingConfEmailButtonDispatchWhenRideBookedConcierge_Main objVerifyResendEmailMain;
	DEV_TC_1059_VerifyPINConfirmationEmailCustomerResendBookingConfEmailButtonDispatchWhenRideBookedConcierge_Test objVerifyResendEmailTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.EmailNotifications")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.EmailNotifications")
	public void VerifyPINConfirmationEmailCustomerResendBookingConfEmailButtonDispatchWhenRideBookedConcierge()
			throws Exception {
		try {
			action = new Actions(driver);
			objVerifyResendEmailMain = new DEV_TC_1059_VerifyPINConfirmationEmailCustomerResendBookingConfEmailButtonDispatchWhenRideBookedConcierge_Main(
					driver);
			objVerifyResendEmailTest = new DEV_TC_1059_VerifyPINConfirmationEmailCustomerResendBookingConfEmailButtonDispatchWhenRideBookedConcierge_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyResendEmailTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyResendEmailTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Concierge Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyResendEmailMain.eMailInput();
				objVerifyResendEmailMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyResendEmailMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyResendEmailMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifyResendEmailMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of New Booking Page loaded.?";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfNewBookingPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			utillLogger.info(testStep + " - " + testStatus);
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}

		if (testStatus == "PASSED") {
			testStatus = " ";
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifyResendEmailMain.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				objVerifyResendEmailMain.clickNewBooking();
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifyResendEmailMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyResendEmailMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyResendEmailMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyResendEmailMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifyResendEmailMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyResendEmailMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			objVerifyResendEmailMain.clickOnSedan();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");

			objVerifyResendEmailMain.enterFirstName();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyResendEmailMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyResendEmailMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyResendEmailMain.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			clickOnCardOption();
			objTestBase.defaultWaitTime(2000);
			
			objVerifyResendEmailMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyResendEmailMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyResendEmailMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifyResendEmailMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyResendEmailMain.clickRidesSection();
				objTestBase.defaultWaitTime(1000);
				// Capture the Updated Ride Booking details based on IDs:
				tripID = objVerifyResendEmailMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
				testStep = "Verification of Capturing the Updated Ride ID for " + scenario + " - Trip ID = " + tripID;
				if (tripID != "")
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				// Click on RESEND for all booked Vehicles:
				if (!rideBookingIdsConcierge.isEmpty()) {
					for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
						System.out.println(entry.getKey() + " - " + entry.getValue());
						testStatus = loadDispatchSite(testStatus);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);
						tripID = entry.getValue();
						objVerifyResendEmailMain.clickOnRidesSection();
						objTestBase.defaultWaitTime(3000);
						objVerifyResendEmailMain.clickonAll();
						objTestBase.defaultWaitTime(3000);
						objVerifyResendEmailMain.searchRideId(tripID);
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Resend Ride Booking Email Confirmation for "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + entry.getValue();
						visibilityStatus = objVerifyResendEmailMain.verifyResendEmailConfirmationBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						// Verify Email Confirmation:
						testStatus = verifyEmailConfirmation(entry.getKey(), tripID);

						if (indexCount != rideBookingIdsConcierge.size()) {
							// Load Dispatch Site:
							testStatus = loadDispatchSite(testStatus);
						}
						indexCount++;
					}

					objTestBase.defaultWaitTime(2000);
					utillLogger.info(testStep + " - " + testStatus);
				} else {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					testStatus = "SKIPPED";

				}
				return;
			}
		}
	}

	private String loadDispatchSite(String testStatus) {
		try {
			driver.get(prop.getProperty("dispatchURL"));
			objTestBase.defaultWaitTime(3000);
			objVerifyResendEmailMain.dispatchEMailInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyResendEmailMain.dispatchPasswordInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyResendEmailMain.dispatchEyeIconClick();
			objTestBase.defaultWaitTime(1000);
			objVerifyResendEmailMain.clickDispatchSigninButton();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of New Booking Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfNewBookingPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyResendEmailMain.clickRidesSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	private String verifyEmailConfirmation(String vehicleType, String tripID) {
		try {
			if (testStatus == "PASSED") {
				for (int i = 0; i <= 1; i++) {
					if (i == 0)
						scenario = "Primary Email";
					else
						scenario = "Secondary Email";

					driver.get(prop.getProperty("yopmailURL"));
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Resend Ride Booking EMail Confirmation of Vehicle: " + vehicleType
							+ " - " + scenario + " with TripID = " + tripID;
					eMail = objVerifyResendEmailMain.emailIDSerach(scenario, eMail, tripID);
					objTestBase.defaultWaitTime(1000);

					System.out.println("DEV_TC_1059_Email = " + eMail);
					utillLogger.info(
							objVerifyResendEmailMain.getClass().getSimpleName() + " - DEV_TC_1059_Email = " + eMail);

					testStep = "Verification Resend Email Received with PIN Number for Vehicle: " + vehicleType + " - "
							+ scenario + " of TripID = " + tripID;
					visibilityStatus = objVerifyResendEmailMain.verificationOfPINConfirmationEmail(visibilityStatus,
							tripID);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "FAILED";
					}

					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,150)", "");
					objTestBase.defaultWaitTime(2000);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	@AfterClass(groups = "Concierge.EmailNotifications")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyResendEmailTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
