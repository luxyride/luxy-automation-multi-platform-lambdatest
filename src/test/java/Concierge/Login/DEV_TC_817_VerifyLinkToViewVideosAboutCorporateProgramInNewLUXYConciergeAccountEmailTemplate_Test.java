package Concierge.Login;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

@Test
public class DEV_TC_817_VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate_Test
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

	DEV_TC_817_VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate_Main objVerifyLogout_Main;
	DEV_TC_817_VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate_Test objVerifyLogout_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.Login")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.Login")

	public void VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyLogout_Main = new DEV_TC_817_VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate_Main(
					driver);
			objVerifyLogout_Test = new DEV_TC_817_VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyLogout_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of entered User details from Login page";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.eMailInput();
				objVerifyLogout_Main.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.clickEyeIcon();

				visibilityStatus = objVerifyLogout_Main.visibilityOfsigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Concierge Portal Login";
				if (testStatus == "PASSED") {
					objTestBase.defaultWaitTime(2000);
					objVerifyLogout_Main.clickSignInButton();
					objTestBase.defaultWaitTime(3000);
					visibilityStatus = objVerifyLogout_Main.visibilityOfsigninUser(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}
			}
			testStep = "Visibility of Concierge in menu tab ";
			visibilityStatus = objVerifyLogout_Main.visibilityOfConcierge(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.clickOnConciergeBtn();
			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.clickOnAddConciergeBtn();
			objTestBase.defaultWaitTime(2000);

			testStep = "visibility Of Concierge Registration Page ";
			visibilityStatus = objVerifyLogout_Main.visibilityOfConciergeRegistrationPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of Concierge registration  Page";
			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.enterFirstName();
			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.enterLastName();
			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.enterEmail();
			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.enterMobile();
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyLogout_Main.visibilityOfRegistrationBtn(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyLogout_Main.clickOnRegistrationBtn();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of new concierge registration account";

			visibilityStatus = objVerifyLogout_Main.visibilityOfRegistrationSuccessmessage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			testStep = "Verify EMail Confirmation for CONCIERGE registered user";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyLogout_Main.launchYopmail(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of confirmation Email ";
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = objVerifyLogout_Main.verifyEmailConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of links available in Email ";
				visibilityStatus = objVerifyLogout_Main.verifyClickHereLink(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyLogout_Main.clickOnLink();
				objTestBase.defaultWaitTime(8000);
				driver.switchTo();
				objTestBase.defaultWaitTime(3000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				objTestBase.defaultWaitTime(8000);

				testStep = "Verification of navigating to Concierge Dashboard ";
				visibilityStatus = objVerifyLogout_Main.verifyLinksConciergeDashboardPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			utillLogger.info(testStep + " - " + testStatus);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Concierge.Login")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
