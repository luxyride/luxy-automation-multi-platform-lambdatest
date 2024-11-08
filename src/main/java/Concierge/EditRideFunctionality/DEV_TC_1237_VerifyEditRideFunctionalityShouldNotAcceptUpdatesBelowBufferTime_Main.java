package Concierge.EditRideFunctionality;

import java.util.Map;
import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.Calendar;
import java.util.TimeZone;
import java.time.Duration;
import java.time.LocalDate;
import java.text.DateFormat;
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

public class DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Main extends TestBase {

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
	int actualTimeHours;
	int actualTimeMinutes;
	int configuredTimeHours;
	Boolean modifyDateFlag = false;

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

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideId;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatus;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTime;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//td[@tabindex='11']")
	WebElement bookedPassengerName;

	@FindBy(xpath = "//td[@tabindex='12']")
	WebElement vehicleType;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement searchUser;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//i[@title='Edit Ride']")
	WebElement editRideBtn;

	@FindBy(xpath = "//span[contains(text(),'Please book a ride at least')]")
	List<WebElement> warningMsg;

	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "(//select[@class='custom-input-text-timepicker-new form-control'])[1]")
	WebElement timeElement;

	@FindBy(xpath = "//button[normalize-space()='Update Ride']")
	WebElement updateBtn;

	LocalDate today;
	TestBase objTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;

	public DEV_TC_1237_VerifyEditRideFunctionalityShouldNotAcceptUpdatesBelowBufferTime_Main(WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
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
		try {
			if (newBookingTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public void addFromAddress(String scenario) {
		try {
			action = new Actions(driver);
			fromAddress.click();
			objTestBase.defaultWaitTime(1000);
			fromAddress.sendKeys(Keys.CONTROL + "A");
			fromAddress.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			if (scenario == "bookRide")
				fromAddress.sendKeys(prop.getProperty("fromAddress"));
			else if (scenario == "editRide")
				fromAddress.sendKeys(prop.getProperty("zoneTypeStateFromAddress"));
			else
				fromAddress.sendKeys(prop.getProperty("zoneTypeStateFromAddress"));

			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addToAddress(String scenario) {
		try {
			action = new Actions(driver);
			toAddress.click();
			objTestBase.defaultWaitTime(1000);
			toAddress.sendKeys(Keys.CONTROL + "A");
			toAddress.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			if (scenario == "bookRide")
				toAddress.sendKeys(prop.getProperty("toAddress"));
			else if (scenario == "editRide")
				toAddress.sendKeys(prop.getProperty("zoneTypeStateToAddressNegative"));
			else
				toAddress.sendKeys(prop.getProperty("zoneTypeStateToAddressPositive"));
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

					//-----------------------------------------------------------------------------------
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
					//-----------------------------------------------------------------------------------
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
			// Select Date of 3 days after based on Current Date:
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

	public void enterFirstName() {
		try {
			action = new Actions(driver);
			firstName.click();
			objTestBase.defaultWaitTime(1000);
			firstName.sendKeys(prop.getProperty("primaryFirstName"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
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
			passengerNotes.click();
			objTestBase.defaultWaitTime(500);
			passengerNotes.sendKeys(Keys.CONTROL + "A");
			passengerNotes.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
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
			if (visibilityStatus == true)
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
				objTestBase.defaultWaitTime(5000);
				action.moveToElement(searchUser).click().sendKeys(prop.getProperty("primaryFirstName")).build()
						.perform();
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
							&& bookedPassengerName.getText().toLowerCase().contains("qa automation")
							&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						tripID = bookingRideTripId.getText().toString();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else
						testStatus = "FAILED";
					utillLogger.info(testStep + " - Capture the Trip ID = " + tripID);
				} else {
					visibilityStatus = false;
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	browserStackTestStatusUpdate("failed", testStep);
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

	public void searchRideId(String tripID) {
		try {
			searchRideId.sendKeys(tripID);
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean validateTripIDDetails(Boolean visibilityStatus) {
		// Get the CurrentDate:
		currDate = getCurrDate(currDate);
		System.out.println(rideStatus.getText().toLowerCase());
		System.out.println(bookedPassengerName.getText().toLowerCase());
		System.out.println(ridePlaceDateTime.getText().toLowerCase());
		if ((!rideStatus.getText().toLowerCase().contains("cancelled")
				|| !rideStatus.getText().toLowerCase().contains("completed"))
				&& bookedPassengerName.getText().toLowerCase().contains("qa automation")
				&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public Boolean verifyRideEDITBtnVisibility(Boolean visibilityStatus) {
		try {
			if (editRideBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
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

	public void clickonEDITRideBtn() {
		try {
			editRideBtn.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean validateEDITRideBookingPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("edit"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void editDate(Boolean todaysFlag, Boolean modifyDateFlag) {
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

			if (todaysFlag == true) {
				String currDate = currMonth + "-" + currDay + "-" + currYear;
				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(currDate);
				cal.setTime(d);

				// Get today's Date:
				String todaysDate;
				if (modifyDateFlag == true)
					todaysDate = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 1);
				else
					todaysDate = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay);
				todaysDate = todaysDate.replaceAll("[a-zA-Z]", "").trim();
				String dayOfMonthXpath = "//span[@class='MuiIconButton-label']//following::p[contains(text(),'"
						+ todaysDate + "')]";
				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			} else {
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
				// Select 3/4 days after based on Current Date:
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
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int enterTimeMinutes(int timeMinutes) {
		try {
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("MM");
			df.setTimeZone(TimeZone.getTimeZone(prop.getProperty("zoneIDState")));

			actualTimeMinutes = Integer.parseInt(df.format(date));
			timeMinutes = actualTimeMinutes + 3;
			System.out.println("Actual Minutes = " + actualTimeHours + " And Configured Minutes = " + timeMinutes);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return timeMinutes;
	}

	public Map<String, Integer> editTime(String scenario, Boolean lessThan24hrs, Map<String, Integer> timeHours) {
		try {
			String conditionTracking = "";
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("HH");
			df.setTimeZone(TimeZone.getTimeZone(prop.getProperty("zoneTypeStateConfigTime")));

			actualTimeHours = Integer.parseInt(df.format(date));
			timeHours.put("ActualTimeHours", actualTimeHours);
			System.out.println("Current Time = " + actualTimeHours);

			if (scenario != "positivescenario") {
				if (scenario == "lessthanBufferTime" && actualTimeHours <= 21) {
					configuredTimeHours = actualTimeHours + 3;
					conditionTracking = "Condition_1";
				} else if (scenario == "lessthanBufferTime" && (22 <= actualTimeHours && actualTimeHours <= 23)) {
					configuredTimeHours = (24 - actualTimeHours)
							- Integer.parseInt(prop.getProperty("zoneTypeStateConfigTime") + 1);

					int result = Integer.signum(configuredTimeHours);
					if (result == -1) {
						System.out.println(Math.abs(configuredTimeHours));
						configuredTimeHours = Math.abs(configuredTimeHours);
					}
					modifyDateFlag = true;
					conditionTracking = "Condition_2";
				} else if (scenario == "greaterthanBufferTime") {
					configuredTimeHours = actualTimeHours + 3;
					conditionTracking = "Condition_3";
					if (configuredTimeHours >= 22) {
						configuredTimeHours = configuredTimeHours - 3;
						modifyDateFlag = true;
						conditionTracking = "Condition_4";
					}
				}
			} else if (!environmentCode.equalsIgnoreCase("prod") && scenario == "positivescenario"
					&& actualTimeHours >= 22) {
				configuredTimeHours = 24
						- (actualTimeHours - Integer.parseInt(prop.getProperty("zoneTypeStateConfigTime")) - 1);
				int result = Integer.signum(configuredTimeHours);
				if (result == -1) {
					System.out.println(Math.abs(configuredTimeHours));
					configuredTimeHours = Math.abs(configuredTimeHours);
				}
				modifyDateFlag = true;
				conditionTracking = "Condition_5";
			} else if (!environmentCode.equalsIgnoreCase("prod") && scenario == "positivescenario"
					&& actualTimeHours < 22) {
				conditionTracking = "Condition_6";
				configuredTimeHours = actualTimeHours + 8;
				if (configuredTimeHours >= 22) {
					configuredTimeHours = configuredTimeHours - 3;
					modifyDateFlag = true;
					conditionTracking = "Condition_7";
				}
			} else if (environmentCode.equalsIgnoreCase("prod") && scenario == "positivescenario"
					&& actualTimeHours >= 22) {
				configuredTimeHours = actualTimeHours + 14;
				configuredTimeHours = configuredTimeHours - 22;
				modifyDateFlag = true;
				conditionTracking = "Condition_8";
			} else if (environmentCode.equalsIgnoreCase("prod") && scenario == "positivescenario"
					&& actualTimeHours < 22) {
				configuredTimeHours = actualTimeHours + 14;
				conditionTracking = "Condition_9";
				if (configuredTimeHours >= 22) {
					configuredTimeHours = configuredTimeHours - 22;
					modifyDateFlag = true;
					conditionTracking = "Condition_10";
				}
			}

			timeHours.put("ConfiguredTimeHours", configuredTimeHours);
			utillLogger.info("DEV_TC_801_VerifyRideBookingWhenZoneTypeAsState_Main - Actual Time in Hours = "
					+ actualTimeHours + " & Configured Time in Hours = " + configuredTimeHours
					+ "Verification of IF-ELSE Condition " + conditionTracking);
			System.out.println("Configured Time = " + configuredTimeHours + "Verification of IF-ELSE Condition "
					+ conditionTracking);

			timeElement.click();
			Select selectTime = new Select(timeElement);
			selectTime.selectByValue(Integer.toString(configuredTimeHours));
			objTestBase.defaultWaitTime(2000);

			if (modifyDateFlag == true) {
				editDate(true, modifyDateFlag);
				utillLogger.info("Modify Date Flag = " + modifyDateFlag);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return timeHours;
	}

	public int editTimeMinutes(int timeMinutes) {
		try {
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("MM");
			df.setTimeZone(TimeZone.getTimeZone(prop.getProperty("zoneIDState")));
			actualTimeMinutes = Integer.parseInt(df.format(date));
			timeMinutes = actualTimeMinutes - 3;
			System.out.println("Actual Minutes = " + actualTimeHours + " And Configured Minutes = " + timeMinutes);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return timeMinutes;
	}

	public Boolean verifyVisibilityOfWarningMsg(String scenario, Boolean visibilityStatus) {
		try {
			if (scenario == "negativeFlow") {
				if (warningMsg.size() != 0) {
					waitTimeForElement(warningMsg.get(0));
					if (warningMsg.get(0).getText().toLowerCase().contains("12")
							&& warningMsg.get(0).getText().toLowerCase().contains("100"))
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else {
					visibilityStatus = false;
				}
			} else if (scenario == "positiveFlow" && warningMsg.size() == 0) {
				visibilityStatus = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnCancel() {
		try {
			action = new Actions(driver);
			action.moveToElement(cancelBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnUpdateBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(updateBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideEDITConfirmation(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

			if (displayStatus.isDisplayed() && alertMessge.getText().toString().toLowerCase().contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

}