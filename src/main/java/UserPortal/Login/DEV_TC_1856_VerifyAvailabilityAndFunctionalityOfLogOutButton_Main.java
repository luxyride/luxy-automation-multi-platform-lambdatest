package UserPortal.Login;

import common.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1856_VerifyAvailabilityAndFunctionalityOfLogOutButton_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signinBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "(//*[normalize-space()='sign in'])[1]")
	WebElement signInBtnNormalView;

	@FindBy(xpath = "(//a[normalize-space()='sign in'])[1]//following::a[normalize-space()='Customer Login'][1]")
	WebElement customerLoginNormalView;

	@FindBy(xpath = "(//a[normalize-space()='sign in'])[2]//following::a[normalize-space()='Customer Login']")
	WebElement customerLoginSimulatorView;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement passwordInput;

	@FindBy(xpath = "(//*[name()='path'])[4]")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement loginAndContinue;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "(//a[normalize-space()='Logout'])[2]")
	WebElement logoutBtn;

	public DEV_TC_1856_VerifyAvailabilityAndFunctionalityOfLogOutButton_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickLogin(String viewName) throws Exception {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signinBtn).click().build().perform();
			Thread.sleep(1000);
			if (viewName.equalsIgnoreCase("simulatorView") && customerLoginSimulatorView.isDisplayed()) {
				js.executeScript("arguments[0].scrollIntoView(true);", customerLoginSimulatorView);
				js.executeScript("window.scrollBy(0,-100)", "");
				action.moveToElement(customerLoginSimulatorView).click().build().perform();
			} else {
				js.executeScript("arguments[0].scrollIntoView(true);", customerLoginNormalView);
				js.executeScript("window.scrollBy(0,-100)", "");
				action.moveToElement(customerLoginNormalView).click().build().perform();
			}
			defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			defaultWaitTime(1000);
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eMailInput);
			js.executeScript("window.scrollBy(0,-100)", "");
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
			js.executeScript("window.scrollBy(0,-100)", "");
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
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public void clickSigninButton() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", loginAndContinue);
			js.executeScript("window.scrollBy(0,-100)", "");
			loginAndContinue.click();
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
				js.executeScript("window.scrollBy(0,-100)", "");
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
			js.executeScript("window.scrollBy(0,-100)", "");
			if (logoutBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public void clickSignInNormalView() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signInBtnNormalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signInBtnNormalView).click().build().perform();
			action.moveToElement(signinBtn).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public Boolean visibilityOfSignInButtonNormalView(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signInBtnNormalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (signInBtnNormalView.isDisplayed())
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
			customerLogin.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnCustomerLogin(String viewName) throws Exception {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signinBtn).click().build().perform();
			Thread.sleep(1000);
			if (viewName.equalsIgnoreCase("simulatorView") && customerLoginSimulatorView.isDisplayed()) {
				js.executeScript("arguments[0].scrollIntoView(true);", customerLoginSimulatorView);
				js.executeScript("window.scrollBy(0,-100)", "");
				customerLoginSimulatorView.click();
			} else {
				js.executeScript("arguments[0].scrollIntoView(true);", customerLoginNormalView);
				js.executeScript("window.scrollBy(0,-100)", "");
				customerLoginNormalView.click();
			}
			defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			defaultWaitTime(1000);
		}
	}

	public void clickOnProfileDropDown() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signInBtnDropdown);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signInBtnDropdown).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfDropDown(Boolean visibilityStatus, String viewName) throws Exception {
		try {
			action = new Actions(driver);
			if (viewName.equalsIgnoreCase("simulatorView")) {
				defaultWaitTime(3000);
				clickOn3HorizontalToggleNavigationBar();
				defaultWaitTime(3000);
				if (customerLoginSimulatorView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", signinBtn);
				js.executeScript("window.scrollBy(0,-100)", "");
				action.moveToElement(signinBtn).click().build().perform();
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true);", customerLoginNormalView);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (customerLoginNormalView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
			defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			defaultWaitTime(1000);
		}
		return visibilityStatus;
	}

	public void clickOnLogOut() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", logoutBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(logoutBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
