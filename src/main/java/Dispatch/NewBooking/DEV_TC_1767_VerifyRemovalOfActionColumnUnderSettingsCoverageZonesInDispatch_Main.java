package Dispatch.NewBooking;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1767_VerifyRemovalOfActionColumnUnderSettingsCoverageZonesInDispatch_Main extends TestBase {

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

	@FindBy(xpath = "(//span[normalize-space()='Settings'])[1]")
	WebElement settingsTab;

	@FindBy(xpath = "(//span[normalize-space()='Users'])[1]")
	WebElement usersTab;

	@FindBy(xpath = "(//span[normalize-space()='Coverage Zones'])[1]")
	WebElement zonesTab;

	@FindBy(xpath = "(//span[normalize-space()='Notifications'])[1]")
	WebElement notificationTab;

	@FindBy(xpath = "(//span[normalize-space()='User Profile'])[1]")
	WebElement profileTab;

	@FindBy(xpath = "//th[@title='Company Name']")
	WebElement companyName;

	@FindBy(xpath = "//th[@title='Region']")
	WebElement region;

	@FindBy(xpath = "//th[@title='Zone Name']")
	WebElement zoneName;

	@FindBy(xpath = "//th[@title='Zone Type']")
	WebElement zoneType;

	@FindBy(xpath = "//th[@title='Airport']")
	WebElement airport;

	@FindBy(xpath = "//th[@title='City']")
	WebElement city;

	@FindBy(xpath = "//th[@title='State']")
	WebElement state;

	@FindBy(xpath = "//th[@title='Zip Codes']")
	WebElement zipcodes;

	@FindBy(xpath = "//th[@title='Place Name']")
	WebElement placeName;

	@FindBy(xpath = "//th[@title='Action']")
	WebElement actionTab;

	TestBase objTestBase;

	public DEV_TC_1767_VerifyRemovalOfActionColumnUnderSettingsCoverageZonesInDispatch_Main(WebDriver driver) {
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
		} catch (Exception ex) {
			ex.printStackTrace();
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
				objTestBase.defaultWaitTime(1000);
				if (signinUser.getText().toLowerCase().contains("welcome")) {
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

	public void clickOnSettingsDropDown() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(settingsTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifySettingsDropDownList(Boolean visibilityStatus) {
		try {
			if (usersTab.isDisplayed() && zonesTab.isDisplayed() && profileTab.isDisplayed()
					&& notificationTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnCoverageZones() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(zonesTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifycoloumnsInCoverageZonePage(Boolean visibilityStatus) {
		try {
			if (companyName.isDisplayed() && region.isDisplayed() && zoneName.isDisplayed() && zoneType.isDisplayed()
					&& airport.isDisplayed() && state.isDisplayed() && city.isDisplayed() && zipcodes.isDisplayed()
					&& placeName.isDisplayed() && !actionTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}
}
