package UserPortal.NewBookings;

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

public class DEV_TC_1845_VerifyTheAdditionOf10$ForNewRideBookingForLessThanOrMoreThan24hrsFromPickUpTime_Test extends TestBase {

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
	Boolean todaysFlag;
	JavascriptExecutor js;

	DEV_TC_1845_VerifyTheAdditionOf10$ForNewRideBookingForLessThanOrMoreThan24hrsFromPickUpTime_Main objVerifyAdditionMain;
	DEV_TC_1845_VerifyTheAdditionOf10$ForNewRideBookingForLessThanOrMoreThan24hrsFromPickUpTime_Test objVerifyAdditionTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "UserPortal.NewBookings")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "UserPortal.NewBookings")
	public void verifyAdditionOf10$ForNewRideLessorMorethan24hrs_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyAdditionMain = new DEV_TC_1845_VerifyTheAdditionOf10$ForNewRideBookingForLessThanOrMoreThan24hrsFromPickUpTime_Main(driver);
			objVerifyAdditionTest = new DEV_TC_1845_VerifyTheAdditionOf10$ForNewRideBookingForLessThanOrMoreThan24hrsFromPickUpTime_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyAdditionTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyAdditionTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			// Method to close Pop-up Window:
			objTestBase.closePopupWindow();
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
				|| browserType.equalsIgnoreCase("chromeiOSMobileView")
				|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
					clickOn3HorizontalToggleNavigationBar();
			}
			
			testStep = "Verification user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				objVerifyAdditionMain.clickLogin();
				objTestBase.defaultWaitTime(2000);
				objVerifyAdditionMain.eMailInput();
				objVerifyAdditionMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyAdditionMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyAdditionMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyAdditionMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyAdditionMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of User Portal Login";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verification user login";
			testStatus = vechileBooking(testStatus);
			utillLogger.info(testStep + " - " + testStatus);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
	}

	public String vechileBooking(String testStatus) throws Exception {
		try {
			objTestBase.defaultWaitTime(1000);
			objVerifyAdditionMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyAdditionMain.addToAddress();
			objTestBase.defaultWaitTime(3000);

			todaysFlag = true;
			objVerifyAdditionMain.enterDate(todaysFlag);
			objTestBase.defaultWaitTime(2000);
			visibilityStatus = objVerifyAdditionMain.enterTime(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			objVerifyAdditionMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			visibilityStatus = objVerifyAdditionMain.visibilityOfVechileSection();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyAdditionMain.visibilityOfListofVechiles(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			testStep = "Verify price list of all available vechiles - More than 12hrs and Less than 24hrs Scenario";
			visibilityStatus = objVerifyAdditionMain.getvechilesPriceListLessThan24hrs(visibilityStatus);
			objTestBase.defaultWaitTime(3000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			driver.navigate().refresh();
			objTestBase.closePopupWindow();
			js.executeScript("window.scrollBy(0,-350)", "");
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			objVerifyAdditionMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyAdditionMain.addToAddress();
			objTestBase.defaultWaitTime(2000);

			todaysFlag = false;
			objVerifyAdditionMain.enterDate(todaysFlag);
			objTestBase.defaultWaitTime(2000);
			objVerifyAdditionMain.clickOngetQuote();
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyAdditionMain.visibilityOfVechileSection();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify price list of all available vechiles - More than 24hrs Scenario";
			visibilityStatus = objVerifyAdditionMain.getvechilesPriceListMoreThan24hrs(visibilityStatus);
			objTestBase.defaultWaitTime(3000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			testStep = "Verify comparison of Price list of all available vechiles - Less than & More than 24hrs";
			visibilityStatus = objVerifyAdditionMain.verifyVechilesPriceListDifferences(visibilityStatus);
			objTestBase.defaultWaitTime(3000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			testStatus = "PASSED";

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			testStatus = "FALIED";
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
		return testStatus;
	}

	@AfterClass(groups = "UserPortal.NewBookings")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyAdditionTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
