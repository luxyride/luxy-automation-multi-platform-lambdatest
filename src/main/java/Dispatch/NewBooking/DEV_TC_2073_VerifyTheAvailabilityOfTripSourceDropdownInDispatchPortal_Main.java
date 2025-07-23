package Dispatch.NewBooking;

import common.TestBase;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_2073_VerifyTheAvailabilityOfTripSourceDropdownInDispatchPortal_Main extends TestBase {

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
	WebElement ridesSection;
	
	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAll;
	
	@FindBy(xpath = "//select[@name='trip_source']")
	WebElement tripSource;

	@FindBy(xpath = "//option[@value='Concierge']")
	WebElement concierge;
	
	@FindBy(xpath = "(//option[@value='Phone'])[1]")
	WebElement phone;
	
	@FindBy(xpath = "//option[@value='Web']")
	WebElement web;
	
	@FindBy(xpath = "//option[@value='Mobile']")
	WebElement mobile;
	
	@FindBy(xpath = "//select[@name='trip_source']")
	WebElement travelArranger;
	
	@FindBy(xpath = "//option[@value='Starred']")
	WebElement starred;
	
	@FindBy(xpath = "(//img[@title='Concierge'])[1]")
	WebElement conciergeRidesList;
	
	@FindBy(xpath = "(//img[@title='Travel Arranger'])[2]")
	WebElement travelArrangerRidesList;
	
	@FindBy(xpath = "(//img[@title='Luxy Dispatch'])[1]")
	WebElement phoneRidesList;
	
	@FindBy(xpath = "(//img[@title='Customer Web'])[1]")
	WebElement webRidesList;
	
	@FindBy(xpath = "(//img[@title='Customer App'])[1]")
	WebElement mobileRidesList;
	
	@FindBy(xpath = "(//i[@class='fas fa-star text-warning'])")
	WebElement starredRidesList;

	
	
	TestBase objTestBase;

	public DEV_TC_2073_VerifyTheAvailabilityOfTripSourceDropdownInDispatchPortal_Main(WebDriver driver) {
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
	
	public void clickRidesSection() {
		try {
			action = new Actions(driver);
			action.moveToElement(ridesSection).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Boolean visibilityOfRidesAllPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(ridesTabAll).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfTripSource(Boolean visibilityStatus) {
		try {
			if (tripSource.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}

	public void clickOnTripSource() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(tripSource).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfTripSourceList(Boolean visibilityStatus) {
		try {
			if (web.isDisplayed() &&  travelArranger.isDisplayed() && concierge.isDisplayed() && phone.isDisplayed() && mobile.isDisplayed()&& starred.isDisplayed() )
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}

}
