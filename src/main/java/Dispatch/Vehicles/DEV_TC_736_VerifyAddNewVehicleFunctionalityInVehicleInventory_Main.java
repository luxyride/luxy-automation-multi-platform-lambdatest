package Dispatch.Vehicles;

import common.GetCurrentDateTime;
import common.TestBase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_736_VerifyAddNewVehicleFunctionalityInVehicleInventory_Main extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
	TestBase objTestBase;
	String currDDMMYYYY;
	String currYear;

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

	@FindBy(xpath = "//*[normalize-space()= 'Add New Vehicle']")
	WebElement addNewvehicleLbl;

	@FindBy(xpath = "//select[@name='service_class_id']")
	WebElement selectSeviceClass;

	@FindBy(xpath = "//select[@name='vehicle_type_id']")
	WebElement selectVehicleTypeID;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'MAKE')]//following-sibling::input")
	WebElement makeInputField;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'MODEL')]//following-sibling::input")
	WebElement modelInputField;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'COLOR')]//following-sibling::input")
	WebElement colorInputField;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'YEAR')]//following-sibling::div/div/div/div[contains(normalize-space(),'Select')]")
	WebElement enterYear;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchVehicleInventory;

	public DEV_TC_736_VerifyAddNewVehicleFunctionalityInVehicleInventory_Main(WebDriver driver) {
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

	public void clickonAddVehicleInventory() {
		try {
			addvehicleInventory.click();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfADDvehicleInventoryTabPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("vehicle-inventory") && addNewvehicleLbl.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyFillingAllDetailsInAddNewVehicleInventory(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			Select select = new Select(selectSeviceClass);
			select.selectByVisibleText(prop.getProperty("selectSeviceType"));
			objTestBase.defaultWaitTime(2000);

			select = new Select(selectVehicleTypeID);
			select.selectByVisibleText(prop.getProperty("vehicleTypeID"));
			objTestBase.defaultWaitTime(2000);

			currDDMMYYYY = GetCurrentDateTime.getCurrentDate(currDDMMYYYY);
			objTestBase.defaultWaitTime(1000);
			makeInputField.sendKeys(prop.getProperty("make"));
			objTestBase.defaultWaitTime(1000);

			modelInputField.sendKeys(prop.getProperty("modelName"));
			objTestBase.defaultWaitTime(1000);

			colorInputField.sendKeys(prop.getProperty("colorName"));
			objTestBase.defaultWaitTime(1000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			

			currYear = GetCurrentDateTime.getCurrentYear(currYear);
			action.moveToElement(enterYear).click().sendKeys(currYear).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);

			submitBtn.click();
			objTestBase.defaultWaitTime(3000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
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
		}
		return visibilityStatus;
	}
}
