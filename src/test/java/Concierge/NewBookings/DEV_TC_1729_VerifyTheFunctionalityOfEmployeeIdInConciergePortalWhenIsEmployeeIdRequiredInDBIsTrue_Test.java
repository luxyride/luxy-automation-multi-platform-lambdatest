package Concierge.NewBookings;

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

public class DEV_TC_1729_VerifyTheFunctionalityOfEmployeeIdInConciergePortalWhenIsEmployeeIdRequiredInDBIsTrue_Test extends TestBase {

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

	DEV_TC_1729_VerifyTheFunctionalityOfEmployeeIdInConciergePortalWhenIsEmployeeIdRequiredInDBIsTrue_Main objVerifyLogout_Main;
	DEV_TC_1729_VerifyTheFunctionalityOfEmployeeIdInConciergePortalWhenIsEmployeeIdRequiredInDBIsTrue_Test objVerifyLogout_Test;
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
	public void VerifyUserShouldNotLogoutAutomaticallyWhenReloadsTheDispatchPage() throws Exception {

		try {
			action = new Actions(driver);
			objVerifyLogout_Main = new DEV_TC_1729_VerifyTheFunctionalityOfEmployeeIdInConciergePortalWhenIsEmployeeIdRequiredInDBIsTrue_Main(
					driver);
			objVerifyLogout_Test = new DEV_TC_1729_VerifyTheFunctionalityOfEmployeeIdInConciergePortalWhenIsEmployeeIdRequiredInDBIsTrue_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifyLogout_Test.getClass().getSimpleName());
			utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			
			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			testStep = "Verify Dispatch Portal Launch Homepage";
			currURL = driver.getCurrentUrl();
			if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))
					&& currURL.toLowerCase().contains("luxyride")) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			if (testStatus == "PASSED") {
				testStatus = " ";
				objVerifyLogout_Main.eMailInputDispatch();
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.passwordInputDispatch();
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.eyeIconClickDispatch();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifyLogout_Main.visibilityOfSigninButtonDispatch(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					objVerifyLogout_Main.clickSigninButtonDispatch();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objVerifyLogout_Main.clickNewBookingDispatch();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifyLogout_Main.visibilityOfLoggedinUserDispatch(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.clickOnCorporate();
				objTestBase.defaultWaitTime(1000);
				
				testStep = "Visibility of manage corporate Page";
				visibilityStatus = objVerifyLogout_Main.visibilityOfManageCorporatePage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.searchInput();
				objTestBase.defaultWaitTime(1000);
				
				testStep = "Visibility of manage corporate Page";
				visibilityStatus = objVerifyLogout_Main.visibilityOfEditBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			
				utillLogger.info(testStep + " - " + testStatus);
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
			
		
			driver.get(prop.getProperty("conciergeURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(2000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Dispatch Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
				else
					browserStackTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			utillLogger.info(testStep + " - " + testStatus);
			testStep = "Verification of entered User details from Login page";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.passwordInput();
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.clickEyeIcon();

				visibilityStatus = objVerifyLogout_Main.visibilityOfsigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login ";
				if (testStatus == "PASSED") {
					objTestBase.defaultWaitTime(2000);
					objVerifyLogout_Main.clickSignInButton();
					objTestBase.defaultWaitTime(3000);
					visibilityStatus = objVerifyLogout_Main.visibilityOfsigninUser(visibilityStatus);
					objTestBase.defaultWaitTime(2000);
					if (visibilityStatus == true) {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
						else
							browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)
							objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
						else
							browserStackTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					testStatus = "SKIPPED";
				}
				
				
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.clickOnPassangerTab();
				objTestBase.defaultWaitTime(2000);
				
				testStep = "Visibility of Add passanger Button  ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfAddPassangerBtn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.clickOnAddPassanger();
				objTestBase.defaultWaitTime(3000);
				
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)", "");
				objTestBase.defaultWaitTime(3000);
				
				
				testStep = "Visibility of Employee id with mandatory field ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfEmployeIdfield(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.clickOnRegisterBtn();
				objTestBase.defaultWaitTime(1000);
				
				testStep = "Visibility of error pop up message ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfErrorMessage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				
				testStep = "Visibility of error pop up message ";
				objTestBase.defaultWaitTime(5000);
				objVerifyLogout_Main.enterAllRequiredInfo();
				objTestBase.defaultWaitTime(2000);
				testStep = "Visibility of error  message under employee field ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfErrorMessageUnderEmployeeField(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.enterEmployeId();
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.clickOnRegisterBtn();
				objTestBase.defaultWaitTime(3000);

				testStep = "Visibility of success pop up Message ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfSuccessMessage(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				
				objTestBase.defaultWaitTime(1000);
				testStep = "Visibility of employee id coloumn ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfEmployeeIdColumn(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.enterSearchInput(eMail);
				objTestBase.defaultWaitTime(3000);
				objVerifyLogout_Main.clickonEditIcon();
				objTestBase.defaultWaitTime(3000);
				
				
				testStep = "Visibility of created employee id in employe idcoloumn ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfPassangerDetails(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				
				objTestBase.defaultWaitTime(3000);
				objVerifyLogout_Main.removeEmployeId();
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.clickOnUpdateBtn();
				objTestBase.defaultWaitTime(2000);
				testStep = "Visibility of error  message under employee id field ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfErrorMessageUnderEmployeIdField(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				
				
				testStep = "enter valid employee id agin after negative validation  ";				
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.enterEmployeId();
				objTestBase.defaultWaitTime(2000);
				objVerifyLogout_Main.clickOnUpdateBtn();
				objTestBase.defaultWaitTime(2000);

				testStep = "Visibility of success pop up Messageafter updating employed id in edit mode ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfSuccesspopup(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				objTestBase.defaultWaitTime(3000);
				objVerifyLogout_Main.enterSearchInput(eMail);
				objTestBase.defaultWaitTime(1000);
				objVerifyLogout_Main.clickonEditIcon();
				objTestBase.defaultWaitTime(1000);
				
				
				testStep = "Visibility of created employee id in employe idcoloumn ";
				visibilityStatus = objVerifyLogout_Main.visibilityOfPassangerDetails(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						browserStackTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				
			} else {
				if (localExecutionFlag == true)
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
				else
					browserStackTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}
			utillLogger.info(testStep + " - " + testStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Concierge.NewBookings")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifyLogout_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}
}
