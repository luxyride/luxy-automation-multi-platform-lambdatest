package Concierge.EditRideFunctionality;

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

public class DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Test extends TestBase {

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
	int timeMinutes;
	Map<String, Integer> timeHours;
	Boolean lessThan24hrs;
	UpdateExtentReportResults objupdateResults;
	DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Main objVerifyEditRides_Main;
	DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Test objVerifyEditRides_Test;

	@BeforeClass(groups = "Concierge.EditRideFunctionality")
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

	@Test(groups = "Concierge.EditRideFunctionality")
	public void verifyDisplayingreasonsForCancellationRidesInCancellationDropdown() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyEditRides_Main = new DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Main(
					driver);
			objVerifyEditRides_Test = new DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyEditRides_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyEditRides_Test.getClass().getSimpleName()
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
				objVerifyEditRides_Main.eMailInput();
				objVerifyEditRides_Main.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRides_Main.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyEditRides_Main.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyEditRides_Main.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyEditRides_Main.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Concierge Portal Login With Valid Credentials";
				visibilityStatus = objVerifyEditRides_Main.visibilityOfLoggedinUser(visibilityStatus);
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

			// Verification of Ride Booking Details:
			scenario = "Book a Ride";
			tripID = vechileBooking(scenario, testStatus, tripID);
			System.out.println("Trip ID = " + tripID);

