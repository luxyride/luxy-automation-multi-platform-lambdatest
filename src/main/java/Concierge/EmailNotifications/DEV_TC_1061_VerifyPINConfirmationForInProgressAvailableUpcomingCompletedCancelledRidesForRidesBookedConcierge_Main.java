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
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Main
		extends TestBase {

	Date date;
	String tripID;
	Actions action;
	String expected;
	LocalDate today;
	String currDate;
	String testStep;
	WebDriver driver;
	String exception;
	String testStatus;
	TestBase objTestBase;
	JavascriptExecutor js;
	String screenshotPath;
	SimpleDateFormat formatDate;
	GetCurrentDateTime getDate;
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

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "//td[@tabindex=4]")
	WebElement showRideDetails;

	@FindBy(xpath = "//i[@title='Update Status']")
	WebElement updateRideStatus;

	@FindBy(xpath = "//div[contains(@class,'singleValue')]")
	WebElement rideStatusDrpdown;

	@FindBy(xpath = "(//span[normalize-space()='in progress'])[1]")
	WebElement ridesTabInProgress;
	@FindBy(xpath = "(//span[normalize-space()='Upcoming'])[1]")
	WebElement ridesTabUpcoming;
	@FindBy(xpath = "(//span[normalize-space()='Available'])[1]")
	WebElement ridesTabAvailable;
	@FindBy(xpath = "(//span[normalize-space()='Cancelled'])[1]")
	WebElement ridesTabCancelled;

	@FindBy(xpath = "//i[@title='Cancel Ride']")
	WebElement cancleBtn;
	@FindBy(xpath = "(//span[normalize-space()='Completed'])[1]")
	WebElement ridesTabCompleted;

	@FindBy(xpath = "//i[@title='Cancel Ride']")
	WebElement cancelRideBtn;

	@FindBy(xpath = "//*[text()='Review Cancel Ride']")
	WebElement reviewCancleRidePopup;

	@FindBy(xpath = "//select[@class='form-control']")
	WebElement reasonForCancellation;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement cancelContinueBtn;

	@FindBy(xpath = "//*[text()='Confirm Cancel Ride']")
	WebElement confirmCancleRidePopup;

	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement cancelRideConfirmBtn;

	@FindBy(xpath = "//td[text()='Cancelled']")
	WebElement cancelStatusLbl;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn_Login;

	@FindBy(xpath = "//button[@class='accoutBtn dropdown-toggle']")
	WebElement signInBtnDropdown;

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

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span[@class='MuiIconButton-label']//*[name()='svg'])")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//td[@tabindex='4']")
	WebElement rideStatus;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTime;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//td[@tabindex='13']//a")
	WebElement bookedPassengerName;

	@FindBy(xpath = "//td[@tabindex='15']")
	WebElement vehicleType;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchUser;

	public DEV_TC_1061_VerifyPINConfirmationForInProgressAvailableUpcomingCompletedCancelledRidesForRidesBookedConcierge_Main(
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
			visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
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

	public void expandRideDetails() {
		try {
			action = new Actions(driver);
			action.moveToElement(showRideDetails).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean updateRideStatus(String scenario, Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(updateRideStatus).click().build().perform();
			objTestBase.defaultWaitTime(5000);

			action.moveToElement(rideStatusDrpdown).click().build().perform();
			objTestBase.defaultWaitTime(500);

			if (scenario == "Available")
				action.sendKeys("Available").build().perform();
			else if (scenario == "Upcoming")
				action.sendKeys("Upcoming").build().perform();
			else if (scenario == "InProgress")
				action.sendKeys("InProgress").build().perform();
			else if (scenario == "Completed")
				action.sendKeys("Completed").build().perform();
			else if (scenario == "Cancelled") {
				cancleBtn.click();

				objTestBase.defaultWaitTime(1000);
				action.moveToElement(cancelRideBtn).click().build().perform();
				objTestBase.defaultWaitTime(3000);

				if (reviewCancleRidePopup.isDisplayed()) {
					Select select = new Select(reasonForCancellation);
					select.selectByValue("Client change of plans");
					objTestBase.defaultWaitTime(2000);
					cancelContinueBtn.click();
					objTestBase.defaultWaitTime(2000);
					visibilityStatus = true;
				} else
					visibilityStatus = false;

				if (confirmCancleRidePopup.isDisplayed()) {
					visibilityStatus = true;
				} else
					visibilityStatus = false;

				action.moveToElement(cancelRideConfirmBtn).click().build().perform();
				objTestBase.defaultWaitTime(3000);
			}

			if (scenario != "Cancelled")
				action.sendKeys(Keys.ENTER).build().perform();

			objTestBase.defaultWaitTime(3000);
			visibilityStatus = true;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyRideStatusPageNavigation(String scenario, Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (!expected.toLowerCase().contains(scenario.toLowerCase())) {
				if (scenario == "Available")
					ridesTabAvailable.click();
				else if (scenario == "Upcoming")
					ridesTabUpcoming.click();
				else if (scenario == "InProgress")
					ridesTabInProgress.click();
				else if (scenario == "Completed")
					ridesTabCompleted.click();
				else if (scenario == "Cancelled")
					ridesTabInProgress.click();
			}

			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(scenario.toLowerCase()))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
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

	public Boolean CreateNewRideVANXL(String scenario, String testStatus, Boolean visibilityStatus) {
		try {
			// PROD Restriction:
			if (!environmentCode.equalsIgnoreCase("prod")) {
				scenario = "van-xl";
				visibilityStatus = visibilityOfNewBookingPage(visibilityStatus);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-3000)", "");

				testStatus = vechileBooking(scenario, testStatus, visibilityStatus);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public String vechileBooking(String scenario, String testStatus, Boolean visibilityStatus) throws Exception {
		try {
			visibilityStatus = visibilitOfNewBookingTab(visibilityStatus);
			if (visibilityStatus.booleanValue() == true) {
				objTestBase.defaultWaitTime(1000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(3000);
				testStatus = "PASSED";
			} else {
				testStatus = "FAILED";
			}

			objTestBase.defaultWaitTime(3000);
			addFromAddress();
			objTestBase.defaultWaitTime(2000);
			addToAddress();
			objTestBase.defaultWaitTime(2000);
			clickOnExtraStop();
			objTestBase.defaultWaitTime(1000);
			addExtraStop();
			objTestBase.defaultWaitTime(2000);
			enterDate();
			objTestBase.defaultWaitTime(2000);
			clickOngetQuote();
			objTestBase.defaultWaitTime(3000);

			visibilityStatus = visibilityOfVechileSection(visibilityStatus);
			objTestBase.defaultWaitTime(2000);
			if (scenario == "van-xl") {
				clickOnVANXL();
				objTestBase.defaultWaitTime(2000);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)", "");
				objTestBase.defaultWaitTime(2000);

				searchBookingUserName();
				objTestBase.defaultWaitTime(1000);
				clickcheckbox();
				objTestBase.defaultWaitTime(2000);

				clickOnAddSecondaryPassengerDetails();
				objTestBase.defaultWaitTime(1000);

				objTestBase.defaultWaitTime(1000);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,50)", "");
				objTestBase.defaultWaitTime(2000);

				enterspFirstName();
				objTestBase.defaultWaitTime(1000);
				enterspLastName();
				objTestBase.defaultWaitTime(1000);
				enterspMobile();
				objTestBase.defaultWaitTime(2000);
				enterspEmail();
				objTestBase.defaultWaitTime(1000);
				addAirline();
				objTestBase.defaultWaitTime(1000);
				enterFlightNumber();
				objTestBase.defaultWaitTime(1000);
				enterPassengerNotes();

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,350)", "");
				objTestBase.defaultWaitTime(2000);

				promoCodeEnable();
				objTestBase.defaultWaitTime(2000);
				enterPromocode(scenario);
				objTestBase.defaultWaitTime(2000);
				clickonPromocodeApply();
				objTestBase.defaultWaitTime(2000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)", "");
				objTestBase.defaultWaitTime(2000);
				
				clickOnCardOption();
				objTestBase.defaultWaitTime(2000);

				enterPaymentInformation();
				objTestBase.defaultWaitTime(2000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)", "");
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = verifyConfirmBookingBtnVisibility(visibilityStatus);

				// Prod Restriction:
				if (!environmentCode.equalsIgnoreCase("prod")) {
					objTestBase.defaultWaitTime(2000);
					clickonConfirmBooking();
					objTestBase.defaultWaitTime(2000);

					visibilityStatus = verifyRideBookingConfirmation(visibilityStatus);

					objTestBase.defaultWaitTime(3000);
					clickRidesSection();
					objTestBase.defaultWaitTime(6000);

					// Capture the Ride Booking IDs:
					tripID = captureRideBookingIDs(visibilityStatus, scenario, tripID);
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(2000);
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,-3000)", "");
					objTestBase.defaultWaitTime(1000);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
		}
		return testStatus;
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

	public void clickOngetQuote() {
		try {
			action = new Actions(driver);
			action.moveToElement(getQuote).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
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

	public void clickOnVANXL() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookVANXL).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchBookingUserName() {
		try {
			action = new Actions(driver);
			action.moveToElement(searchBookingUser).click().sendKeys(prop.getProperty("dispatchadminMail")).build()
					.perform();
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickcheckbox() {
		try {
			action = new Actions(driver);
			action.moveToElement(checkBox).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void promoCodeEnable() {
		try {
			action = new Actions(driver);
			action.moveToElement(promoCodeEnable).click().build().perform();
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
						&& !rideBookingIdsConcierge.containsValue(bookingRideTripId.getText())) {
					System.out.println(rideStatus.getText().toLowerCase());
					System.out.println(bookedPassengerName.getText().toLowerCase());
					System.out.println(ridePlaceDateTime.getText().toLowerCase());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatus.getText().toLowerCase().contains("cancelled")
							|| !rideStatus.getText().toLowerCase().contains("completed"))
							&& bookedPassengerName.getText().toLowerCase().contains("qa automation")
							&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						rideBookingIdsConcierge.put(vehicleType.getText().toLowerCase(),
								bookingRideTripId.getText().toString());
						tripID = bookingRideTripId.getText().toString();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currDate;
	}
}
