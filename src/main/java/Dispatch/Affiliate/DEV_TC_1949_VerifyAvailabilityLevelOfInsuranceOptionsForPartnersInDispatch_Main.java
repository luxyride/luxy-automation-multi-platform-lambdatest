package Dispatch.Affiliate;

import common.TestBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1949_VerifyAvailabilityLevelOfInsuranceOptionsForPartnersInDispatch_Main extends TestBase {

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
	WebElement affiliateTab;

	@FindBy(xpath = "(//a[normalize-space()='Add Affiliate'])[1]")
	WebElement addAffiliateBtn;

	@FindBy(xpath = "(//a[normalize-space()='Active Affiliates'])[1]")
	WebElement activeAffiliate;
	
	@FindBy(xpath = "(//span[normalize-space()='Affiliates'])[1]")
	WebElement affiliatesTab;

	@FindBy(xpath = "(//span[normalize-space()='Affiliate Details'])[1]")
	WebElement affiliateLeadsTab;
	
	@FindBy(xpath = "//th[@title='Status']")
	WebElement activeStatus;
	
	@FindBy(xpath = "(//a[normalize-space()='Inactive Affiliates'])[1]")
	WebElement inActiveAffiliate;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBar;

	@FindBy(xpath = "//*[normalize-space()='Inactive']")
	List<WebElement> inActiveStatus;

	@FindBy(xpath = "(//i[@title='Edit Affiliate User'])[1]")
	WebElement editAffiliate;

	@FindBy(xpath = "//*[normalize-space()='Affiliate Details']")
	WebElement affiliateDetailsHeader;

	@FindBy(xpath = "//label[text()='COI EXPIRATION DATE']")
	WebElement coiExpirationDateText;

	@FindBy(xpath = "//label[text()='COI EXPIRATION DATE']//following-sibling::div")
	WebElement coiExpirationDateField;

	@FindBy(xpath = "//label[text()='Commercial Insurance']")
	WebElement commercialInsuranceText;

	@FindBy(xpath = "//select[@name='affiliate_id']")
	List<WebElement> commercialInsuranceDetails;

	TestBase objTestBase;

	public DEV_TC_1949_VerifyAvailabilityLevelOfInsuranceOptionsForPartnersInDispatch_Main(WebDriver driver) {
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

	public void clickAffiliateTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliateLeadsTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliatesTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfActiveandInactiveTabs(Boolean visibilityStatus) {
		if (activeAffiliate.isDisplayed() && inActiveAffiliate.isDisplayed()) {
			visibilityStatus = true;
		} else {
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnActiveAffiliateTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(activeAffiliate).click().build().perform();
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

	public Boolean visibilityOfInsuranceOptions_COIExpirationDate_ActiveAffiliateTab(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (searchBar.isDisplayed() && editAffiliate.isDisplayed()) {
				editAffiliate.click();
				defaultWaitTime(3000);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(affiliateDetailsHeader));
				if (displayStatus.isDisplayed()) {
					js.executeScript("arguments[0].scrollIntoView(true);", coiExpirationDateText);
					js.executeScript("window.scrollBy(0,-200)", "");
					defaultWaitTime(1000);
					if (coiExpirationDateText.isDisplayed() && coiExpirationDateField.isDisplayed())
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else
					visibilityStatus = false;
				objTestBase.defaultWaitTime(1000);
			} else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfInsuranceOptions_CommercialInsurance_ActiveAffiliateTab(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			defaultWaitTime(1000);
			if (commercialInsuranceText.isDisplayed() && commercialInsuranceDetails.size() != 0) {
				Select select = new Select(commercialInsuranceDetails.get(0));
				List<WebElement> listOfOptions = select.getOptions();
				if (listOfOptions.size() >= 4)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean navigationOfInactiveAffiliateTab(Boolean visibilityStatus) {
		try {
			if (affiliateTab.isDisplayed()) {
				affiliateTab.click();
				defaultWaitTime(3000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(inActiveAffiliate));

				if (inActiveAffiliate.isDisplayed()) {
					inActiveAffiliate.click();
					defaultWaitTime(3000);
					wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					displayStatus = wait.until(ExpectedConditions.visibilityOf(editAffiliate));
					if (displayStatus.isDisplayed())
						visibilityStatus = true;
					else
						visibilityStatus = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
	
	public Boolean visibilityOfInsuranceOptions_COIExpirationDate_InActiveAffiliateTab(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (searchBar.isDisplayed() && editAffiliate.isDisplayed()) {
				editAffiliate.click();
				defaultWaitTime(3000);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(affiliateDetailsHeader));
				if (displayStatus.isDisplayed()) {
					js.executeScript("arguments[0].scrollIntoView(true);", coiExpirationDateText);
					js.executeScript("window.scrollBy(0,-200)", "");
					defaultWaitTime(1000);
					if (coiExpirationDateText.isDisplayed() && coiExpirationDateField.isDisplayed())
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else
					visibilityStatus = false;
				objTestBase.defaultWaitTime(1000);
			} else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfInsuranceOptions_CommercialInsurance_InActiveAffiliateTab(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			defaultWaitTime(1000);
			if (commercialInsuranceText.isDisplayed() && commercialInsuranceDetails.size() != 0) {
				Select select = new Select(commercialInsuranceDetails.get(0));
				List<WebElement> listOfOptions = select.getOptions();
				if (listOfOptions.size() >= 4)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
