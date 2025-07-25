package Dispatch.Login;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_2350_VerifyTheAvailabilityAndFunctionalityOfNewlyCreatedDropdownMenusWithSubTabs_Main extends TestBase {

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
	
	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesMenu;
	
	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement passengers;
	
	@FindBy(xpath = "(//span[normalize-space()='Corporate Details'])[1]")
	WebElement corporateMenu;
	
	@FindBy(xpath = "(//span[normalize-space()='Travel Agency'])[1]")
	WebElement travelAgencyMenu;
	
	@FindBy(xpath = "(//span[normalize-space()='Affiliate Details'])[1]")
	WebElement affiliateMenu;
	
	@FindBy(xpath = "(//span[normalize-space()='Special Events'])[1]")
	WebElement specialEvents;
	
	@FindBy(xpath = "(//span[normalize-space()='Pricing'])[1]")
	WebElement pricingMenu;
	
	@FindBy(xpath = "(//span[normalize-space()='Settings'])[1]")
	WebElement settingsMenu;

	TestBase objTestBase;

	public DEV_TC_2350_VerifyTheAvailabilityAndFunctionalityOfNewlyCreatedDropdownMenusWithSubTabs_Main(WebDriver driver) {
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

	public Boolean visibilityOfDispatchMenu(Boolean visibilityStatus) {
		try {
			if (newbooking.isDisplayed() && ridesMenu.isDisplayed() && passengers.isDisplayed()&& corporateMenu.isDisplayed() && travelAgencyMenu.isDisplayed()&& affiliateMenu.isDisplayed()&& pricingMenu.isDisplayed() && settingsMenu.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}
}
