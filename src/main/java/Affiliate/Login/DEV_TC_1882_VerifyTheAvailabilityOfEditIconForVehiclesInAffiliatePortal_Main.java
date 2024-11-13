package Affiliate.Login;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1882_VerifyTheAvailabilityOfEditIconForVehiclesInAffiliatePortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "(//i[@title='Edit Vehicle'])[1]")
	WebElement editBtn;

	@FindBy(xpath = "(//span[normalize-space()='Vehicles'])[1]")
	WebElement vehicleTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchInput;

	TestBase objTestBase;

	public DEV_TC_1882_VerifyTheAvailabilityOfEditIconForVehiclesInAffiliatePortal_Main(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objTestBase = new TestBase();
	}

	public void eMailInput() {
		action = new Actions(driver);
		eMailInput.sendKeys(prop.getProperty("affiliatEMail"));
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void passwordInput() {
		action = new Actions(driver);
		passwordInput.sendKeys(prop.getProperty("affiliatePwd"));
	}

	public void eyeIconClick() {
		action = new Actions(driver);
		action.moveToElement(eyeIcon).click().build().perform();
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		if (signInBtn.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickSigninButton() {
		signInBtn.click();
	}

	public void clickOnVehicleTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(vehicleTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterSearchInput() {
		try {
			action = new Actions(driver);
			searchInput.sendKeys(prop.getProperty("plateNumber"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfEditBtn(Boolean visibilityStatus) {
		try {
			if (editBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
			return visibilityStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnEditTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(editBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfEditVehiclePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("vehicle"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			return visibilityStatus;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}
}
