package Concierge.NewBookings;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1645_VerifyFunctionalityOfCreatingQuoteInSpecialEventsInConciergePortal_Test extends TestBase {

	Actions action;
	String currURL;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	String quoteNumber;
	String exception = "";
	String screenshotPath;
	Boolean visibilityStatus;
	TestBase objTestBase;
	UpdateExtentReportResults objupdateResults;
	DEV_TC_1645_VerifyFunctionalityOfCreatingQuoteInSpecialEventsInConciergePortal_Main objVerifySplEventsMain;
	DEV_TC_1645_VerifyFunctionalityOfCreatingQuoteInSpecialEventsInConciergePortal_Test objVerifySplEventsTest;

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
	public void VerifySignInWithValidCredentials_Test() throws Exception {
		try {
			action = new Actions(driver);
			objVerifySplEventsMain = new DEV_TC_1645_VerifyFunctionalityOfCreatingQuoteInSpecialEventsInConciergePortal_Main(
					driver);
			objVerifySplEventsTest = new DEV_TC_1645_VerifyFunctionalityOfCreatingQuoteInSpecialEventsInConciergePortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySplEventsTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySplEventsTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Concierge Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
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
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					objVerifySplEventsMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

				testStep = "Verification of Concierge Portal Login With Valid Credentials";
				visibilityStatus = objVerifySplEventsMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

				utillLogger.info(testStep + " - " + testStatus);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

			testStep = "Verification of availability of special events Tab";
			visibilityStatus = objVerifySplEventsMain.visibilityOfSpecialEvents(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			objVerifySplEventsMain.clickOnSpecialEvents();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify manage special events page and create button at top right corner";
			visibilityStatus = objVerifySplEventsMain.visibilityOfManageSpecialEventsPageAndCreateBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Verification of Quote Registration page request";
			visibilityStatus = objVerifySplEventsMain.verifyQuoteRegistrationPage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

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
				quoteNumber = objVerifySplEventsMain.visibilityOfCreatedQuoteConfirmationMsg(quoteNumber);
				objTestBase.defaultWaitTime(2000);
				testStep = "Verification of created QUOTE and confirmation text displayed.? - Quote Number = "
						+ quoteNumber;
				if (quoteNumber != "")
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

				utillLogger.info(testStep + " - " + testStatus);
				testStep = "Verification of visibility of Home Button from Created Quote Confirmation Page";
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
		} catch (Exception ex) {
			ex.printStackTrace();
			objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		try {
			utillLogger.info("## " + objVerifySplEventsTest.getClass().getSimpleName() + " Created Quote Number = "
					+ quoteNumber);
			// Cancel the created quote:
			if (quoteNumber != null) {
				objTestBase.defaultWaitTime(1000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = objVerifySplEventsMain.visibilityOfcancelQuoteConfirmationMsg(visibilityStatus);
				testStep = "Verify Cancellation of created Quote confirmation message.? - Quote Number = "
						+ quoteNumber;
				if (visibilityStatus.booleanValue() == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			}
			driver.quit();
			utillLogger.info("## " + objVerifySplEventsTest.getClass().getSimpleName()
					+ " - END --------------------------------------------------------------##");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
