package Dispatch.Affiliate;

import common.TestBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1555_VerifyFunctionalityOfDeductingAmountInAffiliatePaymentOfAffiliateTabInDispatch_Main
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

	TestBase objTestBase;

	public DEV_TC_1555_VerifyFunctionalityOfDeductingAmountInAffiliatePaymentOfAffiliateTabInDispatch_Main(
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
				objTestBase.defaultWaitTime(1000);
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
				objTestBase.defaultWaitTime(500);

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
}
