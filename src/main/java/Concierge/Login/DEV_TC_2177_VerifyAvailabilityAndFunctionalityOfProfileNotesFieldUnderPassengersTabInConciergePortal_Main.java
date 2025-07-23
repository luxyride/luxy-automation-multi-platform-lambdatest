package Concierge.Login;

import common.GetCurrentDateTime;
import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_2177_VerifyAvailabilityAndFunctionalityOfProfileNotesFieldUnderPassengersTabInConciergePortal_Main extends TestBase {

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
	
	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement passanger;
	
	@FindBy(xpath = "(//a[normalize-space()='Add Passenger'])[1]")
	WebElement addPassanger;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastName;
	
	@FindBy(xpath = "(//input[@placeholder='name@example.com'])[1]")
	WebElement email;
	
	@FindBy(xpath = "(//input[@placeholder='Mobile Number'])[1]")
	WebElement mobile;
	
	@FindBy(xpath = "//textarea[@placeholder='Profile Notes']")
	WebElement profileNotes;
	
	@FindBy(xpath = "//input[@placeholder='Employee ID']")
	WebElement employeeID;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement registerBtn;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement alertMsg;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchInput;
	
	@FindBy(xpath = "(//i[@title='Passenger Profile'])[1]")
	WebElement profileBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Profile Notes:']")
	WebElement profile;

	TestBase objTestBase;

	public DEV_TC_2177_VerifyAvailabilityAndFunctionalityOfProfileNotesFieldUnderPassengersTabInConciergePortal_Main(WebDriver driver) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
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

	public void clickPassanger() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(passanger).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(addPassanger).click().build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterAllRequiredFields() {
		try {
			action = new Actions(driver);
			firstName.sendKeys(prop.getProperty("spFirstName"));
			objTestBase.defaultWaitTime(2000);
			lastName.sendKeys(prop.getProperty("spLastName"));
			objTestBase.defaultWaitTime(2000);
			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);
			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("regeMail") + currDateTime + prop.getProperty("eMailDomain");
			action.sendKeys(Keys.TAB).build().perform();
			email.sendKeys(eMail);
			objTestBase.defaultWaitTime(2000);
			mobile.sendKeys(prop.getProperty("spMobile"));
			objTestBase.defaultWaitTime(2000);
			profileNotes.sendKeys(prop.getProperty("pasengerNotes"));
			objTestBase.defaultWaitTime(2000);
			employeeID.sendKeys(prop.getProperty("employeID"));
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void clickOnRegister() {
		try {
			action = new Actions(driver);
			action.moveToElement(registerBtn).click().build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfsuccessMsg(Boolean visibilityStatus) {
		try {
			if (alertMsg.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}

	public void searchAboveCreatedPassanger() {
		try {
			action = new Actions(driver);
			searchInput.sendKeys(eMail);
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(profileBtn).click().build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public Boolean visibilityOfProfileNotes(Boolean visibilityStatus) {
		try {
			if (profile.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}
}
