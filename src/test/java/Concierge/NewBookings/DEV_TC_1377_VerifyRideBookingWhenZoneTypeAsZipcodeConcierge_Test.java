package Concierge.NewBookings;

import java.util.Map;
import common.TestBase;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1377_VerifyRideBookingWhenZoneTypeAsZipcodeConcierge_Test extends TestBase {

	String tripID;
	String currURL;
	Actions action;
	String testStep;
	String scenario;
	String testStatus;
	WebElement element;
	TestBase objTestBase;
	String screenshotPath;
	String exception = "";
	JavascriptExecutor js;
	Boolean visibilityStatus;
	String expected;
	String userName;
	int vechilesCount = 0;
	String donotServeStatus;
	String captureSKUNumber;
	Boolean todaysFlag;
	Map<String, Integer> timeHours;
	Boolean enableDONOTSERVE = false;
	Boolean lessThan24hrs;
	UpdateExtentReportResults objupdateResults;
	DEV_TC_1377_VerifyRideBookingWhenZoneTypeAsZipcodeConcierge_Main objVerifyEditRidesZone_Main;
	DEV_TC_1377_VerifyRideBookingWhenZoneTypeAsZipcodeConcierge_Test objVerifyEditRidesZone_Test;

	@BeforeClass(groups = "Concierge.NewBookings")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			timeHours = new HashMap<String, Integer>();
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

	@Test(groups = "Concierge.NewBookings")
	public void verifyRideEditWhenZoneTypeAsState() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyEditRidesZone_Main = new DEV_TC_1377_VerifyRideBookingWhenZoneTypeAsZipcodeConcierge_Main(driver);
			objVerifyEditRidesZone_Test = new DEV_TC_1377_VerifyRideBookingWhenZoneTypeAsZipcodeConcierge_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyEditRidesZone_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyEditRidesZone_Test.getClass().getSimpleName()
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
				objVerifyEditRidesZone_Main.eMailInput();
				objVerifyEditRidesZone_Main.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRidesZone_Main.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyEditRidesZone_Main.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyEditRidesZone_Main.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Concierge Portal Login With Valid Credentials";
				visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfLoggedinUser(visibilityStatus);
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

			// Verification of BufferTime Scenarios Validations - START:
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifyEditRidesZone_Main.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRidesZone_Main.clickNewBooking();
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				// Negative Scenario-1:
				testStep = "Negative Scenario-1: Verify Warning message display when the ride booking hours < configured buffer time and miles <= configured miles.";
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRidesZone_Main.addFromAddress();
				objTestBase.defaultWaitTime(2000);
				scenario = "lessthanConfigMiles";
				objVerifyEditRidesZone_Main.addToAddress(scenario);
				objTestBase.defaultWaitTime(3000);
				objVerifyEditRidesZone_Main.enterDate(true, false);
				objTestBase.defaultWaitTime(2000);

				scenario = "lessthanBufferTime";
				lessThan24hrs = false;
				timeHours = objVerifyEditRidesZone_Main.enterTime(scenario, lessThan24hrs, timeHours);
				objTestBase.defaultWaitTime(2000);

				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
						"- ActualTimeHours = " + timeHours.get("ActualTimeHours").toString()
								+ " - ConfiguredTimeHours = " + timeHours.get("ConfiguredTimeHours").toString());
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyEditRidesZone_Main.verifyVisibilityOfWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.clickOnCancel();
					objTestBase.defaultWaitTime(1000);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}

				// Negative Scenario-2:
				testStep = "Negative Scenario-2: Verify Warning message display when the ride booking hours >= configured buffer time and upto 24 hours and miles > configured miles.";
				scenario = "greaterthanConfigMilesNegative";
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRidesZone_Main.addFromAddress();
				objTestBase.defaultWaitTime(2000);
				objVerifyEditRidesZone_Main.addToAddress(scenario);
				objTestBase.defaultWaitTime(3000);
				objVerifyEditRidesZone_Main.enterDate(true, false);
				objTestBase.defaultWaitTime(2000);
				scenario = "greaterthanBufferTime";
				lessThan24hrs = false;
				timeHours = objVerifyEditRidesZone_Main.enterTime(scenario, lessThan24hrs, timeHours);
				objTestBase.defaultWaitTime(2000);

				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
						"- ActualTimeHours = " + timeHours.get("ActualTimeHours").toString()
								+ " - ConfiguredTimeHours = " + timeHours.get("ConfiguredTimeHours").toString());

				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyEditRidesZone_Main.verifyVisibilityOfWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.clickOnCancel();
					objTestBase.defaultWaitTime(1000);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}

				// Negative Scenario-3:
				testStep = "Negative Scenario-3: Verify Warning message display when the ride booking hours < configured buffer time and miles > configured miles.";
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRidesZone_Main.addFromAddress();
				objTestBase.defaultWaitTime(2000);
				scenario = "greaterthanConfigMilesNegative";
				objVerifyEditRidesZone_Main.addToAddress(scenario);
				objTestBase.defaultWaitTime(3000);
				objVerifyEditRidesZone_Main.enterDate(true, false);
				objTestBase.defaultWaitTime(2000);
				scenario = "lessthanBufferTime";
				lessThan24hrs = false;
				timeHours = objVerifyEditRidesZone_Main.enterTime(scenario, lessThan24hrs, timeHours);
				objTestBase.defaultWaitTime(2000);

				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
						"- ActualTimeHours = " + timeHours.get("ActualTimeHours").toString()
								+ " - ConfiguredTimeHours = " + timeHours.get("ConfiguredTimeHours").toString());
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyEditRidesZone_Main.verifyVisibilityOfWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.clickOnCancel();
					objTestBase.defaultWaitTime(1000);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}

				// Positive Scenario:
				testStep = "// Positive Scenario: Verify ride booking when hours >= configured buffer time and miles <= configured miles. - Before Enabling DO NOT SERVE";
				visibilityStatus = objVerifyEditRidesZone_Main.visibilitOfNewBookingTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(1000);
					objVerifyEditRidesZone_Main.clickNewBooking();
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyEditRidesZone_Main.addFromAddress();
				objTestBase.defaultWaitTime(2000);
				scenario = "positivescenario";
				objVerifyEditRidesZone_Main.addToAddress(scenario);
				objTestBase.defaultWaitTime(2000);
				objVerifyEditRidesZone_Main.enterDate(false, false);
				objTestBase.defaultWaitTime(2000);
				objVerifyEditRidesZone_Main.clickOngetQuote();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verify list of available vechiles";
				visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfVechileSection(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					visibilityStatus = true;
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
				}

				objVerifyEditRidesZone_Main.clickOnSedan();
				objTestBase.defaultWaitTime(3000);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)", "");

				objVerifyEditRidesZone_Main.enterFirstName();
				objTestBase.defaultWaitTime(1000);

				objTestBase.defaultWaitTime(1000);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)", "");
				objTestBase.defaultWaitTime(2000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)", "");
				objTestBase.defaultWaitTime(2000);
				
				clickOnCardOption();
				objTestBase.defaultWaitTime(2000);

				objVerifyEditRidesZone_Main.enterPaymentInformation();
				objTestBase.defaultWaitTime(2000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)", "");
				objTestBase.defaultWaitTime(2000);

				utillLogger.info(testStep + " - " + testStatus);
				testStep = "Verification of " + scenario + " Ride Booking Details Page";
				visibilityStatus = objVerifyEditRidesZone_Main.verifyConfirmBookingBtnVisibility(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				}

				// Prod Restriction:
				if (!environmentCode.equalsIgnoreCase("prod")) {
					objTestBase.defaultWaitTime(2000);
					objVerifyEditRidesZone_Main.clickonConfirmBooking();
					objTestBase.defaultWaitTime(2000);

					testStep = "Verification of Ride Booking Confirmation Message";
					visibilityStatus = objVerifyEditRidesZone_Main.verifyRideBookingConfirmation(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.clickRidesSection();
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
						// Capture the Ride Booking IDs:
						tripID = objVerifyEditRidesZone_Main.captureRideBookingIDs(visibilityStatus, scenario, tripID);
						System.out.println("Trip ID = " + tripID);
						testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
						if (tripID != null)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					} else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				}
				objTestBase.defaultWaitTime(2000);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-3000)", "");
				objTestBase.defaultWaitTime(1000);
				utillLogger.info(testStep + " - " + testStatus);

			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
			// Verification of BufferTime Scenarios Validations - END:

			// Validate DO NOT SERVE Functionality - START:
			testStep = "Verification of DO NOT SERVE Validations";
			if (testStatus == "PASSED" && !tripID.isEmpty() && !environmentCode.equalsIgnoreCase("prod")) {
				enableDONOTSERVE = true;
				if (!environmentCode.equalsIgnoreCase("prod"))	{	enableDONOTSERVE(enableDONOTSERVE);	}	 // Enable Do Not Serve:
				if (enableDONOTSERVE == true) {
					// Re-launch User Portal:
					donotServeStatus = "afterDONOTSERVEEnabled";
					driver.get(prop.getProperty("conciergeURL"));
					objTestBase.defaultWaitTime(3000);

					objVerifyEditRidesZone_Main.clickRidesSection();
					objTestBase.defaultWaitTime(3000);
					testStep = "Verification of Rides All Page loaded.? - After Do Not Serve Enabled";
					visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfRidesAllPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.clickNewBooking();
					objTestBase.defaultWaitTime(3000);

					// Positive Scenario:
					testStep = "// Positive Scenario: Verify ride booking when hours >= configured buffer time and miles <= configured miles. - After Do Not Serve Enabled";
					objTestBase.defaultWaitTime(1000);
					objVerifyEditRidesZone_Main.addFromAddress();
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.addToAddress("positivescenario");
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.editDate(false, false);
					objTestBase.defaultWaitTime(2000);
					objVerifyEditRidesZone_Main.clickOngetQuote();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verify DO NOT SERVE Error Message Displayed.? - " + donotServeStatus;
					visibilityStatus = objVerifyEditRidesZone_Main
							.verifyVisibilityOfDoNotServeWarningMsg(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						visibilityStatus = true;
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						visibilityStatus = false;
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(1000);
						testStatus = "FAILED";
					}

					// Reset the DO NOT SERVE Configuration:
					enableDONOTSERVE = false;
					if (!environmentCode.equalsIgnoreCase("prod"))	{	enableDONOTSERVE(enableDONOTSERVE);	}	 // Disable Do Not Serve:
					// Re-launch User Portal:
					donotServeStatus = "afterDONOTSERVEDisabled";
					driver.get(prop.getProperty("conciergeURL"));
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.clickRidesSection();
					objTestBase.defaultWaitTime(3000);
					testStep = "Verification of Rides All Page loaded.? - After Do Not Serve Disabled";
					visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfRidesAllPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					driver.navigate().refresh();
					objTestBase.defaultWaitTime(6000);
					objVerifyEditRidesZone_Main.searchRideId(tripID);
					objTestBase.defaultWaitTime(6000);

					// Validate the TripID Details:
					testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for - Trip ID: " + tripID
							+ " - After Do Not Serve Disabled";
					visibilityStatus = objVerifyEditRidesZone_Main.validateTripIDDetails(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					}

					objVerifyEditRidesZone_Main.clickonEDITRideBtn();
					objTestBase.defaultWaitTime(1000);

					testStep = "Verify the EDIT Ride Details Page - After Do Not Serve Disabled";
					visibilityStatus = objVerifyEditRidesZone_Main.validateEDITRideBookingPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					// Positive Scenario:
					testStep = "// Positive Scenario: Verify ride booking when hours >= configured buffer time and miles <= configured miles. - After Do Not Serve Disabled";
					objTestBase.defaultWaitTime(1000);
					objVerifyEditRidesZone_Main.addFromAddress();
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.addToAddress("positivescenario");
					objTestBase.defaultWaitTime(3000);
					objVerifyEditRidesZone_Main.enterDate(false, false);
					objTestBase.defaultWaitTime(2000);
					objVerifyEditRidesZone_Main.clickOngetQuote();
					objTestBase.defaultWaitTime(3000);
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)", "");

					testStep = "Verify list of available vechiles - " + donotServeStatus;
					visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfListofVechiles(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						objTestBase.defaultWaitTime(1000);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,350)", "");
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						visibilityStatus = false;
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(1000);
						testStatus = "FAILED";
					}
				}

			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// Validate DO NOT SERVE Functionality - END:

			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (

		Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			objVerifyEditRidesZone_Main.clickRidesSection();
			objTestBase.defaultWaitTime(3000);
			visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfRidesAllPage(visibilityStatus);
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	private Boolean enableDONOTSERVE(Boolean enableStatus) {
		try {
			objTestBase.defaultWaitTime(1000);
			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Dispatch Site Login";
			if (enableStatus == true) {
				objVerifyEditRidesZone_Main.eMailDispatchInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRidesZone_Main.passwordDispatchInput();
				objTestBase.defaultWaitTime(1000);
				utillLogger.info(testStep + " - " + testStatus);
				visibilityStatus = objVerifyEditRidesZone_Main.dispatchVisibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyEditRidesZone_Main.dispatchclickonSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Site New Booking Page loaded.?";
				visibilityStatus = objVerifyEditRidesZone_Main.visibilityOfNewBookingPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				objVerifyEditRidesZone_Main.addDispatchFromAddress();
				objTestBase.defaultWaitTime(2000);
				objVerifyEditRidesZone_Main.addDispatchToAddress();
				objTestBase.defaultWaitTime(2000);
				objVerifyEditRidesZone_Main.dispatchenterDate();
				objTestBase.defaultWaitTime(2000);
				objVerifyEditRidesZone_Main.dipatchclickOngetQuote();
				objTestBase.defaultWaitTime(5000);

				testStep = "Verify list of available vechiles from Dispatch site";
				visibilityStatus = objVerifyEditRidesZone_Main.dispatchvisibilityOfVechileSection(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					visibilityStatus = true;

					objVerifyEditRidesZone_Main.dispatchclickonEDITVehicle();
					objTestBase.defaultWaitTime(3000);

					// Capture SKU NUMBER from Dispatch Site:
					visibilityStatus = objVerifyEditRidesZone_Main.switchToWindow(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					captureSKUNumber = objVerifyEditRidesZone_Main.captureSKUNumber(captureSKUNumber);
					System.out.println("SKU Number = " + captureSKUNumber);
					testStep = "Verify EDIT Service Rates Page loaded from Dispatch site and Capture the SKU Number = "
							+ captureSKUNumber;
					if (!captureSKUNumber.isEmpty() || captureSKUNumber != null) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						utillLogger.info(objVerifyEditRidesZone_Main.getClass().getSimpleName() + " - " + testStep
								+ " - SKU NUMBER = " + captureSKUNumber);
						enableStatus = true;
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						utillLogger.info(objVerifyEditRidesZone_Main.getClass().getSimpleName() + " - " + testStep
								+ " - SKU NUMBER = " + captureSKUNumber);
						enableStatus = false;
					}
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					enableStatus = false;
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}
			} else {
				objVerifyEditRidesZone_Main.dispatchclickPricingSection();
				objTestBase.defaultWaitTime(1000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)", "");

				testStep = "Verification of Pricing ServiceRate Page loaded while disabling DO NOT SERVE - SKU NUMBER = "
						+ captureSKUNumber;
				visibilityStatus = objVerifyEditRidesZone_Main.dispatchvisibilityOfServiceRateTabPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				captureSKUNumber = objVerifyEditRidesZone_Main.dispatchSKUNumberSearch(captureSKUNumber);
				System.out.println("SKU Number = " + captureSKUNumber);
				testStep = "Verification of SKU Number Search from Dispatch Site - SKU Number = " + captureSKUNumber;
				if (!captureSKUNumber.isEmpty() || captureSKUNumber != null) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					utillLogger.info(objVerifyEditRidesZone_Main.getClass().getSimpleName() + " - " + testStep
							+ " - SKU NUMBER = " + captureSKUNumber);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					utillLogger.info(objVerifyEditRidesZone_Main.getClass().getSimpleName() + " - " + testStep
							+ " - SKU NUMBER = " + captureSKUNumber);
				}

				testStep = "Verification of EDIT button visibility of SKU NUMBER = " + captureSKUNumber;
				visibilityStatus = objVerifyEditRidesZone_Main.dipatchclickOnEDITButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyEditRidesZone_Main.dispatchupdateDONOTSERVE(enableStatus);
			objTestBase.defaultWaitTime(2000);
			objVerifyEditRidesZone_Main.dipatchclickOnUpdateButton();
			objTestBase.defaultWaitTime(500);

			testStep = "Verify DO NOT SERVE UPDATE Confirmation message displayed for SKU Number = " + captureSKUNumber;
			visibilityStatus = objVerifyEditRidesZone_Main.verifyDispatchDoNotServeUpdateConfirmation(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return enableStatus;
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
			System.out.println(
					"EditRideFunctionality Ride IDs from TC: DEV_TC_1377_VerifyRideBookingWhenZoneTypeAsZipcode_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
			utillLogger.info(
					"EditRideFunctionality Ride IDs from TC: DEV_TC_1377_VerifyRideBookingWhenZoneTypeAsZipcode_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditRidesZone_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
		if (!captureSKUNumber.isEmpty() || !captureSKUNumber.isEmpty()) {
			enableDONOTSERVE = false;
			if (!environmentCode.equalsIgnoreCase("prod"))	{	enableDONOTSERVE(enableDONOTSERVE);	}
		}
		driver.quit();
	}
}