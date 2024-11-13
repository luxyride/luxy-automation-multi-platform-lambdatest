package Dispatch.NewBooking;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1688_VerifyTheAvailabilityOfColumnsInDispatchPortalForSpecialEvents_Main extends TestBase {
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

	@FindBy(xpath = "(//span[normalize-space()='Special Events'])[1]")
	WebElement specialEvents;

	@FindBy(xpath = "(//span[normalize-space()='Settings'])[1]")
	WebElement settingsTab;

	@FindBy(xpath = "(//button[contains(text(),'Welcome')])[1]")
	WebElement welcomedropdown;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//th[@title='Action']")
	WebElement actionColumn;

	@FindBy(xpath = "//th[@title='Quote Number']")
	WebElement qouteColumn;

	@FindBy(xpath = "//th[@title='Pickup']")
	WebElement pickColumn;

	@FindBy(xpath = "//th[@title='Dropoff']")
	WebElement dropColumn;

	@FindBy(xpath = "//th[@title='Date']")
	WebElement dateColumn;

	@FindBy(xpath = "//th[@title='No of passengers']")
	WebElement passengersColumn;

	@FindBy(xpath = "//th[@title='No of luggage']")
	WebElement luggageColumn;

	@FindBy(xpath = "//th[@title='No of Hours']")
	WebElement hoursColumn;

	@FindBy(xpath = "//th[@title='Trip confirmation number']")
	WebElement tipColumn;

	@FindBy(xpath = "//th[@title='Company name']")
	WebElement companyColumn;

	@FindBy(xpath = "//th[@title='Email']")
	WebElement statusColumn;

	@FindBy(xpath = "//th[@title='Status']")
	WebElement emailColumn;

	TestBase objTestBase;

	public DEV_TC_1688_VerifyTheAvailabilityOfColumnsInDispatchPortalForSpecialEvents_Main(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objTestBase = new TestBase();
	}

	public void eMailInput() {
		action = new Actions(driver);
		eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void passwordInput() {
		action = new Actions(driver);
		passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
	}

	public void eyeIconClick() {
		action = new Actions(driver);
		action.moveToElement(eyeIcon).click().build().perform();
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			if (signInBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public void clickOnSettingsTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(settingsTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSpecialEventsTabInMenu(Boolean visibilityStatus) {
		try {
			if (specialEvents.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickspecialEventsTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(specialEvents).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfcolumnsInSpecialEventsPage(Boolean visibilityStatus) {
		try {
			if (actionColumn.isDisplayed() && qouteColumn.isDisplayed() && pickColumn.isDisplayed()
					&& dropColumn.isDisplayed() && dateColumn.isDisplayed() && actionColumn.isDisplayed()
					&& passengersColumn.isDisplayed() && luggageColumn.isDisplayed() && actionColumn.isDisplayed()
					&& companyColumn.isDisplayed() && emailColumn.isDisplayed() && statusColumn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

}