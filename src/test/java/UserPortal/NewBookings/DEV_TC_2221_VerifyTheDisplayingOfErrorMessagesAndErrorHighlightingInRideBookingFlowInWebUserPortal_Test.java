package UserPortal.NewBookings;

import java.util.Map;
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

public class DEV_TC_2221_VerifyTheDisplayingOfErrorMessagesAndErrorHighlightingInRideBookingFlowInWebUserPortal_Test
		extends TestBase {

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

	DEV_TC_2221_VerifyTheDisplayingOfErrorMessagesAndErrorHighlightingInRideBookingFlowInWebUserPortal_Main objVerifyNewBookingMain;
	DEV_TC_2221_VerifyTheDisplayingOfErrorMessagesAndErrorHighlightingInRideBookingFlowInWebUserPortal_Test objVerifyNewBookingTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "UserPortal.NewBookings")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "UserPortal.NewBookings")
	public void ActivationOfNewUserAfterRegistration() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyNewBookingMain = new DEV_TC_2221_VerifyTheDisplayingOfErrorMessagesAndErrorHighlightingInRideBookingFlowInWebUserPortal_Main(
					driver);
			objVerifyNewBookingTest = new DEV_TC_2221_VerifyTheDisplayingOfErrorMessagesAndErrorHighlightingInRideBookingFlowInWebUserPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyNewBookingTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyNewBookingTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);
			objTestBase.closeCookiesPopupWindow();
			objTestBase.defaultWaitTime(2000);
			
			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
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

			// Method to close Pop-up Window:
			objTestBase.closePopupWindow();
//			// Configuration for handing mobile simulator testing:
//			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
//					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
//					|| browserType.equalsIgnoreCase("chromeLocal")) {
//				clickOn3HorizontalToggleNavigationBar();
//			}

			testStep = "Verify visibility of SIGN IN option from User Portal Landing Page";
			if (testStatus == "PASSED") {
				testStatus = " ";
				visibilityStatus = objVerifyNewBookingMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
			}

			testStep = "Verification customer user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(3000);
//				// Configuration for handing mobile simulator testing:
//				if (!browserType.equalsIgnoreCase("chromeAndroidMobileView")
//						&& !browserType.equalsIgnoreCase("chromeiOSMobileView")
//						&& !browserType.equalsIgnoreCase("chromeLocal")) {

				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingMain.clickSignIn();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verify customer log-in opion under sign in dropdown ";
				visibilityStatus = objVerifyNewBookingMain.visibilityOfDropDown(visibilityStatus);
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

			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.clickOnCustomerLogin();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.eMailInput();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.passwordInput();
			objTestBase.defaultWaitTime(2000);

			visibilityStatus = objVerifyNewBookingMain.visibilityOfLoginAndContinueBtn(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				objVerifyNewBookingMain.clickSigninButton();
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
			}

			objTestBase.defaultWaitTime(6000);
			visibilityStatus = objVerifyNewBookingMain.visibilityOfLoggedinUser(visibilityStatus);
			testStep = "Verification of User Portal Login";
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

			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.clickOngetQuote();
			objTestBase.defaultWaitTime(2000);

			testStep = "verify Error messages displaying under fileds ";
			visibilityStatus = objVerifyNewBookingMain.visibilityOfErrorMessages(visibilityStatus);
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

			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.clickOngetQuote();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyNewBookingMain.visibilityOfVechileSection(visibilityStatus);
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
			
			testStep = "Verify Ride Details Page";
			visibilityStatus = objVerifyNewBookingMain.verifyRideDetailsPage(visibilityStatus);
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
		
			objTestBase.defaultWaitTime(2000);
			
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(1000);
			
			objVerifyNewBookingMain.enablePaymentInfo();
			objTestBase.defaultWaitTime(2000);
			
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-500)", "");
			objTestBase.defaultWaitTime(1000);
			
			testStep = "Verify Error MEssages under Primary fields";
			visibilityStatus = objVerifyNewBookingMain.verifyErrorMsgsUnderPrimaryFields(visibilityStatus);
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
			
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.clickOnArrivalMeetAndGreet();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(1000);
			
			objVerifyNewBookingMain.enablePaymentInfo();
			objTestBase.defaultWaitTime(2000);
			
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-200)", "");
			objTestBase.defaultWaitTime(1000);
			
			testStep = "Verify Error Messages under Passenger Name in Arrival meet and greet fields";
			visibilityStatus = objVerifyNewBookingMain.verifyErrorMsgsUnderPassengerName(visibilityStatus);
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
		} catch (

		Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
	}

	@AfterClass(groups = "UserPortal.NewBookings")
	public void afterClass() {
		driver.quit();
		// Print the Captured the Ride Booking ids - captured from
		// DEV_TC_1092_VerifyCustomerLoginOptionOnWebUserPortal_Test Test Case:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIds.entrySet()) {
			System.out.println("Booking IDs from TC: DEV_TC_1092_VerifyCustomerLoginOptionOnWebUserPortal_Test = "
					+ "Total TripIDs = " + rideBookingIds.size() + " - " + entry.getKey() + " - " + entry.getValue());
			utillLogger.info("Booking IDs from TC: DEV_TC_1092_VerifyCustomerLoginOptionOnWebUserPortal_Test = "
					+ "Total TripIDs = " + rideBookingIds.size() + entry.getKey() + " - " + entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyNewBookingTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}