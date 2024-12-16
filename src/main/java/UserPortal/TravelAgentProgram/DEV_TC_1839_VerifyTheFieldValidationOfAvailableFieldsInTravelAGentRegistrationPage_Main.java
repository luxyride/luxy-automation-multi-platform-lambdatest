package UserPortal.TravelAgentProgram;

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

public class DEV_TC_1839_VerifyTheFieldValidationOfAvailableFieldsInTravelAGentRegistrationPage_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;

	@FindBy(xpath = "//div[normalize-space()='Travel Agent Program'][1]")
	WebElement travelAgentBtn;

	@FindBy(xpath = "(//a[normalize-space()='Travel Agent Program'])[2]")
	WebElement travelAgentBtn_Simulator;

	@FindBy(xpath = "(//a[contains(@aria-label,'Join the LUXY Travel Agent Program')])[1]")
	WebElement travelAgentSignup;

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

	@FindBy(xpath = "//input[@id='website']")
	WebElement workAddress;

	@FindBy(xpath = "//label[@for='isPartner']")
	WebElement termsConditionsChckbx;

	@FindBy(xpath = "//button[@aria-label='Create']")
	WebElement signupCreateBtn;

	@FindBy(xpath = "//p[normalize-space()='Company Name is required']")
	WebElement errorMessage;

	public DEV_TC_1839_VerifyTheFieldValidationOfAvailableFieldsInTravelAGentRegistrationPage_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfTaTransport(Boolean visibilityStatus) {
		try {
			if (travelAgentBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfTaTransportSimulatorView(Boolean visibilityStatus) {
		try {
			if (travelAgentBtn_Simulator.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnTA() {
		try {
			action = new Actions(driver);
			action.moveToElement(travelAgentBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnTA_Siumlator() {
		try {
			action = new Actions(driver);
			action.moveToElement(travelAgentBtn_Simulator).click().build().perform();
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

	public Boolean verifyVisibilityOfTaRegistrationForm(Boolean visibilityStatus) {
		try {
			if (companyName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnEnrollTaBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(travelAgentSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Boolean verifyTaPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("travel"))
				if (travelAgentSignup.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public Boolean verifyTheAvailabilityOfTextFieldsInTravelAgentForm(Boolean visibilityStatus) {
		try {
			if (companyName.isDisplayed() && fName.isDisplayed() && lName.isDisplayed() && workAddress.isDisplayed()
					&& eMailInput.isDisplayed() && phoneInput.isDisplayed())
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupCreateBtn);
			action.moveToElement(signupCreateBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyerrorMessagesUnderTextFields(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", errorMessage);
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
