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

public class DEV_TC_1649_VerifyTheFunctionalityOfHomeRequestNewQuoteCancelQuoteInEventAndSpecialServiceQuoteRequestPageInConciergePortal_Test
		extends TestBase {

	Actions action;
	String currURL;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	String exception = "";
	String screenshotPath;
	Boolean visibilityStatus;
	TestBase objTestBase;
	String quoteNumber;

	UpdateExtentReportResults objupdateResults;
	DEV_TC_1649_VerifyTheFunctionalityOfHomeRequestNewQuoteCancelQuoteInEventAndSpecialServiceQuoteRequestPageInConciergePortal_Main objVerifySplEventsMain;
	DEV_TC_1649_VerifyTheFunctionalityOfHomeRequestNewQuoteCancelQuoteInEventAndSpecialServiceQuoteRequestPageInConciergePortal_Test objVerifySplEventsTest;

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
			objVerifySplEventsMain = new DEV_TC_1649_VerifyTheFunctionalityOfHomeRequestNewQuoteCancelQuoteInEventAndSpecialServiceQuoteRequestPageInConciergePortal_Main(
					driver);
			objVerifySplEventsTest = new DEV_TC_1649_VerifyTheFunctionalityOfHomeRequestNewQuoteCancelQuoteInEventAndSpecialServiceQuoteRequestPageInConciergePortal_Test();
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
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					testStatus = "FAILED";
				}

				testStep = "Verification of Concierge Portal Login With Valid Credentials";
				visibilityStatus = objVerifySplEventsMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					testStatus = "PASSED";
				} else {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
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
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objVerifySplEventsMain.clickOnSpecialEvents();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify the availability of columns in MANAGE SPECIAL EVENT QUOTES page";
			visibilityStatus = objVerifySplEventsMain.visibilityOfColoumnsInManageEventsPage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objVerifySplEventsMain.clickOnCreateQouteBtn();
			objTestBase.defaultWaitTime(2000);

			testStep = "Enter all required information EVENT AND SPECIAL SERVICE QUOTE REQUEST";
			visibilityStatus = objVerifySplEventsMain.visibilityOfCreateQoutePage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterPickUpAddr();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterDropOffAddr();
			objTestBase.defaultWaitTime(2000);

			objVerifySplEventsMain.enterDate();
			objTestBase.defaultWaitTime(6000);
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

			testStep = "Visibility of Request Qoute Button";
			visibilityStatus = objVerifySplEventsMain.visibilityOfRequestBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objVerifySplEventsMain.clickOnRequestBtn();
			objTestBase.defaultWaitTime(3000);

			testStep = "Visibility of Success Message";
			visibilityStatus = objVerifySplEventsMain.visibilityOfAlertMessage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			quoteNumber = objVerifySplEventsMain.visibilityOfCreatedQuoteConfirmationMsg(quoteNumber);
			objTestBase.defaultWaitTime(2000);
			testStep = "Verification of created QUOTE and confirmation text displayed.? - Quote Number = "
					+ quoteNumber;
			if (quoteNumber != "")
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of Home Button ";
			visibilityStatus = objVerifySplEventsMain.visibilityOfHomeBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.clickOnHomeBtn();
			objTestBase.defaultWaitTime(2000);

			objVerifySplEventsMain.clickOnCreateQouteBtn();
			objTestBase.defaultWaitTime(2000);

			testStep = "Enter all required information EVENT AND SPECIAL SERVICE QUOTE REQUEST";
			visibilityStatus = objVerifySplEventsMain.visibilityOfCreateQoutePage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(1000);
			objVerifySplEventsMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.selectPassengers();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterPickUpAddr();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterDropOffAddr();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Event Type as Round Trip toggle, Hourly toggle options displayed from Quote Registration page request";
			visibilityStatus = objVerifySplEventsMain.verifyEventTypeHourlyOption(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of Request Qoute Button";
			visibilityStatus = objVerifySplEventsMain.visibilityOfRequestBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objVerifySplEventsMain.clickOnRequestBtn();
			objTestBase.defaultWaitTime(3000);

			testStep = "Visibility of Success Message";
			visibilityStatus = objVerifySplEventsMain.visibilityOfAlertMessage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			quoteNumber = objVerifySplEventsMain.visibilityOfCreatedQuoteConfirmationMsg(quoteNumber);
			objTestBase.defaultWaitTime(2000);
			testStep = "Verification of created QUOTE and confirmation text displayed.? - Quote Number = "
					+ quoteNumber;
			if (quoteNumber != "")
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of request new qoute Button ";
			visibilityStatus = objVerifySplEventsMain.visibilityOfRequestNewQouteBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.clickOnRequestNewQouteBtn();
			objTestBase.defaultWaitTime(2000);

			testStep = "Enter all required information EVENT AND SPECIAL SERVICE QUOTE REQUEST";
			visibilityStatus = objVerifySplEventsMain.visibilityOfCreateQoutePage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(1000);
			objVerifySplEventsMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.selectPassengers();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterPickUpAddr();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterDropOffAddr();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Event Type as Round Trip toggle, Hourly toggle options displayed from Quote Registration page request";
			visibilityStatus = objVerifySplEventsMain.verifyEventTypeHourlyOption(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of Request Qoute Button";
			visibilityStatus = objVerifySplEventsMain.visibilityOfRequestBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			objVerifySplEventsMain.clickOnRequestBtn();
			objTestBase.defaultWaitTime(3000);

			testStep = "Visibility of Success Message";
			visibilityStatus = objVerifySplEventsMain.visibilityOfAlertMessage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				testStatus = "PASSED";
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				testStatus = "FAILED";
			}

			quoteNumber = objVerifySplEventsMain.visibilityOfCreatedQuoteConfirmationMsg(quoteNumber);
			objTestBase.defaultWaitTime(2000);
			testStep = "Verification of created QUOTE and confirmation text displayed.? - Quote Number = "
					+ quoteNumber;
			if (quoteNumber != "")
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
			utillLogger.info(testStep + " - " + testStatus);
			objVerifySplEventsMain.clickOnCreateQouteBtn();
			objTestBase.defaultWaitTime(2000);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Enter all required information EVENT AND SPECIAL SERVICE QUOTE REQUEST";
			visibilityStatus = objVerifySplEventsMain.visibilityOfCreateQoutePage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			objTestBase.defaultWaitTime(1000);
			objVerifySplEventsMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.selectPassengers();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterPickUpAddr();
			objTestBase.defaultWaitTime(2000);
			objVerifySplEventsMain.enterDropOffAddr();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Event Type as Round Trip toggle, Hourly toggle options displayed from Quote Registration page request";
			visibilityStatus = objVerifySplEventsMain.verifyEventTypeHourlyOption(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of Request Qoute Button";
			visibilityStatus = objVerifySplEventsMain.visibilityOfRequestBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			objVerifySplEventsMain.clickOnRequestBtn();
			objTestBase.defaultWaitTime(3000);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of Success Message";
			visibilityStatus = objVerifySplEventsMain.visibilityOfAlertMessage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of Request Qoute Button";
			visibilityStatus = objVerifySplEventsMain.visibilityOfCancelBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			objVerifySplEventsMain.clickOnCancelBtn();
			objTestBase.defaultWaitTime(3000);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of pop up request to cancel qoute";
			visibilityStatus = objVerifySplEventsMain.visibilityOfpopup(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Visibility of Success Message";
			visibilityStatus = objVerifySplEventsMain.visibilityOfAlertMessage(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			else
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
