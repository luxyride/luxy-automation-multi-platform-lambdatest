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

public class DEV_TC_1841_VerifyTheRegistrationOfCorporate_Main
		extends TestBase {

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
	
	@FindBy(xpath = "//p[@class='font-normal text-[16px] leading-[25.6px]']")
	WebElement successMsg;


	public DEV_TC_1841_VerifyTheRegistrationOfCorporate_Main(
			WebDriver driver) {
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
			js.executeScript("window.scrollBy(0,-100)", "");
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
			js.executeScript("window.scrollBy(0,-100)", "");
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
			js.executeScript("window.scrollBy(0,-100)", "");
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
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(corporateSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void enterAllDetails() throws Exception {
		try {
			action = new Actions(driver);
			for (int i = 1; i <= 3; i++) {
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
			}

			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);

			companyName.sendKeys(prop.getProperty("conciergeCName") + "_" + currDateTime);
			workAddress.sendKeys(prop.getProperty("fromAddress"));
			objTestBase.defaultWaitTime(4000);
			action.sendKeys(Keys.DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			fName.sendKeys(prop.getProperty("conciergeFName"));
			lName.sendKeys(prop.getProperty("conciergeLName"));

			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("conciergeMail") + currDateTime + prop.getProperty("eMailDomain");

			action.sendKeys(Keys.TAB).build().perform();
			eMailInput.sendKeys(eMail);

			phoneInput.sendKeys(prop.getProperty("phoneNumber"));
			termsConditionsChckbx.click();
			objTestBase.defaultWaitTime(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnSignupCreateBtn() throws Exception {
		try {
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupCreateBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			signupCreateBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfSignupConfirmationMsg(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", successMsg);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (successMsg.isDisplayed()) {
				expected = successMsg.getText();
				if (expected.toLowerCase().contains("success")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfSignupCreateBtn(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", signupCreateBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (signupCreateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
