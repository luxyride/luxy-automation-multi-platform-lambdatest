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

public class DEV_TC_1607_VerifyTheFunctionalityOfActivationOrDeactivationOfAffiliatesInDispatchPortal_Main
		extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
	TestBase objTestBase;

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
	WebElement affiliateTab;

	@FindBy(xpath = "(//a[normalize-space()='Add Affiliate'])[1]")
	WebElement addAffiliateBtn;

	@FindBy(xpath = "(//a[normalize-space()='Active Affiliates'])[1]")
	WebElement activeAffiliate;

	@FindBy(xpath = "(//a[normalize-space()='Inactive Affiliates'])[1]")
	WebElement inActiveAffiliate;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBar;

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

	public DEV_TC_1607_VerifyTheFunctionalityOfActivationOrDeactivationOfAffiliatesInDispatchPortal_Main(
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
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
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

	public void clickAffiliateTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliateTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSearchBar(Boolean visibilityStatus) {
		if (searchBar.isDisplayed()) {
			visibilityStatus = true;
		} else {
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void enterSearchInput() {
		action = new Actions(driver);
		searchBar.sendKeys(prop.getProperty("affiliateMail"));
		action.sendKeys(Keys.TAB).build().perform();
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
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(searchBar));

				if (displayStatus.isDisplayed()) {
					searchBar.sendKeys(prop.getProperty("affiliateMail"));
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
			if (scenarioPage == "Active" && deactivateAffiliateBtn.size() != 0) {
				if (deactivateAffiliateBtn.get(0).isDisplayed()) {
					action.moveToElement(deactivateAffiliateBtn.get(0)).click().build().perform();
					objTestBase.defaultWaitTime(2000);
					chooseReasonFromDropDown();
					objTestBase.defaultWaitTime(2000);
					visibilityStatus = true;
				} else
					visibilityStatus = false;
			} else if (scenarioPage == "Inactive" && activateAffiliateBtn.size() != 0) {
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
			objTestBase.defaultWaitTime(1000);
			yesBtn.click();
			objTestBase.defaultWaitTime(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(successMessage));

			if (displayStatus.isDisplayed() && successMessage.getText().toLowerCase().contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
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

	public void clickonInActiveAffiliateTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(inActiveAffiliate).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfActiveAffiliate(Boolean visibilityStatus) {
		try {
			if (inActiveStatus.size() == 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfDeActivateBtn(Boolean visibilityStatus) {
		if (inActivateBtn.isDisplayed()) {
			visibilityStatus = true;
		} else {
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfDeActivatepopup(Boolean visibilityStatus) {
		try {
			if (inActivateBtn.isDisplayed()) {
				inActivateBtn.click();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfActivateBtn(Boolean visibilityStatus) {
		if (activateBtn.isDisplayed()) {
			visibilityStatus = true;
		} else {
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfActivatepopup(Boolean visibilityStatus) {
		try {
			if (activateBtn.isDisplayed()) {
				activateBtn.click();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void chooseReasonFromDropDown() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			Select select = new Select(inActiveDrpdwn);
			select.selectByVisibleText(prop.getProperty("inActiveReason"));
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
