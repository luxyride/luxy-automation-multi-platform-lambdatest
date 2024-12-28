package UserPortal.Login;

import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1952_VerifyFunctionalityOfProfileOptionInWebUserPortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signinBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement welcomeDropDown;

	@FindBy(xpath = "(//div[normalize-space()='User Details'])[1]")
	WebElement userDetails;

	@FindBy(xpath = "(//div[normalize-space()='Logout'])[1]")
	WebElement logOutBtn;

	@FindBy(xpath = "//button[@value='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "(//div[normalize-space()='My Trips'])[1]")
	WebElement myRideBookings;

	@FindBy(xpath = "(//a[@label='Profile'])[1]")
	WebElement profileOptionNormalView;

	@FindBy(xpath = "(//a[@label='Profile'])[2]")
	WebElement profileOptionSimulatorView;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement passwordInput;

	@FindBy(xpath = "(//*[name()='path'])[4]")
	WebElement eyeIcon;

	@FindBy(xpath = "(//*[normalize-space()='sign in'])[1]")
	WebElement signinBtnNormalView;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signInBtn_Login;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "(//a[normalize-space()='Logout'])[2]")
	WebElement logoutBtn;

	TestBase objTestBase;
	GetCurrentDateTime getDate;
	JavascriptExecutor js;
	LocalDate today;

	public DEV_TC_1952_VerifyFunctionalityOfProfileOptionInWebUserPortal_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
			getDate = new GetCurrentDateTime();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickLogin() throws InterruptedException {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtn);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(signinBtn).click().build().perform();
			Thread.sleep(1000);
			if (customerLogin.isDisplayed()) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
				js.executeScript("window.scrollBy(0,50)", "");
				action.moveToElement(customerLogin).click().build().perform();
			}
			Thread.sleep(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			Thread.sleep(1000);
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eMailInput);
			js.executeScript("window.scrollBy(0,50)", "");
			eMailInput.sendKeys(prop.getProperty("sanityeMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", passwordInput);
			js.executeScript("window.scrollBy(0,50)", "");
			passwordInput.sendKeys(prop.getProperty("sanityPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eyeIconClick() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eyeIcon);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickSignInNormalView() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtnNormalView);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(signinBtnNormalView).click().build().perform();
			action.moveToElement(signinBtn).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signInBtn_Login);
			js.executeScript("window.scrollBy(0,50)", "");
			if (signInBtn_Login.isDisplayed())
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signInBtn_Login);
			js.executeScript("window.scrollBy(0,50)", "");
			signInBtn_Login.click();
			defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				clickOn3HorizontalToggleNavigationBar(); // Click on 3 Lines Navigation Bar:
				visibilityStatus = visibilityOfLogoutButton(visibilityStatus);
			} else {
				waitTimeForElement(signInBtnDropdown);
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", signInBtnDropdown);
				js.executeScript("window.scrollBy(0,50)", "");
				if (signInBtnDropdown.isDisplayed()) {
					expected = signInBtnDropdown.getText();
					if (expected.toLowerCase().contains("welcome"))
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfLogoutButton(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", logoutBtn);
			js.executeScript("window.scrollBy(0,50)", "");
			if (logoutBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSignIn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtn);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(signinBtn).click().build().perform();
			action.moveToElement(signinBtn).build().perform();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfDropDown(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
			js.executeScript("window.scrollBy(0,50)", "");
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(customerLogin).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickWelcomeDropDown() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", welcomeDropDown);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(welcomeDropDown).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfProfileOption(Boolean visibilityStatus, String viewName) {
		try {
			if (viewName.equalsIgnoreCase("profileOptionSimulatorView")) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", profileOptionSimulatorView);
				js.executeScript("window.scrollBy(0,50)", "");
				if (profileOptionSimulatorView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", profileOptionNormalView);
				js.executeScript("window.scrollBy(0,50)", "");
				if (profileOptionNormalView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnProfileOption(String viewName) {
		try {
			try {
				action = new Actions(driver);
				if (viewName.equalsIgnoreCase("profileOptionNormalView")) {
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", profileOptionNormalView);
					js.executeScript("window.scrollBy(0,50)", "");
					if (profileOptionNormalView.isDisplayed())
						action.moveToElement(profileOptionNormalView).click().build().perform();
				} else {
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", profileOptionSimulatorView);
					js.executeScript("window.scrollBy(0,50)", "");
					if (profileOptionSimulatorView.isDisplayed())
						action.moveToElement(profileOptionSimulatorView).click().build().perform();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean VerifyProfilePage(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", userDetails);
			js.executeScript("window.scrollBy(0,50)", "");
			expected = driver.getCurrentUrl();
			if (userDetails.isDisplayed() && myRideBookings.isDisplayed() && expected.contains("profile"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}