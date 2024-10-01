package TravelAgent.NewBooking;

import common.GetCurrentDateTime;
import common.TestBase;
import common.UpdateExtentReportResults;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1906_VerifyNewBookingFunctionalityWithPayPalPayUnderAvailaiblePaymentMethodsForTravelAgentPortal_Main
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

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "//*[@placeholder='Search Passenger']")
	WebElement searchPassenger;

	@FindBy(xpath = "//*[@placeholder='Pickup Address']")
	WebElement fromAddress;

	@FindBy(xpath = "//*[@placeholder='Drop Off Address']")
	WebElement toAddress;

	@FindBy(xpath = "//*[normalize-space()='Add Stops']")
	WebElement extraStopIcon;

	@FindBy(xpath = "//*[@placeholder='Stop 1']")
	WebElement addextraStop;

	@FindBy(xpath = "//*[@class='MuiIconButton-label']//div")
	WebElement calendar;

	@FindBy(xpath = "//*[@id='date-picker-inline']")
	WebElement dateInput;

	@FindBy(xpath = "//*[normalize-space()='Get Quote']")
	WebElement getQuote;

	@FindBy(xpath = "//*[normalize-space()='Choose Vehicle']//following-sibling::div")
	List<WebElement> vechileAvailableSection;

	@FindBy(xpath = "//*[(@title='Sedan') and normalize-space()='Sedan']")
	WebElement bookSedan;

	@FindBy(xpath = "(//*[@name='age'])[1]")
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "//*[@placeholder='Flight Number']")
	WebElement flightNumber;

	@FindBy(xpath = "//*[@name='passengerNotes']")
	WebElement passengerNotes;

	@FindBy(xpath = "//*[@placeholder='Cardholder Name']")
	WebElement cardHolderName;

	@FindBy(xpath = "//*[@name='credit-card-number']")
	WebElement cardHolderNumber;

	@FindBy(xpath = "//*[@name='expiration']")
	WebElement cardExpiryDate;

	@FindBy(xpath = "//*[@id='cvv']")
	WebElement cvv;

	@FindBy(xpath = "//*[@id='postal-code']")
	WebElement postalCode;

	@FindBy(xpath = "//span[normalize-space()='Confirm Booking']")
	WebElement confirmBookingBtn;

	@FindBy(xpath = "(//*[text() = 'Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "(//*[text() = 'All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span)[1]")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//*[(@role='alert')]")
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
	WebElement loginBtn;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//*[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "(//*[@type='text'])[4]")
	WebElement searchUser;

	@FindBy(xpath = "//*[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//div[@aria-label='Paying with Card']")
	WebElement cardOption;

	@FindBy(xpath = "//div[@aria-label='Paying with Google Pay']")
	WebElement gpayOption;

	@FindBy(xpath = "//div[@aria-label='Paying with PayPal']")
	WebElement paypalOption;

	@FindBy(xpath = "//div[@aria-label='Paying with Venmo']")
	WebElement venmoOption;

	// pay pal creds ;
	@FindBy(xpath = "//div[@aria-label='Paying with PayPal']")
	WebElement payingWithPayPalPayOption;

	@FindBy(xpath = "//div[@aria-label='PayPal Checkout']")
	WebElement payPalPayOption;

	@FindBy(xpath = "//input[@type='email']")
	WebElement paypalEmail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement paypalPswd;

	@FindBy(xpath = "//button[normalize-space()='Log In']")
	List<WebElement> paypalSignInBtn;
	
	@FindBy(xpath = "//div[normalize-space()='Continue to Review Order']")
	List<WebElement> continueReviewOrder;

	@FindBy(xpath = "//button//span[normalize-space()='Continue']")
	WebElement continueButton;

	// Gmail Elements
	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	List<WebElement> gMailSignInBtn;

	@FindBy(xpath = "//input[@type='email']")
	WebElement gMailEMail;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	WebElement nextButton;

	@FindBy(xpath = "//input[@type='password']")
	WebElement gMailPassword;

	@FindBy(xpath = "//a[normalize-space()='Inbox']")
	List<WebElement> gMailSignedInConfirmationInboxLable;

	LocalDate today;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;

	TestBase objTestBase;

	public DEV_TC_1906_VerifyNewBookingFunctionalityWithPayPalPayUnderAvailaiblePaymentMethodsForTravelAgentPortal_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("travelAgentEMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("travelAgentPwd"));
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
			if (signInBtn.isDisplayed())
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
			signInBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBooking() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbooking).click().build().perform();
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

	public Boolean searchPassenger(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(searchPassenger).click().sendKeys(prop.getProperty("taPassengerEMail")).build()
					.perform();
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);

			expected = searchPassenger.getAttribute("value"); // searchPassenger
			if (expected.toLowerCase().contains("automation"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilitOfNewBookingTab(Boolean visibilityStatus) {
		try {
			if (newbooking.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public String captureRideBookingIDs(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			action = new Actions(driver);
			ridesTabAll.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(5000);
				action.moveToElement(searchUser).click().sendKeys(prop.getProperty("taPassengerEMail")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripId.isDisplayed()
						&& !rideBookingIdsTravelAgent.containsValue(bookingRideTripId.getText())) {
					System.out.println(rideStatus.getText().toLowerCase());
					System.out.println(bookedPassengerName.getText().toLowerCase());
					System.out.println(ridePlaceDateTime.getText().toLowerCase());
					System.out.println(bookingRideTripId.getText());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatus.getText().toLowerCase().contains("cancelled")
							|| !rideStatus.getText().toLowerCase().contains("completed"))
							&& bookedPassengerName.getText().toLowerCase().contains("automation")
							&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						rideBookingIdsConcierge.put(vehicleType.getText().toLowerCase(),
								bookingRideTripId.getText().toString());
						objTestBase.defaultWaitTime(500);
						tripID = bookingRideTripId.getText().toString();
						objTestBase.defaultWaitTime(1000);
					}
					utillLogger.info(
							"DEV_TC_1152_VerifyNewBookingFunctionalityInTravelAgentSite_Main - Capture the Trip ID = "
									+ tripID);
					visibilityStatus = true;
				} else
					visibilityStatus = false;
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return currDate;
	}

	public void enterFirstName() {
		try {
			action = new Actions(driver);
			firstName.click();
			objTestBase.defaultWaitTime(1000);
			firstName.sendKeys(prop.getProperty("taPassengerEMail"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfPaymentOptions(Boolean visibilityStatus) {
		try {
			if (cardOption.isDisplayed() && gpayOption.isDisplayed() && paypalOption.isDisplayed()
					&& venmoOption.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public Boolean verifyGMailAccountLogin(Boolean visibilityStatus) {
		try {
			driver.get(prop.getProperty("gMailURL"));
			driver.manage().window().maximize();
			defaultWaitTime(6000);

			if (gMailSignInBtn.size() != 0) {
				gMailSignInBtn.get(0).click();
				defaultWaitTime(6000);
			}

			gMailEMail.sendKeys(prop.getProperty("gMailEMailID"));
			defaultWaitTime(2000);
			nextButton.click();
			defaultWaitTime(2000);
			gMailPassword.sendKeys(prop.getProperty("gMailPassword"));
			defaultWaitTime(2000);
			nextButton.click();
			defaultWaitTime(12000);

			if (gMailSignedInConfirmationInboxLable.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyPayPalPayOptionVisibility(Boolean visibilityStatus) {
		try {
			if (payingWithPayPalPayOption.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnpayingWithPayPalPayOption() {
		try {
			payingWithPayPalPayOption.click();
			defaultWaitTime(10000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='PayPal']")));
			defaultWaitTime(1000);
			payingWithPayPalPayOption.click();
			defaultWaitTime(12000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyPayPalLoginBtnVisibility(String parentWindow, Boolean visibilityStatus) {
		try {
			Set<String> listOfWindows = driver.getWindowHandles();
			System.out.println(listOfWindows.size());
			Iterator<String> windowsIterator = listOfWindows.iterator();
			while (windowsIterator.hasNext()) {
				String child_window = windowsIterator.next();
				System.out.println(child_window);
				if (!parentWindow.equals(child_window)) {
					driver.switchTo().window(child_window);
					if (nextButton.isDisplayed())
						visibilityStatus = true;
					else
						visibilityStatus = false;
					visibilityStatus = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void enterLoginDetails() {
		try {
			action = new Actions(driver);
			paypalEmail.sendKeys(prop.getProperty("paypalEmail"));
			defaultWaitTime(1000);
			paypalPswd.sendKeys(prop.getProperty("paypalPassword"));
			defaultWaitTime(2000);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnContinueButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmBookingBtn).click().build().perform();
			defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean verifyPayPalLoginAccountOptionDisplayed(Boolean visibilityStatus) {
		try {
			if (paypalSignInBtn.size() != 0) {
				paypalSignInBtn.get(0).click();
				defaultWaitTime(10000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyPayPalContinueReviewOrderDisplayed(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			objTestBase.defaultWaitTime(1000);
			if (continueReviewOrder.size() != 0) {
				continueReviewOrder.get(0).click();
				defaultWaitTime(10000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
	

}
