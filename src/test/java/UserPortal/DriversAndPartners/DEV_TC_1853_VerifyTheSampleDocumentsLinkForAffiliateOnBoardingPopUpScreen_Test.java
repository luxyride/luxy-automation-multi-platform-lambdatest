package UserPortal.DriversAndPartners;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1853_VerifyTheSampleDocumentsLinkForAffiliateOnBoardingPopUpScreen_Test extends TestBase {
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

	DEV_TC_1853_VerifyTheSampleDocumentsLinkForAffiliateOnBoardingPopUpScreen_Main objVerifyRegisCorpMain;
	DEV_TC_1853_VerifyTheSampleDocumentsLinkForAffiliateOnBoardingPopUpScreen_Test objVerifyRegisCorpTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "UserPortal.DriversAndPartners")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "UserPortal.DriversAndPartners")
	public void verifyRegistrationCorporate() {
		try {
			action = new Actions(driver);
			objVerifyRegisCorpMain = new DEV_TC_1853_VerifyTheSampleDocumentsLinkForAffiliateOnBoardingPopUpScreen_Main(
					driver);
			objVerifyRegisCorpTest = new DEV_TC_1853_VerifyTheSampleDocumentsLinkForAffiliateOnBoardingPopUpScreen_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyRegisCorpTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyRegisCorpTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);
			objTestBase.closeCookiesPopupWindow();


			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("devnew")) {
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

			// Method to close Pop-up Window:
			objTestBase.closePopupWindow();
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				clickOn3HorizontalToggleNavigationBar();
			}

			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {

				testStep = "Verify visibility of Driver & Partners from Homepage Header";
				visibilityStatus = objVerifyRegisCorpMain.visibilityOfDriverPartnersSimulatorView(visibilityStatus);
				objTestBase.defaultWaitTime(500);
				if (visibilityStatus.booleanValue() == true) {
					objVerifyRegisCorpMain.clickOnDriverPartners_Siumlator();
					objTestBase.defaultWaitTime(1000);
					screenshotPath = getScreenshot(driver, "VerifyRideRewards");
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
			} else {
				testStep = "Verify visibility of Affiliate from Homepage Header";
				visibilityStatus = objVerifyRegisCorpMain.visibilityOfAffiliateTransportNormalVeiw(visibilityStatus);
				objTestBase.defaultWaitTime(500);
				if (visibilityStatus.booleanValue() == true) {
					objVerifyRegisCorpMain.clickOnAffiliateNormalView();
					objTestBase.defaultWaitTime(1000);
					screenshotPath = getScreenshot(driver, "VerifyRideRewards");
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
			}
			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verify visibility of  Affiliate module  from Homepage Header";
			if (testStatus == "PASSED") {
				String parentWindow = driver.getWindowHandle();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = objVerifyRegisCorpMain.switchToNewTab(visibilityStatus, parentWindow);
				objTestBase.defaultWaitTime(1000);
				testStep = "Verify visibility of Affiliate Navigation from Programs dropdown";

				js = (JavascriptExecutor) driver;

				objTestBase.defaultWaitTime(2000);

				if (visibilityStatus.booleanValue() == true) {
					visibilityStatus = objVerifyRegisCorpMain.verifyAffiliatePage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						screenshotPath = getScreenshot(driver, "VerifyCorporate");
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
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}
			utillLogger.info(testStep + " - " + testStatus);

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objVerifyRegisCorpMain.clickOnEnrollAffiliateBtn();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verify visibility of Affiliate  registration Page Option";
				if (visibilityStatus.booleanValue() == true) {
					visibilityStatus = objVerifyRegisCorpMain
							.verifyVisibilityOfAffiliateRegistrationForm(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						screenshotPath = getScreenshot(driver, "VerifyCorporate");
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
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);

				js = (JavascriptExecutor) driver;

				objTestBase.defaultWaitTime(2000);

				String parentWindow = driver.getWindowHandle();
				objTestBase.defaultWaitTime(3000);

				objTestBase.defaultWaitTime(1000);
				objVerifyRegisCorpMain.clickOnW9Document();
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = objVerifyRegisCorpMain.switchToNewTab(visibilityStatus, parentWindow);
				objTestBase.defaultWaitTime(1000);
				testStep = "Verify visibility of W9 Document Page";
				visibilityStatus = objVerifyRegisCorpMain.verifyVisibilityOfW9DocumentPage(visibilityStatus);
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
				driver.close();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = objVerifyRegisCorpMain.switchBackToMainWindow(visibilityStatus);

				parentWindow = driver.getWindowHandle();
				objTestBase.defaultWaitTime(3000);

				objVerifyRegisCorpMain.clickOnInsuranceDocument();
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = objVerifyRegisCorpMain.switchToNewTab(visibilityStatus, parentWindow);
				objTestBase.defaultWaitTime(1000);
				testStep = "Verify visibility of Insurance  Page";
				visibilityStatus = objVerifyRegisCorpMain.verifyVisibilityOfInsurancePage(visibilityStatus);
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
				driver.close();

				objTestBase.defaultWaitTime(2000);
				visibilityStatus = objVerifyRegisCorpMain.switchBackToMainWindow(visibilityStatus);

				parentWindow = driver.getWindowHandle();
				objTestBase.defaultWaitTime(2000);
				objVerifyRegisCorpMain.clickOnDirectDeposit();
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = objVerifyRegisCorpMain.switchToNewTab(visibilityStatus, parentWindow);
				objTestBase.defaultWaitTime(1000);
				testStep = "Verify visibility of Direct Deposit Page";
				visibilityStatus = objVerifyRegisCorpMain.verifyVisibilityOfDirectDepositPage(visibilityStatus);
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
				driver.close();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = objVerifyRegisCorpMain.switchBackToMainWindow(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(1000);
			}
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "UserPortal.DriversAndPartners")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyRegisCorpTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
