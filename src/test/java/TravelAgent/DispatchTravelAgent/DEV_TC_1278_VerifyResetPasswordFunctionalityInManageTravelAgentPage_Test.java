package TravelAgent.DispatchTravelAgent;

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

public class DEV_TC_1278_VerifyResetPasswordFunctionalityInManageTravelAgentPage_Test extends TestBase {

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

	DEV_TC_1278_VerifyResetPasswordFunctionalityInManageTravelAgentPage_Main objVerifyTADeletionMain;
	DEV_TC_1278_VerifyResetPasswordFunctionalityInManageTravelAgentPage_Test objVerifyTADeletionTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.DispatchTravelAgent")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.DispatchTravelAgent")
	public void activationOfNewUserAfterRegistration() throws Exception {
		try {
			objVerifyTADeletionMain = new DEV_TC_1278_VerifyResetPasswordFunctionalityInManageTravelAgentPage_Main(
					driver);
			objVerifyTADeletionTest = new DEV_TC_1278_VerifyResetPasswordFunctionalityInManageTravelAgentPage_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyTADeletionTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyTADeletionTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");
			System.out.println("Travel Agent Registered Email = " + eMail);
			utillLogger.info("Travel Agent Registered Email ID registered from DEV_TC_1196: = " + eMail);
			testStep = "Verification of registered travel agent user Reset Password Functinality.";
			if (eMail != null) {
				testStep = "Verification of Dispatch Site Login.?";
				visibilityStatus = objVerifyTADeletionMain.verifyDispatchLogin(visibilityStatus, eMail);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				if (testStatus == "PASSED") {
					testStep = "Verification of Manage Travel Agent dashboard navigation";
					visibilityStatus = objVerifyTADeletionMain.verifyTravelAgentPageNavigation(visibilityStatus, eMail);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify visibitlity of RESET Password button from Manage Travel Agent Page";
					visibilityStatus = objVerifyTADeletionMain.verifyVisibilityOfResetButton(visibilityStatus, eMail);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify visibitlity of RESET Password Confirmation Popup from Manage Travel Agent Page";
					visibilityStatus = objVerifyTADeletionMain
							.verifyVisibilityOfConfirmResetPasswordPopup(visibilityStatus, eMail);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify visibitlity of Manage Travel Agent Dashboard Page when user clicks on 'No' ";
					visibilityStatus = objVerifyTADeletionMain.clickOnNoVerifyManageTAPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				testStep = "Verify visibitlity of RESET Password button from Manage Travel Agent Page";
				visibilityStatus = objVerifyTADeletionMain.verifyVisibilityOfResetButton(visibilityStatus, eMail);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				if (testStatus == "PASSED") {
					testStep = "Verify visibitlity of RESET Password Confirmation Popup from Manage Travel Agent Page";
					visibilityStatus = objVerifyTADeletionMain
							.verifyVisibilityOfConfirmResetPasswordPopup(visibilityStatus, eMail);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify visibitlity of Password Reset Confirmaiton Notification message from Manage Travel Agent Page after clicking on 'YES' button";
					visibilityStatus = objVerifyTADeletionMain.clickOnYesVerifyManageTAPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify RESET Password EMail received.?";
					visibilityStatus = objVerifyTADeletionMain.verifyResetPasswordEmail(visibilityStatus, eMail);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
				objTestBase.defaultWaitTime(2000);

				objVerifyTADeletionMain.confirmEmailAccount();
				objTestBase.defaultWaitTime(3000);

				visibilityStatus = objVerifyTADeletionMain.verifyConfirmResetPassword(visibilityStatus);
				testStep = "Confirm Reset Password Page";
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus.booleanValue() == true) {
					currURL = driver.getCurrentUrl();
					if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
						objTestBase.defaultWaitTime(1000);
						objVerifyTADeletionMain.passwordConfirmPwdInputs();
						objTestBase.defaultWaitTime(3000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify RESET Password Confirmation";
					visibilityStatus = objVerifyTADeletionMain.confirmResetPassword(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify entering the newly updated password from Travel Agent Login Page";
					visibilityStatus = objVerifyTADeletionMain.verifyLoginWithNewPassword(visibilityStatus, eMail);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				if (testStatus == "PASSED") {
					testStep = "Verify Travel Agent Login with newly updated Password";
					visibilityStatus = objVerifyTADeletionMain.visibilityOfLoggedinUser(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				objTestBase.defaultWaitTime(3000);
				objTestBase.closePopupWindow();
				utillLogger.info(testStep + " - " + testStatus);

			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
			utillLogger.info(testStep + " - Deleted EMail account is: " + eMail + " - TestStatus = " + testStatus);

		} catch (Exception ex) {
			ex.printStackTrace();
			testStep = "Activation of New User after Registration";
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.DispatchTravelAgent")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyTADeletionTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
