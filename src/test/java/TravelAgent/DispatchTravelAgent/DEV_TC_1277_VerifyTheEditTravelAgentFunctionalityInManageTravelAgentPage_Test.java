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

public class DEV_TC_1277_VerifyTheEditTravelAgentFunctionalityInManageTravelAgentPage_Test extends TestBase {

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

	DEV_TC_1277_VerifyTheEditTravelAgentFunctionalityInManageTravelAgentPage_Main objVerifySighninMain;
	DEV_TC_1277_VerifyTheEditTravelAgentFunctionalityInManageTravelAgentPage_Test objVerifySighninTest;
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
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1277_VerifyTheEditTravelAgentFunctionalityInManageTravelAgentPage_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1277_VerifyTheEditTravelAgentFunctionalityInManageTravelAgentPage_Test();
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
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
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

				testStep = "Verification of logged in user";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}

				objVerifySighninMain.clickTravelArranger();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickTravelAgent();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.enterSearchField();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickOnEditBtn();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verify Edit Travel Agent Profile";
				visibilityStatus = objVerifySighninMain.visibilityOfEditTravelAgentProfile(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.enterfirstName();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.enterLastName();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.enterEmail();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.enterMobile();
				objTestBase.defaultWaitTime(3000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
				objTestBase.defaultWaitTime(2000);

				testStep = "Visibility of cancel button after entering all required fields";
				visibilityStatus = objVerifySighninMain.visibilityOfCancelBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.clickOnCancel();
				objTestBase.defaultWaitTime(3000);

				testStep = "Visibility Manage Travel Agent Page ";
				visibilityStatus = objVerifySighninMain.visibilityOfManageTravelAgentPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.enterSearchField();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickOnEditBtn();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verify Edit Travel Agent Profile";
				visibilityStatus = objVerifySighninMain.visibilityOfEditTravelAgentProfile(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.enterfirstName();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.enterLastName();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.enterEmail();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.enterMobile();
				objTestBase.defaultWaitTime(3000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
				objTestBase.defaultWaitTime(2000);

				testStep = "Visibility of confirm button after entering all required fields";
				visibilityStatus = objVerifySighninMain.visibilityOfConfirmBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.clickOnupdateBtn();
				objTestBase.defaultWaitTime(15000);

				testStep = "Verify alert message";
				visibilityStatus = objVerifySighninMain.visibilityOfAlertMessage(visibilityStatus);
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
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.DispatchTravelAgent")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
