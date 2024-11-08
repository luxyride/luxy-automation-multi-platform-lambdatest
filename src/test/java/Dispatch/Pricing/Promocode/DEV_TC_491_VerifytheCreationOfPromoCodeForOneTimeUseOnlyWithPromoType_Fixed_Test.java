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

public class DEV_TC_491_VerifytheCreationOfPromoCodeForOneTimeUseOnlyWithPromoType_Fixed_Test extends TestBase {

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
	TestBase objTestBase;
	String scenario;

	DEV_TC_491_VerifytheCreationOfPromoCodeForOneTimeUseOnlyWithPromoType_Fixed_Main objVerifyPromocodeFixedtMain;
	DEV_TC_491_VerifytheCreationOfPromoCodeForOneTimeUseOnlyWithPromoType_Fixed_Test objVerifyPromocodeFixedtTest;
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
	public void verifytheCreationOfPromoCodeForMultipleUsesWithPromoType_FIXEDTest() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyPromocodeFixedtMain = new DEV_TC_491_VerifytheCreationOfPromoCodeForOneTimeUseOnlyWithPromoType_Fixed_Main(
					driver);
			objVerifyPromocodeFixedtTest = new DEV_TC_491_VerifytheCreationOfPromoCodeForOneTimeUseOnlyWithPromoType_Fixed_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyPromocodeFixedtTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyPromocodeFixedtTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Dispatch Site Login";
			objVerifyPromocodeFixedtMain.eMailDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.passwordDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.eyeIconDispatchClick();
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			visibilityStatus = objVerifyPromocodeFixedtMain.visibilitydispatchOfSigninButton(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				objVerifyPromocodeFixedtMain.clickdispatchSigninButton();
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.closePopupWindow();
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of Dispatch Site New Booking Page loaded.?";
			visibilityStatus = objVerifyPromocodeFixedtMain.visibilityOfNewBookingPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyPromocodeFixedtMain.dispatchclickPricingSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of navigating to Manage Promocode Page";
			visibilityStatus = objVerifyPromocodeFixedtMain.dispatchvisibilityOfPromocodeTabPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			testStep = "Verification of navigating to ADD Promocode Page";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeFixedtMain.dispatchvisibilityOfAddPromocodePage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			testStep = "Verify the Promo Type is 'FIXED' and 'One Time Use Only' checkbox is selected by default.?";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeFixedtMain
						.dispatchVerifyPromoTypeAndOneTimeUseOnlyStatus(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			testStep = "Verify adding Promocode by giving all required details for Promo Type = FIXED";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeFixedtMain.dispatchEnterAllReqDetailsPromoFixed(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(1000);
			testStep = "Verify Creation of Promocode for Promo Type = FIXED";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodeFixedtMain
						.dispatchVerifyCreationOfPromocodeFixed(visibilityStatus);
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			testStep = "Verify the Ride Booking with Created Promo code";
			if (testStatus == "PASSED") {
				// Verify the Ride Booking with Created Promo code:
				testStatus = verifyRideBookingWithSedan(testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verify deletion of created Promocode for Promo Type = FIXED";
			if (testStatus == "PASSED") {
				driver.get(prop.getProperty("dispatchURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(3000);

				objVerifyPromocodeFixedtMain.dispatchclickPricingSection();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyPromocodeFixedtMain.dispatchDeletionOfPromocode(visibilityStatus);
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
		}
	}

	public String verifyRideBookingWithSedan(String testStatus) throws Exception {
		try {
			action = new Actions(driver);
			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.closePopupWindow();

			testStep = "Verification user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				objVerifyPromocodeFixedtMain.clickLogin();
				objTestBase.defaultWaitTime(2000);
				objVerifyPromocodeFixedtMain.eMailInput();
				objVerifyPromocodeFixedtMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyPromocodeFixedtMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyPromocodeFixedtMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					objVerifyPromocodeFixedtMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyPromocodeFixedtMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of User Portal Login";
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

			testStep = "Verification user login";
			scenario = "Book Sedan";
			testStatus = vechileBooking(scenario, testStatus);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	public String vechileBooking(String scenario, String testStatus) throws Exception {
		try {
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.clickOngetQuote();
			objTestBase.defaultWaitTime(2000);
			visibilityStatus = objVerifyPromocodeFixedtMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyPromocodeFixedtMain.visibilityOfListofVechiles(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
				testStatus = continueBookingFlow(scenario, testStatus);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	public String continueBookingFlow(String scenario, String testStatus) {
		try {
			objVerifyPromocodeFixedtMain.clickOnSedan();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify " + scenario + " Vehicle Confirmation Popup Displayed.?";
			visibilityStatus = objVerifyPromocodeFixedtMain.verifyVehicleConfirmationPopup(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				objVerifyPromocodeFixedtMain.clickonConfirmPopup();
				objTestBase.defaultWaitTime(5000);
			}

			testStep = "Verify " + scenario + " Page Navigation";
			visibilityStatus = objVerifyPromocodeFixedtMain.verifyRideDetailsPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
			objVerifyPromocodeFixedtMain.clickOnSecondaryPassenger();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.enterPassengerNotes();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodeFixedtMain.promoCodeEnable();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.enterPromocode();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodeFixedtMain.clickonPromocodeApply();
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyPromocodeFixedtMain.verifyVisibilityOfPaymentInfo(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objVerifyPromocodeFixedtMain.enablePaymentInfo();
				objTestBase.defaultWaitTime(2000);
			} else {
				clickOnCardOption();
				objTestBase.defaultWaitTime(3000);
				objVerifyPromocodeFixedtMain.enterPaymentInformation();
				objTestBase.defaultWaitTime(2000);
			}

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,220)", "");
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyPromocodeFixedtMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyPromocodeFixedtMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(12000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Page";
				visibilityStatus = objVerifyPromocodeFixedtMain.verifyRideBookingConfirmation(visibilityStatus);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)", "");
				objTestBase.defaultWaitTime(2000);

				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();

					objVerifyPromocodeFixedtMain.clickonBookNextRide();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				driver.get(prop.getProperty("portalURL"));
				testStatus = "PASSED";
			}
			objTestBase.defaultWaitTime(2000);
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	@AfterClass(groups = "Dispatch.Pricing.Promocode")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyPromocodeFixedtTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
