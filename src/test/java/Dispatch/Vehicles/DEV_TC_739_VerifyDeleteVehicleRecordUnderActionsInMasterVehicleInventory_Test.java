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

public class DEV_TC_739_VerifyDeleteVehicleRecordUnderActionsInMasterVehicleInventory_Test extends TestBase {
	String currURL;
	Actions action;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	String screenshotPath;
	String exception = "";
	Boolean visibilityStatus;

	DEV_TC_739_VerifyDeleteVehicleRecordUnderActionsInMasterVehicleInventory_Main objVerifyDeleteVehicleRecordMain;
	DEV_TC_739_VerifyDeleteVehicleRecordUnderActionsInMasterVehicleInventory_Test objVerifyDeleteVehicleRecordTest;
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
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyDeleteVehicleRecordMain = new DEV_TC_739_VerifyDeleteVehicleRecordUnderActionsInMasterVehicleInventory_Main(
					driver);
			objVerifyDeleteVehicleRecordTest = new DEV_TC_739_VerifyDeleteVehicleRecordUnderActionsInMasterVehicleInventory_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyDeleteVehicleRecordTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyDeleteVehicleRecordTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Dispatch Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of Dispatch Portal Loginpage with entered details";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyDeleteVehicleRecordMain.eMailInput();
				objVerifyDeleteVehicleRecordMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyDeleteVehicleRecordMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyDeleteVehicleRecordMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyDeleteVehicleRecordMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyDeleteVehicleRecordMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				utillLogger.info(testStep + " - " + testStatus);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Vehicle Inventory Page loaded.?";
				visibilityStatus = objVerifyDeleteVehicleRecordMain
						.visibilityOfvehicleInventoryTabPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			testStep = "Verify existing Vehicle Inventory is displayed in Manage Master Vehicle Inventory Page.?";
			if (testStatus == "PASSED") {
				testStatus = " ";
				visibilityStatus = objVerifyDeleteVehicleRecordMain
						.verifyManageMasterVehicleInventoryPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				objTestBase.defaultWaitTime(2000);
				utillLogger.info(testStep + " - " + testStatus);

			}

			testStep = "Verify visibility of DELETE Vehicle Inventory confirmation popup - for Clicking on NO Option";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyDeleteVehicleRecordMain.clickondeletebutton();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyDeleteVehicleRecordMain
						.VisibilityofDeleteVehicleInventorypopup(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyDeleteVehicleRecordMain.clickNoButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			testStep = "Verify visibility of DELETE Vehicle Inventory confirmation popup - for Clicking on YES Option";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyDeleteVehicleRecordMain.clickondeletebutton();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyDeleteVehicleRecordMain
						.VisibilityofDeleteVehicleInventorypopup1(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyDeleteVehicleRecordMain.clickYesButton();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

			}

			testStep = "Verify deletion of added new vehicle inventory";
			if (testStatus == "PASSED") {
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = objVerifyDeleteVehicleRecordMain.dispatchDeletionOfnewvehicle(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
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
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Dispatch.Vehicles")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyDeleteVehicleRecordTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
