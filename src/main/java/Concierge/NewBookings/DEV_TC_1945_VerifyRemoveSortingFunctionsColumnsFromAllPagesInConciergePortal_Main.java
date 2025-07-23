package Concierge.NewBookings;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1945_VerifyRemoveSortingFunctionsColumnsFromAllPagesInConciergePortal_Main extends TestBase {

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
	
	@FindBy(xpath = "(//span[normalize-space()='in progress'])[1]")
	WebElement inProgress;

	@FindBy(xpath = "(//span[normalize-space()='Upcoming'])[1]")
	WebElement upComing;

	@FindBy(xpath = "(//span[normalize-space()='Available'])[1]")
	WebElement available;
	
	@FindBy(xpath = "(//span[normalize-space()='Cancelled'])[1]")
	WebElement cancelled;
	
	@FindBy(xpath = "//th[@title='Sub Status']//span[@class='order fa fa-sort']")
	WebElement subStatus;
	
	@FindBy(xpath = "//th[@title='Trip ID']//span[@class='order fa fa-sort']")
	WebElement tripId;
	
	@FindBy(xpath = "//th[@title='Loop ID']//span[@class='order fa fa-sort']")
	WebElement loopId;
	
	@FindBy(xpath = "//th[@title='Passenger']//span[@class='order fa fa-sort']")
	WebElement passenger;
	
	@FindBy(xpath = "//th[@title='Company Name']//span[@class='order fa fa-sort']")
	WebElement company;
	
	@FindBy(xpath = "//th[@title='Driver']//span[@class='order fa fa-sort']")
	WebElement driverSort;

	TestBase objTestBase;

	public DEV_TC_1945_VerifyRemoveSortingFunctionsColumnsFromAllPagesInConciergePortal_Main(WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
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
			ridesSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	public void clickOnAllRides() {
		try {
			ridesTabAll.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRemovedSortingFunctionality(Boolean visibilityStatus) {
		try {
			if (!subStatus.isDisplayed() && !tripId.isDisplayed() && !loopId.isDisplayed() &&!passenger.isDisplayed() && !company.isDisplayed() && !driverSort.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}

	public void clickOnInProgressRides() {
		try {
			inProgress.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnUpComingRides() {
		try {
			upComing.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnAvailableRides() {
		try {
			available.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnCancelledRides() {
		try {
			cancelled.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
