package Concierge.NewBookings;

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

public class DEV_TC_306_VerifyTheRideBookingFunctionalityForLessThan12hrsDuration_Test extends TestBase {

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
	Boolean todaysFlag;
	JavascriptExecutor js;
	Boolean bookingStatus;
	String tripID;

	DEV_TC_306_VerifyTheRideBookingFunctionalityForLessThan12hrsDuration_Main objVerifyLessThan12hrsMain;
	DEV_TC_306_VerifyTheRideBookingFunctionalityForLessThan12hrsDuration_Test objVerifyLessThan12hrsTest;
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
	public void verifyRideBookingFunctionalityLessthan12hrsDuration() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyLessThan12hrsMain = new DEV_TC_306_VerifyTheRideBookingFunctionalityForLessThan12hrsDuration_Main(
					driver);
			objVerifyLessThan12hrsTest = new DEV_TC_306_VerifyTheRideBookingFunctionalityForLessThan12hrsDuration_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyLessThan12hrsTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyLessThan12hrsTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);
			currURL = driver.getCurrentUrl();
			testStep = "Verify Concierge Portal Launch";
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyLessThan12hrsMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyLessThan12hrsMain.passwordInput();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verify Concierge Portal with entered SignIn details";
				visibilityStatus = objVerifyLessThan12hrsMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifyLessThan12hrsMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Concierge Portal LoggedIn with valid Credentials";
				visibilityStatus = objVerifyLessThan12hrsMain.visibilityOfLoggedinUser(visibilityStatus);
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
			tripID = vechileBooking(scenario, testStatus, tripID);

			// # EDIT Ride Functionality
			// ------------------------------------------------------------
			testStep = "Verification of EDIT the created ride into below 12 hrs";
			if (tripID != null) {
				objTestBase.defaultWaitTime(3000);
				objVerifyLessThan12hrsMain.clickOnAll();
				objTestBase.defaultWaitTime(2000);
				objVerifyLessThan12hrsMain.searchTripID(tripID);
				objTestBase.defaultWaitTime(2000);
				objVerifyLessThan12hrsMain.clickOnEditRide();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = objVerifyLessThan12hrsMain.verifyVisibilityOfEditRidePage(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					todaysFlag = true;
					objVerifyLessThan12hrsMain.enterDate(todaysFlag);
					objTestBase.defaultWaitTime(2000);
					visibilityStatus = objVerifyLessThan12hrsMain.enterTime(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
				}

				objVerifyLessThan12hrsMain.clickOngetQuote();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verify Warning message displayed for below 12hrs";
				visibilityStatus = objVerifyLessThan12hrsMain.verifyVisibilityOfWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					visibilityStatus = true;
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	public String vechileBooking(String scenario, String testStatus, String tripID) throws Exception {
		try {
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifyLessThan12hrsMain.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				objVerifyLessThan12hrsMain.clickNewBooking();
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifyLessThan12hrsMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyLessThan12hrsMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyLessThan12hrsMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyLessThan12hrsMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			todaysFlag = false;
			objVerifyLessThan12hrsMain.enterDate(todaysFlag);
			objTestBase.defaultWaitTime(2000);
			objVerifyLessThan12hrsMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyLessThan12hrsMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)", "");
			objVerifyLessThan12hrsMain.clickOnSedan();
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");

			objVerifyLessThan12hrsMain.enterFirstName();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyLessThan12hrsMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyLessThan12hrsMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyLessThan12hrsMain.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);
			
			clickOnCardOption();
			objTestBase.defaultWaitTime(2000);

			objVerifyLessThan12hrsMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyLessThan12hrsMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyLessThan12hrsMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifyLessThan12hrsMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyLessThan12hrsMain.clickRidesSection();
				objTestBase.defaultWaitTime(2000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifyLessThan12hrsMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					System.out.println("Trip ID = " + tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != null)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			}
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return tripID;
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyLessThan12hrsTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
