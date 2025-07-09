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

	@FindBy(xpath = "(//*[normalize-space()='sign in'])[1]")
	WebElement signInBtnNormalView;

	@FindBy(xpath = "(//a[normalize-space()='sign in'])[1]//following::a[normalize-space()='Customer Login'][1]")
	WebElement customerLoginNormalView;

	@FindBy(xpath = "(//a[normalize-space()='sign in'])[2]//following::a[normalize-space()='Customer Login']")
	WebElement customerLoginSimulatorView;

	@FindBy(xpath = "(//button[contains(@class,'pointer-events-auto')])[2]")
	WebElement closeBtnSimulatorView;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement loginAndContinue;

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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", loginAndContinue);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(loginAndContinue).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfDropDown(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (customerLogin.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", customerLoginSimulatorView);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (customerLoginSimulatorView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", signInBtnNormalView);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (signInBtnNormalView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfLoginAndContinueBtn(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", loginAndContinue);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (loginAndContinue.isDisplayed())
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
			js.executeScript("window.scrollBy(0,-100)", "");
			driver.findElement(By.linkText("Customer Login")).click();
			defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnSignup() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signupBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fNameInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", fName);
			js.executeScript("window.scrollBy(0,-100)", "");
			fName.sendKeys(prop.getProperty("fName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void lNameInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", lName);
			js.executeScript("window.scrollBy(0,-100)", "");
			lName.sendKeys(prop.getProperty("lName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfSignupButton(Boolean visibilityStatus) {
		try {
			defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupBtnFromSignupScreen.get(0));
			js.executeScript("window.scrollBy(0,-100)", "");
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eMailInput);
			js.executeScript("window.scrollBy(0,-100)", "");
			eMailInput.sendKeys(eMail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eMail;

	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", passwordInput);
			js.executeScript("window.scrollBy(0,-100)", "");
			passwordInput.sendKeys(prop.getProperty("regPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void phoneNumberInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", phoneInput);
			js.executeScript("window.scrollBy(0,-100)", "");
			phoneInput.sendKeys(prop.getProperty("phoneNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void termsConditionsCheckbox() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", termsConditionsChckbx);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(termsConditionsChckbx).click().build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfSignupButtonFromSignupScreen(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupBtnFromSignupScreen.get(0));
			js.executeScript("window.scrollBy(0,-100)", "");
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
			objTestBase.defaultWaitTime(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupBtnFromSignupScreen.get(0));
			js.executeScript("window.scrollBy(0,-100)", "");
			action.sendKeys(Keys.TAB).build().perform();
			defaultWaitTime(1000);
			signupBtnFromSignupScreen.get(0).click();
			js.executeScript("window.scrollBy(0,-5000)", "");
			String msgText = "";
			defaultWaitTime(1000);
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
