package Concierge.Cancelled;

import java.util.Map;
import common.TestBase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1247_VerifyCancelRideByConcierge_Test extends TestBase {

	String currURL;
	String screenshotPath;
	Actions action;
	String testStep;
	String testStatus;
	String scenario;
	WebElement element;
	Boolean visibilityStatus;
	String exception = "";
	JavascriptExecutor js;

	DEV_TC_1247_VerifyCancelRideByConcierge_Main objVerifyCancelRides_Main;
	DEV_TC_1247_VerifyCancelRideByConcierge_Test objVerifyCancelRides_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.Cancelled")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
			// Removes the Duplicate Trip IDs from rideBookingIdsConcierge HashMap
			final Iterator<Entry<String, String>> iter = rideBookingIdsConcierge.entrySet().iterator();
			final HashSet<String> valueSet = new HashSet<String>();
			while (iter.hasNext()) {
				final Entry<String, String> next = iter.next();
				if (!valueSet.add(next.getValue())) {
					iter.remove();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.Cancelled")
	public void verifyDisplayingreasonsForCancellationRidesInCancellationDropdown() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyCancelRides_Main = new DEV_TC_1247_VerifyCancelRideByConcierge_Main(driver);
			objVerifyCancelRides_Test = new DEV_TC_1247_VerifyCancelRideByConcierge_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyCancelRides_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyCancelRides_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify Concierge Portal Launch Homepage";
			currURL = driver.getCurrentUrl();
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyCancelRides_Main.eMailInput();
				objVerifyCancelRides_Main.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyCancelRides_Main.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyCancelRides_Main.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyCancelRides_Main.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyCancelRides_Main.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyCancelRides_Main.visibilityOfLoggedinUser(visibilityStatus);
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

			objVerifyCancelRides_Main.clickRidesSection();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyCancelRides_Main.visibilityOfRidesAllPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (!rideBookingIdsConcierge.isEmpty()) {
				for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
					testStep = "Verification of Rides All Page loaded.?";
					System.out.println(entry.getKey() + " - " + entry.getValue());
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(6000);
					objVerifyCancelRides_Main.searchRideId(entry.getValue());
					objTestBase.defaultWaitTime(6000);

					// Validate the TripID Details:
					testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for "
							+ entry.getKey().toUpperCase() + " - Trip ID: " + entry.getValue() + " - Before Update";
					visibilityStatus = objVerifyCancelRides_Main.validateTripIDDetails(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					}

					testStep = "Validate Cancel Ride for " + entry.getKey().toUpperCase() + " - Trip ID: "
							+ entry.getValue();
					if (visibilityStatus.booleanValue() == true) {
						objVerifyCancelRides_Main.clickOnCancelRide();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Cancelling Ride Booking for " + entry.getKey().toUpperCase()
								+ " - Trip ID: " + entry.getValue();
						visibilityStatus = objVerifyCancelRides_Main
								.visibilityOfReviewCancleRidepopup(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						testStep = "Verification of Visibility Of Cancel Ride Booking Confirmation Popup "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + entry.getValue();
						objTestBase.defaultWaitTime(2000);
						if (testStatus == "PASSED") {
							visibilityStatus = objVerifyCancelRides_Main
									.visibilityOfConfirmCancleRidepopup(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
						}

						testStep = "Verification of Cancelling Ride Booking Confirmation Message "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + entry.getValue();
						if (testStatus == "PASSED") {
							visibilityStatus = objVerifyCancelRides_Main
									.visibilityOfCancelRideConfirmationMsg(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
						}

						testStep = "Verify status for Trip ID after Cancellation Successful - "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + entry.getValue();
						if (testStatus == "PASSED") {
							driver.navigate().refresh();
							objTestBase.defaultWaitTime(8000);
							visibilityStatus = objVerifyCancelRides_Main
									.visibilityOfNoRidesFoundWithCancelledID(visibilityStatus, entry.getValue());
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
						}
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(2000);
						objVerifyCancelRides_Main.clickRidesSection();
						objTestBase.defaultWaitTime(3000);
						visibilityStatus = objVerifyCancelRides_Main.visibilityOfRidesAllPage(visibilityStatus);
						utillLogger.info(testStep + " - " + testStatus);
					}
				}
			} else {
				testStep = "Cancel Rides Skipped due to EMPTY Rides Captured from DEV_TC_1020_VerificationOfNewBookingFromDispatchSite";
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
			}
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			objVerifyCancelRides_Main.clickRidesSection();
			objTestBase.defaultWaitTime(3000);
			visibilityStatus = objVerifyCancelRides_Main.visibilityOfRidesAllPage(visibilityStatus);
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	@AfterClass(groups = "Concierge.Cancelled")
	public void afterClass() {
		driver.quit();
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
			System.out.println(
					"Cancelled Ride IDs from TC: DEV_TC_1247_VerifyCancelRideByConcierge = " + "Total TripIDs = "
							+ rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - " + entry.getValue());

			utillLogger
					.info("Cancelled Ride IDs from TC: DEV_TC_1247_VerifyCancelRideByConcierge = " + "Total TripIDs = "
							+ rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - " + entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyCancelRides_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}