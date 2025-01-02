package UserPortal.DriversAndPartners;

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

public class DEV_TC_1840_VerifyTheRegistrationOfAffiliate_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;

	@FindBy(xpath = "//div[normalize-space()='Driver & Partners']")
	WebElement affiliateBtn;

	@FindBy(xpath = "(//a[contains(@aria-label,'Sign Up with LUXY™ today')])[1]")
	WebElement affiliateSignup;

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
	WebElement website;

	@FindBy(xpath = "//input[@placeholder='Enter Business Address']")
	WebElement workAddress;

	@FindBy(xpath = "//label[@for='isPartner']")
	WebElement termsConditionsChckbx;

	@FindBy(xpath = "//label[contains(@for,'terms')]")
	WebElement privacyPolicy;

	@FindBy(xpath = "//button[@aria-label='Create']")
	WebElement signupCreateBtn;

	@FindBy(xpath = "//p[normalize-space()='Company Name is required']")
	WebElement errorMessage;

	@FindBy(xpath = "//p[@class='font-normal text-[16px] leading-[25.6px]']")
	WebElement successMsg;

	public DEV_TC_1840_VerifyTheRegistrationOfAffiliate_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfAffiliateTransport(Boolean visibilityStatus) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliateBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (affiliateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnAffiliate() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliateBtn);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(affiliateBtn).click().build().perform();
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

	public Boolean verifyVisibilityOfAffiliateRegistrationForm(Boolean visibilityStatus) {
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

	public void clickOnEnrollAffiliateBtn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliateSignup);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(affiliateSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyAffiliatePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("affiliate"))
				js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliateSignup);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (affiliateSignup.isDisplayed())
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
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", companyName);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (companyName.isDisplayed() && privacyPolicy.isDisplayed() && fName.isDisplayed() && lName.isDisplayed()
					&& website.isDisplayed() && eMailInput.isDisplayed() && phoneInput.isDisplayed()
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
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(signupCreateBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyerrorMessagesUnderTextFields(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", errorMessage);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (errorMessage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enterAllDetails() throws Exception {
		try {
			action = new Actions(driver);
			for (int i = 1; i <= 3; i++) {
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
			}

			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);

			companyName.sendKeys(prop.getProperty("conciergeCName") + "_" + currDateTime);
			website.sendKeys(prop.getProperty("websiteInput"));

			workAddress.sendKeys(prop.getProperty("fromAddress"));
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
			fName.sendKeys(prop.getProperty("conciergeFName"));
			lName.sendKeys(prop.getProperty("conciergeLName"));

			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("conciergeMail") + currDateTime + prop.getProperty("eMailDomain");

			action.sendKeys(Keys.TAB).build().perform();
			eMailInput.sendKeys(eMail);

			phoneInput.sendKeys(prop.getProperty("phoneNumber"));
			termsConditionsChckbx.click();
			privacyPolicy.click();
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
