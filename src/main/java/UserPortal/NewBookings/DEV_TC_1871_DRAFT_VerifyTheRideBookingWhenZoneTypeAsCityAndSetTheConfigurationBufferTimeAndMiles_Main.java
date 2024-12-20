package UserPortal.NewBookings;

import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Calendar;
import java.time.Duration;
import java.time.LocalDate;
import java.text.DateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Main
		extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
	Boolean modifyDateFlag = false;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signinBtn;

	@FindBy(xpath = "((//a[normalize-space()='Customer Login'])[2])[1]")
	WebElement customerLogin;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement passwordInput;

	@FindBy(xpath = "(//div[@class='input-group-prepend'])[1]//span//i")
	WebElement eyeIcon;

	@FindBy(xpath = "(//div[normalize-space()='Login and Continue'])[1]")
	WebElement signInBtn_Login;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "//input[@placeholder='Enter Pickup Location']")
	WebElement fromAddress;

	@FindBy(xpath = "//input[@placeholder='Enter dropoff Location']")
	WebElement toAddress;

	@FindBy(xpath = "(//div[normalize-space()='Get Quote'])[2]")
	WebElement getQuote;

	@FindBy(xpath = "(//input[@placeholder='Select Time'])[1]")
	WebElement timeElement;

	@FindBy(xpath = "(//input[@placeholder='Select Time'])[1]")
	WebElement timeElementMinutes;

	@FindBy(xpath = "//input[@placeholder='Enter Pickup Date']")
	WebElement calendar;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement nextMonthArrow;

	@FindBy(xpath = "(//*[contains(text(),'Please book a ride at least')])[1]")
	List<WebElement> warningMsg;

	@FindBy(xpath = "(//*[contains(text(),'This trip can not be quoted at the moment')])[1]")
	List<WebElement> dispatchwarningMsg;

	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[normalize-space()='Sedan']")
	List<WebElement> bookSedan;

	@FindBy(xpath = "//*[text()='Confirm your vehicle']")
	List<WebElement> confirmVehiclePopup;

	@FindBy(xpath = "//button[text()='Confirm']")
	List<WebElement> confirmBtn;

	@FindBy(xpath = "(//div[normalize-space()='Add Secondary Passenger'])[1]")
	WebElement secondaryPassenger;

	@FindBy(xpath = "(//input[@placeholder='Enter First Name'])[2]")
	WebElement spFirstName;

	@FindBy(xpath = "(//input[@placeholder='Enter Last Name'])[2]")
	WebElement spLastName;

	@FindBy(xpath = "(//div[normalize-space()='Phone'])[4]//following-sibling::input")
	WebElement spMobile;

	@FindBy(xpath = "(//input[@placeholder='Enter Email Address'])[2]")
	WebElement spEmail;

