package TravelAgent.AccountCreation;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1390_VerifyTheFunctionalityOfTravelAgentRegistrationThroughDispatch_Test extends TestBase {

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

	DEV_TC_1390_VerifyTheFunctionalityOfTravelAgentRegistrationThroughDispatch_Main objVerifySighninMain;
	DEV_TC_1390_VerifyTheFunctionalityOfTravelAgentRegistrationThroughDispatch_Test objVerifySighninTest;
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
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1390_VerifyTheFunctionalityOfTravelAgentRegistrationThroughDispatch_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1390_VerifyTheFunctionalityOfTravelAgentRegistrationThroughDispatch_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(4000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Dispatch Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifySighninMain.enterEMail();
				objVerifySighninMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of logged in user";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}

				objVerifySighninMain.clickTravelArranger();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickTravelAgent();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verification Manage travel agent page";
				visibilityStatus = objVerifySighninMain.visibilityOfManageTravelAgentPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

				objVerifySighninMain.clickAddTravelAgent();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Travel Agent Registration Page";
				visibilityStatus = objVerifySighninMain.visibilityOfTARegistrationPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

				objTestBase.defaultWaitTime(2000);
				utillLogger.info(testStep + " - " + testStatus);
				// Prod Restriction:
				if (!environmentCode.equalsIgnoreCase("prod")) {
					testStep = "Verify creation of Travel Arranger by filing all the required details";
					eMail = objVerifySighninMain.verifyFillingAllDetailsInTraveArrangerPage(eMail);
					if (eMail != null) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,50)", "");
						objTestBase.defaultWaitTime(2000);
						objVerifySighninMain.clickOnRegister();
						objTestBase.defaultWaitTime(8000);

						objVerifySighninMain.enterSearchField(eMail);
						objTestBase.defaultWaitTime(6000);

						driver.get(prop.getProperty("yopmailURL"));
						objTestBase.defaultWaitTime(6000);
						utillLogger.info(testStep + " - " + testStatus);
						testStep = "Verification of Email to confirm account - EMail = " + eMail;
						visibilityStatus = objVerifySighninMain.verifyyopeMail(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						utillLogger.info(testStep + " - " + testStatus);
						objVerifySighninMain.searchInput();
						objTestBase.defaultWaitTime(3000);

						objVerifySighninMain.clickOnConfirm();
						objTestBase.defaultWaitTime(3000);

						utillLogger.info(testStep + " - " + testStatus);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,150)", "");
						objTestBase.defaultWaitTime(2000);
						utillLogger.info(testStep + " - " + testStatus);

						objVerifySighninMain.confirmEmailAccount();
						objTestBase.defaultWaitTime(3000);
						visibilityStatus = objVerifySighninMain.switchToConfirmAccountWindow(visibilityStatus);
						objTestBase.defaultWaitTime(1000);
						if (visibilityStatus.booleanValue() == true) {
							currURL = driver.getCurrentUrl();
							if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
								objTestBase.defaultWaitTime(1000);
								objVerifySighninMain.passwordConfirmPwdInputs();
								objTestBase.defaultWaitTime(1000);
								objVerifySighninMain.clickOncheckbox();
								objTestBase.defaultWaitTime(2000);
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							} else
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
						}

						utillLogger.info(testStep + " - " + testStatus);
						testStep = "Verification of Registered Email to confirm account";
						visibilityStatus = objVerifySighninMain.verifyActivatePage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);

						utillLogger.info(testStep + " - " + testStatus);
						objTestBase.defaultWaitTime(3000);
						objVerifySighninMain.clickActivateBtn();
						objTestBase.defaultWaitTime(500);
						testStep = "Verification Success Message";
						visibilityStatus = objVerifySighninMain.visibilityOfAlertMessage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);

						utillLogger.info(testStep + " - " + testStatus);
						objTestBase.defaultWaitTime(3000);

						if (visibilityStatus.booleanValue() == true) {
							driver.get(prop.getProperty("travelAgentURL"));
							objTestBase.defaultWaitTime(3000);
							utillLogger.info(testStep + " - " + testStatus);
							objTestBase.defaultWaitTime(1000);
							visibilityStatus = objVerifySighninMain.eMailTravelArrange(visibilityStatus, eMail);
							objTestBase.defaultWaitTime(1000);
							objVerifySighninMain.passwordTravelArranger();
							objTestBase.defaultWaitTime(1000);
							objVerifySighninMain.eyeIconClick();
							objTestBase.defaultWaitTime(1000);
							utillLogger.info(testStep + " - " + testStatus);
							testStep = "Verification of registered user login details from TravelAgent Portal Login Page";
							visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								objVerifySighninMain.clickSigninButton();
								objTestBase.defaultWaitTime(3000);
								driver.navigate().refresh();
								objTestBase.defaultWaitTime(1000);
								testStatus = "PASSED";
							} else
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);

							utillLogger.info(testStep + " - " + testStatus);
							testStep = "Verification of TravelAgent Portal Login With registered email";
							visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
							if (visibilityStatus.booleanValue() == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							utillLogger.info(testStep + " - " + testStatus);
						}
					} else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

					utillLogger.info(testStep + " - " + testStatus);
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.AccountCreation")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
