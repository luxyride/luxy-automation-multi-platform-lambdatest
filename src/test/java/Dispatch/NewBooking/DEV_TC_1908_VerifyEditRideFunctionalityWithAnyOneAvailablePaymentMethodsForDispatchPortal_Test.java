package Dispatch.NewBooking;

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

public class DEV_TC_1908_VerifyEditRideFunctionalityWithAnyOneAvailablePaymentMethodsForDispatchPortal_Test
		extends TestBase {
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

	DEV_TC_1908_VerifyEditRideFunctionalityWithAnyOneAvailablePaymentMethodsForDispatchPortal_Main objVerifyEditDetails_Main;
	DEV_TC_1908_VerifyEditRideFunctionalityWithAnyOneAvailablePaymentMethodsForDispatchPortal_Test objVerifyEditDetails_Test;
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
	public void verificationOfRideEditDetailsFromDispatchSite() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyEditDetails_Main = new DEV_TC_1908_VerifyEditRideFunctionalityWithAnyOneAvailablePaymentMethodsForDispatchPortal_Main(
					driver);
			objVerifyEditDetails_Test = new DEV_TC_1908_VerifyEditRideFunctionalityWithAnyOneAvailablePaymentMethodsForDispatchPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyEditDetails_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify Dispatch Portal Launch Homepage";
			currURL = driver.getCurrentUrl();
			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))
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
				objTestBase.defaultWaitTime(1000);
				objVerifyEditDetails_Main.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyEditDetails_Main.eyeIconClick();
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

			objVerifyEditDetails_Main.clickRidesSection();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Rides All Page loaded.?";
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

			if (!rideBookingDispatchIds.isEmpty()) {
				for (Map.Entry<String, String> entry : rideBookingDispatchIds.entrySet()) {
					if (!entry.getKey().toLowerCase().contains("temp")) {
						objVerifyEditDetails_Main.clickNewBooking();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.clickRidesSection();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Rides All Page loaded for " + entry.getKey().toUpperCase()
								+ " - Trip ID: " + tripID + " - Before Update";
						visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);
						tripID = entry.getValue();
						scenario = entry.getKey();
						objVerifyEditDetails_Main.searchRideId(tripID);
						objTestBase.defaultWaitTime(5000);

						// Validate the TripID Details:
						testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + tripID + " - Before Update";
						visibilityStatus = objVerifyEditDetails_Main.validateTripIDDetails(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								lambdaTestStatusUpdate("passed", testStep);
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								lambdaTestStatusUpdate("failed", testStep);
						}

						testStep = "Validate EDIT Ride for " + entry.getKey().toUpperCase() + " - Trip ID: " + tripID;
						if (visibilityStatus.booleanValue() == true) {
							objVerifyEditDetails_Main.editRideDetails();
							objTestBase.defaultWaitTime(3000);

							testStep = "Verification of Edit Ride Booking for " + entry.getKey().toUpperCase()
									+ " - Trip ID: " + tripID + " - Before Update";
							visibilityStatus = objVerifyEditDetails_Main.verifyEDITRideDetailsPage(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
							objTestBase.defaultWaitTime(2000);
							js = (JavascriptExecutor) driver;
							
							objTestBase.defaultWaitTime(2000);

							objVerifyEditDetails_Main.selectTravelWithPet();
							objTestBase.defaultWaitTime(3000);

							js = (JavascriptExecutor) driver;
							
							objTestBase.defaultWaitTime(2000);

							testStep = "Verification of Visibility of Card Options In NewBooking Page";
							visibilityStatus = objVerifyEditDetails_Main.visibilityOfPaymentOptions(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									lambdaTestStatusUpdate("passed", testStep);
								testStatus = "PASSED";
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								else
									lambdaTestStatusUpdate("failed", testStep);
								testStatus = "FAILED";

							}
							utillLogger.info(testStep + " - " + testStatus);

							clickOnCardOption();
							objTestBase.defaultWaitTime(3000);

							objVerifyEditDetails_Main.enterPaymentInformation();
							objTestBase.defaultWaitTime(2000);

							utillLogger.info(testStep + " - " + testStatus);
							testStep = "Verification of " + entry.getKey().toLowerCase().toString()
									+ " Ride Booking Payment Update";
							visibilityStatus = objVerifyEditDetails_Main.visibilitofUpdatePaymentBtn(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							}

							// Prod Restriction:
							if (!environmentCode.equalsIgnoreCase("prod")) {
								objTestBase.defaultWaitTime(1000);
								objVerifyEditDetails_Main.clickonPaynowBtn();
								testStep = "Verification of " + entry.getKey().toLowerCase().toString()
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
					}
				}
			}
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);

		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return;
	}

	@AfterClass(groups = "Dispatch.NewBooking")
	public void afterClass() {
		driver.quit();
		// Removes the Duplicate Trip IDs from rideBookingDispatchIds HashMap
		final Iterator<Entry<String, String>> iter = rideBookingDispatchIds.entrySet().iterator();
		final HashSet<String> valueSet = new HashSet<String>();
		while (iter.hasNext()) {
			final Entry<String, String> next = iter.next();
			if (!valueSet.add(next.getValue())) {
				iter.remove();
			}
		}

		// Print the Captured the Ride Booking ids - captured from
		// DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (String keyCar : rideBookingDispatchIds.keySet()) {
			String newKey = keyCar;
			String newValue = rideBookingDispatchIds.get(keyCar);
			if (newKey.toLowerCase().contains("_temp")) {
				rideBookingDispatchIds.remove(keyCar);
				newKey = newKey.replace("_TEMP", "").trim();
				rideBookingDispatchIds.put(newKey, newValue);
			}
		}

		for (Map.Entry<String, String> entry : rideBookingDispatchIds.entrySet()) {
			System.out.println(
					"EDIT Ride IDs from TC: DEV_TC_1908_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test = "
							+ "Total TripIDs = " + rideBookingDispatchIds.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());

			utillLogger.info(
					"EDIT Ride IDs from TC: DEV_TC_1908_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test = "
							+ "Total TripIDs = " + rideBookingDispatchIds.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
