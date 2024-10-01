package Concierge.EmailNotifications;

import common.TestBase;
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

public class DEV_TC_1058_VerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConcierge_Test
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

	DEV_TC_1058_VerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConcierge_Main objVerifySendingPINDispatchMain;
	DEV_TC_1058_VerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConcierge_Test objVerifySendingPINDispatchTest;
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
	public void verificationOfNewBVerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConciergeookingFromDispatchSite()
			throws Exception {

		try {
			action = new Actions(driver);
			objVerifySendingPINDispatchMain = new DEV_TC_1058_VerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConcierge_Main(
					driver);
			objVerifySendingPINDispatchTest = new DEV_TC_1058_VerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConcierge_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySendingPINDispatchTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySendingPINDispatchTest.getClass().getSimpleName()
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
				objVerifySendingPINDispatchMain.eMailInput();
				objVerifySendingPINDispatchMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifySendingPINDispatchMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySendingPINDispatchMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifySendingPINDispatchMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifySendingPINDispatchMain.visibilityOfLoggedinUser(visibilityStatus);
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

			for (int i = 5; i <= 5; i++) {
				if (i == 1) {
					scenario = "Book Sedan";
					testStatus = vechileBooking(scenario, testStatus);
				} else if (i == 2) {
					scenario = "Book SUV";
					testStatus = vechileBooking(scenario, testStatus);
				} else if (i == 3) {
					scenario = "Book SUVXL";
					testStatus = vechileBooking(scenario, testStatus);
				}
				// Prod Restriction:
				else if (!environmentCode.equalsIgnoreCase("prod") && i == 4) {
					scenario = "Book VAN";
					testStatus = vechileBooking(scenario, testStatus);
				}
				// Prod Restriction:
				else if (!environmentCode.equalsIgnoreCase("prod") && i == 5) {
					scenario = "Book VANXL";
					testStatus = vechileBooking(scenario, testStatus);
				}
			}
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
			visibilityStatus = objVerifySendingPINDispatchMain.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				objVerifySendingPINDispatchMain.clickNewBooking();
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifySendingPINDispatchMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifySendingPINDispatchMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifySendingPINDispatchMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifySendingPINDispatchMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifySendingPINDispatchMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifySendingPINDispatchMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifySendingPINDispatchMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			if (scenario == "Book Sedan") {
				objVerifySendingPINDispatchMain.clickOnSedan();
			} else if (scenario == "Book SUV") {
				objVerifySendingPINDispatchMain.clickOnSUV();
			} else if (scenario == "Book SUVXL") {
				objVerifySendingPINDispatchMain.clickOnSUVXL();
			} else if (scenario == "Book VAN") {
				objVerifySendingPINDispatchMain.clickOnVAN();
			} else if (scenario == "Book VANXL") {
				objVerifySendingPINDispatchMain.clickOnVANXL();
			}
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");

			objVerifySendingPINDispatchMain.enterFirstName();
			objTestBase.defaultWaitTime(1000);

			objVerifySendingPINDispatchMain.clickAddSecondary();
			objTestBase.defaultWaitTime(1000);

			objVerifySendingPINDispatchMain.enterSecondname();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySendingPINDispatchMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifySendingPINDispatchMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifySendingPINDispatchMain.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);
			
			clickOnCardOption();
			objTestBase.defaultWaitTime(2000);

			objVerifySendingPINDispatchMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifySendingPINDispatchMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifySendingPINDispatchMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifySendingPINDispatchMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifySendingPINDispatchMain.clickRidesSection();
				objTestBase.defaultWaitTime(2000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifySendingPINDispatchMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					System.out.println("Trip ID = " + tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != null)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}
			VerifyingSendinPinConfirmationForEmails();
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

	public void VerifyingSendinPinConfirmationForEmails() throws Exception {
		try {
			action = new Actions(driver);
			objVerifySendingPINDispatchMain = new DEV_TC_1058_VerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConcierge_Main(
					driver);
			objVerifySendingPINDispatchTest = new DEV_TC_1058_VerifySendingPINConfirmationForPrimaryAndSecondaryPassengerInBookingConfirmationEmailConcierge_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySendingPINDispatchTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySendingPINDispatchTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("yopmailURL"));
			objTestBase.defaultWaitTime(3000);
			driver.manage().window().maximize();
			testStep = "Verify lanching the Yopmail";
			currURL = driver.getCurrentUrl();
			if (currURL.toLowerCase().contains("yopmail")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verifying the Email Notification with PIN validations";
			if (testStatus == "PASSED" && !rideBookingIdsConcierge.isEmpty()) {
				for (Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
					System.out.println(entry.getKey() + " - " + entry.getValue());
					visibilityStatus = objVerifySendingPINDispatchMain.verifyEmailConfirmation(visibilityStatus,
							entry.getKey(), entry.getValue());
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
	}

	@AfterClass(groups = "Concierge.EmailNotifications")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySendingPINDispatchTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}