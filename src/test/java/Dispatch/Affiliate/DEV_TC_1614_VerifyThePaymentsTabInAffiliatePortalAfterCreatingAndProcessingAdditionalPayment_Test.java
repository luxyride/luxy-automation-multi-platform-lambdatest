package Dispatch.Affiliate;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1614_VerifyThePaymentsTabInAffiliatePortalAfterCreatingAndProcessingAdditionalPayment_Test
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
	String scenarioPage;

	DEV_TC_1614_VerifyThePaymentsTabInAffiliatePortalAfterCreatingAndProcessingAdditionalPayment_Main objVerifySighninMain;
	DEV_TC_1614_VerifyThePaymentsTabInAffiliatePortalAfterCreatingAndProcessingAdditionalPayment_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.Affiliate")
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		try {
			objTestBase = new TestBase();
			driver = objTestBase.launchBrowser(browser, driver, getClass().getSimpleName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(groups = "Dispatch.Affiliate")
	public void VerifySignInWithValidCredentials_Test() throws Exception {

		try {
			action = new Actions(driver);
			objVerifySighninMain = new DEV_TC_1614_VerifyThePaymentsTabInAffiliatePortalAfterCreatingAndProcessingAdditionalPayment_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1614_VerifyThePaymentsTabInAffiliatePortalAfterCreatingAndProcessingAdditionalPayment_Test();
			objTestBase = new TestBase();
			objupdateResults = new UpdateExtentReportResults(driver);

			logger = extent.startTest(objVerifySighninTest.getClass().getSimpleName());
			utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
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
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
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

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
				utillLogger.info(testStep + " - " + testStatus);
				objTestBase.defaultWaitTime(1000);
				if (testStatus == "PASSED") {
					testStep = "Verification of Affiliates Page Navigation";
					visibilityStatus = objVerifySighninMain.verifyAffiliatesPageNavigationTab(visibilityStatus);
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

				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.enterSearchInput();
				objTestBase.defaultWaitTime(3000);

				scenarioPage = objVerifySighninMain.visibilityOfActivateInactivateStatus(scenarioPage);
				testStep = "Verify and Activate affiliate account if the affiliate is in inActive Status "
						+ scenarioPage + " Affiliate Page";
				if (visibilityStatus.booleanValue() == true)
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
				else
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
				utillLogger.info(testStep + " - " + testStatus);

				/// affiliate log in -
				objTestBase.defaultWaitTime(3000);
				driver.get(prop.getProperty("affiliateURL"));
				driver.manage().window().maximize();
				objTestBase.defaultWaitTime(2000);

				currURL = driver.getCurrentUrl();
				testStep = "Verification of affiliate Portal Loginpage ";

				if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}

				if (testStatus == "PASSED") {
					testStatus = " ";
					objVerifySighninMain.affiliateeMailInput();
					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.affiliatepasswordInput();
					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.affiliateeyeIconClick();
					objTestBase.defaultWaitTime(1000);

					visibilityStatus = objVerifySighninMain.affiliatevisibilityOfSigninButton(visibilityStatus);
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
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.clickOnPayments();
					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.clickOnAffiliatePayments();
					objTestBase.defaultWaitTime(3000);
					testStep = "Verification of payments DashBoard Rides Payout And Extra PayOut";
					visibilityStatus = objVerifySighninMain
							.visibilityOfRidesPayoutAndExtraPayOutAndTotalPayOut(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					utillLogger.info(testStep + " - " + testStatus);
					objTestBase.defaultWaitTime(3000);

					driver.get(prop.getProperty("dispatchURL"));
					driver.manage().window().maximize();
					objTestBase.defaultWaitTime(3000);

					objVerifySighninMain.clickNewBooking();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of Dispatch Portal Login With Valid Credentials";
					visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					utillLogger.info(testStep + " - " + testStatus);
					objTestBase.defaultWaitTime(1000);
					if (testStatus == "PASSED") {
						testStep = "Verification of Affiliates Page Navigation";
						visibilityStatus = objVerifySighninMain.verifyAffiliatesPageNavigationTab(visibilityStatus);
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
					objTestBase.defaultWaitTime(1000);

					if (testStatus == "PASSED") {
						testStep = "Verification of Affiliate Payment Button Visibility Under Actions";
						visibilityStatus = objVerifySighninMain
								.verifyPaymentsButtonVisibilityUnderActions(visibilityStatus);
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
					objTestBase.defaultWaitTime(1000);
					if (testStatus == "PASSED") {
						testStep = "Verification of Affiliate Payments Page Navigation";
						visibilityStatus = objVerifySighninMain.verifyAffiliatesPaymentsPage(visibilityStatus);
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

					if (testStatus == "PASSED") {
						testStep = "Verification of filling the Affiliate Payments details for Addition Payment Method";
						visibilityStatus = objVerifySighninMain
								.verifyAffiliatesPaymentsFillingDetails(visibilityStatus);
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
					objTestBase.defaultWaitTime(1000);

					if (testStatus == "PASSED") {
						testStep = "Verification of Affiliate Payments Confirmation message displayed for Addition Payment Method.?";
						visibilityStatus = objVerifySighninMain
								.verifyAffiliatesPaymentsConfirmationMsg(visibilityStatus);
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

					objTestBase.defaultWaitTime(1000);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);

					//// navigate to affiliate portal to check processed status without clicking on
					//// processing amount

					driver.get(prop.getProperty("affiliateURL"));
					driver.manage().window().maximize();
					objTestBase.defaultWaitTime(3000);

					currURL = driver.getCurrentUrl();
					testStep = "Verification of affiliate Portal Loginpage ";

					if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.clickOnPayments();
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.clickOnAffiliatePayments();
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.clickOnSelectWeek();
					objTestBase.defaultWaitTime(3000);

					testStep = "Verification of process status after creating a amount from dispatch without clicking process ";
					visibilityStatus = objVerifySighninMain.visibilityOfPaymentswithProcessedstatus(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					//// now redirect to dispatch portal again and check affiliate payments tab

					driver.get(prop.getProperty("dispatchURL"));
					driver.manage().window().maximize();
					objTestBase.defaultWaitTime(2000);

					currURL = driver.getCurrentUrl();

					if (currURL.toLowerCase().contains(prop.getProperty("dispatchenv"))) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objTestBase.defaultWaitTime(1000);
					objVerifySighninMain.clickOnAffiliatePayments();
					objTestBase.defaultWaitTime(3000);
					objVerifySighninMain.clickOnExtraPayments();
					objTestBase.defaultWaitTime(3000);
					testStep = "Verification of extra payments rides data ";
					visibilityStatus = objVerifySighninMain.visibilityOfExtraPaymentsRidesData(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.clickOnSelectAffiliate();
					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.clickOnSelectWeek();
					objTestBase.defaultWaitTime(2000);
					testStep = "Visibility of click process button  ";
					visibilityStatus = objVerifySighninMain.visibilityOfProcessButton(visibilityStatus);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}
					
					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.clickOnProcessButton();
					objTestBase.defaultWaitTime(2000);

					//// affiliate portal and check now processed status after updating from
					//// dispatch

					driver.get(prop.getProperty("affiliateURL"));
					driver.manage().window().maximize();
					objTestBase.defaultWaitTime(2000);

					currURL = driver.getCurrentUrl();
					testStep = "Verification of affiliate Portal Loginpage ";

					if (currURL.toLowerCase().contains(prop.getProperty("environment"))) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
						testStatus = "FAILED";
					}

				}

				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.clickOnPayments();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickOnAffiliatePayments();
				objTestBase.defaultWaitTime(3000);
				objVerifySighninMain.clickOnSelectWeek();
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification of process status after updating from dispatch after clicking on process ";
				visibilityStatus = objVerifySighninMain.visibilityOfPaymentswithProcessedstatus(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	lambdaTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
					testStatus = "FAILED";
				}
			}

		} catch (

		Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
			utillLogger.info(testStep + " - " + testStatus + " - " + ex.toString());
		}
	}

	@AfterClass(groups = "Dispatch.Affiliate")
	public void afterClass() {
		driver.quit();
		utillLogger.info("## " + objVerifySighninTest.getClass().getSimpleName()
				+ " - END --------------------------------------------------------------##");
	}

}
