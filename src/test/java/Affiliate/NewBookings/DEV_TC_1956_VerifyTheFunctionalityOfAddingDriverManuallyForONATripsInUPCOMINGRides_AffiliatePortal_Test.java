package Affiliate.NewBookings;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1956_VerifyTheFunctionalityOfAddingDriverManuallyForONATripsInUPCOMINGRides_AffiliatePortal_Test
		extends TestBase {

	String currURL;
	String screenshotPath;
	String expected;
	String userName;
	String testStep;
	String testStatus;
	String scenario;
	WebElement element;
	Actions action;
	Boolean visibilityStatus;
	String exception = "";
	String tripID;

	DEV_TC_1956_VerifyTheFunctionalityOfAddingDriverManuallyForONATripsInUPCOMINGRides_AffiliatePortal_Main objVerifySighninMain;
	DEV_TC_1956_VerifyTheFunctionalityOfAddingDriverManuallyForONATripsInUPCOMINGRides_AffiliatePortal_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Affiliate.NewBookings")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Affiliate.NewBookings")
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1956_VerifyTheFunctionalityOfAddingDriverManuallyForONATripsInUPCOMINGRides_AffiliatePortal_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1956_VerifyTheFunctionalityOfAddingDriverManuallyForONATripsInUPCOMINGRides_AffiliatePortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			// Book a ride and capture the TripID from Dispatch
			tripID = verificationOfNewBookingFromDispatchSite(tripID);
			// -----------------------------------------------------------------------------------

			// Farm-out the created TripID:
			visibilityStatus = false;
			if (tripID != null)
				visibilityStatus = objVerifySighninMain.farmOutTripIDDispatch(visibilityStatus, tripID);

			System.out.println("TripID after Farm-out completed - " + tripID);
			if (visibilityStatus == true) {
				driver.get(prop.getProperty("affiliateURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(2000);

				currURL = driver.getCurrentUrl();
				testStep = "Verification of Affiliate Portal Loginpage ";

				if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				if (testStatus == "PASSED") {
					testStatus = " ";
					objVerifySighninMain.eMailInput();
					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.passwordInput();
					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.eyeIconClick();
					objTestBase.defaultWaitTime(1000);

					visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							browserStackTestStatusUpdate("passed", testStep);
						objVerifySighninMain.clickSigninButton();
						objTestBase.defaultWaitTime(3000);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						else
							browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					objVerifySighninMain.clickOnRides();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of affiliate Portal Login With Valid Credentials";
					visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						else
							browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					objTestBase.defaultWaitTime(3000);
					testStep = "Verification of AVAILABLE RIDEs Page Navigation from affiliate Portal";
					visibilityStatus = objVerifySighninMain.verifyNavigationOfAvailableRidesTab(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						else
							browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					if (tripID != null) {
						objTestBase.defaultWaitTime(3000);
						testStep = "Verification of Search TripID from affiliate Portal - AVAILABLE Page.?";
						visibilityStatus = objVerifySighninMain.searchTripID(visibilityStatus, tripID);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);

						testStep = "Verification of Claim Ride Details Popup Confimation message displayed.?";
						visibilityStatus = objVerifySighninMain.verifyClaimRideDetailsPopup(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);

						testStep = "Verification of Claim Ride Details Popup Confimation message displayed.?";
						visibilityStatus = objVerifySighninMain.verifyClaimRideDetailsPopup(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);

						testStep = "Verification of Ride Cliamed Successfully Confirmation Message displayed.?";
						visibilityStatus = objVerifySighninMain.verifyRideClaimedConfirmationMsg(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
						utillLogger.info("## DEV_TC_1956 - Claimed Ride - TripID = " + tripID);
						System.out.println("## DEV_TC_1956 - Claimed Ride - TripID = " + tripID);
					}
				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	public String verificationOfNewBookingFromDispatchSite(String tripID) throws Exception {
		try {
			action = new Actions(driver);
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Homepage Launch";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// ----------------------------------------------------------------------
			testStep = "Verify the entered Dispatch User Logins";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.dispatcheMailInput();
				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.dispatchpasswordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.dispatcheyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.dispatchvisibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					objVerifySighninMain.dispatchlickonSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifySighninMain.dispatchvisibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of Dispatch user LoggedIn Successfully.?";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			scenario = "Book Sedan";
			tripID = dispatchVechileBooking(scenario, tripID);
			System.out.println(tripID);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			visibilityStatus = false;
		}
		return tripID;
	}

	public String dispatchVechileBooking(String scenario, String tripID) throws Exception {
		try {
			testStep = "Visibility of New Booking Tab Loaded";
			visibilityStatus = objVerifySighninMain.dispatchvisibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				objTestBase.defaultWaitTime(1000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			objVerifySighninMain.dispatchaddFromAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.dispatchaddToAddress();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.dispatchclickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.dispatchaddExtraStop();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.dispatchenterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.dispatchclickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifySighninMain.dispatchvisibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			objVerifySighninMain.dispatchclickOnSedan();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.dispatchsearchBookingUserName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.dispatchclickcheckbox();
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.dispatchclickOnAddSecondaryPassengerDetails();
			objTestBase.defaultWaitTime(1000);

			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifySighninMain.dispatchenterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.dispatchenterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifySighninMain.dispatchenterspEmail();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.dispatchaddAirline();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.dispatchenterFlightNumber();
			objTestBase.defaultWaitTime(1000);
			objVerifySighninMain.dispatchenterPassengerNotes();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)", "");
			objTestBase.defaultWaitTime(3000);

			clickOnCardOption();
			objTestBase.defaultWaitTime(3000);

			objVerifySighninMain.dispatchenterPaymentInformation();
			objTestBase.defaultWaitTime(2000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			objTestBase.defaultWaitTime(2000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of " + scenario + " Ride Booking Details Page";
			visibilityStatus = objVerifySighninMain.dispatchverifyConfirmBookingBtnVisibility(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
			}

			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objTestBase.defaultWaitTime(2000);
				objVerifySighninMain.dispatchclickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
				visibilityStatus = objVerifySighninMain.dispatchverifyRideBookingConfirmation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.dispatchclickRidesSection();
				objTestBase.defaultWaitTime(6000);

				if (testStatus == "PASSED") {
					// Capture the Ride Booking IDs:
					tripID = objVerifySighninMain.dispatchcaptureRideBookingIDs(visibilityStatus, scenario, tripID);
					testStep = "Verification of Capturing the Ride ID for " + scenario + " - Trip ID = " + tripID;
					if (tripID != "")
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							browserStackTestStatusUpdate("passed", testStep);
					else if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
				} else if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
			}
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-3000)", "");
			objTestBase.defaultWaitTime(1000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return tripID;
	}

	@AfterClass(groups = "Affiliate.NewBookings")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
