package Concierge.NewBookings;

import java.util.Set;
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

public class DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Main
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
	LocalDate today;
	TestBase objTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;
	String currURL;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn_Login;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "(//span[text() = 'New Booking'])[1]")
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

	@FindBy(xpath = "(//select[@name='age'])[1]")
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "//input[@placeholder='Flight Number']")
	WebElement flightNumber;

	@FindBy(xpath = "//textarea[@name='passengerNotes']")
	WebElement passengerNotes;

	@FindBy(xpath = "//input[@placeholder='Cardholder Name']")
	WebElement cardHolderName;

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

	@FindBy(xpath = "(//span[text() = 'Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "(//span[text() = 'All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatus;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTime;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//td[@tabindex='11']")
	WebElement bookedPassengerName;

	@FindBy(xpath = "//td[@tabindex='13']")
	WebElement vehicleType;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtnUserPortal;

	@FindBy(xpath = "//*[text()='New LUXY Customer Account']")
	WebElement verifyNewCustomerAccountEmail;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Confirm Account']")
	WebElement confirmEmailAccountEMail;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtnEMail;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement searchUser;

	@FindBy(xpath = "//input[@name='passengerFirstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='passengerLastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='passengerMobileNumber']")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@name='passengerEmail']")
	WebElement passengerEMail;

	@FindBy(xpath = "//div[@id='clearbut']//a")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Confirm Account']")
	WebElement confirmEmailAccount;

	@FindBy(xpath = "//*[@type='password']")
	WebElement password;

	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@id='email'][1]")
	WebElement eMailInputUserPortal;

	@FindBy(xpath = "//input[@id='password'][1]")
	WebElement reloginPwd;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement loggedInDrpdwn;

	@FindBy(xpath = "//button[normalize-space()='Confirm Luxy Account']")
	WebElement confirmAccount;

	@FindBy(xpath = "//input[@type='text']")
	WebElement dispatcheMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement dispatchpasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchsignInBtn;

	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement dispatchpassengersTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchSearchPassenger;

	@FindBy(xpath = "//i[@title='Delete Passenger']")
	WebElement dispatchDeletePassenger;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement dispatchYesBtn;

	@FindBy(xpath = "//*[text()='There is no data to display']")
	WebElement dispatchNoPassengerMsg;

	@FindBy(xpath = "//a[starts-with(normalize-space(),'Welcome')]")
	WebElement loggedInDropdown;

	@FindBy(xpath = "//a[normalize-space()='Notification Preferences']")
	WebElement clickOnNotificationBtn;

	@FindBy(xpath = "//button[normalize-space()='SUBMIT']")
	WebElement changePwdSubmitBtn;

	@FindBy(xpath = "//input[@id='allow_all']")
	WebElement allowAll;

	@FindBy(xpath = "//input[@id='allow_all']//following-sibling::label")
	WebElement allowAllBtn;

	@FindBy(xpath = "//i[@title='close']")
	WebElement closeWindow;

	@FindBy(xpath = "(//input[@name='tripPricesEmail'])[1]")
	WebElement eMailcheckbox1;
	@FindBy(xpath = "(//input[@name='tripPricesEmail'])[2]")
	WebElement eMailcheckbox2;
	@FindBy(xpath = "(//input[@name='tripPricesEmail'])[3]")
	WebElement eMailcheckbox3;
	@FindBy(xpath = "(//input[@name='tripPricesEmail'])[4]")
	WebElement eMailcheckbox4;

	@FindBy(xpath = "(//input[@name='tripPricesSms'])[1]")
	WebElement smscheckbox1;
	@FindBy(xpath = "(//input[@name='tripPricesSms'])[2]")
	WebElement smscheckbox2;
	@FindBy(xpath = "(//input[@name='tripPricesSms'])[3]")
	WebElement smscheckbox3;

	public DEV_TC_1314_VerifyAvailabilityFunctionalityOfNotificationsSettingsWhenPassengerCreatedThroughConciergeWhileCreatingRide_Main(
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
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInputUserPortal() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
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
		if (newBookingTab.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickNewBooking() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newBookingTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public String captureRideBookingIDs(Boolean visibilityStatus, String scenario, String tripID, String newEMail) {
		try {
			action = new Actions(driver);
			ridesTabAll.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(5000);
				action.moveToElement(searchUser).click().sendKeys(newEMail).build().perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripId.isDisplayed()
						&& !rideBookingIdsConcierge.containsValue(bookingRideTripId.getText())) {
					System.out.println(rideStatus.getText().toLowerCase());
					System.out.println(bookedPassengerName.getText().toLowerCase());
					System.out.println(ridePlaceDateTime.getText().toLowerCase());
					System.out.println(bookingRideTripId.getText());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatus.getText().toLowerCase().contains("cancelled")
							|| !rideStatus.getText().toLowerCase().contains("completed"))
							&& bookedPassengerName.getText().toLowerCase().contains("test user")
							&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						rideBookingIdsConcierge.put(vehicleType.getText().toLowerCase(),
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

	public void enterPassengerDetails() {
		try {
			action = new Actions(driver);
			firstName.click();
			objTestBase.defaultWaitTime(500);
			firstName.sendKeys("Test User");
			objTestBase.defaultWaitTime(1000);
			lastName.click();
			objTestBase.defaultWaitTime(500);
			lastName.sendKeys("Automation");
			objTestBase.defaultWaitTime(1000);
			mobileNumber.click();
			objTestBase.defaultWaitTime(500);
			mobileNumber.sendKeys(prop.getProperty("updatedMobileNumber"));
			objTestBase.defaultWaitTime(3000);
			passengerEMail.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String enterNewEmailID(String newEMail) {
		try {
			action = new Actions(driver);
			passengerEMail.click();
			objTestBase.defaultWaitTime(1000);
			passengerEMail.sendKeys(Keys.CONTROL + "A");
			passengerEMail.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			// Generate New EMailID:
			newEMail = eMailInput(newEMail);
			passengerEMail.sendKeys(newEMail);
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newEMail;
	}

	public String eMailInput(String newEMail) {
		try {
			action = new Actions(driver);
			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);
			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			newEMail = prop.getProperty("newEmail") + currDateTime + prop.getProperty("eMailDomain");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return newEMail;
	}

	// EMail Validations:
	public void clearButton() {
		try {
			if (clearBtnEMail.get(0).isDisplayed()) {
				waitTimeForElement(clearBtnEMail.get(0));
				clearBtnEMail.get(0).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String emailIDSerach(String newEMail) {
		try {
			System.out.println("Regression Email = " + newEMail);
			action = new Actions(driver);
			String[] tempEmail = newEMail.toString().split("@");
			loginBtnUserPortal.sendKeys(tempEmail[0]);
			action.sendKeys(Keys.ENTER).build().perform();
			driver.navigate().refresh();
			defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newEMail;
	}

	public Boolean verifyyopeMail(Boolean visibilityStatus) {
		expected = driver.getCurrentUrl();
		if (expected.toLowerCase().contains("yopmail"))
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void confirmEmailAccount() {
		try {
			driver.switchTo().frame("ifinbox");
			verifyNewCustomerAccountEmail.click();
			objTestBase.defaultWaitTime(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifmail");
			objTestBase.defaultWaitTime(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", confirmAccount);
			objTestBase.defaultWaitTime(2000);
			confirmEmailAccountEMail.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyConfirmAccountPassword(Boolean visibilityStatus) {
		Set<String> listOfWindows = driver.getWindowHandles();
		int i = 0;
		for (String currWindow : listOfWindows) {
			if (i == 1) {
				driver.switchTo().window(currWindow);
				try {
					defaultWaitTime(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				currURL = driver.getCurrentUrl();
				if (currURL.toLowerCase().contains(prop.getProperty("environment")))
					visibilityStatus = updateuaturlWithAuth(visibilityStatus, currURL);
			}
			i++;
		}
		objTestBase.closePopupWindow();
		return visibilityStatus;
	}

	public Boolean updateuaturlWithAuth(Boolean visibilityStatus, String currURL) {
		try {
			currURL = currURL.replace("uat", "uat");
			System.out.println(currURL);
			driver.get(currURL);
			objTestBase.defaultWaitTime(3000);
			if (confirmAccount.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			action.moveToElement(password).click().sendKeys(prop.getProperty("regPwd")).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void login() throws InterruptedException {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
			Thread.sleep(1000);
			if (customerLogin.isDisplayed())
				action.moveToElement(customerLogin).click().build().perform();
			Thread.sleep(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			Thread.sleep(1000);
		}
	}

	public String enterEmail(String newEMail) {
		action = new Actions(driver);
		eMailInputUserPortal.sendKeys(newEMail);
		action.sendKeys(Keys.TAB).build().perform();
		return newEMail;
	}

	public void passwordRelogin() {
		action = new Actions(driver);
		password.sendKeys(prop.getProperty("regPwd"));
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public Boolean loggedInDrpdwn(Boolean visibilityStatus) {
		try {
			if (loggedInDrpdwn.isDisplayed()) {
				waitTimeForElement(loggedInDrpdwn);
				String tempText = loggedInDrpdwn.getText();
				if (tempText.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void confirmAccount() {
		try {
			confirmAccount.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean deleteCreatedUserfromDispatch(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			driver.get(prop.getProperty("dispatchURL"));
			objTestBase.defaultWaitTime(3000);
			dispatcheMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			objTestBase.defaultWaitTime(500);
			action.sendKeys(Keys.TAB).build().perform();
			dispatchpasswordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
			objTestBase.defaultWaitTime(500);

			try {
				dispatchsignInBtn.click();
				// Validate Dispatch 2fa Authentication:
				Boolean visibilityStatus1 = false;
				visibilityStatus = validateDispatchBypassCode(visibilityStatus);
				utillLogger.info(
						"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			objTestBase.defaultWaitTime(3000);
			dispatchpassengersTab.click();
			objTestBase.defaultWaitTime(8000);
			action.moveToElement(dispatchSearchPassenger).click().sendKeys(eMail).build().perform();
			objTestBase.defaultWaitTime(5000);
			action.sendKeys(Keys.ENTER).build().perform();
			action.moveToElement(dispatchDeletePassenger).click().build().perform();
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(dispatchYesBtn).click().build().perform();
			objTestBase.defaultWaitTime(5000);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(dispatchSearchPassenger).click().sendKeys(eMail).build().perform();
			objTestBase.defaultWaitTime(2000);
			if (dispatchNoPassengerMsg.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	// Notification Preferences:
	public void clickLogginUserDrpdown() {
		try {
			action = new Actions(driver);
			action.moveToElement(loggedInDropdown).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
			;
		}
	}

	public void clickonNotificationDrpdwn() {
		action = new Actions(driver);
		action.moveToElement(clickOnNotificationBtn).click().build().perform();
	}

	public void verifyEmailCheckboxmarked() {
		changePwdSubmitBtn.click();
	}

	public Boolean clickonallowAll(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (!allowAll.isSelected())
				action.moveToElement(allowAll).click().build().perform();

			action.sendKeys(Keys.TAB).build().perform();
			visibilityStatus = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void closeWindow() {
		closeWindow.click();
	}

	public Boolean clickOnEmailCheckboxes(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(eMailcheckbox1).click().build().perform();
			action.moveToElement(eMailcheckbox2).click().build().perform();
			action.moveToElement(eMailcheckbox3).click().build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			visibilityStatus = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean clickOnSMSCheckboxes(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(smscheckbox1).click().build().perform();
			defaultWaitTime(500);
			action.moveToElement(smscheckbox2).click().build().perform();
			defaultWaitTime(500);
			action.moveToElement(smscheckbox3).click().build().perform();
			defaultWaitTime(500);
			action.sendKeys(Keys.TAB).build().perform();
			defaultWaitTime(500);
			visibilityStatus = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
