package Concierge.Profile;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.ElementNotInteractableException;

public class DEV_TC_363_VerifyFieldValidationForEmail_Main extends TestBase {

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

	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profileTab;

	@FindBy(xpath = "//button[contains(text(),'Edit Profile')]")
	WebElement editProfileBtn;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailField;

	TestBase objTestBase;

	public DEV_TC_363_VerifyFieldValidationForEmail_Main(WebDriver driver) {
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
			Boolean visibilityStatus1 = false;
			visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
		} catch (Exception e) {
			e.printStackTrace();
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

	public Boolean verifyProfilePage(Boolean visibilityStatus) {
		try {
			if (signinUser.isDisplayed()) {
				signinUser.click();
				defaultWaitTime(1000);
				profileTab.click();
				defaultWaitTime(2000);
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("profile")) {
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

	public Boolean verifyEmailEditable(Boolean visibilityStatus) {
		try {
			if (editProfileBtn.isDisplayed()) {
				editProfileBtn.click();
				defaultWaitTime(3000);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)", "");
				objTestBase.defaultWaitTime(2000);

				// Verify thru Exception Handle:
				action = new Actions(driver);
				emailField.click();
				objTestBase.defaultWaitTime(500);
				emailField.sendKeys(Keys.CONTROL + "A");
				emailField.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(1000);
				emailField.sendKeys("TempEmail");
				objTestBase.defaultWaitTime(1000);
				if (emailField.getText() == "TempEmail")
					visibilityStatus = false;
				else
					visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			visibilityStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
