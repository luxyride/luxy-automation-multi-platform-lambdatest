package TravelAgent.NewBooking;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1229_VerifyRideBookedThroughTAListedintheDispatchSiteUnderRidesALLTab_Main extends TestBase {

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
	List<WebElement> eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideId;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//input[@id='outlined-with-placeholder'])[1]")
	WebElement searchCorporate;

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

	@FindBy(xpath = "//div[@aria-label='Paying with Card']")
	WebElement cardOptions;
	
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
	WebElement rideStatusTA;

	@FindBy(xpath = "//td[@tabindex='5']")
	WebElement ridePlaceDateTimeTA;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement bookingRideTripIdTA;

	@FindBy(xpath = "//td[@tabindex='11']")
	WebElement bookedPassengerNameTA;

	@FindBy(xpath = "//td[@tabindex='13']")
	WebElement vehicleTypeTA;

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

	@FindBy(xpath = "//input[@name='isConcierge']")
	WebElement toggleBtn;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateBtn;

	@FindBy(xpath = "(//i[@title='Corporate Profile'])[1]")
	WebElement profileBtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchInput;

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[1]")
	WebElement taBtn;

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[2]")
	WebElement subTaBtn;

	@FindBy(xpath = "(//i[@title='Travel Arranger Profile'])[1]")
	WebElement profile;

	@FindBy(xpath = "//div[@class='react-bs-container-body']")
	WebElement rideDetails;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatusDispatch;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTimeDispatch;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripIdDispatch;

	@FindBy(xpath = "//td[@tabindex='12']//a")
	WebElement bookedPassengerNameDispatch;

	@FindBy(xpath = "//td[@tabindex='15']")
	WebElement vehicleTypeDispatch;

	LocalDate today;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;

	TestBase objTestBase;

	public DEV_TC_1229_VerifyRideBookedThroughTAListedintheDispatchSiteUnderRidesALLTab_Main(WebDriver driver) {
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
			eMailInput.get(0).sendKeys(prop.getProperty("travelAgentEMail"));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchclickSigninButton() {
		try {
			signInBtn.click();
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			e.printStackTrace();
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

	public Boolean searchCorporate(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(searchCorporate).click().sendKeys(prop.getProperty("taCorporateEMail")).build()
					.perform();
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);

			expected = searchCorporate.getAttribute("value"); // searchPassenger
			if (expected.toLowerCase().contains("automation"))
				visibilityStatus = false;
			else
				visibilityStatus = true;
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

	public Boolean visibilityOfRidesAllPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(ridesTabAll).click().build().perform();
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
			searchRideId.sendKeys(tripID);
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public String captureRideBookingIDsFromTA(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			action = new Actions(driver);
			ridesTabAll.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(5000);
				action.moveToElement(searchUser).click().sendKeys(prop.getProperty("travelagentPassengerName")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripIdTA.isDisplayed()) {
					System.out.println(rideStatusTA.getText().toLowerCase());
					System.out.println(bookedPassengerNameTA.getText().toLowerCase());
					System.out.println(ridePlaceDateTimeTA.getText().toLowerCase());
					System.out.println(bookingRideTripIdTA.getText());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatusTA.getText().toLowerCase().contains("cancelled")
							|| !rideStatusTA.getText().toLowerCase().contains("completed"))
							&& bookedPassengerNameTA.getText().toLowerCase().contains("automation")
							&& ridePlaceDateTimeTA.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						tripID = bookingRideTripIdTA.getText().toString();
						objTestBase.defaultWaitTime(1000);
					}
					utillLogger.info(
							"DEV_TC_1229_VerifyRideBookedThroughTAListedintheDispatchSiteUnderRidesALLTab_Main - Capture the Trip ID = "
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currDate;
	}

	public void enterFirstName() {
		try {
			action = new Actions(driver);
			firstName.click();
			objTestBase.defaultWaitTime(1000);
			firstName.sendKeys(prop.getProperty("travelagentPassengerName"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispatchEMailInput() {
		try {
			action = new Actions(driver);
			visibilityStatus = waitToPageLoadElementsFluentWait(visibilityStatus, eMailInput);
			if (visibilityStatus.booleanValue() == true) {
				action = new Actions(driver);
				eMailInput.get(0).sendKeys(prop.getProperty("dispatchadminMail"));
				action.sendKeys(Keys.TAB).build().perform();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dispatchPasswordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean validateTripIDDetails(Boolean visibilityStatus) {
		// Get the CurrentDate:
		currDate = getCurrDate(currDate);
		System.out.println(rideStatusDispatch.getText().toLowerCase());
		System.out.println(bookedPassengerNameDispatch.getText().toLowerCase());
		System.out.println(ridePlaceDateTimeDispatch.getText().toLowerCase());
		System.out.println(bookingRideTripIdDispatch.getText());
		if ((!rideStatusDispatch.getText().toLowerCase().contains("cancelled")
				|| !rideStatusDispatch.getText().toLowerCase().contains("completed"))
				&& bookedPassengerNameDispatch.getText().toLowerCase().contains("automation")
				&& ridePlaceDateTimeDispatch.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void selectToggle() {
		try {
			action = new Actions(driver);
			action.moveToElement(toggleBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnYes() {
		try {
			action = new Actions(driver);
			action.moveToElement(yesBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonCorporateTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(corporateBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterSearchField() {
		try {
			action = new Actions(driver);
			searchInput.sendKeys(prop.getProperty("travelAgentCName"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnProfileBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(profileBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfProfilePage(Boolean visibilityStatus2) {
		if (searchInput.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void enterSearch(String tripID) {
		try {
			action = new Actions(driver);
			searchInput.sendKeys(tripID);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void clickonTATab() {
		try {
			action = new Actions(driver);
			action.moveToElement(taBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonSubTATab() {
		try {
			action = new Actions(driver);
			action.moveToElement(subTaBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnProfile() {
		try {
			action = new Actions(driver);
			action.moveToElement(profile).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterSearchFieldTa() {
		try {
			action = new Actions(driver);
			searchInput.sendKeys(prop.getProperty("travelAgentEMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRideDetails(Boolean visibilityStatus) {
		try {
			if (rideDetails.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
