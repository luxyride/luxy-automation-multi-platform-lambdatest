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

public class DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test extends TestBase {
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

	DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Main objVerifyEditDetails_Main;
	DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test objVerifyEditDetails_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.NewBooking")
	@Parameters({"browser"})
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
		int indexCount = 1;
		try {
			action = new Actions(driver);
			objVerifyEditDetails_Main = new DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Main(
					driver);
			objVerifyEditDetails_Test = new DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test();
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
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
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
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			objVerifyEditDetails_Main.clickRidesSection();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
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
						visibilityStatus = objVerifyEditDetails_Main.validateTripIDDetails(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
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

							// Validation-1: SEDAN - Update the Address for Pickup, Drop-off and Extra Stop,
							// if vehicle is "SEDAN"
							if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "sedan") {
								objVerifyEditDetails_Main.deleteAllExistingAddress();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.addFromAddress();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.addToAddress();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.clickOnExtraStop();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.addExtraStop();
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
							// Validation-2: SUV - Date & Time and Vehicle change to VAN
							else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "suv") {
								objVerifyEditDetails_Main.enterDate();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.enterTime();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.clickOngetQuote();
								objTestBase.defaultWaitTime(3000);
								objVerifyEditDetails_Main.clickOnVAN();
								objTestBase.defaultWaitTime(1000);

								js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,1600)", "");
								objTestBase.defaultWaitTime(2000);

								// Update the SUV Trip ID to VAN_TEMP Vehicle:
								for (Map.Entry<String, String> updateEntry : rideBookingDispatchIds.entrySet()) {
									String key = updateEntry.getKey();
									String value = updateEntry.getValue();
									if (key == "suv") {
										String updatedKey = "van_temp";
										rideBookingDispatchIds.put(updatedKey, value);
									}
								}
							}
							// Validation-3: SUV-XL - Remove Secondary Passenger details and Extra Stops
							else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "suv-xl") {
								objVerifyEditDetails_Main.removeExtraStop();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.enterDate();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.clickOngetQuote();
								objTestBase.defaultWaitTime(3000);
								objVerifyEditDetails_Main.clickOnSUVXL();
								objTestBase.defaultWaitTime(1000);

								js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,600)", "");
								objTestBase.defaultWaitTime(2000);

								objVerifyEditDetails_Main.clickOnRemoveSecondaryPassenger();
								objTestBase.defaultWaitTime(1000);

								js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,1100)", "");
								objTestBase.defaultWaitTime(2000);

							}
							// Validation-4: VAN - Update Flight Info. details and Arrival Meet and Greet
							// update and vehicle change to SUV
							else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "van") {
								objVerifyEditDetails_Main.enterDate();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.clickOngetQuote();
								objTestBase.defaultWaitTime(3000);
								objVerifyEditDetails_Main.clickOnSUV();
								objTestBase.defaultWaitTime(1000);

								js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,800)", "");
								objTestBase.defaultWaitTime(2000);

								objVerifyEditDetails_Main.addAirline();
								objTestBase.defaultWaitTime(1000);
								objVerifyEditDetails_Main.enterFlightNumber();
								objTestBase.defaultWaitTime(1000);
								objVerifyEditDetails_Main.clickonArrivalMeetGreet();
								objTestBase.defaultWaitTime(2000);
								js = (JavascriptExecutor) driver;
								
								objVerifyEditDetails_Main.enterArrivalMeetGreetDetails();
								objTestBase.defaultWaitTime(1000);

								js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,800)", "");
								objTestBase.defaultWaitTime(2000);

								// Update the VAN Trip ID to SUV_TEMP Vehicle:
								for (Map.Entry<String, String> updateEntry : rideBookingDispatchIds.entrySet()) {
									String key = updateEntry.getKey();
									String value = updateEntry.getValue();
									if (key == "van") {
										String updatedKey = "suv_temp";
										rideBookingDispatchIds.put(updatedKey, value);
									}
								}
							}
							// Validation-5: VAN-XL - Update Traveling with Pet & Child Seat from Extras
							else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "van-xl") {
								objVerifyEditDetails_Main.enterDate();
								objTestBase.defaultWaitTime(2000);
								objVerifyEditDetails_Main.clickOngetQuote();
								objTestBase.defaultWaitTime(3000);
								objVerifyEditDetails_Main.clickOnVANXL();
								objTestBase.defaultWaitTime(1000);

								js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,1200)", "");
								objTestBase.defaultWaitTime(2000);

								objVerifyEditDetails_Main.clickTravelingPetCheckbox();
								objTestBase.defaultWaitTime(1000);

								objVerifyEditDetails_Main.clickChildSeatCheckbox();
								objTestBase.defaultWaitTime(1000);

								js = (JavascriptExecutor) driver;
								
								objTestBase.defaultWaitTime(2000);
							}

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
								
								clickOnCardOption();
								objTestBase.defaultWaitTime(3000);

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

							if (tripID != null) {
								// Capture the Updated Ride Booking details based on IDs:
								tripID = objVerifyEditDetails_Main.captureRideBookingIDs(visibilityStatus, scenario,
										tripID);
								testStep = "Verification of Capturing the Updated Ride ID for " + scenario
										+ " - Trip ID = " + tripID;
								if (tripID != "")
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);

								objVerifyEditDetails_Main.editRideDetails();
								objTestBase.defaultWaitTime(3000);

								testStep = "Verificatin of Edit Ride Booking for " + entry.getKey().toUpperCase()
										+ " - Trip ID: " + tripID + " - After Update";
								visibilityStatus = objVerifyEditDetails_Main
										.verifyEDITRideDetailsPage(visibilityStatus);
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
						}
					}
				}
				testStatus = "PASSED";
			} else {
				testStep = "EDIT Rides Skipped due to EMPTY Rides Captured from DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test";
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "FAILED";
			}
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);

			if (testStatus == "PASSED") {
				if (!rideBookingDispatchIds.isEmpty()) {
					for (Map.Entry<String, String> entry : rideBookingDispatchIds.entrySet()) {
						System.out.println(entry.getKey() + " - " + tripID);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.searchRideId(tripID);
						objTestBase.defaultWaitTime(1000);
						objVerifyEditDetails_Main.editRideDetails();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verificatin of Edit Ride Booking for " + entry.getKey().toUpperCase()
								+ " - Trip ID: " + tripID + " - After Update";
						visibilityStatus = objVerifyEditDetails_Main.verifyEDITRideDetailsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						objVerifyEditDetails_Main.clickRidesSection();
						objTestBase.defaultWaitTime(1000);
						visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
						objTestBase.defaultWaitTime(3000);

						objTestBase.defaultWaitTime(1000);
						utillLogger.info(testStep + " - " + testStatus);

						testStep = "Verification of Resend Ride Booking Email Confirmation for "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + tripID;
						visibilityStatus = objVerifyEditDetails_Main.verifyResendEmailConfirmationBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						// Verify Email Confirmation:
						testStatus = verifyEmailConfirmation(entry.getKey(), tripID);

						if (indexCount != rideBookingDispatchIds.size()) {
							// Load Dispatch Site:
							testStatus = loadDispatchSite(testStatus);
						}

						objTestBase.defaultWaitTime(2000);
						utillLogger.info(testStep + " - " + testStatus);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	private String loadDispatchSite(String testStatus) {
		try {
			driver.get(prop.getProperty("dispatchURL"));
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of New Booking Page loaded.?";
			visibilityStatus = objVerifyEditDetails_Main.visibilityOfNewBookingPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objVerifyEditDetails_Main.clickRidesSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	private String verifyEmailConfirmation(String vehicleType, String tripID) {
		try {
			if (testStatus == "PASSED") {
				for (int i = 0; i <= 1; i++) {
					if (i == 0)
						scenario = "Primary Email";
					else
						scenario = "Secondary Email";

					driver.get(prop.getProperty("yopmailURL"));
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Resend Ride Booking EMail Confirmation of Vehicle: " + vehicleType
							+ " - " + scenario + " with TripID = " + tripID;
					eMail = objVerifyEditDetails_Main.emailIDSerach(scenario, eMail, tripID);
					objTestBase.defaultWaitTime(1000);

					System.out.println("DEV_TC_1051_Email = " + eMail);
					utillLogger.info(
							objVerifyEditDetails_Main.getClass().getSimpleName() + " - DEV_TC_1051_Email = " + eMail);

					testStep = "Verification Resend Email Not Received with PIN Number for Vehicle: " + vehicleType
							+ " - " + scenario + " of TripID = " + tripID;
					visibilityStatus = objVerifyEditDetails_Main.verificationOfPINConfirmationEmail(visibilityStatus,
							tripID);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "FAILED";
					}

					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,150)", "");
					objTestBase.defaultWaitTime(2000);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
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
					"EDIT Ride IDs from TC: DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test = "
							+ "Total TripIDs = " + rideBookingDispatchIds.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());

			utillLogger.info(
					"EDIT Ride IDs from TC: DEV_TC_1032_VerificationOfNewBookingAndEditRideDetailsFromDispatchSite_Test = "
							+ "Total TripIDs = " + rideBookingDispatchIds.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
