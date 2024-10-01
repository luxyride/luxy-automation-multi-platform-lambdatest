package TravelAgent.DispatchTravelArranger;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1272_VerifyFunctionalityOfTravelArrangerRegistrationInDispatchPortalAndLginIntoTravelAgentPortal_Test
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

	DEV_TC_1272_VerifyFunctionalityOfTravelArrangerRegistrationInDispatchPortalAndLginIntoTravelAgentPortal_Main objVerifyTADispatch_Main;
	DEV_TC_1272_VerifyFunctionalityOfTravelArrangerRegistrationInDispatchPortalAndLginIntoTravelAgentPortal_Test objVerifyTADispatch_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "TravelAgent.DispatchTravelArranger")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "TravelAgent.DispatchTravelArranger")
	public void verifyTravelAgentAccountDetailsDispatch() throws Exception {
		try {
			action = new Actions(driver);
			objVerifyTADispatch_Main = new DEV_TC_1272_VerifyFunctionalityOfTravelArrangerRegistrationInDispatchPortalAndLginIntoTravelAgentPortal_Main(
					driver);
			objVerifyTADispatch_Test = new DEV_TC_1272_VerifyFunctionalityOfTravelArrangerRegistrationInDispatchPortalAndLginIntoTravelAgentPortal_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyTADispatch_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyTADispatch_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

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

				testStep = "Verify navigation of Travel Arranger Tab from Dispatch Site";
				visibilityStatus = objVerifyTADispatch_Main.verifyTravelArrangerTabNavigation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verify navigation of Travel Arranger Tab from Dispatch Site";
				visibilityStatus = objVerifyTADispatch_Main.verifyAddTravelArrangerPageNavigation(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);

				// Identify Paths:
				String printPaths;
				if (System.getProperty("user.name").equalsIgnoreCase("circleci")) // Docker Env. User Name
					printPaths = dockerTravelAgentDocsPath + "W9Test.pdf" + "  &  " + dockerTravelAgentDocsPath
							+ "TestDDForm.pdf";
				else
					printPaths = localTravelAgentDocsPath + "W9Test.pdf" + "  &  " + localTravelAgentDocsPath
							+ "TestDDForm.pdf";

				testStep = "Verification for Registering a Travel Arranger from Dispatch Site - Paths = " + printPaths;
				eMail = objVerifyTADispatch_Main.verifyRegistrationOfTravelArranger(visibilityStatus, eMail);
				if (eMail != null)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				utillLogger.info(testStep + " - " + testStatus);

				if (!environmentCode.equalsIgnoreCase("prod")) {
					testStep = "Verification for Registering a Travel Arranger Confirmation Message displayed from Dispatch Site";
					visibilityStatus = objVerifyTADispatch_Main.visibilityOfConfimrationMessage(visibilityStatus);
					objTestBase.defaultWaitTime(4000);
					if (visibilityStatus.booleanValue() == true)
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					else
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
					utillLogger.info(testStep + " - " + testStatus);

					testStep = "Verification of Registered Travel Arragner Login From Travel Agent Site";
					driver.get(prop.getProperty("travelAgentURL"));
					driver.manage().window().maximize();
					objTestBase.defaultWaitTime(2000);

					currURL = driver.getCurrentUrl();
					testStep = "Verification of TravelAgent Portal Loginpage ";
					if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					System.out.println("Registered Travel Arranger Email = " + eMail);
					if (testStatus == "PASSED") {
						testStatus = " ";
						objTestBase.defaultWaitTime(1000);
						utillLogger.info(objVerifyTADispatch_Test.getClass().getSimpleName()
								+ " -->> Registered Travel Arranger Email = " + eMail);
						objVerifyTADispatch_Main.eMailInputTA(eMail);
						objTestBase.defaultWaitTime(2000);
						objVerifyTADispatch_Main.passwordInputTA();
						objTestBase.defaultWaitTime(2000);

						visibilityStatus = objVerifyTADispatch_Main.visibilityOfSigninButtonTA(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							objVerifyTADispatch_Main.clickSigninButtonTA();
							objTestBase.defaultWaitTime(3000);
							driver.navigate().refresh();
							objTestBase.defaultWaitTime(1000);
						} else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);

						objVerifyTADispatch_Main.clickNewBookingTA();
						objTestBase.defaultWaitTime(3000);

						testStep = "Verification of TravelAgent Portal Login With Valid Credentials";
						visibilityStatus = objVerifyTADispatch_Main.visibilityOfLoggedinUserTA(visibilityStatus);
						if (visibilityStatus.booleanValue() == true)
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						else
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						utillLogger.info(testStep + " - " + testStatus);
					} else
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				}

				utillLogger.info(testStep + " - " + testStatus);
			} else
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "TravelAgent.DispatchTravelArranger")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyTADispatch_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
