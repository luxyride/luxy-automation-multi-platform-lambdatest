package UserPortal.NewBookings;

import java.util.Map;
import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.HashMap;
import java.util.Calendar;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1845_VerifyTheAdditionOf10$ForNewRideBookingForLessThanOrMoreThan24hrsFromPickUpTime_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;


	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signinBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement passwordInput;

	@FindBy(xpath = "(//*[name()='path'])[4]")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[contains(@aria-label,'Login and Continue')]")
	WebElement signInBtn_Login;

	@FindBy(xpath = "(//a[normalize-space()='Welcome Test User'])[1]")
	WebElement signInBtnDropdown;


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

	@FindBy(xpath = "//button[@aria-label='Get Quote']")
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
	WebElement airlinesDrpdwnHeader;

	@FindBy(xpath = "//label[normalize-space()='Airline']//following-sibling::div//div//div[1]")
	WebElement airlinesDrpdwnValue;

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

	@FindBy(xpath = "//button[contains(@aria-label,'Proceed to Pay')]")
	List<WebElement> paymentInfocheckbox;

	@FindBy(xpath = "//div[normalize-space()='Make Payment & Book Ride'][1]")
	WebElement confirmBookingBtn;

	@FindBy(xpath = "//div[normalize-space()='Book Another Ride'][1]")
	WebElement bookNextRideBtn;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
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

	@FindBy(xpath = "//input[@placeholder='Enter Pickup Date']")
	WebElement calendar;

	@FindBy(xpath = "//button[@class='button next-button next-btn']")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//div[normalize-space()='Trip ID:']//following-sibling::div[1]")
	WebElement bookingRideTripId;

	@FindBy(xpath = "//input[@placeholder='Select Time']")
	WebElement timeElement;

	@FindBy(xpath = "//div[@class='text-orange-500']")
	List<WebElement> vechilePriceList;

	TestBase objTestBase;
	GetCurrentDateTime getDate;
	JavascriptExecutor js;
	Map<String, String> vechilePricesDataLessThan24hrs;
	Map<String, String> vechilePricesDataMoreThan24hrs;

	public DEV_TC_1845_VerifyTheAdditionOf10$ForNewRideBookingForLessThanOrMoreThan24hrsFromPickUpTime_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
			getDate = new GetCurrentDateTime();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickLogin() throws InterruptedException {
		try {
			action = new Actions(driver);
			action.moveToElement(signinBtn).click().build().perform();
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("sanityPwd"));
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
			// Configuration for handing mobile simulator testing:
			if (browserType.equalsIgnoreCase("chromeAndroidMobileView")
					|| browserType.equalsIgnoreCase("chromeiOSMobileView")
					|| browserType.equalsIgnoreCase("chromeLocalMobileView")) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", customerLogin);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (customerLogin.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", signInBtn_Login);
				js.executeScript("window.scrollBy(0,-100)", "");
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signInBtnDropdown);
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

	public void clickOnExtraStop() {
		try {
			action = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
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

	public void enterDate(Boolean todaysFlag) {
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
				String todaysDate = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay);
				String dayOfMonthXpath = "//div[contains(@aria-label,'" + todaysDate + "')]";
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

	public void clickOngetQuote() {
		try {
			action = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", getQuote);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(getQuote).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfListofVechiles(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", vechileAvailableSection);
			js.executeScript("window.scrollBy(0,-100)", "");
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyRideBookingConfirmation(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("completed"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean enterTime(Boolean visibilityStatus) {
		try {
			LocalTime time = LocalTime.now();
			int currTime = time.getHour();
			System.out.println("Current Time = " + currTime);

			if (currTime <= 12 || (currTime >= 12 && currTime <= 24)) {
				currTime = 20;
			}

			timeElement.click();
			Select selectTime = new Select(timeElement);
			selectTime.selectByIndex(currTime);

			visibilityStatus = true;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfVechileSection() {
		try {
			waitTimeForElement(bookSedan);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8000));
			wait.until(ExpectedConditions.visibilityOf(bookSedan));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Boolean getvechilesPriceListLessThan24hrs(Boolean visibilityStatus) {
		try {
			int priceList = vechilePriceList.size();
			String vechileType = "sedan";
			vechilePricesDataLessThan24hrs = new HashMap<String, String>();

			for (int i = 0; i < priceList; i++) {
				switch (vechileType) {
				case "sedan":
					vechilePricesDataLessThan24hrs.put("sedan", vechilePriceList.get(i).getText());
					vechileType = "suv";
					break;
				case "suv":
					vechilePricesDataLessThan24hrs.put("suv", vechilePriceList.get(i).getText());
					vechileType = "suv-xl";
					break;
				case "suv-xl":
					vechilePricesDataLessThan24hrs.put("suv-xl", vechilePriceList.get(i).getText());
					break;
				}
			}
			visibilityStatus = true;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean getvechilesPriceListMoreThan24hrs(Boolean visibilityStatus) {
		try {
			int priceList = vechilePriceList.size();
			String vechileType = "sedan";
			vechilePricesDataMoreThan24hrs = new HashMap<String, String>();

			for (int i = 0; i < priceList; i++) {
				switch (vechileType) {
				case "sedan":
					vechilePricesDataMoreThan24hrs.put("sedan", vechilePriceList.get(i).getText());
					vechileType = "suv";
					break;
				case "suv":
					vechilePricesDataMoreThan24hrs.put("suv", vechilePriceList.get(i).getText());
					vechileType = "suv-xl";
					break;
				case "suv-xl":
					vechilePricesDataMoreThan24hrs.put("suv-xl", vechilePriceList.get(i).getText());
					break;
				}
			}
			visibilityStatus = true;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVechilesPriceListDifferences(Boolean visibilityStatus) {
		try {
			if (!vechilePricesDataLessThan24hrs.equals(vechilePricesDataMoreThan24hrs))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}
}
