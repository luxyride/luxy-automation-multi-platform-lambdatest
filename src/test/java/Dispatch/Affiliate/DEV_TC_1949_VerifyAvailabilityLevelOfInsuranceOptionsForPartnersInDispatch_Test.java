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

public class DEV_TC_1949_VerifyAvailabilityLevelOfInsuranceOptionsForPartnersInDispatch_Test extends TestBase {

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

	DEV_TC_1949_VerifyAvailabilityLevelOfInsuranceOptionsForPartnersInDispatch_Main objVerifySighninMain;
	DEV_TC_1949_VerifyAvailabilityLevelOfInsuranceOptionsForPartnersInDispatch_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.Affiliate")
	@Parameters({ "browser" })
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
			objVerifySighninMain = new DEV_TC_1949_VerifyAvailabilityLevelOfInsuranceOptionsForPartnersInDispatch_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1949_VerifyAvailabilityLevelOfInsuranceOptionsForPartnersInDispatch_Test();
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
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButton();
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

				objVerifySighninMain.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
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

				objVerifySighninMain.clickAffiliateTab();
				objTestBase.defaultWaitTime(3000);

				testStep = "verify the availability of inactive / active affiliates in manage affiliate page";
				visibilityStatus = objVerifySighninMain.visibilityOfActiveandInactiveTabs(visibilityStatus);
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
				objVerifySighninMain.clickOnActiveAffiliateTab();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verify only Active affiliates in manage affiliate Page";
				visibilityStatus = objVerifySighninMain.visibilityOfActiveAffiliate(visibilityStatus);
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

				testStep = "Verify the availability Level of Insurance Options COI Expiration Date for partners in Dispatch from Active Affiliates Tab";
				visibilityStatus = objVerifySighninMain
						.visibilityOfInsuranceOptions_COIExpirationDate_ActiveAffiliateTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verify the availability of Commercial Insurance in Dispatch from Active Affiliates Tab";
				visibilityStatus = objVerifySighninMain
						.visibilityOfInsuranceOptions_CommercialInsurance_ActiveAffiliateTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verify navigation of InActive Affilate Tab in Dispatch";
				visibilityStatus = objVerifySighninMain.navigationOfInactiveAffiliateTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verify the availability Level of Insurance Options COI Expiration Date for partners in Dispatch from InActive Affiliates Tab";
				visibilityStatus = objVerifySighninMain
						.visibilityOfInsuranceOptions_COIExpirationDate_InActiveAffiliateTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verify the availability of Commercial Insurance in Dispatch from InActive Affiliates Tab";
				visibilityStatus = objVerifySighninMain
						.visibilityOfInsuranceOptions_CommercialInsurance_InActiveAffiliateTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}
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

	@AfterClass(groups = "Dispatch.Affiliate")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
