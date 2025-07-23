package Dispatch.NewBooking;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1942_VerifyFilteringOutDriversAssociatedWithInactiveDriversUnderSettingsInNotificationTab_Main extends TestBase {

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
	WebElement settingsSection;
	
	@FindBy(xpath = "(//span[normalize-space()='Notifications'])[1]")
	WebElement notificationsTab;
	
	@FindBy(xpath = "(//h4[normalize-space()='Add Notification'])[1]")
	WebElement addNotificaitonPage;
	
	@FindBy(xpath = "//select[@class='form-control col-sm-12']")
	WebElement dropDown;
	
	@FindBy(xpath = "//select[@refs='notification_sub_type']")
	WebElement subTypedropdown;

	@FindBy(xpath = "//textarea[@id='title_text']")
	WebElement titleInput;
	
	@FindBy(xpath = "//textarea[@id='notificationText']")
	WebElement messageInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement successMessage;



	TestBase objTestBase;

	public DEV_TC_1942_VerifyFilteringOutDriversAssociatedWithInactiveDriversUnderSettingsInNotificationTab_Main(WebDriver driver) {
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

	public void clickSettingSection() {
		try {
			settingsSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnNotificationsTab() {
		try {
			notificationsTab.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfAddNotificationPage(Boolean visibilityStatus) {
		try {
			addNotificaitonPage.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("Add Notification"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void selectFromdropdown() {
		try {
			action = new Actions(driver);
			dropDown.click();
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSubTypeFromdropdown() {
		try {
			action = new Actions(driver);
			subTypedropdown.click();
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterTitleInput() {
		try {
			action = new Actions(driver);
			titleInput.sendKeys(prop.getProperty("titleInput"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void enterMessage() {
		try {
			action = new Actions(driver);
			messageInput.sendKeys(prop.getProperty("MessageInput"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public Boolean visibilityOfSendButtonAddNotificationPage(Boolean visibilityStatus) {
		try {
			if (sendBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}

	public void clickOnSendBtn() {
		try {
			sendBtn.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSuccessMessage(Boolean visibilityStatus) {
		try {
			if (successMessage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visibilityStatus;
	}

	public void clickOnYesBtn() {
		try {
			yesBtn.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