//	@FindBy(xpath = "//textarea[@id='passenger_notes']")
//	WebElement passengerNotes;

	@FindBy(xpath = "(//div[normalize-space()='Proceed to Pay'])[1]")
	List<WebElement> paymentInfocheckbox;

	@FindBy(xpath = "(//div[normalize-space()='Make Payment & Book Ride'])[1]")
	WebElement confirmBookingBtn;
	
	@FindBy(xpath = "//div[text()='Save card for future use']//following::input//following::label//div[1]")
	WebElement termsAndConditionsCheckbox;

	@FindBy(xpath = "(//div[normalize-space()='Book Another Ride'])[1]")
	WebElement bookNextRideBtn;

	@FindBy(id = "cardholder-name")
	WebElement cardHolderName;

	@FindBy(id = "credit-card-number")
	WebElement cardHolderNumber;

	@FindBy(id = "expiration")
	WebElement cardExpiryDate;

	@FindBy(id = "cvv")
	WebElement cvv;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(xpath = "//h5[@class='block-head mx-2']")
	WebElement vechileAvailableSection;

	@FindBy(xpath = "(//div[@class='row'])[3]")
	List<WebElement> vechileAvailableList;

	@FindBy(xpath = "//input[@type='text']")
	List<WebElement> eMailDispatchInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordDispatchInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIconDispatch;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

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

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
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

	@FindBy(xpath = "//div[normalize-space()='Trip ID:']//following-sibling::div[1]")
	WebElement bookingRideTripId;

	TestBase objTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	int actualTimeHours;
	int configuredTimeHours;
	int configuredTimeMinutes;
	String actualTimeHHMM;

	public DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
			getDate = new GetCurrentDateTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickLogin() throws InterruptedException {
		try {
			action = new Actions(driver);
			action.moveToElement(signinBtn).click().build().perform();
			action.moveToElement(signinBtn).build().perform();
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

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("sanityeMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("sanityPwd"));
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
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
				js.executeScript("window.scrollBy(0,50)", "");
				if (customerLogin.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", signInBtn_Login);
				js.executeScript("window.scrollBy(0,50)", "");
				if (signInBtn_Login.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn_Login).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilitydispatchOfSigninButton(Boolean visibilityStatus) {
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

	public void clickdispatchSigninButton() {
		try {
			dispatchsignInBtn_Login.click();
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
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

	public void addFromAddress() {
		try {
			action = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", fromAddress);
			js.executeScript("window.scrollBy(0,50)", "");
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
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDate(Boolean todaysFlag, Boolean modifyDateFlag) {
		try {
			objTestBase.defaultWaitTime(2000);
			driver.findElement(By.xpath("//input[@placeholder='Enter Pickup Date']")).click();
			objTestBase.defaultWaitTime(2000);

			LocalDate today = LocalDate.now();
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
				
				todaysDate = todaysDate.replaceAll("[^0-9]", "");
				String dayOfMonthXpath = "//div[text()='" + todaysDate + "']";
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
						// -----------------------------------------------------------------------------------
						// Handling Feb month xpath issue:
						objTestBase.defaultWaitTime(1000);
						nextMonthArrow.click();
						objTestBase.defaultWaitTime(2000);
						// -----------------------------------------------------------------------------------
					}

					String nextMonthDate = nextMonth + "-" + currDay + "-" + currYear;
					Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(nextMonthDate);
					cal.setTime(d);

					// Select 2nd Day of NextMonth
					String secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 2";
					secondDayOfNextMonth = secondDayOfNextMonth.replaceAll("[^0-9]", "");
					String dayOfMonthXpath = "//div[text()='" + secondDayOfNextMonth + "']";
					driver.findElement(By.xpath(dayOfMonthXpath)).click();
					objTestBase.defaultWaitTime(2000);
				}
				// Select Date of 2 days after based on Current Date:
				else {
					String currDate = currMonth + "-" + currDay + "-" + currYear;

					Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(currDate);
					cal.setTime(d);

					// Select 2 days after Current Date:
					String secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " "
							+ (currDay + 2);
					secondDayOfCurrMonth = secondDayOfCurrMonth.replaceAll("[^0-9]", "");
					String dayOfMonthXpath = "//div[text()='" + secondDayOfCurrMonth + "']";
					driver.findElement(By.xpath(dayOfMonthXpath)).click();
					objTestBase.defaultWaitTime(2000);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Map<String, Integer> enterTime(String scenario, Boolean lessThan24hrs, Map<String, Integer> timeHHMM) {
		try {
			String conditionTracking = "";
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("HH:MM");
			df.setTimeZone(TimeZone.getTimeZone(prop.getProperty("zoneIDAirport")));

			actualTimeHHMM = df.format(date);
			String[] tempVal = actualTimeHHMM.split(":");
			timeHHMM.put("ActualTimeHours", Integer.parseInt(tempVal[0]));
			timeHHMM.put("ActualTimeMinutes", Integer.parseInt(tempVal[1]));
			System.out.println("Actual Time Hours : Minutes = " + timeHHMM.get("ActualTimeHours") + " : "
					+ timeHHMM.get("ActualTimeMinutes"));

			if (scenario != "positivescenario") {
				if (scenario == "lessthanBufferTime" && actualTimeHours <= 21) {
					configuredTimeHours = timeHHMM.get("ActualTimeHours");
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
				configuredTimeHours = actualTimeHours + 8;
				conditionTracking = "Condition_6";
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

			timeHHMM.put("ConfiguredTimeHours", configuredTimeHours);
			utillLogger.info(
					"DEV_TC_1871_DRAFT_VerifyTheRideBookingWhenZoneTypeAsCityAndSetTheConfigurationBufferTimeAndMiles_Test - Actual Time in Hours = "
							+ actualTimeHours + " & Configured Time in Hours = " + configuredTimeHours
							+ "Verification of IF-ELSE Condition " + conditionTracking);
			System.out.println("Configured Time = " + configuredTimeHours + "Verification of IF-ELSE Condition "
					+ conditionTracking);
			objTestBase.defaultWaitTime(2000);

			if (modifyDateFlag == true) {
				enterDate(true, modifyDateFlag);
				utillLogger.info("Modify Date Flag = " + modifyDateFlag);
			}

			// Configure the Minutes:
			configuredTimeMinutes = timeHHMM.get("ActualTimeMinutes") + 10;
			if (configuredTimeMinutes > 55)
				configuredTimeHours = timeHHMM.get("ActualTimeHours") + 1;

			timeElement.sendKeys(Integer.toString(configuredTimeHours) + ":" + Integer.toString(configuredTimeMinutes));
			objTestBase.defaultWaitTime(1000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"document.querySelectorAll(\"input[placeholder=Select Time]\")[1].value = configuredTimeHours + \":\"\r\n"
							+ "					+ configuredTimeMinutes;");

			objTestBase.defaultWaitTime(5000);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return timeHHMM;
	}

	public Boolean visibilityOfVechileSection() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8000));
			wait.until(ExpectedConditions.visibilityOf(bookSedan.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Boolean visibilityOfListofVechiles(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", vechileAvailableSection);
			js.executeScript("window.scrollBy(0,50)", "");
			if (vechileAvailableSection.isDisplayed()) {
				expected = vechileAvailableSection.getText();
				if (expected.toLowerCase().contains("choose") && vechileAvailableList.size() != 0) {
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

	public void clickOnSedan() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookSedan.get(0)).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonConfirmPopup() {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmBtn.get(0)).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideDetailsPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("ride-details")) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnSecondaryPassenger() {
		try {
			action = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", toAddress);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(secondaryPassenger).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspFirstName() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spFirstName);
			js.executeScript("window.scrollBy(0,50)", "");
			spFirstName.sendKeys(prop.getProperty("spFirstName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspLastName() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spLastName);
			js.executeScript("window.scrollBy(0,50)", "");
			spLastName.sendKeys(prop.getProperty("spLastName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspEmail() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spEmail);
			js.executeScript("window.scrollBy(0,50)", "");
			spEmail.sendKeys(prop.getProperty("spEmail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspMobile() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spMobile);
			js.executeScript("window.scrollBy(0,50)", "");
			spMobile.sendKeys(prop.getProperty("spMobile"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPaymentInformation() throws Exception {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,50)", "");

			// SwitchTo CardHolder Frame
			driver.switchTo().frame("braintree-hosted-field-cardholderName");
			cardHolderName.click();
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

			// SwitchTo Expiry Date
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

	public void clickonConfirmBooking() {
		try {
			action = new Actions(driver);
			// Validate FAQs checkbox - User Portal Ride-Details Page:
			clickonFAQscheckbox();
			objTestBase.defaultWaitTime(1000);
			termsAndConditionsCheckbox.click();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(confirmBookingBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(bookingRideTripId));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookingRideTripId);
			js.executeScript("window.scrollBy(0,50)", "");
			
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1000)", "");
			js.executeScript("arguments[0].scrollIntoView(true);", bookingRideTripId);
			objTestBase.defaultWaitTime(2000);

			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("confirmed"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyConfirmBookingBtnVisibility(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", confirmBookingBtn);
			js.executeScript("window.scrollBy(0,50)", "");
			if (confirmBookingBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfPaymentInfo(Boolean visibilityStatus) {
		try {
			if (paymentInfocheckbox.size() != 0 && paymentInfocheckbox.get(0).isDisplayed()) {
				paymentInfocheckbox.get(0).click();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOngetQuote() {
		try {
			action = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", getQuote);
			js.executeScript("window.scrollBy(0,50)", "");
			action.moveToElement(getQuote).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCancel() {
		try {
			action = new Actions(driver);
			action.moveToElement(cancelBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyVisibilityOfWarningMsg(Boolean visibilityStatus) {
		try {
			waitTimeForElement(warningMsg.get(0));
			System.out.println(warningMsg.get(0).getText());
			expected = warningMsg.get(0).getText();
			if (expected != null) {
				System.out.println("Configured Hours = " + prop.getProperty("zoneTypeCityConfigTime") + "\n"
						+ "Configured Miles = " + prop.getProperty("zoneTypeCityConfigMiles"));
				if (expected.toLowerCase().contains(prop.getProperty("zoneTypeCityConfigTime"))
						&& expected.toLowerCase().contains(prop.getProperty("zoneTypeCityConfigMiles")))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickonBookNextRide() {
		try {
			waitTimeForElement(bookNextRideBtn);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookNextRideBtn);
			js.executeScript("window.scrollBy(0,50)", "");
			action = new Actions(driver);
			action.moveToElement(bookNextRideBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Dispatch Methods:
	public void eMailDispatchInput() {
		try {
			action = new Actions(driver);
			eMailDispatchInput.get(0).sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void passwordDispatchInput() {
		try {
			action = new Actions(driver);
			passwordDispatchInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eyeIconDispatchClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIconDispatch).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
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

	public void clickRidesSection() {
		try {
			ridesSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dispatchvechileAvailableSection);
			js.executeScript("window.scrollBy(0,50)", "");
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
					// Handling Feb month xpath issue:
					objTestBase.defaultWaitTime(1000);
					nextMonthArrow.click();
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
				driver.switchTo().window(currWindow);
				try {
					defaultWaitTime(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
			action.moveToElement(updateBtn).click().build().perform();
			objTestBase.defaultWaitTime(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyDispatchDoNotServeUpdateConfirmation(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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
			waitTimeForElement(warningMsg.get(0));
			if (dispatchwarningMsg.size() != 0) {
				if (dispatchwarningMsg.get(0).getText().toLowerCase()
						.contains("this trip can not be quoted at the moment"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else if (bookSedan.size() != 0) {
				waitTimeForElement(bookSedan.get(0));
				if (bookSedan.get(0).isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public void dispatchclickPricingSection() {
		try {
			dispatchpricingSection.click();
			objTestBase.defaultWaitTime(1000);
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

	public void verifyDispatchLogin() {
		try {
			Boolean visibilityStatus = false;
			if (eMailDispatchInput.size() != 0) {
				eMailDispatchInput();
				objTestBase.defaultWaitTime(1000);
				passwordDispatchInput();
				objTestBase.defaultWaitTime(1000);
				eyeIconDispatchClick();
				objTestBase.defaultWaitTime(1000);

				visibilityStatus = visibilitydispatchOfSigninButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					clickdispatchSigninButton();
					objTestBase.defaultWaitTime(3000);
					driver.navigate().refresh();
					objTestBase.closePopupWindow();
				}
				visibilityStatus = visibilityOfNewBookingPage(visibilityStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
