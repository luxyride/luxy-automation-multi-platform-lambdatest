package UserPortal.NewBookings;

import java.util.Map;
import common.TestBase;
import java.util.HashMap;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Test
		extends TestBase {

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
	String donotServeStatus;
	String captureSKUNumber;
	Boolean todaysFlag;
	JavascriptExecutor js;
	Map<String, Integer> timeHours;
	Boolean enableDONOTSERVE = false;
	Boolean lessThan24hrs;

	DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Main objVerifyZoneTypeCityMain;
	DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Test objVerifyZoneTypeCityTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "UserPortal.NewBookings")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			timeHours = new HashMap<String, Integer>();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "UserPortal.NewBookings")
	public void verifyRideBookingWhenZoneTypeAsCity() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyZoneTypeCityMain = new DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Main(
					driver);
			objVerifyZoneTypeCityTest = new DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyZoneTypeCityTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyZoneTypeCityTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";
			System.out.println(prop.getProperty("environment"));
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
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

			// Method to close Pop-up Window:
			objTestBase.closePopupWindow();
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
				|| browserType.equalsIgnoreCase("chromeiOSMobileView")
				|| browserType.equalsIgnoreCase("chromeLocal")) {
					clickOnToggleNavigationBar();
			}
			
			testStep = "Verification user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				objVerifyZoneTypeCityMain.clickLogin();
				objTestBase.defaultWaitTime(2000);
				objVerifyZoneTypeCityMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyZoneTypeCityMain.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyZoneTypeCityMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyZoneTypeCityMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyZoneTypeCityMain.clickSigninButton();
					objTestBase.defaultWaitTime(5000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyZoneTypeCityMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of User Portal Login";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";

					donotServeStatus = "beforeDONOTSERVEEnabled";
					testStatus = vechileBooking(donotServeStatus);
					System.out.println("Test Status 'Before DO NOT SERVE Enabled' Scenarios compelted = " + testStatus);
					utillLogger.info("Test Status 'Before DO NOT SERVE Enabled' Scenarios compelted = " + testStatus);
					testStep = "Verification of vechileBooking Validations";
					if (testStatus == "PASSED") {
						if (!environmentCode.equalsIgnoreCase("prod")) {
							enableDONOTSERVE = true;
							if (!environmentCode.equalsIgnoreCase("prod")) {
								enableDONOTSERVE(enableDONOTSERVE);
							} // Enable Do Not Serve:

							if (enableDONOTSERVE == true) {
								// Re-launch User Portal:
								donotServeStatus = "afterDONOTSERVEEnabled";
								driver.get(prop.getProperty("portalURL"));
								objTestBase.defaultWaitTime(3000);
								
								// Method to close Pop-up Window:
								objTestBase.closePopupWindow();
								// Configuration for handing mobile simulator testing:
								if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
									|| browserType.equalsIgnoreCase("chromeiOSMobileView")
									|| browserType.equalsIgnoreCase("chromeLocal")) {
										clickOnToggleNavigationBar();
								}
								
								vechileBooking(donotServeStatus);

								enableDONOTSERVE = false;
								if (!environmentCode.equalsIgnoreCase("prod")) {
									enableDONOTSERVE(enableDONOTSERVE);
								} // Disable Do Not Serve:

								// Re-test if all Positive scenarios working as expected:
								// Re-launch User Portal:
								donotServeStatus = "afterDONOTSERVEDisabled";
								driver.get(prop.getProperty("portalURL"));
								objTestBase.defaultWaitTime(3000);
								
								// Method to close Pop-up Window:
								objTestBase.closePopupWindow();
								// Configuration for handing mobile simulator testing:
								if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
									|| browserType.equalsIgnoreCase("chromeiOSMobileView")
									|| browserType.equalsIgnoreCase("chromeLocal")) {
										clickOnToggleNavigationBar();
								}
								vechileBooking(donotServeStatus);
							}
						}
					} else {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						else
							lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
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
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
	}

	public String vechileBooking(String donotServeStatus) throws Exception {
		try {
			if (donotServeStatus == "beforeDONOTSERVEEnabled") {
				// Negative Scenario-1:
				testStep = "Negative Scenario-1: Verify Warning message display when the ride booking hours < configured buffer time and miles <= configured miles. - "
						+ donotServeStatus;
				objTestBase.defaultWaitTime(1000);
				objVerifyZoneTypeCityMain.addFromAddress();
				objTestBase.defaultWaitTime(3000);
				scenario = "lessthanConfigMiles";
				objVerifyZoneTypeCityMain.addToAddress(scenario);
				objTestBase.defaultWaitTime(3000);
				objVerifyZoneTypeCityMain.enterDate(true, false);
				objTestBase.defaultWaitTime(2000);

				scenario = "lessthanBufferTime";
				lessThan24hrs = false;
				timeHours = objVerifyZoneTypeCityMain.enterTime(scenario, lessThan24hrs, timeHours);
				objTestBase.defaultWaitTime(2000);

				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
						"- ActualTimeHours = " + timeHours.get("ActualTimeHours").toString()
								+ " - ConfiguredTimeHours = " + timeHours.get("ConfiguredTimeHours").toString());
				objTestBase.defaultWaitTime(1000);

				objVerifyZoneTypeCityMain.clickOngetQuote();
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = objVerifyZoneTypeCityMain.verifyVisibilityOfWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(3000);
					objVerifyZoneTypeCityMain.clickOnCancel();
					objTestBase.defaultWaitTime(1000);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}

				// Negative Scenario-2:
				testStep = "Negative Scenario-2: Verify Warning message display when the ride booking hours >= configured buffer time and upto 24 hours and miles > configured miles. - "
						+ donotServeStatus;
				scenario = "greaterthanConfigMilesNegative";
				objTestBase.defaultWaitTime(2000);
				objVerifyZoneTypeCityMain.addToAddress(scenario);
				objTestBase.defaultWaitTime(3000);
				scenario = "greaterthanBufferTime";
				lessThan24hrs = false;
				timeHours = objVerifyZoneTypeCityMain.enterTime(scenario, lessThan24hrs, timeHours);
				objTestBase.defaultWaitTime(2000);

				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
						"- ActualTimeHours = " + timeHours.get("ActualTimeHours").toString()
								+ " - ConfiguredTimeHours = " + timeHours.get("ConfiguredTimeHours").toString());

				objTestBase.defaultWaitTime(1000);
				objVerifyZoneTypeCityMain.clickOngetQuote();
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = objVerifyZoneTypeCityMain.verifyVisibilityOfWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(3000);
					objVerifyZoneTypeCityMain.clickOnCancel();
					objTestBase.defaultWaitTime(1000);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}

				// Negative Scenario-3:
				testStep = "Negative Scenario-3: Verify Warning message display when the ride booking hours < configured buffer time and miles > configured miles. - "
						+ donotServeStatus;
				objTestBase.defaultWaitTime(2000);
				scenario = "greaterthanConfigMilesNegative";
				objVerifyZoneTypeCityMain.addToAddress(scenario);
				objTestBase.defaultWaitTime(3000);
				scenario = "lessthanBufferTime";
				lessThan24hrs = false;
				timeHours = objVerifyZoneTypeCityMain.enterTime(scenario, lessThan24hrs, timeHours);
				objTestBase.defaultWaitTime(2000);

				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
						"- ActualTimeHours = " + timeHours.get("ActualTimeHours").toString()
								+ " - ConfiguredTimeHours = " + timeHours.get("ConfiguredTimeHours").toString());
				objTestBase.defaultWaitTime(1000);

				objVerifyZoneTypeCityMain.clickOngetQuote();
				objTestBase.defaultWaitTime(3000);

				visibilityStatus = objVerifyZoneTypeCityMain.verifyVisibilityOfWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(3000);
					objVerifyZoneTypeCityMain.clickOnCancel();
					objTestBase.defaultWaitTime(1000);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}

				// Positive Scenario-1:
				testStep = "// Positive Scenario-1: Verify ride booking when hours >= configured buffer time and miles <= configured miles. - "
						+ donotServeStatus;
				lessThan24hrs = true;
				scenario = "positivescenario";
				testStatus = verifyRideBooking(testStep, scenario, lessThan24hrs, donotServeStatus, testStatus);

				// Positive Scenario-2:
				testStep = "// Positive Scenario-2: Verify ride booking when hours > 24 hours. - " + donotServeStatus;
				lessThan24hrs = false;
				scenario = "positivescenario";
				testStatus = verifyRideBooking(testStep, scenario, lessThan24hrs, donotServeStatus, testStatus);
			} else if (donotServeStatus == "afterDONOTSERVEEnabled") {
				// Positive Scenario-2:
				testStep = "// Positive Scenario-2: Verify ride booking when hours > 24 hours. - " + donotServeStatus;
				lessThan24hrs = false;
				scenario = "positivescenario";
				testStatus = verifyRideBooking(testStep, scenario, lessThan24hrs, donotServeStatus, testStatus);
			} else {
				// Positive Scenario-2:
				testStep = "// Positive Scenario-2: Verify ride booking when hours > 24 hours. - " + donotServeStatus;
				lessThan24hrs = false;
				scenario = "positivescenario";
				testStatus = verifyRideBooking(testStep, scenario, lessThan24hrs, donotServeStatus, testStatus);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			testStatus = "FALIED";
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
		return testStatus;
	}

	private Boolean enableDONOTSERVE(Boolean enableStatus) throws Exception {
		try {
			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verification of Dispatch Site Login";
			if (enableStatus == true) {
				objVerifyZoneTypeCityMain.eMailDispatchInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyZoneTypeCityMain.passwordDispatchInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyZoneTypeCityMain.eyeIconDispatchClick();
				objTestBase.defaultWaitTime(1000);

				utillLogger.info(testStep + " - " + testStatus);
				visibilityStatus = objVerifyZoneTypeCityMain.visibilitydispatchOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyZoneTypeCityMain.clickdispatchSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Site New Booking Page loaded.?";
				visibilityStatus = objVerifyZoneTypeCityMain.visibilityOfNewBookingPage(visibilityStatus);
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
				objVerifyZoneTypeCityMain.addDispatchFromAddress();
				objTestBase.defaultWaitTime(2000);
				objVerifyZoneTypeCityMain.addDispatchToAddress();
				objTestBase.defaultWaitTime(2000);
				objVerifyZoneTypeCityMain.dispatchenterDate();
				objTestBase.defaultWaitTime(2000);
				objVerifyZoneTypeCityMain.dipatchclickOngetQuote();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verify list of available vechiles from Dispatch site";
				visibilityStatus = objVerifyZoneTypeCityMain.dispatchvisibilityOfVechileSection(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					visibilityStatus = true;

					objVerifyZoneTypeCityMain.dispatchclickonEDITVehicle();
					objTestBase.defaultWaitTime(3000);

					// Capture SKU NUMBER from Dispatch Site:
					visibilityStatus = objVerifyZoneTypeCityMain.switchToWindow(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					captureSKUNumber = objVerifyZoneTypeCityMain.captureSKUNumber(captureSKUNumber);
					System.out.println("SKU Number = " + captureSKUNumber);
					testStep = "Verify EDIT Service Rates Page loaded from Dispatch site and Capture the SKU Number = "
							+ captureSKUNumber;
					if (!captureSKUNumber.isEmpty() || captureSKUNumber != null) {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							lambdaTestStatusUpdate("passed", testStep);
						utillLogger.info(objVerifyZoneTypeCityTest.getClass().getSimpleName() + " - " + testStep
								+ " - SKU NUMBER = " + captureSKUNumber);
						enableStatus = true;
					} else {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						else
							lambdaTestStatusUpdate("failed", testStep);
						utillLogger.info(objVerifyZoneTypeCityTest.getClass().getSimpleName() + " - " + testStep
								+ " - SKU NUMBER = " + captureSKUNumber);
						enableStatus = false;
					}
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					enableStatus = false;
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
				}
			} else {
				objVerifyZoneTypeCityMain.verifyDispatchLogin();
				objTestBase.defaultWaitTime(3000);
				objVerifyZoneTypeCityMain.dispatchclickPricingSection();
				objTestBase.defaultWaitTime(3000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)", "");

				testStep = "Verification of Pricing ServiceRate Page loaded while disabling DO NOT SERVE - SKU NUMBER = "
						+ captureSKUNumber;
				visibilityStatus = objVerifyZoneTypeCityMain.dispatchvisibilityOfServiceRateTabPage(visibilityStatus);
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

				captureSKUNumber = objVerifyZoneTypeCityMain.dispatchSKUNumberSearch(captureSKUNumber);
				System.out.println("SKU Number = " + captureSKUNumber);
				testStep = "Verification of SKU Number Search from Dispatch Site - SKU Number = " + captureSKUNumber;
				if (!captureSKUNumber.isEmpty() || captureSKUNumber != null) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					utillLogger.info(objVerifyZoneTypeCityTest.getClass().getSimpleName() + " - " + testStep
							+ " - SKU NUMBER = " + captureSKUNumber);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					utillLogger.info(objVerifyZoneTypeCityTest.getClass().getSimpleName() + " - " + testStep
							+ " - SKU NUMBER = " + captureSKUNumber);
				}

				testStep = "Verification of EDIT button visibility of SKU NUMBER = " + captureSKUNumber;
				visibilityStatus = objVerifyZoneTypeCityMain.dipatchclickOnEDITButton(visibilityStatus);
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
			}

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			objTestBase.defaultWaitTime(2000);

			objVerifyZoneTypeCityMain.dispatchupdateDONOTSERVE(enableStatus);
			objTestBase.defaultWaitTime(2000);
			objVerifyZoneTypeCityMain.dipatchclickOnUpdateButton();
			objTestBase.defaultWaitTime(500);

			testStep = "Verify DO NOT SERVE UPDATE Confirmation message displayed for SKU Number = " + captureSKUNumber;
			visibilityStatus = objVerifyZoneTypeCityMain.verifyDispatchDoNotServeUpdateConfirmation(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					lambdaTestStatusUpdate("passed", testStep);
				visibilityStatus = true;
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					lambdaTestStatusUpdate("failed", testStep);
				visibilityStatus = false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			testStatus = "FALIED";
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
		return enableStatus;
	}

	private String verifyRideBooking(String testStep, String scenario, Boolean lessThan24hrs, String donotServeStatus,
			String testStatus) throws Exception {
		try {
			objTestBase.defaultWaitTime(1000);
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
			objVerifyZoneTypeCityMain.addFromAddress();
			objTestBase.defaultWaitTime(3000);
			objVerifyZoneTypeCityMain.addToAddress(scenario);
			objTestBase.defaultWaitTime(3000);
			objVerifyZoneTypeCityMain.enterDate(lessThan24hrs, false);
			objTestBase.defaultWaitTime(2000);

			if (lessThan24hrs == true) {
				timeHours = objVerifyZoneTypeCityMain.enterTime(scenario, lessThan24hrs, timeHours);
			}
			objTestBase.defaultWaitTime(2000);

			objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
					"- ActualTimeHours = " + timeHours.get("ActualTimeHours").toString() + " - ConfiguredTimeHours = "
							+ timeHours.get("ConfiguredTimeHours").toString());

			objTestBase.defaultWaitTime(1000);
			objVerifyZoneTypeCityMain.clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			if (donotServeStatus == "beforeDONOTSERVEEnabled" || donotServeStatus == "afterDONOTSERVEDisabled") {
				testStep = "Verify list of available vechiles - " + donotServeStatus;
				visibilityStatus = objVerifyZoneTypeCityMain.visibilityOfListofVechiles(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objTestBase.defaultWaitTime(1000);
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,350)", "");
					testStatus = continueSedanBooking(donotServeStatus, testStatus);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "FAILED";
				}
			} else {
				testStep = "Verify DO NOT SERVE Error Message Displayed.? - " + donotServeStatus;
				visibilityStatus = objVerifyZoneTypeCityMain.verifyVisibilityOfDoNotServeWarningMsg(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					visibilityStatus = true;
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					visibilityStatus = false;
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(1000);
				objVerifyZoneTypeCityMain.clickOnCancel();
				objTestBase.defaultWaitTime(2000);
			}

			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			testStatus = "FALIED";
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
		return testStatus;
	}

	public String continueSedanBooking(String donotServeStatus, String testStatus) {
		try {
			objVerifyZoneTypeCityMain.clickOnSedan();
			objTestBase.defaultWaitTime(5000);

			testStep = "Verify ride details Page Navigation - " + donotServeStatus;
			visibilityStatus = objVerifyZoneTypeCityMain.verifyRideDetailsPage(visibilityStatus);
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
			objVerifyZoneTypeCityMain.clickOnSecondaryPassenger();
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			objTestBase.defaultWaitTime(1000);
			objVerifyZoneTypeCityMain.enterspFirstName();
			objTestBase.defaultWaitTime(1000);
			objVerifyZoneTypeCityMain.enterspLastName();
			objTestBase.defaultWaitTime(1000);
			objVerifyZoneTypeCityMain.enterspMobile();
			objTestBase.defaultWaitTime(2000);
			objVerifyZoneTypeCityMain.enterspEmail();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1100)", "");
			objTestBase.defaultWaitTime(1000);

			visibilityStatus = objVerifyZoneTypeCityMain.verifyVisibilityOfPaymentInfo(visibilityStatus);
			objTestBase.defaultWaitTime(5000);
			js.executeScript("window.scrollBy(0,500)", "");
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus.booleanValue() == true)
				objVerifyZoneTypeCityMain.enterPaymentInformation();

			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", "");
			objTestBase.defaultWaitTime(1000);

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of Ride Booking Details Page - " + donotServeStatus;
			visibilityStatus = objVerifyZoneTypeCityMain.verifyConfirmBookingBtnVisibility(visibilityStatus);
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

			objTestBase.defaultWaitTime(2000);
			// Prod Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				objVerifyZoneTypeCityMain.clickonConfirmBooking();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of " + scenario + " Ride Booking Confirmation Page - " + donotServeStatus;
				visibilityStatus = objVerifyZoneTypeCityMain.verifyRideBookingConfirmation(visibilityStatus);

				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					objVerifyZoneTypeCityMain.clickonBookNextRide();
					objTestBase.defaultWaitTime(3000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				driver.get(prop.getProperty("portalURL"));
				// Method to close Pop-up Window:
				objTestBase.closePopupWindow();
				// Configuration for handing mobile simulator testing:
				if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocal")) {
						clickOnToggleNavigationBar();
				}
			}

			objTestBase.defaultWaitTime(2000);
			driver.navigate().refresh();
			objTestBase.closePopupWindow();

		} catch (Exception ex) {
			ex.printStackTrace();
			testStatus = "FAILED";
		}
		return testStatus;
	}

	@AfterClass(groups = "UserPortal.NewBookings")
	public void afterClass() {
		utillLogger.info("## " + objVerifyZoneTypeCityTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
		enableDONOTSERVE = false;
		if (!environmentCode.equalsIgnoreCase("prod")) {
			try {
				enableDONOTSERVE(enableDONOTSERVE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
