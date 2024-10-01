package Affiliate.Login;

import common.TestBase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1976_VerifyTheFieldValidationInAssignedriverAndVehiclePopUpForOnatripsInUpcomingRidesInAffiliatePortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	Boolean visibilityStatus;


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

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesTab;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement allTab;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchUser;

	@FindBy(xpath = "(//button[normalize-space()='Assign driver and vehicle'])[1]")
	WebElement assignDriverToggle;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripId;
	
	@FindBy(xpath = "(//h4[normalize-space()='Assign Driver and Vehicle'])[1]")
	WebElement driverDetailsPage;
	
	@FindBy(xpath = "(//button[normalize-space()='Confirm'])[1]")
	WebElement confirmBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Please select any driver name.']")
	WebElement driverName;
	
	@FindBy(xpath = "//span[normalize-space()='Please select any mobile number.']")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//span[normalize-space()='Please select vehicle.']")
	WebElement vehicle;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter make.']")
	WebElement make;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter model.']")
	WebElement model;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter color.']")
	WebElement color;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter year.']")
	WebElement year;

	
	TestBase objTestBase;

	public DEV_TC_1976_VerifyTheFieldValidationInAssignedriverAndVehiclePopUpForOnatripsInUpcomingRidesInAffiliatePortal_Main(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objTestBase = new TestBase();
	}

	public void eMailInput() {
		action = new Actions(driver);
		eMailInput.sendKeys(prop.getProperty("affiliatEMail"));
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void passwordInput() {
		action = new Actions(driver);
		passwordInput.sendKeys(prop.getProperty("affiliatePwd"));
	}

	public void eyeIconClick() {
		action = new Actions(driver);
		action.moveToElement(eyeIcon).click().build().perform();
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		if (signInBtn.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickSigninButton() {
		signInBtn.click();
	}

	public void clickOnRides() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(ridesTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnAllTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(allTab).click().build().perform();
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
	
	public Boolean searchTripID(String tripID) {
		try {
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(searchUser));
			if (displayStatus.isDisplayed()) {
				searchUser.click();
				searchUser.sendKeys(Keys.CONTROL + "A");
				searchUser.clear();
				searchUser.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(searchUser).sendKeys(tripID).build().perform();
				objTestBase.defaultWaitTime(3000);
				if (searchUser.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
	
	public void clickBookingTripId() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookingRideTripId).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfAssignDriverAndVehicle(Boolean visibilityStatus) {
		if (assignDriverToggle.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickOnAssignDriverToggle() {
		try {
			action = new Actions(driver);
			action.moveToElement(assignDriverToggle).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfDriverDetailsFormPage(Boolean visibilityStatus) {
		if (driverDetailsPage.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickOnConfirm() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)", "");
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(confirmBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfErrorMessagedUnderTextFields(Boolean visibilityStatus) {
		try {
			defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-600)", "");
			objTestBase.defaultWaitTime(1000);
			if (color.isDisplayed() && driverName.isDisplayed() && vehicle.isDisplayed() && mobileNumber.isDisplayed() && make.isDisplayed() && model.isDisplayed() && year.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
			return visibilityStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
		
	}
}
