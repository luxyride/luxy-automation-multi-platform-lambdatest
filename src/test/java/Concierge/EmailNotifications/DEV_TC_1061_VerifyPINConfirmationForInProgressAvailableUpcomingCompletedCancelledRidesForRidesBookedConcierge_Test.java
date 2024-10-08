package Concierge.EmailNotifications;

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

public class DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Test
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
	String scenario;
	String tripID;

	DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Main objVerifyResendEmailMain;
	DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Test objVerifyResendEmailTest;
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
	public void VerifySignInWithValidCredentials_Test() throws Exception {
		try {
			int indexCount = 1;

			action = new Actions(driver);
			objVerifyResendEmailMain = new DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Main(
					driver);
			objVerifyResendEmailTest = new DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyResendEmailTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyResendEmailTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Dispatch Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyResendEmailMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyResendEmailMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyResendEmailMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyResendEmailMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyResendEmailMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				utillLogger.info(testStep + " - " + testStatus);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verification of New Booking Page loaded.?";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfNewBookingPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyResendEmailMain.clickRidesSection();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verification of Rides All Page loaded.?";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of EMAIL PIN Confirmation Email";
				if (!rideBookingIdsConcierge.isEmpty()) {
					// Click on RESEND for all booked Vehicles:
					for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
						System.out.println(entry.getKey() + " - " + entry.getValue());
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);
						tripID = entry.getValue();
						objVerifyResendEmailMain.searchRideId(tripID);
						objTestBase.defaultWaitTime(2000);

						objVerifyResendEmailMain.expandRideDetails();
						objTestBase.defaultWaitTime(3000);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,600)", "");

						testStep = "Verification of Update Ride Status - " + entry.getKey().toUpperCase()
								+ " - Trip ID: " + tripID;
						// Set Status as AVAILABLE if Vehicle is SEDAN:
						if (entry.getKey() == "sedan") {
							scenario = "Available";
							visibilityStatus = objVerifyResendEmailMain.updateRideStatus(scenario, visibilityStatus);
						}
						// Set Status as UPCOMING if Vehicle is SUV:
						else if (entry.getKey() == "suv") {
							scenario = "Upcoming";
							visibilityStatus = objVerifyResendEmailMain.updateRideStatus(scenario, visibilityStatus);
						}
						// Set Status as InProgress if Vehicle is SUVXL:
						else if (entry.getKey() == "suv-xl") {
							scenario = "InProgress";
							visibilityStatus = objVerifyResendEmailMain.updateRideStatus(scenario, visibilityStatus);
						}
						// Set Status as COMPLETED if Vehicle is VAN:
						else if (entry.getKey() == "van") {
							scenario = "Completed";
							visibilityStatus = objVerifyResendEmailMain.updateRideStatus(scenario, visibilityStatus);
						}
						// Set Status as CANCELLED if Vehicle is VANXL
						else if (entry.getKey() == "van-xl") {
							scenario = "Cancelled";
							visibilityStatus = objVerifyResendEmailMain.updateRideStatus(scenario, visibilityStatus);
						}

						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						objVerifyResendEmailMain.clickRidesSection();
						objTestBase.defaultWaitTime(1000);

						testStep = "Verification of Navigating to the respective Ride Status Page for the Scenario - "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + tripID;
						visibilityStatus = objVerifyResendEmailMain.verifyRideStatusPageNavigation(scenario,
								visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						objVerifyResendEmailMain.searchRideId(tripID);
						objTestBase.defaultWaitTime(1000);

						testStep = "Verification of Resend Ride Booking Email Confirmation for "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + tripID;
						visibilityStatus = objVerifyResendEmailMain.verifyResendEmailConfirmationBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						// Verify Email Confirmation:
						testStatus = verifyEmailConfirmation(entry.getKey(), tripID);
						scenario = ""; // reset back to blank:
						if (indexCount != rideBookingIdsConcierge.size()) {
							// Load Dispatch Site:
							testStatus = loadDispatchSite(testStatus);
						}

						// Create new Ride for Cancelled Vehicle Type to validate TC:
						// DEV_TC_304_VerifyCancelRideByDispatch_Test and update new Trip ID in
						// rideBookingIdsConcierge
						if (entry.getKey() == "van-xl") {
							visibilityStatus = objVerifyResendEmailMain.CreateNewRideVANXL(scenario, testStatus,
									visibilityStatus);
						}
					}
				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

				objTestBase.defaultWaitTime(2000);
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	private String loadDispatchSite(String testStatus) {
		try {
			driver.get(prop.getProperty("dispatchURL"));
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of New Booking Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfNewBookingPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyResendEmailMain.clickRidesSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
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

					utillLogger.info(
							objVerifyResendEmailMain.getClass().getSimpleName() + " - DEV_TC_1061_EMail = " + eMail);

					testStep = "Verification Resend Email Received with PIN Number for Vehicle: " + vehicleType + " - "
							+ scenario + " of TripID = " + tripID;
					visibilityStatus = objVerifyResendEmailMain.verificationOfPINConfirmationEmail(visibilityStatus,
							tripID);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "FAILED";
					}

					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,150)", "");
					objTestBase.defaultWaitTime(2000);
				}
				scenario = "";
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
		// Removes the Duplicate Trip IDs from rideBookingIdsConcierge HashMap
		final Iterator<Entry<String, String>> iter = rideBookingIdsConcierge.entrySet().iterator();
		final HashSet<String> valueSet = new HashSet<String>();
		while (iter.hasNext()) {
			final Entry<String, String> next = iter.next();
			if (!valueSet.add(next.getValue())) {
				iter.remove();
			}
		}
		// DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Test:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
			System.out.println(
					"Booking IDs from TC: DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
			utillLogger.info(
					"Booking IDs from TC: DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyResendEmailTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}