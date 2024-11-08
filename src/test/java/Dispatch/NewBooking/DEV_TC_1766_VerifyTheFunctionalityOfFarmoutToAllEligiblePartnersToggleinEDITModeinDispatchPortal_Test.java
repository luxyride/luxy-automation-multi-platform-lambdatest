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

public class DEV_TC_1766_VerifyTheFunctionalityOfFarmoutToAllEligiblePartnersToggleinEDITModeinDispatchPortal_Test
		extends TestBase {
	String currURL;
	String screenshotPath;
	Actions action;
	String testStep;
	String testStatus;
	WebElement element;
	Boolean visibilityStatus;
	String exception = "";
	JavascriptExecutor js;
	String claimRideHoursBeforeUpdate;
	String claimRideHoursAfterUpdate;

	DEV_TC_1766_VerifyTheFunctionalityOfFarmoutToAllEligiblePartnersToggleinEDITModeinDispatchPortal_Main objVerifyEditDetails_Main;
	DEV_TC_1766_VerifyTheFunctionalityOfFarmoutToAllEligiblePartnersToggleinEDITModeinDispatchPortal_Test objVerifyEditDetails_Test;
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
		int indexCount = 1;
		try {
			action = new Actions(driver);
			objVerifyEditDetails_Main = new DEV_TC_1766_VerifyTheFunctionalityOfFarmoutToAllEligiblePartnersToggleinEDITModeinDispatchPortal_Main(
					driver);
			objVerifyEditDetails_Test = new DEV_TC_1766_VerifyTheFunctionalityOfFarmoutToAllEligiblePartnersToggleinEDITModeinDispatchPortal_Test();
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
						browserStackTestStatusUpdate("passed", testStep);
					objVerifyEditDetails_Main.clickSigninButton();
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

				objVerifyEditDetails_Main.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfLoggedinUser(visibilityStatus);
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

			if (tripIDFarmoutScenario != null) {
				objVerifyEditDetails_Main.clickNewBooking();
				objTestBase.defaultWaitTime(2000);
				objVerifyEditDetails_Main.clickRidesSection();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Rides All Page loaded for SEDAN - Trip ID: " + tripIDFarmoutScenario
						+ " - Before Update";
				visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
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

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				objVerifyEditDetails_Main.searchRideId(tripIDFarmoutScenario);
				objTestBase.defaultWaitTime(5000);

				// Validate the tripIDFarmoutScenario Details:
//				testStep = "Verify the RideStatus, PassengerName & Ride Booked Date for SEDAN - Trip ID: "
//						+ tripIDFarmoutScenario + " - Before Update";
//				visibilityStatus = objVerifyEditDetails_Main.validateTripIDDetails(visibilityStatus);
//				if (visibilityStatus.booleanValue() == true) {
//					if (localExecutionFlag == true)
//						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
//					else
//						browserStackTestStatusUpdate("passed", testStep);
//					testStatus = "PASSED";
//				} else {
//					if (localExecutionFlag == true)
//						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
//					else
//						browserStackTestStatusUpdate("failed", testStep);
//					testStatus = "FAILED";
//				}

				testStep = "Validate EDIT Ride for SEDAN - Trip ID: " + tripIDFarmoutScenario;
				if (testStatus == "PASSED") {
					objVerifyEditDetails_Main.editRideDetails();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Edit Ride Booking for SEDAN- Trip ID: " + tripIDFarmoutScenario
							+ " - Before Update";
					visibilityStatus = objVerifyEditDetails_Main.verifyEDITRideDetailsPage(visibilityStatus);
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
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
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

						testStep = "Verify Capturing the Claim Ride Hours Details - Before Update";
						claimRideHoursBeforeUpdate = objVerifyEditDetails_Main
								.captureFarmoutPreferencesClaimRideHoursBeforeUpdate(claimRideHoursBeforeUpdate);
						if (claimRideHoursBeforeUpdate != "" || claimRideHoursBeforeUpdate != null) {
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

						testStep = "Verification of updating Claims Ride Within hours";
						claimRideHoursAfterUpdate = objVerifyEditDetails_Main
								.updateFarmoutPreferencesClaimRideHours(claimRideHoursAfterUpdate);
						if (claimRideHoursAfterUpdate != "" || claimRideHoursAfterUpdate != null) {
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
					}

					visibilityStatus = objVerifyEditDetails_Main.visibilityOfUpdateRideBtn(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						testStep = "Verify visibility of Update Ride Button";
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						objTestBase.defaultWaitTime(1000);
						// Prod Restriction:
						if (!environmentCode.equalsIgnoreCase("prod")) {
							objTestBase.defaultWaitTime(1000);
							objVerifyEditDetails_Main.clickonUpdateRideBtn();
							testStep = "Verification of SEDAN Ride Update Booking Confirmation Message for TripID = "
									+ tripIDFarmoutScenario;
							visibilityStatus = objVerifyEditDetails_Main
									.verifyRideBookingConfirmation(visibilityStatus);
							objTestBase.defaultWaitTime(2000);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
							}
						}
					} else {
						
						clickOnCardOption();
						objTestBase.defaultWaitTime(3000);
						
						objVerifyEditDetails_Main.enterPaymentInformation();
						objTestBase.defaultWaitTime(2000);

						utillLogger.info(testStep + " - " + testStatus);
						testStep = "Verification of SEDAN Ride Booking Payment Update for TripID = "
								+ tripIDFarmoutScenario;
						visibilityStatus = objVerifyEditDetails_Main.visibilitofUpdatePaymentBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
						}

						// Prod Restriction:
						if (!environmentCode.equalsIgnoreCase("prod")) {
							objTestBase.defaultWaitTime(1000);
							objVerifyEditDetails_Main.clickonPaynowBtn();
							testStep = "Verification of SEDAN Ride Update Booking Confirmation Message for TripID = "
									+ tripIDFarmoutScenario;
							visibilityStatus = objVerifyEditDetails_Main
									.verifyRideBookingConfirmation(visibilityStatus);
							objTestBase.defaultWaitTime(2000);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
							}
						}
					}

					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,-3000)", "");
					objTestBase.defaultWaitTime(1000);

					if (tripIDFarmoutScenario != null) {
						objVerifyEditDetails_Main.clickNewBooking();
						objTestBase.defaultWaitTime(2000);
						objVerifyEditDetails_Main.clickRidesSection();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of Rides All Page loaded for SEDAN - Trip ID: " + tripIDFarmoutScenario
								+ " - Before Update";
						visibilityStatus = objVerifyEditDetails_Main.visibilityOfRidesAllPage(visibilityStatus);
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

						driver.navigate().refresh();
						objTestBase.defaultWaitTime(3000);

						objVerifyEditDetails_Main.searchRideId(tripIDFarmoutScenario);
						objTestBase.defaultWaitTime(1000);

						objVerifyEditDetails_Main.editRideDetails();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verificatin of Farmout details of SEDAN in EDIT View - Trip ID: "
								+ tripIDFarmoutScenario + " - After Update";
						visibilityStatus = objVerifyEditDetails_Main.verifyFarmoutDetailsInEDITView(visibilityStatus,
								claimRideHoursBeforeUpdate);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
						}

					}
				}
			} else {
				testStep = "EDIT Rides Skipped due to EMPTY Rides Captured from DEV_TC_1766_VerifyTheFunctionalityOfFarmoutToAllEligiblePartnersToggleinEDITModeinDispatchPortal_Test";
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "FAILED";
			}
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
			utillLogger.info(testStep + " - " + testStatus);
		}
	}

	@AfterClass(groups = "Dispatch.NewBooking")
	public void afterClass() {
		driver.quit();
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyEditDetails_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
