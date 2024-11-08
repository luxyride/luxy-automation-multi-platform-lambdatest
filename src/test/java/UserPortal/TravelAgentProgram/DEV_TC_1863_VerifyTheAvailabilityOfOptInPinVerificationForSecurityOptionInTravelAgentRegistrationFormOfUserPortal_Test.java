package UserPortal.TravelAgentProgram;

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

public class DEV_TC_1863_VerifyTheAvailabilityOfOptInPinVerificationForSecurityOptionInTravelAgentRegistrationFormOfUserPortal_Test
		extends TestBase {
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

	DEV_TC_1863_VerifyTheAvailabilityOfOptInPinVerificationForSecurityOptionInTravelAgentRegistrationFormOfUserPortal_Main objVerifyRegisCorpMain;
	DEV_TC_1863_VerifyTheAvailabilityOfOptInPinVerificationForSecurityOptionInTravelAgentRegistrationFormOfUserPortal_Test objVerifyRegisCorpTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "UserPortal.TravelAgentProgram")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "UserPortal.TravelAgentProgram")
	public void verifyRegistrationCorporate() {
		try {
			action = new Actions(driver);
			objVerifyRegisCorpMain = new DEV_TC_1863_VerifyTheAvailabilityOfOptInPinVerificationForSecurityOptionInTravelAgentRegistrationFormOfUserPortal_Main(
					driver);
			objVerifyRegisCorpTest = new DEV_TC_1863_VerifyTheAvailabilityOfOptInPinVerificationForSecurityOptionInTravelAgentRegistrationFormOfUserPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyRegisCorpTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyRegisCorpTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verify visibility of travel Agent  from Homepage Header";
			visibilityStatus = objVerifyRegisCorpMain.visibilityOfTaTransport(visibilityStatus);
			objTestBase.defaultWaitTime(500);

			if (visibilityStatus.booleanValue() == true) {
				objVerifyRegisCorpMain.clickOnTa();
				objTestBase.defaultWaitTime(1000);
				screenshotPath = getScreenshot(driver, "VerifyRideRewards");
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verify visibility of travel Agent module  from Homepage Header";
			if (testStatus == "PASSED") {
				String parentWindow = driver.getWindowHandle();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = objVerifyRegisCorpMain.switchToNewTab(visibilityStatus, parentWindow);
				objTestBase.defaultWaitTime(1000);
				testStep = "Verify visibility of Corporate Navigation from Programs dropdown";
				
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)", "");
				objTestBase.defaultWaitTime(2000);
				
				if (visibilityStatus.booleanValue() == true) {
					visibilityStatus = objVerifyRegisCorpMain.verifyTaPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						screenshotPath = getScreenshot(driver, "VerifyCorporate");
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						else
							browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}
			utillLogger.info(testStep + " - " + testStatus);

			objVerifyRegisCorpMain.clickOnEnrollTaBtn();
			objTestBase.defaultWaitTime(3000);
			
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			objTestBase.defaultWaitTime(2000);
			
			testStep = "Verify visibility of OPt In Verification Option in travel Agent registration Page";
			if (visibilityStatus.booleanValue() == true) {
				visibilityStatus = objVerifyRegisCorpMain.verifyVisibilityOfTaRegistrationForm(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					screenshotPath = getScreenshot(driver, "VerifyCorporate");
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
		
			utillLogger.info(testStep + " - " + testStatus);

		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "UserPortal.TravelAgentProgram")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyRegisCorpTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
