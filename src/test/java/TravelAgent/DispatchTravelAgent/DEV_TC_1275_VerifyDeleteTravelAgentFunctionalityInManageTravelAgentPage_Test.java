package TravelAgent.DispatchTravelAgent;

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

public class DEV_TC_1275_VerifyDeleteTravelAgentFunctionalityInManageTravelAgentPage_Test extends TestBase {

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
	JavascriptExecutor js;

	DEV_TC_1275_VerifyDeleteTravelAgentFunctionalityInManageTravelAgentPage_Main objVerifyTADeletionMain;
	DEV_TC_1275_VerifyDeleteTravelAgentFunctionalityInManageTravelAgentPage_Test objVerifyTADeletionTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.DispatchTravelAgent")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.DispatchTravelAgent")
	public void activationOfNewUserAfterRegistration() throws Exception {
		try {
			objVerifyTADeletionMain = new DEV_TC_1275_VerifyDeleteTravelAgentFunctionalityInManageTravelAgentPage_Main(
					driver);
			objVerifyTADeletionTest = new DEV_TC_1275_VerifyDeleteTravelAgentFunctionalityInManageTravelAgentPage_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyTADeletionTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyTADeletionTest.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			System.out.println("Travel Agent Registered Email = " + eMail);
			utillLogger.info("Travel Agent Registered Email ID registered from DEV_TC_1196: = " + eMail);
			testStep = "Verification of registered travel agent users Email Activation.";
			if (eMail != null) {
				// Delete Created user from Dispatch Site:
				testStep = "Delete registered user from Dispath after all validations completed - " + "\n"
						+ "#Note: This step is only for Automation Suite runs to avoid unnecessary account creation on daily test runs.";
				visibilityStatus = objVerifyTADeletionMain.deleteCreatedUserfromDispatch(visibilityStatus, eMail);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
				}
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

			utillLogger.info(testStep + " - Deleted EMail account is: " + eMail + " - TestStatus = " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			testStep = "Activation of New User after Registration";
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.DispatchTravelAgent")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyTADeletionTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
