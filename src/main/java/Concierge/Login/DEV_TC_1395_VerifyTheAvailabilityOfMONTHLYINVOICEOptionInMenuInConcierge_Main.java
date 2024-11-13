package Concierge.Login;

import common.TestBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1395_VerifyTheAvailabilityOfMONTHLYINVOICEOptionInMenuInConcierge_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[text()='Monthly Invoice'])[1]")
	WebElement monthlyInvoice;

	@FindBy(xpath = "(//*[text()='Monthly Invoice'])[1]")
	WebElement monthlyInvoiceHeading;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement search;

	@FindBy(xpath = "//th[@title='Status']")
	WebElement statusColumnHeader;

	@FindBy(xpath = "//th[@title='Trip ID']")
	WebElement tripIDColumnHeader;

	@FindBy(xpath = "//th[@title='Pickup Date & Time']")
	WebElement pickupDateTimeColumnHeader;

	@FindBy(xpath = "//th[@title='Pickup']")
	WebElement pickupColumnHeader;

	@FindBy(xpath = "//th[@title='Drop off']")
	WebElement dropOffColumnHeader;

	@FindBy(xpath = "//th[@title='Passenger Name']")
	WebElement passengerNameColumnHeader;

	@FindBy(xpath = "//th[@title='Transaction Amount']")
	WebElement transactionAmountColumnHeader;

	@FindBy(xpath = "//th[@title='Transaction Type']")
	WebElement transactionTypeColumnHeader;

	@FindBy(xpath = "//label[text()='From']//following-sibling::select")
	WebElement selectAMonthDropdown;;

	@FindBy(xpath = "//button[@type='submit']")
	List<WebElement> downloadOption;

	@FindBy(xpath = "(//*[text()='There is no data to display'])[1]")
	List<WebElement> noDataDisplayMsgText;

	TestBase objTestBase;

	public DEV_TC_1395_VerifyTheAvailabilityOfMONTHLYINVOICEOptionInMenuInConcierge_Main(WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
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
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninUser(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(signinUser));

			if (displayStatus.isDisplayed()) {
				expected = signinUser.getText();
				if (expected.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyMonthlyInvoicePageNavigaton(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
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

	public Boolean verifyPageContents(Boolean visibilityStatus) {
		try {
			if (monthlyInvoice.isDisplayed() && monthlyInvoiceHeading.isDisplayed() && search.isDisplayed()
					&& statusColumnHeader.isDisplayed() && tripIDColumnHeader.isDisplayed()
					&& pickupDateTimeColumnHeader.isDisplayed() && pickupColumnHeader.isDisplayed()
					&& dropOffColumnHeader.isDisplayed() && passengerNameColumnHeader.isDisplayed()
					&& transactionAmountColumnHeader.isDisplayed() && transactionTypeColumnHeader.isDisplayed()
					&& selectAMonthDropdown.isDisplayed())
				visibilityStatus = true;
			else if (noDataDisplayMsgText.size() != 0)
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
