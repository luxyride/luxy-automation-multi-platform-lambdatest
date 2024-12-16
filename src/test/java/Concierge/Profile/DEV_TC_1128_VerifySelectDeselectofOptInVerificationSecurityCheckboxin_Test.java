package Concierge.Profile;

import java.util.Map;
import java.util.Set;
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

public class DEV_TC_1128_VerifySelectDeselectofOptInVerificationSecurityCheckboxin_Test extends TestBase {

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

	DEV_TC_1128_VerifySelectDeselectofOptInVerificationSecurityCheckboxin_Main objOptinPIN_Main;
	DEV_TC_1128_VerifySelectDeselectofOptInVerificationSecurityCheckboxin_Test objOptinPIN_Test;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Concierge.Profile")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Concierge.Profile")
	public void verifyRegistrationCorporate() {
		try {
			int verifyCount = 0;
			String mainWindow = driver.getWindowHandle();

			action = new Actions(driver);
			objOptinPIN_Main = new DEV_TC_1128_VerifySelectDeselectofOptInVerificationSecurityCheckboxin_Main(driver);
			objOptinPIN_Test = new DEV_TC_1128_VerifySelectDeselectofOptInVerificationSecurityCheckboxin_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objOptinPIN_Test.getClass().getSimpleName());
			utillLogger.info("## " + objOptinPIN_Test.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");

			// Verify Opt in PIN Checkbox Verification from User Portal Signup:
			driver.get(prop.getProperty("portalURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			currURL = driver.getCurrentUrl();
			testStep = "Verify Luxy Portal Launch Homepage";

			if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

			// Method to close Pop-up Window:
			closePopupWindow();	
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
				|| browserType.equalsIgnoreCase("chromeiOSMobileView")
				|| browserType.equalsIgnoreCase("chromeLocal")) {
					clickOnToggleNavigationBar();
			}
			utillLogger.info(testStep + " - " + testStatus);

			// Run the Test Script 2 times for Concierge Signup with Check and Uncheck
			// Secure PIN:
			for (verifyCount = 0; verifyCount <= 1; verifyCount++) {
				testStep = "Verify visibility of Programs dropdown from Homepage Header";
				visibilityStatus = objOptinPIN_Main.visibilityOfProgramsDropdown(visibilityStatus);
				objTestBase.defaultWaitTime(500);

				if (visibilityStatus.booleanValue() == true) {
					objOptinPIN_Main.clickOnPrograms();
					objTestBase.defaultWaitTime(1000);
					screenshotPath = getScreenshot(driver, "VerifyRideRewards");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
				testStep = "Verify visibility of Corporate module under Programs dropdown from Homepage Header";
				if (testStatus == "PASSED") {
					String parentWindow = driver.getWindowHandle();
					objTestBase.defaultWaitTime(1000);
					objOptinPIN_Main.clickOnCorporate();
					objTestBase.defaultWaitTime(1000);
					visibilityStatus = objOptinPIN_Main.switchToNewTab(visibilityStatus, parentWindow);
					objTestBase.defaultWaitTime(1000);
					testStep = "Verify visibility of Corporate Navigation from Programs dropdown";
					if (visibilityStatus.booleanValue() == true) {
						visibilityStatus = objOptinPIN_Main.verifyCorporatePage(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							screenshotPath = getScreenshot(driver, "VerifyCorporate");
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				}

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(4000);

				objOptinPIN_Main.clickOnEnroll();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verify 'Opt in PIN Verification for security' checkbox is selected by Default.?";
				if (testStatus == "PASSED") {
					visibilityStatus = objOptinPIN_Main.verifyOptInCheckboxSelected(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						objTestBase.defaultWaitTime(2000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						screenshotPath = getScreenshot(driver, "VerifySignup");
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);

				testStep = "Verify 'Opt in PIN Verification for security' Check and Uncheck functioality is working.?";
				if (testStatus == "PASSED") {
					visibilityStatus = objOptinPIN_Main.verifyOptInCheckUncheck(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						objTestBase.defaultWaitTime(2000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						screenshotPath = getScreenshot(driver, "VerifySignup");
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);

				if (verifyCount == 0)
					scenario = "Checked";
				else
					scenario = "Unchecked";
				testStep = "Verify the Concierge Signup with 'Opt in PIN Verification for security' is " + scenario;
				if (testStatus == "PASSED") {
					visibilityStatus = objOptinPIN_Main.verifyOptInCheckbox(visibilityStatus, scenario);
					if (visibilityStatus.booleanValue() == true) {
						objTestBase.defaultWaitTime(2000);
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						screenshotPath = getScreenshot(driver, "VerifySignup");
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);

				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStep = "Verify Concierge Account signup by filling all the required details.";
				if (testStatus == "PASSED") {
					objTestBase.defaultWaitTime(500);
					objOptinPIN_Main.enterAllDetails(scenario);
					objTestBase.defaultWaitTime(2000);
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);

				// Prod Restriction:
				if (!environmentCode.equalsIgnoreCase("prod")) {
					utillLogger.info(testStep + " - " + testStatus);
					testStep = "Verify User entered details from Signup page";
					if (testStatus == "PASSED") {
						visibilityStatus = objOptinPIN_Main.verifyVisibilityOfSignupCreateBtn(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							objOptinPIN_Main.clickOnSignupCreateBtn();
							objTestBase.defaultWaitTime(3000);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
					} else {
						screenshotPath = getScreenshot(driver, "VerifySignup");
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);
					testStep = "Verification of User Signup Confirmation Message.!";
					if (testStatus == "PASSED") {
						visibilityStatus = objOptinPIN_Main.visibilityOfSignupConfirmationMsg(visibilityStatus);

						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
					} else {
						screenshotPath = getScreenshot(driver, "VerifySignup");
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);

					// Close the current Window:
					Set<String> listOfWindows = driver.getWindowHandles();
					int tabCount = 0;
					for (String currWindow : listOfWindows) {
						if (tabCount == 1) {
							driver.switchTo().window(currWindow);	try	{	defaultWaitTime(5000);	}	catch (Exception e)	{	e.printStackTrace(); }
							driver.close();
							driver.switchTo().window(mainWindow);
						}
						tabCount++;
					}
				}
			}

			// Verify Opt in PIN Checkbox Verification from Dispatch Site:
			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(500);
			currURL = driver.getCurrentUrl();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Dispatch Portal Loginpage ";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objOptinPIN_Main.eMailInputDispatch();
				objOptinPIN_Main.passwordInputDispatch();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objOptinPIN_Main.visibilityOfSigninButtonDispatch(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objOptinPIN_Main.clickSigninButtonDispatch();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objOptinPIN_Main.visibilityOfLoggedinUserDispatch(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";

				}
				utillLogger.info(testStep + " - " + testStatus);

				objTestBase.defaultWaitTime(1000);
				testStep = "Verify CORPORATE tab from Dispatch Site";
				if (testStatus == "PASSED") {
					visibilityStatus = objOptinPIN_Main.verifyCorporateTabDispatch(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verify CORPORATE Registration Page from Dispatch Site";
				if (testStatus == "PASSED") {
					visibilityStatus = objOptinPIN_Main.verifyCorporateRegisPageDispatch(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				testStep = "Verify the 'Opt in PIN Verification for security' option is checked by default from Dispatch Site";
				if (testStatus == "PASSED") {
					visibilityStatus = objOptinPIN_Main.verifyOptInCheckedDefaultDispatch(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
				} else {
					screenshotPath = getScreenshot(driver, "VerifySignup");
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verify check/uncheck the 'Opt in PIN Verification for security' option from Dispatch Site";
				visibilityStatus = objOptinPIN_Main.verifyOptInCheckUncheckDispatch(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}
			utillLogger.info(testStep + " - " + testStatus);

			// Verify Opt in PIN Checkbox Verification from Concierge Site Profile Page:
			driver.get(prop.getProperty("conciergeURL"));
			currURL = driver.getCurrentUrl();
			objTestBase.defaultWaitTime(2000);

			testStep = "Verification of Concierge Site Login Page ";
			if (testStatus == "PASSED") {
				testStatus = " ";
				objOptinPIN_Main.eMailInputConcierge();
				objOptinPIN_Main.passwordInputConcierge();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = objOptinPIN_Main.visibilityOfSigninButtonConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					objOptinPIN_Main.clickSigninButtonConcierge();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification of Concierge Site Login With Valid Credentials";
				visibilityStatus = objOptinPIN_Main.visibilityOfLoggedinUserConcierge(visibilityStatus);
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

			testStep = "Verification of Profile Page Navigation in Concierge site";
			if (testStatus == "PASSED") {
				visibilityStatus = objOptinPIN_Main.verifyProfilePageConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verification of EDIT Profile Page from Concierge site";
			if (testStatus == "PASSED") {
				visibilityStatus = objOptinPIN_Main.verifyEditProfilePageConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verification of Opt In Checkbox is selected by default from Concierge site";
			if (testStatus == "PASSED") {
				visibilityStatus = objOptinPIN_Main.verifyOptInCheckedDefaultConcierge(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			} else {
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
				testStatus = "SKIPPED";
			}

			testStep = "Verify check/uncheck the 'Opt in PIN Verification for security' option from Concierge EDIT Profile Page";
			visibilityStatus = objOptinPIN_Main.verifyOptInCheckUncheckConcierge(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				testStatus = "PASSED";
			} else {
				if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				testStatus = "FAILED";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Concierge.Profile")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objOptinPIN_Test.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
		System.out.println("Concierge Company Name and EMail: " + conciergeCompanyName);
		utillLogger.info("//--------------------------------------------------------------------------------------//");
		for (Map.Entry<String, String> entry : conciergeCompanyName.entrySet()) {
			System.out.println("DEV_TC_1128: Verification of Secure PIN Check and Uncheck Validations = "
					+ "Concierge Company Created Data = " + conciergeCompanyName.size() + " - " + entry.getKey() + " - "
					+ entry.getValue());
			utillLogger.info("DEV_TC_1128: Verification of Secure PIN Check and Uncheck Validations = "
					+ "Concierge Company Created Data = " + conciergeCompanyName.size() + " - " + entry.getKey() + " - "
					+ entry.getValue());
		}
		utillLogger.info("//--------------------------------------------------------------------------------------//");
	}
}
