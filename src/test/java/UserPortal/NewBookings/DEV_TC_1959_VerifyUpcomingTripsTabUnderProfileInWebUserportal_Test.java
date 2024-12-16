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

public class DEV_TC_1959_VerifyUpcomingTripsTabUnderProfileInWebUserportal_Test extends TestBase {

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

	DEV_TC_1959_VerifyUpcomingTripsTabUnderProfileInWebUserportal_Main objVerifyNewBookingMain;
	DEV_TC_1959_VerifyUpcomingTripsTabUnderProfileInWebUserportal_Test objVerifyNewBookingTest;
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
			objVerifyNewBookingMain = new DEV_TC_1959_VerifyUpcomingTripsTabUnderProfileInWebUserportal_Main(driver);
			objVerifyNewBookingTest = new DEV_TC_1959_VerifyUpcomingTripsTabUnderProfileInWebUserportal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyNewBookingTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyNewBookingTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

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
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
				|| browserType.equalsIgnoreCase("chromeiOSMobileView")
				|| browserType.equalsIgnoreCase("chromeLocal")) {
					clickOnToggleNavigationBar();
			}

			testStep = "Verification customer user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
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

				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingMain.clickOnCustomerLogin();
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyNewBookingMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyNewBookingMain.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

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
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
	}

	public String vechileBooking(String scenario, String testStatus) throws Exception {
		try {
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.addExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.clickOngetQuote();
			objTestBase.defaultWaitTime(2000);
			visibilityStatus = objVerifyNewBookingMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(1000);
			
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyNewBookingMain.visibilityOfListofVechiles(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
				continueBookingFlow(scenario, testStatus);
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
		return testStatus;
	}

	public void continueBookingFlow(String scenario, String testStatus) {
		try {
			if (scenario == "Book Sedan") {
				objVerifyNewBookingMain.clickOnSedan();
			}
			objTestBase.defaultWaitTime(3000);
			testStep = "Verify " + scenario + " Page Navigation";
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

			utillLogger.info(testStep + " - " + testStatus);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)", "");
			objTestBase.defaultWaitTime(1000);

			objVerifyNewBookingMain.clickOnSecondaryPassenger();
			objTestBase.defaultWaitTime(2000);

			objVerifyNewBookingMain.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			js.executeScript("window.scrollBy(0,100)", "");
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Booking For 'Personal' is selected by default for the scenario " + scenario
					+ " from Ride Booking Details Page";
			visibilityStatus = objVerifyNewBookingMain.verifyBookingForPersonalSelected(visibilityStatus);
			if (visibilityStatus.booleanValue() == true)
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
			else if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)", "");
			objTestBase.defaultWaitTime(1000);

			objVerifyNewBookingMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(1000);
			
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.enablePaymentInfo();
			objTestBase.defaultWaitTime(6000);

			objVerifyNewBookingMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(3000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,220)", "");
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyNewBookingMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
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
				objVerifyNewBookingMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(5000);
				testStep = "Verification of " + scenario + " Ride Booking Confirmation Page";
				visibilityStatus = objVerifyNewBookingMain.verifyRideBookingConfirmation(visibilityStatus);

					if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					// Capture the Ride Booking IDs:
					String[] tempVal = scenario.split(" ");
					tripID = objVerifyNewBookingMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					testStep = "Verification of Capturing the Ride ID for " + tempVal[1] + " - TripID = " + tripID;
					if (!tripID.isEmpty())
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							lambdaTestStatusUpdate("passed", testStep);
					else if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);

					objTestBase.defaultWaitTime(1000);
					objVerifyNewBookingMain.clickonBookNextRide();
					objTestBase.defaultWaitTime(3000);
				} else if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
			} else {
				driver.get(prop.getProperty("portalURL"));
				// Method to close Pop-up Window:
				objTestBase.closePopupWindow();
				// Configuration for handing mobile simulator testing:
				if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocal")) {
						clickOnToggleNavigationBar();
				}
			}

			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.clickWelcomeDropDown();
			objTestBase.defaultWaitTime(3000);
			
			visibilityStatus = objVerifyNewBookingMain.visibilityOfProfileOption(visibilityStatus);
			testStep = "verifi profile option under welcome dropdown";
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
			objVerifyNewBookingMain.clickOnProfileOption();
			objTestBase.defaultWaitTime(3000);
			objVerifyNewBookingMain.clickOnMyRideBookings();
			objTestBase.defaultWaitTime(2000);
			
			visibilityStatus = objVerifyNewBookingMain.visibilityOfMyRideBookingsPage(visibilityStatus);
			testStep = "visibility Of My ride Bookings page";
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
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
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