			if (!tripID.isEmpty()) {
				testStep = "Verification of Rides All Page loaded.?";
				visibilityStatus = objVerifyEditRides_Main.visibilityOfRidesAllPage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(6000);
				objVerifyEditRides_Main.searchRideId(tripID);
				objTestBase.defaultWaitTime(6000);

				// Validate the TripID Details:
				testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for - Trip ID: " + tripID;
				visibilityStatus = objVerifyEditRides_Main.validateTripIDDetails(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				if (testStatus == "PASSED") {
					objVerifyEditRides_Main.clickonEDITRideBtn();
					objTestBase.defaultWaitTime(1000);

					testStep = "Verify the EDIT Ride Details Page";
					visibilityStatus = objVerifyEditRides_Main.validateEDITRideBookingPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					if (testStatus == "PASSED") {
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);

						// Positive Scenario:
						testStep = "// Positive Scenario: Verify ride booking when hours >= configured buffer time and miles <= configured miles. - Before Enabling DO NOT SERVE";
						objTestBase.defaultWaitTime(1000);
						objVerifyEditRides_Main.addFromAddress("editRide");
						objTestBase.defaultWaitTime(3000);
						objVerifyEditRides_Main.addToAddress("positiveFlow");
						objTestBase.defaultWaitTime(3000);
						objVerifyEditRides_Main.editDate(true, false);
						objTestBase.defaultWaitTime(2000);

						timeHours = objVerifyEditRides_Main.editTime("positivescenario", true, timeHours);
						objTestBase.defaultWaitTime(2000);

						objTestBase.defaultWaitTime(1000);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,300)", "");
						objTestBase.defaultWaitTime(2000);

						objVerifyEditRides_Main.addAirline();
						objTestBase.defaultWaitTime(1000);
						objVerifyEditRides_Main.enterFlightNumber();
						objTestBase.defaultWaitTime(1000);
						objVerifyEditRides_Main.enterPassengerNotes();

						js.executeScript("window.scrollBy(0,-300)", "");
						objTestBase.defaultWaitTime(2000);

						timeMinutes = objVerifyEditRides_Main.enterTimeMinutes(timeMinutes);
						objTestBase.defaultWaitTime(2000);

						objVerifyEditRides_Main.clickOngetQuote();
						objTestBase.defaultWaitTime(3000);
						objVerifyEditRides_Main.clickOnSedan();
						objTestBase.defaultWaitTime(2000);
						js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,3500)", "");
						objVerifyEditRides_Main.clickOnUpdateBtn();
						objTestBase.defaultWaitTime(1000);
						testStep = "Verification of SEDAN Ride Update Confirmation Message for Trip ID = " + tripID;
						visibilityStatus = objVerifyEditRides_Main.verifyRideBookingConfirmation(visibilityStatus);
						objTestBase.defaultWaitTime(2000);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							objTestBase.defaultWaitTime(1000);
						} else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);
						System.out.println("Trip ID = " + tripID);
						objVerifyEditRides_Main.clickRidesSection();
						objTestBase.defaultWaitTime(3000);
						testStep = "Verification of Rides All Page loaded.?";
						visibilityStatus = objVerifyEditRides_Main.visibilityOfRidesAllPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						driver.navigate().refresh();
						objTestBase.defaultWaitTime(6000);
						objVerifyEditRides_Main.searchRideId(tripID);
						objTestBase.defaultWaitTime(6000);

						// Validate the TripID Details:
						testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for - Trip ID: " + tripID;
						visibilityStatus = objVerifyEditRides_Main.validateTripIDDetails(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						}

						objVerifyEditRides_Main.clickonEDITRideBtn();
						objTestBase.defaultWaitTime(1000);

						testStep = "Verify the EDIT Ride Details Page";
						visibilityStatus = objVerifyEditRides_Main.validateEDITRideBookingPage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);

						// Positive Scenario:
						testStep = "// Positive Scenario: Verify ride booking when hours >= configured buffer time and miles <= configured miles. - Before Enabling DO NOT SERVE";
						objTestBase.defaultWaitTime(1000);
						objVerifyEditRides_Main.addFromAddress("editRide");
						objTestBase.defaultWaitTime(3000);
						objVerifyEditRides_Main.addToAddress("positiveFlow");
						objTestBase.defaultWaitTime(3000);
						objVerifyEditRides_Main.editDate(true, false);
						objTestBase.defaultWaitTime(2000);

						timeHours = objVerifyEditRides_Main.editTime("positivescenario", true, timeHours);
						objTestBase.defaultWaitTime(2000);
						timeMinutes = objVerifyEditRides_Main.editTimeMinutes(timeMinutes);
						objTestBase.defaultWaitTime(2000);
						objVerifyEditRides_Main.clickOngetQuote();
						objTestBase.defaultWaitTime(3000);
						visibilityStatus = objVerifyEditRides_Main.verifyVisibilityOfWarningMsg("positiveFlow",
								visibilityStatus);
						objTestBase.defaultWaitTime(2000);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							visibilityStatus = false;
							driver.navigate().refresh();
						}

					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

				} else {
					testStep = "EDIT Ride Details Validation";
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				}
			} else {
				testStep = "Cancel Rides Skipped due to EMPTY Rides Captured from DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Test";
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
			objVerifyEditRides_Main.clickRidesSection();
			objTestBase.defaultWaitTime(3000);
			visibilityStatus = objVerifyEditRides_Main.visibilityOfRidesAllPage(visibilityStatus);
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	public String vechileBooking(String scenario, String testStatus, String tripID) throws Exception {
		try {
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifyEditRides_Main.visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				objVerifyEditRides_Main.clickNewBooking();
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifyEditRides_Main.addFromAddress("bookRide");
			objTestBase.defaultWaitTime(2000);
			objVerifyEditRides_Main.addToAddress("bookRide");
			objTestBase.defaultWaitTime(2000);
			objVerifyEditRides_Main.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyEditRides_Main.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyEditRides_Main.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			objVerifyEditRides_Main.clickOnSedan();
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");

			objVerifyEditRides_Main.enterFirstName();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyEditRides_Main.addAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifyEditRides_Main.enterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifyEditRides_Main.enterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);
			
			clickOnCardOption();
			objTestBase.defaultWaitTime(2000);

			objVerifyEditRides_Main.enterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifyEditRides_Main.verifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifyEditRides_Main.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifyEditRides_Main.verifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyEditRides_Main.clickRidesSection();
				objTestBase.defaultWaitTime(2000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifyEditRides_Main.captureRideBookingIDs(visibilityStatus, scenario, tripID);
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
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return tripID;
	}

	@AfterClass(groups = "Concierge.EditRideFunctionality")
	public void afterClass() {
		driver.quit();
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIdsConcierge.entrySet()) {
			System.out.println(
					"EditRideFunctionality Ride IDs from TC: DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
			utillLogger.info(
					"EditRideFunctionality Ride IDs from TC: DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Test = "
							+ "Total TripIDs = " + rideBookingIdsConcierge.size() + " - " + entry.getKey() + " - "
							+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditRides_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}