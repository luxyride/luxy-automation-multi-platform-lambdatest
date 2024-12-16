package UserPortal.CorporateTransport;

import java.util.Iterator;
import java.util.Set;
import common.TestBase;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1838_VerifyTheFieldValidationOfAvailableFieldsInCorporateRegistrationPage_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;

	@FindBy(xpath = "//div[normalize-space()='Corporate Transport'][1]")
	WebElement corporateBtn;

	@FindBy(xpath = "//a[normalize-space()='Corporate']")
	WebElement corporate;

	@FindBy(xpath = "(//a[contains(@aria-label,'Try LUXY for Corporate Transport')])[1]")
	WebElement corporateSignup;

	@FindBy(xpath = "//input[@id='companyName']")
	WebElement companyName;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement fName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lName;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement phoneInput;

	@FindBy(xpath = "//input[@placeholder='Enter Bussiness Address']")
	WebElement workAddress;

	@FindBy(xpath = "//label[@for='isPartner']")
	WebElement termsConditionsChckbx;

	@FindBy(xpath = "//button[@aria-label='Create']")
	WebElement signupCreateBtn;

	@FindBy(xpath = "//p[normalize-space()='Company Name is required']")
	WebElement errorMessage;

	public DEV_TC_1838_VerifyTheFieldValidationOfAvailableFieldsInCorporateRegistrationPage_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfCorporateTransport(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", corporateBtn);
			js.executeScript("window.scrollBy(0,200)", "");
			if (corporateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnCorporate() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", corporateBtn);
			js.executeScript("window.scrollBy(0,200)", "");
			action.moveToElement(corporateBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean switchToNewTab(Boolean visibilityStatus, String parentWindow) {
		try {
			defaultWaitTime(10000);
			Set<String> listOfWindows = driver.getWindowHandles();
			Iterator<String> windowsIterator = listOfWindows.iterator();
			while (windowsIterator.hasNext()) {
				String child_window = windowsIterator.next();
				if (!parentWindow.equals(child_window)) {
					driver.switchTo().window(child_window);
					visibilityStatus = true;
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyCorporatePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("corporate"))
				js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", corporateSignup);
			js.executeScript("window.scrollBy(0,200)", "");
			if (corporateSignup.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfCorporateRegistrationForm(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", companyName);
			js.executeScript("window.scrollBy(0,200)", "");
			if (companyName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnEnrollCorporateBtn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", corporateSignup);
			js.executeScript("window.scrollBy(0,200)", "");
			action.moveToElement(corporateSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Boolean verifyTheAvailabilityOfTextFieldsInCorporateForm(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", companyName);
			js.executeScript("window.scrollBy(0,200)", "");
			if (companyName.isDisplayed() && fName.isDisplayed() && lName.isDisplayed() && workAddress.isDisplayed()
					&& eMailInput.isDisplayed() && phoneInput.isDisplayed() && termsConditionsChckbx.isDisplayed()
					&& signupCreateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnCreateButton() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupCreateBtn);
			js.executeScript("window.scrollBy(0,200)", "");
			action.moveToElement(signupCreateBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyerrorMessagesUnderTextFields(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", errorMessage);
			js.executeScript("window.scrollBy(0,200)", "");

			if (errorMessage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

}
