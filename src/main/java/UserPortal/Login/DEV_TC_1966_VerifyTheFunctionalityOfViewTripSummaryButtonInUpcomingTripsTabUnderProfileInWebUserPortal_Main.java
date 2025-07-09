package UserPortal.Login;

import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.Calendar;
import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1966_VerifyTheFunctionalityOfViewTripSummaryButtonInUpcomingTripsTabUnderProfileInWebUserPortal_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//div[@class='choices__inner']")
	WebElement individual;

	@FindBy(xpath = "(//a[normalize-space()='sign in'])[1]")
	WebElement signinBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "(//*[normalize-space()='sign in'])[1]")
	WebElement signinBtnNormalView;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[1]")
	WebElement customerLoginNorvmalView;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement passwordInput;

	@FindBy(xpath = "(//*[name()='path'])[4]")
	WebElement eyeIcon;

	@FindBy(xpath = "(//button[contains(@class,'pointer-events-auto')])[2]")
	WebElement closeBtnSimulatorView;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement loginAndContinue;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "(//a[normalize-space()='Logout'])[2]")
	WebElement logoutBtn;

	@FindBy(xpath = "//input[@placeholder='Enter Pickup Location']")
	WebElement fromAddress;

	@FindBy(xpath = "//input[@placeholder='Enter dropoff Location']")
	WebElement toAddress;

	@FindBy(xpath = "//div[@class='flex items-center gap-x-2']")
	WebElement extraStopIcon;

	@FindBy(xpath = "//input[@placeholder='Enter Stop 1 Location']")
	WebElement addextraStop;

	@FindBy(xpath = "//input[@placeholder='Enter Pickup Date']")
	WebElement dateInput;

	@FindBy(xpath = "//div[normalize-space()='Get Quote'][2]")
	WebElement getQuote;

	@FindBy(xpath = "(//div[@class='rounded-2xl p-4 border border-orange-100 bg-white gap-y-8 flex flex-col animate-[fadeIn_1s]'])[1]")
	WebElement vechileAvailableSection;

	@FindBy(xpath = "//div[normalize-space()='LOOKING FOR OTHER CAR OPTIONS?']")
	List<WebElement> vechileAvailableList;

	@FindBy(xpath = "//div[normalize-space()='Sedan']")
	WebElement bookSedan;

	@FindBy(xpath = "//*[text()='Confirm your vehicle']")
	List<WebElement> confirmVehiclePopup;

	@FindBy(xpath = "//button[text()='Confirm']")
	List<WebElement> confirmBtn;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='SUV']")
	WebElement bookSUV;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='SUV-XL']")
	WebElement bookSUVXL;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='Van']")
	WebElement bookVAN;

	@FindBy(xpath = "//div[@class='vehicle-name vehicle-name-bold'][normalize-space()='Van-XL']")
	WebElement bookVANXL;

	@FindBy(xpath = "//button[contains(@aria-label,'Add Secondary Passenger')]")
	WebElement secondaryPassenger;

	@FindBy(xpath = "(//input[@id='fname'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@id='fname'])[2]")
	WebElement lastName;

	@FindBy(xpath = "(//input[@type='tel'])")
	WebElement mobileInput;

	@FindBy(xpath = "(//input[@id='fname'])[3]")
	WebElement emailInput;

	@FindBy(xpath = "(//input[@id='fname'])[4]")
	WebElement spFirstName;

	@FindBy(xpath = "(//input[@id='fname'])[5]")
	WebElement spLastName;

	@FindBy(xpath = "(//input[@type='tel'])[2]")
	WebElement spMobile;

	@FindBy(xpath = "(//input[@id='fname'])[6]")
	WebElement spEmail;

	@FindBy(xpath = "//div[@class='choices__inner']")
	WebElement airlinesDrpdwn;

	@FindBy(xpath = "(//input[@placeholder='Enter Flight Number'])")
	WebElement flightNumber;

	@FindBy(xpath = "//textarea[@id='passenger_notes']")
	WebElement passengerNotes;

	@FindBy(xpath = "//*[normalize-space()='Personal Travel']")
	WebElement bookingForPersonal;

	@FindBy(xpath = "//input[@value='Business']")
	WebElement bookingForBusiness;

	@FindBy(xpath = "//div[@class='custom-control custom-switch ']")
	WebElement promoCodeEnable;

	@FindBy(xpath = "//input[@id='promoCode']")
	WebElement promoCode;

	@FindBy(xpath = "//button[@class='btn btn-small customized-button']")
	WebElement applypromoCode;

	@FindBy(xpath = "//button[@aria-label='Proceed to Pay']")
	WebElement paymentInfocheckbox;

	@FindBy(xpath = "//div[normalize-space()='Make Payment & Book Ride'][1]")
	WebElement confirmBookingBtn;

	@FindBy(xpath = "(//div[@class='relative h-4 w-4 rounded-full bg-white items-start checkbox border border-orange-300'])[2]")
	WebElement termsAndConditionsCheckbox;

	@FindBy(xpath = "//div[normalize-space()='Book Another Ride'][1]")
	WebElement bookNextRideBtn;

	@FindBy(xpath = "(//div[normalize-space()='Card'])[2]")
	WebElement cardPaymentType;

	@FindBy(xpath = "(//div[normalize-space()='Card'])[1]")
	WebElement dateNextMonth;

	@FindBy(xpath = "//input[@id='cardholder-name']")
	WebElement cardHolderName;

	@FindBy(xpath = "//input[@id='credit-card-number']")
	WebElement cardHolderNumber;

	@FindBy(xpath = "//input[@id='expiration']")
	WebElement cardExpiryDate;

	@FindBy(xpath = "//input[@id='cvv']")
	WebElement cvv;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement calendar;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//div[normalize-space()='Trip ID:']//following-sibling::div[1]")
	WebElement bookingRideTripId;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement welcomeDropDown;

	@FindBy(xpath = "(//div[normalize-space()='My Ride Bookings'])[1]")
	WebElement myRideBookings;

	@FindBy(xpath = "(//button[normalize-space()='Upcoming trips'])[1]")
	WebElement upComingTripsPage;

	@FindBy(xpath = "(//a[@label='Profile'])[1]")
	WebElement profileOption;

	@FindBy(xpath = "(//button[@value='View Trip Summary'])[1]")
	WebElement tripSummary;

	@FindBy(xpath = "(//button[normalize-space()='close'])[1]")
	WebElement closeBtn;

	TestBase objTestBase;
	GetCurrentDateTime getDate;
	JavascriptExecutor js;
	LocalDate today;

	public DEV_TC_1966_VerifyTheFunctionalityOfViewTripSummaryButtonInUpcomingTripsTabUnderProfileInWebUserPortal_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
			getDate = new GetCurrentDateTime();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addFromAddress() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", fromAddress);
			js.executeScript("window.scrollBy(0,-100)", "");
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", toAddress);
			js.executeScript("window.scrollBy(0,-100)", "");
			toAddress.sendKeys(prop.getProperty("toAddress"));
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(toAddress).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSignInNormalView() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtnNormalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signinBtnNormalView).click().build().perform();
			action.moveToElement(signinBtn).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnCustomerLogin() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
			js.executeScript("window.scrollBy(0,-100)", "");
			driver.findElement(By.linkText("Customer Login")).click();
			defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnExtraStop() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", extraStopIcon);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(extraStopIcon).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addExtraStop() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", addextraStop);
			js.executeScript("window.scrollBy(0,-100)", "");
			addextraStop.sendKeys(prop.getProperty("extraStop"));
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(addextraStop).click().build().perform();
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
			objTestBase.defaultWaitTime(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(By.xpath("//input[@placeholder='Enter Pickup Date']")));
			js.executeScript("window.scrollBy(0,-100)", "");
			driver.findElement(By.xpath("//input[@placeholder='Enter Pickup Date']")).click();
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
//				calendar.click();
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
				String secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 2);
				secondDayOfCurrMonth = secondDayOfCurrMonth.replaceAll("[^0-9]", "");
				String dayOfMonthXpath = "//div[text()='" + secondDayOfCurrMonth + "']";
				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyVisibilityOfPaymentInfo(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", paymentInfocheckbox);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (paymentInfocheckbox.isDisplayed()) {
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enablePaymentInfo() {
		try {
			defaultWaitTime(1000);
			for (int i = 0; i <= 6; i++) {
				action.sendKeys(Keys.TAB).build().perform();
				defaultWaitTime(500);
			}
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", paymentInfocheckbox);
			js.executeScript("window.scrollBy(0,2000)", "");
			js.executeScript("window.scrollBy(0,-500)", "");
			paymentInfocheckbox.click();
			defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOngetQuote() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", getQuote);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(getQuote).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSedan() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", getQuote);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(bookSedan).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyVehicleConfirmationPopup(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", confirmVehiclePopup.get(0));
			js.executeScript("window.scrollBy(0,-100)", "");
			if (confirmVehiclePopup.size() != 0) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickonConfirmPopup() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", confirmBtn.get(0));
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(confirmBtn.get(0)).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSUV() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookSUV);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(bookSUV).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSUVXL() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookSUVXL);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(bookSUVXL).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnVAN() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookVAN);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(bookVAN).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnVANXL() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookVANXL);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(bookVANXL).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonPromocodeApply() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", applypromoCode);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(applypromoCode).click().build().perform();
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", termsAndConditionsCheckbox);
			js.executeScript("window.scrollBy(0,-100)", "");
			termsAndConditionsCheckbox.click();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(confirmBookingBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonBookNextRide() {
		try {
			waitTimeForElement(bookNextRideBtn);
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookNextRideBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(bookNextRideBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void promoCodeEnable() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", promoCodeEnable);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(promoCodeEnable).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspFirstName() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spFirstName);
			js.executeScript("window.scrollBy(0,-100)", "");
			spFirstName.sendKeys(prop.getProperty("spFirstName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspLastName() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spLastName);
			js.executeScript("window.scrollBy(0,-100)", "");
			spLastName.sendKeys(prop.getProperty("spLastName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspEmail() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spEmail);
			js.executeScript("window.scrollBy(0,-100)", "");
			spEmail.sendKeys(prop.getProperty("spEmail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterspMobile() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", spMobile);
			js.executeScript("window.scrollBy(0,-100)", "");
			spMobile.sendKeys(prop.getProperty("spMobile"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAirline() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", flightNumber);
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(airlinesDrpdwn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.DOWN).build().perform();
			action.sendKeys(Keys.DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFlightNumber() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", flightNumber);
			js.executeScript("window.scrollBy(0,-100)", "");
			flightNumber.sendKeys(prop.getProperty("flightNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPassengerNotes() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", passengerNotes);
			js.executeScript("window.scrollBy(0,-100)", "");
			passengerNotes.sendKeys(prop.getProperty("pasengerNotes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPromocode(String vechileModel) {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", promoCode);
			js.executeScript("window.scrollBy(0,-100)", "");
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

	public Boolean visibilityOfListofVechiles(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", vechileAvailableSection);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (vechileAvailableSection.isDisplayed()) {
				expected = vechileAvailableSection.getText();
				if (expected.toUpperCase().contains("OPTIONS") && vechileAvailableList.size() != 0) {
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

	public void enterPaymentInformation() throws Exception {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);

			js = (JavascriptExecutor) driver;
			objTestBase.defaultWaitTime(1000);
			js.executeScript("window.scrollBy(0,700)", "");
			objTestBase.defaultWaitTime(1000);
			js.executeScript("arguments[0].scrollIntoView(true);", cardPaymentType);
			objTestBase.defaultWaitTime(1000);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(cardPaymentType).click().build().perform();
			objTestBase.defaultWaitTime(5000);

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();
			// SwitchTo CardHolder Frame
			driver.switchTo().frame("braintree-hosted-field-cardholderName");
			js.executeScript("arguments[0].scrollIntoView(true);", cardHolderName);
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

			// SwitchTo Expire Date:
			driver.switchTo().frame("braintree-hosted-field-expirationDate");
			cardExpiryDate.click();
			objTestBase.defaultWaitTime(1000);
			String expiryDate = GetCurrentDateTime.getMonthYear(expected, "addCard");
			action.moveToElement(cardExpiryDate).click().sendKeys(expiryDate).perform();

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo CVV:
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

	public Boolean verifyBookingForPersonalSelected(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookingForPersonal);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (bookingForPersonal.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(bookingRideTripId));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookingRideTripId);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (displayStatus.isDisplayed())
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", confirmBookingBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (confirmBookingBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfVechileSection(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookSedan);
			js.executeScript("window.scrollBy(0,-100)", "");
			waitTimeForElement(bookSedan);
			visibilityStatus = true;
		} catch (Exception e) {
			visibilityStatus = false;
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public String captureRideBookingIDs(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bookingRideTripId);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (bookingRideTripId.isDisplayed() && !rideBookingIds.containsValue(bookingRideTripId.getText())) {
				if (scenario == "Book Sedan") {
					rideBookingIds.put("sedan", bookingRideTripId.getText().toString());
				} else if (scenario == "Book SUV") {
					rideBookingIds.put("suv", bookingRideTripId.getText().toString());
				} else if (scenario == "Book SUVXL") {
					rideBookingIds.put("suvxl", bookingRideTripId.getText().toString());
				} else if (scenario == "Book VAN") {
					rideBookingIds.put("van", bookingRideTripId.getText().toString());
				} else if (scenario == "Book VANXL") {
					rideBookingIds.put("vanxl", bookingRideTripId.getText().toString());
				}
				tripID = bookingRideTripId.getText().toString();
				utillLogger.info("Capture Trip IDs: DEV_TC_58_VerificationOfNewBooking_Main = " + " - " + scenario
						+ " - " + tripID);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tripID;
	}

	public void selectDropdown() {
		try {
			action = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", individual);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(individual).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnSecondaryPassenger() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", secondaryPassenger);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(secondaryPassenger).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFirstName() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", firstName);
			js.executeScript("window.scrollBy(0,-100)", "");
			firstName.sendKeys(prop.getProperty("fName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterLastName() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", lastName);
			js.executeScript("window.scrollBy(0,-100)", "");
			lastName.sendKeys(prop.getProperty("lName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterEmail() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", emailInput);
			js.executeScript("window.scrollBy(0,-100)", "");
			emailInput.sendKeys(prop.getProperty("primaryEmail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterMobile() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", mobileInput);
			js.executeScript("window.scrollBy(0,-100)", "");
			mobileInput.sendKeys(prop.getProperty("phoneNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSignIn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signinBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signinBtn).click().build().perform();
			defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfDropDown(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (customerLogin.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOncustomerLogin() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", customerLoginNorvmalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(customerLoginNorvmalView).click().build().perform();
			defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eMailInput);
			js.executeScript("window.scrollBy(0,-100)", "");
			eMailInput.sendKeys(prop.getProperty("sanityeMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", passwordInput);
			js.executeScript("window.scrollBy(0,-100)", "");
			passwordInput.sendKeys(prop.getProperty("sanityPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eyeIconClick() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eyeIcon);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoginAndContinueBtn(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", loginAndContinue);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (loginAndContinue.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", customerLoginNorvmalView);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (customerLoginNorvmalView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", loginAndContinue);
				if (loginAndContinue.isDisplayed())
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", loginAndContinue);
			js.executeScript("window.scrollBy(0,-400)", "");
			loginAndContinue.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				clickOn3HorizontalToggleNavigationBar(); // Click on 3 Lines Navigation Bar:
				visibilityStatus = visibilityOfLogoutButton(visibilityStatus);
				if (visibilityStatus.booleanValue() == true) {
					if (closeBtnSimulatorView.isDisplayed())
						closeBtnSimulatorView.click();
					defaultWaitTime(3000);
				}
			} else {
				waitTimeForElement(signInBtnDropdown);
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", signInBtnDropdown);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (signInBtnDropdown.isDisplayed()) {
					expected = signInBtnDropdown.getText();
					if (expected.toLowerCase().contains("welcome"))
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfLogoutButton(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", logoutBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (logoutBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickWelcomeDropDown() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", welcomeDropDown);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(welcomeDropDown).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfProfileOption(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", profileOption);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (profileOption.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnProfileOption() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", profileOption);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(profileOption).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnMyRideBookings() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", myRideBookings);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(myRideBookings).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfMyRideBookingsPage(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", upComingTripsPage);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (upComingTripsPage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfTripSummaryBtn(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", tripSummary);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (tripSummary.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnTripSummary() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", tripSummary);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(tripSummary).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfTripSummaryPage(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", closeBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (closeBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnCloseBtn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", closeBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(closeBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}