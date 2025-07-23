package Concierge.NewBookings;

import java.util.Date;
import java.util.List;

import common.GetCurrentDateTime;
import common.TestBase;
import java.util.Locale;
import java.time.Duration;
import java.util.Calendar;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1426_VerifyFilteringOfExternalSourceInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Main
		extends TestBase {

	TestBase objTestBase;
	String expected;
	Actions action;
	WebDriver driver;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;
	Boolean visibilityStatus;
	String screenshotPath;
	String exception;
	int indexCount = 1;
	String scenario;
	String testStep;
	UpdateExtentReportResults objupdateResults;

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

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideId;

	@FindBy(xpath = "(//i[@title='Edit Ride'])[1]")
	WebElement editRideDetailsBtn;

	@FindBy(xpath = "//input[@placeholder='Pickup Address']")
	WebElement fromAddress;

	@FindBy(xpath = "//input[@placeholder='Pickup Address']//following-sibling::div//span//i")
	WebElement fromAddressDelete;

	@FindBy(xpath = "//input[@placeholder='Drop Off Address']")
	WebElement toAddress;

	@FindBy(xpath = "//input[@placeholder='Drop Off Address']//following-sibling::div//span//i")
	WebElement toAddressDelete;

	@FindBy(xpath = "//span[normalize-space()='Add Stops']")
	WebElement extraStopIcon;

	@FindBy(xpath = "//input[@placeholder='Stop 1']")
	WebElement addextraStop;

	@FindBy(xpath = "//i[@title='Delete']")
	WebElement addextraStopDelete;

	@FindBy(xpath = "//span[@class='MuiIconButton-label']//div")
	WebElement calendar;

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

	@FindBy(xpath = "//i[@title='Delete Secondary Passenger']")
	WebElement removeSecondaryPassenger;

	@FindBy(xpath = "//span[normalize-space()='Pay Now']")
	WebElement paynowBtn;

	@FindBy(xpath = "//button[normalize-space()='Update Ride']")
	List<WebElement> updateRideBtn;

	@FindBy(xpath = "//span[normalize-space()='Show Vehicles']")
	WebElement getQuote;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])")
	WebElement nextMonthArrow;

	@FindBy(xpath = "(//*[@class='custom-input-text-timepicker-new form-control'])[1]")
	WebElement selectTime;

	@FindBy(xpath = "(//select[@name='age'])[1]")
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "//input[@placeholder='Flight Number']")
	WebElement flightNumber;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatus;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement ridePlaceDateTime;

	@FindBy(xpath = "//td[@tabindex='9']")
	WebElement ridePickupDateTime;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//td[@tabindex='12']//a")
	WebElement bookedPassengerName;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTripID;

	@FindBy(xpath = "//td[@tabindex='15']")
	WebElement vehicleType;

	@FindBy(xpath = "(//*[text() = 'All'])[1]")
	WebElement allRidesTab;

	@FindBy(xpath = "(//*[text() = 'in progress'])[1]")
	WebElement inProgressTab;

	@FindBy(xpath = "(//*[text() = 'Upcoming'])[1]")
	WebElement upcomingTab;

	@FindBy(xpath = "(//*[text() = 'Available'])[1]")
	WebElement availableTab;

	@FindBy(xpath = "(//*[text() = 'Cancelled'])[1]")
	WebElement cancelledTab;

	@FindBy(xpath = "(//*[text() = 'Completed'])[1]")
	WebElement completedTab;

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

	// Concierge Elements
	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputConcierge;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputConcierge;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn_LoginConcierge;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement signInBtnDropdownConcierge;

	@FindBy(xpath = "(//span[text() = 'New Booking'])[1]")
	WebElement newBookingTabConcierge;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement searchUserConcierge;

	@FindBy(xpath = "//td[@tabindex='2']//child::div")
	List<WebElement> sourceValueConcierge;

	public DEV_TC_1426_VerifyFilteringOfExternalSourceInConciergePortalUsingOriginatorTypeAfterRidesEditFromDispatch_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
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
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus1 = false;
//			visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
		} catch (Exception e) {
			// TODO: handle exception
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

	public void clickRidesSection() {
		try {
			action = new Actions(driver);
			action.moveToElement(ridesSection).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRespectivePage(Boolean visibilityStatus, String scenario) {
		try {
			expected = driver.getCurrentUrl();

			if (scenario.contains("externalSource_Rides_All") && expected.toLowerCase().contains("all"))
				visibilityStatus = true;
			else if (scenario.contains("externalSource_InProgress") && expected.toLowerCase().contains("inprogress"))
				visibilityStatus = true;
			else if (scenario.contains("externalSource_Upcoming") && expected.toLowerCase().contains("upcoming"))
				visibilityStatus = true;
			else if (scenario.contains("externalSource_Available") && expected.toLowerCase().contains("available"))
				visibilityStatus = true;
			else if (scenario.contains("externalSource_Cancelled") && expected.toLowerCase().contains("canceled"))
				visibilityStatus = true;
			else if (scenario.contains("externalSource_Completed") && expected.toLowerCase().contains("completed"))
				visibilityStatus = true;

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

	public void editRideDetails() {
		try {
			action = new Actions(driver);
			action.moveToElement(editRideDetailsBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilitofUpdatePaymentBtn(Boolean visibilityStatus) {
		try {
			if (paynowBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickonPaynowBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(paynowBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickonUpdateRideBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(updateRideBtn.get(0)).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyEDITRideDetailsPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("bookingedit"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean updatePickupDate(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("bookingedit"))
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
			fromAddress.sendKeys(prop.getProperty("toAddress"));
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
			toAddress.sendKeys(prop.getProperty("fromAddress"));
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
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addExtraStop() {
		try {
			action = new Actions(driver);
			addextraStop.sendKeys(prop.getProperty("serviceRateMsgtoAddress"));
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

			LocalDate today = LocalDate.now();
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

				// Select NextMonth 28 as Static Date:
				String secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 28";
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

	public void clickOnSedan() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookSedan).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
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

	public void clickOngetQuote() {
		try {
			action = new Actions(driver);
			action.moveToElement(getQuote).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfUpdateRideBtn(Boolean visibilityStatus) {
		try {
			if (updateRideBtn.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void addAirline() {
		try {
			action = new Actions(driver);
			airlinesDrpdwnHeader.click();
			objTestBase.defaultWaitTime(1000);
			Select select = new Select(airlinesDrpdwnHeader);
			select.selectByValue(prop.getProperty("airlineInputDispatchEDIT"));
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFlightNumber() {
		try {
			flightNumber.click();
			objTestBase.defaultWaitTime(1000);
			flightNumber.sendKeys(Keys.CONTROL + "A");
			flightNumber.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			flightNumber.sendKeys(prop.getProperty("flightNumberDispatchEDIT"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String validateTripIDDetails(Boolean visibilityStatus, String ridePickupDate) {
		// Get the CurrentDate:
		currDate = getCurrDate(currDate);
		System.out.println(rideStatus.getText().toLowerCase());
		System.out.println(bookedPassengerName.getText().toLowerCase());
		System.out.println(ridePlaceDateTime.getText().toLowerCase());
		System.out.println(ridePickupDateTime.getText().toLowerCase());

		if ((!rideStatus.getText().toLowerCase().contains("cancelled")
				|| !rideStatus.getText().toLowerCase().contains("completed"))
				&& (bookedPassengerName.getText().toLowerCase().contains("test user")
						|| bookedPassengerName.getText().toLowerCase().contains("qa automation"))) {
			ridePickupDate = ridePickupDateTime.getText().toLowerCase();
			visibilityStatus = true;
		} else
			visibilityStatus = false;
		return ridePickupDate;
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

	public Boolean visibilityOfNewBookingPage(Boolean visibilityStatus) {
		try {
			newBookingTab.click();
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

	public String captureRideBookingIDs(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			action = new Actions(driver);
			clickRidesSection();
			objTestBase.defaultWaitTime(6000);
			ridesTabAll.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			testStep = "Capture the Updated Ride Details based on the Trip ID = " + tripID;
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(500);
				action.moveToElement(searchTripID).click().sendKeys(tripID).build().perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripId.isDisplayed()) {
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
						visibilityStatus = true;
					} else
						visibilityStatus = false;
					utillLogger.info(testStep + " - Capture the Updated Ride Details based on the Trip ID = " + tripID);
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

	public void clickonAllTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(allRidesTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonInProgressTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(inProgressTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonUpcomingTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(upcomingTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonAvailableTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(availableTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonCancelledTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(cancelledTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonCompletedTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(completedTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPaymentInformation() throws Exception {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);

			cardOptions.click();
			objTestBase.defaultWaitTime(2000);
			
			driver.switchTo().frame("braintree-hosted-field-cardholderName");
			cardHolderName.sendKeys(prop.getProperty("walletcardHolderNameEdit"));
			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo CardNumber Frame
			driver.switchTo().frame("braintree-hosted-field-number");
			cardHolderNumber.click();
			cardHolderNumber.sendKeys(prop.getProperty("walletcardNumberEdit"));

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
			cvv.sendKeys(prop.getProperty("walletCVVEdit"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Postal Code:
			driver.switchTo().frame("braintree-hosted-field-postalCode");
			postalCode.click();
			postalCode.sendKeys(prop.getProperty("walletPostalCodeEdit"));
			objTestBase.defaultWaitTime(1000);

			// SwitchBackTo Default Frame
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Concierge Methods:
	public void eMailInputConcierge() {
		try {
			action = new Actions(driver);
			eMailInputConcierge.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInputConcierge() {
		try {
			action = new Actions(driver);
			passwordInputConcierge.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonConcierge(Boolean visibilityStatus) {
		try {
			if (signInBtn_LoginConcierge.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonConcierge() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn_LoginConcierge).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserConcierge(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(2000);
			if (signInBtnDropdownConcierge.isDisplayed()) {
				expected = signInBtnDropdownConcierge.getText();
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

	public Boolean visibilitOfNewBookingTabConcierge(Boolean visibilityStatus) {
		try {
			if (newBookingTabConcierge.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickNewBookingConcierge() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newBookingTabConcierge).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean searchTripID(Boolean visibilityStatus, String tripID) {
		try {
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(searchUserConcierge));
			if (displayStatus.isDisplayed()) {
				searchUserConcierge.click();
				searchUserConcierge.sendKeys(Keys.CONTROL + "A");
				searchUserConcierge.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(searchUserConcierge).sendKeys(tripID).build().perform();
				objTestBase.defaultWaitTime(3000);
				if (sourceValueConcierge.size() != 0)
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

	public Boolean verifySourceSystemConcierge(Boolean visibilityStatus) {
		try {
			if (sourceValueConcierge.size() != 0) {
				expected = sourceValueConcierge.get(0).getAttribute("title").toLowerCase();
				if (expected.equalsIgnoreCase("External Source"))
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
