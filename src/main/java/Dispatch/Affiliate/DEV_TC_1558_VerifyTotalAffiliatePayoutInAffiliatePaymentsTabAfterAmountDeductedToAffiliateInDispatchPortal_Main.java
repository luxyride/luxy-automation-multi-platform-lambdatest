package Dispatch.Affiliate;

import java.util.List;
import common.TestBase;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1558_VerifyTotalAffiliatePayoutInAffiliatePaymentsTabAfterAmountDeductedToAffiliateInDispatchPortal_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//span[normalize-space()='Affiliates'])[1]")
	WebElement affiliatesTab;

	@FindBy(xpath = "(//span[normalize-space()='Affiliate Payments'])[1]")
	WebElement affiliatePaymentsTab;

	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	WebElement searchAffiliate;

	@FindBy(xpath = "//td[normalize-space()='There is no data to display']")
	List<WebElement> noDataMsg;

	@FindBy(xpath = "//a[normalize-space()='Inactive Affiliates']")
	WebElement inActiveTab;

	@FindBy(xpath = "(//i[@title='Affiliate Payment'])[1]")
	WebElement affiliatePaymentBtn;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[2]//following-sibling::input")
	WebElement affiliateConfirmationNumberDeduction;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[3]//following-sibling::input")
	WebElement affiliateConfirmationAmount;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[4]//following-sibling::input")
	WebElement affiliateConfirmationReason;

	@FindBy(xpath = "(//div[normalize-space()='PAYMENT METHOD'])[1]")
	WebElement affiliatePaymentMethod;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement affiliatePaymentCancelBtn;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	WebElement affiliatePaymentCreateBtn;

	@FindBy(xpath = "(//*[(@role='alert')])[1]")
	WebElement alertMessge;

	@FindBy(xpath = "(//a[normalize-space()='Active Affiliates'])[1]")
	WebElement activeAffiliate;

	@FindBy(xpath = "(//a[normalize-space()='Inactive Affiliates'])[1]")
	WebElement inActiveAffiliate;

	@FindBy(xpath = "(//td[normalize-space()='Active'])[1]")
	List<WebElement> activeStatus;

	@FindBy(xpath = "(//td[normalize-space()='Inactive'])[1]")
	List<WebElement> inActiveStatus;

	@FindBy(xpath = "(//i[@title='Deactivate Affiliate'])[1]")
	WebElement inActivateBtn;

	@FindBy(xpath = "(//i[@title='Activate Affiliate'])[1]")
	WebElement activateBtn;

	@FindBy(xpath = "(//button[normalize-space()='Yes'])[1]")
	WebElement yesBtn;

	@FindBy(xpath = "(//*[@role='alert'])[1]")
	WebElement successMessage;

	@FindBy(xpath = "//div[@class='rides-list mainDiactivateModelDiv']")
	WebElement deactivatePopup;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[1]//following-sibling::select")
	WebElement inActiveDrpdwn;

	@FindBy(xpath = "//i[@title='Deactivate Affiliate']")
	List<WebElement> deactivateAffiliateBtn;

	@FindBy(xpath = "//i[@title='Activate Affiliate']")
	List<WebElement> activateAffiliateBtn;

	@FindBy(xpath = "//select[@name='affiliate_id']")
	WebElement affiliateID;

	@FindBy(xpath = "//p[contains(normalize-space(),'Rides Payout')]")
	List<WebElement> ridesPayout;

	@FindBy(xpath = "//p[contains(normalize-space(),'Extra Payout')]")
	List<WebElement> extraPayout;

	@FindBy(xpath = "//p[contains(normalize-space(),'Total Payout')]")
	List<WebElement> totalPayout;

	@FindBy(xpath = "//p[contains(normalize-space(),'Rides Payout')]//b")
	List<WebElement> ridesPayoutAmount;

	@FindBy(xpath = "//p[contains(normalize-space(),'Extra Payout')]//b")
	List<WebElement> extraPayoutAmount;

	@FindBy(xpath = "//p[contains(normalize-space(),'Total Payout')]//b")
	List<WebElement> totalPayoutAmount;

	@FindBy(xpath = "//button[normalize-space()='Click to Process']")
	List<WebElement> clickToProcess;

	@FindBy(xpath = "(//*[normalize-space()='Extra Payments'])[1]")
	List<WebElement> confirmPaymentsPopup;

	@FindBy(xpath = "//select[@class='form-control col-sm-12']")
	WebElement selectWeek;

	@FindBy(xpath = "(//a[normalize-space()='Extra Payments'])[1]")
	WebElement extraPaymentTab;

	@FindBy(xpath = "//td[normalize-space()='Processed']")
	List<WebElement> processedStatus;

	TestBase objTestBase;

	public DEV_TC_1558_VerifyTotalAffiliatePayoutInAffiliatePaymentsTabAfterAmountDeductedToAffiliateInDispatchPortal_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eyeIconClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			if (signInBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickSigninButton() {
		try {
			signInBtn.click();
			// Validate Dispatch 2fa Authentication:
//			Boolean visibilityStatus = false;
//			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickNewBooking() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbooking).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUser);
			if (signinUser.isDisplayed()) {
				expected = signinUser.getText();
				if (expected.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatePaymentsPageNavigationTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliatesTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);

			for (int i = 0; i <= 7; i++) {
				action.sendKeys(Keys.DOWN).build().perform();
				objTestBase.defaultWaitTime(500);
			}

			action.moveToElement(affiliatePaymentsTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatesPageNavigationTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliatesTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);

			expected = driver.getCurrentUrl();
			objTestBase.defaultWaitTime(1000);
			if (expected.toLowerCase().contains("affiliate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliateSelectionFromAffiliatePaymentsPage(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("payments")) {
				Select select = new Select(affiliateID);
				select.selectByVisibleText(prop.getProperty("affiliateCompanyName"));
				objTestBase.defaultWaitTime(3000);

				if (ridesPayout.size() != 0 && extraPayout.size() != 0 && totalPayout.size() != 0)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfClickToProcessOptionFromAffiliatePaymentsPage(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("payments")) {
				Select select = new Select(affiliateID);
				select.selectByVisibleText(prop.getProperty("affiliateCompanyName"));
				objTestBase.defaultWaitTime(3000);

				if (ridesPayout.size() != 0 && extraPayout.size() != 0 && totalPayout.size() != 0
						&& clickToProcess.size() != 0)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean selectweek(Boolean visibilityStatus) {
		try {
			Select select = new Select(selectWeek);
			List<WebElement> listOptions = select.getOptions();
			listOptions.get(1).click();
			objTestBase.defaultWaitTime(3000);
			visibilityStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfConfirmPaymentPopup(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("payments")) {
				if (confirmPaymentsPopup.size() != 0 && yesBtn.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyPaymentsButtonVisibilityUnderActions(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			searchAffiliate.click();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(searchAffiliate).click().sendKeys(prop.getProperty("affiliateMail")).build().perform();
			objTestBase.defaultWaitTime(5000);

			if (noDataMsg.size() != 0) {
				action.moveToElement(inActiveTab).click().build().perform();
				objTestBase.defaultWaitTime(5000);
				action.moveToElement(searchAffiliate).click().sendKeys(prop.getProperty("affiliateMail")).build()
						.perform();
				objTestBase.defaultWaitTime(5000);
			}

			if (affiliatePaymentBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatesPaymentsPage(Boolean visibilityStatus) {
		try {
			if (affiliatePaymentBtn.isDisplayed()) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(affiliatePaymentBtn).click().build().perform();
				objTestBase.defaultWaitTime(3000);

				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("payments"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatesPaymentsFillingDetails(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliateConfirmationNumberDeduction).click()
					.sendKeys(prop.getProperty("affiliateConfirmationNumberDeduction")).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliateConfirmationAmount).click()
					.sendKeys(prop.getProperty("affiliateConfirmationDeductionAmount")).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliateConfirmationReason).click()
					.sendKeys(prop.getProperty("affiliateConfirmationDeductionReason")).build().perform();
			objTestBase.defaultWaitTime(1000);

			action.moveToElement(affiliatePaymentMethod).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliatePaymentMethod).sendKeys(prop.getProperty("affiliatePaymentMethodDeduction"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);

			if (affiliatePaymentCancelBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatesPaymentsCancellation(Boolean visibilityStatus) {
		try {
			if (affiliatePaymentCancelBtn.isDisplayed()) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(affiliatePaymentCancelBtn).click().build().perform();
				objTestBase.defaultWaitTime(5000);

				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("manage"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatesPaymentsConfirmationMsg(Boolean visibilityStatus) {
		try {
			String msgText = "";
			if (affiliatePaymentCreateBtn.isDisplayed()) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(affiliatePaymentCreateBtn).click().build().perform();
				objTestBase.defaultWaitTime(1000);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
				if (displayStatus.isDisplayed()) {
					objTestBase.defaultWaitTime(500);
					msgText = alertMessge.getText().toLowerCase();
					visibilityStatus = true;
				} else
					visibilityStatus = false;
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus == true && msgText.contains("successfully"))
					visibilityStatus = true;
				else
					visibilityStatus = false;

			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatesPaymentsHistory(Boolean visibilityStatus) {
		try {
			if (searchAffiliate.isDisplayed()) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(searchAffiliate).click()
						.sendKeys(prop.getProperty("affiliateConfirmationNumberDeduction")).build().perform();
				objTestBase.defaultWaitTime(5000);

				if (noDataMsg.size() == 0)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickAffiliateTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliatesTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfsearchAffiliate(Boolean visibilityStatus) {
		if (searchAffiliate.isDisplayed()) {
			visibilityStatus = true;
		} else {
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void enterSearchInput() {
		action = new Actions(driver);
		searchAffiliate.sendKeys(prop.getProperty("affiliateMail"));
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void clickonActiveAffiliateTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(activeAffiliate).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnInActiveAffiliateTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(inActiveAffiliate).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String visibilityOfActivateInactivateStatus(String scenarioPage) {
		try {
			objTestBase.defaultWaitTime(3000);
			if (activeStatus.size() != 0)
				scenarioPage = "Active";
			else {
				inActiveAffiliate.click();
				objTestBase.defaultWaitTime(3000);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(searchAffiliate));

				if (displayStatus.isDisplayed()) {
					searchAffiliate.sendKeys(prop.getProperty("affiliateMail"));
					action.sendKeys(Keys.TAB).build().perform();

					if (inActiveStatus.size() != 0)
						scenarioPage = "Inactive";
					else
						scenarioPage = "Error";
				} else
					scenarioPage = "Error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			scenarioPage = "Error";
		}
		return scenarioPage;
	}

	public Boolean visibilityOfpopup(Boolean visibilityStatus, String scenarioPage) {
		try {
			action = new Actions(driver);
			if (scenarioPage == "Inactive" && activateAffiliateBtn.size() != 0) {
				if (activateAffiliateBtn.get(0).isDisplayed()) {
					action.moveToElement(activateAffiliateBtn.get(0)).click().build().perform();
					objTestBase.defaultWaitTime(2000);
					visibilityStatus = true;
				} else
					visibilityStatus = false;
			}
			objTestBase.defaultWaitTime(2000);
			if (yesBtn.isDisplayed()) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfAlertSuccessMessage(Boolean visibilityStatus) {
		try {
			if (clickToProcess.size() != 0) {
				objTestBase.defaultWaitTime(1000);
				clickToProcess.get(0).click();
				objTestBase.defaultWaitTime(3000);
				yesBtn.click();
				objTestBase.defaultWaitTime(1000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(successMessage));

				if (displayStatus.isDisplayed() && successMessage.getText().toLowerCase().contains("successfully")
						|| successMessage.getText().toLowerCase().contains("processed"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfSearchBar(Boolean visibilityStatus) {
		try {
			if (searchAffiliate.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyPaymentStatusInExtraPaymentsTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			extraPaymentTab.click();
			objTestBase.defaultWaitTime(5000);
			searchAffiliate.click();
			objTestBase.defaultWaitTime(1000);

			action.moveToElement(searchAffiliate).click()
					.sendKeys(prop.getProperty("affiliateConfirmationNumberDeduction")).build().perform();
			objTestBase.defaultWaitTime(5000);

			if (processedStatus.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyPayoutsAmountAfterProcessed(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("payments")) {
				Select select = new Select(affiliateID);
				select.selectByVisibleText(prop.getProperty("affiliateCompanyName"));
				objTestBase.defaultWaitTime(3000);

				if (ridesPayoutAmount.size() != 0 && extraPayoutAmount.size() != 0 && totalPayoutAmount.size() != 0) {
					if (ridesPayoutAmount.get(0).getText().contains("0.00")
							&& extraPayoutAmount.get(0).getText().contains("0.00")
							&& totalPayoutAmount.get(0).getText().contains("0.00"))
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

}
