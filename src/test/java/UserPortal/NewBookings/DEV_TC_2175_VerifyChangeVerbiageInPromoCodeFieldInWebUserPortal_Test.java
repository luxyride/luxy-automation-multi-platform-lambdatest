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

public class DEV_TC_2175_VerifyChangeVerbiageInPromoCodeFieldInWebUserPortal_Test extends TestBase {

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

	DEV_TC_2175_VerifyChangeVerbiageInPromoCodeFieldInWebUserPortal_Main objVerifyNewBookingMain;
	DEV_TC_2175_VerifyChangeVerbiageInPromoCodeFieldInWebUserPortal_Test objVerifyNewBookingTest;
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
			objVerifyNewBookingMain = new DEV_TC_2175_VerifyChangeVerbiageInPromoCodeFieldInWebUserPortal_Main(
					driver);
			objVerifyNewBookingTest = new DEV_TC_2175_VerifyChangeVerbiageInPromoCodeFieldInWebUserPortal_Test();
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

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
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
				|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
					clickOn3HorizontalToggleNavigationBar();
			}
			
			testStep = "Verification customer user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
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
		}
	}

	public String vechileBooking(String scenario, String testStatus) throws Exception {
		try {
			objVerifyNewBookingMain.selectDropdown();
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
			
			objTestBase.defaultWaitTime(1000);

			objVerifyNewBookingMain.enterFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.enterLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifyNewBookingMain.enterMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.enterEmail();
			objTestBase.defaultWaitTime(1000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
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
			js.executeScript("window.scrollBy(0,1300)", "");
			objTestBase.defaultWaitTime(4000);
			

			objTestBase.defaultWaitTime(2000);
			objVerifyNewBookingMain.enablePaymentInfo();
			objTestBase.defaultWaitTime(5000);
			
			testStep = "Verify the veribiage change in promocode field";
			visibilityStatus = objVerifyNewBookingMain.verifyVerbiageChangeInPromoCodeField(visibilityStatus);
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
			objVerifyNewBookingMain.enterPromocode();
			objTestBase.defaultWaitTime(5000);
			objVerifyNewBookingMain.clickOnApply();
			objTestBase.defaultWaitTime(2000);
			
			
			
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)", "");
			objTestBase.defaultWaitTime(1000);
			
			objVerifyNewBookingMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(5000);

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

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-100)", "");
				objTestBase.defaultWaitTime(2000);

				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					driver.navigate().refresh();
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,-200)", "");
					objTestBase.defaultWaitTime(2000);
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
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
						clickOn3HorizontalToggleNavigationBar();
				}
			}

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