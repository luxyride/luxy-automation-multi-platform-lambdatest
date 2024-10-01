package Dispatch.Vehicles;

import java.awt.Robot;
import java.util.List;

import common.GetCurrentDateTime;
import common.TestBase;
import java.awt.Toolkit;
import java.time.Duration;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.datatransfer.Clipboard;
import org.openqa.selenium.support.FindBy;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_920_VerifyModificationorUploadingOfNewImagesForExistingVehicleRecordFromDispatch_Main
		extends TestBase {
	Actions action;
	String expected;
	WebDriver driver;
	TestBase objTestBase;
	StringSelection stringSelection;
	Clipboard clipboard;
	String fileName;
	String currYear;
	String tempVal;

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

	@FindBy(xpath = "//*[contains(text(),'Manage Vehicle')]")
	WebElement manageVehicleLbl;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchVehicle;

	@FindBy(xpath = "//i[@title='Edit Vehicle']")
	WebElement editBtn;

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

	@FindBy(xpath = "(//input[@type='file'])[1]")
	WebElement editfrontImageUpload;

	@FindBy(xpath = "(//input[@type='file'])[2]")
	WebElement editbackImageUpload;

	@FindBy(xpath = "(//input[@type='file'])[3]")
	WebElement editsideImageUpload;

	@FindBy(xpath = "(//input[@type='file'])[4]")
	WebElement editregistrationImageUpload;

	public DEV_TC_920_VerifyModificationorUploadingOfNewImagesForExistingVehicleRecordFromDispatch_Main(
			WebDriver driver) {
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
			if (expected.toLowerCase().contains("manage") && manageVehicleLbl.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfExistingVehicle(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(searchVehicle).click().sendKeys(prop.getProperty("make")).build().perform();
			objTestBase.defaultWaitTime(3000);
			if (editBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyEditingAllDetailsInAddNewVehicle(Boolean visibilityStatus) {
		try {
			if (manageVehicleLbl.isDisplayed()) {
				action = new Actions(driver);
				action.moveToElement(editBtn).click().build().perform();
				objTestBase.defaultWaitTime(8000);

				plateNumber.click();
				plateNumber.sendKeys(Keys.CONTROL + "A");
				plateNumber.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(1000);
				currYear = GetCurrentDateTime.getCurrentYear(currYear);
				tempVal = prop.getProperty("editplateNumber").replace("YYYY", currYear); // EDITCAYYYYQA65848
				action.moveToElement(plateNumber).click().sendKeys(tempVal).build().perform();
				objTestBase.defaultWaitTime(3000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)", "");

				vinNumber.click();
				vinNumber.sendKeys(Keys.CONTROL + "A");
				vinNumber.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(500);
				action.moveToElement(vinNumber).click().sendKeys(prop.getProperty("editvinNumber")).build().perform();
				objTestBase.defaultWaitTime(1000);

				js.executeScript("window.scrollBy(0,500)", "");
				objTestBase.defaultWaitTime(2000);

				utillLogger.info("DEV_TC_920 - Docker UserName = " + " - " + System.getProperty("user.name"));
				if (System.getProperty("user.name").equalsIgnoreCase("circleci")) // Docker Env. User Name
				{
					editfrontImageUpload.sendKeys(dockervehicleImagesPath + "suvxl_frontView.jpg");
					objTestBase.defaultWaitTime(15000);
					editbackImageUpload.sendKeys(dockervehicleImagesPath + "suvxl_backView.jpg");
					objTestBase.defaultWaitTime(15000);
					editsideImageUpload.sendKeys(dockervehicleImagesPath + "suvxl_sideView.jpg");
					objTestBase.defaultWaitTime(15000);
					editregistrationImageUpload.sendKeys(dockervehicleImagesPath + "suvxl_Registration.jpg");
					objTestBase.defaultWaitTime(15000);
				} else {
					editfrontImageUpload.sendKeys(localvehicleImagesPath + "suvxl_frontView.jpg");
					objTestBase.defaultWaitTime(15000);
					editbackImageUpload.sendKeys(localvehicleImagesPath + "suvxl_backView.jpg");
					objTestBase.defaultWaitTime(15000);
					editsideImageUpload.sendKeys(localvehicleImagesPath + "suvxl_sideView.jpg");
					objTestBase.defaultWaitTime(15000);
					editregistrationImageUpload.sendKeys(localvehicleImagesPath + "suvxl_Registration.jpg");
					objTestBase.defaultWaitTime(15000);
				}
				js.executeScript("window.scrollBy(0,100)", "");
				objTestBase.defaultWaitTime(15000);
				visibilityStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfEDITConfirmationMsg(Boolean visibilityStatus) {
		try {
			saveBtn.click();
			objTestBase.defaultWaitTime(5000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

	public Boolean verifyManageMasterVehicleInventoryPage(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(10000);
			action = new Actions(driver);
			action.moveToElement(searchVehicle).click().sendKeys(prop.getProperty("make")).build().perform();
			objTestBase.defaultWaitTime(5000);
			if (editBtn.isDisplayed()) {
				action.moveToElement(editBtn).click().build().perform();
				objTestBase.defaultWaitTime(6000);
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,800)", "");
				objTestBase.defaultWaitTime(1000);
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
