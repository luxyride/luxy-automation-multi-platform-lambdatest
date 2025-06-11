package UserPortal.Login;

import java.util.Map;
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

public class DEV_TC_1952_VerifyFunctionalityOfProfileOptionInWebUserPortal_Test extends TestBase {

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

	DEV_TC_1952_VerifyFunctionalityOfProfileOptionInWebUserPortal_Main objVerifyNewBookingMain;
	DEV_TC_1952_VerifyFunctionalityOfProfileOptionInWebUserPortal_Test objVerifyNewBookingTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "UserPortal.Login")
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "UserPortal.Login")
	public void ActivationOfNewUserAfterRegistration() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyNewBookingMain = new DEV_TC_1952_VerifyFunctionalityOfProfileOptionInWebUserPortal_Main(driver);
			objVerifyNewBookingTest = new DEV_TC_1952_VerifyFunctionalityOfProfileOptionInWebUserPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyNewBookingTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyNewBookingTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);
			objTestBase.closeCookiesPopupWindow();
			objTestBase.defaultWaitTime(2000);
			
			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";
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
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				clickOn3HorizontalToggleNavigationBar();
			}

			testStep = "Verification customer user login";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(1000);
				// Configuration for handing mobile simulator testing:
				if (!browserType.equalsIgnoreCase("chromeAndroidMobileView")
						&& !browserType.equalsIgnoreCase("chromeiOSMobileView")
						&& !browserType.equalsIgnoreCase("chromeLocalMobileView")) {
					objVerifyNewBookingMain.clickSignInNormalView();
					objTestBase.defaultWaitTime(2000);
				} else {
					testStep = "Verify visibility of Customer Login";
					visibilityStatus = objVerifyNewBookingMain.visibilityOfDropDown(visibilityStatus);
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

				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingMain.clickOnCustomerLogin();
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyNewBookingMain.passwordInput();
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = objVerifyNewBookingMain.visibilityOfLoginAndContinueBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
					objVerifyNewBookingMain.clickSigninButton();
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}

				visibilityStatus = objVerifyNewBookingMain.visibilityOfLoggedinUser(visibilityStatus);
				testStep = "Verification of User Portal Login";
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
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
			utillLogger.info(testStep + " - " + testStatus);

			// Validation of PROFILE option availability:
			testStep = "Verify availability of PROFILE option.?";
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				visibilityStatus = objVerifyNewBookingMain.visibilityOfProfileOption(visibilityStatus,
						"profileOptionSimulatorView");
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}

				utillLogger.info(testStep + " - " + testStatus);
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingMain.clickOnProfileOption("profileOptionSimulatorView");
				objTestBase.defaultWaitTime(3000);
			} else {
				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingMain.clickWelcomeDropDown();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = objVerifyNewBookingMain.visibilityOfProfileOption(visibilityStatus,
						"profileOptionNormalViewF");
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						lambdaTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}

				utillLogger.info(testStep + " - " + testStatus);
				objTestBase.defaultWaitTime(2000);

				objTestBase.defaultWaitTime(2000);
				objVerifyNewBookingMain.clickOnProfileOption("profileOptionNormalView");
				objTestBase.defaultWaitTime(3000);
			}

			visibilityStatus = objVerifyNewBookingMain.VerifyProfilePage(visibilityStatus);
			testStep = "verify profile options Page";
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
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass(groups = "UserPortal.Login")
	public void afterClass() {
		driver.quit();
		// Print the Captured the Ride Booking ids - captured from
		// DEV_TC_1092_VerifyCustomerLoginOptionOnWebUserPortal_Test Test Case:
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : rideBookingIds.entrySet()) {
			System.out.println("Booking IDs from TC: DEV_TC_1092_VerifyCustomerLoginOptionOnWebUserPortal_Test = "
					+ "Total TripIDs = " + rideBookingIds.size() + " - " + entry.getKey() + " - " + entry.getValue());
			utillLogger.info("Booking IDs from TC: DEV_TC_1092_VerifyCustomerLoginOptionOnWebUserPortal_Test = "
					+ "Total TripIDs = " + rideBookingIds.size() + entry.getKey() + " - " + entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		utillLogger.info("## " + objVerifyNewBookingTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}