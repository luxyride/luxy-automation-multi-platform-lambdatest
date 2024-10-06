package Dispatch.NewBooking;

import common.TestBase;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1895_VerifyAvailabilityAndFunctionalityOfPaginationForVehicleInventoryInDispatchPortal_Main extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
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

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "(//span[normalize-space()='Vehicles'])[1]")
	WebElement vehiclesTab;

	@FindBy(xpath = "(//span[normalize-space()='Vehicle Inventory'])[1]")
	WebElement vehicleInventoryTab;

	@FindBy(xpath = "//a[normalize-space()= 'Add Vehicle Inventory']")
	WebElement addvehicleInventory;

	@FindBy(xpath = "(//i[@title='Delete Vehicle'])[1]")
	WebElement DeleteBtn;

	@FindBy(xpath = "(//button[normalize-space()='Yes'])")
	WebElement YesBtn;

	@FindBy(xpath = "//a[@class='btn-outline-orange pull-right p-2']")
	WebElement addNewvehicleLbl;
	
	@FindBy(xpath = "//ul[@class='react-bootstrap-table-page-btns-ul pagination']")
	WebElement paginationNumbers;
	
	@FindBy(xpath = "//a[normalize-space()='2']")
	WebElement page2;
	
	@FindBy(xpath = "//button[@id='pageDropDown']")
	WebElement pageDropDown;
	
	@FindBy(xpath = "//a[normalize-space()='50']")
	WebElement records50;
	

	@FindBy(xpath = "//select[@name='service_class_id']")
	WebElement selectSeviceClass;

	@FindBy(xpath = "//select[@name='vehicle_type_id']")
	WebElement selectVehicleTypeID;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchVehicle;

	@FindBy(xpath = "//*[text()='There is no data to display']")
	WebElement noVehicleDisplayText;

	public DEV_TC_1895_VerifyAvailabilityAndFunctionalityOfPaginationForVehicleInventoryInDispatchPortal_Main(WebDriver driver) {
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
			vehiclesTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("vehicle"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfManagevehicleTabPage(Boolean visibilityStatus) {
		try {
			vehicleInventoryTab.click();
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

	public void clickonVehicleTab() {
		try {
			vehiclesTab.click();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfManagevehiclePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage") && addNewvehicleLbl.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfPageNavigation(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage") && paginationNumbers.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyPageNaviagtion(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			page2.click();
			defaultWaitTime(2000);
			if (expected.toLowerCase().contains("manage"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyPageRecords(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			pageDropDown.click();
			defaultWaitTime(1000);
			records50.click();
			defaultWaitTime(2000);
			if (expected.toLowerCase().contains("manage"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyPageNavigationWhenRecordsChangesTo50(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage")&& paginationNumbers.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}