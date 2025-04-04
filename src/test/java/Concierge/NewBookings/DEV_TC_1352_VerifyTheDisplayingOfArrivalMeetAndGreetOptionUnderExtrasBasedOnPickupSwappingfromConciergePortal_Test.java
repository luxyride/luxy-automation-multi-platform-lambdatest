package Concierge.NewBookings;

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

public class DEV_TC_1352_VerifyTheDisplayingOfArrivalMeetAndGreetOptionUnderExtrasBasedOnPickupSwappingfromConciergePortal_Test
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
	Boolean bookingStatus;
	JavascriptExecutor js;
	String scenario;

	DEV_TC_1352_VerifyTheDisplayingOfArrivalMeetAndGreetOptionUnderExtrasBasedOnPickupSwappingfromConciergePortal_Main objVerifyArrivalMeetGreet_Main;
	DEV_TC_1352_VerifyTheDisplayingOfArrivalMeetAndGreetOptionUnderExtrasBasedOnPickupSwappingfromConciergePortal_Test objVerifyArrivalMeetGreet_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.NewBookings")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.NewBookings")
	public void ActivationOfNewUserAfterRegistration() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyArrivalMeetGreet_Main = new DEV_TC_1352_VerifyTheDisplayingOfArrivalMeetAndGreetOptionUnderExtrasBasedOnPickupSwappingfromConciergePortal_Main(
					driver);
			objVerifyArrivalMeetGreet_Test = new DEV_TC_1352_VerifyTheDisplayingOfArrivalMeetAndGreetOptionUnderExtrasBasedOnPickupSwappingfromConciergePortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyArrivalMeetGreet_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyArrivalMeetGreet_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			// Method to close Pop-up Window:
			objTestBase.closePopupWindow();

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				objVerifyArrivalMeetGreet_Main.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyArrivalMeetGreet_Main.passwordInput();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = objVerifyArrivalMeetGreet_Main.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyArrivalMeetGreet_Main.clickSigninButton();
					objTestBase.defaultWaitTime(3000);
					objVerifyArrivalMeetGreet_Main.ClickNewBooking();
					objTestBase.defaultWaitTime(4000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				visibilityStatus = objVerifyArrivalMeetGreet_Main.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of User Portal Login";
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					// Validation of Airport To Ground Address when pickup address = TRUE:
					scenario = "Airport To Ground Address Validation When Pickup Address = TRUE";
					vechileBooking(scenario);
					// Validation of Airport To Airport Address when pickup address = TRUE:
					objVerifyArrivalMeetGreet_Main.ClickNewBooking();
					objTestBase.defaultWaitTime(3000);
					scenario = "Airport To Airport Address Validation When Pickup Address = TRUE";
					vechileBooking(scenario);
					// Validation of Airport To Ground Address when pickup address = FALSE:
					objVerifyArrivalMeetGreet_Main.ClickNewBooking();
					objTestBase.defaultWaitTime(3000);
					scenario = "Airport To Ground Address Validation When Pickup Address = FALSE";
					vechileBooking(scenario);
					// Validation of Airport To Airport Address when pickup address = FALSE:
					objVerifyArrivalMeetGreet_Main.ClickNewBooking();
					objTestBase.defaultWaitTime(3000);
					scenario = "Airport To Airport Address Validation When Pickup Address = FALSE";
					vechileBooking(scenario);

				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
	}

	public String vechileBooking(String scenario) throws Exception {
		try {
			objTestBase.defaultWaitTime(1000);
			if (scenario == "Airport To Ground Address Validation When Pickup Address = TRUE") {
				objVerifyArrivalMeetGreet_Main.addFromAddress("airportPickupAddressTRUE");
				objTestBase.defaultWaitTime(1000);
				objVerifyArrivalMeetGreet_Main.addToAddress("groundAddressTPA");
				objTestBase.defaultWaitTime(1000);
			} else if (scenario == "Airport To Airport Address Validation When Pickup Address = TRUE") {
				objVerifyArrivalMeetGreet_Main.addFromAddress("airportPickupAddressTRUE");
				objTestBase.defaultWaitTime(1000);
				objVerifyArrivalMeetGreet_Main.addToAddress("airportToAddressTPA");
				objTestBase.defaultWaitTime(1000);
			} else if (scenario == "Airport To Ground Address Validation When Pickup Address = FALSE") {
				objVerifyArrivalMeetGreet_Main.addFromAddress("airportPickupAddressFALSE");
				objTestBase.defaultWaitTime(1000);
				objVerifyArrivalMeetGreet_Main.addToAddress("groundAddressJFK");
				objTestBase.defaultWaitTime(1000);
			} else if (scenario == "Airport To Airport Address Validation When Pickup Address = FALSE") {
				objVerifyArrivalMeetGreet_Main.addFromAddress("airportPickupAddressFALSE");
				objTestBase.defaultWaitTime(1000);
				objVerifyArrivalMeetGreet_Main.addToAddress("airportToAddressJFK");
				objTestBase.defaultWaitTime(1000);
			}

			objVerifyArrivalMeetGreet_Main.enterDate();
			objTestBase.defaultWaitTime(2000);
			objVerifyArrivalMeetGreet_Main.clickOngetQuote();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify list of available vechiles for the scenario - " + scenario + " - Before Swapping";
			visibilityStatus = objVerifyArrivalMeetGreet_Main.visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(1000);

			if (visibilityStatus == true) {
				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);
				utillLogger.info(testStep + " - " + testStatus);
				objVerifyArrivalMeetGreet_Main.clickOnSedan();
				objTestBase.defaultWaitTime(5000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,750)", "");
				objTestBase.defaultWaitTime(2000);

				if (testStatus == "PASSED"
						&& (scenario == "Airport To Ground Address Validation When Pickup Address = TRUE"
								|| scenario == "Airport To Airport Address Validation When Pickup Address = TRUE")) {
					testStep = "Verify the displaying of Arrival meet and greet option for the scenario - " + scenario
							+ " - Before Swapping";
					visibilityStatus = objVerifyArrivalMeetGreet_Main
							.verifyArrivalMeetGreetSectionTRUE(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					objVerifyArrivalMeetGreet_Main.enableMeetGreetOption();
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
						testStep = "Verify the displaying of Passenger Name and Additional Comments displayed after enabling Arrival meet and greet option for the scenario - "
								+ scenario + " - Before Swapping";
						visibilityStatus = objVerifyArrivalMeetGreet_Main
								.verifyPassengerNameCommentsVisibility(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					}
				} else if (testStatus == "PASSED"
						&& (scenario == "Airport To Ground Address Validation When Pickup Address = FALSE"
								|| scenario == "Airport To Airport Address Validation When Pickup Address = FALSE")) {
					testStep = "Verify the displaying of Arrival meet and greet option for the scenario - " + scenario
							+ " - Before Swapping";
					visibilityStatus = objVerifyArrivalMeetGreet_Main
							.verifyArrivalMeetGreetSectionFALSE(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);
				}

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-1000)", "");
				objTestBase.defaultWaitTime(2000);

				objVerifyArrivalMeetGreet_Main.clickonSwap();
				objTestBase.defaultWaitTime(6000);
				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);

				// After Swapping Validations:
				if (scenario == "Airport To Ground Address Validation When Pickup Address = TRUE")
					scenario = "Ground To Airport Address Validation When Pickup Address = TRUE";
				else if (scenario == "Airport To Airport Address Validation When Pickup Address = TRUE")
					scenario = "Airport To Airport Address Validation When Pickup Address = TRUE";
				else if (scenario == "Airport To Ground Address Validation When Pickup Address = FALSE")
					scenario = "Ground To Airport Address Validation When Pickup Address = FALSE";
				else if (scenario == "Airport To Airport Address Validation When Pickup Address = FALSE")
					scenario = "Airport To Airport Address Validation When Pickup Address = FALSE";

				if (testStatus == "PASSED"
						&& (scenario == "Airport To Airport Address Validation When Pickup Address = TRUE")) {
					testStep = "Verify the displaying of Arrival meet and greet option for the scenario - " + scenario
							+ " - After Swapping";
					visibilityStatus = objVerifyArrivalMeetGreet_Main
							.verifyArrivalMeetGreetSectionTRUE(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					objVerifyArrivalMeetGreet_Main.enableMeetGreetOption();
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
						testStep = "Verify the displaying of Passenger Name and Additional Comments displayed after enabling Arrival meet and greet option for the scenario - "
								+ scenario + " - After Swapping";
						visibilityStatus = objVerifyArrivalMeetGreet_Main
								.verifyPassengerNameCommentsVisibility(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);
					}
				} else {
					testStep = "Verify the displaying of Arrival meet and greet option for the scenario - " + scenario
							+ " - After Swapping";
					visibilityStatus = objVerifyArrivalMeetGreet_Main
							.verifyArrivalMeetGreetSectionFALSE(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			// Navigate back to Homepage:
			driver.get(prop.getProperty("conciergeURL"));
			objTestBase.defaultWaitTime(3000);
			objVerifyArrivalMeetGreet_Main.ClickNewBooking();
			objTestBase.defaultWaitTime(3000);
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			testStatus = "FAILED";
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
			driver.navigate().refresh();
			objTestBase.closePopupWindow();
		}
		return testStatus;
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyArrivalMeetGreet_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
