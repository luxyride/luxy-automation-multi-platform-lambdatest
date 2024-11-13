package Dispatch.Pricing.Promocode;

import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.Calendar;
import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_620_VerifytheCreationOfPromoCodeForOneTimeUseOnlyWithPromoType_Percent_Main extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
	WebDriverWait wait;
	WebElement displayStatus;
	LocalDate today;
	Select selectAMPMDrpdwn;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailDispatchInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordDispatchInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIconDispatch;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement dispatchsignInBtn_Login;

	@FindBy(xpath = "//input[@placeholder='Pickup Address']")
	WebElement dispatchFromAddress;

	@FindBy(xpath = "//input[@placeholder='Drop Off Address']")
	WebElement dispatchToAddress;

	@FindBy(xpath = "//span[@class='MuiIconButton-label']//div")
	WebElement dispatchcalendar;

	@FindBy(xpath = "//input[@id='date-picker-inline']")
	WebElement dispatchdateInput;

	@FindBy(xpath = "//button[normalize-space()='Get Quote']")
	WebElement dispatchgetQuote;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement dispatchsignInBtnDropdown;

	@FindBy(xpath = "(//span[normalize-space()='Pricing'])[1]")
	WebElement dispatchpricingSection;

	@FindBy(xpath = "(//span[normalize-space()='Promo Code'])[1]")
	WebElement dispatchPromocodeTab;

	@FindBy(xpath = "//a[normalize-space()='Add Promo Code']")
	WebElement dispatchAddPromocodeBtn;

	@FindBy(xpath = "//h4[@class='topText' and contains(normalize-space(),'Add Promo Code')]")
	WebElement dispatchAddPromocodeHeader;

	@FindBy(xpath = "//label[@for='extra_services']")
	WebElement dispatchOneTimeUseOnlychckbox;

	@FindBy(xpath = "//label[@for='rPercent']//span[@class='checkmark']")
	WebElement dispatchPercentchckbox;

	@FindBy(xpath = "//div[@class='percentage' and contains(normalize-space(),'Percent amount')]")
	WebElement dispatchPercentAmountLbl;

	@FindBy(xpath = "//label[contains(normalize-space(),'Name')]//following::input[1]")
	WebElement dispatchPromocodeName;

	@FindBy(xpath = "//div[@class='percentage' and contains(normalize-space(),'Percent amount')]//input")
	WebElement dispatchPercentAmountInput;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'Max uses per user')]//following::input[1]")
	WebElement dispatchMaxUsesPerUserInput;

	@FindBy(xpath = "//button[normalize-space()='Next month']")
	WebElement dispatchnextMonthArrow;

	@FindBy(xpath = "(//input[@placeholder='MM-DD-YYYY'])[1]")
	WebElement calStartingDate;

	@FindBy(xpath = "(//input[@placeholder='MM-DD-YYYY'])[2]")
	WebElement calExpirationDate;

	@FindBy(xpath = "(//input[@name='hour12'])[1]")
	WebElement calStartingHours;

	@FindBy(xpath = "(//input[@name='hour12'])[2]")
	WebElement calExpirationHours;

	@FindBy(xpath = "(//input[@name='minute'])[1]")
	WebElement calStartingMinute;

	@FindBy(xpath = "(//input[@name='minute'])[2]")
	WebElement calExpirationMinute;

	@FindBy(xpath = "(//select[@name='amPm'])[1]")
	WebElement calStartingHoursFormat;

	@FindBy(xpath = "(//select[@name='amPm'])[2]")
	WebElement calExpirationHoursFormat;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchPromocodeSaveBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchPromocodeSearch;

	@FindBy(xpath = "//i[@title='Delete Promo Code']")
	WebElement dispatchPromocodeDeleteBtn;

	@FindBy(xpath = "//h1[normalize-space()='Delete Promo Code']//following::div//button[2]")
	WebElement dispatchPromocodeDeleteConf;

	@FindBy(xpath = "(//*[normalize-space()='There is no data to display'])[1]")
	WebElement dispatchPromocodeDeleteConfMsg;

	// User Portal Variables:
	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signinBtn;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement passwordInput;

	@FindBy(xpath = "(//div[@class='input-group-prepend'])[1]//span//i")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn_Login;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "//input[@id='input-pickup-searchbox']")
	WebElement fromAddress;

	@FindBy(xpath = "//input[@id='input-dropoff-searchbox']")
	WebElement toAddress;

	@FindBy(xpath = "//img[@alt='Black Car Cab Everywhere']")
	WebElement extraStopIcon;

	@FindBy(xpath = "//input[@id='auto_extra_1']")
	WebElement addextraStop;

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement dateInput;

	@FindBy(xpath = "//button[normalize-space()='Get Quote']")
	WebElement getQuote;

	@FindBy(xpath = "//h5[@class='block-head mx-2']")
	WebElement vechileAvailableSection;

	@FindBy(xpath = "(//div[@class='row'])[3]")
	List<WebElement> vechileAvailableList;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='Sedan']")
	WebElement bookSedan;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='SUV']")
	WebElement bookSUV;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='SUV-XL']")
	WebElement bookSUVXL;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='Van']")
	WebElement bookVAN;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='Van-XL']")
	WebElement bookVANXL;

	@FindBy(xpath = "//a[@class='passenger luxy-btn pointer font-14']")
	WebElement secondaryPassenger;

	@FindBy(xpath = "//input[@id='sp-firstName']")
	WebElement spFirstName;

	@FindBy(xpath = "//input[@id='sp-lastName']")
	WebElement spLastName;

	@FindBy(xpath = "//input[@placeholder='Enter Contact Number']")
	WebElement spMobile;

	@FindBy(xpath = "//input[@id='sp-email']")
	WebElement spEmail;

	@FindBy(xpath = "//label[normalize-space()='Airline']//following-sibling::div")
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "//label[normalize-space()='Airline']//following-sibling::div//div//div[1]")
	WebElement airlinesDrpdwnValue;

	@FindBy(xpath = "//input[@id='flight_number']")
	WebElement flightNumber;

	@FindBy(xpath = "//textarea[@id='passenger_notes']")
	WebElement passengerNotes;

	@FindBy(xpath = "//div[@class='custom-control custom-switch ']")
	WebElement promoCodeEnable;

	@FindBy(xpath = "//input[@id='promoCode']")
	WebElement promoCode;

	@FindBy(xpath = "//button[@class='btn btn-small customized-button']")
	WebElement applypromoCode;

	@FindBy(xpath = "//input[@name='paymentInfo']")
	List<WebElement> paymentInfocheckbox;

	@FindBy(xpath = "//button[@class='btn btn-block primary custom-button']")
	WebElement confirmBookingBtn;

	@FindBy(xpath = "//button[normalize-space()='Book Next Ride']")
	WebElement bookNextRideBtn;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement dateNextMonth;

	@FindBy(id = "cardholder-name")
	WebElement cardHolderName;

	@FindBy(id = "credit-card-number")
	WebElement cardHolderNumber;

	@FindBy(id = "expiration")
	WebElement cardExpiryDate;

	@FindBy(id = "cvv")
	WebElement cvv;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement calendar;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//*[text()='Confirm your vehicle']")
	List<WebElement> confirmVehiclePopup;

	@FindBy(xpath = "//button[text()='Confirm']")
	List<WebElement> confirmBtn;

	TestBase objTestBase;

	public DEV_TC_620_VerifytheCreationOfPromoCodeForOneTimeUseOnlyWithPromoType_Percent_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eMailDispatchInput() {
		try {
			action = new Actions(driver);
			eMailDispatchInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void passwordDispatchInput() {
		try {
			action = new Actions(driver);
			passwordDispatchInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void eyeIconDispatchClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIconDispatch).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Boolean visibilityOfNewBookingPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(newBookingTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("booking"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickRidesSection() {
		try {
			ridesSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilitydispatchOfSigninButton(Boolean visibilityStatus) {
		try {
			if (dispatchsignInBtn_Login.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickdispatchSigninButton() {
		try {
			dispatchsignInBtn_Login.click();
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean dispatchvisibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			if (dispatchsignInBtnDropdown.isDisplayed()) {
				expected = dispatchsignInBtnDropdown.getText();
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

	public void dispatchclickPricingSection() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchpricingSection).click().build().perform();
			for (int i = 1; i <= 6; i++) {
				action.sendKeys(Keys.DOWN).build().perform();
			}
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchvisibilityOfPromocodeTabPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeTab).click().build().perform();
			objTestBase.defaultWaitTime(5000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchAddPromocodeBtn));
			if (displayStatus.isDisplayed()) {
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("managepromocode"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean dispatchvisibilityOfAddPromocodePage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchAddPromocodeBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchAddPromocodeHeader));
			if (displayStatus.isDisplayed()) {
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("addpromocode"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean dispatchEnterAllReqDetailsPromoPercent(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeName).click().sendKeys(prop.getProperty("promoCodeNamePercent"))
					.build().perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(dispatchPercentAmountInput).click().sendKeys(prop.getProperty("percentAmount")).build()
					.perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(dispatchMaxUsesPerUserInput).click().sendKeys(prop.getProperty("maxUsesPerUser"))
					.build().perform();
			objTestBase.defaultWaitTime(500);

			action.moveToElement(calStartingDate).click().build().perform();
			objTestBase.defaultWaitTime(500);
			dispatchenterDate("startingDate");
			objTestBase.defaultWaitTime(500);
			action.moveToElement(calExpirationDate).click().build().perform();
			objTestBase.defaultWaitTime(500);
			dispatchenterDate("expirationDate");
			objTestBase.defaultWaitTime(500);

			action.moveToElement(calStartingHours).click().sendKeys(prop.getProperty("calStartingHours")).build()
					.perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(calStartingMinute).click().sendKeys(prop.getProperty("calStartingMinute")).build()
					.perform();
			objTestBase.defaultWaitTime(500);

			calStartingHoursFormat.click();
			selectAMPMDrpdwn = new Select(calStartingHoursFormat);
			selectAMPMDrpdwn.selectByValue(prop.getProperty("calStartingHoursFormat"));
			objTestBase.defaultWaitTime(1000);

			action.moveToElement(calExpirationHours).click().sendKeys(prop.getProperty("calExpirationHours")).build()
					.perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(calExpirationMinute).click().sendKeys(prop.getProperty("calExpirationMinute")).build()
					.perform();
			objTestBase.defaultWaitTime(500);

			calExpirationHoursFormat.click();
			selectAMPMDrpdwn = new Select(calExpirationHoursFormat);
			selectAMPMDrpdwn.selectByValue(prop.getProperty("calExpirationHoursFormat"));
			objTestBase.defaultWaitTime(1000);

			if (dispatchAddPromocodeHeader.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void dispatchenterDate(String dateType) {
		try {
			objTestBase.defaultWaitTime(2000);
			today = LocalDate.now();
			int currDay = today.getDayOfMonth();
			int currMonth = today.getMonthValue();
			int currYear = today.getYear();

			Calendar cal = Calendar.getInstance();
			int lastDateofMonth = cal.getActualMaximum(Calendar.DATE);

			// Select Date of Next Month:
			if (currDay >= lastDateofMonth - 2) {
				int nextMonth = today.getMonthValue() + 1;
				if (dateType == "startingDate")
					calStartingDate.click();
				else
					calExpirationDate.click();

				objTestBase.defaultWaitTime(2000);
				dispatchnextMonthArrow.click();
				objTestBase.defaultWaitTime(2000);

				// For Handling Month Count till 12:
				if (nextMonth == 13) {
					nextMonth = 01; // Set Constant Month value as January
				}
				// For Handling Leap Year February Month:
				else if (nextMonth == 2 && (currDay > 26 && currDay <= 28)) {
					currDay = 28;
				} else if (nextMonth == 2 && currDay > 28) {
					currDay = 2;
					nextMonth = 3; // Set Constant Month to March

					//-----------------------------------------------------------------------------------
					// Handing Feb month xpath issue:
					objTestBase.defaultWaitTime(1000);
					List<WebElement> nextMonthArrow = driver.findElements(By.xpath(
							"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])"));

					if (nextMonthArrow.size() > 1) {
						nextMonthArrow.clear();
						nextMonthArrow = driver.findElements(By.xpath(
								"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[2]"));
					}
					nextMonthArrow.get(0).click();
					objTestBase.defaultWaitTime(2000);
					//-----------------------------------------------------------------------------------
				}

				String nextMonthDate = nextMonth + "-" + currDay + "-" + currYear;
				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(nextMonthDate);
				cal.setTime(d);

				String secondDayOfNextMonth;
				if (dateType == "startingDate")
					secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 2";
				else
					secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 4";

				String[] tempVal = secondDayOfNextMonth.split(" ");
				tempVal[0] = "day";
				String dayOfMonthXpath = "(//div[contains(@aria-label,'" + tempVal[0] + "-" + tempVal[1] + "')])[1]";

				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			}
			// Select Date of 2 days after based on Current Date:
			else {
				String currDate = currMonth + "-" + currDay + "-" + currYear;

				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(currDate);
				cal.setTime(d);

				// Select 2 days after Current Date:
				String secondDayOfCurrMonth;
				if (dateType == "startingDate")
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 2);
				else
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 4);

				String[] tempVal = secondDayOfCurrMonth.split(" ");
				tempVal[0] = "day";
				String dayOfMonthXpath = "(//div[contains(@aria-label,'" + tempVal[0] + "-" + tempVal[1] + "')])[1]";

				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchVerifyCreationOfPromocodePercent(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeSaveBtn).click().build().perform();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean dispatchDeletionOfPromocode(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeSearch).click().build().perform();
			action.moveToElement(dispatchPromocodeSearch).click().sendKeys(prop.getProperty("promoCodeNamePercent"))
					.build().perform();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchPromocodeDeleteBtn));

			if (displayStatus.isDisplayed()) {
				action.moveToElement(dispatchPromocodeDeleteBtn).click().build().perform();
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(dispatchPromocodeDeleteConf).click().build().perform();
				objTestBase.defaultWaitTime(1000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
				objTestBase.defaultWaitTime(1000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchPromocodeDeleteConfMsg));

				if (displayStatus.isDisplayed())
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

	// User Portal Methods:
	public void clickLogin() {
		try {
			action = new Actions(driver);
			action.moveToElement(signinBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("sanityeMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("sanityPwd"));
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
			if (signInBtn_Login.isDisplayed())
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
			action = new Actions(driver);
			action.moveToElement(signInBtn_Login).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnSecondaryPassenger() {
		try {
			action = new Actions(driver);
			action.moveToElement(secondaryPassenger).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signInBtnDropdown);
			if (signInBtnDropdown.isDisplayed()) {
				expected = signInBtnDropdown.getText();
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

	public void addFromAddress() {
		try {
			action = new Actions(driver);
			fromAddress.click();
			objTestBase.defaultWaitTime(1000);
			fromAddress.sendKeys(Keys.CONTROL + "A");
			fromAddress.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			fromAddress.sendKeys(prop.getProperty("fromAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addToAddress() {
		try {
			action = new Actions(driver);
			toAddress.sendKeys(prop.getProperty("toAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnExtraStop() {
		try {
			action = new Actions(driver);
			action.moveToElement(extraStopIcon).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addExtraStop() {
		try {
			action = new Actions(driver);
			addextraStop.sendKeys(prop.getProperty("extraStop"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDate() {
		try {
			objTestBase.defaultWaitTime(2000);
			driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']")).click();
			objTestBase.defaultWaitTime(2000);

			today = LocalDate.now();
			int currDay = today.getDayOfMonth();
			int currMonth = today.getMonthValue();
			int currYear = today.getYear();

			Calendar cal = Calendar.getInstance();
			int lastDateofMonth = cal.getActualMaximum(Calendar.DATE);

			// Select Date of Next Month:
			if (currDay >= lastDateofMonth - 2) {
				int nextMonth = today.getMonthValue() + 1;
				calendar.click();
				objTestBase.defaultWaitTime(1000);
				nextMonthArrow.click();
				objTestBase.defaultWaitTime(2000);

				// For Handling Month Count till 12:
				if (nextMonth == 13) {
					nextMonth = 01; // Set Constant Month value as January
				}
				// For Handling Leap Year February Month:
				else if (nextMonth == 2 && (currDay > 26 && currDay <= 28)) {
					currDay = 28;
				} else if (nextMonth == 2 && currDay > 28) {
					currDay = 2;
					nextMonth = 3; // Set Constant Month to March

					//-----------------------------------------------------------------------------------
					// Handing Feb month xpath issue:
					objTestBase.defaultWaitTime(1000);
					List<WebElement> nextMonthArrow = driver.findElements(By.xpath(
							"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])"));

					if (nextMonthArrow.size() > 1) {
						nextMonthArrow.clear();
						nextMonthArrow = driver.findElements(By.xpath(
								"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[2]"));
					}
					nextMonthArrow.get(0).click();
					objTestBase.defaultWaitTime(2000);
					//-----------------------------------------------------------------------------------
				}

				String nextMonthDate = nextMonth + "-" + currDay + "-" + currYear;
				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(nextMonthDate);
				cal.setTime(d);

				// Select 2nd Day of NextMonth
				String secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 2";
				String dayOfMonthXpath = "(//div[contains(@aria-label,'" + secondDayOfNextMonth + "')])[1]";

				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			}
			// Select Date of 2 days after based on Current Date:
			else {
				String currDate = currMonth + "-" + currDay + "-" + currYear;

				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(currDate);
				cal.setTime(d);

				// Select 2 days after Current Date:
				String secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 2);
				String dayOfMonthXpath = "//div[contains(@aria-label,'" + secondDayOfCurrMonth + "')]";

				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyVisibilityOfPaymentInfo(Boolean visibilityStatus) {
		try {
			if (paymentInfocheckbox.size() != 0 && paymentInfocheckbox.get(0).isDisplayed()) {
				waitTimeForElement(paymentInfocheckbox.get(0));
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enablePaymentInfo() {
		try {
			action = new Actions(driver);
			action.moveToElement(paymentInfocheckbox.get(0)).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOngetQuote() {
		try {
			action = new Actions(driver);
			action.moveToElement(getQuote).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSedan() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookSedan).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyVehicleConfirmationPopup(Boolean visibilityStatus) {
		try {
			if (confirmVehiclePopup.size() != 0) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickonConfirmPopup() {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmBtn.get(0)).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSUV() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookSUV).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSUVXL() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookSUVXL).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnVAN() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookVAN).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnVANXL() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookVANXL).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonPromocodeApply() {
		try {
			action = new Actions(driver);
			action.moveToElement(applypromoCode).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonConfirmBooking() {
		try {
			action = new Actions(driver);
			// Validate FAQs checkbox - User Portal Ride-Details Page:
			clickonFAQscheckbox();
			action.moveToElement(confirmBookingBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonBookNextRide() {
		try {
			waitTimeForElement(bookNextRideBtn);
			action = new Actions(driver);
			action.moveToElement(bookNextRideBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void promoCodeEnable() {
		try {
			action = new Actions(driver);
			action.moveToElement(promoCodeEnable).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspFirstName() {
		try {
			spFirstName.sendKeys(prop.getProperty("spFirstName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspLastName() {
		try {
			spLastName.sendKeys(prop.getProperty("spLastName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspEmail() {
		try {
			spEmail.sendKeys(prop.getProperty("spEmail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspMobile() {
		try {
			spMobile.sendKeys(prop.getProperty("spMobile"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAirline() {
		try {
			action = new Actions(driver);
			airlinesDrpdwnHeader.click();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(airlinesDrpdwnValue).sendKeys(prop.getProperty("airlineInput")).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFlightNumber() {
		try {
			flightNumber.sendKeys(prop.getProperty("flightNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPassengerNotes() {
		try {
			passengerNotes.sendKeys(prop.getProperty("pasengerNotes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPromocode() {
		try {
			action = new Actions(driver);
			action.moveToElement(promoCode).click().build().perform();
			action.moveToElement(promoCode).sendKeys(prop.getProperty("promoCodeNamePercent")).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideDetailsPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("ride-details")) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfListofVechiles(Boolean visibilityStatus) {
		try {
			if (vechileAvailableSection.isDisplayed()) {
				expected = vechileAvailableSection.getText();
				if (expected.toLowerCase().contains("choose") && vechileAvailableList.size() != 0) {
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

	public void enterPaymentInformation() throws Exception {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);

			// SwitchTo CardHolder Frame
			driver.switchTo().frame("braintree-hosted-field-cardholderName");
			cardHolderName.click();
			cardHolderName.sendKeys(prop.getProperty("walletcardHolderNameGuest"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo CardNumber Frame
			driver.switchTo().frame("braintree-hosted-field-number");
			cardHolderNumber.click();
			cardHolderNumber.sendKeys(prop.getProperty("walletcardNumberGuest"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Expiry Date
			driver.switchTo().frame("braintree-hosted-field-expirationDate");
			cardExpiryDate.click();
			String expiryDate = GetCurrentDateTime.getMonthYear(expected, "addCard");
			action.moveToElement(cardExpiryDate).click().sendKeys(expiryDate).perform();

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Expiry Date
			driver.switchTo().frame("braintree-hosted-field-cvv");
			cvv.click();
			cvv.sendKeys(prop.getProperty("walletCVVGuest"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Postal Code:
			driver.switchTo().frame("braintree-hosted-field-postalCode");
			postalCode.click();
			postalCode.sendKeys(prop.getProperty("walletPostalCodeGuest"));
			objTestBase.defaultWaitTime(1000);

			// SwitchBackTo Default Frame
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("completed"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyConfirmBookingBtnVisibility(Boolean visibilityStatus) {
		try {
			if (confirmBookingBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfVechileSection(Boolean visibilityStatus) {
		try {
			waitTimeForElement(bookSedan);
			visibilityStatus = true;
		} catch (Exception e) {
			visibilityStatus = false;
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean dispatchVerifyPromoTypeAndOneTimeUseOnlyStatus(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (!dispatchPercentchckbox.isSelected())
				action.moveToElement(dispatchPercentchckbox).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			if (!dispatchOneTimeUseOnlychckbox.isSelected())
				action.moveToElement(dispatchOneTimeUseOnlychckbox).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchPercentAmountLbl));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

}
