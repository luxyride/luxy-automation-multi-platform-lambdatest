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

public class DEV_TC_1228_VerifyRideBookedThroughTravelAgentIsListedInTravelAgentSiteUnderRIDEAllTab_Test
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
	Boolean bookingStatus;
	JavascriptExecutor js;
	String tripID;

	DEV_TC_1228_VerifyRideBookedThroughTravelAgentIsListedInTravelAgentSiteUnderRIDEAllTab_Main objVerifySighninMain;
	DEV_TC_1228_VerifyRideBookedThroughTravelAgentIsListedInTravelAgentSiteUnderRIDEAllTab_Test objVerifySighninTest;
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
	public void VerifyLogInPageOfTravelAgentWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1228_VerifyRideBookedThroughTravelAgentIsListedInTravelAgentSiteUnderRIDEAllTab_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1228_VerifyRideBookedThroughTravelAgentIsListedInTravelAgentSiteUnderRIDEAllTab_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("travelAgentURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(8000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of TravelAgent Portal Loginpage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			tripID = "3DAN-HZ66";
			// tripID should capture from TC:
			// DEV_TC_1228_VerifyRideBookedThroughTravelAgentIsListedInTravelAgentSiteUnderRIDEAllTab_Test
			if (testStatus == "PASSED" && tripID != null) {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifySighninMain.eMailInput(visibilityStatus);
				objTestBase.defaultWaitTime(1000);

				if (visibilityStatus.booleanValue() == true) {
					objVerifySighninMain.passwordInput();
					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.eyeIconClick();
					objTestBase.defaultWaitTime(1000);

					visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						objVerifySighninMain.clickSigninButton();
						objTestBase.defaultWaitTime(3000);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objVerifySighninMain.clickNewBooking();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of TravelAgent Portal Login With Valid Credentials";
					visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					utillLogger.info(testStep + " - " + testStatus);

					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.clickRidesSection();
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
						// Capture the Ride Booking IDs:
						tripID = objVerifySighninMain.verifyTripDetails(visibilityStatus, tripID);
						System.out.println("Trip ID = " + tripID);
						testStep = "Verify the Booked Ride ID Details from Rides All Page for Trip ID = " + tripID;
						if (tripID != null)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					} else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				}
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

	@AfterClass(groups = "TravelAgent.NewBooking")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
