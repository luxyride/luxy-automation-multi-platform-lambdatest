package Dispatch.NewBooking;

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

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class DEV_TC_2107_VerifyThatTheJfkLinkIsNotIncludedInTheConfirmationEmailForCustomersBookingToOrFromWithOtherAirportAddresses_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	String testStatus;
	String scenario;
	String testStep;
	Boolean visibilityStatus;
	String screenshotPath;
	String exception;
	int indexCount = 1;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn_Login;

	@FindBy(xpath = "//button[@class='accoutBtn dropdown-toggle']")
	WebElement signInBtnDropdown;

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

	@FindBy(xpath = "//button[normalize-space()='Get Quote']")
	WebElement getQuote;

	@FindBy(xpath = "//span[normalize-space()='Choose Vehicle']//following-sibling::div")
	List<WebElement> vechileAvailableSection;

	@FindBy(xpath = "//div[(@title='Sedan') and normalize-space()='Sedan']")
	WebElement bookSedan;

	@FindBy(xpath = "//div[(@title='SUV') and normalize-space()='SUV']")
	WebElement bookSUV;

	@FindBy(xpath = "//div[(@title='SUV-XL') and normalize-space()='SUV-XL']")
	WebElement bookSUVXL;

	@FindBy(xpath = "//div[(@title='Van') and normalize-space()='Van']")
	WebElement bookVAN;

	@FindBy(xpath = "//div[(@title='Van-XL') and normalize-space()='Van-XL']")
	WebElement bookVANXL;

	@FindBy(xpath = "//input[@name='bookingUser']")
	WebElement searchBookingUser;

	@FindBy(xpath = "//input[@value='false']")
	WebElement checkBox;

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

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span)[1]")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatus;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTime;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//td[@tabindex='12']//a")
	WebElement bookedPassengerName;

	@FindBy(xpath = "//td[@tabindex='15']")
	WebElement vehicleType;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@id='clearbut']//a")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchUser;

	@FindBy(xpath = "//b[normalize-space()='Note:']")
	WebElement note;

	LocalDate today;
	TestBase objTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;

	public DEV_TC_2107_VerifyThatTheJfkLinkIsNotIncludedInTheConfirmationEmailForCustomersBookingToOrFromWithOtherAirportAddresses_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
			getDate = new GetCurrentDateTime();
			objupdateResults = new UpdateExtentReportResults(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
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
			// Validate Dispatch 2fa Authentication:
//			Boolean visibilityStatus = false;
//			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(2000);
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
			fromAddress.sendKeys(prop.getProperty("zoneTypeAirportFromAddress"));
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
			toAddress.sendKeys(prop.getProperty("zoneTypeAirportToAddressPositives"));
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
							"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])"));

					if (nextMonthArrow.size() > 1) {
						nextMonthArrow.clear();
						nextMonthArrow = driver.findElements(By.xpath(
								"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[2]"));
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
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 1);
				else
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 2);

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
			action.moveToElement(confirmBookingBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickRidesSection() {
		try {
			ridesSection.click();
			objTestBase.defaultWaitTime(1000);
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

	public void searchBookingUserName() {
		try {
			action = new Actions(driver);
			action.moveToElement(searchBookingUser).click().sendKeys(prop.getProperty("dispatchadminMail")).build()
					.perform();
			objTestBase.defaultWaitTime(6000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickcheckbox() {
		action = new Actions(driver);
		action.moveToElement(checkBox).click().build().perform();
	}

	public void enterPrimaryFirstName() {
		try {
			primaryFirstName.sendKeys(prop.getProperty("fName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPrimaryLastName() {
		try {
			primaryLastName.sendKeys(prop.getProperty("lName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPrimaryEmail() {
		try {
			primaryEmail.sendKeys(prop.getProperty("dispatchadminMail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPrimaryMobile() {
		try {
			primaryMobile.sendKeys(prop.getProperty("phoneNumber"));
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

	public String captureRideBookingIDs(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			action = new Actions(driver);
			ridesTabAll.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(500);
				action.moveToElement(searchUser).click().sendKeys(prop.getProperty("dispatchadminMail")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripId.isDisplayed()
						&& !rideBookingDispatchIds.containsValue(bookingRideTripId.getText())) {
					System.out.println(rideStatus.getText().toLowerCase());
					System.out.println(bookedPassengerName.getText().toLowerCase());
					System.out.println(ridePlaceDateTime.getText().toLowerCase());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatus.getText().toLowerCase().contains("cancelled")
							|| !rideStatus.getText().toLowerCase().contains("completed"))
							&& bookedPassengerName.getText().toLowerCase().contains("test user")
							&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						rideBookingDispatchIds.put(vehicleType.getText().toLowerCase(),
								bookingRideTripId.getText().toString());
						objTestBase.defaultWaitTime(500);
						tripID = bookingRideTripId.getText().toString();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else
						testStatus = "FAILED";
					utillLogger.info(testStep + " - Capture the Trip ID = " + tripID);
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
		date = new Date();
		formatDate = new SimpleDateFormat("MM-dd-yyyy");
		currDate = formatDate.format(date);
		return currDate;
	}

	public void clearButton() {
		try {
			if (clearBtn.get(0).isDisplayed()) {
				waitTimeForElement(clearBtn.get(0));
				clearBtn.get(0).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyyopeMail(Boolean visibilityStatus) {
		try {
			driver.switchTo().frame("ifmail");
			objTestBase.defaultWaitTime(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			defaultWaitTime(2000);
			js.executeScript("arguments[0].scrollIntoView(true);", note);
			objTestBase.defaultWaitTime(2000);
			if (!note.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void emailIDSerach() {
		try {
			loginBtn.sendKeys(prop.getProperty("dispatchadminMail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
