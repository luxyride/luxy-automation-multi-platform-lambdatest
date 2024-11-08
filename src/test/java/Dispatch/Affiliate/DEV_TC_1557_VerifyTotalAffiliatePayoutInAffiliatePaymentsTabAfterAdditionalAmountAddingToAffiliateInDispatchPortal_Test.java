package Dispatch.Affiliate;

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

public class DEV_TC_1557_VerifyTotalAffiliatePayoutInAffiliatePaymentsTabAfterAdditionalAmountAddingToAffiliateInDispatchPortal_Test
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
	String scenarioPage;

	DEV_TC_1557_VerifyTotalAffiliatePayoutInAffiliatePaymentsTabAfterAdditionalAmountAddingToAffiliateInDispatchPortal_Main objVerifySighninMain;
	DEV_TC_1557_VerifyTotalAffiliatePayoutInAffiliatePaymentsTabAfterAdditionalAmountAddingToAffiliateInDispatchPortal_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.Affiliate")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.Affiliate")
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1557_VerifyTotalAffiliatePayoutInAffiliatePaymentsTabAfterAdditionalAmountAddingToAffiliateInDispatchPortal_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1557_VerifyTotalAffiliatePayoutInAffiliatePaymentsTabAfterAdditionalAmountAddingToAffiliateInDispatchPortal_Test();
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
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
				objTestBase.defaultWaitTime(1000);

				// Verify Affiliate is in Active state/not, if not activate the Affiliate before
				// proceeding for further validations:
				testStep = "Verify Activation of Affiliate from Affiliate Page:";
				visibilityStatus = verifyAffiliateActiveStatus(visibilityStatus);
				if (visibilityStatus == true) {
					testStep = "Verification of Affiliates Payments Page Navigation";
					visibilityStatus = objVerifySighninMain.verifyAffiliatePaymentsPageNavigationTab(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);
					objTestBase.defaultWaitTime(1000);

					if (testStatus == "PASSED") {
						testStep = "Verification of Selecting an Affiliates from Affiliate Payments Page";
						visibilityStatus = objVerifySighninMain
								.verifyAffiliateSelectionFromAffiliatePaymentsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Affiliates Page Navigation";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.verifyAffiliatesPageNavigationTab(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Affiliate Payment Button Visibility Under Actions";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain
								.verifyPaymentsButtonVisibilityUnderActions(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Affiliate Payments Page Navigation";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.verifyAffiliatesPaymentsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of filling the Affiliate Payments details for Addition Payment Method";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain
								.verifyAffiliatesPaymentsFillingDetails(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification Payment Cancelled after clicking on 'CANCEL' button from Affiliate Payments page";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.verifyAffiliatesPaymentsCancellation(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Affiliate Payment Button Visibility Under Actions";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain
								.verifyPaymentsButtonVisibilityUnderActions(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Affiliate Payments Page Navigation";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.verifyAffiliatesPaymentsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

					testStep = "Verification of filling the Affiliate Payments details for Addition Payment Method";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain
								.verifyAffiliatesPaymentsFillingDetails(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Affiliate Payments Confirmation message displayed for Addition Payment Method.?";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain
								.verifyAffiliatesPaymentsConfirmationMsg(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

					objTestBase.defaultWaitTime(1000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);

					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,6000)", "");
					objTestBase.defaultWaitTime(2000);

					testStep = "Verification created Payment details is displayed from Affiliate Payements History section for Addition Payment Method.?";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.verifyAffiliatesPaymentsHistory(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

					objTestBase.defaultWaitTime(1000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);

					// Navigate Back Affiliate Payments Page:
					testStep = "Verification of Affiliates Payments Page Navigation after Payment Additon completed from Affiliates Page";
					visibilityStatus = objVerifySighninMain.verifyAffiliatePaymentsPageNavigationTab(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);
					objTestBase.defaultWaitTime(1000);

					if (testStatus == "PASSED") {
						testStep = "Verification of Selecting an Affiliates from Affiliate Payments Page after Payment Additon completed from Affiliates Page";
						visibilityStatus = objVerifySighninMain
								.verifyAffiliateSelectionFromAffiliatePaymentsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					if (testStatus == "PASSED") {
						testStep = "Verify visibility of 'Click To Process' option from Affiliate Payments Page - after Payment Additon completed from Affiliates Page";
						visibilityStatus = objVerifySighninMain
								.verifyVisibilityOfClickToProcessOptionFromAffiliatePaymentsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Selecting a Week to process the Payment from Affiliate Payments Page";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.selectweek(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verify visibility of Payment Confirmation Popup display after clicking on 'Click To Process' option from Affiliate Payments Page";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain
								.verifyVisibilityOfClickToProcessOptionFromAffiliatePaymentsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verify visibility of Payment Processed Confirmation Message displayed.?";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.visibilityOfAlertSuccessMessage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Payment Processed confirmation from Affiliate Payments Page - Extras Payments Tab";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.verifyPaymentStatusInExtraPaymentsTab(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verification of Rides Payout, Extra Payout and Total Payout reset back to ZERO after Processing the Additional Amount";
					if (testStatus == "PASSED") {
						visibilityStatus = objVerifySighninMain.verifyPayoutsAmountAfterProcessed(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					objTestBase.defaultWaitTime(1000);

				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	private Boolean verifyAffiliateActiveStatus(Boolean visibilityStatus) {
		try {
			objVerifySighninMain.clickAffiliateTab();
			objTestBase.defaultWaitTime(3000);
			objVerifySighninMain.clickonActiveAffiliateTab();
			objTestBase.defaultWaitTime(3000);
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Verify the availability of search bar in manage affiliate page";
			visibilityStatus = objVerifySighninMain.visibilityOfSearchBar(visibilityStatus);
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
			else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			utillLogger.info(testStep + " - " + testStatus);

			objTestBase.defaultWaitTime(3000);
			objVerifySighninMain.enterSearchInput();
			objTestBase.defaultWaitTime(3000);

			scenarioPage = objVerifySighninMain.visibilityOfActivateInactivateStatus(scenarioPage);
			testStep = "Verify the availability of Affiliate Activate Status in Manage " + scenarioPage
					+ " Affiliate Page";
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
			else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			utillLogger.info(testStep + " - " + testStatus);

			if (scenarioPage == "Inactive") {
				testStep = "Verify the visibility of pop-up alert to activate affiliate with yes or no options from "
						+ scenarioPage + " Affilate Page";
				visibilityStatus = objVerifySighninMain.visibilityOfpopup(visibilityStatus, scenarioPage);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				utillLogger.info(testStep + " - " + testStatus);
				objTestBase.defaultWaitTime(1000);

				testStep = "Verify the visibility of success message alert after Activating/Deactivating Affiliate ";
				visibilityStatus = objVerifySighninMain.visibilityOfAlertSuccessMessage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				utillLogger.info(testStep + " - " + testStatus);
			}

			objTestBase.defaultWaitTime(3000);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	@AfterClass(groups = "Dispatch.Affiliate")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
