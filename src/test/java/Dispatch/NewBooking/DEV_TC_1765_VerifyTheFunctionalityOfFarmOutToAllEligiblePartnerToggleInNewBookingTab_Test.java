package Dispatch.NewBooking;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1765_VerifyTheFunctionalityOfFarmOutToAllEligiblePartnerToggleInNewBookingTab_Test
		extends TestBase {

	String currURL;
	String screenshotPath;
	String expected;
	String userName;
	String testStep;
	String scenario;
	String testStatus;
	WebElement element;
	Actions action;
	Boolean visibilityStatus;
	String exception = "";
	String claimRideHoursBeforeUpdate;

	DEV_TC_1765_VerifyTheFunctionalityOfFarmOutToAllEligiblePartnerToggleInNewBookingTab_Main objVerifySighninMain;
	DEV_TC_1765_VerifyTheFunctionalityOfFarmOutToAllEligiblePartnerToggleInNewBookingTab_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.NewBooking")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.NewBooking")
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1765_VerifyTheFunctionalityOfFarmOutToAllEligiblePartnerToggleInNewBookingTab_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1765_VerifyTheFunctionalityOfFarmOutToAllEligiblePartnerToggleInNewBookingTab_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Dispatch Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				utillLogger.info(testStep + " - " + testStatus);

				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.clickAffiliateTab();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.searchAffiliate();
				objTestBase.defaultWaitTime(3000);
				testStep = "Visibility of Edit Button in Manage affiliate Page";
				visibilityStatus = objVerifySighninMain.visibilityOfEditBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				utillLogger.info(testStep + " - " + testStatus);

				objVerifySighninMain.clickEditBtn();
				objTestBase.defaultWaitTime(3000);

				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);

				testStep = "Visibility of extras with disabled or enabled in affiliate edit Page";
				visibilityStatus = objVerifySighninMain.visibilityOfExtras(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
			}
			utillLogger.info(testStep + " - " + testStatus);

			objVerifySighninMain.clickNewBooking();
			objTestBase.defaultWaitTime(3000);

			scenario = "Book Sedan";
			testStatus = vechileBooking(scenario, testStatus);

			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
	}

	public String vechileBooking(String scenario, String testStatus) throws Exception {
		try {
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifySighninMain.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			objVerifySighninMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifySighninMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			if (scenario == "Book Sedan") {
				objVerifySighninMain.clickOnSedan();
			}

			testStep = "Verify Capturing the Claim Ride Hours Details - Before Update";
			claimRideHoursBeforeUpdate = objVerifySighninMain
					.captureFarmoutPreferencesClaimRideHoursBeforeUpdate(claimRideHoursBeforeUpdate);
			if (claimRideHoursBeforeUpdate != "" || claimRideHoursBeforeUpdate != null) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.searchBookingUserName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.clickcheckbox();
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.clickOnAddSecondaryPassengerDetails();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.clickChildSeatCheckbox();
			objTestBase.defaultWaitTime(3000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.enableFarmoutToggle();
			objTestBase.defaultWaitTime(3000);

			testStep = "visibilit of Farmout Pop up related to Farmout ";
			visibilityStatus = objVerifySighninMain.visibilityOfConfirmPopUp(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.clickOnYesBtn();
			objTestBase.defaultWaitTime(1000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-200)", "");
			objTestBase.defaultWaitTime(2000);

			clickOnCardOption();
			objTestBase.defaultWaitTime(3000);

			objVerifySighninMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifySighninMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifySighninMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickRidesSection();
				objTestBase.defaultWaitTime(6000);
				objVerifySighninMain.clickOnAllTab();
				objTestBase.defaultWaitTime(3000);

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.searchRideId();
				objTestBase.defaultWaitTime(5000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripIDFarmoutScenario = objVerifySighninMain.captureRideBookingIDs(visibilityStatus, scenario,
							tripIDFarmoutScenario);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != "")
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							lambdaTestStatusUpdate("passed", testStep);
					else if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				} else if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);

			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
		return testStatus;
	}

	@AfterClass(groups = "Dispatch.NewBooking")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
