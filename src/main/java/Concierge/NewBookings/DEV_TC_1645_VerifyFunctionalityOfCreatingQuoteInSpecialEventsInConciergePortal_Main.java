package Concierge.NewBookings;

import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.Calendar;
import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1645_VerifyFunctionalityOfCreatingQuoteInSpecialEventsInConciergePortal_Main extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
	String msgText = "";
	TestBase objTestBase;

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

	@FindBy(xpath = "(//span[normalize-space()='Special Events'])[1]")
	WebElement specialEvents;

	@FindBy(xpath = "(//button[contains(text(),'Welcome')])[1]")
	WebElement welcomedropdown;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//h3[@class='PageHeading']")
	WebElement managePage;

	@FindBy(xpath = "(//a[normalize-space()='NEW QUOTE'])[1]")
	List<WebElement> createQuoteBtn;

	@FindBy(xpath = "(//a[normalize-space()='NEW QUOTE'])[1]")
	List<WebElement> createQuoteNewQuoteBtn;

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement calendar;

	@FindBy(xpath = "//button[text()='Next month']")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//th[@title='Action']")
	WebElement actionColumn;

	@FindBy(xpath = "//th[@title='Quote Number']")
	WebElement qouteColumn;

	@FindBy(xpath = "//th[@title='Pickup ']")
	WebElement pickupColumn;

	@FindBy(xpath = "//th[@title='Dropoff']")
	WebElement dropColumn;

	@FindBy(xpath = "//th[@title='Date']")
	WebElement dateColumn;

	@FindBy(xpath = "//th[@title='No of passengers']")
	WebElement passengerscolumn;

	@FindBy(xpath = "//select[@refs='hours']")
	WebElement numberOfHoursDrpdown;

	@FindBy(xpath = "(//a[normalize-space()='NEW QUOTE'])[1]")
	WebElement createQouteBtn;

	@FindBy(xpath = "//h4[@class='topText']")
	WebElement eventQoute;

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement dateInput;

	@FindBy(xpath = "//input[@placeholder='Pickup Address']")
	WebElement pickUpAddr;

	@FindBy(xpath = "//input[@placeholder='Dropoff Address']")
	WebElement dropOffAddr;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement eventType;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement hourlyOption;

	@FindBy(xpath = "//select[@refs='passengers']")
	WebElement passengerList;

	@FindBy(xpath = "//select[@refs='luggage']")
	WebElement luggageList;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement requestBtn;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alertMessage;

	@FindBy(xpath = "(//p[starts-with(text(),'Thank you')])//preceding-sibling::div//p")
	WebElement createdQuoteText;

	@FindBy(xpath = "//button[normalize-space()='HOME']")
	WebElement homeBtn;

	@FindBy(xpath = "//button[normalize-space()='REQUEST NEW QUOTE']")
	WebElement requestNewQouteBtn;

	@FindBy(xpath = "//p[starts-with(text(),'Thank you')]")
	WebElement quoteConfimationTextValidation1;

	@FindBy(xpath = "//p[contains(text(),'events@luxyride.com')]")
	WebElement quoteConfimationTextValidation2;

	@FindBy(xpath = "//p[contains(text(),' 555-555-5555')]")
	WebElement quoteConfimationTextValidation3;

	@FindBy(xpath = "//p[contains(text(),'24 - 28 hours')]")
	WebElement quoteConfimationTextValidation4;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchQuoteNumber;

	@FindBy(xpath = "//td[@tabindex='2']")
	List<WebElement> tableRowData;

	@FindBy(xpath = "(//i[@title='Cancel Event'])[1]")
	WebElement cancelQuoteIcon;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//*[text()='Cancelled']")
	List<WebElement> cancelledStatus;

	public DEV_TC_1645_VerifyFunctionalityOfCreatingQuoteInSpecialEventsInConciergePortal_Main(WebDriver driver) {
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

	public void clickOnSpecialEvents() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(specialEvents).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSpecialEvents(Boolean visibilityStatus) {
		try {
			if (specialEvents.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfManageSpecialEventsPageAndCreateBtn(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(createQuoteBtn.get(0)));

			if (displayStatus.isDisplayed() && managePage.isDisplayed())
				if (displayStatus.isDisplayed() && managePage.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyQuoteRegistrationPage(Boolean visibilityStatus) {
		try {
			if (createQuoteBtn.size() != 0)
				createQuoteBtn.get(0).click();
			else if (createQuoteNewQuoteBtn.size() != 0)
				createQuoteNewQuoteBtn.get(0).click();

			defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.contains("register"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean enterDate(Boolean visibilityStatus) {
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
					nextMonthArrow.click();
					objTestBase.defaultWaitTime(2000);
				}

				String nextMonthDate = nextMonth + "-" + currDay + "-" + currYear;
				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(nextMonthDate);
				cal.setTime(d);

				// Select NextMonth 30 as Static Date:
				String secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 30";
				secondDayOfNextMonth = secondDayOfNextMonth.replaceAll("[a-zA-Z]", "").trim();
				String dayOfMonthXpath = "//div[@class='react-datepicker__month']//following::div[contains(text(),'"
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

				String dayOfMonthXpath = "//div[@class='react-datepicker__month']//following::div[contains(text(),'"
						+ secondDayOfCurrMonth + "')]";

				List<WebElement> element = driver.findElements(By.xpath(dayOfMonthXpath));
				if (element.size() == 1)
					action.moveToElement(element.get(0)).click().build().perform();
				else
					action.moveToElement(element.get(1)).click().build().perform();
				objTestBase.defaultWaitTime(2000);
			}

			defaultWaitTime(1000);
			expected = calendar.getAttribute("value");
			defaultWaitTime(2000);
			if (expected != "")
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void selectPassengers() {
		try {
			action = new Actions(driver);
			action.moveToElement(passengerList).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			Select select = new Select(passengerList);
			select.selectByValue("4");
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectLuggage() {
		try {
			action = new Actions(driver);
			action.moveToElement(luggageList).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			Select select = new Select(luggageList);
			select.selectByValue("4");
			objTestBase.defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfRequestBtn(Boolean visibilityStatus) {
		try {
			if (requestBtn.isDisplayed() && cancelBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnHomeBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(homeBtn).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRequestNewQouteBtn(Boolean visibilityStatus) {
		try {
			if (requestNewQouteBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enterPickUpAddr() {
		try {
			action = new Actions(driver);
			pickUpAddr.sendKeys(prop.getProperty("zoneTypeStateFromAddress"));
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterDropOffAddr() {
		try {
			action = new Actions(driver);
			dropOffAddr.sendKeys(prop.getProperty("zoneTypeStateFromAddress"));
			objTestBase.defaultWaitTime(1000);
			for (int i = 0; i <= 4; i++)
				action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyEventTypeHourlyOption(Boolean visibilityStatus) {
		try {
			if (eventType.isEnabled() && hourlyOption.isEnabled()) {
				action = new Actions(driver);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(eventType).click().build().perform();
				objTestBase.defaultWaitTime(2000);

				objTestBase.defaultWaitTime(1000);
				action.moveToElement(hourlyOption).click().build().perform();
				objTestBase.defaultWaitTime(2000);

				if (numberOfHoursDrpdown.isDisplayed()) {
					Select select = new Select(numberOfHoursDrpdown);
					select.selectByValue("5");
					objTestBase.defaultWaitTime(1000);
					visibilityStatus = true;
				} else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfAlertMessage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(requestBtn).click().build().perform();
			objTestBase.defaultWaitTime(500);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessage));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				msgText = alertMessage.getText().toLowerCase();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus == true && msgText.contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public String visibilityOfCreatedQuoteConfirmationMsg(String quoteNumber) {
		try {
			if (createdQuoteText.isDisplayed() && quoteConfimationTextValidation1.isDisplayed()
					&& quoteConfimationTextValidation2.isDisplayed() && quoteConfimationTextValidation3.isDisplayed()
					&& quoteConfimationTextValidation4.isDisplayed()) {
				defaultWaitTime(1000);
				quoteNumber = createdQuoteText.getText();
				defaultWaitTime(2000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return quoteNumber;
	}

	public Boolean visibilityOfHomeBtn(Boolean visibilityStatus) {
		try {
			if (homeBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfCreatedQuoteFromManageSpecialEventsPage(Boolean visibilityStatus, String quoteNumber) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(searchQuoteNumber));
			if (displayStatus.isDisplayed()) {
				searchQuoteNumber.click();
				searchQuoteNumber.sendKeys(quoteNumber);
				defaultWaitTime(3000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				displayStatus = wait.until(ExpectedConditions.visibilityOf(tableRowData.get(0)));

				if (displayStatus.isDisplayed())
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

	public Boolean visibilityOfcancelQuoteConfirmationMsg(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (cancelQuoteIcon.isDisplayed()) {
				defaultWaitTime(1000);
				action.moveToElement(cancelQuoteIcon).click().build().perform();
				defaultWaitTime(3000);

				if (yesBtn.isDisplayed()) {
					action.moveToElement(yesBtn).click().build().perform();
					defaultWaitTime(500);

					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessage));
					if (displayStatus.isDisplayed()) {
						objTestBase.defaultWaitTime(500);
						msgText = alertMessage.getText().toLowerCase();
						visibilityStatus = true;
					} else
						visibilityStatus = false;
					objTestBase.defaultWaitTime(1000);
					if (visibilityStatus == true && msgText.contains("successfully") && cancelledStatus.size() != 0)
						visibilityStatus = true;
					else
						visibilityStatus = false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}
}