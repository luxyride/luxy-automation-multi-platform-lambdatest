package Dispatch.Pricing.Promocode;

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

public class DEV_TC_492_VerifytheCreationOfPromoCodeForMultipleUses_Main extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
	WebDriverWait wait;
	WebElement displayStatus;
	LocalDate today;
	Select selectAMPMDrpdwn;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailDispatchInput;

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

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement dispatchsignInBtnDropdown;

	@FindBy(xpath = "(//span[normalize-space()='Pricing'])[1]")
	WebElement dispatchpricingSection;

	@FindBy(xpath = "(//span[normalize-space()='Promo Code'])[1]")
	WebElement dispatchPromocodeTab;

	@FindBy(xpath = "//a[normalize-space()='Add Promo Code']")
	WebElement dispatchAddPromocodeBtn;

	@FindBy(xpath = "//h4[@class='topText' and contains(normalize-space(),'Add Promo Code')]")
	WebElement dispatchAddPromocodeHeader;

	@FindBy(xpath = "//label[@for='extra_services']")
	WebElement dispatchOneTimeUseOnlychckbox;

	@FindBy(xpath = "//label[@for='rFixed']//span[@class='checkmark']")
	WebElement dispatchFixedchckbox;

	@FindBy(xpath = "//div[@class='Fixedage' and contains(normalize-space(),'Fixed amount')]")
	WebElement dispatchFixedAmountLbl;

	@FindBy(xpath = "//label[contains(normalize-space(),'Name')]//following::input[1]")
	WebElement dispatchPromocodeName;

	@FindBy(xpath = "//div[@class='Fixedage' and contains(normalize-space(),'Fixed amount')]//input")
	WebElement dispatchFixedAmountInput;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'Max uses per user')]//following::input[1]")
	WebElement dispatchMaxUsesPerUserInput;

	@FindBy(xpath = "//button[normalize-space()='Next month']")
	WebElement dispatchnextMonthArrow;

	@FindBy(xpath = "(//input[@placeholder='MM-DD-YYYY'])[1]")
	WebElement calStartingDate;

	@FindBy(xpath = "(//input[@placeholder='MM-DD-YYYY'])[2]")
	WebElement calExpirationDate;

	@FindBy(xpath = "(//input[@name='hour12'])[1]")
	WebElement calStartingHours;

	@FindBy(xpath = "(//input[@name='hour12'])[2]")
	WebElement calExpirationHours;

	@FindBy(xpath = "(//input[@name='minute'])[1]")
	WebElement calStartingMinute;

	@FindBy(xpath = "(//input[@name='minute'])[2]")
	WebElement calExpirationMinute;

	@FindBy(xpath = "(//select[@name='amPm'])[1]")
	WebElement calStartingHoursFormat;

	@FindBy(xpath = "(//select[@name='amPm'])[2]")
	WebElement calExpirationHoursFormat;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchPromocodeSaveBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchPromocodeSearch;

	@FindBy(xpath = "//i[@title='Delete Promo Code']")
	WebElement dispatchPromocodeDeleteBtn;

	@FindBy(xpath = "//h1[normalize-space()='Delete Promo Code']//following::div//button[2]")
	WebElement dispatchPromocodeDeleteConf;

	@FindBy(xpath = "(//*[normalize-space()='There is no data to display'])[1]")
	WebElement dispatchPromocodeDeleteConfMsg;

	TestBase objTestBase;

	public DEV_TC_492_VerifytheCreationOfPromoCodeForMultipleUses_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eMailDispatchInput() {
		try {
			action = new Actions(driver);
			eMailDispatchInput.sendKeys(prop.getProperty("dispatchadminMail"));
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

	public void clickRidesSection() {
		try {
			ridesSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public Boolean dispatchvisibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			if (dispatchsignInBtnDropdown.isDisplayed()) {
				expected = dispatchsignInBtnDropdown.getText();
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

	public void dispatchclickPricingSection() {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchpricingSection).click().build().perform();
			for (int i = 1; i <= 6; i++) {
				action.sendKeys(Keys.DOWN).build().perform();
			}
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchvisibilityOfPromocodeTabPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeTab).click().build().perform();
			objTestBase.defaultWaitTime(5000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchAddPromocodeBtn));
			if (displayStatus.isDisplayed()) {
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("managepromocode"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean dispatchvisibilityOfAddPromocodePage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchAddPromocodeBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchAddPromocodeHeader));
			if (displayStatus.isDisplayed()) {
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("addpromocode"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean dispatchDeselectPromocodeAndSelectFixed(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchOneTimeUseOnlychckbox).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(dispatchFixedchckbox).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchFixedAmountLbl));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean dispatchEnterAllReqDetailsPromoFixed(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeName).click().sendKeys(prop.getProperty("promoCodeNameFixed")).build()
					.perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(dispatchFixedAmountInput).click().sendKeys(prop.getProperty("FixedAmount")).build()
					.perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(dispatchMaxUsesPerUserInput).click().sendKeys(prop.getProperty("maxUsesPerUser"))
					.build().perform();
			objTestBase.defaultWaitTime(500);

			action.moveToElement(calStartingDate).click().build().perform();
			objTestBase.defaultWaitTime(500);
			dispatchenterDate("startingDate");
			objTestBase.defaultWaitTime(500);
			action.moveToElement(calExpirationDate).click().build().perform();
			objTestBase.defaultWaitTime(500);
			dispatchenterDate("expirationDate");
			objTestBase.defaultWaitTime(500);

			action.moveToElement(calStartingHours).click().sendKeys(prop.getProperty("calStartingHours")).build()
					.perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(calStartingMinute).click().sendKeys(prop.getProperty("calStartingMinute")).build()
					.perform();
			objTestBase.defaultWaitTime(500);

			calStartingHoursFormat.click();
			selectAMPMDrpdwn = new Select(calStartingHoursFormat);
			selectAMPMDrpdwn.selectByValue(prop.getProperty("calStartingHoursFormat"));
			objTestBase.defaultWaitTime(1000);

			action.moveToElement(calExpirationHours).click().sendKeys(prop.getProperty("calExpirationHours")).build()
					.perform();
			objTestBase.defaultWaitTime(500);
			action.moveToElement(calExpirationMinute).click().sendKeys(prop.getProperty("calExpirationMinute")).build()
					.perform();
			objTestBase.defaultWaitTime(500);

			calExpirationHoursFormat.click();
			selectAMPMDrpdwn = new Select(calExpirationHoursFormat);
			selectAMPMDrpdwn.selectByValue(prop.getProperty("calExpirationHoursFormat"));
			objTestBase.defaultWaitTime(1000);

			if (dispatchAddPromocodeHeader.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void dispatchenterDate(String dateType) {
		try {
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
				if (dateType == "startingDate")
					calStartingDate.click();
				else
					calExpirationDate.click();

				objTestBase.defaultWaitTime(2000);
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

					//-----------------------------------------------------------------------------------
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
					//-----------------------------------------------------------------------------------
				}

				String nextMonthDate = nextMonth + "-" + currDay + "-" + currYear;
				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(nextMonthDate);
				cal.setTime(d);

				String secondDayOfNextMonth;
				if (dateType == "startingDate")
					secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 2";
				else
					secondDayOfNextMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " 4";

				String[] tempVal = secondDayOfNextMonth.split(" ");
				tempVal[0] = "day";
				String dayOfMonthXpath = "(//div[contains(@aria-label,'" + tempVal[0] + "-" + tempVal[1] + "')])[1]";

				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			}
			// Select Date of 2 days after based on Current Date:
			else {
				String currDate = currMonth + "-" + currDay + "-" + currYear;

				Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(currDate);
				cal.setTime(d);

				// Select 2 days after Current Date:
				String secondDayOfCurrMonth;
				if (dateType == "startingDate")
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 2);
				else
					secondDayOfCurrMonth = new SimpleDateFormat("MMMM").format(cal.getTime()) + " " + (currDay + 4);

				String[] tempVal = secondDayOfCurrMonth.split(" ");
				tempVal[0] = "day";
				String dayOfMonthXpath = "(//div[contains(@aria-label,'" + tempVal[0] + "-" + tempVal[1] + "')])[1]";

				driver.findElement(By.xpath(dayOfMonthXpath)).click();
				objTestBase.defaultWaitTime(2000);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchVerifyCreationOfPromocodeFixed(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeSaveBtn).click().build().perform();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

	public Boolean dispatchDeletionOfPromocode(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchPromocodeSearch).click().build().perform();
			action.moveToElement(dispatchPromocodeSearch).click().sendKeys(prop.getProperty("promoCodeNameFixed"))
					.build().perform();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchPromocodeDeleteBtn));

			if (displayStatus.isDisplayed()) {
				action.moveToElement(dispatchPromocodeDeleteBtn).click().build().perform();
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(dispatchPromocodeDeleteConf).click().build().perform();
				objTestBase.defaultWaitTime(1000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
				objTestBase.defaultWaitTime(1000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatchPromocodeDeleteConfMsg));

				if (displayStatus.isDisplayed())
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
}
