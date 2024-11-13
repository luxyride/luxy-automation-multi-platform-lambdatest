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

public class DEV_TC_1862_VerifyTheAvailabilityOfOptInPinVerificationForSecurityOptionUncheckedWhileNewCorporateRegistrationInUserPortal_Main
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

	@FindBy(xpath = "//label[@for='isOpt']")
	WebElement optInOPtion;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement fName;


	public DEV_TC_1862_VerifyTheAvailabilityOfOptInPinVerificationForSecurityOptionUncheckedWhileNewCorporateRegistrationInUserPortal_Main(
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

	public Boolean verifyVisibilityOfOptInOptioinCorporateRegistrationForm(Boolean visibilityStatus) {
		try {
			if (optInOPtion.isDisplayed())
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
			action.moveToElement(corporateSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	

}
