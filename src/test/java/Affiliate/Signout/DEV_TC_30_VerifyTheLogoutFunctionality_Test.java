package Affiliate.Signout;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_30_VerifyTheLogoutFunctionality_Test extends TestBase {

	Actions action;
	String currURL;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	TestBase objTestBase;
	String exception = "";
	String screenshotPath;
	Boolean visibilityStatus;
	UpdateExtentReportResults objupdateResults;

	DEV_TC_30_VerifyTheLogoutFunctionality_Main objVerifylogoutMain;
	DEV_TC_30_VerifyTheLogoutFunctionality_Test objVerifylogoutTest;

	@BeforeClass(groups = "Affiliate.Signout")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Affiliate.Signout")
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifylogoutMain = new DEV_TC_30_VerifyTheLogoutFunctionality_Main(driver);
			objVerifylogoutTest = new DEV_TC_30_VerifyTheLogoutFunctionality_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifylogoutTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifylogoutTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("affiliateURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of affiliate Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifylogoutMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifylogoutMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifylogoutMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifylogoutMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifylogoutMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifylogoutMain.clickOnRides();
				objTestBase.defaultWaitTime(3000);
				objVerifylogoutMain.clickOnAllTab();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of affiliate Portal Login With Valid Credentials";
				visibilityStatus = objVerifylogoutMain.visibilityOfLoggedinUser(visibilityStatus);
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

			objVerifylogoutMain.clickWelcomeDropdown();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of availability of logout option under welcome dropdown";
			visibilityStatus = objVerifylogoutMain.visibilityOflogout(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				screenshotPath = getScreenshot(driver, "Verifylogout");
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);

			objVerifylogoutMain.clickLogoutoption();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of functionality of logout option ";
			visibilityStatus = objVerifylogoutMain.visibilityOflogin(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				screenshotPath = getScreenshot(driver, "Verifylogin");
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}

	}

	@AfterClass(groups = "Affiliate.Signout")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifylogoutTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
