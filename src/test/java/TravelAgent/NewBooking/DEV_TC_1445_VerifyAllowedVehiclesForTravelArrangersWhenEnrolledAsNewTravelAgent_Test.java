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

public class DEV_TC_1445_VerifyAllowedVehiclesForTravelArrangersWhenEnrolledAsNewTravelAgent_Test extends TestBase {

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
	String scenario;
	String tripID;

	DEV_TC_1445_VerifyAllowedVehiclesForTravelArrangersWhenEnrolledAsNewTravelAgent_Main objVerifyLogout_Main;
	DEV_TC_1445_VerifyAllowedVehiclesForTravelArrangersWhenEnrolledAsNewTravelAgent_Test objVerifyLogout_Test;
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
	public void VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyLogout_Main = new DEV_TC_1445_VerifyAllowedVehiclesForTravelArrangersWhenEnrolledAsNewTravelAgent_Main(
					driver);
			objVerifyLogout_Test = new DEV_TC_1445_VerifyAllowedVehiclesForTravelArrangersWhenEnrolledAsNewTravelAgent_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyLogout_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of entered User details from Login page";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.eMailInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.clickEyeIcon();

				visibilityStatus = objVerifyLogout_Main.visibilityOfsigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login";
				if (testStatus == "PASSED") {
					objTestBase.defaultWaitTime(2000);
					objVerifyLogout_Main.clickSignInButton();
					objTestBase.defaultWaitTime(3000);
					visibilityStatus = objVerifyLogout_Main.visibilityOfsigninUser(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
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

				objVerifyLogout_Main.clickonTravelArrangerTab();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verify Travel Arranger Page is loaded.?";
				visibilityStatus = objVerifyLogout_Main.verifyTravelArrangerPageLoaded(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyLogout_Main.clickEnrolledTa();
				objTestBase.defaultWaitTime(2000);

				testStep = "Unenroll if the Travel Arranger already Enrolled.";
				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyLogout_Main.unenrollTravelArrenger(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(5000);

				testStep = "Search Travel Arranger from Available Travel Arranger Tab.";
				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyLogout_Main.searchTravelArranger(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				testStep = "Verify Confirm Enrollment Popup displayed from manage Travel Arranger Page";
				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyLogout_Main.verifyConfirmEnrollementPopupDispay(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				testStep = "Verify SEDAN And SUV vehicles selection from manage Travel Arranger Page";
				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyLogout_Main.verifySedanSUVVehicleSelection(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				testStep = "Verify SEDAN And SUV vehicles enrolled confirmation message from manage Travel Arranger Page";
				if (testStatus == "PASSED") {
					visibilityStatus = objVerifyLogout_Main
							.verifyEnrollTravelArrangerConfirmationMsgDisplay(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				// Travel Agent Site Validations:
				testStep = "Verify SEDAN And SUV vehicles enrolled confirmation message from manage Travel Arranger Page";
				if (testStatus == "PASSED") {
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

					if (testStatus == "PASSED") {
						testStatus = " ";
						objTestBase.defaultWaitTime(1000);
						objVerifyLogout_Main.eMailInputTA();
						objTestBase.defaultWaitTime(1000);
						objVerifyLogout_Main.passwordInputTA();
						objTestBase.defaultWaitTime(1000);

						visibilityStatus = objVerifyLogout_Main.visibilityOfSigninButtonTA(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							objVerifyLogout_Main.clickSigninButtonTA();
							objTestBase.defaultWaitTime(3000);
							driver.navigate().refresh();
							objTestBase.defaultWaitTime(1000);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}

						objVerifyLogout_Main.clickNewBookingTA();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of TravelAgent Portal Login With Valid Credentials";
						visibilityStatus = objVerifyLogout_Main.visibilityOfLoggedinUserTA(visibilityStatus);
						if (visibilityStatus.booleanValue() == true)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						utillLogger.info(testStep + " - " + testStatus);

						testStep = "Verification of Selecting the Passenger Details from Search Passenger box";
						visibilityStatus = objVerifyLogout_Main.searchCoporateTA(visibilityStatus);
						if (visibilityStatus.booleanValue() == true)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						utillLogger.info(testStep + " - " + testStatus);

						scenario = "Book Sedan";
						testStatus = vechileBookingTA(scenario, testStatus);
					}
				}
			} else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	public String vechileBookingTA(String scenario, String testStatus) throws Exception {
		try {
			objTestBase.defaultWaitTime(3000);
			objVerifyLogout_Main.addFromAddressTA();
			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.addToAddressTA();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)", "");
			objVerifyLogout_Main.enterDateTA();
			objTestBase.defaultWaitTime(2000);
			objVerifyLogout_Main.clickOngetQuoteTA();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify list of available vechiles";
			visibilityStatus = objVerifyLogout_Main.visibilityOfVechileSectionTA(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

			testStep = "Verification of Popup message displayed for unenrolled vehicles selection";
			if (visibilityStatus.booleanValue() == true) {
				testStep = "Verify Popup message when user selects unavailable SUV-XL vechile";
				visibilityStatus = objVerifyLogout_Main.visibilityOfUnallowedVehiclesPopupMsg(visibilityStatus,
						"SUV-XL");
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					visibilityStatus = true;
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
				}

				testStep = "Verify Popup message when user selects unavailable VAN vechile";
				visibilityStatus = objVerifyLogout_Main.visibilityOfUnallowedVehiclesPopupMsg(visibilityStatus, "VAN");
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					visibilityStatus = true;
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
				}

				testStep = "Verify Popup message when user selects unavailable VAN-XL vechile";
				visibilityStatus = objVerifyLogout_Main.visibilityOfUnallowedVehiclesPopupMsg(visibilityStatus,
						"VAN-XL");
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					visibilityStatus = true;
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
				}

				objVerifyLogout_Main.clickOnSedanTA();
				objTestBase.defaultWaitTime(3000);
				js = (JavascriptExecutor) driver;
				

				objVerifyLogout_Main.enterFirstNameTA();
				objTestBase.defaultWaitTime(1000);

				objTestBase.defaultWaitTime(1000);
				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);

				objVerifyLogout_Main.addAirlineTA();
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.enterFlightNumberTA();
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.enterPassengerNotes();

				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);
				
				clickOnCardOption();
				objTestBase.defaultWaitTime(2000);

				objVerifyLogout_Main.enterPaymentInformationTA();
				objTestBase.defaultWaitTime(2000);

				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);

				utillLogger.info(testStep + " - " + testStatus);
				testStep = "Verification of " + scenario + " Ride Booking Details Page";
				visibilityStatus = objVerifyLogout_Main.verifyConfirmBookingBtnVisibilityTA(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				}

				// Prod Restriction:
				if (!environmentCode.equalsIgnoreCase("prod")) {
					objTestBase.defaultWaitTime(2000);
					objVerifyLogout_Main.clickonConfirmBooking();
					objTestBase.defaultWaitTime(2000);
					testStatus = "";
					testStep = "Verification of " + scenario + " Ride Booking Confirmation Message";
					visibilityStatus = objVerifyLogout_Main.verifyRideBookingConfirmationTA(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objTestBase.defaultWaitTime(3000);
					objVerifyLogout_Main.clickRidesSectionTA();
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
						// Capture the Ride Booking IDs:
						tripID = objVerifyLogout_Main.captureRideBookingIDsTA(visibilityStatus, scenario, tripID);
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
			} else
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
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
		utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
