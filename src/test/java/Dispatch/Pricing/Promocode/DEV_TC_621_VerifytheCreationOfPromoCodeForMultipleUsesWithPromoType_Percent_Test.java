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

public class DEV_TC_621_VerifytheCreationOfPromoCodeForMultipleUsesWithPromoType_Percent_Test extends TestBase {

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

	DEV_TC_621_VerifytheCreationOfPromoCodeForMultipleUsesWithPromoType_Percent_Main objVerifyPromocodePercentMain;
	DEV_TC_621_VerifytheCreationOfPromoCodeForMultipleUsesWithPromoType_Percent_Test objVerifyPromocodePercentTest;
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
	public void verifytheCreationOfPromoCodeForMultipleUsesWithPromoType_PercentTest() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyPromocodePercentMain = new DEV_TC_621_VerifytheCreationOfPromoCodeForMultipleUsesWithPromoType_Percent_Main(
					driver);
			objVerifyPromocodePercentTest = new DEV_TC_621_VerifytheCreationOfPromoCodeForMultipleUsesWithPromoType_Percent_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyPromocodePercentTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyPromocodePercentTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Dispatch Site Login";
			objVerifyPromocodePercentMain.eMailDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.passwordDispatchInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.eyeIconDispatchClick();
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			visibilityStatus = objVerifyPromocodePercentMain.visibilitydispatchOfSigninButton(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objVerifyPromocodePercentMain.clickdispatchSigninButton();
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.closePopupWindow();
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of Dispatch Site New Booking Page loaded.?";
			visibilityStatus = objVerifyPromocodePercentMain.visibilityOfNewBookingPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyPromocodePercentMain.dispatchclickPricingSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of navigating to Manage Promocode Page";
			visibilityStatus = objVerifyPromocodePercentMain.dispatchvisibilityOfPromocodeTabPage(visibilityStatus);
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
				visibilityStatus = objVerifyPromocodePercentMain.dispatchvisibilityOfAddPromocodePage(visibilityStatus);
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
			testStep = "Deselect the Promo code - 'One time use only' Checkbox and select Promo Type = PERCENT";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodePercentMain
						.dispatchDeselectPromocodeAndSelectPercent(visibilityStatus);
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
			testStep = "Verify adding Promocode by giving all required details for Promo Type = PERCENT";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodePercentMain
						.dispatchEnterAllReqDetailsPromoPercent(visibilityStatus);
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
			testStep = "Verify Creation of Promocode for Promo Type = PERCENT";
			if (testStatus == "PASSED") {
				visibilityStatus = objVerifyPromocodePercentMain
						.dispatchVerifyCreationOfPromocodePercent(visibilityStatus);
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
			testStep = "Verify the Ride Booking with Created Promo code";
			if (testStatus == "PASSED") {
				// Verify the Ride Booking with Created Promo code:
				testStatus = verifyRideBookingWithSedan(testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verify deletion of created Promocode for Promo Type = PERCENT";
			if (testStatus == "PASSED") {
				driver.get(prop.getProperty("dispatchURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(3000);

				objVerifyPromocodePercentMain.dispatchclickPricingSection();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyPromocodePercentMain.dispatchDeletionOfPromocode(visibilityStatus);
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
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			// Method to close Pop-up Window:
			closePopupWindow();	
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
				objVerifyPromocodePercentMain.clickLogin();
				objTestBase.defaultWaitTime(2000);
				objVerifyPromocodePercentMain.eMailInput();
				objVerifyPromocodePercentMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyPromocodePercentMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyPromocodePercentMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyPromocodePercentMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyPromocodePercentMain.visibilityOfLoggedinUser(visibilityStatus);
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
			scenario = "Book Sedan";
			testStatus = vechileBooking(scenario, testStatus);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
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
			objVerifyPromocodePercentMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodePercentMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodePercentMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodePercentMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodePercentMain.clickOngetQuote();
			objTestBase.defaultWaitTime(2000);
			visibilityStatus = objVerifyPromocodePercentMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyPromocodePercentMain.visibilityOfListofVechiles(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
				testStatus = continueBookingFlow(scenario, testStatus);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	public String continueBookingFlow(String scenario, String testStatus) {
		try {
			objVerifyPromocodePercentMain.clickOnSedan();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify " + scenario + " Vehicle Confirmation Popup Displayed.?";
			visibilityStatus = objVerifyPromocodePercentMain.verifyVehicleConfirmationPopup(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objVerifyPromocodePercentMain.clickonConfirmPopup();
				objTestBase.defaultWaitTime(5000);
			}

			testStep = "Verify " + scenario + " Page Navigation";
			visibilityStatus = objVerifyPromocodePercentMain.verifyRideDetailsPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
			objVerifyPromocodePercentMain.clickOnSecondaryPassenger();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodePercentMain.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.enterPassengerNotes();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(1000);
			objVerifyPromocodePercentMain.promoCodeEnable();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodePercentMain.enterPromocode();
			objTestBase.defaultWaitTime(2000);
			objVerifyPromocodePercentMain.clickonPromocodeApply();
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyPromocodePercentMain.verifyVisibilityOfPaymentInfo(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				objVerifyPromocodePercentMain.enablePaymentInfo();
				objTestBase.defaultWaitTime(2000);
			} else {
				clickOnCardOption();
				objTestBase.defaultWaitTime(3000);
				objVerifyPromocodePercentMain.enterPaymentInformation();
				objTestBase.defaultWaitTime(2000);
			}

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,220)", "");
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyPromocodePercentMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyPromocodePercentMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(12000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Page";
				visibilityStatus = objVerifyPromocodePercentMain.verifyRideBookingConfirmation(visibilityStatus);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-100)", "");
				objTestBase.defaultWaitTime(2000);

				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();

					objVerifyPromocodePercentMain.clickonBookNextRide();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				driver.get(prop.getProperty("portalURL"));
				// Method to close Pop-up Window:
				closePopupWindow();	
				// Configuration for handing mobile simulator testing:
				if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
						clickOn3HorizontalToggleNavigationBar();
				}
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
		utillLogger.info("## " + objVerifyPromocodePercentTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
