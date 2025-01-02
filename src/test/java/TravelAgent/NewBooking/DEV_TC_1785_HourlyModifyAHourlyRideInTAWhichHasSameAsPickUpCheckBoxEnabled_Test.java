package TravelAgent.NewBooking;

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

public class DEV_TC_1785_HourlyModifyAHourlyRideInTAWhichHasSameAsPickUpCheckBoxEnabled_Test extends TestBase {
	String tripID;
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

	DEV_TC_1785_HourlyModifyAHourlyRideInTAWhichHasSameAsPickUpCheckBoxEnabled_Main objVerifyEditDetails_Main;
	DEV_TC_1785_HourlyModifyAHourlyRideInTAWhichHasSameAsPickUpCheckBoxEnabled_Test objVerifyEditDetails_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.NewBooking")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.NewBooking")
	public void verificationOfRideEditDetailsFromDispatchSite() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyEditDetails_Main = new DEV_TC_1785_HourlyModifyAHourlyRideInTAWhichHasSameAsPickUpCheckBoxEnabled_Main(
					driver);
			objVerifyEditDetails_Test = new DEV_TC_1785_HourlyModifyAHourlyRideInTAWhichHasSameAsPickUpCheckBoxEnabled_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyEditDetails_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("travelAgentURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify Dispatch Portal Launch Homepage";
			currURL = driver.getCurrentUrl();
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

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyEditDetails_Main.eMailInput();
				objVerifyEditDetails_Main.passwordInput();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyEditDetails_Main.clickSigninButton();
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
				objVerifyEditDetails_Main.clickNewBooking();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfLoggedinUser(visibilityStatus);
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

			if (!travelAgenthourlyRideTripID.isEmpty()) {
				objVerifyEditDetails_Main.clickNewBooking();
				objTestBase.defaultWaitTime(2000);
				objVerifyEditDetails_Main.clickRidesSection();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Rides All Page loaded for " + travelAgenthourlyRideTripID + " - Trip ID: "
						+ tripID + " - Before Update";
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
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

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				tripID = travelAgenthourlyRideTripID;
				objVerifyEditDetails_Main.searchRideId(tripID);
				objTestBase.defaultWaitTime(5000);

				// Validate the TripID Details:
				testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for " + travelAgenthourlyRideTripID
						+ " - Trip ID: " + tripID + " - Before Update";
				visibilityStatus = objVerifyEditDetails_Main.validateTripIDDetails(visibilityStatus);
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

				testStep = "Validate EDIT Ride for " + travelAgenthourlyRideTripID + " - Trip ID: " + tripID;
				if (visibilityStatus.booleanValue() == true) {
					objVerifyEditDetails_Main.editRideDetails();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Edit Ride Booking for " + travelAgenthourlyRideTripID + " - Trip ID: "
							+ tripID + " - Before Update";
					visibilityStatus = objVerifyEditDetails_Main.verifyEDITRideDetailsPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						testStatus = "PASSED";
					} else {
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						testStatus = "FAILED";
					}
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.enterDate();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.clickOngetQuote();
						objTestBase.defaultWaitTime(3000);
						objVerifyEditDetails_Main.clickOnSedan();
						objTestBase.defaultWaitTime(1000);

						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,1900)", "");
						objTestBase.defaultWaitTime(2000);
					}

					visibilityStatus = objVerifyEditDetails_Main.visibilityOfUpdateRideBtn(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						testStep = "Verify visibility of Update Ride Button";
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						objTestBase.defaultWaitTime(1000);
						// Prod Restriction:
						if (!environmentCode.equalsIgnoreCase("prod")) {
							objTestBase.defaultWaitTime(1000);
							objVerifyEditDetails_Main.clickonUpdateRideBtn();
							testStep = "Verification of " + travelAgenthourlyRideTripID
									+ " Ride Update Booking Confirmation Message";
							visibilityStatus = objVerifyEditDetails_Main
									.verifyRideBookingConfirmation(visibilityStatus);
							objTestBase.defaultWaitTime(2000);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								objTestBase.defaultWaitTime(1000);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
						}
					} else {
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,-100)", "");
						objTestBase.defaultWaitTime(2000);

						clickOnCardOption();
						objTestBase.defaultWaitTime(2000);
						
						objVerifyEditDetails_Main.enterPaymentInformation();
						objTestBase.defaultWaitTime(2000);

						utillLogger.info(testStep + " - " + testStatus);
						testStep = "Verification of " + travelAgenthourlyRideTripID
								+ " Ride Booking Payment Update";
						visibilityStatus = objVerifyEditDetails_Main.visibilitofUpdatePaymentBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						} else {
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						}

						// Prod Restriction:
						if (!environmentCode.equalsIgnoreCase("prod")) {
							objTestBase.defaultWaitTime(1000);
							objVerifyEditDetails_Main.clickonPaynowBtn();
							testStep = "Verification of " + travelAgenthourlyRideTripID
									+ " Ride Update Booking Confirmation Message";
							visibilityStatus = objVerifyEditDetails_Main
									.verifyRideBookingConfirmation(visibilityStatus);
							objTestBase.defaultWaitTime(2000);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								objTestBase.defaultWaitTime(1000);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
						}
					}

					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,-3000)", "");
					objTestBase.defaultWaitTime(1000);

					if (tripID != null) {
						// Capture the Updated Ride Booking details based on IDs:
						tripID = objVerifyEditDetails_Main.captureRideBookingIDs(visibilityStatus, scenario, tripID);
						testStep = "Verification of Capturing the Updated Ride ID for " + scenario + " - Trip ID = "
								+ tripID;
						if (tripID != "")
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);

						objVerifyEditDetails_Main.editRideDetails();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verificatin of Edit Ride Booking for " + travelAgenthourlyRideTripID
								+ " - Trip ID: " + tripID + " - After Update";
						visibilityStatus = objVerifyEditDetails_Main.verifyEDITRideDetailsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
							testStatus = "PASSED";
						} else {
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
							testStatus = "FAILED";
						}
					}
				}

				testStatus = "PASSED";
			} else {
				testStep = "EDIT Rides Skipped due to EMPTY Rides Captured from DEV_TC_1249_VerifyEDITRideRunctionalityFromConciergePortal_Test";
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
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
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	@AfterClass(groups = "TravelAgent.NewBooking")
	public void afterClass() {
		driver.quit();
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
