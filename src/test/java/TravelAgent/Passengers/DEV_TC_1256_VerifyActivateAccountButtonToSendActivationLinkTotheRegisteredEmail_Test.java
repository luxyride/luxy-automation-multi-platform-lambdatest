package TravelAgent.Passengers;

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

public class DEV_TC_1256_VerifyActivateAccountButtonToSendActivationLinkTotheRegisteredEmail_Test extends TestBase {

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

	DEV_TC_1256_VerifyActivateAccountButtonToSendActivationLinkTotheRegisteredEmail_Main objVerifySighninMain;
	DEV_TC_1256_VerifyActivateAccountButtonToSendActivationLinkTotheRegisteredEmail_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.Passengers")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.Passengers")
	public void VerifyUIOfPassengerRegistrationFormInTravelAgentSite_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1256_VerifyActivateAccountButtonToSendActivationLinkTotheRegisteredEmail_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1256_VerifyActivateAccountButtonToSendActivationLinkTotheRegisteredEmail_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("travelAgentURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Available Fields in Log-in Page ";
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInput();
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

				testStep = "Verify logged in user";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				objVerifySighninMain.clickOnPassengerTab();
				objTestBase.defaultWaitTime(4000);
				testStep = "Verification of Manage passenegr page";
				visibilityStatus = objVerifySighninMain.visibilityOfManagePassengerPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				objTestBase.defaultWaitTime(2000);
				eMail = objVerifySighninMain.searchPassenger(eMail);
				objTestBase.defaultWaitTime(3000);

				testStep = "Verify visibility of Passenger Activation Button";
				visibilityStatus = objVerifySighninMain.visibilityOfPassengerActivateButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				testStep = "Verification of Passenger Activation Popup Confimation displayed for Selectin 'No' Option.?";
				visibilityStatus = objVerifySighninMain
						.visibilityOfActivatePassengerPopupConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				testStep = "Verification of Navigating Back to Manage Passenger Page After Clicking on 'No' button from Confirmation Popup";
				visibilityStatus = objVerifySighninMain
						.verificationOfNavigatingBackToManagePassengerPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				testStep = "Verification of Passenger Activation Popup Confimation displayed for Selectin 'Yes' Option.?";
				visibilityStatus = objVerifySighninMain
						.visibilityOfActivatePassengerPopupConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				testStep = "Verification of Activate Passenger Confirmation Message After Clicking on 'Yes' button from Confirmation Popup";
				visibilityStatus = objVerifySighninMain
						.verificationOfActivatePassengerConfirmationMessage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(300000);	//5Mins:
				testStep = "Verify Activation of Registered Passenger Email";
				if (testStatus == "PASSED" && eMail != null) {
					driver.get(prop.getProperty("yopmailURL"));
					driver.manage().window().maximize();
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);

					objVerifySighninMain.clearButtonTA();
					objTestBase.defaultWaitTime(1000);

					eMail = objVerifySighninMain.emailIDSerachTA(eMail);
					objTestBase.defaultWaitTime(1000);

					System.out.println("Regression Email = " + eMail);
					utillLogger
							.info(objVerifySighninMain.getClass().getSimpleName() + " - Regression Email = " + eMail);

					testStep = "Verify New Travel Agent User Account - EMail Confirmation";
					visibilityStatus = objVerifySighninMain.verifyyopeMailTA(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);

					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,150)", "");
					objTestBase.defaultWaitTime(2000);

					objVerifySighninMain.confirmEmailAccountTA();
					objTestBase.defaultWaitTime(3000);

					visibilityStatus = objVerifySighninMain.switchToConfirmAccountWindowTA(visibilityStatus);
					objTestBase.defaultWaitTime(1000);
					testStatus = "";
					testStep = "Confirm New Travel Agent Passenger User Account Registration";
					if (visibilityStatus.booleanValue() == true) {
						currURL = driver.getCurrentUrl();
						if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
							objTestBase.defaultWaitTime(1000);
							testStep = "Verification of Confirm Password Popup displayed.?";
							visibilityStatus = objVerifySighninMain.passwordConfirmPasswordInputsTA(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								objTestBase.defaultWaitTime(3000);
								objVerifySighninMain.clickOnConfirmEMailAccountTA();
								objTestBase.defaultWaitTime(1000);
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
					}

					// Method to close Pop-up Window:
					objTestBase.closePopupWindow();

					testStep = "Verification of Registered User Login after account activation completed";
					if (testStatus == "PASSED") {
						testStatus = " ";

						objTestBase.defaultWaitTime(1000);
						objVerifySighninMain.clickLoginUserPortal();

						objVerifySighninMain.eMailInputUserPortal(eMail);
						objTestBase.defaultWaitTime(1000);
						objVerifySighninMain.passwordInputUserPortal();
						objTestBase.defaultWaitTime(1000);

						objVerifySighninMain.eyeIconClickUserPortal();
						objTestBase.defaultWaitTime(1000);
						visibilityStatus = objVerifySighninMain.visibilityOfSigninButtonUserPortal(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							objVerifySighninMain.clickSigninButtonUserPortal();
							objTestBase.defaultWaitTime(3000);
							driver.navigate().refresh();
							objTestBase.closePopupWindow();
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUserPortal(visibilityStatus);
						testStep = "Verification of User Portal Login";
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

				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				utillLogger.info(testStep + " - " + testStatus);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.Passengers")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
