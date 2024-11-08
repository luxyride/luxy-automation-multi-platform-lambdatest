package Dispatch.Affiliate;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1607_VerifyTheFunctionalityOfActivationOrDeactivationOfAffiliatesInDispatchPortal_Test
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

	DEV_TC_1607_VerifyTheFunctionalityOfActivationOrDeactivationOfAffiliatesInDispatchPortal_Main objVerifySighninMain;
	DEV_TC_1607_VerifyTheFunctionalityOfActivationOrDeactivationOfAffiliatesInDispatchPortal_Test objVerifySighninTest;
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
			objVerifySighninMain = new DEV_TC_1607_VerifyTheFunctionalityOfActivationOrDeactivationOfAffiliatesInDispatchPortal_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1607_VerifyTheFunctionalityOfActivationOrDeactivationOfAffiliatesInDispatchPortal_Test();
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
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				utillLogger.info(testStep + " - " + testStatus);
				objVerifySighninMain.clickNewBooking();
				objTestBase.defaultWaitTime(3000);
				utillLogger.info(testStep + " - " + testStatus);

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

				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(5000);

				if (scenarioPage == "Inactive") {
					objVerifySighninMain.clickonActiveAffiliateTab();
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.enterSearchInput();
					objTestBase.defaultWaitTime(3000);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify only ACTIVE affiliates in manage affiliate Page";
					visibilityStatus = objVerifySighninMain.visibilityOfActiveAffiliate(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify the availability of DeActivate button in Manage affiliate page";
					visibilityStatus = objVerifySighninMain.visibilityOfDeActivateBtn(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify the visibility of pop-up alert to activate affiliate with yes or no options";
					visibilityStatus = objVerifySighninMain.visibilityOfDeActivatepopup(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.chooseReasonFromDropDown();
					objTestBase.defaultWaitTime(1000);

					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify the visibility of success message alert after Deactitvating affiliate ";
					visibilityStatus = objVerifySighninMain.visibilityOfAlertSuccessMessage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					utillLogger.info(testStep + " - " + testStatus);
				} else if (scenarioPage == "Active") {
					objVerifySighninMain.clickonInActiveAffiliateTab();
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.enterSearchInput();
					objTestBase.defaultWaitTime(3000);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify only Inactive affiliates in manage affiliate Page";
					visibilityStatus = objVerifySighninMain.visibilityOfActivateBtn(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify the visibility of pop-up alert to activate affiliate with yes or no options";
					visibilityStatus = objVerifySighninMain.visibilityOfActivatepopup(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.chooseReasonFromDropDown();
					objTestBase.defaultWaitTime(1000);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify the visibility of success message alert after Deactitvating affiliate ";
					visibilityStatus = objVerifySighninMain.visibilityOfAlertSuccessMessage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					utillLogger.info(testStep + " - " + testStatus);
				}
				objTestBase.defaultWaitTime(3000);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Dispatch.Affiliate")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
