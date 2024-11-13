package Dispatch.EmailNotifications;

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

public class DEV_TC_1048_VerifyPINConfirmationEmailToUsingResendBookingConfirmationEmail_Test extends TestBase {

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

	DEV_TC_1048_VerifyPINConfirmationEmailToUsingResendBookingConfirmationEmail_Main objVerifyResendEmailMain;
	DEV_TC_1048_VerifyPINConfirmationEmailToUsingResendBookingConfirmationEmail_Test objVerifyResendEmailTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.EmailNotifications")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.EmailNotifications")
	public void VerifySignInWithValidCredentials_Test() throws Exception {
		try {
			int indexCount = 1;

			action = new Actions(driver);
			objVerifyResendEmailMain = new DEV_TC_1048_VerifyPINConfirmationEmailToUsingResendBookingConfirmationEmail_Main(
					driver);
			objVerifyResendEmailTest = new DEV_TC_1048_VerifyPINConfirmationEmailToUsingResendBookingConfirmationEmail_Test();
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

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyResendEmailMain.eMailInput();
				objVerifyResendEmailMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyResendEmailMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyResendEmailMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyResendEmailMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfLoggedinUser(visibilityStatus);
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
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verification of New Booking Page loaded.?";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfNewBookingPage(visibilityStatus);
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

				objVerifyResendEmailMain.clickRidesSection();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verification of Rides All Page loaded.?";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
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

				// Click on RESEND for all booked Vehicles:
				if (!rideBookingDispatchIds.isEmpty()) {
					for (Map.Entry<String, String> entry : rideBookingDispatchIds.entrySet()) {
						System.out.println(entry.getKey() + " - " + entry.getValue());
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);
						tripID = entry.getValue();
						objVerifyResendEmailMain.searchRideId(tripID);
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Resend Ride Booking Email Confirmation for "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + entry.getValue();
						visibilityStatus = objVerifyResendEmailMain.verifyResendEmailConfirmationBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						// Verify Email Confirmation:
						testStatus = verifyEmailConfirmation(entry.getKey(), tripID);

						if (indexCount != rideBookingDispatchIds.size()) {
							// Load Dispatch Site:
							testStatus = loadDispatchSite(testStatus);
						}

						if (testStatus == "FAILED")
							break;

						indexCount++;
					}
				}
				objTestBase.defaultWaitTime(2000);
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
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

			objVerifyResendEmailMain.clickRidesSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
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

		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	private String verifyEmailConfirmation(String vehicleType, String tripID) {
		try {
			for (int i = 0; i <= 1; i++) {
				if (i == 0)
					scenario = "Primary Email";
				else
					scenario = "Secondary Email";

				driver.get(prop.getProperty("yopmailURL"));
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Resend Ride Booking EMail Confirmation of Vehicle: " + vehicleType + " - "
						+ scenario + " with TripID = " + tripID;
				eMail = objVerifyResendEmailMain.emailIDSerach(scenario, eMail, tripID);
				objTestBase.defaultWaitTime(1000);

				System.out.println("DEV_TC_1048_Email = " + eMail);
				utillLogger
						.info(objVerifyResendEmailMain.getClass().getSimpleName() + " - DEV_TC_1048_Email = " + eMail);

				testStep = "Verification Resend Email Received with PIN Number for Vehicle: " + vehicleType + " - "
						+ scenario + " of TripID = " + tripID;
				visibilityStatus = objVerifyResendEmailMain.verificationOfPINConfirmationEmail(visibilityStatus,
						tripID);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "FAILED";
				}

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
				objTestBase.defaultWaitTime(2000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	@AfterClass(groups = "Dispatch.EmailNotifications")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyResendEmailTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
