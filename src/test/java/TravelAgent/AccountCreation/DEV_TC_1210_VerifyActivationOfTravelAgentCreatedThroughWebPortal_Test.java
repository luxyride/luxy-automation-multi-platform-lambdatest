package TravelAgent.AccountCreation;

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

public class DEV_TC_1210_VerifyActivationOfTravelAgentCreatedThroughWebPortal_Test extends TestBase {

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
	JavascriptExecutor js;

	DEV_TC_1210_VerifyActivationOfTravelAgentCreatedThroughWebPortal_Main objVerifyUserActivationMain;
	DEV_TC_1210_VerifyActivationOfTravelAgentCreatedThroughWebPortal_Test objVerifyUserActivationTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.AccountCreation")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.AccountCreation")
	public void activationOfNewUserAfterRegistration() throws Exception {
		try {
			verifyActivationOfTravelAgentCreatedThroughWebPortal();
		} catch (Exception ex) {
			ex.printStackTrace();
			testStep = "Activation of New User after Registration";
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
		}
	}

	public void verifyActivationOfTravelAgentCreatedThroughWebPortal() throws Exception {
		try {
			objVerifyUserActivationMain = new DEV_TC_1210_VerifyActivationOfTravelAgentCreatedThroughWebPortal_Main(
					driver);
			objVerifyUserActivationTest = new DEV_TC_1210_VerifyActivationOfTravelAgentCreatedThroughWebPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyUserActivationTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyUserActivationTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			System.out.println("Travel Agent Registered Email = " + eMail);
			utillLogger.info("Travel Agent Registered Email ID registered from DEV_TC_1196: = " + eMail);
			testStep = "Verification of registered travel agent users Email Activation - Email = " + eMail;
			if (eMail != null) {
				driver.get(prop.getProperty("yopmailURL"));
				driver.manage().window().maximize();
				driver.navigate().refresh();
				objTestBase.closePopupWindow();

				objVerifyUserActivationMain.clearButton();
				objTestBase.defaultWaitTime(1000);

				eMail = objVerifyUserActivationMain.emailIDSerach(eMail);
				objTestBase.defaultWaitTime(1000);

				System.out.println("Regression Email = " + eMail);
				utillLogger.info(
						objVerifyUserActivationTest.getClass().getSimpleName() + " - Regression Email = " + eMail);

				testStep = "Verify New Travel Agent User Account - EMail Confirmation - Email = " + eMail;
				visibilityStatus = objVerifyUserActivationMain.verifyyopeMail(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "FAILED";
				}

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
				objTestBase.defaultWaitTime(2000);

				objVerifyUserActivationMain.confirmEmailAccount();
				objTestBase.defaultWaitTime(3000);

				visibilityStatus = objVerifyUserActivationMain.switchToConfirmAccountWindow(visibilityStatus);
				objTestBase.defaultWaitTime(1000);
				testStep = "Confirm New Travel Agent User Account Registration";
				if (visibilityStatus.booleanValue() == true) {
					currURL = driver.getCurrentUrl();
					if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
						objTestBase.defaultWaitTime(1000);
						objVerifyUserActivationMain.passwordConfirmPasswordInputs();
						objTestBase.defaultWaitTime(3000);
						objVerifyUserActivationMain.clickOncheckbox();
						objTestBase.defaultWaitTime(1000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					} else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				}

				objVerifyUserActivationMain.activateAccount();
				objTestBase.defaultWaitTime(3000);
				objTestBase.closePopupWindow();
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Re-login with the registered Email account";
				if (testStatus == "PASSED") {
					testStatus = " ";
					objTestBase.defaultWaitTime(1000);
					objVerifyUserActivationMain.eMailInput(eMail);
					objVerifyUserActivationMain.passwordInput();
					objTestBase.defaultWaitTime(1000);
					visibilityStatus = objVerifyUserActivationMain.visibilityOfSigninButton(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						objVerifyUserActivationMain.clickSigninButton();
						objTestBase.defaultWaitTime(3000);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objVerifyUserActivationMain.clickNewBooking();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of TravelAgent Portal Login With Valid Credentials";
					visibilityStatus = objVerifyUserActivationMain.visibilityOfLoggedinUser(visibilityStatus);
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
				utillLogger.info(testStep + " - " + testStatus);
				extent.endTest(logger);

				// Delete Created user from Dispatch Site:
				testStep = "Delete registered user from Dispath after all validations completed - " + "\n"
						+ "#Note: This step is only for Automation Suite runs to avoid unnecessary account creation on daily test runs.";
				visibilityStatus = objVerifyUserActivationMain.deleteCreatedUserfromDispatch(visibilityStatus, eMail);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				}
				utillLogger.info(testStep + " - Deleted EMail account is: " + eMail + " - TestStatus = " + testStatus);
			} else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
		} catch (Exception ex) {
			ex.printStackTrace();
			testStep = "Activation of New User after Registration";
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.AccountCreation")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyUserActivationTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
