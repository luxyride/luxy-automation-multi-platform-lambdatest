package Dispatch.EmailNotifications;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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

public class DEV_TC_1051_VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Test extends TestBase {

	String tripID;
	Actions action;
	String currURL;
	String expected;
	String userName;
	String testStep;
	String scenario;
	String testStatus;
	WebElement element;
	String exception = "";
	String screenshotPath;
	Boolean visibilityStatus;

	DEV_TC_1051_VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Main objVerifyResendEmailMain;
	DEV_TC_1051_VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Test objVerifyResendEmailTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.EmailNotifications")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.EmailNotifications")
	public void VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Test() throws Exception {
		try {
			int indexCount = 1;
			action = new Actions(driver);
			objVerifyResendEmailMain = new DEV_TC_1051_VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Main(
					driver);
			objVerifyResendEmailTest = new DEV_TC_1051_VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyResendEmailMain.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyResendEmailTest.getClass().getSimpleName()
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
				objVerifyResendEmailMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyResendEmailMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyResendEmailMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyResendEmailMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyResendEmailMain.clickSigninButton();
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

				objVerifyResendEmailMain.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyResendEmailMain.visibilityOfLoggedinUser(visibilityStatus);
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

			objVerifyResendEmailMain.clickRidesSection();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
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
					tripID = entry.getValue();
					scenario = entry.getKey();
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(2000);
					objVerifyResendEmailMain.searchRideId(tripID);
					objTestBase.defaultWaitTime(3000);

					// -----------------------------------------------------------------------------------
					// Validate the TripID Details:
					testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for "
							+ entry.getKey().toUpperCase() + " - Trip ID: " + tripID + " - Before Update";
					visibilityStatus = objVerifyResendEmailMain.validateTripIDDetails(visibilityStatus);
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
					// -----------------------------------------------------------------------------------

					testStep = "Validate EDIT Ride for " + entry.getKey().toUpperCase() + " - Trip ID: " + tripID;
					if (visibilityStatus.booleanValue() == true) {
						objVerifyResendEmailMain.editRideDetails();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Edit Ride Booking for " + entry.getKey().toUpperCase()
								+ " - Trip ID: " + tripID + " - Before Update";
						visibilityStatus = objVerifyResendEmailMain.verifyEDITRideDetailsPage(visibilityStatus);
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
						objTestBase.defaultWaitTime(2000);

						// Validation-1: SEDAN - Update the Address for Pickup, Drop-off and Extra Stop,
						// if vehicle is "SEDAN"
						if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "sedan") {
							objVerifyResendEmailMain.deleteAllExistingAddress();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.addFromAddress();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.addToAddress();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.clickOnExtraStop();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.addExtraStop();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.enterDate();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.clickOngetQuote();
							objTestBase.defaultWaitTime(3000);
							objVerifyResendEmailMain.clickOnSedan();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,1900)", "");
							objTestBase.defaultWaitTime(2000);

						}
						// Validation-2: SUV - Date & Time and Vehicle change to Sedan
						else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "suv") {
							objVerifyResendEmailMain.enterDate();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.enterTime();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.clickOngetQuote();
							objTestBase.defaultWaitTime(3000);
							objVerifyResendEmailMain.clickOnSedan();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,1600)", "");
							objTestBase.defaultWaitTime(2000);

							// Update the SEDAN Trip ID to SUV Vehicle:
							for (Map.Entry<String, String> updateEntry : rideBookingDispatchIds.entrySet()) {
								String key = updateEntry.getKey();
								String value = updateEntry.getValue();
								if (key == "sedan") {
									String updatedKey = "suv";
									rideBookingDispatchIds.put(updatedKey, value);
								}
							}

						}
						// Validation-3: SUV-XL - Remove Secondary Passenger details and Extra Stops
						else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "suv-xl") {
							objVerifyResendEmailMain.removeExtraStop();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.enterDate();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.clickOngetQuote();
							objTestBase.defaultWaitTime(3000);
							objVerifyResendEmailMain.clickOnSUVXL();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,600)", "");
							objTestBase.defaultWaitTime(2000);

							objVerifyResendEmailMain.clickOnRemoveSecondaryPassenger();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,1100)", "");
							objTestBase.defaultWaitTime(2000);

						}
						// Validation-4: VAN - Update Flight Info. details and Arrival Meet and Greet
						// update and vehicle change to SUV
						else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "van") {
							objVerifyResendEmailMain.enterDate();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.clickOngetQuote();
							objTestBase.defaultWaitTime(3000);
							objVerifyResendEmailMain.clickOnSUV();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,1100)", "");
							objTestBase.defaultWaitTime(2000);

							objVerifyResendEmailMain.addAirline();
							objTestBase.defaultWaitTime(1000);
							objVerifyResendEmailMain.enterFlightNumber();
							objTestBase.defaultWaitTime(1000);
							objVerifyResendEmailMain.clickonArrivalMeetGreet();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.enterArrivalMeetGreetDetails();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,800)", "");
							objTestBase.defaultWaitTime(2000);

							// Update the SUV Trip ID to VAN Vehicle:
							for (Map.Entry<String, String> updateEntry : rideBookingDispatchIds.entrySet()) {
								String key = updateEntry.getKey();
								String value = updateEntry.getValue();
								if (key == "suv") {
									String updatedKey = "van";
									rideBookingDispatchIds.put(updatedKey, value);
								}
							}
						}
						// Validation-5: VAN-XL - Update Traveling with Pet & Child Seat from Extras
						else if (testStatus == "PASSED" && entry.getKey().toLowerCase() == "van-xl") {
							objVerifyResendEmailMain.enterDate();
							objTestBase.defaultWaitTime(2000);
							objVerifyResendEmailMain.clickOngetQuote();
							objTestBase.defaultWaitTime(3000);
							objVerifyResendEmailMain.clickOnVANXL();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,1200)", "");
							objTestBase.defaultWaitTime(2000);

							objVerifyResendEmailMain.clickTravelingPetCheckbox();
							objTestBase.defaultWaitTime(1000);

							objVerifyResendEmailMain.clickChildSeatCheckbox();
							objTestBase.defaultWaitTime(1000);

							js = (JavascriptExecutor) driver;
							
							objTestBase.defaultWaitTime(2000);
						}

						visibilityStatus = objVerifyResendEmailMain.visibilityOfUpdateRideBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							testStep = "Verify visibility of Update Ride Button";
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								lambdaTestStatusUpdate("passed", testStep);
							objTestBase.defaultWaitTime(1000);

							// Prod Restriction:
							if (!environmentCode.equalsIgnoreCase("prod")) {
								objTestBase.defaultWaitTime(1000);
								objVerifyResendEmailMain.clickonUpdateRideBtn();
								testStep = "Verification of " + entry.getKey().toUpperCase()
										+ " Ride Update Booking Confirmation Message";
								visibilityStatus = objVerifyResendEmailMain
										.verifyRideBookingConfirmation(visibilityStatus);
								objTestBase.defaultWaitTime(2000);
								if (visibilityStatus.booleanValue() == true) {
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
									objTestBase.defaultWaitTime(1000);
								} else {
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								}
							}

						} else {
							js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,-100)", "");
							objTestBase.defaultWaitTime(2000);

							objVerifyResendEmailMain.enterPaymentInformation();
							objTestBase.defaultWaitTime(2000);

							utillLogger.info(testStep + " - " + testStatus);
							testStep = "Verification of " + entry.getKey().toLowerCase().toString()
									+ " Ride Booking Payment Update";
							visibilityStatus = objVerifyResendEmailMain.visibilitofUpdatePaymentBtn(visibilityStatus);
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
								objVerifyResendEmailMain.clickonPaynowBtn();
								testStep = "Verification of " + entry.getKey().toLowerCase().toString()
										+ " Ride Update Booking Confirmation Message";
								visibilityStatus = objVerifyResendEmailMain
										.verifyRideBookingConfirmation(visibilityStatus);
								objTestBase.defaultWaitTime(2000);
								if (visibilityStatus.booleanValue() == true) {
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
									objTestBase.defaultWaitTime(1000);
								} else {
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								}
							}
						}

						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,-3000)", "");
						objTestBase.defaultWaitTime(1000);

						if (visibilityStatus.booleanValue() == true) {
							if (tripID != "") {
								// Capture the Updated Ride Booking details based on IDs:
								tripID = objVerifyResendEmailMain.captureRideBookingIDs(visibilityStatus, scenario,
										tripID);
								testStep = "Verification of Capturing the Updated Ride ID for " + scenario
										+ " - Trip ID = " + tripID;
								if (tripID != "")
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
							} else
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);

							objVerifyResendEmailMain.editRideDetails();
							objTestBase.defaultWaitTime(3000);

							testStep = "Verificatin of Edit Ride Booking for " + entry.getKey().toUpperCase()
									+ " - Trip ID: " + tripID + " - After Update";
							visibilityStatus = objVerifyResendEmailMain.verifyEDITRideDetailsPage(visibilityStatus);
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
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);
					}
					objTestBase.defaultWaitTime(500);
					objVerifyResendEmailMain.clickRidesSection();
					objTestBase.defaultWaitTime(1000);
					visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
					objTestBase.defaultWaitTime(3000);
				}
				testStatus = "PASSED";
			} else {
				testStep = "EDIT Rides Skipped due to EMPTY Rides Captured from DEV_TC_1020_VerificationOfNewBookingFromDispatchSite";
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
						objVerifyResendEmailMain.searchRideId(tripID);
						objTestBase.defaultWaitTime(1000);
						objVerifyResendEmailMain.editRideDetails();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verificatin of Edit Ride Booking for " + entry.getKey().toUpperCase()
								+ " - Trip ID: " + tripID + " - After Update";
						visibilityStatus = objVerifyResendEmailMain.verifyEDITRideDetailsPage(visibilityStatus);
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

						objVerifyResendEmailMain.clickRidesSection();
						objTestBase.defaultWaitTime(1000);
						visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
						objTestBase.defaultWaitTime(3000);

						objTestBase.defaultWaitTime(1000);
						utillLogger.info(testStep + " - " + testStatus);

						testStep = "Verification of Resend Ride Booking Email Confirmation for "
								+ entry.getKey().toUpperCase() + " - Trip ID: " + tripID;
						visibilityStatus = objVerifyResendEmailMain.verifyResendEmailConfirmationBtn(visibilityStatus);
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

						// Verify Email Confirmation:
						testStatus = verifyEmailConfirmation(entry.getKey(), tripID);

						if (indexCount != rideBookingDispatchIds.size()) {
							// Load Dispatch Site:
							testStatus = loadDispatchSite(testStatus);
						}

						if (testStatus == "FAILED")
							break;

						objTestBase.defaultWaitTime(2000);
						utillLogger.info(testStep + " - " + testStatus);
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	private String loadDispatchSite(String testStatus) {
		try {
			driver.get(prop.getProperty("dispatchURL"));
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of New Booking Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfNewBookingPage(visibilityStatus);
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

			objVerifyResendEmailMain.clickRidesSection();
			objTestBase.defaultWaitTime(1000);

			testStep = "Verification of Rides All Page loaded.?";
			visibilityStatus = objVerifyResendEmailMain.visibilityOfRidesAllPage(visibilityStatus);
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

		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	private String verifyEmailConfirmation(String vehicleType, String tripID) {
		try {
			for (int i = 0; i <= 1; i++) {
				if (i == 0)
					scenario = "Primary Email";
				else
					scenario = "Secondary Email";

				driver.get(prop.getProperty("yopmailURL"));
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Resend Ride Booking EMail Confirmation of Vehicle: " + vehicleType + " - "
						+ scenario + " with TripID = " + tripID;
				eMail = objVerifyResendEmailMain.emailIDSerach(scenario, eMail, tripID);
				objTestBase.defaultWaitTime(1000);

				System.out.println("DEV_TC_1051_Email = " + eMail);
				utillLogger
						.info(objVerifyResendEmailMain.getClass().getSimpleName() + " - DEV_TC_1051_Email = " + eMail);

				testStep = "Verification Resend Email Not Received with PIN Number for Vehicle: " + vehicleType + " - "
						+ scenario + " of TripID = " + tripID;
				visibilityStatus = objVerifyResendEmailMain.verificationOfPINConfirmationEmail(visibilityStatus,
						tripID);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "FAILED";
				}

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
				objTestBase.defaultWaitTime(2000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	@AfterClass(groups = "Dispatch.EmailNotifications")
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
		// DEV_TC_1020_VerificationOfNewBookingFromDispatchSite Test Case:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingDispatchIds.entrySet()) {
			System.out.println(
					"Booking IDs from TC: DEV_TC_1051_VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Test = "
							+ "Total TripIDs = " + rideBookingDispatchIds.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
			utillLogger.info(
					"Booking IDs from TC: DEV_TC_1051_VerifyPINConfirmationEmailIsNotSentToCustomerWhenTheRidesEdited_Test = "
							+ "Total TripIDs = " + rideBookingDispatchIds.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyResendEmailTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
