package Dispatch.EmailNotifications;

import java.util.Map;
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

public class DEV_TC_1045_VerifySendingPINConfirmationForPrimaryAndSecondaryPassenger_Test extends TestBase {

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
	int vechilesCount = 0;
	String scenario;
	Boolean bookingStatus;
	JavascriptExecutor js;
	String tripID;

	DEV_TC_1045_VerifySendingPINConfirmationForPrimaryAndSecondaryPassenger_Main objVerifySendingPINDispatchMain;
	DEV_TC_1045_VerifySendingPINConfirmationForPrimaryAndSecondaryPassenger_Test objVerifySendingPINDispatchTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.EmailNotifications")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.EmailNotifications")
	public void verificationOfNewBookingFromDispatchSite() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySendingPINDispatchMain = new DEV_TC_1045_VerifySendingPINConfirmationForPrimaryAndSecondaryPassenger_Main(
					driver);
			objVerifySendingPINDispatchTest = new DEV_TC_1045_VerifySendingPINConfirmationForPrimaryAndSecondaryPassenger_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySendingPINDispatchTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySendingPINDispatchTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("yopmailURL"));
			objTestBase.defaultWaitTime(3000);
			driver.manage().window().maximize();
			testStep = "Verify lanching the Yopmail";
			currURL = driver.getCurrentUrl();
			if (currURL.toLowerCase().contains("yopmail")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verifying the Email Notification with PIN validations";
			if (testStatus == "PASSED" && !rideBookingDispatchIds.isEmpty()) {
				for (Map.Entry<String, String> entry : rideBookingDispatchIds.entrySet()) {
					System.out.println(entry.getKey() + " - " + entry.getValue());
					visibilityStatus = objVerifySendingPINDispatchMain.verifyEmailConfirmation(visibilityStatus,
							entry.getKey(), entry.getValue());
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
	}

	@AfterClass(groups = "Dispatch.EmailNotifications")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySendingPINDispatchTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}