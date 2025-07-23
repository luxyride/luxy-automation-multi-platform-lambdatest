package Concierge.EmailNotifications;

import java.util.Date;
import java.util.List;
import java.awt.Robot;
import common.TestBase;
import java.util.Locale;
import java.awt.Toolkit;
import java.time.Duration;
import java.util.Calendar;
import java.time.LocalDate;
import org.openqa.selenium.By;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.datatransfer.Clipboard;
import common.UpdateExtentReportResults;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1062_VerifyPINConfirmationEmailNotSentToCustomerWhenRidesEditedWhileBookedConcierge_Main
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
	WebElement newBookingTab;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "//i[@title='Edit Ride']")
	WebElement editRideDetailsBtn;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideId;

	@FindBy(xpath = "//i[@title='Resend Booking Confirmation']")
	WebElement resendEmailConfirmation;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

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

	@FindBy(xpath = "//span[normalize-space()='Show Vehicles']")
	WebElement getQuote;

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

	@FindBy(xpath = "//div[(@title='Van-XL') and normalize-space()='Van-XL']")
	WebElement bookVANXL;

	@FindBy(xpath = "//i[@title='Delete Secondary Passenger']")
	WebElement removeSecondaryPassenger;

	@FindBy(xpath = "(//select[@name='age'])[1]")
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "(//input[@name = 'checkedC'])[4]")
	WebElement enableChildSeatCheckbox;

	@FindBy(xpath = "//textarea[@id='greet_passenger_name']")
	WebElement arrivalMeetGreetPassengerName;

	@FindBy(xpath = "//textarea[@id='greet_notes']")
	WebElement arrivalMeetGreetNotes;

	@FindBy(xpath = "//select[@class='form-control custom-sb']")
	WebElement selectChildSeat;

	@FindBy(xpath = "//input[@placeholder='Flight Number']")
	WebElement flightNumber;

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

	@FindBy(xpath = "(//input[@name = 'checkedC'])[2]")
	WebElement enableArrivalMeetGreetCheckbox;

	@FindBy(xpath = "(//input[@name = 'checkedC'])[3]")
	WebElement enableTravelingWithPetCheckbox;

	@FindBy(xpath = "//span[normalize-space()='Pay Now']")
	WebElement paynowBtn;

	@FindBy(xpath = "//button[normalize-space()='Update Ride']")
	List<WebElement> updateRideBtn;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])")
	WebElement nextMonthArrow;

	@FindBy(xpath = "(//*[@class='custom-input-text-timepicker-new form-control'])[1]")
	WebElement selectTime;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTripID;

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

	public DEV_TC_1062_VerifyPINConfirmationEmailNotSentToCustomerWhenRidesEditedWhileBookedConcierge_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
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
			e.printStackTrace();
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

	public void clickRidesSection() {
		try {
			ridesSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickTravelingPetCheckbox() {
		try {
			enableTravelingWithPetCheckbox.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickChildSeatCheckbox() {
		try {
			enableTravelingWithPetCheckbox.click();
			objTestBase.defaultWaitTime(1000);

			Select select = new Select(selectChildSeat);
			select.selectByValue("2");
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
			action = new Actions(driver);
			searchRideId.click();
			objTestBase.defaultWaitTime(1000);
			searchRideId.sendKeys(Keys.CONTROL + "A");
			searchRideId.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			searchRideId.sendKeys(tripID);
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
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

	public void deleteAllExistingAddress() {
		try {
			fromAddressDelete.click();
			objTestBase.defaultWaitTime(500);
			toAddressDelete.click();
			objTestBase.defaultWaitTime(500);
			addextraStopDelete.click();
			objTestBase.defaultWaitTime(500);
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

	public void enterTime() {
		try {
			Select select = new Select(selectTime);
			select.selectByValue("8");
			objTestBase.defaultWaitTime(2000);
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

	public void clickOnSUVXL() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookSUVXL).click().build().perform();
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

	public void clickOnVANXL() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookVANXL).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnRemoveSecondaryPassenger() {
		try {
			action = new Actions(driver);
			action.moveToElement(removeSecondaryPassenger).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeExtraStop() {
		try {
			action = new Actions(driver);
			action.moveToElement(addextraStopDelete).click().build().perform();
			objTestBase.defaultWaitTime(1000);
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

	public void editRideDetails() {
		try {
			action = new Actions(driver);
			action.moveToElement(editRideDetailsBtn).click().build().perform();
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

	public void clickonArrivalMeetGreet() {
		try {
			action = new Actions(driver);
			action.moveToElement(enableArrivalMeetGreetCheckbox).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterArrivalMeetGreetDetails() {
		try {
			arrivalMeetGreetPassengerName.click();
			objTestBase.defaultWaitTime(1000);
			arrivalMeetGreetPassengerName.sendKeys(Keys.CONTROL + "A");
			arrivalMeetGreetPassengerName.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			arrivalMeetGreetPassengerName.sendKeys(prop.getProperty("greetPassengerNameDispatchEDIT"));
			objTestBase.defaultWaitTime(1000);

			arrivalMeetGreetNotes.click();
			objTestBase.defaultWaitTime(1000);
			arrivalMeetGreetNotes.sendKeys(Keys.CONTROL + "A");
			arrivalMeetGreetNotes.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			arrivalMeetGreetNotes.sendKeys(prop.getProperty("greetCommentsDispatchEDIT"));
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyResendEmailConfirmationBtn(Boolean visibilityStatus) {
		try {
			resendEmailConfirmation.click();
			objTestBase.defaultWaitTime(1000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

			if (displayStatus.isDisplayed() && alertMessge.getText().toString().toLowerCase().contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return visibilityStatus;
	}

	public String emailIDSerach(String scenario, String eMail, String tripID) {
		action = new Actions(driver);
		try {
			if (scenario.contains("Primary"))
				eMail = prop.getProperty("dispatchadminMail");
			else
				eMail = prop.getProperty("spEmail");
			System.out.println("DEV_TC_1048_Email = " + eMail);
			action = new Actions(driver);
			String[] tempEmail = eMail.toString().split("@");
			defaultWaitTime(1000);
			if (clearBtn.size() != 0) {
				if (clearBtn.get(0).isDisplayed()) {
					clearBtn.get(0).click();
					objTestBase.defaultWaitTime(1000);
				}
			}
			action.moveToElement(loginBtn).click().sendKeys(tempEmail[0]).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			defaultWaitTime(2000);
			driver.navigate().refresh();
			defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eMail;
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

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
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

	public Boolean verificationOfPINConfirmationEmail(Boolean visibilityStatus, String tripID) {
		try {
			expected = driver.getCurrentUrl();
			action = new Actions(driver);
			if (expected.toLowerCase().contains("yopmail")) {
				defaultWaitTime(1000);
				driver.switchTo().frame("ifmail");
				if (mailSubject.size() > 1) {
					if (mailSubject.get(1).isDisplayed() && mailSubject.get(1).getText().contains(tripID))
						visibilityStatus = true;
				} else {
					if (mailSubject.get(0).isDisplayed() && mailSubject.get(0).getText().contains(tripID))
						visibilityStatus = true;
				}

				objTestBase.defaultWaitTime(1000);

				StringSelection stringSelection = new StringSelection("PIN");
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				robot = new Robot();

				// ctrl+F
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_F);
				Thread.sleep(500);
				// Releasing Ctrl and F key
				robot.keyRelease(KeyEvent.VK_F);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);

				// ctrl+v
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(500);

				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);

				robot.keyPress(KeyEvent.VK_ESCAPE);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(500);

				if (pinNumber.size() != 0)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

			driver.switchTo().defaultContent();
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
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

	public Boolean validateTripIDDetails(Boolean visibilityStatus) {
		try {
			// Get the CurrentDate:
			currDate = getCurrDate(currDate);

			System.out.println(rideStatusDispatch.getText().toLowerCase());
			System.out.println(bookedPassengerNameDispatch.getText().toLowerCase());
			System.out.println(ridePlaceDateTimeDispatch.getText().toLowerCase());

			if ((!rideStatusDispatch.getText().toLowerCase().contains("cancelled")
					|| !rideStatusDispatch.getText().toLowerCase().contains("completed"))
					&& (bookedPassengerNameDispatch.getText().toLowerCase().contains("test user")
							|| bookedPassengerNameDispatch.getText().toLowerCase().contains("qa automation"))
					&& ridePlaceDateTimeDispatch.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
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
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(500);
				action.moveToElement(searchTripID).click().sendKeys(tripID).build().perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripIdDispatch.isDisplayed()) {
					System.out.println(rideStatusDispatch.getText().toLowerCase());
					System.out.println(bookedPassengerNameDispatch.getText().toLowerCase());
					System.out.println(ridePlaceDateTimeDispatch.getText().toLowerCase());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatusDispatch.getText().toLowerCase().contains("cancelled")
							|| !rideStatusDispatch.getText().toLowerCase().contains("completed"))
							&& bookedPassengerNameDispatch.getText().toLowerCase().contains("qa automation")
							&& ridePlaceDateTimeDispatch.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00
						visibilityStatus = true;

					else
						visibilityStatus = false;

				} else
					visibilityStatus = false;

				objTestBase.defaultWaitTime(1000);
				utillLogger.info(testStep + " - Capture the Updated Ride Details based on the Trip ID = " + tripID);
			} else
				visibilityStatus = false;
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
}
