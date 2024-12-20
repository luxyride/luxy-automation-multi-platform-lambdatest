package UserPortal.SignUp;

import common.TestBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1884_VerifyTheNewUserSignUpFlowInUserPortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement loginBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "//div[normalize-space()='Sign Up for new account'][1]")
	WebElement signupBtn;

	@FindBy(xpath = "//input[@id='fname']")
	WebElement fName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lName;

	@FindBy(xpath = "//input[@id='email_address']")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])")
	WebElement passwordInput;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement phoneInput;

	@FindBy(xpath = "//div[@class='relative h-4 w-4 rounded-full border border-orange-300 bg-white']")
	WebElement termsConditionsChckbx;

	@FindBy(xpath = "(//*[normalize-space()='Sign Up'])[1]")
	List<WebElement> signupBtnFromSignupScreen;

	@FindBy(xpath = "//div[@class='alert alert-success success_box m-top-1']//span")
	WebElement successMsg;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signinBtn;

	@FindBy(xpath = "(//*[contains(normalize-space(),'Your registration with LUXY is successful')])[1]")
	List<WebElement> alertMessge;

	TestBase objTestBase;

	public DEV_TC_1884_VerifyTheNewUserSignUpFlowInUserPortal_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickSignIn() {
		try {
			action = new Actions(driver);
			action.moveToElement(signinBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfDropDown(Boolean visibilityStatus) {
		try {
			if (customerLogin.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnCustomerLogin() {
		try {
			action = new Actions(driver);
			action.moveToElement(customerLogin).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnSignup() {
		try {
			action = new Actions(driver);
			action.moveToElement(signupBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fNameInput() {
		try {
			action = new Actions(driver);
			fName.sendKeys(prop.getProperty("fName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void lNameInput() {
		try {
			action = new Actions(driver);
			lName.sendKeys(prop.getProperty("lName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfSignupButton(Boolean visibilityStatus) {
		try {
			if (signupBtnFromSignupScreen.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public String eMailInput(String eMail) {
		try {
			action = new Actions(driver);
			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);
			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("regeMail") + currDateTime + prop.getProperty("eMailDomain");
			action.sendKeys(Keys.TAB).build().perform();
			eMailInput.sendKeys(eMail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eMail;

	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("regPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void phoneNumberInput() {
		try {
			action = new Actions(driver);
			phoneInput.sendKeys(prop.getProperty("phoneNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void termsConditionsCheckbox() {
		try {
			action = new Actions(driver);
			action.moveToElement(termsConditionsChckbx).click().build().perform();
			;
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfSignupButtonFromSignupScreen(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(1000);
			if (signupBtnFromSignupScreen.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public Boolean visibilityOfSignupConfirmationMsg(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(1000);
			signupBtnFromSignupScreen.get(0).click();

			String msgText = "";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(alertMessge.get(0)));
			if (alertMessge.size() != 0) {
				msgText = alertMessge.get(0).getText().toLowerCase();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus == true && msgText.contains("successful"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfSignUpPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("register")) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
