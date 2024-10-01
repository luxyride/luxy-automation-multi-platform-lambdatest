package Dispatch.Login;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_649_VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage_Test extends TestBase {

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

	DEV_TC_649_VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage_Main objVerifyLogout_Main;
	DEV_TC_649_VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage_Test objVerifyLogout_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.Login")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.Login")
	public void VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyLogout_Main = new DEV_TC_649_VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage_Main(
					driver);
			objVerifyLogout_Test = new DEV_TC_649_VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyLogout_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
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

				testStep = "Verification of Dispatch Portal Login - Before Refresh the page";
				if (testStatus == "PASSED") {
					objTestBase.defaultWaitTime(2000);
					objVerifyLogout_Main.clickSignInButton();
					objTestBase.defaultWaitTime(8000);
					visibilityStatus = objVerifyLogout_Main.visibilityOfsigninUser(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

				} else {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					testStatus = "SKIPPED";
				}

				// ---------------------------------------------------------
				// Validation:
				// DEV-TC-648_Verify user logging out automatically when he reloads the page
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(4000);
				testStep = "Verification of Dispatch Portal Login - After Refresh the page";

				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyLogout_Main.visibilityOfsigninUser(visibilityStatus);
					objTestBase.defaultWaitTime(3000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Dispatch.Login")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
