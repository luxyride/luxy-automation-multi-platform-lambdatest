package TravelAgent.Passengers;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1290_VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Test
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

	DEV_TC_1290_VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Main objVerifySighninMain;
	DEV_TC_1290_VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.Passengers")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.Passengers")
	public void VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Test()
			throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1290_VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1290_VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");
			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(4000);

			currURL = driver.getCurrentUrl();
			testStep = "Verification of Dispatch Portal Loginpage ";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifySighninMain.enterEMail();
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

				testStep = "Verification of logged in user";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}

				objVerifySighninMain.clickTravelArranger();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickTravelArrangerTb();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verification of Add Travle Arranger Tab";
				visibilityStatus = objVerifySighninMain.visibilityOfAddTravelArrangerTab(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifySighninMain.clickaddTravelArrangerTab();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verification of Travel Arranger Registration form fields display";
				visibilityStatus = objVerifySighninMain.visibilityOfTravelArrangerFieldsDisplay(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				testStep = "Verification of Entered details from Travel Arranger Registration form page and click on cancel";
				visibilityStatus = objVerifySighninMain.enterDetailsTravelAgentForm(visibilityStatus);
				objTestBase.defaultWaitTime(2000);
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";

				objVerifySighninMain.clickOnUpdateBtn();
				objTestBase.defaultWaitTime(3000);

				driver.get(prop.getProperty("conciergeURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(10000);

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
					objVerifySighninMain.eMailInput();
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
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";

					}

					objVerifySighninMain.clickTravelArrangerTab();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verify manage travel arranger page ";
					visibilityStatus = objVerifySighninMain.visibilityOfManageTAPage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.enterSearchField(eMail);
					objTestBase.defaultWaitTime(3000);
					testStep = "visibility Of Travel Arranger details based on Search criteria ";
					visibilityStatus = objVerifySighninMain
							.visibilityOfTravelArrangerdetailsbasedonSearchcriteria(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";

					}

					objVerifySighninMain.clickOnEnrollBtn();
					objTestBase.defaultWaitTime(3000);
					testStep = "visibility Of pop-up messsage with yes / no options ";
					visibilityStatus = objVerifySighninMain.visibilityofpopupmessage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";

					}

					objVerifySighninMain.clickOnYesBtn();
					objTestBase.defaultWaitTime(3000);

					testStep = "visibility of alert message ";
					visibilityStatus = objVerifySighninMain.visibilityofAlertMessage(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";

					}

					driver.get(prop.getProperty("yopmailURL"));
					objTestBase.defaultWaitTime(3000);
					driver.manage().window().maximize();
					testStep = "Verify lanching the Yopmail";
					currURL = driver.getCurrentUrl();
					if (currURL.toLowerCase().contains("yopmail")) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					testStep = "Verifying the Email Notification with confirm account";
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.searchInput(eMail);
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.clickOnGo();
					objTestBase.defaultWaitTime(3000);

					visibilityStatus = objVerifySighninMain.visibilityofConfirmAccount(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					objVerifySighninMain.clickOnConfirmAccount();
					objTestBase.defaultWaitTime(3000);
					visibilityStatus = objVerifySighninMain.switchToWindow(visibilityStatus);
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.enterPasswordInput();
					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.confirmPwdInput();
					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.clickCheckBox();
					objTestBase.defaultWaitTime(2000);

					visibilityStatus = objVerifySighninMain.visibilityOfActivateBtn(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						objVerifySighninMain.clickOnActivateBtn();
						objTestBase.defaultWaitTime(3000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.enterEmail(eMail);
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.passwordInput();
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.clickOnSignin();
					objTestBase.defaultWaitTime(6000);

					testStep = "Verification of TravelAgent Portal Login With Valid Credentials";
					visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objVerifySighninMain.clickOnCorporate();
					objTestBase.defaultWaitTime(6000);
					objVerifySighninMain.clickOnPassenger();
					objTestBase.defaultWaitTime(6000);
					testStep = "Verification of Manage Passenger Page";
					visibilityStatus = objVerifySighninMain.visibilityOfManagePassenger(visibilityStatus);
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
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.Passengers")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
