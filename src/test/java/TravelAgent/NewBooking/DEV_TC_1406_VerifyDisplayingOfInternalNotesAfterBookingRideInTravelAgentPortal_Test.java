package TravelAgent.NewBooking;

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

public class DEV_TC_1406_VerifyDisplayingOfInternalNotesAfterBookingRideInTravelAgentPortal_Test extends TestBase {

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
	String internalNotesBeforeUpdate;
	String internalNotesAfterUpdate;

	DEV_TC_1406_VerifyDisplayingOfInternalNotesAfterBookingRideInTravelAgentPortal_Main objVerifyBookedRideCorporateMain;
	DEV_TC_1406_VerifyDisplayingOfInternalNotesAfterBookingRideInTravelAgentPortal_Test objVerifyBookedRideCorporateTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.NewBooking")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.NewBooking")
	public void VerifyDisplayingOfInternalNotesAfterBookingRideInTravelAgentPortal() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyBookedRideCorporateMain = new DEV_TC_1406_VerifyDisplayingOfInternalNotesAfterBookingRideInTravelAgentPortal_Main(
					driver);
			objVerifyBookedRideCorporateTest = new DEV_TC_1406_VerifyDisplayingOfInternalNotesAfterBookingRideInTravelAgentPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyBookedRideCorporateTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyBookedRideCorporateTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("travelAgentURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(8000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of TravelAgent Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of user login in TravelAgent Portal ";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyBookedRideCorporateMain.eMailInput(visibilityStatus);
				objTestBase.defaultWaitTime(1000);

				if (visibilityStatus.booleanValue() == true) {
					objVerifyBookedRideCorporateMain.passwordInput();
					objTestBase.defaultWaitTime(1000);
					visibilityStatus = objVerifyBookedRideCorporateMain.visibilityOfSigninButton(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						objVerifyBookedRideCorporateMain.clickSigninButton();
						objTestBase.defaultWaitTime(3000);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objVerifyBookedRideCorporateMain.clickNewBooking();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of TravelAgent Portal Login With Valid Credentials";
					visibilityStatus = objVerifyBookedRideCorporateMain.visibilityOfLoggedinUser(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verification of 'Are you Booking For Corporate.?' toggle displayed and enable the toggle";
					visibilityStatus = objVerifyBookedRideCorporateMain
							.visibilityOfAreYouBookingForCorporateToggle(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verification of Selecting the Corporate Details from Search Corporate box";
					visibilityStatus = objVerifyBookedRideCorporateMain.searchCorporate(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					scenario = "Book Sedan";
					testStatus = vechileBooking(scenario, testStatus);
				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	public String vechileBooking(String scenario, String testStatus) throws Exception {
		try {
			objTestBase.defaultWaitTime(3000);
			objVerifyBookedRideCorporateMain.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifyBookedRideCorporateMain.addToAddress();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)", "");
			objVerifyBookedRideCorporateMain.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyBookedRideCorporateMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyBookedRideCorporateMain.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			objVerifyBookedRideCorporateMain.clickOnSedan();
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			

			objVerifyBookedRideCorporateMain.enterFirstName();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			objVerifyBookedRideCorporateMain.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyBookedRideCorporateMain.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyBookedRideCorporateMain.enterPassengerNotes();
			objTestBase.defaultWaitTime(1000);
			objVerifyBookedRideCorporateMain.enterInternalNotes();
			objTestBase.defaultWaitTime(1000);

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);
			
			objVerifyBookedRideCorporateMain.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyBookedRideCorporateMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyBookedRideCorporateMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(500);
				testStatus = "";
				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifyBookedRideCorporateMain.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyBookedRideCorporateMain.clickRidesSection();
				objTestBase.defaultWaitTime(2000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifyBookedRideCorporateMain.captureRideBookingIDs(visibilityStatus, scenario, tripID);
					System.out.println("Trip ID = " + tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != null)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

				if (tripID != null) {
					objVerifyBookedRideCorporateMain.editRideDetails();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Edit Ride Booking Page for Trip ID = " + tripID;
					visibilityStatus = objVerifyBookedRideCorporateMain.verifyEDITRideDetailsPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					objTestBase.defaultWaitTime(5000);

					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,900)", "");

					testStep = "Verification of Internal Notes value from Edit Ride Booking Page - Before Update for Trip ID = "
							+ tripID;
					internalNotesBeforeUpdate = objVerifyBookedRideCorporateMain
							.verifyInternalNotesValueBeforeUpdate(visibilityStatus, internalNotesBeforeUpdate);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					objTestBase.defaultWaitTime(3000);

					objVerifyBookedRideCorporateMain.updateInternalNotes();
					objTestBase.defaultWaitTime(1000);

					if (testStatus == "PASSED") {
						js.executeScript("window.scrollBy(0,700)", "");
						visibilityStatus = objVerifyBookedRideCorporateMain.visibilityOfUpdateRideBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							testStep = "Verify visibility of Update Ride Button";
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							objTestBase.defaultWaitTime(1000);
							// Prod Restriction:
							if (!environmentCode.equalsIgnoreCase("prod")) {
								objTestBase.defaultWaitTime(1000);
								objVerifyBookedRideCorporateMain.clickonUpdateRideBtn();
								testStep = "Verification of Ride Booking Confirmation Message for Trip ID = " + tripID;
								visibilityStatus = objVerifyBookedRideCorporateMain
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

							objVerifyBookedRideCorporateMain.enterPaymentInformation();
							objTestBase.defaultWaitTime(2000);

							utillLogger.info(testStep + " - " + testStatus);
							testStep = "Verification of Ride Booking Payment Update for Trip ID = " + tripID;
							visibilityStatus = objVerifyBookedRideCorporateMain
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
								objVerifyBookedRideCorporateMain.clickonPaynowBtn();
								testStep = "Verification of Ride Booking Confirmation Message for Trip ID = " + tripID;
								visibilityStatus = objVerifyBookedRideCorporateMain
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

						testStep = "Verification Trip ID displayed from Rides All Page = " + tripID;
						visibilityStatus = objVerifyBookedRideCorporateMain.searchTripID(visibilityStatus, tripID);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						objVerifyBookedRideCorporateMain.editRideDetails();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Edit Ride Booking Page for Trip ID = " + tripID;
						visibilityStatus = objVerifyBookedRideCorporateMain.verifyEDITRideDetailsPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						objTestBase.defaultWaitTime(5000);

						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,700)", "");

						testStep = "Verification of Internal Notes value from Edit Ride Booking Page - After Update for Trip ID = "
								+ tripID;
						visibilityStatus = objVerifyBookedRideCorporateMain.verifyInternalNotesValueAfterUpdate(
								visibilityStatus, internalNotesBeforeUpdate, internalNotesAfterUpdate);
						if (visibilityStatus.booleanValue() == true)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

						objTestBase.defaultWaitTime(3000);
					}
				}
			}
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return testStatus;
	}

	@AfterClass(groups = "TravelAgent.NewBooking")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyBookedRideCorporateTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
