package Dispatch.NewBooking;

import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.time.Duration;
import java.util.Calendar;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;

import java.text.DateFormat;
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

public class DEV_TC_1372_VerifyRideBookingWhenZoneTypeAsCityDispatch_Main extends TestBase {

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
	int actualTimeHours;
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
	WebElement vechileAvailableSection;

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

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span)[1]")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//*[(@role='alert')]")
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

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchUser;

	@FindBy(xpath = "//span[contains(text(),'Please book a ride at least')]")
	List<WebElement> warningMsg;

	@FindBy(xpath = "(//select[@class='custom-input-text-timepicker-new form-control'])[1]")
	WebElement timeElement;

	@FindBy(xpath = "//button[normalize-space()='Update Ride']")
	WebElement updateBtn;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//i[@title='Edit Ride']")
	WebElement editRideBtn;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement conciergeTripID;

	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement dispatchupdateBtn;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideId;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement dispatchsignInBtn_Login;

	@FindBy(xpath = "//input[@placeholder='Pickup Address']")
	WebElement dispatchFromAddress;

	@FindBy(xpath = "//input[@placeholder='Drop Off Address']")
	WebElement dispatchToAddress;

	@FindBy(xpath = "//span[@class='MuiIconButton-label']//div")
	WebElement dispatchcalendar;

	@FindBy(xpath = "//input[@id='date-picker-inline']")
	WebElement dispatchdateInput;

	@FindBy(xpath = "//button[normalize-space()='Get Quote']")
	WebElement dispatchgetQuote;

	@FindBy(xpath = "//span[normalize-space()='Choose Vehicle']//following-sibling::div")
	List<WebElement> dispatchvechileAvailableSection;

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	WebElement dispatchEDITVehicle;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span)[1]")
	WebElement dispatchnextMonthArrow;

	@FindBy(xpath = "//label[normalize-space()='Airline']//following-sibling::div")
	WebElement donotServe;

	@FindBy(xpath = "(//select[@class='form-control'])[6]")
	WebElement doNotServeDrpdown;

	@FindBy(xpath = "//*[(@role='alert')]")
	WebElement dispatchalertMessge;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement dispatchSKUNumber;

	@FindBy(xpath = "(//span[normalize-space()='Pricing'])[1]")
	WebElement dispatchpricingSection;

	@FindBy(xpath = "(//span[normalize-space()='Service Rate'])[1]")
	WebElement dispatchserviceRateTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchSKUNumberSearch;

	@FindBy(xpath = "//i[@title = 'Edit']")
	WebElement dispatchEDIT;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailDispatchInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordDispatchInput;

	@FindBy(xpath = "//span[contains(text(),'This trip can not be quoted at the moment')]")
	List<WebElement> dispatchwarningMsg;

	public DEV_TC_1372_VerifyRideBookingWhenZoneTypeAsCityDispatch_Main(WebDriver driver) {
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
			objTestBase.defaultWaitTime(2000);
			fromAddress.sendKeys(prop.getProperty("zoneTypeCityFromAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(3000);
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
			objTestBase.defaultWaitTime(2000);
			if (scenario == "lessthanConfigMiles")
				toAddress.sendKeys(prop.getProperty("zoneTypeCityToAddressNegative"));
			else if (scenario == "greaterthanConfigMilesNegative")
				toAddress.sendKeys(prop.getProperty("zoneTypeCityToAddressNegative"));
			else if (scenario == "positivescenario")
				toAddress.sendKeys(prop.getProperty("zoneTypeCityToAddressPositive"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDate(Boolean todaysFlag, Boolean modifyDateFlag) {
		try {
			action = new Actions(driver);
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

				List<WebElement> sizeOfDayElement = driver.findElements(By.xpath(dayOfMonthXpath));
				if (sizeOfDayElement.size() == 1)
					action.moveToElement(sizeOfDayElement.get(0)).click().build().perform();
				else
					action.moveToElement(sizeOfDayElement.get(1)).click().build().perform();
				objTestBase.defaultWaitTime(2000);

			} else {
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
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Map<String, Integer> enterTime(String scenario, Boolean lessThan24hrs, Map<String, Integer> timeHours) {
		try {
			String conditionTracking = "";
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("HH");
			df.setTimeZone(TimeZone.getTimeZone(prop.getProperty("zoneIDCity")));

			actualTimeHours = Integer.parseInt(df.format(date));
			timeHours.put("ActualTimeHours", actualTimeHours);
			System.out.println("Current Time = " + actualTimeHours);

			if (scenario != "positivescenario") {
				if (scenario == "lessthanBufferTime" && actualTimeHours <= 21) {
					configuredTimeHours = actualTimeHours + 3;
					conditionTracking = "Condition_1";
				} else if (scenario == "lessthanBufferTime" && (22 <= actualTimeHours && actualTimeHours <= 23)) {
					configuredTimeHours = (24 - actualTimeHours)
							- Integer.parseInt(prop.getProperty("zoneTypeCityConfigTime") + 1);

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
						- (actualTimeHours - Integer.parseInt(prop.getProperty("zoneTypeCityConfigTime")) - 1);
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
			System.out.println("Configured Time = " + configuredTimeHours + " Verification of IF-ELSE Condition "
					+ conditionTracking);

			timeElement.click();
			Select selectTime = new Select(timeElement);
			selectTime.selectByValue(Integer.toString(configuredTimeHours));
			objTestBase.defaultWaitTime(2000);

			if (modifyDateFlag == true) {
				enterDate(true, modifyDateFlag);
				utillLogger.info("Modify Date Flag = " + modifyDateFlag);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return timeHours;
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

	public void searchBookingUserName() {
		try {
			action = new Actions(driver);
			action.moveToElement(searchBookingUser).click().sendKeys(prop.getProperty("dispatchadminMail")).build()
					.perform();
			objTestBase.defaultWaitTime(6000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickcheckbox() {
		action = new Actions(driver);
		action.moveToElement(checkBox).click().build().perform();
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

	public void enterFirstName() {
		try {
			action = new Actions(driver);
			firstName.click();
			objTestBase.defaultWaitTime(1000);
			firstName.sendKeys(prop.getProperty("dispatchadminMail"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
		try {
			String msgText = "";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(24));
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
				objTestBase.defaultWaitTime(2000);
				action.moveToElement(searchUser).click().sendKeys(prop.getProperty("dispatchadminMail")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(3000);

				if (conciergeTripID.isDisplayed()
						&& !rideBookingIdsConcierge.containsValue(conciergeTripID.getText())) {
					System.out.println(rideStatus.getText().toLowerCase());
					System.out.println(bookedPassengerName.getText().toLowerCase());
					System.out.println(ridePlaceDateTime.getText().toLowerCase());
					System.out.println(conciergeTripID.getText());

					// Get the CurrentDate:
					currDate = getCurrDate(currDate);

					if ((!rideStatus.getText().toLowerCase().contains("cancelled")
							|| !rideStatus.getText().toLowerCase().contains("completed"))
							&& bookedPassengerName.getText().toLowerCase().contains("test user")
							&& ridePlaceDateTime.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						tripID = conciergeTripID.getText().toString();
						objTestBase.defaultWaitTime(1000);
						testStatus = "PASSED";
					} else
						testStatus = "FAILED";
					utillLogger.info(testStep + " - Capture the Trip ID = " + tripID);
				} else {
					visibilityStatus = false;
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);	else	lambdaTestStatusUpdate("failed", testStep);
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

	public Map<String, Integer> editTime(String scenario, Boolean lessThan24hrs, Map<String, Integer> timeHours) {
		try {
			String conditionTracking = "";
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("HH");
			df.setTimeZone(TimeZone.getTimeZone(prop.getProperty("zoneTypeCityConfigTime")));

			actualTimeHours = Integer.parseInt(df.format(date));
			timeHours.put("ActualTimeHours", actualTimeHours);
			System.out.println("Current Time = " + actualTimeHours);

			if (scenario != "positivescenario") {
				if (scenario == "lessthanBufferTime" && actualTimeHours <= 21) {
					configuredTimeHours = actualTimeHours + 3;
					conditionTracking = "Condition_1";
				} else if (scenario == "lessthanBufferTime" && (22 <= actualTimeHours && actualTimeHours <= 23)) {
					configuredTimeHours = (24 - actualTimeHours)
							- Integer.parseInt(prop.getProperty("zoneTypeCityConfigTime") + 1);

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
						- (actualTimeHours - Integer.parseInt(prop.getProperty("zoneTypeCityConfigTime")) - 1);
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

	public Boolean verifyVisibilityOfWarningMsg(Boolean visibilityStatus) {
		try {
			clickOngetQuote(); // Click on getQuote:
			objTestBase.defaultWaitTime(1000);
			String msgText = "";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				msgText = alertMessge.getText().toLowerCase();
				System.out.println("Alert Message Text = " + msgText);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus == true && msgText.contains(prop.getProperty("zoneTypeCityConfigTime"))
					&& msgText.contains(prop.getProperty("zoneTypeCityConfigMiles")))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
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

	// Dispatch Methods:
	public void eMailDispatchInput() {
		try {
			action = new Actions(driver);
			eMailDispatchInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordDispatchInput() {
		try {
			action = new Actions(driver);
			passwordDispatchInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public String captureSKUNumber(String skuNumber) {
		try {
			skuNumber = dispatchSKUNumber.getAttribute("value");
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return skuNumber;
	}

	public void addDispatchFromAddress() {
		try {
			action = new Actions(driver);
			dispatchFromAddress.click();
			objTestBase.defaultWaitTime(1000);
			dispatchFromAddress.sendKeys(Keys.CONTROL + "A");
			dispatchFromAddress.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			dispatchFromAddress.sendKeys(prop.getProperty("zoneTypeCityFromAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDispatchToAddress() {
		try {
			action = new Actions(driver);
			dispatchToAddress.sendKeys(prop.getProperty("zoneTypeCityToAddressPositive"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dipatchclickOngetQuote() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchgetQuote).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfVechileSection(Boolean visibilityStatus) {
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

	public void dispatchclickonEDITVehicle() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchEDITVehicle).click().build().perform();
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

			LocalDate today = LocalDate.now();
			int currDay = today.getDayOfMonth();
			int currMonth = today.getMonthValue();
			int currYear = today.getYear();

			Calendar cal = Calendar.getInstance();
			int lastDateofMonth = cal.getActualMaximum(Calendar.DATE);

			// Select Date of Next Month:
			if (currDay >= lastDateofMonth - 2) {
				int nextMonth = today.getMonthValue() + 1;
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

	public Boolean switchToWindow(Boolean visibilityStatus) {
		Set<String> listOfWindows = driver.getWindowHandles();
		int i = 0;
		for (String currWindow : listOfWindows) {
			if (i == 1) {
				driver.switchTo().window(currWindow);	try	{	defaultWaitTime(5000);	}	catch (Exception e)	{	e.printStackTrace(); }
			}
			i++;
		}
		expected = driver.getCurrentUrl();

		if (expected.toLowerCase().contains("editservicerate"))
			visibilityStatus = true;
		else
			visibilityStatus = false;

		return visibilityStatus;
	}

	public void dispatchupdateDONOTSERVE(Boolean enable) {
		try {
			action = new Actions(driver);
			doNotServeDrpdown.click();
			objTestBase.defaultWaitTime(3000);
			Select select = new Select(doNotServeDrpdown);

			if (enable == true)
				select.selectByValue("true");
			else
				select.selectByValue("false");

			objTestBase.defaultWaitTime(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dipatchclickOnUpdateButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchupdateBtn).click().build().perform();
			objTestBase.defaultWaitTime(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyDispatchDoNotServeUpdateConfirmation(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchalertMessge));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfDoNotServeWarningMsg(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(3000);
			if (dispatchwarningMsg.size() != 0) {
				waitTimeForElement(warningMsg.get(0));
				if (dispatchwarningMsg.get(0).getText().toLowerCase()
						.contains("this trip can not be quoted at the moment"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else if (bookSedan.isDisplayed()) {
				waitTimeForElement(bookSedan);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void dispatchclickPricingSection() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchpricingSection).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchvisibilityOfServiceRateTabPage(Boolean visibilityStatus) {
		try {
			dispatchserviceRateTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manageservicerate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public String dispatchSKUNumberSearch(String captureSKUNumber) {
		try {
			action = new Actions(driver);
			dispatchSKUNumberSearch.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(dispatchSKUNumberSearch));
			dispatchSKUNumberSearch.sendKeys(captureSKUNumber);
			dispatchSKUNumberSearch.sendKeys(Keys.ENTER);
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return captureSKUNumber;
	}

	public Boolean dipatchclickOnEDITButton(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(dispatchEDIT));
			action = new Actions(driver);
			action.moveToElement(dispatchEDIT).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
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

	public Boolean dispatchVisibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			if (dispatchsignInBtn_Login.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void dispatchclickonSigninButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchsignInBtn_Login).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfListofVechiles(Boolean visibilityStatus) {
		try {
			if (vechileAvailableSection.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
