package Concierge.NewBookings;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_2068_VerifyTheFunctionalityOfAddAnotherTripButtonInEventAndSpecialServiceQuoteRequestPage_Test
		extends TestBase {

	Actions action;
	String currURL;
	String expected;
	String quoteNumber;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	String exception = "";
	String screenshotPath;
	Boolean visibilityStatus;
	TestBase objTestBase;
	UpdateExtentReportResults objupdateResults;
	DEV_TC_2068_VerifyTheFunctionalityOfAddAnotherTripButtonInEventAndSpecialServiceQuoteRequestPage_Main objVerifySplEventsMain;
	DEV_TC_2068_VerifyTheFunctionalityOfAddAnotherTripButtonInEventAndSpecialServiceQuoteRequestPage_Test objVerifySplEventsTest;

	@BeforeClass(groups = "Concierge.NewBookings")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.NewBookings")
	public void VerifySignInWithValidCredentials_Test() throws Exception {
		try {
			action = new Actions(driver);
			objVerifySplEventsMain = new DEV_TC_2068_VerifyTheFunctionalityOfAddAnotherTripButtonInEventAndSpecialServiceQuoteRequestPage_Main(
					driver);
			objVerifySplEventsTest = new DEV_TC_2068_VerifyTheFunctionalityOfAddAnotherTripButtonInEventAndSpecialServiceQuoteRequestPage_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySplEventsMain.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySplEventsMain.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
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
				objVerifySplEventsMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySplEventsMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySplEventsMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySplEventsMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifySplEventsMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifySplEventsMain.visibilityOfLoggedinUser(visibilityStatus);
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
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verification of availability of special events Tab";
			visibilityStatus = objVerifySplEventsMain.visibilityOfSpecialEvents(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
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

			objVerifySplEventsMain.clickOnSpecialEvents();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of special events tab ";
			visibilityStatus = objVerifySplEventsMain.visibilityOfSpecialEventsPage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
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

			objTestBase.defaultWaitTime(1000);
			objVerifySplEventsMain.clickOnNewQoute();
			objTestBase.defaultWaitTime(3000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of special events tab ";
			visibilityStatus = objVerifySplEventsMain.visibilityOfAddAnotherTrip(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
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

			objTestBase.defaultWaitTime(1000);
			objVerifySplEventsMain.clickOnAddAnotherTrip();
			objTestBase.defaultWaitTime(3000);

			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterPickUpAddr();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterDropOffAddr();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Date Selection from Quote Registration page request";
			visibilityStatus = objVerifySplEventsMain.enterDate(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			objVerifySplEventsMain.selectPassengers();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.selectLuggage();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Event Type as Round Trip toggle, Hourly toggle options displayed from Quote Registration page request";
			visibilityStatus = objVerifySplEventsMain.verifyEventTypeHourlyOption(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)", "");
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Remove trip button";
			visibilityStatus = objVerifySplEventsMain.visibilityOfRemoveTrip(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			utillLogger.info(testStep + " - " + testStatus);

			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.clickOnRemoveTrip();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Request Quote and Cancel options displayed from Quote Registration page";
			visibilityStatus = objVerifySplEventsMain.visibilityOfRequestBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);

				testStep = "Verification of Success Message Confirmation displayed.?";
				visibilityStatus = objVerifySplEventsMain.visibilityOfAlertMessage(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Visibility of Home Button ";
				visibilityStatus = objVerifySplEventsMain.visibilityOfHomeBtn(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

				utillLogger.info(testStep + " - " + testStatus);
				objTestBase.defaultWaitTime(2000);
				objVerifySplEventsMain.clickOnHomeBtn();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of created Quote is displaying from Manage Special Event Quotes page.? - Quote Number = "
						+ quoteNumber;
				visibilityStatus = objVerifySplEventsMain
						.visibilityOfCreatedQuoteFromManageSpecialEventsPage(visibilityStatus, quoteNumber);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			utillLogger.info(testStep + " - " + testStatus);

			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifySplEventsMain.visibilityOfcancelQuoteConfirmationMsg(visibilityStatus);
			testStep = "Verify Cancellation of created Quote confirmation message.? - Quote Number = " + quoteNumber;
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySplEventsTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
