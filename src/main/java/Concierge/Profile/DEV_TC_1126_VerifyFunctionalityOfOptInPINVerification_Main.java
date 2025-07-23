package Concierge.Profile;

import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.time.Duration;
import java.util.Calendar;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1126_VerifyFunctionalityOfOptInPINVerification_Main extends TestBase {

	Date date;
	Actions action;
	String expected;
	LocalDate today;
	String currDate;
	String scenario;
	String testStep;
	WebDriver driver;
	String exception;
	String testStatus;
	int indexCount = 1;
	TestBase objTestBase;
	JavascriptExecutor js;
	String screenshotPath;
	Boolean visibilityStatus;
	GetCurrentDateTime getDate;
	SimpleDateFormat formatDate;
	UpdateExtentReportResults objupdateResults;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement dispatchCompanyName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement dispatchFirstName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement dispatchLastName;

	@FindBy(xpath = "//input[@type='email']")
	WebElement dispatchEMail;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement dispatchMobile;

	@FindBy(xpath = "//input[@placeholder='Work Address']")
	WebElement dispatchWorkaddress;

	@FindBy(xpath = "//input[@id='pin_opt_in']")
	WebElement dispatchoptInChkbox;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputConcierge;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputConcierge;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnConcierge;

	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profileTab;

	@FindBy(xpath = "//button[contains(text(),'Edit Profile')]")
	WebElement editProfileBtn;

	@FindBy(xpath = "//input[@id='pin_opt_in']")
	WebElement conciergeoptInChkbox;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	// New Booking Validation Elements:
	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "//input[@placeholder='Pickup Address']")
	WebElement fromAddress;

	@FindBy(xpath = "//input[@placeholder='Drop Off Address']")
	WebElement toAddress;

	@FindBy(xpath = "//span[normalize-space()='Add Stops']")
	WebElement extraStopIcon;

	@FindBy(xpath = "//input[@placeholder='Stop 1']")
	WebElement addextraStop;

	@FindBy(xpath = "//span[@class='MuiIconButton-label']//div")
	WebElement calendar;

	@FindBy(xpath = "//input[@id='date-picker-inline']")
	WebElement dateInput;

	@FindBy(xpath = "//span[normalize-space()='Show Vehicles']")
	WebElement getQuote;

	@FindBy(xpath = "//span[normalize-space()='Choose Vehicle']//following-sibling::div")
	List<WebElement> vechileAvailableSection;

	@FindBy(xpath = "//div[normalize-space()='Sedan']")
	WebElement bookSedan;

	@FindBy(xpath = "//input[@name='passengerFirstName']")
	WebElement primaryFirstName;

	@FindBy(xpath = "//input[@name='passengerLastName']")
	WebElement primaryLastName;

	@FindBy(xpath = "//input[@name='passengerMobileNumber']")
	WebElement primaryMobile;

	@FindBy(xpath = "//input[@name='passengerEmail']")
	WebElement primaryEmail;

	@FindBy(xpath = "(//div[normalize-space()='Add Secondary Passenger'])[1]")
	WebElement addSecondaryPassengerDetailsLink;

	@FindBy(xpath = "//input[@name='secondaryFirstName']")
	WebElement spFirstName;

	@FindBy(xpath = "//input[@name='secondaryLastName']")
	WebElement spLastName;

	@FindBy(xpath = "//input[@name='secondaryMobileNumber']")
	WebElement spMobile;

	@FindBy(xpath = "//input[@name='secondaryEmail']")
	WebElement spEmail;

	@FindBy(xpath = "(//select[@name='age'])[1]")
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "//input[@placeholder='Flight Number']")
	WebElement flightNumber;

	@FindBy(xpath = "//textarea[@name='passengerNotes']")
	WebElement passengerNotes;

	@FindBy(xpath = "(//input[@name='checkedC'])[5]")
	WebElement promoCodeEnable;

	@FindBy(xpath = "//textarea[@id='promo_code']")
	WebElement promoCode;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement applypromoCode;

	@FindBy(xpath = "//input[@placeholder='Cardholder Name']")
	WebElement cardHolderName;

	@FindBy(xpath = "//div[@aria-label='Paying with Card']")
	WebElement cardOptions;

	@FindBy(xpath = "//input[@name='credit-card-number']")
	WebElement cardHolderNumber;

	@FindBy(xpath = "//input[@name='expiration']")
	WebElement cardExpiryDate;

	@FindBy(xpath = "//input[@id='cvv']")
	WebElement cvv;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;

	@FindBy(xpath = "//button[normalize-space()='Confirm Booking']")
	WebElement confirmBookingBtn;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//td[@tabindex='3']")
	WebElement rideStatusConcierge;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement ridePlaceDateTimeConcierge;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement bookingRideTripIdConcierge;

	@FindBy(xpath = "//td[@tabindex='11']//div")
	WebElement bookedPassengerNameConcierge;

	@FindBy(xpath = "//td[@tabindex='13']")
	WebElement vehicleTypeConcierge;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchUser;

	// Dispatch Site Elements:
	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputDispatch;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputDispatch;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnDispatch;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUserDispatch;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideIdDispatch;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatusDispatch;

	@FindBy(xpath = "//li[text()='Farm Out']")
	WebElement formOutTabDispatch;

	@FindBy(xpath = "//input[@placeholder='Enter Company name']")
	WebElement companyNameDispatch;

	@FindBy(xpath = "//input[@name='farm out']")
	WebElement farmoutDispatch;

	// Affiliate Site Elements:
	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputAffiliate;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputAffiliate;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnAffiliate;

	@FindBy(xpath = "(//span[contains(text(),'Rides')])[1]")
	WebElement ridesTabAffiliate;

	@FindBy(xpath = "(//span[contains(text(),'Upcoming')])[1]")
	WebElement upcomingTabAffiliate;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTripIDAffiliate;

	@FindBy(xpath = "//td[@tabindex='5']")
	WebElement rideIDAffiliate;

	public DEV_TC_1126_VerifyFunctionalityOfOptInPINVerification_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eMailInputConcierge() {
		try {
			action = new Actions(driver);
			eMailInputConcierge.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInputConcierge() {
		try {
			action = new Actions(driver);
			passwordInputConcierge.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonConcierge(Boolean visibilityStatus) {
		try {
			if (signInBtnConcierge.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonConcierge() {
		try {
			signInBtnConcierge.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserConcierge(Boolean visibilityStatus) {
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

	public Boolean verifyProfilePageConcierge(Boolean visibilityStatus) {
		try {
			if (signinUser.isDisplayed()) {
				signinUser.click();
				defaultWaitTime(1000);
				profileTab.click();
				defaultWaitTime(2000);
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("profile"))
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

	public Boolean verifyEditProfilePageConcierge(Boolean visibilityStatus) {
		try {
			if (editProfileBtn.isDisplayed()) {
				editProfileBtn.click();
				defaultWaitTime(3000);
				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckedDefaultConcierge(Boolean visibilityStatus) {
		try {
			if (conciergeoptInChkbox.isSelected())
				visibilityStatus = true;
			else
				visibilityStatus = false;
			return visibilityStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckUncheckConcierge(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					if (conciergeoptInChkbox.isSelected()) {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (!conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					}
				} else if (i == 1) {
					if (conciergeoptInChkbox.isSelected()) {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (!conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyUpdateConfMsgConcierge(Boolean visibilityStatus) {
		try {
			String msgText = "";
			updateBtn.click();
			objTestBase.defaultWaitTime(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				msgText = alertMessge.getText().toLowerCase();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus == true && msgText.contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilitOfNewBookingTab(Boolean visibilityStatus) {
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
			action = new Actions(driver);
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(calendar).click().build().perform();
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

					// -----------------------------------------------------------------------------------
					// Handing Feb month xpath issue:
					objTestBase.defaultWaitTime(1000);
					List<WebElement> nextMonthArrow = driver.findElements(By.xpath(
							"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])"));

					if (nextMonthArrow.size() > 1) {
						nextMonthArrow.clear();
						nextMonthArrow = driver.findElements(By.xpath(
								"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])[2]"));
					}
					nextMonthArrow.get(0).click();
					objTestBase.defaultWaitTime(2000);
					// -----------------------------------------------------------------------------------
				}

				String nextMonthDate = nextMonth + "-" + currDay + "-" + currYear;
				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(nextMonthDate);
				cal.setTime(d);

				// Select NextMonth 30 as Static Date:
				String secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 30";
				secondDayOfNextMonth = secondDayOfNextMonth.replaceAll("[a-zA-Z]", "").trim();
				String dayOfMonthXpath = "//span[@class='MuiIconButton-label']//following::p[contains(text(),'"
						+ secondDayOfNextMonth + "')]";

				List<WebElement> element = driver.findElements(By.xpath(dayOfMonthXpath));
				if (element.size() == 1)
					action.moveToElement(element.get(0)).click().build().perform();
				else
					action.moveToElement(element.get(1)).click().build().perform();
				objTestBase.defaultWaitTime(2000);
			}
			// Select Date of 2 days after based on Current Date:
			else {
				String currDate = currMonth + "-" + currDay + "-" + currYear;
				String secondDayOfCurrMonth;

				if (currDay != 22)
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 3);
				else
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 4);

				secondDayOfCurrMonth = secondDayOfCurrMonth.replaceAll("[a-zA-Z]", "").trim();

				String dayOfMonthXpath = "//span[@class='MuiIconButton-label']//following::p[contains(text(),'"
						+ secondDayOfCurrMonth + "')]";

				List<WebElement> element = driver.findElements(By.xpath(dayOfMonthXpath));
				if (element.size() == 1)
					action.moveToElement(element.get(0)).click().build().perform();
				else
					action.moveToElement(element.get(1)).click().build().perform();
				objTestBase.defaultWaitTime(2000);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfVechileSection(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(2000);
			if (vechileAvailableSection.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			visibilityStatus = false;
			e.printStackTrace();
		}
		return visibilityStatus;
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

	public void searchBookingUserName() {
		try {
			action = new Actions(driver);
			action.moveToElement(primaryFirstName).click().sendKeys(prop.getProperty("primaryFirstName")).build()
					.perform();
			objTestBase.defaultWaitTime(5000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
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
			action.moveToElement(confirmBookingBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickRidesSection() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(ridesSection));
			if (displayStatus.isDisplayed()) {
				ridesSection.click();
				objTestBase.defaultWaitTime(1000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public void clickOnAddSecondaryPassengerDetails() {
		try {
			action = new Actions(driver);
			action.moveToElement(addSecondaryPassengerDetailsLink).click().build().perform();
			objTestBase.defaultWaitTime(3000);
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
			Select select = new Select(airlinesDrpdwnHeader);
			select.selectByValue(prop.getProperty("airlineInput"));
			objTestBase.defaultWaitTime(2000);
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

	public void enterPromocode(String vechileModel) {
		try {
			action = new Actions(driver);
			action.moveToElement(promoCode).click().build().perform();
			if (vechileModel.equalsIgnoreCase("Book Sedan"))
				action.moveToElement(promoCode).sendKeys(prop.getProperty("promocodeFixed")).build().perform();
			else if (vechileModel.equalsIgnoreCase("Book SUV"))
				action.moveToElement(promoCode).sendKeys(prop.getProperty("promocodePercentage")).build().perform();
			else if (vechileModel.equalsIgnoreCase("Book SUVXL"))
				action.moveToElement(promoCode).sendKeys(prop.getProperty("promocodeFixed")).build().perform();
			else if (vechileModel.equalsIgnoreCase("Book VAN"))
				action.moveToElement(promoCode).sendKeys(prop.getProperty("promocodePercentage")).build().perform();
			else if (vechileModel.equalsIgnoreCase("Book VANXL"))
				action.moveToElement(promoCode).sendKeys(prop.getProperty("promocodeFixed")).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
		try {
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
			if (visibilityStatus == true && msgText.contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);
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

	public void enterPaymentInformation() throws Exception {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			
			cardOptions.click();
			objTestBase.defaultWaitTime(2000);

			driver.switchTo().frame("braintree-hosted-field-cardholderName");
			cardHolderName.sendKeys(prop.getProperty("walletcardHolderName"));
			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();


			// SwitchTo CardNumber Frame
			driver.switchTo().frame("braintree-hosted-field-number");
			cardHolderNumber.click();
			cardHolderNumber.sendKeys(prop.getProperty("walletcardNumber"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Expiry Date
			driver.switchTo().frame("braintree-hosted-field-expirationDate");
			cardExpiryDate.click();
			String expiryDate = GetCurrentDateTime.getMonthYear(expected, "addCard");
			action.moveToElement(cardExpiryDate).click().sendKeys(expiryDate).perform();

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo CVV
			driver.switchTo().frame("braintree-hosted-field-cvv");
			cvv.click();
			cvv.sendKeys(prop.getProperty("walletCVV"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Postal Code:
			driver.switchTo().frame("braintree-hosted-field-postalCode");
			postalCode.click();
			postalCode.sendKeys(prop.getProperty("walletPostalCode"));
			objTestBase.defaultWaitTime(1000);

			// SwitchBackTo Default Frame
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String captureRideBookingIDsConcierge(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			action = new Actions(driver);
			ridesTabAll.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(500);
				action.moveToElement(searchUser).click().sendKeys(prop.getProperty("primaryFirstName")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripIdConcierge.isDisplayed()
						&& !rideBookingIdsConcierge.containsValue(bookingRideTripIdConcierge.getText())) {
					System.out.println(rideStatusConcierge.getText().toLowerCase());
					System.out.println(bookedPassengerNameConcierge.getText().toLowerCase());
					System.out.println(ridePlaceDateTimeConcierge.getText().toLowerCase());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatusConcierge.getText().toLowerCase().contains("cancelled")
							|| !rideStatusConcierge.getText().toLowerCase().contains("completed"))
							&& bookedPassengerNameConcierge.getText().toLowerCase().contains("qa automation")
							&& ridePlaceDateTimeConcierge.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00
																										// AM
					{
						objTestBase.defaultWaitTime(1000);
						rideBookingIdsConcierge.put(vehicleTypeConcierge.getText().toLowerCase(),
								bookingRideTripIdConcierge.getText().toString());
						objTestBase.defaultWaitTime(500);
						tripID = bookingRideTripIdConcierge.getText().toString();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else
						testStatus = "FAILED";
					utillLogger.info(testStep + " - DEV_TC_1126_Concierge - Capture the Trip ID = " + tripID);
				} else {
					visibilityStatus = false;
					if (localExecutionFlag == true)
						objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
					else
						lambdaTestStatusUpdate("failed", testStep);
				}
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tripID;
	}

	private String getCurrDate(String currDate) {
		try {
			date = new Date();
			formatDate = new SimpleDateFormat("MM-dd-yyyy");
			currDate = formatDate.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currDate;
	}

	public void eMailInputDispatch() {
		try {
			action = new Actions(driver);
			eMailInputDispatch.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInputDispatch() {
		try {
			action = new Actions(driver);
			passwordInputDispatch.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonDispatch(Boolean visibilityStatus) {
		try {
			if (signInBtnDispatch.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonDispatch() {
		try {
			signInBtnDispatch.click();
			// Validate Dispatch 2fa Authentication:
//			Boolean visibilityStatus1 = false;
//			visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean visibilityOfLoggedinUserDispatch(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed()) {
				expected = signinUserDispatch.getText();
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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfRidesAllPage(Boolean visibilityStatus) {
		try {
			ridesTabAll.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void searchRideId(String tripID) {
		try {
			searchRideIdDispatch.sendKeys(tripID);
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean validateTripIDDetailsDispatch(Boolean visibilityStatus) {
		// Get the CurrentDate:
		currDate = getCurrDate(currDate);
		System.out.println(rideStatusConcierge.getText().toLowerCase());
		System.out.println(bookedPassengerNameConcierge.getText().toLowerCase());
		System.out.println(ridePlaceDateTimeConcierge.getText().toLowerCase());
		if ((!rideStatusConcierge.getText().toLowerCase().contains("cancelled")
				|| !rideStatusConcierge.getText().toLowerCase().contains("completed"))
				&& bookedPassengerNameConcierge.getText().toLowerCase().contains("test user")
				&& ridePlaceDateTimeConcierge.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public Boolean verifyFormout(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(rideStatusDispatch).click().build().perform();
			objTestBase.defaultWaitTime(1000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			objTestBase.defaultWaitTime(500);

			action.moveToElement(formOutTabDispatch).click().build().perform();
			objTestBase.defaultWaitTime(500);
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(500);
			action.moveToElement(companyNameDispatch).click().sendKeys(prop.getProperty("conciergeCompanyName")).build()
					.perform();
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(500);

			farmoutDispatch.click();
			objTestBase.defaultWaitTime(2000);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyFarmedOutConfirmation(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

			if (displayStatus.isDisplayed()
					&& alertMessge.getText().toString().toLowerCase().contains("manual farm out enabled"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void eMailInputAffiliate() {
		try {
			action = new Actions(driver);
			eMailInputAffiliate.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInputAffiliate() {
		try {
			action = new Actions(driver);
			passwordInputAffiliate.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonAffiliate(Boolean visibilityStatus) {
		try {
			if (signInBtnAffiliate.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonAffiliate() {
		try {
			signInBtnAffiliate.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserAffiliate(Boolean visibilityStatus) {
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

	public Boolean verifyRideDetailsUpcomingTabAffiliate(Boolean visibilityStatus, String tripID) {
		try {
			ridesTabAffiliate.click();
			objTestBase.defaultWaitTime(1000);

			upcomingTabAffiliate.click();
			objTestBase.defaultWaitTime(1000);

			action = new Actions(driver);
			action.moveToElement(searchTripIDAffiliate).click().sendKeys(tripID).build().perform();
			objTestBase.defaultWaitTime(3000);

			if (rideIDAffiliate.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
