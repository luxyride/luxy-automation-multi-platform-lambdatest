package UserPortal.SignUp;

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

public class DEV_TC_1884_VerifyTheNewUserSignUpFlowInUserPortal_Test extends TestBase {

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

	DEV_TC_1884_VerifyTheNewUserSignUpFlowInUserPortal_Main objVerifySighninMain;
	DEV_TC_1884_VerifyTheNewUserSignUpFlowInUserPortal_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "UserPortal.SignUp")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "UserPortal.SignUp")
	public void Verification_Of_UserPortal_SignUp() throws Exception {
		try {
			objVerifySighninMain = new DEV_TC_1884_VerifyTheNewUserSignUpFlowInUserPortal_Main(driver);
			objVerifySighninTest = new DEV_TC_1884_VerifyTheNewUserSignUpFlowInUserPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");
			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
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

			// Method to close Pop-up Window:
			objTestBase.closePopupWindow();
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
				|| browserType.equalsIgnoreCase("chromeiOSMobileView")
				|| browserType.equalsIgnoreCase("chromeLocal")) {
					clickOnToggleNavigationBar();
			}

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification Customer User Login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				if (!browserType.equalsIgnoreCase("chromeAndroidMobileView")
						|| !browserType.equalsIgnoreCase("chromeiOSMobileView")
						|| !browserType.equalsIgnoreCase("chromeLocal")) {
					objVerifySighninMain.clickSignIn();
					objTestBase.defaultWaitTime(2000);
				}

				testStep = "Verify customer log-in opion under sign in dropdown ";
				visibilityStatus = objVerifySighninMain.visibilityOfDropDown(visibilityStatus);
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

				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.clickOnCustomerLogin();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.clickOnSignup();
				objTestBase.defaultWaitTime(8000);

				testStep = "visibility of sign up page ";
				visibilityStatus = objVerifySighninMain.visibilityOfSignUpPage(visibilityStatus);
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

				utillLogger.info(testStep + " - " + testStatus);
				if (testStatus == "PASSED") {
					testStatus = " ";
					Thread.sleep(1000);
					action = new Actions(driver);

					objVerifySighninMain.fNameInput();
					objTestBase.defaultWaitTime(1000);

					objVerifySighninMain.lNameInput();
					objTestBase.defaultWaitTime(1000);

					eMail = objVerifySighninMain.eMailInput(eMail);
					objTestBase.defaultWaitTime(1000);

					System.out.println("Regression Email = " + eMail);
					utillLogger
							.info(objVerifySighninTest.getClass().getSimpleName() + " - Regression Email = " + eMail);

					objVerifySighninMain.passwordInput();
					objTestBase.defaultWaitTime(1000);

					objVerifySighninMain.phoneNumberInput();
					objTestBase.defaultWaitTime(1000);

					objVerifySighninMain.termsConditionsCheckbox();
					objTestBase.defaultWaitTime(1000);
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)", "");

					visibilityStatus = objVerifySighninMain.visibilityOfSignupButtonFromSignupScreen(visibilityStatus);
					testStep = "Verify User entered details from Signup page";
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

					// Prod Restriction:
					if (!environmentCode.equalsIgnoreCase("prod")) {
						objTestBase.defaultWaitTime(1000);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,100)", "");
						objTestBase.defaultWaitTime(2000);

						visibilityStatus = objVerifySighninMain.visibilityOfSignupConfirmationMsg(visibilityStatus);
						testStep = "Verification of User Signup Confirmation Message.!";
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					}
				} else {
					testStep = "Verify User entered details from Signup page";
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				}
				utillLogger.info(testStep + " - " + testStatus);
				objTestBase.defaultWaitTime(2000);
				extent.endTest(logger);
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

	@AfterClass(groups = "UserPortal.SignUp")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
