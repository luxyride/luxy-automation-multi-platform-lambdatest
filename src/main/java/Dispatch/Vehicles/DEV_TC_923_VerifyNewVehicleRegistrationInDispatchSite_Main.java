package Dispatch.Vehicles;

import java.awt.Robot;
import java.util.Date;
import java.util.List;

import common.GetCurrentDateTime;
import common.TestBase;
import java.awt.Toolkit;
import java.util.Locale;
import java.time.Duration;
import java.util.Calendar;
import java.time.LocalDate;
import java.awt.AWTException;
import org.openqa.selenium.By;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.datatransfer.Clipboard;
import org.openqa.selenium.support.FindBy;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_923_VerifyNewVehicleRegistrationInDispatchSite_Main extends TestBase {

	String tempVal;
	Actions action;
	String fileName;
	String currYear;
	String expected;
	WebDriver driver;
	TestBase objTestBase;
	Clipboard clipboard;
	StringSelection stringSelection;

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

	@FindBy(xpath = "(//span[normalize-space()='Vehicles'])[1]")
	WebElement vehiclesTab;

	@FindBy(xpath = "(//span[normalize-space()='Vehicle Inventory'])[1]")
	WebElement vehicleInventoryTab;

	@FindBy(xpath = "//a[normalize-space()= 'Add Vehicle Inventory']")
	WebElement addvehicleInventory;

	@FindBy(xpath = "//*[normalize-space()= 'Add Vehicle']")
	WebElement addNewvehicleBtn;

	@FindBy(xpath = "//*[normalize-space()= 'Add New Vehicle']")
	WebElement addNewvehicleLbl;

	@FindBy(xpath = "//select[@name='affiliate_id']")
	WebElement selectCompanyName;

	@FindBy(xpath = "//input[@type='text' and contains(@placeholder,'2016')]")
	WebElement selectYearMakeModel;

	@FindBy(xpath = "//input[@type='text' and contains(@placeholder,'2016')]//following::ul/li")
	WebElement selectYearMakeModelDrpListValue;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement plateNumber;

	@FindBy(xpath = "//select[@name='state_id']")
	WebElement stateID;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement vinNumber;

	@FindBy(xpath = "//span[@class='MuiIconButton-label']")
	WebElement calendar;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton']//span)[1]")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchVehicleInventory;

	@FindBy(xpath = "//input[@id='file-upload-front']")
	WebElement frontImageUpload;

	@FindBy(xpath = "//input[@id='file-upload-back']")
	WebElement backImageUpload;

	@FindBy(xpath = "//input[@id='file-upload-right']")
	WebElement sideImageUpload;

	@FindBy(xpath = "//input[@id='file-upload-reg']")
	WebElement registrationImageUpload;

	public DEV_TC_923_VerifyNewVehicleRegistrationInDispatchSite_Main(WebDriver driver) {
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

	public Boolean visibilityOfVehicleTabPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(vehiclesTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfADDNewVehiclePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage") && addNewvehicleBtn.isDisplayed()) {
				action = new Actions(driver);
				action.moveToElement(addNewvehicleBtn).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyFillingAllDetailsInAddNewVehicle(Boolean visibilityStatus) {
		try {
			if (addNewvehicleLbl.isDisplayed()) {
				action = new Actions(driver);
				Select select = new Select(selectCompanyName);
				String companyName = prop.getProperty("companyName");
				String[] splitCompanyName = companyName.split(" | ");

				if (environmentCode.equalsIgnoreCase("dev"))
					select.selectByVisibleText(splitCompanyName[0]);
				else if (environmentCode.equalsIgnoreCase("uat"))
					select.selectByVisibleText(splitCompanyName[2]);
				else
					select.selectByVisibleText(splitCompanyName[4]);

				objTestBase.defaultWaitTime(2000);
				action.moveToElement(selectYearMakeModel).clickAndHold().sendKeys(prop.getProperty("make")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(selectYearMakeModelDrpListValue).click().build().perform();
				objTestBase.defaultWaitTime(2000);

				currYear = GetCurrentDateTime.getCurrentYear(currYear);
				tempVal = prop.getProperty("plateNumber").replace("YYYY", currYear); // CAYYYYQA65848
				action.moveToElement(plateNumber).click().sendKeys(tempVal).build().perform();
				objTestBase.defaultWaitTime(500);

				select = new Select(stateID);
				select.selectByVisibleText(prop.getProperty("stateId"));
				objTestBase.defaultWaitTime(2000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				

				action.moveToElement(vinNumber).click().sendKeys(prop.getProperty("vinNumber")).build().perform();
				objTestBase.defaultWaitTime(1000);

				js.executeScript("window.scrollBy(0,400)", "");

				enterDate();
				objTestBase.defaultWaitTime(2000);
				

				utillLogger.info("DEV_TC_923 - Docker UserName = " + " - " + System.getProperty("user.name"));
				if (System.getProperty("user.name").equalsIgnoreCase("circleci")) // Docker Env. User Name
				{
					frontImageUpload.sendKeys(dockervehicleImagesPath + "sedan_frontView.jpg");
					objTestBase.defaultWaitTime(15000);
					backImageUpload.sendKeys(dockervehicleImagesPath + "sedan_backView.jpg");
					objTestBase.defaultWaitTime(15000);
					sideImageUpload.sendKeys(dockervehicleImagesPath + "sedan_sideView.jpg");
					objTestBase.defaultWaitTime(15000);
					registrationImageUpload.sendKeys(dockervehicleImagesPath + "sedan_Registration.jpg");
					objTestBase.defaultWaitTime(15000);
				} else {
					frontImageUpload.sendKeys(localvehicleImagesPath + "sedan_frontView.jpg");
					objTestBase.defaultWaitTime(15000);
					backImageUpload.sendKeys(localvehicleImagesPath + "sedan_backView.jpg");
					objTestBase.defaultWaitTime(15000);
					sideImageUpload.sendKeys(localvehicleImagesPath + "sedan_sideView.jpg");
					objTestBase.defaultWaitTime(15000);
					registrationImageUpload.sendKeys(localvehicleImagesPath + "sedan_Registration.jpg");
					objTestBase.defaultWaitTime(15000);
				}

				
				objTestBase.defaultWaitTime(15000);

				saveBtn.click();
				objTestBase.defaultWaitTime(15000);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

				if (displayStatus.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
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

	public Boolean verifyManageMasterVehicleInventoryPage(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(1000);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage")) {
				action.moveToElement(searchVehicleInventory).click().sendKeys(prop.getProperty("make")).build()
						.perform();
				objTestBase.defaultWaitTime(1000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
