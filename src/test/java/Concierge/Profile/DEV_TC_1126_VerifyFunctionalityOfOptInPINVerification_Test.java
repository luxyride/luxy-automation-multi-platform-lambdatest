package Concierge.Profile;

import java.util.Map;
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

public class DEV_TC_1126_VerifyFunctionalityOfOptInPINVerification_Test extends TestBase {

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

	DEV_TC_1126_VerifyFunctionalityOfOptInPINVerification_Main objOptinPIN_Main;
	DEV_TC_1126_VerifyFunctionalityOfOptInPINVerification_Test objOptinPIN_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.Profile")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.Profile")
	public void verifyRegistrationCorporate() {
		try {
			action = new Actions(driver);
			objOptinPIN_Main = new DEV_TC_1126_VerifyFunctionalityOfOptInPINVerification_Main(driver);
			objOptinPIN_Test = new DEV_TC_1126_VerifyFunctionalityOfOptInPINVerification_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objOptinPIN_Test.getClass().getSimpleName());
			utillLogger.info("## " + objOptinPIN_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			// Verify Opt PIN checkbox from Concierge Profile Page - START:
			driver.get(prop.getProperty("conciergeURL"));
			currURL = driver.getCurrentUrl();
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);
			testStep = "Verification of Concierge Site Login Page ";

			objOptinPIN_Main.eMailInputConcierge();
			objOptinPIN_Main.passwordInputConcierge();
			objTestBase.defaultWaitTime(1000);
			visibilityStatus = objOptinPIN_Main.visibilityOfSigninButtonConcierge(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objOptinPIN_Main.clickSigninButtonConcierge();
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(1000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verification of Concierge Site Login With Valid Credentials";
			visibilityStatus = objOptinPIN_Main.visibilityOfLoggedinUserConcierge(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Verification of Profile Page Navigation in Concierge site";
			if (testStatus == "PASSED") {
				visibilityStatus = objOptinPIN_Main.verifyProfilePageConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verification of EDIT Profile Page from Concierge site";
			if (testStatus == "PASSED") {
				visibilityStatus = objOptinPIN_Main.verifyEditProfilePageConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verification of Opt In Checkbox is selected by default from Concierge site";
			if (testStatus == "PASSED") {
				visibilityStatus = objOptinPIN_Main.verifyOptInCheckedDefaultConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verify check/uncheck the 'Opt in PIN Verification for security' option from Concierge EDIT Profile Page";
			visibilityStatus = objOptinPIN_Main.verifyOptInCheckUncheckConcierge(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			testStep = "Verify confirmation message after UPDATED the details from Concierge EDIT Profile Page";
			visibilityStatus = objOptinPIN_Main.verifyUpdateConfMsgConcierge(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// Verify Opt PIN checkbox from Concierge Profile Page - END:

			// Verify Ride Booking Functionality from Concierge Site - START:
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objOptinPIN_Main.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objOptinPIN_Main.addFromAddress();
			objTestBase.defaultWaitTime(2000);
			objOptinPIN_Main.addToAddress();
			objTestBase.defaultWaitTime(2000);
			objOptinPIN_Main.clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.addExtraStop();
			objTestBase.defaultWaitTime(3000);
			objOptinPIN_Main.enterDate();
			objTestBase.defaultWaitTime(2000);
			objOptinPIN_Main.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objOptinPIN_Main.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.clickOnSedan();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(2000);

			objOptinPIN_Main.searchBookingUserName();
			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.clickOnAddSecondaryPassengerDetails();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(2000);

			objOptinPIN_Main.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objOptinPIN_Main.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.addAirline();
			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objOptinPIN_Main.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			objOptinPIN_Main.promoCodeEnable();
			objTestBase.defaultWaitTime(2000);
			scenario = "Sedan";
			objOptinPIN_Main.enterPromocode(scenario);
			objTestBase.defaultWaitTime(2000);
			objOptinPIN_Main.clickonPromocodeApply();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			objTestBase.defaultWaitTime(2000);
			
			clickOnCardOption();
			objTestBase.defaultWaitTime(2000);

			objOptinPIN_Main.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objOptinPIN_Main.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objOptinPIN_Main.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objOptinPIN_Main.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objOptinPIN_Main.clickRidesSection();
				objTestBase.defaultWaitTime(6000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objOptinPIN_Main.captureRideBookingIDsConcierge(visibilityStatus, scenario, tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != null)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				} else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
			// Verify Ride Booking Functionality from Concierge Site - END:

			// Verify Form-out functionality from Dispatch Site & Affiliate - START:
			if (tripID != null) {
				driver.get(prop.getProperty("dispatchURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(500);
				currURL = driver.getCurrentUrl();
				objTestBase.defaultWaitTime(2000);
				testStep = "Verification of Dispatch Portal Loginpage ";
				objOptinPIN_Main.eMailInputDispatch();
				objTestBase.defaultWaitTime(2000);
				objOptinPIN_Main.passwordInputDispatch();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objOptinPIN_Main.visibilityOfSigninButtonDispatch(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objOptinPIN_Main.clickSigninButtonDispatch();
					objTestBase.defaultWaitTime(5000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objOptinPIN_Main.visibilityOfLoggedinUserDispatch(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				utillLogger.info(testStep + " - " + testStatus);

				objOptinPIN_Main.clickRidesSection();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Rides All Page loaded.?";
				visibilityStatus = objOptinPIN_Main.visibilityOfRidesAllPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				if (tripID != null) {
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(2000);
					objOptinPIN_Main.searchRideId(tripID);
					objTestBase.defaultWaitTime(5000);
					// -----------------------------------------------------------------------------------
					// Validate the TripID Details:
					testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for " + scenario
							+ " - Trip ID: " + tripID + " - Before Update";
					visibilityStatus = objOptinPIN_Main.validateTripIDDetailsDispatch(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					}
					// -----------------------------------------------------------------------------------

					testStep = "Verify Farm-out the above booked ride - Trip ID = " + tripID
							+ " to particular affiliate.";
					visibilityStatus = objOptinPIN_Main.verifyFormout(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					}

					testStep = "Verify Farmed-out Confimation Message has displayed for the Trip ID = " + tripID
							+ " to particular affiliate.";
					visibilityStatus = objOptinPIN_Main.verifyFarmedOutConfirmation(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					// Verify Login to the above farmed out affiliate dashboard and verify the Ride
					// Details.
					testStep = "Verification of Affiliate Loginpage ";
					if (testStatus == "PASSED") {
						driver.get(prop.getProperty("affiliateURL"));
						objTestBase.defaultWaitTime(500);
						currURL = driver.getCurrentUrl();
						objTestBase.defaultWaitTime(2000);
						objOptinPIN_Main.eMailInputAffiliate();
						objOptinPIN_Main.passwordInputAffiliate();
						objTestBase.defaultWaitTime(1000);
						visibilityStatus = objOptinPIN_Main.visibilityOfSigninButtonAffiliate(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							objOptinPIN_Main.clickSigninButtonAffiliate();
							objTestBase.defaultWaitTime(3000);
							driver.navigate().refresh();
							objTestBase.defaultWaitTime(1000);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						testStep = "Verification of user Loggedin in Affiliate Site";
						if (testStatus == "PASSED") {
							visibilityStatus = objOptinPIN_Main.visibilityOfSigninButtonAffiliate(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								objOptinPIN_Main.clickSigninButtonAffiliate();
								objTestBase.defaultWaitTime(3000);
								driver.navigate().refresh();
								objTestBase.defaultWaitTime(1000);
								testStatus = "PASSED";
							} else {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
								testStatus = "FAILED";
							}
						}

						testStep = "Verification of Ride Details from Upcoming Tab in Affiliate Site";
						if (testStatus == "PASSED") {
							visibilityStatus = objOptinPIN_Main.verifyRideDetailsUpcomingTabAffiliate(visibilityStatus,
									tripID);
							if (visibilityStatus.booleanValue() == true) {
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
								objOptinPIN_Main.clickSigninButtonAffiliate();
								objTestBase.defaultWaitTime(3000);
								driver.navigate().refresh();
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
			// Verify Form-out functionality from Dispatch Site & Affiliate - END:
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Concierge.Profile")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objOptinPIN_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
		System.out.println("Capture Ride Booking Ids from Concierge: " + rideBookingIdsConcierge);
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
			System.out.println(
					"DEV_TC_1126: Capture Ride Booking Ids from Concierge = " + "Concierge Company Created Data = "
							+ rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - " + entry.getValue());
			utillLogger.info(
					"DEV_TC_1126: Capture Ride Booking Ids from Concierge = " + "Concierge Company Created Data = "
							+ rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - " + entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");

		// Clear the RideBooking IDs data from rideBookingIdsConcierge:
		rideBookingIdsConcierge.clear();
	}
}
