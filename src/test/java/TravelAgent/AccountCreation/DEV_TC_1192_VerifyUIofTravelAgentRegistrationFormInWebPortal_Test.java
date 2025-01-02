package TravelAgent.AccountCreation;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1192_VerifyUIofTravelAgentRegistrationFormInWebPortal_Test extends TestBase {

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

	DEV_TC_1192_VerifyUIofTravelAgentRegistrationFormInWebPortal_Main objVerifyUITARegisMain;
	DEV_TC_1192_VerifyUIofTravelAgentRegistrationFormInWebPortal_Test objVerifyUITARegisTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.AccountCreation")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.AccountCreation")
	public void verificationOfTravelAgentRegistrationPage() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyUITARegisMain = new DEV_TC_1192_VerifyUIofTravelAgentRegistrationFormInWebPortal_Main(driver);
			objVerifyUITARegisTest = new DEV_TC_1192_VerifyUIofTravelAgentRegistrationFormInWebPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyUITARegisTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyUITARegisTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";
			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
				utillLogger.info(testStep + " - " + testStatus);
			}

			// Method to close Pop-up Window:
			closePopupWindow();	
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
				|| browserType.equalsIgnoreCase("chromeiOSMobileView")
				|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
					clickOn3HorizontalToggleNavigationBar();
			}

			scenario = "Without Login";
			verifyTravelAgentReistrationForm(scenario);

			// ---------------------- #WithLogin: Start --------------------//
			testStep = "Verify visibility of Travel Agent under Programs menu from Home page - With Login";
			objTestBase.defaultWaitTime(1000);
			visibilityStatus = objVerifyUITARegisMain.switchBacktoHomepage(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(1000);
				objVerifyUITARegisMain.clickLogin();
				objTestBase.defaultWaitTime(2000);

				objVerifyUITARegisMain.enterEmail();
				objTestBase.defaultWaitTime(1000);

				objVerifyUITARegisMain.passwordRelogin();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyUITARegisMain.visibilityOfSignInButton(visibilityStatus);
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objVerifyUITARegisMain.clickOnSignInBtn();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
				}

				scenario = "With Login";
				verifyTravelAgentReistrationForm(scenario);
				// ---------------------- #WithLogin: End --------------------//
			}
		} catch (

		Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	private void verifyTravelAgentReistrationForm(String scenario) {
		try {
			testStep = "Verify visibility of Travel Agent under Programs menu from Home page - " + scenario;
			visibilityStatus = objVerifyUITARegisMain.visibilityOfProgramsDropdown(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				screenshotPath = getScreenshot(driver, "Verification of User Signout");
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
				utillLogger.info(testStep + " - " + testStatus);
			}
			testStep = "Verify Travel Agent Page Navigation from Home page - " + scenario;
			if (testStatus == "PASSED") {
				objVerifyUITARegisMain.clickOnTravelAgent();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objVerifyUITARegisMain.verifyTravelAgentPageNavigation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					currURL = driver.getCurrentUrl();
					if (currURL.toLowerCase().contains("travel")) {
						objTestBase.defaultWaitTime(2000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
						utillLogger.info(testStep + " - " + testStatus);
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
						utillLogger.info(testStep + " - " + testStatus);
					}
				}
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
				utillLogger.info(testStep + " - " + testStatus);
			}

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,5000)", "");
			objTestBase.defaultWaitTime(2000);

			testStep = "Verify visibility of 'JOIN THE LUXY™ TRAVEL AGENT PROGRAM' Button visibility - " + scenario;
			visibilityStatus = objVerifyUITARegisMain.visibilityOfJoinTheLuxyAgentProgramBtn(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Verification of Travel Agent Registration form - " + scenario;
			visibilityStatus = objVerifyUITARegisMain.verificationOfTARegistrationForm(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);

			testStep = "Verification of Travel Agent Registration form fields display - " + scenario;
			visibilityStatus = objVerifyUITARegisMain.visibilityOfTravelAgentFieldsDisplay(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass(groups = "TravelAgent.AccountCreation")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyUITARegisTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
