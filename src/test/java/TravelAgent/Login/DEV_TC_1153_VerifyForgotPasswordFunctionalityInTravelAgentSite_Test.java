package TravelAgent.Login;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1153_VerifyForgotPasswordFunctionalityInTravelAgentSite_Test extends TestBase {

	String currURL;
	String screenshotPath;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	Actions action;
	Boolean visibilityStatus;
	String executeBrwsr;
	String scenario = "changepassword";
	String exception = "";

	DEV_TC_1153_VerifyForgotPasswordFunctionalityInTravelAgentSite_Main objVerifyForgotPwdMain;
	DEV_TC_1153_VerifyForgotPasswordFunctionalityInTravelAgentSite_Test objVerifyForgotPwdTest;

	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.Login")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
			executeBrwsr = browser;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.Login")
	public void VerifyTheFunctionalityForgotPassword() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyForgotPwdMain = new DEV_TC_1153_VerifyForgotPasswordFunctionalityInTravelAgentSite_Main(driver);
			objVerifyForgotPwdTest = new DEV_TC_1153_VerifyForgotPasswordFunctionalityInTravelAgentSite_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyForgotPwdTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyForgotPwdTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("travelAgentURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);
			currURL = driver.getCurrentUrl();

			testStep = "Verify Dispatch Portal Launch Homepage";
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verify visibility of Forgot Password Link from LoginPage";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = objVerifyForgotPwdMain.visibilityOfForgotPwdLink(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
					objVerifyForgotPwdMain.forgotPwdlinkClick();
					objTestBase.defaultWaitTime(3000);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verify Send Email for Forgot Password";
				visibilityStatus = objVerifyForgotPwdMain.visibilityOfGetResetLinkClick(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					objTestBase.defaultWaitTime(1000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					objVerifyForgotPwdMain.eMailInput();
					objTestBase.defaultWaitTime(1000);
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(1000);
					objVerifyForgotPwdMain.GetResetLinkClick();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(2000);
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verify Forgot Password pop-up Message";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				// --------------------------------------------------
				// Validating the YopMail Forgot Password Link:
				driver.get(prop.getProperty("yopmailURL"));
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);

				objVerifyForgotPwdMain.yopMaileMailInput();
				objTestBase.defaultWaitTime(2000);
				driver.navigate().refresh();
				utillLogger.info(testStep + " - " + testStatus);
				visibilityStatus = objVerifyForgotPwdMain.visibilityOfyopMailForgotPwdLink(visibilityStatus);
				testStep = "Verify Forgot Password Email Link";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyForgotPwdMain.yopMailforgotPwdLinkClick();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = objVerifyForgotPwdMain.switchToWindow(visibilityStatus);
				objTestBase.defaultWaitTime(3000);

				testStep = "Reset Password Confirmation Page";
				if (visibilityStatus.booleanValue() == true) {
					testStatus = "";
					objVerifyForgotPwdMain.passwordInput(scenario);
					objTestBase.defaultWaitTime(1000);
					objVerifyForgotPwdMain.confirmPwdInput(scenario);
					objTestBase.defaultWaitTime(1000);
					objVerifyForgotPwdMain.confirmPwdSubmitBtn(scenario);
					objTestBase.defaultWaitTime(1000);

					testStep = "Verify Reset Password Confirmation Message displayed.?";
					visibilityStatus = objVerifyForgotPwdMain
							.visibilityOfConfirmPwdConfirmationMessage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						objTestBase.defaultWaitTime(3000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}
				utillLogger.info(testStep + " - " + testStatus);
				// -------------------------------------------------------
				// ## Verify New Password login:
				driver.get(prop.getProperty("travelAgentURL"));
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);

				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyForgotPwdMain.entereMail(visibilityStatus);
					objTestBase.defaultWaitTime(1000);
					objVerifyForgotPwdMain.enterpassword(scenario);
					objTestBase.defaultWaitTime(1000);
					objVerifyForgotPwdMain.clickSignInButton();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Dispatch Portal Login with New Password";
					visibilityStatus = objVerifyForgotPwdMain.visibilityOfLoggedInUserName(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					testStatus = "SKIP";
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// -------------------------------------------------------
			utillLogger.info(testStep + " - " + testStatus);

			objVerifyForgotPwdMain.clickOnuserLoginName();
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyForgotPwdMain.visibilityOfLoginDropdown(visibilityStatus);
			testStep = "Verify Signout button from UserLogin Dropdown";
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			visibilityStatus = false;// Reset

			objVerifyForgotPwdMain.clickOnSignoutButton();
			objTestBase.defaultWaitTime(2000);

			// -------------------------------------------------------
			// Reset Back to Main Password:
			testStatus = resetBacktoMainPassword(testStatus);
			if (testStatus == "PASSED")
				System.out.println("RESET PASSWORD SUCCESS");
			else
				System.out.println("RESET PASSWORD FAILED");
			// -------------------------------------------------------
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			// Reset Back to Main Password:
			testStatus = resetBacktoMainPassword(testStatus);
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	private String resetBacktoMainPassword(String testStatus) {
		try {
			action = new Actions(driver);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(1000);

			currURL = driver.getCurrentUrl();

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {

				objTestBase.defaultWaitTime(1000);
				testStep = "Verify Travel Agent Homepage navigation after Clicking on Signout";
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";

				visibilityStatus = objVerifyForgotPwdMain.entereMail(visibilityStatus);
				objTestBase.defaultWaitTime(1000);
				objVerifyForgotPwdMain.enterpassword(scenario);
				objTestBase.defaultWaitTime(1000);
				objVerifyForgotPwdMain.clickSignInButton();
				objTestBase.defaultWaitTime(3000);

				objVerifyForgotPwdMain.clickOnuserLoginName();
				objTestBase.defaultWaitTime(2000);
				objVerifyForgotPwdMain.clickChangePWDbutton();
				objTestBase.defaultWaitTime(2000);

				scenario = "resetBacktoMainPwd";
				visibilityStatus = objVerifyForgotPwdMain.enterChangePWDDetails(visibilityStatus, scenario);
				objTestBase.defaultWaitTime(1000);
				objVerifyForgotPwdMain.clickOnChangePWDSubmit();
				objTestBase.defaultWaitTime(3000);

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(1000);

				objVerifyForgotPwdMain.clickOnuserLoginName();
				objTestBase.defaultWaitTime(2000);
				objVerifyForgotPwdMain.clickOnSignoutButton();
				objTestBase.defaultWaitTime(1000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
		return testStatus;
	}

	@AfterClass(groups = "TravelAgent.Login")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyForgotPwdTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
