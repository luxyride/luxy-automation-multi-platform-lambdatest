package TravelAgent.ChangePassword;

import common.TestBase;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1305_VerifyFieldValidationOfChangePassword_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	List<WebElement> eMailInput;

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

	@FindBy(xpath = "//button[@type='button']")
	WebElement userLoginName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement changePwdSubmitBtn;

	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	WebElement ChangePWDbutton;

	@FindBy(xpath = "//button[@id='cancelchange']")
	WebElement CancelBtn;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement inputoldpwd;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement inputnewpwd;

	@FindBy(xpath = "(//input[@type='password'])[3]")
	WebElement inputconfirmpwd;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	TestBase objTestBase;

	public DEV_TC_1305_VerifyFieldValidationOfChangePassword_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean eMailInput(Boolean visibilityStatus) {
		try {
			visibilityStatus = waitToPageLoadElementsFluentWait(visibilityStatus, eMailInput);
			if (visibilityStatus.booleanValue() == true) {
				action = new Actions(driver);
				eMailInput.get(0).sendKeys(prop.getProperty("travelAgentEMail"));
				action.sendKeys(Keys.TAB).build().perform();
				visibilityStatus = true;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("travelAgentPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eyeIconClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public void clickOnuserLoginName() {
		try {
			action = new Actions(driver);
			action.moveToElement(userLoginName).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoginDropdown(Boolean visibilityStatus) {
		try {
			if (userLoginName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickChangePWDbutton() {
		try {
			action = new Actions(driver);
			action.moveToElement(ChangePWDbutton).click().build().perform();
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

	public Boolean visibilityOfChangePasswordPage(Boolean visibilityStatus) {
		try {
			if (CancelBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean validatePwdErrorMessages(Boolean visibilityStatus, String scenario) {
		try {
			action = new Actions(driver);
			if (scenario == "oldNewSamePwd") {
				inputoldpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				action.sendKeys(Keys.TAB).build().perform();
				objTestBase.defaultWaitTime(1000);

				inputnewpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				action.sendKeys(Keys.TAB).build().perform();
				objTestBase.defaultWaitTime(1000);

				inputconfirmpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = true;
			} else if (scenario == "wrongCurrPwd") {
				inputoldpwd.sendKeys(prop.getProperty("travelAgentTempPwd"));
				action.sendKeys(Keys.TAB).build().perform();
				objTestBase.defaultWaitTime(1000);

				inputnewpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				action.sendKeys(Keys.TAB).build().perform();
				objTestBase.defaultWaitTime(1000);

				inputconfirmpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = true;
			} else if (scenario == "confPwdDiff") {
				inputoldpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				action.sendKeys(Keys.TAB).build().perform();
				objTestBase.defaultWaitTime(1000);

				inputnewpwd.sendKeys(prop.getProperty("travelAgentTempPwd"));
				action.sendKeys(Keys.TAB).build().perform();
				objTestBase.defaultWaitTime(1000);

				inputconfirmpwd.sendKeys(prop.getProperty("travelagentwrngPwd"));
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfErrorMsgDisplay(Boolean visibilityStatus, String scenario) {
		try {
			action = new Actions(driver);
			action.moveToElement(changePwdSubmitBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			String msgText = "";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				msgText = alertMessge.getText().toLowerCase();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus == true && msgText.contains("old password and new password cannot be same"))
				visibilityStatus = true;
			else if (visibilityStatus == true && msgText
					.contains("The current password you entered does not match. please re-enter the correct password"))
				visibilityStatus = true;
			else if (visibilityStatus == true && msgText.contains("new password and confirm password should be same"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickChangePwdSubmitBtn() {
		try {
			changePwdSubmitBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
