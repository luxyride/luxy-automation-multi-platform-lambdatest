package TravelAgent.AccountCreation;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1208_VerifyTravelAgentAccountDetailsCreatedThroughWebPortalIsListedUnderManageTravelAgentInDispatch_Test
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

	DEV_TC_1208_VerifyTravelAgentAccountDetailsCreatedThroughWebPortalIsListedUnderManageTravelAgentInDispatch_Main objVerifyTADispatch_Main;
	DEV_TC_1208_VerifyTravelAgentAccountDetailsCreatedThroughWebPortalIsListedUnderManageTravelAgentInDispatch_Test objVerifyTADispatch_Test;
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
	public void verifyTravelAgentAccountDetailsDispatch() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyTADispatch_Main = new DEV_TC_1208_VerifyTravelAgentAccountDetailsCreatedThroughWebPortalIsListedUnderManageTravelAgentInDispatch_Main(
					driver);
			objVerifyTADispatch_Test = new DEV_TC_1208_VerifyTravelAgentAccountDetailsCreatedThroughWebPortalIsListedUnderManageTravelAgentInDispatch_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyTADispatch_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyTADispatch_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");
			System.out.println("Travel Agent Registered Email = " + eMail);
			utillLogger.info("Travel Agent Registered Email ID registered from DEV_TC_1196: = " + eMail);
			testStep = "Verification of Travel Agent from Dispatch Site under Travel Agent Section - Email = " + eMail;
			if (eMail != null) {
				driver.get(prop.getProperty("dispatchURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(2000);

				currURL = driver.getCurrentUrl();
				testStep = "Verification of Dispatch Portal Loginpage ";

				if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				if (testStatus == "PASSED") {
					testStatus = " ";
					objVerifyTADispatch_Main.eMailInput();
					objVerifyTADispatch_Main.passwordInput();
					objTestBase.defaultWaitTime(1000);

					visibilityStatus = objVerifyTADispatch_Main.visibilityOfSigninButton(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						objVerifyTADispatch_Main.clickSigninButton();
						objTestBase.defaultWaitTime(3000);
						driver.navigate().refresh();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objVerifyTADispatch_Main.clickNewBooking();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Dispatch Portal Login With Valid Credentials";
					visibilityStatus = objVerifyTADispatch_Main.visibilityOfLoggedinUser(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verify navigation of Travel Agent Tab from Dispatch Site";
					visibilityStatus = objVerifyTADispatch_Main.verifyTravelAgentTabNavigation(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verification of Registered Travel Agent details from Dispatch Site";
					visibilityStatus = objVerifyTADispatch_Main.verifyTravelAgentRegisteredDetails(visibilityStatus,
							eMail);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);
				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.AccountCreation")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyTADispatch_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
