package Dispatch.Vehicles;

import common.TestBase;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_739_VerifyDeleteVehicleRecordUnderActionsInMasterVehicleInventory_Main extends TestBase {
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

	@FindBy(xpath = "(//span[normalize-space()='Vehicles'])[1]")
	WebElement vehiclesTab;

	@FindBy(xpath = "(//span[normalize-space()='Vehicle Inventory'])[1]")
	WebElement vehicleInventoryTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchVehicleInventory;

	@FindBy(xpath = "//i[@title='Delete Vehicle']")
	WebElement deletebutton;

	@FindBy(xpath = "//h1[normalize-space()='Delete Vehicle Inventory']")
	WebElement DeleteVehicleInventorytext;

	@FindBy(xpath = "//h1[normalize-space()='Delete Vehicle Inventory']")
	WebElement DeleteVehicleInventory;

	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement noBtn;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchvehicleSearch;

	@FindBy(xpath = "//td[@class='react-bs-table-no-data']")
	WebElement noDataDispaytxt;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "(//*[normalize-space()='There is no data to display'])[1]")
	WebElement dispatchnewvehicleDeleteConfMsg;

	public DEV_TC_739_VerifyDeleteVehicleRecordUnderActionsInMasterVehicleInventory_Main(WebDriver driver) {
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
//			Boolean visibilityStatus = false;
//			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
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

	public Boolean visibilityOfvehicleInventoryTabPage(Boolean visibilityStatus) {
		try {
			vehicleInventoryTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("vehicle-inventory"))
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
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage")) {
				action.moveToElement(searchVehicleInventory).click().sendKeys(prop.getProperty("make")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickondeletebutton() {
		try {
			deletebutton.click();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean VisibilityofDeleteVehicleInventorypopup(Boolean visibilityStatus) {
		try {
			if (DeleteVehicleInventorytext.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickNoButton() {
		try {
			noBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean VisibilityofDeleteVehicleInventorypopup1(Boolean visibilityStatus) {
		try {
			if (DeleteVehicleInventorytext.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickYesButton() {
		try {
			yesBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean dispatchDeletionOfnewvehicle(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchvehicleSearch).click().build().perform();
			action.moveToElement(dispatchvehicleSearch).click().sendKeys(prop.getProperty("make")).build().perform();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(noDataDispaytxt));

			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}