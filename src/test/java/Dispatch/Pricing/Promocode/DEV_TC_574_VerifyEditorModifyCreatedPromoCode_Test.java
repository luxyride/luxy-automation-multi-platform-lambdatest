package Dispatch.Pricing.Promocode;

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

public class DEV_TC_574_VerifyEditorModifyCreatedPromoCode_Test extends TestBase {
	String currURL;
	String screenshotPath;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	WebElement element;
	Actions action;
	String exception = "";
	TestBase objTestBase;
	String scenario;
	Boolean visibilityStatus;

	DEV_TC_574_VerifyEditorModifyCreatedPromoCode_Main objVerifyPromocodeEditMain;
	DEV_TC_574_VerifyEditorModifyCreatedPromoCode_Test objVerifyPromocodeEditTest;
	UpdateExtentReportResults objupdateResults;

	@BeforeClass(groups = "Dispatch.Pricing.Promocode")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.Pricing.Promocode")
	public void verifytheCreationOfPromoCodeForMultipleUsesWithPromoType_FixedTest() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyPromocodeEditMain = new DEV_TC_574_VerifyEditorModifyCreatedPromoCode_Main(driver);
			objVerifyPromocodeEditTest = new DEV_TC_574_VerifyEditorModifyCreatedPromoCode_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyPromocodeEditTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyPromocodeEditTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Dispatch Site Login";
			objVerifyPromocodeEditMain.eMailDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeEditMain.passwordDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeEditMain.eyeIconDispatchClick();
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			visibilityStatus = objVerifyPromocodeEditMain.visibilitydispatchOfSigninButton(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objVerifyPromocodeEditMain.clickdispatchSigninButton();
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.closePopupWindow();
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of Dispatch Site New Booking Page loaded.?";
			visibilityStatus = objVerifyPromocodeEditMain.visibilityOfNewBookingPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyPromocodeEditMain.dispatchclickPricingSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of navigating to Manage Promocode Page";
			visibilityStatus = objVerifyPromocodeEditMain.dispatchvisibilityOfPromocodeTabPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			testStep = "Verification of navigating to ADD Promocode Page";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeEditMain.dispatchvisibilityOfAddPromocodePage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			testStep = "Deselect the Promo code - 'One time use only' Checkbox ";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeEditMain.dispatchDeselectPromocodeAndSelectFixed(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			testStep = "Verify adding Promocode by giving all required details for Promo Type = Fixed";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeEditMain.dispatchEnterAllReqDetailsPromoFixed(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(1000);
			testStep = "Verify Creation of Promocode for Promo Type = Fixed";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeEditMain.dispatchVerifyCreationOfPromocodeFixed(visibilityStatus);
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);

			testStep = "Verify Edition of created Promocode for Promo Type = Fixed";
			if (testStatus == "PASSED") {

				driver.get(prop.getProperty("dispatchURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(3000);

				objVerifyPromocodeEditMain.dispatchclickPricingSection();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of navigating to Manage Promocode Page";
				visibilityStatus = objVerifyPromocodeEditMain.dispatchvisibilityOfPromocodeTabPage1(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verify Edition of created Promocode for Promo Type = Fixed";
				visibilityStatus = objVerifyPromocodeEditMain.dispatchEditionOfPromocode(visibilityStatus);
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
		}
	}

	@AfterClass(groups = "Dispatch.Pricing.Promocode")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyPromocodeEditTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
