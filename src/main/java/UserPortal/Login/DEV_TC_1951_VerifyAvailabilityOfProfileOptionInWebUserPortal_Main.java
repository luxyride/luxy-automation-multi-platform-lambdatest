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

public class DEV_TC_1951_VerifyAvailabilityOfProfileOptionInWebUserPortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signinBtn;

	@FindBy(xpath = "(//a[normalize-space()='Logout'])[2]")
	WebElement logoutBtn;

	@FindBy(xpath = "(//*[normalize-space()='sign in'])[1]")
	WebElement signinBtnNormalView;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement welcomeDropDown;

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
	
	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement loginAndContinue;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signInBtn_Login;
	
	@FindBy(xpath = "(//button[contains(@class,'pointer-events-auto')])[2]")
	WebElement closeBtnSimulatorView;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "//input[@placeholder='Enter Pickup Location']")
	WebElement fromAddress;

	@FindBy(xpath = "//input[@placeholder='Enter dropoff Location']")
	WebElement toAddress;

	@FindBy(xpath = "//div[@class='flex items-center gap-x-2']")
	WebElement extraStopIcon;

	@FindBy(xpath = "//input[@placeholder='Enter Stop 1 Location']")
	WebElement addextraStop;

	@FindBy(xpath = "//input[@placeholder='Enter Pickup Date']")
	WebElement dateInput;

	@FindBy(xpath = "//div[normalize-space()='Get Quote'][2]")
	WebElement getQuote;

	@FindBy(xpath = "(//div[@class='rounded-2xl p-4 border border-orange-100 bg-white gap-y-8 flex flex-col animate-[fadeIn_1s]'])[1]")
	WebElement vechileAvailableSection;

	@FindBy(xpath = "//div[normalize-space()='LOOKING FOR OTHER CAR OPTIONS?']")
	List<WebElement> vechileAvailableList;

	@FindBy(xpath = "//div[normalize-space()='Sedan']")
	WebElement bookSedan;

	@FindBy(xpath = "//*[text()='Confirm your vehicle']")
	List<WebElement> confirmVehiclePopup;

	@FindBy(xpath = "//button[text()='Confirm']")
	List<WebElement> confirmBtn;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='SUV']")
	WebElement bookSUV;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='SUV-XL']")
	WebElement bookSUVXL;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='Van']")
	WebElement bookVAN;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='Van-XL']")
	WebElement bookVANXL;

	@FindBy(xpath = "//button[contains(@aria-label,'Add Secondary Passenger')]")
	WebElement secondaryPassenger;

	@FindBy(xpath = "(//input[@id='fname'])[4]")
	WebElement spFirstName;

	@FindBy(xpath = "(//input[@id='fname'])[5]")
	WebElement spLastName;

	@FindBy(xpath = "(//div[text()='Phone'])[2]//following::input[1]")
	WebElement spMobile;

	@FindBy(xpath = "(//input[@id='fname'])[6]")
	WebElement spEmail;

	@FindBy(xpath = "//div[@class='choices__inner']")
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "//label[normalize-space()='Airline']//following-sibling::div//div//div[1]")
	WebElement airlinesDrpdwnValue;

	@FindBy(xpath = "(//input[@placeholder='Enter Flight Number'])")
	WebElement flightNumber;

	@FindBy(xpath = "//textarea[@id='passenger_notes']")
	WebElement passengerNotes;

	@FindBy(xpath = "//*[normalize-space()='Personal Travel']")
	WebElement bookingForPersonal;

	@FindBy(xpath = "//input[@value='Business']")
	WebElement bookingForBusiness;

	@FindBy(xpath = "//div[@class='custom-control custom-switch ']")
	WebElement promoCodeEnable;

	@FindBy(xpath = "//input[@id='promoCode']")
	WebElement promoCode;

	@FindBy(xpath = "//button[@class='btn btn-small customized-button']")
	WebElement applypromoCode;

	@FindBy(xpath = "//button[contains(@aria-label,'Proceed to Pay')]")
	WebElement paymentInfocheckbox;

	@FindBy(xpath = "//div[normalize-space()='Make Payment & Book Ride'][1]")
	WebElement confirmBookingBtn;

	@FindBy(xpath = "//div[normalize-space()='Book Another Ride'][1]")
	WebElement bookNextRideBtn;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement dateNextMonth;

	@FindBy(xpath = "//input[@id='cardholder-name']")
	WebElement cardHolderName;

	@FindBy(xpath = "//input[@id='credit-card-number']")
	WebElement cardHolderNumber;

	@FindBy(xpath = "//input[@id='expiration']")
	WebElement cardExpiryDate;

	@FindBy(xpath = "//input[@id='cvv']")
	WebElement cvv;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement calendar;

	@FindBy(xpath = "//button[@class='button next-button next-btn']")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//div[normalize-space()='Trip ID:']")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//div[text()='Save card for future use']//following::input//following::label//div[1]")
	WebElement termsAndConditionsCheckbox;

	TestBase objTestBase;
	GetCurrentDateTime getDate;
	JavascriptExecutor js;
	LocalDate today;

	public DEV_TC_1951_VerifyAvailabilityOfProfileOptionInWebUserPortal_Main(WebDriver driver) {
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
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signinBtn).click().build().perform();
			Thread.sleep(1000);
			if (customerLogin.isDisplayed()) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
				js.executeScript("window.scrollBy(0,-100)", "");
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
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signInBtn_Login);
			js.executeScript("window.scrollBy(0,-100)", "");
			signInBtn_Login.click();
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
				if (visibilityStatus.booleanValue() == true) {
					if(closeBtnSimulatorView.isDisplayed())
						closeBtnSimulatorView.click();
					defaultWaitTime(3000);
				}
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
			visibilityStatus = false;
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signInBtn_Login);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (signInBtn_Login.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSignInNormalView() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtnNormalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signinBtnNormalView).click().build().perform();
			action.moveToElement(signinBtn).build().perform();
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
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtnNormalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (signinBtnNormalView.isDisplayed())
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

	public Boolean visibilityOfLogOutButton(Boolean visibilityStatus) {
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

	public void clickOnSecondaryPassenger() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", secondaryPassenger);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(secondaryPassenger).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickSignIn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signinBtn).click().build().perform();
			action.moveToElement(signinBtn).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickWelcomeDropDown() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", welcomeDropDown);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(welcomeDropDown).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfProfileOption(Boolean visibilityStatus, String viewName) {
		try {
			if (viewName.equalsIgnoreCase("profileOptionNormalView")) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", profileOptionNormalView);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (profileOptionNormalView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", profileOptionSimulatorView);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (profileOptionSimulatorView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}