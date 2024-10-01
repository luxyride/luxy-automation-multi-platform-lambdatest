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

public class DEV_TC_492_VerifytheCreationOfPromoCodeForMultipleUses_Test extends TestBase {
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

	DEV_TC_492_VerifytheCreationOfPromoCodeForMultipleUses_Main objVerifyPromocodeFixedMain;
	DEV_TC_492_VerifytheCreationOfPromoCodeForMultipleUses_Test objVerifyPromocodeFixedTest;
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
			objVerifyPromocodeFixedMain = new DEV_TC_492_VerifytheCreationOfPromoCodeForMultipleUses_Main(driver);
			objVerifyPromocodeFixedTest = new DEV_TC_492_VerifytheCreationOfPromoCodeForMultipleUses_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyPromocodeFixedTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyPromocodeFixedTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Dispatch Site Login";
			objVerifyPromocodeFixedMain.eMailDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedMain.passwordDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedMain.eyeIconDispatchClick();
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			visibilityStatus = objVerifyPromocodeFixedMain.visibilitydispatchOfSigninButton(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objVerifyPromocodeFixedMain.clickdispatchSigninButton();
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.closePopupWindow();
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of Dispatch Site New Booking Page loaded.?";
			visibilityStatus = objVerifyPromocodeFixedMain.visibilityOfNewBookingPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyPromocodeFixedMain.dispatchclickPricingSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of navigating to Manage Promocode Page";
			visibilityStatus = objVerifyPromocodeFixedMain.dispatchvisibilityOfPromocodeTabPage(visibilityStatus);
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
				visibilityStatus = objVerifyPromocodeFixedMain.dispatchvisibilityOfAddPromocodePage(visibilityStatus);
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
			testStep = "Deselect the Promo code - 'One time use only' Checkbox and select Promo Type = Fixed";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeFixedMain
						.dispatchDeselectPromocodeAndSelectFixed(visibilityStatus);
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
				visibilityStatus = objVerifyPromocodeFixedMain.dispatchEnterAllReqDetailsPromoFixed(visibilityStatus);
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
				visibilityStatus = objVerifyPromocodeFixedMain.dispatchVerifyCreationOfPromocodeFixed(visibilityStatus);
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

			testStep = "Verify deletion of created Promocode for Promo Type = Fixed";
			if (testStatus == "PASSED") {
				driver.get(prop.getProperty("dispatchURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(3000);

				objVerifyPromocodeFixedMain.dispatchclickPricingSection();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyPromocodeFixedMain.dispatchDeletionOfPromocode(visibilityStatus);
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
		utillLogger.info("## " + objVerifyPromocodeFixedTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
