package Dispatch.Login;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_13_VerifyDisplayingOnDispatchSiteSigninPage_Test extends TestBase {

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

	DEV_TC_13_VerifyDisplayingOnDispatchSiteSigninPage_Main objVerifySigninPage_Main;
	DEV_TC_13_VerifyDisplayingOnDispatchSiteSigninPage_Test objVerifySigninPage_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.Login")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.Login")
	public void VerifyDisplayingOnDispatchSiteSigninPage() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySigninPage_Main = new DEV_TC_13_VerifyDisplayingOnDispatchSiteSigninPage_Main(driver);
			objVerifySigninPage_Test = new DEV_TC_13_VerifyDisplayingOnDispatchSiteSigninPage_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySigninPage_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySigninPage_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(6000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify the displaying on dispatch site sign in page";

			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
				objTestBase.defaultWaitTime(1000);
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Dispatch.Login")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySigninPage_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
