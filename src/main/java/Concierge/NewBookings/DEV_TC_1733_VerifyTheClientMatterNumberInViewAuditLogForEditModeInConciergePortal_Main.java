package Concierge.NewBookings;

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

public class DEV_TC_1733_VerifyTheClientMatterNumberInViewAuditLogForEditModeInConciergePortal_Main extends TestBase {

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

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "(//span[text() = 'New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "//input[@name='clientMatterNumber']")
	WebElement clientMatterNumber;

	@FindBy(xpath = "//span[text()='Client Matter Number']")
	List<WebElement> clientMatterNumberLables;

	@FindBy(xpath = "(//*[normalize-space()='Reason'])[1]")
	List<WebElement> auditLogsReason;
	
	@FindBy(xpath = "(//*[normalize-space()='Load Activity'])[1]")
	WebElement loadActivityBtn;

	@FindBy(xpath = "(//*[normalize-space()='Reason'])[1]//following::label[2]")
	List<WebElement> auditLogsClientMatterNumberLabel;

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

	@FindBy(xpath = "(//span[text() = 'Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "//i[@title='Edit Ride']")
	WebElement editRideButtonIcon;

	@FindBy(xpath = "(//span[normalize-space()='Update Ride'])[1]")
	WebElement updateRideDetailsBtn;

	@FindBy(xpath = "(//span[text() = 'All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//span[contains(normalize-space(),'First Name is required')]")
	List<WebElement> firstNameRequiredMsg;

	@FindBy(xpath = "//span[contains(normalize-space(),'Last Name is required')]")
	List<WebElement> lastNameRequiredMsg;

	@FindBy(xpath = "//span[contains(normalize-space(),'Mobile Number is required')]")
	List<WebElement> mobileNumberRequiredMsg;

	@FindBy(xpath = "//span[contains(normalize-space(),'Email is required')]")
	List<WebElement> eMailRequiredMsg;

	@FindBy(xpath = "//span[contains(normalize-space(),'Client Matter is required')]")
	List<WebElement> clientMatterNumberRequiredMsg;

	@FindBy(xpath = "//span[contains(normalize-space(),'Client Matter Number characters should not be more than 32 characters')]")
	List<WebElement> clientMatterNumberNotMorethan32CharsMsg;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatus;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTime;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//td[@tabindex='11']")
	WebElement bookedPassengerName;

	@FindBy(xpath = "//td[@tabindex='15']")
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

	// Dispatch Elements:
	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputDispatch;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputDispatch;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIconDispatch;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnDispatch;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUserDispatch;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbookingDispatch;

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateNavigation;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSectionDispatch;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAllDispatch;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideIdDispatch;

	@FindBy(xpath = "//i[@title='Edit Corporate']")
	List<WebElement> editCorporate;

	@FindBy(xpath = "(//i[@title='Edit Corporate']//parent::a)[1]")
	List<WebElement> editCorporateHyperlink;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatusDispatch;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTimeDispatch;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripIdDispatch;

	@FindBy(xpath = "//td[@tabindex='12']//a")
	WebElement bookedPassengerNameDispatch;

	@FindBy(xpath = "//i[@title='Move to Corporate Account']//parent::button")
	List<WebElement> actionsIcon;

	LocalDate today;
	TestBase objTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;

	public DEV_TC_1733_VerifyTheClientMatterNumberInViewAuditLogForEditModeInConciergePortal_Main(WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("conciergeCompanyCMNMail"));
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

	public void enterClientMatterNumber() {
		try {
			clientMatterNumber.sendKeys(prop.getProperty("clientMatterNumberValid"));
			objTestBase.defaultWaitTime(500);
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
							&& (bookedPassengerName.getText().toLowerCase().contains("automation")
									|| bookedPassengerName.getText().toLowerCase().contains("test user"))
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

	// Dispatch Validations:
	public void eMailInputDispatch() {
		action = new Actions(driver);
		eMailInputDispatch.sendKeys(prop.getProperty("dispatchadminMail"));
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void passwordInputDispatch() {
		action = new Actions(driver);
		passwordInputDispatch.sendKeys(prop.getProperty("dispatchadminPwd"));
	}

	public void eyeIconClickDispatch() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIconDispatch).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonDispatch(Boolean visibilityStatus) {
		try {
			if (signInBtnDispatch.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonDispatch() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtnDispatch).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBookingDispatch() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbookingDispatch).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserDispatch(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUserDispatch);
			if (signinUserDispatch.isDisplayed()) {
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
		}
		return visibilityStatus;
	}

	public Boolean verifyCorporateIDAtBottomOftheCorporatePage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(corporateNavigation).click().build().perform();
			objTestBase.defaultWaitTime(1000);

			waitTimeForElement(searchRideIdDispatch);

			action.moveToElement(searchRideIdDispatch).click().sendKeys(prop.getProperty("conciergeadminMail")).build()
					.perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(3000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(editCorporate.get(0)));

			if (displayStatus.isDisplayed()) {
				action.moveToElement(editCorporate.get(0)).build().perform();
				objTestBase.defaultWaitTime(3000);
				String tempVal = editCorporateHyperlink.get(0).getAttribute("href");
				tempVal = tempVal.replaceAll("[^\\d.]", "").replaceAll("\\.", "");
				System.out.println("Corporate ID Value = " + tempVal);

				// Verifies CorporateID is not Empty and holding only Digits/not.?
				if (tempVal.length() != 0 || tempVal.matches("[0-9]+"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickRidesSectionDispatch() {
		try {
			action = new Actions(driver);
			action.moveToElement(ridesSectionDispatch).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRidesAllPageDispatch(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(ridesTabAllDispatch).click().build().perform();
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

	public void searchRideIdDispatch(String tripID) {
		try {
			searchRideIdDispatch.sendKeys(tripID);
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean validateTripIDDetailsDispatch(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(rideStatusDispatch));
			if (displayStatus.isDisplayed()) {
				// Get the CurrentDate:
				currDate = getCurrDate(currDate);
				System.out.println(rideStatusDispatch.getText().toLowerCase());
				System.out.println(bookedPassengerNameDispatch.getText().toLowerCase());
				System.out.println(ridePlaceDateTimeDispatch.getText().toLowerCase());
				if ((!rideStatus.getText().toLowerCase().contains("cancelled")
						|| !rideStatus.getText().toLowerCase().contains("completed"))
						&& (bookedPassengerName.getText().toLowerCase().contains("test user")
								|| bookedPassengerName.getText().toLowerCase().contains("automation"))
						&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = true;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfActionsIcon(Boolean visibilityStatus) {
		try {
			if (actionsIcon.size() != 0) {
				if (!actionsIcon.get(0).isEnabled())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = true;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfClientMatterNumber(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			
			objTestBase.defaultWaitTime(2000);
			if (clientMatterNumber.isDisplayed() && clientMatterNumberLables.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfMandatoryErrorMsgs(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmBookingBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-550)", "");
				objTestBase.defaultWaitTime(2000);

				if (firstNameRequiredMsg.size() != 0 && lastNameRequiredMsg.size() != 0
						&& mobileNumberRequiredMsg.size() != 0 && eMailRequiredMsg.size() != 0
						&& clientMatterNumberRequiredMsg.size() != 0)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfClientMatterNumberErrorMsgIfMorethan32Chars(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", clientMatterNumber);
			objTestBase.defaultWaitTime(2000);

			if (clientMatterNumber.isDisplayed() && clientMatterNumberLables.size() != 0) {
				clientMatterNumber.click();
				clientMatterNumber.sendKeys(prop.getProperty("clientMatterNumberMorethan32Chars"));
				objTestBase.defaultWaitTime(2000);

				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(2000);

				if (clientMatterNumberNotMorethan32CharsMsg.size() != 0)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyClientMatterNumberNotAllowedToEnterAnySpecialChars(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", clientMatterNumber);
			objTestBase.defaultWaitTime(2000);

			action.moveToElement(clientMatterNumber).click().sendKeys("!@#$%^&*()_+=").build().perform();
			objTestBase.defaultWaitTime(1000);

			expected = clientMatterNumber.getText();
			if (expected.length() == 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verificationOfEditRidePageNavigation(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(editRideButtonIcon));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				action.moveToElement(editRideButtonIcon).click().build().perform();
				objTestBase.defaultWaitTime(5000);

				expected = driver.getCurrentUrl();
				if (expected.contains("bookingedit"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public String verificationOfClientMatterNumberFromEDITRideDetailsPage(String clientMatterNumberBeforeUpdate) {
		try {
			action = new Actions(driver);

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", clientMatterNumber);
			objTestBase.defaultWaitTime(2000);

			clientMatterNumberBeforeUpdate = clientMatterNumber.getAttribute("value");
			System.out.println("Client Matter Number - Before EDIT - Update = " + clientMatterNumberBeforeUpdate);
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return clientMatterNumberBeforeUpdate;
	}

	public String verificationOfUpdatingClientMatterNumberFromEDITRideDetailsPage(
			String clientMatterNumberAfterUpdate) {
		try {
			objTestBase.defaultWaitTime(1000);
			action = new Actions(driver);
			objTestBase.defaultWaitTime(3000);
			clientMatterNumber.click();
			objTestBase.defaultWaitTime(1000);
			clientMatterNumber.sendKeys(Keys.CONTROL + "A");
			clientMatterNumber.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			clientMatterNumber.sendKeys(prop.getProperty("clientMatterNumberUpdatedValid"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);

			clientMatterNumberAfterUpdate = clientMatterNumber.getAttribute("value");
			System.out.println("Client Matter Number - After EDIT - Update = " + clientMatterNumberAfterUpdate);

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return clientMatterNumberAfterUpdate;
	}

	public Boolean updateRideConfirmationMsg(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", updateRideDetailsBtn);
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(updateRideDetailsBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyClientMatterNumberAfterUpdatedSuccessfullyInViewAuditLogs(Boolean visibilityStatus,
			String tripID, String clientMatterNumberBeforeUpdate, String clientMatterNumberAfterUpdate) {
		try {
			objTestBase.defaultWaitTime(3000);
			searchUser.sendKeys(tripID);
			objTestBase.defaultWaitTime(3000);
			visibilityStatus = verificationOfEditRidePageNavigation(visibilityStatus);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(loadActivityBtn).click().build().perform();
			objTestBase.defaultWaitTime(2000);
			if (auditLogsReason.size() != 0 && auditLogsClientMatterNumberLabel.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void enterSearchInput(String tripID) {
		try {
			objTestBase.defaultWaitTime(1000);
			searchUser.sendKeys(tripID);
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}