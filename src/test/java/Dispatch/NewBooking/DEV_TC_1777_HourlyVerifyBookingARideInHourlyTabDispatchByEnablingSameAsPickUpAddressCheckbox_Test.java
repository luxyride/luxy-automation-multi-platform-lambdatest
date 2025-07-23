package Dispatch.NewBooking;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1777_HourlyVerifyBookingARideInHourlyTabDispatchByEnablingSameAsPickUpAddressCheckbox_Test extends TestBase {

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


	DEV_TC_1777_HourlyVerifyBookingARideInHourlyTabDispatchByEnablingSameAsPickUpAddressCheckbox_Main objVerifySighninMain;
	DEV_TC_1777_HourlyVerifyBookingARideInHourlyTabDispatchByEnablingSameAsPickUpAddressCheckbox_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.NewBooking")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.NewBooking")
	public void VerifySignInWithValidCredentials_Test() throws Exception {
		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1777_HourlyVerifyBookingARideInHourlyTabDispatchByEnablingSameAsPickUpAddressCheckbox_Main(driver);
			objVerifySighninTest = new DEV_TC_1777_HourlyVerifyBookingARideInHourlyTabDispatchByEnablingSameAsPickUpAddressCheckbox_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
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

			testStep = "Verification of Dispatch Portal Loginpage ";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				
				testStep = "Visibility of point to point and hourly Tab should be displayed";
				visibilityStatus = objVerifySighninMain.visibilityOfHourlyAndPointToPointTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				
				scenario = "Book Sedan";
				testStatus = vechileBooking(scenario, testStatus);
				
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
			visibilityStatus = objVerifySighninMain.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickOnHourlyTab();
				objTestBase.defaultWaitTime(2000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifySighninMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.selectTime();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifySighninMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			if (scenario == "Book Sedan") {
				objVerifySighninMain.clickOnSedan();
			}

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.searchBookingUserName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.clickcheckbox();
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.clickOnAddSecondaryPassengerDetails();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.enterPassengerNotes();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)", "");
			objTestBase.defaultWaitTime(2000);
			
			objVerifySighninMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifySighninMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Hourly Ride Booking Confirmation Message";
				visibilityStatus = objVerifySighninMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickRidesSection();
				objTestBase.defaultWaitTime(6000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifySighninMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != "")
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}
			driver.navigate().refresh();
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

	@AfterClass(groups = "Dispatch.NewBooking")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
