package Dispatch.Affiliate;

import common.TestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1874_VerifyTheFunctionalityOfApplicantStatusInDispatchAffiliatePortals_Test extends TestBase {

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

	DEV_TC_1874_VerifyTheFunctionalityOfApplicantStatusInDispatchAffiliatePortals_Main objVerifySighninMain;
	DEV_TC_1874_VerifyTheFunctionalityOfApplicantStatusInDispatchAffiliatePortals_Test objVerifySighninTest;
	UpdateExtentReportResults objupdateResults;
	TestBase objTestBase;

	@BeforeClass(groups = "Dispatch.Affiliate")
	@Parameters({ "browser" })
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
			objVerifySighninMain = new DEV_TC_1874_VerifyTheFunctionalityOfApplicantStatusInDispatchAffiliatePortals_Main(
					driver);
			objVerifySighninTest = new DEV_TC_1874_VerifyTheFunctionalityOfApplicantStatusInDispatchAffiliatePortals_Test();
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
				objVerifySighninMain.eMailInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.passwordInput();
				objTestBase.defaultWaitTime(1000);
				objVerifySighninMain.eyeIconClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = objVerifySighninMain.visibilityOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
					else
						browserStackTestStatusUpdate("passed", testStep);
					objVerifySighninMain.clickSigninButton();
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

				objVerifySighninMain.clickNewBooking();
				objTestBase.defaultWaitTime(3000);

				testStep = "Verification of Dispatch Portal Login With Valid Credentials";
				visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUser(visibilityStatus);
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

				if (testStatus == "PASSED") {
					testStep = "Verification of Affiliates Page Navigation";
					visibilityStatus = objVerifySighninMain.verifyAffiliatesPageNavigationTab(visibilityStatus);
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
				} else
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);

				if (testStatus == "PASSED") {
					testStep = "Verification of Affiliate Payment Button Visibility Under Actions";
					visibilityStatus = objVerifySighninMain.verifySearchAffiliate(visibilityStatus);
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

					objTestBase.defaultWaitTime(2000);
					objVerifySighninMain.clickOnEditIcon();
					objTestBase.defaultWaitTime(2000);

					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,300)", "");
					objTestBase.defaultWaitTime(2000);

					if (testStatus == "PASSED") {
						testStep = "Verification of Applicant Status drop down.";
						visibilityStatus = objVerifySighninMain.verifyApplicantStatusDropDown(visibilityStatus);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);

						objTestBase.defaultWaitTime(2000);
						driver.navigate().refresh();

						objTestBase.defaultWaitTime(2000);
						driver.get(prop.getProperty("affiliateURL"));
						driver.manage().window().maximize();
						objTestBase.defaultWaitTime(2000);

						testStep = "Verify visiblity of affiliate Page";
						visibilityStatus = objVerifySighninMain.verifyAffiliatePageLoad(visibilityStatus);
						objTestBase.defaultWaitTime(1000);
						if (visibilityStatus.booleanValue() == true) {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
										exception);
							else
								browserStackTestStatusUpdate("passed", testStep);
							testStatus = "PASSED";
						} else {
							if (localExecutionFlag == true)
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
										exception);
							else
								browserStackTestStatusUpdate("failed", testStep);
							testStatus = "FAILED";
						}
						utillLogger.info(testStep + " - " + testStatus);

						testStep = "Verification of Login with the above registered Email account after Account Activated - "
								+ eMail;
						if (visibilityStatus.booleanValue() == true) {
							testStatus = " ";
							objVerifySighninMain.eMailInputAffiliate(eMail);
							objTestBase.defaultWaitTime(1000);
							objVerifySighninMain.passwordInputAffiliate();
							objTestBase.defaultWaitTime(1000);
							objVerifySighninMain.eyeIconClickAffiliate();
							objTestBase.defaultWaitTime(1000);

							visibilityStatus = objVerifySighninMain.visibilityOfSigninButtonAffiliate(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
								testStatus = "PASSED";
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
								testStatus = "FAILED";
							}
							utillLogger.info(testStep + " - " + testStatus);

							objTestBase.defaultWaitTime(2000);

							testStep = "Verification of affiliate Portal Login With Valid Credentials";
							visibilityStatus = objVerifySighninMain.visibilityOfLoggedinUserAffiliate(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
								testStatus = "PASSED";
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
								testStatus = "FAILED";
							}
							utillLogger.info(testStep + " - " + testStatus);

							testStep = "Verify visibility of Status in Affiliate Home Page";
							visibilityStatus = objVerifySighninMain.visibilityOfStatusInAffiliatePage(visibilityStatus);
							if (visibilityStatus.booleanValue() == true) {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
											exception);
								else
									browserStackTestStatusUpdate("passed", testStep);
								testStatus = "PASSED";
							} else {
								if (localExecutionFlag == true)
									objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
											exception);
								else
									browserStackTestStatusUpdate("failed", testStep);
								testStatus = "FAILED";
							}

							utillLogger.info(testStep + " - " + testStatus);

							objTestBase.defaultWaitTime(2000);
							driver.get(prop.getProperty("dispatchURL"));
							driver.manage().window().maximize();
							objTestBase.defaultWaitTime(2000);

							if (testStatus == "PASSED") {
								testStep = "Verification of Affiliates Page Navigation";
								visibilityStatus = objVerifySighninMain
										.verifyAffiliatesPageNavigationTab(visibilityStatus);
								if (visibilityStatus.booleanValue() == true) {
									if (localExecutionFlag == true)
										objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
												exception);
									else
										browserStackTestStatusUpdate("passed", testStep);
									testStatus = "PASSED";
								} else {
									if (localExecutionFlag == true)
										objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
												exception);
									else
										browserStackTestStatusUpdate("failed", testStep);
									testStatus = "FAILED";
								}
								utillLogger.info(testStep + " - " + testStatus);
							} else
								objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep,
										exception);

							if (testStatus == "PASSED") {
								testStep = "Verification of Affiliate Payment Button Visibility Under Actions";
								visibilityStatus = objVerifySighninMain.verifySearchAffiliate(visibilityStatus);
								if (visibilityStatus.booleanValue() == true) {
									if (localExecutionFlag == true)
										objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
												exception);
									else
										browserStackTestStatusUpdate("passed", testStep);
									testStatus = "PASSED";
								} else {
									if (localExecutionFlag == true)
										objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
												exception);
									else
										browserStackTestStatusUpdate("failed", testStep);
									testStatus = "FAILED";
								}
								utillLogger.info(testStep + " - " + testStatus);

								objTestBase.defaultWaitTime(2000);
								objVerifySighninMain.clickOnEditIcon();
								objTestBase.defaultWaitTime(2000);

								js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,300)", "");
								objTestBase.defaultWaitTime(2000);

								if (testStatus == "PASSED") {
									testStep = "Verification of Applicant Status drop down.";
									visibilityStatus = objVerifySighninMain
											.verifyApplicantStatusDropDown(visibilityStatus);
									if (visibilityStatus.booleanValue() == true) {
										if (localExecutionFlag == true)
											objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS,
													testStep, exception);
										else
											browserStackTestStatusUpdate("passed", testStep);
										testStatus = "PASSED";
									} else {
										if (localExecutionFlag == true)
											objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL,
													testStep, exception);
										else
											browserStackTestStatusUpdate("failed", testStep);
										testStatus = "FAILED";
									}
									utillLogger.info(testStep + " - " + testStatus);

									objTestBase.defaultWaitTime(2000);
									objVerifySighninMain.clickOnStatusDropDown();
									objTestBase.defaultWaitTime(2000);
									if (testStatus == "PASSED") {
										testStep = "Verification of Applicant Status drop down.";
										visibilityStatus = objVerifySighninMain
												.verifyApplicantStatusDropDownList(visibilityStatus);
										if (visibilityStatus.booleanValue() == true) {
											if (localExecutionFlag == true)
												objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS,
														testStep, exception);
											else
												browserStackTestStatusUpdate("passed", testStep);
											testStatus = "PASSED";
										} else {
											if (localExecutionFlag == true)
												objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL,
														testStep, exception);
											else
												browserStackTestStatusUpdate("failed", testStep);
											testStatus = "FAILED";
										}
										utillLogger.info(testStep + " - " + testStatus);

										objTestBase.defaultWaitTime(2000);
										objVerifySighninMain.selectFromDropDown();
										objTestBase.defaultWaitTime(2000);
										objVerifySighninMain.clickOnUpdate();
										objTestBase.defaultWaitTime(2000);

										if (testStatus == "PASSED") {
											testStep = "Verification of success Message After Udpating.";
											visibilityStatus = objVerifySighninMain
													.verifySuccessMessageAfterUpdatingStatus(visibilityStatus);
											if (visibilityStatus.booleanValue() == true) {
												if (localExecutionFlag == true)
													objupdateResults.updateResults(screenshotPath, logger,
															LogStatus.PASS, testStep, exception);
												else
													browserStackTestStatusUpdate("passed", testStep);
												testStatus = "PASSED";
											} else {
												if (localExecutionFlag == true)
													objupdateResults.updateResults(screenshotPath, logger,
															LogStatus.FAIL, testStep, exception);
												else
													browserStackTestStatusUpdate("failed", testStep);
												testStatus = "FAILED";
											}										}
										utillLogger.info(testStep + " - " + testStatus);
										
										objTestBase.defaultWaitTime(2000);
										driver.get(prop.getProperty("affiliateURL"));
										driver.manage().window().maximize();
										objTestBase.defaultWaitTime(4000);
										
										testStep = "verify status should not display after updating from dispatch";
										visibilityStatus = objVerifySighninMain.VerifyvisibilityOfStatusInAffiliatePage(visibilityStatus);
										if (visibilityStatus.booleanValue() == true) {
											if (localExecutionFlag == true)
												objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep,
														exception);
											else
												browserStackTestStatusUpdate("passed", testStep);
											testStatus = "PASSED";
										} else {
											if (localExecutionFlag == true)
												objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep,
														exception);
											else
												browserStackTestStatusUpdate("failed", testStep);
											testStatus = "FAILED";
										}

										utillLogger.info(testStep + " - " + testStatus);

									}
								}
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (localExecutionFlag == true)
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			else
				browserStackTestStatusUpdate("failed", testStep + " - Exception - " + ex.toString());
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
