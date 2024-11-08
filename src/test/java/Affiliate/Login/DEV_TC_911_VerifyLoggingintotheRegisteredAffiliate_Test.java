package Affiliate.Login;

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

public class DEV_TC_911_VerifyLoggingintotheRegisteredAffiliate_Test extends TestBase {
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

	DEV_TC_911_VerifyLoggingintotheRegisteredAffiliate_Main objVerifyAffiliateRegisMain;
	DEV_TC_911_VerifyLoggingintotheRegisteredAffiliate_Test objVerifyAffiliateRegisTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Affiliate.Login")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Affiliate.Login")
	public void verifyRegistrationAffiliate() {
		try {
			action = new Actions(driver);
			objVerifyAffiliateRegisMain = new DEV_TC_911_VerifyLoggingintotheRegisteredAffiliate_Main(driver);
			objVerifyAffiliateRegisTest = new DEV_TC_911_VerifyLoggingintotheRegisteredAffiliate_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyAffiliateRegisTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyAffiliateRegisTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
				utillLogger.info(testStep + " - " + testStatus);
			}

			// Method to close Pop-up Window:
			objTestBase.closePopupWindow();

			testStep = "Verify visibility of Programs dropdown from Homepage Header";
			visibilityStatus = objVerifyAffiliateRegisMain.visibilityOfProgramsDropdown(visibilityStatus);
			objTestBase.defaultWaitTime(500);

			if (visibilityStatus.booleanValue() == true) {
				objVerifyAffiliateRegisMain.clickOnPrograms();
				objTestBase.defaultWaitTime(1000);
				screenshotPath = getScreenshot(driver, "VerifyRideRewards");
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
				utillLogger.info(testStep + " - " + testStatus);
			}

			testStep = "Verify visibility of Affiliate module under Programs dropdown from Homepage Header";
			if (testStatus == "PASSED") {
				String parentWindow = driver.getWindowHandle();
				objTestBase.defaultWaitTime(1000);
				objVerifyAffiliateRegisMain.clickOnAffiliate();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyAffiliateRegisMain.switchToNewTab(visibilityStatus, parentWindow);
				objTestBase.defaultWaitTime(1000);
				testStep = "Verify visibility of Affiliate Navigation from Programs dropdown";
				if (visibilityStatus.booleanValue() == true) {
					visibilityStatus = objVerifyAffiliateRegisMain.verifyAffiliatePage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						screenshotPath = getScreenshot(driver, "VerifyAffiliate");
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
						utillLogger.info(testStep + " - " + testStatus);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
						utillLogger.info(testStep + " - " + testStatus);
					}
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
					utillLogger.info(testStep + " - " + testStatus);
				}
			}

			driver.navigate().refresh();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,6000)", "");

			testStep = "Verify visibility of Affiliate Signup Option";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyAffiliateRegisMain.verifyVisibilityOfSignupBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					objTestBase.defaultWaitTime(3000);
					objVerifyAffiliateRegisMain.clickOnJoinUS();
					objTestBase.defaultWaitTime(2000);

					eMail = objVerifyAffiliateRegisMain.enterAllDetails(eMail);
					objTestBase.defaultWaitTime(2000);

					testStatus = "PASSED";
					utillLogger.info(testStep + " - " + testStatus);

				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				screenshotPath = getScreenshot(driver, "VerifySignup");
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				testStep = "Verify User entered details from Signup page";
				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyAffiliateRegisMain.verifyVisibilityOfSignupCreateBtn(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);

						objVerifyAffiliateRegisMain.clickOnSignupCreateBtn();
						objTestBase.defaultWaitTime(3000);
						testStatus = "PASSED";
						utillLogger.info(testStep + " - " + testStatus);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
						utillLogger.info(testStep + " - " + testStatus);
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
					utillLogger.info(testStep + " - " + testStatus);
				}

				testStep = "Verification of User Signup Confirmation Message.!";
				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyAffiliateRegisMain.visibilityOfSignupConfirmationMsg(visibilityStatus);

					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
						utillLogger.info(testStep + " - " + testStatus);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
						utillLogger.info(testStep + " - " + testStatus);
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
					utillLogger.info(testStep + " - " + testStatus);
				}
			}

			if (eMail != null) {
				driver.get(prop.getProperty("yopmailURL"));
				driver.manage().window().maximize();
				driver.navigate().refresh();
				objTestBase.closePopupWindow();

				objVerifyAffiliateRegisMain.clearButton();
				objTestBase.defaultWaitTime(1000);

				eMail = objVerifyAffiliateRegisMain.emailIDSerach(eMail);
				objTestBase.defaultWaitTime(1000);

				System.out.println("Regression Email = " + eMail);
				utillLogger.info(
						objVerifyAffiliateRegisMain.getClass().getSimpleName() + " - Regression Email = " + eMail);

				testStep = "Verify New User Luxy Account - EMail Confirmation";
				visibilityStatus = objVerifyAffiliateRegisMain.verifyyopeMail(visibilityStatus);
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

				objVerifyAffiliateRegisMain.confirmEmailAccount();
				objTestBase.defaultWaitTime(3000);

				visibilityStatus = objVerifyAffiliateRegisMain.verifyConfirmAccountPasswordPage(visibilityStatus);
				objTestBase.defaultWaitTime(1000);

				testStep = "Verify Confirm New User Account Signup";
				if (visibilityStatus.booleanValue() == true) {
					currURL = driver.getCurrentUrl();
					if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
						objTestBase.defaultWaitTime(1000);
						objVerifyAffiliateRegisMain.passwordInput();
						objTestBase.defaultWaitTime(1000);
						objVerifyAffiliateRegisMain.confirmPassword();
						objTestBase.defaultWaitTime(2000);
						objVerifyAffiliateRegisMain.clickOnTermsAndConditionsCheckbox();
						objTestBase.defaultWaitTime(3000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);

						js.executeScript("window.scrollBy(0,200)", "");
						objTestBase.defaultWaitTime(2000);

						testStep = "Verification of Account Activation Confirmation Message Displayed for registered User - "
								+ eMail;
						visibilityStatus = objVerifyAffiliateRegisMain
								.visibilityOfActivateAccountConfirmationMsg(visibilityStatus);
						objTestBase.defaultWaitTime(1000);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

						objTestBase.closePopupWindow();
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verification of Navigating to Affiliate Portal after Clicking on Confirm Account - "
						+ eMail;
				visibilityStatus = objVerifyAffiliateRegisMain.verifyAffiliatePageLoad(visibilityStatus);
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

				testStep = "Verification of Login with the above registered Email account after Account Activated - "
						+ eMail;
				if (visibilityStatus.booleanValue() == true) {
					testStatus = " ";
					objVerifyAffiliateRegisMain.eMailInputAffiliate(eMail);
					objTestBase.defaultWaitTime(1000);
					objVerifyAffiliateRegisMain.passwordInputAffiliate();
					objTestBase.defaultWaitTime(1000);
					objVerifyAffiliateRegisMain.eyeIconClickAffiliate();
					objTestBase.defaultWaitTime(1000);

					visibilityStatus = objVerifyAffiliateRegisMain.visibilityOfSigninButtonAffiliate(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						objVerifyAffiliateRegisMain.clickSigninButtonAffiliate();
						objTestBase.defaultWaitTime(3000);
					} else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

					objVerifyAffiliateRegisMain.clickOnRidesAffiliate();
					objTestBase.defaultWaitTime(3000);
					objVerifyAffiliateRegisMain.clickOnAllTabAffiliate();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of affiliate Portal Login With Valid Credentials";
					visibilityStatus = objVerifyAffiliateRegisMain.visibilityOfLoggedinUserAffiliate(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);

					utillLogger.info(testStep + " - " + testStatus);
				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

				utillLogger.info(testStep + " - " + testStatus);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Affiliate.Login")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyAffiliateRegisTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
