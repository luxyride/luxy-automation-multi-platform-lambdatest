package Dispatch.Affiliate;

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

public class DEV_TC_1873_VerifyTheAvailabilityOfApplicantStatusInAffiliatePortal_Test extends TestBase {

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

	DEV_TC_1873_VerifyTheAvailabilityOfApplicantStatusInAffiliatePortal_Main objVerifySighninMain;
	DEV_TC_1873_VerifyTheAvailabilityOfApplicantStatusInAffiliatePortal_Test objVerifySighninTest;
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
			objVerifySighninMain = new DEV_TC_1873_VerifyTheAvailabilityOfApplicantStatusInAffiliatePortal_Main(driver);
			objVerifySighninTest = new DEV_TC_1873_VerifyTheAvailabilityOfApplicantStatusInAffiliatePortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("yopmailURL"));
			driver.manage().window().maximize();
			driver.navigate().refresh();
			objTestBase.closePopupWindow();

			objVerifySighninMain.clearButton();
			objTestBase.defaultWaitTime(1000);

			eMail = objVerifySighninMain.emailIDSerach(eMail);
			objTestBase.defaultWaitTime(1000);

			System.out.println("Regression Email = " + eMail);
			utillLogger.info(objVerifySighninMain.getClass().getSimpleName() + " - Regression Email = " + eMail);

			testStep = "Verify New User Luxy Account - EMail Confirmation";
			visibilityStatus = objVerifySighninMain.verifyyopeMail(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "FAILED";
			}

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.confirmEmailAccount();
			objTestBase.defaultWaitTime(3000);

			visibilityStatus = objVerifySighninMain.verifyConfirmAccountPasswordPage(visibilityStatus);
			objTestBase.defaultWaitTime(1000);

			testStep = "Verify Confirm New User Account Signup";
			if (visibilityStatus.booleanValue() == true) {
				currURL = driver.getCurrentUrl();
				if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.affiliatepasswordInput();
					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.affiliateconfirmPassword();
					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.clickOnTermsAndConditionsCheckbox();
					objTestBase.defaultWaitTime(3000);
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);

					js.executeScript("window.scrollBy(0,200)", "");
					objTestBase.defaultWaitTime(2000);

					testStep = "Verification of Account Activation Confirmation Message Displayed for registered User - "
							+ eMail;
					visibilityStatus = objVerifySighninMain
							.visibilityOfActivateAccountConfirmationMsg(visibilityStatus);
					objTestBase.defaultWaitTime(1000);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);

					objTestBase.closePopupWindow();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			testStep = "Verification of Navigating to Affiliate Portal after Clicking on Confirm Account - " + eMail;
			visibilityStatus = objVerifySighninMain.verifyAffiliatePageLoad(visibilityStatus);
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
			else if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep);

			testStep = "Verification of Login with the above registered Email account after Account Activated - "
					+ eMail;
			if (visibilityStatus.booleanValue() == true) {
				testStatus = " ";
				objVerifySighninMain.eMailInputAffiliate(eMail);
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInputAffiliate();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClickAffiliate();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButtonAffiliate(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButtonAffiliate();
					objTestBase.defaultWaitTime(3000);
				} else if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);

				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of affiliate Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUserAffiliate(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
				else if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);

				utillLogger.info(testStep + " - " + testStatus);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

			testStep = "Verify visibility of Status in Affiliate Home Page";
			visibilityStatus = objVerifySighninMain.visibilityOfStatusInAffiliatePage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
			else if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep);

			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
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
