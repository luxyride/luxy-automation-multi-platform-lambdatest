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

public class DEV_TC_1445_VerifyAllowedVehiclesForTravelArrangersWhenEnrolledAsNewTravelAgent_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "//*[(text()='Travel Arranger')]")
	WebElement travelArragnerTab;

	@FindBy(xpath = "//*[text()='Enrolled Travel Arrangers']")
	WebElement enrolledTravelArrangers;

	@FindBy(xpath = "//*[text()='Available Travel Arrangers']")
	WebElement availableTravelArrangers;

	@FindBy(xpath = "//*[@placeholder='Search']")
	WebElement searchTravelArragner;

	@FindBy(xpath = "//*[@type='checkbox']")
	List<WebElement> enrollCheckbox;

	@FindBy(xpath = "(//a[normalize-space()='Enrolled Travel Arrangers'])[1]")
	WebElement enrolledTaBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//*[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//*[text()='There is no data to display']")
	WebElement nodataMessage;

	@FindBy(xpath = "//*[text()='Confirm Enrollment']")
	WebElement confirmEnrollmentPopup;

	@FindBy(xpath = "//*[@id='Sedan1']//following-sibling::label")
	List<WebElement> sedanCheckbox;

	@FindBy(xpath = "//*[@id='SUV2']//following-sibling::label")
	List<WebElement> suvCheckbox;

	String msgText;

	// Travel Agent Site:
	String testStatus;
	String scenario;
	String testStep;
	Boolean visibilityStatus;
	String screenshotPath;
	String exception;
	int indexCount = 1;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputTA;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputTA;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnTA;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUserTA;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbookingTA;

	@FindBy(xpath = "//input[@name='isConcierge']")
	WebElement corpToggleBtn;

	@FindBy(xpath = "//*[@name='conciergeUser']")
	WebElement conciergeUser;

	@FindBy(xpath = "//*[@placeholder='Pickup Address']")
	WebElement fromAddressTA;

	@FindBy(xpath = "//*[@placeholder='Drop Off Address']")
	WebElement toAddressTA;

	@FindBy(xpath = "//*[normalize-space()='Add Stops']")
	WebElement extraStopIconTA;

	@FindBy(xpath = "//*[@placeholder='Stop 1']")
	WebElement addextraStopTA;

	@FindBy(xpath = "//*[@class='MuiIconButton-label']//div")
	WebElement calendarTA;

	@FindBy(xpath = "//*[@id='date-picker-inline']")
	WebElement dateInputTA;

	@FindBy(xpath = "//*[normalize-space()='Get Quote']")
	WebElement getQuoteTA;

	@FindBy(xpath = "//*[normalize-space()='Choose Vehicle']//following-sibling::div[1]")
	List<WebElement> vechileAvailableSectionTA;

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

	@FindBy(xpath = "//*[contains(text(),'Sorry, this vehicle is not approved by corporate')]")
	WebElement vehicleUnallowedMsg;

	@FindBy(xpath = "//*[text()='No']")
	WebElement noBtn;

	@FindBy(xpath = "//*[(@title='Sedan') and normalize-space()='Sedan']")
	WebElement bookSedanTA;

	@FindBy(xpath = "(//*[@name='age'])[1]")
	WebElement airlinesDrpdwnHeaderTA;

	@FindBy(xpath = "//*[@placeholder='Flight Number']")
	WebElement flightNumberTA;

	@FindBy(xpath = "//*[@name='passengerNotes']")
	WebElement passengerNotesTA;

	@FindBy(xpath = "//*[@placeholder='Cardholder Name']")
	WebElement cardHolderNameTA;

	@FindBy(xpath = "//div[@aria-label='Paying with Card']")
	WebElement cardOptions;
	
	@FindBy(xpath = "//*[@name='credit-card-number']")
	WebElement cardHolderNumberTA;

	@FindBy(xpath = "//*[@name='expiration']")
	WebElement cardExpiryDateTA;

	@FindBy(xpath = "//*[@id='cvv']")
	WebElement cvvTA;

	@FindBy(xpath = "//*[@id='postal-code']")
	WebElement postalCodeTA;

	@FindBy(xpath = "//span[normalize-space()='Confirm Booking']")
	WebElement confirmBookingBtnTA;

	@FindBy(xpath = "(//*[text() = 'Rides'])[1]")
	WebElement ridesSectionTA;

	@FindBy(xpath = "(//*[text() = 'All'])[1]")
	WebElement ridesTabAllTA;

	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span)[1]")
	WebElement nextMonthArrowTA;

	@FindBy(xpath = "//*[(@role='alert')]")
	WebElement alertMessgeTA;

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
	WebElement loginBtnTA;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtnTA;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumberTA;

	@FindBy(xpath = "(//*[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubjectTA;

	@FindBy(xpath = "(//*[@type='text'])[4]")
	WebElement searchUserTA;

	@FindBy(xpath = "//*[@placeholder='First Name']")
	WebElement firstNameTA;

	LocalDate today;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;
	Date date;
	SimpleDateFormat formatDate;
	String currDate;

	TestBase objTestBase;

	public DEV_TC_1445_VerifyAllowedVehiclesForTravelArrangersWhenEnrolledAsNewTravelAgent_Main(WebDriver driver) {
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

	public void clickEyeIcon() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninButton(Boolean visibilityStatus) {
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

	public void clickSignInButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninUser(Boolean visibilityStatus) {
		try {
			expected = signinUser.getText();
			if (expected.toLowerCase().contains("welcome")) {
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickonTravelArrangerTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(travelArragnerTab).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyTravelArrangerPageLoaded(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("arranger")) {
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean unenrollTravelArrenger(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(searchTravelArragner).click().sendKeys(prop.getProperty("travelAgentEMail")).build()
					.perform();
			defaultWaitTime(5000);

			if (enrollCheckbox.size() != 0) {
				action.moveToElement(enrollCheckbox.get(0)).click().build().perform();
				defaultWaitTime(3000);

				action.moveToElement(yesBtn).click().build().perform();
				defaultWaitTime(1000);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
				if (displayStatus.isDisplayed()) {
					objTestBase.defaultWaitTime(500);
					msgText = alertMessge.getText().toLowerCase();
					visibilityStatus = true;
				} else
					visibilityStatus = false;
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus == true && msgText.contains("unenrolled"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
				System.out.println(msgText);
				objTestBase.defaultWaitTime(5000);

				if (visibilityStatus == true && nodataMessage.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean searchTravelArranger(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(searchTravelArragner).click().sendKeys(prop.getProperty("travelAgentEMail")).build()
					.perform();
			objTestBase.defaultWaitTime(5000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(3000);
			if (enrollCheckbox.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyConfirmEnrollementPopupDispay(Boolean visibilityStatus) {
		try {
			if (enrollCheckbox.size() != 0) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(enrollCheckbox.get(0)).click().build().perform();
				objTestBase.defaultWaitTime(3000);

				if (confirmEnrollmentPopup.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifySedanSUVVehicleSelection(Boolean visibilityStatus) {
		try {
			if (sedanCheckbox.size() != 0 && suvCheckbox.size() != 0) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(500);
				action.moveToElement(sedanCheckbox.get(0)).click().build().perform();
				objTestBase.defaultWaitTime(500);
				action.moveToElement(suvCheckbox.get(0)).click().build().perform();
				objTestBase.defaultWaitTime(500);

				if (yesBtn.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyEnrollTravelArrangerConfirmationMsgDisplay(Boolean visibilityStatus) {
		try {
			if (yesBtn.isDisplayed()) {
				action = new Actions(driver);
				action.moveToElement(yesBtn).click().build().perform();
				objTestBase.defaultWaitTime(500);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
				if (displayStatus.isDisplayed()) {
					objTestBase.defaultWaitTime(500);
					msgText = alertMessge.getText().toLowerCase();
					visibilityStatus = true;
				} else
					visibilityStatus = false;
				objTestBase.defaultWaitTime(1000);
				if (visibilityStatus == true && msgText.contains("enrolled"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
				System.out.println(msgText);
				objTestBase.defaultWaitTime(3000);
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	// Travel Agent Site Methods:
	public void eMailInputTA() {
		try {
			action = new Actions(driver);
			eMailInputTA.sendKeys(prop.getProperty("travelAgentEMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInputTA() {
		try {
			action = new Actions(driver);
			passwordInputTA.sendKeys(prop.getProperty("travelAgentPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonTA(Boolean visibilityStatus) {
		try {
			if (signInBtnTA.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonTA() {
		try {
			signInBtnTA.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBookingTA() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbookingTA).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserTA(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUserTA);
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

	public Boolean searchCoporateTA(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(corpToggleBtn).click().build().perform();
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(conciergeUser).click().sendKeys(prop.getProperty("taCorporateEMail")).build()
					.perform();
			objTestBase.defaultWaitTime(5000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(3000);
			expected = conciergeUser.getAttribute("value"); // searchPassenger
			if (expected.toLowerCase().contains("qa"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilitOfNewBookingTabTA(Boolean visibilityStatus) {
		try {
			if (newbookingTA.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void addFromAddressTA() {
		try {
			action = new Actions(driver);
			fromAddressTA.click();
			objTestBase.defaultWaitTime(1000);
			fromAddressTA.sendKeys(Keys.CONTROL + "A");
			fromAddressTA.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			fromAddressTA.sendKeys(prop.getProperty("fromAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addToAddressTA() {
		try {
			action = new Actions(driver);
			toAddressTA.sendKeys(prop.getProperty("toAddress"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnExtraStopTA() {
		try {
			action = new Actions(driver);
			action.moveToElement(extraStopIconTA).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addExtraStopTA() {
		try {
			action = new Actions(driver);
			addextraStopTA.sendKeys(prop.getProperty("extraStop"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDateTA() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(calendarTA).click().build().perform();
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
				nextMonthArrowTA.click();
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

	public Boolean visibilityOfVechileSectionTA(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(2000);
			if (vechileAvailableSectionTA.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			visibilityStatus = false;
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfUnallowedVehiclesPopupMsg(Boolean visibilityStatus, String vehicleType) {
		try {
			objTestBase.defaultWaitTime(1000);
			action = new Actions(driver);
			System.out.println(vechileAvailableSectionTA.size());
			if (vechileAvailableSectionTA.size() != 0) {
				if (vehicleType == "SUV-XL") {
					action.moveToElement(bookSUVXL).click().build().perform();
					objTestBase.defaultWaitTime(1000);
				} else if (vehicleType == "VAN") {
					action.moveToElement(bookVAN).click().build().perform();
					objTestBase.defaultWaitTime(1000);
				} else if (vehicleType == "VAN-XL") {
					action.moveToElement(bookVANXL).click().build().perform();
					objTestBase.defaultWaitTime(1000);
				}
				objTestBase.defaultWaitTime(1000);
				if (vehicleUnallowedMsg.isDisplayed()) {
					action.moveToElement(noBtn).click().build().perform();
					visibilityStatus = true;
				} else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			visibilityStatus = false;
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOngetQuoteTA() {
		try {
			action = new Actions(driver);
			action.moveToElement(getQuoteTA).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSedanTA() {
		try {
			action = new Actions(driver);
			action.moveToElement(bookSedanTA).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonConfirmBooking() {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmBookingBtnTA).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickRidesSectionTA() {
		try {
			ridesSectionTA.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addAirlineTA() {
		try {
			action = new Actions(driver);
			airlinesDrpdwnHeaderTA.click();
			objTestBase.defaultWaitTime(1000);
			Select select = new Select(airlinesDrpdwnHeaderTA);
			select.selectByValue(prop.getProperty("airlineInput"));
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFlightNumberTA() {
		try {
			flightNumberTA.sendKeys(prop.getProperty("flightNumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPassengerNotes() {
		try {
			passengerNotesTA.sendKeys(prop.getProperty("pasengerNotes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyRideBookingConfirmationTA(Boolean visibilityStatus) {
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

	public Boolean verifyConfirmBookingBtnVisibilityTA(Boolean visibilityStatus) {
		try {
			if (confirmBookingBtnTA.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enterPaymentInformationTA() throws Exception {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);

			cardOptions.click();
			objTestBase.defaultWaitTime(2000);
			
			driver.switchTo().frame("braintree-hosted-field-cardholderName");
			cardHolderNameTA.sendKeys(prop.getProperty("walletcardHolderName"));
			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();


			// SwitchTo CardNumber Frame
			driver.switchTo().frame("braintree-hosted-field-number");
			cardHolderNumberTA.click();
			cardHolderNumberTA.sendKeys(prop.getProperty("walletcardNumber"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Expiry Date
			driver.switchTo().frame("braintree-hosted-field-expirationDate");
			cardExpiryDateTA.click();
			String expiryDate = GetCurrentDateTime.getMonthYear(expected, "addCard");
			action.moveToElement(cardExpiryDateTA).click().sendKeys(expiryDate).perform();

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo CVV
			driver.switchTo().frame("braintree-hosted-field-cvv");
			cvvTA.click();
			cvvTA.sendKeys(prop.getProperty("walletCVV"));

			objTestBase.defaultWaitTime(1000);
			driver.switchTo().defaultContent();

			// SwitchTo Postal Code:
			driver.switchTo().frame("braintree-hosted-field-postalCode");
			postalCodeTA.click();
			postalCodeTA.sendKeys(prop.getProperty("walletPostalCode"));
			objTestBase.defaultWaitTime(1000);

			// SwitchBackTo Default Frame
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String captureRideBookingIDsTA(Boolean visibilityStatus, String scenario, String tripID) {
		try {
			action = new Actions(driver);
			ridesTabAllTA.click();
			objTestBase.defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all")) {
				objTestBase.defaultWaitTime(5000);
				action.moveToElement(searchUserTA).click().sendKeys(prop.getProperty("taCorporateEMail")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(1000);

				if (bookingRideTripIdTA.isDisplayed()
						&& !rideBookingIdsTravelAgent.containsValue(bookingRideTripIdTA.getText())) {
					System.out.println(rideStatusTA.getText().toLowerCase());
					System.out.println(bookedPassengerNameTA.getText().toLowerCase());
					System.out.println(ridePlaceDateTimeTA.getText().toLowerCase());
					System.out.println(bookingRideTripIdTA.getText());

					// Get the CurrentDate:
					currDate = getCurrDateTA(currDate);

					if ((!rideStatusTA.getText().toLowerCase().contains("cancelled")
							|| !rideStatusTA.getText().toLowerCase().contains("completed"))
							&& bookedPassengerNameTA.getText().toLowerCase().contains("automation")
							&& ridePlaceDateTimeTA.getText().toLowerCase().contains(currDate))// 06-27-2023 12:00 AM
					{
						objTestBase.defaultWaitTime(1000);
						rideBookingIdsConcierge.put(vehicleTypeTA.getText().toLowerCase(),
								bookingRideTripIdTA.getText().toString());
						objTestBase.defaultWaitTime(500);
						tripID = bookingRideTripIdTA.getText().toString();
						objTestBase.defaultWaitTime(1000);
					}
					utillLogger.info(
							"DEV_TC_1152_VerifyNewBookingFunctionalityInTravelAgentSite_Main - Capture the Trip ID = "
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

	private String getCurrDateTA(String currDate) {
		try {
			date = new Date();
			formatDate = new SimpleDateFormat("MM-dd-yyyy");
			currDate = formatDate.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return currDate;
	}

	public void enterFirstNameTA() {
		try {
			action = new Actions(driver);
			firstNameTA.click();
			objTestBase.defaultWaitTime(1000);
			firstNameTA.sendKeys(prop.getProperty("taCorporateEMail"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickEnrolledTa() {
		try {
			enrolledTaBtn.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
