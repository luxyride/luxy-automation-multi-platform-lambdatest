package Affiliate.NewBookings;

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
import common.UpdateExtentReportResults;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1956_VerifyTheFunctionalityOfAddingDriverManuallyForONATripsInUPCOMINGRides_AffiliatePortal_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	// Affiliate WebElements:
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

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesTab;

	@FindBy(xpath = "(//span[normalize-space()='Available'])[1]")
	WebElement availableTab;

	@FindBy(xpath = "(//*[normalize-space()='Ride Dashboard'])[1]")
	WebElement rideDashboardHeader;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTripID;

	@FindBy(xpath = "//i[@title='Claim Ride']")
	WebElement claimRide;

	@FindBy(xpath = "//button[text()='Yes']")
	List<WebElement> yesBtn;

	// Dispatch Configuration:
	LocalDate dispatchtoday;
	TestBase dispatchobjTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime dispatchgetDate;
	UpdateExtentReportResults objupdateResults;
	Date dispatchdate;
	SimpleDateFormat dispatchformatDate;
	String dispatchcurrDate;
	String testStatus;
	String testStep;
	String screenshotPath;
	String exception;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchSearch;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement dispatchTripID;

	@FindBy(xpath = "//li[normalize-space()='Farm Out']")
	WebElement dispatchFarmout;

	@FindBy(xpath = "//input[@placeholder='Enter Company name']")
	WebElement dispatchCompanyName;

	@FindBy(xpath = "//input[@type='checkbox' and @name='farm out']")
	List<WebElement> dispatchFarmoutCheckbox;

	@FindBy(xpath = "//input[@type='text']")
	WebElement dispatcheMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement dispatchpasswordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement dispatcheyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement dispatchsignInBtn_Login;

	@FindBy(xpath = "//button[@class='accoutBtn dropdown-toggle']")
	WebElement dispatchsignInBtnDropdown;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement dispatchnewBookingTab;

	@FindBy(xpath = "//input[@placeholder='Pickup Address']")
	WebElement dispatchfromAddress;

	@FindBy(xpath = "//input[@placeholder='Drop Off Address']")
	WebElement dispatchtoAddress;

	@FindBy(xpath = "//span[normalize-space()='Add Stops']")
	WebElement dispatchextraStopIcon;

	@FindBy(xpath = "//input[@placeholder='Stop 1']")
	WebElement dispatchaddextraStop;

	@FindBy(xpath = "//span[@class='MuiIconButton-label']//div")
	WebElement dispatchcalendar;

	@FindBy(xpath = "//input[@id='date-picker-inline']")
	WebElement dispatchdateInput;

	@FindBy(xpath = "//button[normalize-space()='Get Quote']")
	WebElement dispatchgetQuote;

	@FindBy(xpath = "//span[normalize-space()='Choose Vehicle']//following-sibling::div")
	List<WebElement> vechileAvailableSection;

	@FindBy(xpath = "//div[(@title='Sedan') and normalize-space()='Sedan']")
	WebElement dispatchbookSedan;

	@FindBy(xpath = "//div[(@title='SUV') and normalize-space()='SUV']")
	WebElement dispatchbookSUV;

	@FindBy(xpath = "//div[(@title='SUV-XL') and normalize-space()='SUV-XL']")
	WebElement dispatchbookSUVXL;

	@FindBy(xpath = "//div[(@title='Van') and normalize-space()='Van']")
	WebElement dispatchbookVAN;

	@FindBy(xpath = "//div[(@title='Van-XL') and normalize-space()='Van-XL']")
	WebElement dispatchbookVANXL;

	@FindBy(xpath = "//input[@name='bookingUser']")
	WebElement dispatchsearchBookingUser;

	@FindBy(xpath = "//input[@value='false']")
	WebElement dispatchcheckBox;

	@FindBy(xpath = "//input[@name='passengerFirstName']")
	WebElement dispatchprimaryFirstName;

	@FindBy(xpath = "//input[@name='passengerLastName']")
	WebElement dispatchprimaryLastName;

	@FindBy(xpath = "//input[@name='passengerMobileNumber']")
	WebElement dispatchprimaryMobile;

	@FindBy(xpath = "//input[@name='passengerEmail']")
	WebElement dispatchprimaryEmail;

	@FindBy(xpath = "(//div[normalize-space()='Add Secondary Passenger'])[1]")
	WebElement dispatchaddSecondaryPassengerDetailsLink;

	@FindBy(xpath = "//input[@name='secondaryFirstName']")
	WebElement dispatchspFirstName;

	@FindBy(xpath = "//input[@name='secondaryLastName']")
	WebElement dispatchspLastName;

	@FindBy(xpath = "//input[@name='secondaryMobileNumber']")
	WebElement dispatchspMobile;

	@FindBy(xpath = "//input[@name='secondaryEmail']")
	WebElement dispatchspEmail;

	@FindBy(xpath = "(//select[@name='age'])[1]")
	WebElement dispatchairlinesDrpdwnHeader;

	@FindBy(xpath = "//input[@placeholder='Flight Number']")
	WebElement dispatchflightNumber;

	@FindBy(xpath = "//textarea[@name='passengerNotes']")
	WebElement dispatchpassengerNotes;

	@FindBy(xpath = "(//input[@name='checkedC'])[5]")
	WebElement dispatchpromoCodeEnable;

	@FindBy(xpath = "//textarea[@id='promo_code']")
	WebElement dispatchpromoCode;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement dispatchapplypromoCode;

	@FindBy(xpath = "//input[@placeholder='Cardholder Name']")
	WebElement dispatchcardHolderName;

	@FindBy(xpath = "//input[@name='credit-card-number']")
	WebElement dispatchcardHolderNumber;

	@FindBy(xpath = "//input[@name='expiration']")
	WebElement dispatchcardExpiryDate;

	@FindBy(xpath = "//input[@id='cvv']")
	WebElement dispatchcvv;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement dispatchpostalCode;

	@FindBy(xpath = "//button[normalize-space()='Confirm Booking']")
	WebElement dispatchconfirmBookingBtn;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement dispatchridesSection;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement dispatchridesTabAll;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span)[1]")
	WebElement dispatchnextMonthArrow;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement dispatchrideStatus;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement dispatchridePlaceDateTime;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement dispatchbookingRideTripId;

	@FindBy(xpath = "//td[@tabindex='12']//a")
	WebElement dispatchbookedPassengerName;

	@FindBy(xpath = "//td[@tabindex='15']")
	WebElement dispatchvehicleType;

	@FindBy(xpath = "//input[@id='login']")
	WebElement dispatchloginBtn;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> dispatchclearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> dispatchpinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> dispatchmailSubject;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchsearchUser;

	@FindBy(xpath = "//span[normalize-space()='Choose Vehicle']//following-sibling::div")
	List<WebElement> dispatchvechileAvailableSection;

	TestBase objTestBase;

	public DEV_TC_1956_VerifyTheFunctionalityOfAddingDriverManuallyForONATripsInUPCOMINGRides_AffiliatePortal_Main(
			WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objTestBase = new TestBase();
		dispatchgetDate = new GetCurrentDateTime();
		objupdateResults = new UpdateExtentReportResults(driver);
	}

	// Dispatch Methods:
	public void dispatcheMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dispatchpasswordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dispatcheyeIconClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchvisibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			if (dispatchsignInBtn_Login.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void dispatchlickonSigninButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchsignInBtn_Login).click().build().perform();
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchvisibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(2000);
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

	public Boolean dispatchvisibilitOfNewBookingTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchnewBookingTab).click().build().perform();
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

	public void dispatchaddFromAddress() {
		try {
			action = new Actions(driver);
			dispatchfromAddress.click();
			objTestBase.defaultWaitTime(1000);
			dispatchfromAddress.sendKeys(Keys.CONTROL + "A");
			dispatchfromAddress.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			dispatchfromAddress.sendKeys(prop.getProperty("fromAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchaddToAddress() {
		try {
			action = new Actions(driver);
			dispatchtoAddress.sendKeys(prop.getProperty("toAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickOnExtraStop() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchextraStopIcon).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchaddExtraStop() {
		try {
			action = new Actions(driver);
			dispatchaddextraStop.sendKeys(prop.getProperty("extraStop"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterDate() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(dispatchcalendar).click().build().perform();
			objTestBase.defaultWaitTime(2000);

			dispatchtoday = LocalDate.now();
			int currDay = dispatchtoday.getDayOfMonth();
			int currMonth = dispatchtoday.getMonthValue();
			int currYear = dispatchtoday.getYear();

			Calendar cal = Calendar.getInstance();
			int lastDateofMonth = cal.getActualMaximum(Calendar.DATE);

			// Select Date of Next Month:
			if (currDay >= lastDateofMonth - 2) {
				int nextMonth = dispatchtoday.getMonthValue() + 1;
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

	public Boolean dispatchvisibilityOfVechileSection(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(2000);
			if (dispatchvechileAvailableSection.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			visibilityStatus = false;
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void dispatchclickOngetQuote() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchgetQuote).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickOnSedan() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchbookSedan).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickonPromocodeApply() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchapplypromoCode).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickonConfirmBooking() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchconfirmBookingBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickRidesSection() {
		try {
			dispatchridesSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dispatchpromoCodeEnable() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchpromoCodeEnable).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchsearchBookingUserName() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchsearchBookingUser).click().sendKeys(prop.getProperty("dispatchadminMail"))
					.build().perform();
			objTestBase.defaultWaitTime(6000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickcheckbox() {
		action = new Actions(driver);
		action.moveToElement(dispatchcheckBox).click().build().perform();
	}

	public void dispatchenterPrimaryFirstName() {
		try {
			dispatchprimaryFirstName.sendKeys(prop.getProperty("fName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterPrimaryLastName() {
		try {
			dispatchprimaryLastName.sendKeys(prop.getProperty("lName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterPrimaryEmail() {
		try {
			dispatchprimaryEmail.sendKeys(prop.getProperty("dispatchadminMail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPrimaryMobile() {
		try {
			dispatchprimaryMobile.sendKeys(prop.getProperty("phoneNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickOnAddSecondaryPassengerDetails() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchaddSecondaryPassengerDetailsLink).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchnterspFirstName() {
		try {
			dispatchspFirstName.sendKeys(prop.getProperty("spFirstName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspLastName() {
		try {
			dispatchspLastName.sendKeys(prop.getProperty("spLastName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterspEmail() {
		try {
			dispatchspEmail.sendKeys(prop.getProperty("spEmail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterspMobile() {
		try {
			dispatchspMobile.sendKeys(prop.getProperty("spMobile"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchaddAirline() {
		try {
			action = new Actions(driver);
			dispatchairlinesDrpdwnHeader.click();
			objTestBase.defaultWaitTime(1000);
			Select select = new Select(dispatchairlinesDrpdwnHeader);
			select.selectByValue(prop.getProperty("airlineInput"));
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterFlightNumber() {
		try {
			dispatchflightNumber.sendKeys(prop.getProperty("flightNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterPassengerNotes() {
		try {
			dispatchpassengerNotes.sendKeys(prop.getProperty("pasengerNotes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchenterPromocode(String vechileModel) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchpromoCode).click().build().perform();
			if (vechileModel.equalsIgnoreCase("Book Sedan"))
				action.moveToElement(dispatchpromoCode).sendKeys(prop.getProperty("promocodeFixed")).build().perform();
			else if (vechileModel.equalsIgnoreCase("Book SUV"))
				action.moveToElement(dispatchpromoCode).sendKeys(prop.getProperty("promocodePercentage")).build()
						.perform();
			else if (vechileModel.equalsIgnoreCase("Book SUVXL"))
				action.moveToElement(dispatchpromoCode).sendKeys(prop.getProperty("promocodeFixed")).build().perform();
			else if (vechileModel.equalsIgnoreCase("Book VAN"))
				action.moveToElement(dispatchpromoCode).sendKeys(prop.getProperty("promocodePercentage")).build()
						.perform();
			else if (vechileModel.equalsIgnoreCase("Book VANXL"))
				action.moveToElement(dispatchpromoCode).sendKeys(prop.getProperty("promocodeFixed")).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean dispatchverifyRideBookingConfirmation(Boolean visibilityStatus) {
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

	public Boolean dispatchverifyConfirmBookingBtnVisibility(Boolean visibilityStatus) {
		try {
			if (dispatchconfirmBookingBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void dispatchenterPaymentInformation() throws Exception {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);

			driver.switchTo().frame("braintree-hosted-field-cardholderName");
			dispatchcardHolderName.sendKeys(prop.getProperty("walletcardHolderName"));
			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo CardNumber Frame
			driver.switchTo().frame("braintree-hosted-field-number");
			dispatchcardHolderNumber.click();
			dispatchcardHolderNumber.sendKeys(prop.getProperty("walletcardNumber"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Expiry Date
			driver.switchTo().frame("braintree-hosted-field-expirationDate");
			dispatchcardExpiryDate.click();
			String expiryDate = GetCurrentDateTime.getMonthYear(expected, "addCard");
			action.moveToElement(dispatchcardExpiryDate).click().sendKeys(expiryDate).perform();

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo CVV
			driver.switchTo().frame("braintree-hosted-field-cvv");
			dispatchcvv.click();
			dispatchcvv.sendKeys(prop.getProperty("walletCVV"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Postal Code:
			driver.switchTo().frame("braintree-hosted-field-postalCode");
			dispatchpostalCode.click();
			dispatchpostalCode.sendKeys(prop.getProperty("walletPostalCode"));
			objTestBase.defaultWaitTime(1000);

			// SwitchBackTo Default Frame
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String dispatchcaptureRideBookingIDs(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			action = new Actions(driver);
			dispatchridesTabAll.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(500);
				action.moveToElement(dispatchsearchUser).click().sendKeys(prop.getProperty("dispatchadminMail")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (dispatchbookingRideTripId.isDisplayed()
						&& !rideBookingDispatchIds.containsValue(dispatchbookingRideTripId.getText())) {
					System.out.println(dispatchrideStatus.getText().toLowerCase());
					System.out.println(dispatchbookedPassengerName.getText().toLowerCase());
					System.out.println(dispatchridePlaceDateTime.getText().toLowerCase());

					// Get the CurrentDate:
					dispatchcurrDate = dispatchgetCurrDate(dispatchcurrDate);

					if ((!dispatchrideStatus.getText().toLowerCase().contains("cancelled")
							|| !dispatchrideStatus.getText().toLowerCase().contains("completed"))
							&& dispatchbookedPassengerName.getText().toLowerCase().contains("test user")
							&& dispatchridePlaceDateTime.getText().toLowerCase().contains(dispatchcurrDate))// 06-27-2023
																											// 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						rideBookingDispatchIds.put(dispatchvehicleType.getText().toLowerCase(),
								dispatchbookingRideTripId.getText().toString());
						objTestBase.defaultWaitTime(500);
						tripID = dispatchbookingRideTripId.getText().toString();
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

	private String dispatchgetCurrDate(String currDate) {
		dispatchdate = new Date();
		dispatchformatDate = new SimpleDateFormat("MM-dd-yyyy");
		currDate = dispatchformatDate.format(dispatchdate);
		return currDate;
	}

	public void dispatchenterspFirstName() {
		try {
			dispatchspFirstName.sendKeys(prop.getProperty("spFirstName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Affiliate Methods:
	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("affiliatEMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("affiliatePwd"));
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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickSigninButton() {
		try {
			signInBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnRides() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(ridesTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
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

	public Boolean verifyNavigationOfAvailableRidesTab(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUser);
			if (availableTab.isDisplayed()) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(availableTab).click().build().perform();
				objTestBase.defaultWaitTime(5000);
				waitTimeForElement(rideDashboardHeader);
				if (rideDashboardHeader.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean searchTripID(Boolean visibilityStatus, String tripID) {
		try {
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(searchTripID));
			if (displayStatus.isDisplayed()) {
				searchTripID.click();
				searchTripID.sendKeys(Keys.CONTROL + "A");
				searchTripID.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(searchTripID).sendKeys(tripID).build().perform();
				objTestBase.defaultWaitTime(3000);
				if (searchTripID.isDisplayed())
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

	public Boolean farmOutTripIDDispatch(Boolean visibilityStatus, String tripID) {
		try {
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			dispatchSearch.click();
			dispatchSearch.sendKeys(tripID);

			objTestBase.defaultWaitTime(3000);
			dispatchTripID.click();
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			objTestBase.defaultWaitTime(2000);

			dispatchFarmout.click();
			objTestBase.defaultWaitTime(1000);
			dispatchCompanyName.click();
			dispatchCompanyName.sendKeys(prop.getProperty("affiliateCName"));
			objTestBase.defaultWaitTime(1000);
			dispatchCompanyName.sendKeys(Keys.ENTER);
			objTestBase.defaultWaitTime(5000);

			if (dispatchFarmoutCheckbox.size() != 0) {
				dispatchFarmoutCheckbox.get(0).click();
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
				if (visibilityStatus == true && msgText.contains("enabled"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
				System.out.println("Farm-out Confirmation Message : " + msgText);
			} else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyClaimRideDetailsPopup(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(claimRide).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			if (yesBtn.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyRideClaimedConfirmationMsg(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(yesBtn.get(0)).click().build().perform();
			objTestBase.defaultWaitTime(500);
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
			if (visibilityStatus == true && msgText.contains("claimed"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
