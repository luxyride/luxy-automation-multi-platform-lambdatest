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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1820_VerifyTheAvailabilityOfActiveAndInactiveCoverageZonesInDispatchPortalUnderSettings_Main
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

	@FindBy(xpath = "(//span[normalize-space()='Settings'])[1]")
	WebElement settingsTab;
	
	@FindBy(xpath = "(//span[normalize-space()='Users'])[1]")
	WebElement userTab;
	
	@FindBy(xpath = "(//span[normalize-space()='Coverage Zones'])[1]")
	WebElement coverageZones;
	
	@FindBy(xpath = "(//span[normalize-space()='Notifications'])[1]")
	WebElement notification;
	
	@FindBy(xpath = "(//span[normalize-space()='User Profile'])[1]")
	WebElement userProfile;

	@FindBy(xpath = "(//a[normalize-space()='Active Coverage Zones'])[1]")
	WebElement activeZoneTab;
	
	@FindBy(xpath = "(//a[normalize-space()='Inactive Coverage Zones'])[1]")
	WebElement InactiveZoneTab;
	
	TestBase objTestBase;

	public DEV_TC_1820_VerifyTheAvailabilityOfActiveAndInactiveCoverageZonesInDispatchPortalUnderSettings_Main(
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

	public Boolean visibilityOfDropDownList(Boolean visibilityStatus) {
		try {
			if (userTab.isDisplayed()&&userProfile.isDisplayed()&&notification.isDisplayed()&&coverageZones.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnCoverageZone() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(coverageZones).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}			
	}

	public Boolean visibilityOfActiveAndInactiveTabs(Boolean visibilityStatus) {
		try {
			if (activeZoneTab.isDisplayed() &&  InactiveZoneTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}
}
