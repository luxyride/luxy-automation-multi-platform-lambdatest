package Concierge.NewBookings;

import java.util.Map;
import common.TestBase;

import java.util.HashMap;
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

public class DEV_TC_1426_VerifyFilteringOfExternalSourceInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Test
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
	String ridePickupDate;

	DEV_TC_1426_VerifyFilteringOfExternalSourceInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Main objVerifyEditDetails_Main;
	DEV_TC_1426_VerifyFilteringOfExternalSourceInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Test objVerifyEditDetails_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.NewBookings")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.NewBookings")
	public void verificationOfRideEditDetailsFromDispatchSite() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyEditDetails_Main = new DEV_TC_1426_VerifyFilteringOfExternalSourceInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Main(
					driver);
			objVerifyEditDetails_Test = new DEV_TC_1426_VerifyFilteringOfExternalSourceInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyEditDetails_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			testStep = "VerifyFilteringOfConciergeRidesInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch";
			if (!externalSourceTripIDsOriginator.isEmpty()) {
				driver.get(prop.getProperty("dispatchURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verify Dispatch Portal Launch Homepage";
				currURL = driver.getCurrentUrl();
				if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))
						&& currURL.toLowerCase().contains("luxyride")) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				}

				objVerifyEditDetails_Main.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyEditDetails_Main.passwordInput();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyEditDetails_Main.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyEditDetails_Main.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyEditDetails_Main.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				utillLogger.info(testStep + " - " + testStatus);

				for (Map.Entry<String, String> entry : externalSourceTripIDsOriginator.entrySet()) {
					testStep = "Verification of Update Trip Details from Dispatch.";
					if (!entry.getValue().equalsIgnoreCase("No_Data")) {
						objVerifyEditDetails_Main.clickRidesSection();
						objTestBase.defaultWaitTime(3000);

						if (entry.getKey().contains("externalSource_Rides_All"))
							objVerifyEditDetails_Main.clickonAllTab();
						else if (entry.getKey().contains("externalSource_InProgress"))
							objVerifyEditDetails_Main.clickonInProgressTab();
						else if (entry.getKey().contains("externalSource_Upcoming"))
							objVerifyEditDetails_Main.clickonUpcomingTab();
						else if (entry.getKey().contains("externalSource_Available"))
							objVerifyEditDetails_Main.clickonAvailableTab();
						else if (entry.getKey().contains("externalSource_Cancelled"))
							objVerifyEditDetails_Main.clickonCancelledTab();
						else if (entry.getKey().contains("externalSource_Completed"))
							objVerifyEditDetails_Main.clickonCompletedTab();

						testStep = "Verification of " + entry.getKey() + " Page loaded.?";
						visibilityStatus = objVerifyEditDetails_Main.visibilityOfRespectivePage(visibilityStatus,
								entry.getKey());
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
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
						ridePickupDate = objVerifyEditDetails_Main.validateTripIDDetails(visibilityStatus,
								ridePickupDate);
						if (ridePickupDate != null) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						}
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.editRideDetails();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Edit Ride Booking for " + entry.getKey().toUpperCase()
								+ " - Trip ID: " + tripID + " - Before Update";
						visibilityStatus = objVerifyEditDetails_Main.verifyEDITRideDetailsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

						objTestBase.defaultWaitTime(2000);

						if (ridePickupDate != null) {
							objVerifyEditDetails_Main.enterDate();
							if (visibilityStatus.booleanValue() == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);

							objTestBase.defaultWaitTime(2000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,1700)", "");
							objTestBase.defaultWaitTime(2000);

							visibilityStatus = objVerifyEditDetails_Main.visibilityOfUpdateRideBtn(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								testStep = "Verify visibility of Update Ride Button";
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								objTestBase.defaultWaitTime(1000);
								// Prod Restriction:
								if (!environmentCode.equalsIgnoreCase("prod")) {
									objTestBase.defaultWaitTime(1000);
									objVerifyEditDetails_Main.clickonUpdateRideBtn();
									testStep = "Verification of " + entry.getKey().toUpperCase()
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
								
								objVerifyEditDetails_Main.enterPaymentInformation();
								objTestBase.defaultWaitTime(2000);

								utillLogger.info(testStep + " - " + testStatus);
								testStep = "Verification of " + entry.getKey().toLowerCase().toString()
										+ " Ride Booking Payment Update";
								visibilityStatus = objVerifyEditDetails_Main
										.visibilitofUpdatePaymentBtn(visibilityStatus);
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

							driver.navigate().refresh();
							objTestBase.defaultWaitTime(3000);
							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,-3000)", "");
							objTestBase.defaultWaitTime(1000);
						}

					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "WARNING";
					}
				}

				testStep = "Verification of Concierge Portal after Editing the details from Dispatch";
				if (testStatus == "PASSED") {
					driver.get(prop.getProperty("conciergeURL"));
					driver.manage().window().maximize();
					objTestBase.defaultWaitTime(3000);

					currURL = driver.getCurrentUrl();
					testStep = "Verify Concierge Homepage Launch";

					if (currURL.toLowerCase().contains(prop.getProperty("environment"))
							&& currURL.toLowerCase().contains("luxyride")) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objTestBase.defaultWaitTime(2000);
					objVerifyEditDetails_Main.eMailInputConcierge();
					objTestBase.defaultWaitTime(1000);
					objVerifyEditDetails_Main.passwordInputConcierge();
					objTestBase.defaultWaitTime(2000);

					testStep = "visibility of Sign In Button";
					visibilityStatus = objVerifyEditDetails_Main.visibilityOfSigninButtonConcierge(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						objVerifyEditDetails_Main.clickSigninButtonConcierge();
						objTestBase.defaultWaitTime(3000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					testStep = "visibility of logged in user";
					visibilityStatus = objVerifyEditDetails_Main.visibilityOfLoggedinUserConcierge(visibilityStatus);
					testStep = "visibility of logged in user";
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					for (Map.Entry<String, String> entry : externalSourceTripIDsOriginator.entrySet()) {
						scenario = entry.getKey();
						tripID = entry.getValue();
						// Validations from Rides - All Page, In Progress Page, Upcoming Page, Available
						// Page, Cancelled Page, Completed Page:
						validateOriginatorScenarios(scenario, tripID);
					}
				} else if (testStatus == "WARNING")
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	private void validateOriginatorScenarios(String scenario, String tripID) throws Exception {
		try {
			objTestBase.defaultWaitTime(3000);
			objVerifyEditDetails_Main.clickRidesSection();
			objTestBase.defaultWaitTime(3000);

			if (scenario.equalsIgnoreCase("externalSource_Rides_All"))
				objVerifyEditDetails_Main.clickonAllTab();
			else if (scenario.equalsIgnoreCase("externalSource_InProgress"))
				objVerifyEditDetails_Main.clickonInProgressTab();
			else if (scenario.equalsIgnoreCase("externalSource_Upcoming"))
				objVerifyEditDetails_Main.clickonUpcomingTab();
			else if (scenario.equalsIgnoreCase("externalSource_Available"))
				objVerifyEditDetails_Main.clickonAvailableTab();
			else if (scenario.equalsIgnoreCase("externalSource_Cancelled"))
				objVerifyEditDetails_Main.clickonCancelledTab();
			else if (scenario.equalsIgnoreCase("externalSource_Completed"))
				objVerifyEditDetails_Main.clickonCompletedTab();

			objTestBase.defaultWaitTime(2000);

			testStep = "Verify Originator drop down section from " + scenario + " Page";
			visibilityStatus = objVerifyEditDetails_Main.searchTripID(visibilityStatus, tripID);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(2000);
			if (testStatus == "PASSED") {
				testStep = "Verify Source System is displayed as per the Concierge site selected from Origintor dropdown from - "
						+ scenario + " page.";
				visibilityStatus = objVerifyEditDetails_Main.verifySourceSystemConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();
		// Removes the Duplicate Trip IDs from externalSourceTripIDsOriginator HashMap
		final Iterator<Entry<String, String>> iter = externalSourceTripIDsOriginator.entrySet().iterator();
		final HashSet<String> valueSet = new HashSet<String>();
		while (iter.hasNext()) {
			final Entry<String, String> next = iter.next();
			if (!valueSet.add(next.getValue())) {
				iter.remove();
			}
		}

		// Print the Captured the Ride Booking ids - captured from
		// DEV_TC_1523_VerifyFilteringOfTravelAgentRidesInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Test:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (String keyCar : externalSourceTripIDsOriginator.keySet()) {
			String newKey = keyCar;
			String newValue = externalSourceTripIDsOriginator.get(keyCar);
			if (newKey.toLowerCase().contains("_temp")) {
				externalSourceTripIDsOriginator.remove(keyCar);
				newKey = newKey.replace("_TEMP", "").trim();
				externalSourceTripIDsOriginator.put(newKey, newValue);
			}
		}

		for (Map.Entry<String, String> entry : externalSourceTripIDsOriginator.entrySet()) {
			System.out.println(
					"EDIT Ride IDs from TC: DEV_TC_1523_VerifyFilteringOfTravelAgentRidesInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Test = "
							+ "Total TripIDs = " + externalSourceTripIDsOriginator.size() + " - " + entry.getKey()
							+ " - " + entry.getValue());

			utillLogger.info(
					"EDIT Ride IDs from TC: DEV_TC_1523_VerifyFilteringOfTravelAgentRidesInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Test = "
							+ "Total TripIDs = " + externalSourceTripIDsOriginator.size() + " - " + entry.getKey()
							+ " - " + entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
