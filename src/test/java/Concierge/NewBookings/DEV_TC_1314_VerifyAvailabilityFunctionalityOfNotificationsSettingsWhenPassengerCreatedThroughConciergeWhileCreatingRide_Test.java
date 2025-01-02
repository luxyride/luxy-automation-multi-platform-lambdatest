package Concierge.NewBookings;

import java.util.Map;
import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Test
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
	String newEMail;

	DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Main objVerifyNewBookingConciergeMain;
	DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Test objVerifyNewBookingConciergeTest;
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
	public void verificationOfNewBookingFromConciergeSite() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyNewBookingConciergeMain = new DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Main(
					driver);
			objVerifyNewBookingConciergeTest = new DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Test();
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
				testStep = "Verification of Concierge Login";
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
			objVerifyNewBookingConciergeMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingConciergeMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
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

			objVerifyNewBookingConciergeMain.clickOnSedan();
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");

			objVerifyNewBookingConciergeMain.enterPassengerDetails();
			objTestBase.defaultWaitTime(2000);

			newEMail = objVerifyNewBookingConciergeMain.enterNewEmailID(newEMail);
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingConciergeMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingConciergeMain.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);
			
			clickOnCardOption();
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
					tripID = objVerifyNewBookingConciergeMain.captureRideBookingIDs(visibilityStatus, scenario, tripID,
							newEMail);
					System.out.println("Trip ID = " + tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != null)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

				
				objTestBase.defaultWaitTime(20000);	//Increased wait time get email received:
				if (!tripID.isEmpty() || !tripID.isEmpty()) {
					driver.get(prop.getProperty("yopmailURL"));
					driver.manage().window().maximize();
					objTestBase.defaultWaitTime(3000);

					objVerifyNewBookingConciergeMain.clearButton();
					objTestBase.defaultWaitTime(1000);

					newEMail = objVerifyNewBookingConciergeMain.emailIDSerach(newEMail);
					objTestBase.defaultWaitTime(1000);

					System.out.println("Regression Email = " + newEMail);
					utillLogger.info(objVerifyNewBookingConciergeTest.getClass().getSimpleName()
							+ " - Regression Email = " + newEMail);

					testStep = "Verify New User Luxy Account - New EMail Confirmation";
					visibilityStatus = objVerifyNewBookingConciergeMain.verifyyopeMail(visibilityStatus);
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

					objVerifyNewBookingConciergeMain.confirmEmailAccount();
					objTestBase.defaultWaitTime(3000);
					testStep = "Confirm New User Luxy Account Signup";
					visibilityStatus = objVerifyNewBookingConciergeMain.verifyConfirmAccountPassword(visibilityStatus);
					objTestBase.defaultWaitTime(1000);

					if (visibilityStatus.booleanValue() == true) {
						currURL = driver.getCurrentUrl();
						if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
							objTestBase.defaultWaitTime(1000);
							objVerifyNewBookingConciergeMain.passwordInputUserPortal();
							objTestBase.defaultWaitTime(3000);
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";

						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
					}

					objVerifyNewBookingConciergeMain.confirmAccount();
					objTestBase.defaultWaitTime(3000);
					objTestBase.closePopupWindow();
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Re-login with the registered Email account";
					if (testStatus == "PASSED") {
						objTestBase.defaultWaitTime(1000);
						objVerifyNewBookingConciergeMain.login();
						objTestBase.defaultWaitTime(1000);

						newEMail = objVerifyNewBookingConciergeMain.enterEmail(newEMail);
						objTestBase.defaultWaitTime(1000);

						objVerifyNewBookingConciergeMain.passwordRelogin();
						objTestBase.defaultWaitTime(6000);

						visibilityStatus = objVerifyNewBookingConciergeMain.loggedInDrpdwn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						// Validate Notification Preferences:
						if (!newEMail.isEmpty()) {
							// Validate Notification Preferences:
							objVerifyNewBookingConciergeMain.clickLogginUserDrpdown();
							objTestBase.defaultWaitTime(500);

							testStep = "Verification of Notification Preference visibility from dropdown - " + scenario;
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							objVerifyNewBookingConciergeMain.clickonNotificationDrpdwn();
							objTestBase.defaultWaitTime(500);

							testStep = "Verification Notification Preference Allow All - " + scenario;
							visibilityStatus = objVerifyNewBookingConciergeMain.clickonallowAll(visibilityStatus);
							objTestBase.defaultWaitTime(8000);
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);

							objVerifyNewBookingConciergeMain.closeWindow();
							utillLogger.info(testStep + " - " + testStatus);

							driver.navigate().refresh();
							objTestBase.defaultWaitTime(5000);

							// SMS Notifications:
							objVerifyNewBookingConciergeMain.clickLogginUserDrpdown();
							objTestBase.defaultWaitTime(500);
							objVerifyNewBookingConciergeMain.clickonNotificationDrpdwn();
							objTestBase.defaultWaitTime(500);
							visibilityStatus = objVerifyNewBookingConciergeMain.clickonallowAll(visibilityStatus);
							objTestBase.defaultWaitTime(1000);
							testStep = "Verification Notification Preference SMS Checkboxes checked.?";
							visibilityStatus = objVerifyNewBookingConciergeMain.clickOnSMSCheckboxes(visibilityStatus);
							objTestBase.defaultWaitTime(3000);
							if (visibilityStatus == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							objTestBase.defaultWaitTime(500);
						}

						utillLogger.info(testStep + " - " + testStatus);
					} else {
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
						testStatus = "SKIPPED";
					}
					utillLogger.info(testStep + " - " + testStatus);
				}
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
		// Print the Captured the Ride Booking ids - captured from
		// DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Test:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
			System.out.println(
					"Booking IDs from TC: DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
			utillLogger.info(
					"Booking IDs from TC: DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyNewBookingConciergeTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
