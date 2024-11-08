package Dispatch.Vehicles;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_445_VerifyDeletionOfVehicleRecordInDispatchSite_Test extends TestBase {
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

	DEV_TC_445_VerifyDeletionOfVehicleRecordInDispatchSite_Main objVerifyNavigationsMain;
	DEV_TC_445_VerifyDeletionOfVehicleRecordInDispatchSite_Test objVerifyNavigationsTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.Vehicles")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.Vehicles")
	public void VerifyDeletionOfVehicleRecordInDispatchSite_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyNavigationsMain = new DEV_TC_445_VerifyDeletionOfVehicleRecordInDispatchSite_Main(driver);
			objVerifyNavigationsTest = new DEV_TC_445_VerifyDeletionOfVehicleRecordInDispatchSite_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyNavigationsTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyNavigationsTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Dispatch Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";

				objVerifyNavigationsMain.eMailInput();
				objVerifyNavigationsMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyNavigationsMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyNavigationsMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifyNavigationsMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyNavigationsMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				utillLogger.info(testStep + " - " + testStatus);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Manage Vehicle Page is loaded";
				visibilityStatus = objVerifyNavigationsMain.visibilityOfManagevehicleTabPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyNavigationsMain.clickonVehicleTab();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verification of Manage Vehicle Page is loaded.?";
				visibilityStatus = objVerifyNavigationsMain.verificationOfSearchVehicle(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(2000);
				utillLogger.info(testStep + " - " + testStatus);

				objVerifyNavigationsMain.clickonDeleteBtn();
				objTestBase.defaultWaitTime(1000);

				testStep = "Verify Deletion Of Vehicle Record in Dispatch Site from Manage Vehicle Page";
				visibilityStatus = objVerifyNavigationsMain.clickonYesBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";

				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "VerifyVehicle Record in Dispatch Site from Manage Vehicle Page after Successfully Deleted";
				visibilityStatus = objVerifyNavigationsMain.verifyvehicleRecordAfterDeletion(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";

				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

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

	@AfterClass(groups = "Dispatch.Vehicles")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyNavigationsTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}