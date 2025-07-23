package Dispatch.Login;

import java.util.List;
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

public class DEV_TC_1133_VerifyTheFunctionalityOfDownloadButtonInMonthlyInvoiceInDispatch_Main extends TestBase {

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

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[text()='Monthly Invoice'])[1]")
	WebElement monthlyInvoice;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "//select[@name='corporate_id']")
	WebElement selectCorporateID;

	@FindBy(xpath = "//label[text()='From']//following-sibling::select")
	WebElement selectAMonthDropdown;

	@FindBy(xpath = "//button[@type='submit']")
	List<WebElement> downloadOption;

	@FindBy(xpath = "(//*[text()='There is no data to display'])[1]")
	List<WebElement> noDataDisplayMsgText;

	TestBase objTestBase;

	public DEV_TC_1133_VerifyTheFunctionalityOfDownloadButtonInMonthlyInvoiceInDispatch_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickEyeIcon() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninButton(Boolean visibilityStatus) {
		try {
			if (signInBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSignInButton() {
		try {
			signInBtn.click();
			// Validate Dispatch 2fa Authentication:
//			Boolean visibilityStatus = false;
//			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
		}
	}

	public Boolean visibilityOfsigninUser(Boolean visibilityStatus) {
		try {
			expected = signinUser.getText();
			if (expected.toLowerCase().contains("welcome")) {
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyMonthlyInvoicePageNavigaton(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(newBookingTab).click().build().perform();
			defaultWaitTime(5000);

			for (int i = 1; i <= 10; i++) {
				action.sendKeys(Keys.DOWN).build().perform();
				defaultWaitTime(200);
			}

			action.moveToElement(monthlyInvoice).click().build().perform();
			defaultWaitTime(5000);
			expected = driver.getCurrentUrl();
			if (expected.contains("trip_invoice"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyDownloadOptionEnabled(Boolean visibilityStatus) {
		try {
			defaultWaitTime(2000);
			Select select = new Select(selectCorporateID);
			select.selectByVisibleText("QATESTAUTOMATION");
			defaultWaitTime(3000);

			select = new Select(selectAMonthDropdown);
			select.selectByIndex(5);
			defaultWaitTime(3000);

			if (downloadOption.size() != 0) {
				if (downloadOption.get(0).isEnabled())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else if (noDataDisplayMsgText.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
