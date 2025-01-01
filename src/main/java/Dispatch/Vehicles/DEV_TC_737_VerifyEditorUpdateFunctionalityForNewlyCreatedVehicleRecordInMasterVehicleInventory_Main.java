package Dispatch.Vehicles;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.TestBase;

public class DEV_TC_737_VerifyEditorUpdateFunctionalityForNewlyCreatedVehicleRecordInMasterVehicleInventory_Main
		extends TestBase {

	Actions action;
	String expected;
	WebDriver driver;
	TestBase objTestBase;
	HashMap<String, String> vehicleDataBeforeEdit;
	HashMap<String, String> vehicleDataAfterEdit;

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

	@FindBy(xpath = "//*[@title='Edit Vehicle']")
	WebElement editVehicleInventory;

	@FindBy(xpath = "//input[@type='text' and @value='Luxy QA Automation']")
	WebElement modelName;

	@FindBy(xpath = "//input[@type='text' and @value='Metallic White']")
	WebElement colorName;

	@FindBy(xpath = "//select[@name='vehicle_type_id']")
	WebElement vehicleType;

	@FindBy(xpath = "//*[normalize-space()='Edit Vehicle']")
	WebElement editVehicleHeader;

	@FindBy(xpath = "//select[@name='vehicle_type_id']")
	WebElement editVehicleTypeID;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'MODEL')]//following-sibling::input")
	WebElement editmodelInputField;

	@FindBy(xpath = "//label[@for='exampleFormControlInput1' and contains(normalize-space(),'COLOR')]//following-sibling::input")
	WebElement editcolorInputField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	public DEV_TC_737_VerifyEditorUpdateFunctionalityForNewlyCreatedVehicleRecordInMasterVehicleInventory_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();

			vehicleDataBeforeEdit = new HashMap<String, String>();
			vehicleDataAfterEdit = new HashMap<String, String>();
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
				objTestBase.defaultWaitTime(1000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(3000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVehicleDetailsBeforeUpdate(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(editVehicleInventory).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("edit")) {
				vehicleDataBeforeEdit.put("model", modelName.getAttribute("value").toString());
				vehicleDataBeforeEdit.put("color", colorName.getAttribute("value").toString());
				Select select = new Select(vehicleType);
				WebElement ele = select.getFirstSelectedOption();
				vehicleDataBeforeEdit.put("vehicleType", ele.getText());
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean updateVehicleInventoryDetails(Boolean visibilityStatus) {
		try {
			if (editVehicleHeader.isDisplayed()) {
				action = new Actions(driver);
				Select select = new Select(editVehicleTypeID);
				select.selectByVisibleText(prop.getProperty("editvehicleTypeID"));
				objTestBase.defaultWaitTime(2000);

				editmodelInputField.click();
				objTestBase.defaultWaitTime(500);
				editmodelInputField.sendKeys(Keys.CONTROL + "A");
				editmodelInputField.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(500);
				editmodelInputField.sendKeys(prop.getProperty("editmodelName"));
				objTestBase.defaultWaitTime(1000);

				editcolorInputField.click();
				objTestBase.defaultWaitTime(500);
				editcolorInputField.sendKeys(Keys.CONTROL + "A");
				editcolorInputField.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(500);
				editcolorInputField.sendKeys(prop.getProperty("editcolorName"));
				objTestBase.defaultWaitTime(1000);

				vehicleDataAfterEdit.put("editmodel", editmodelInputField.getAttribute("value").toString());
				vehicleDataAfterEdit.put("editcolor", editcolorInputField.getAttribute("value").toString());
				select = new Select(vehicleType);
				WebElement ele = select.getFirstSelectedOption();
				vehicleDataAfterEdit.put("editvehicleType", ele.getText());

				JavascriptExecutor js = (JavascriptExecutor) driver;
				

				submitBtn.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

				if (displayStatus.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVehicleDetailsComparisonBeforeAfterUpdate(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(1000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage")) {
				action.moveToElement(searchVehicleInventory).click().sendKeys(prop.getProperty("make")).build()
						.perform();
				objTestBase.defaultWaitTime(1000);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(3000);
				if (!vehicleDataBeforeEdit.equals(vehicleDataAfterEdit))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

}
